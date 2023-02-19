package collections;
import java.util.HashSet;
import java.util.LinkedHashSet;


public class Assignment3Q2 {
    public static void main(String[] args) {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(10);
        linkedHashSet.add(30);
        linkedHashSet.add(5);
        linkedHashSet.add(89);
        linkedHashSet.add(1);


        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(10);
        hashSet.add(30);
        hashSet.add(5);
        hashSet.add(89);
        hashSet.add(1);

        ordered(linkedHashSet);
        unordered(hashSet);
    }
    public static LinkedHashSet<Integer> ordered(LinkedHashSet<Integer> linkedHashSet){
        System.out.println("printing linkedHashSet");
        for(Object i:linkedHashSet){
            System.out.println(i);
        }
        return linkedHashSet;
    }
    public static HashSet<Integer> unordered(HashSet<Integer> hashSet){
        System.out.println("printing HashSet");
        for(Object i:hashSet){
            System.out.println(i);
        }
        return  hashSet;
    }

}