import java.util.ArrayList;
import java.util.List;
public class WordFinder{
    private static class Node{
        char character;
        boolean last;
        Node left;
        Node middle;
        Node right;
        Node(char character){
            this.character = character;
        }
        void add(String word){
            word = word.trim();
            if(word == ""){
                throw new IllegalArgumentException();
            }
            var beginning = word.charAt(0);
            String rest = word.substring(1);
            if(beginning == character){
                if (rest.isEmpty()) {
                    last = true;
                    return;
                }
                if(middle == null){
                    middle = new Node(rest.charAt(0));
                }
                middle.add(rest);
            }
            else if(beginning > character){
                if(right == null){
                    right = new Node(beginning);
                }
                right.add(word);
            }
            else if(beginning < character){
                if(left == null){
                    left = new Node(beginning);
                }
                left.add(word);
            }
        }
        Node nodeFor(String word){//return the node of the last char of word
            if(word.isEmpty()){
                return this;
            }
            var beginning = word.charAt(0);
            var rest = word.substring(1);
            System.out.println(word);
            System.out.println(character);
            if(beginning == character){
                if (rest.isEmpty()){
                    return this;
                }
                if(middle != null){
                    return middle.nodeFor(rest);
                }
                return null;
            }
            else if(beginning < character){
                if(left != null){
                    return left.nodeFor(word);
                }
                return null;
            }
            else{
                if(right != null){
                    return right.nodeFor(word);
                }
                return null;
            }
        }
        void accumulateWords(String prefix, List<String> words){
            if(left !=null){
                left.accumulateWords(prefix, words);
            }
            if(last){
                words.add(prefix + character);
            }
            if(middle != null){
                middle.accumulateWords(prefix + character, words);
            }
            if(right != null){
                right.accumulateWords(prefix, words);
            }
        }
    }
    private Node root = new Node('k');
    public void add(String word){
        word = word.trim();
        if(word.isEmpty()){
            throw new IllegalArgumentException();
        }
        root.add(word);
    }
    public boolean contains(String word){
        word = word.trim();
        var node = root.nodeFor(word);
        return node != null && node.last;
    }
    public List<String> suggestions(String prefix){
        prefix = prefix.trim();
        if(prefix.isEmpty()){
            throw new IllegalArgumentException();
        }
        var words = new ArrayList<String>();
        var node = root.nodeFor(prefix);
        if(node != null){
            if(node.last){
                words.add(prefix);
            }
            else if(node.middle != null){
                node.middle.accumulateWords(prefix, words);
            }
        }
        return words;
    }
    public List<String> allWords(){
        var words = new ArrayList<String>();
        root.accumulateWords("", words);
        return words;
    }
}
