import java.util.NoSuchElementException;

public class ExpandableArrayStack implements Stack{
    private Object[] s;
    private Object[] newS;
    private int size = 0;
    private int cap = 16; 

    public int capacity(){
        return s.length; 
    }

    public void push(Object item){
        if(isFull()){
            doubleSize(); 
            throw new NoSuchElementException("This stack is full!"); 
        }
        else if((cap>16) && (size < 0.25*cap)) {
            halfSize(); 
        }
        s[size++] =item; 
    }

    public Object pop(){
        var head = peek(); 
        s[--size]=null; 
        return head; 
    }
    public Object peek(){
        if(isEmpty()){
            throw new NoSuchElementException("This stack is empty!");
        }
        return s[size-1]; 
    } 
    public int size(){
        return size; 
    }

    public void doubleSize(){
        // currently look at s. 1. make a brand new array whose size is twice s.link 2. copy all 
        //s one at a time with a for loopsystem.array copy move them into the new array
        // make array point to the new array
        cap = 2 * cap; 
        for(int i = 0; i < s.length; i++){
            System.arraycopy(s, 0, newS, 0,cap);  
        }
    }

    public void halfSize(){
        cap = cap/2; 
        for(int i = 0; i <s.length; i++){
            System.arraycopy(s, 0, newS, 0, cap); 
        }
    }
    
    public boolean isFull() {
        return size == s.length;
    }

    @Override
    public boolean isEmpty(){
        return size == 0; 
    }
}