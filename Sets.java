import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

interface Sets{
    static <E> Set<Set<E>> powerSet(Set<E> s){ 
        var power = new HashSet<Set<E>>();
        power.add(new HashSet<>());
        for(var element : s){
            for(var members: power){
                var duplicate = Set.copyOf(power); 
                duplicate.add(element);
                members.add(duplicate); 
                power.add(members); 
            }
        }
        return power;
    }
    
    static List<Integer> multiples(Set<Integer> s, int factor){
        var multiples = new ArrayList<Integer>();
        for(int element: s){
            if(element % factor == 0){
                multiples.add(element);
            }
        }
        Collections.sort(multiples); 
        return multiples;
    }
}
