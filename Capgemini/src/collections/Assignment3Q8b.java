package collections;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Assignment3Q8b {
    public static CopyOnWriteArrayList<Integer> failFast(CopyOnWriteArrayList<Integer> list){
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()){
            Integer num = (Integer)itr.next();
            System.out.println(num);

            list.add(78);
            System.out.println(num);
            
        }
   return  list;
    }
    public static void main(String args[]) {
        CopyOnWriteArrayList<Integer> list
                = new CopyOnWriteArrayList<Integer>();
        list.add(3);
        list.add(13);
        list.add(36);
        list.add(32);
        list.add(23);

        failFast(list);
        
    }
}