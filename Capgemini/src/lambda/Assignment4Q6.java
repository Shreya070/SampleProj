package lambda;


import java.util.Arrays;
import java.util.List;


public class Assignment4Q6 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot");
        Assignment4Q6 assignment4Q6 = new Assignment4Q6();
        System.out.println(assignment4Q6.convertToUpperCase(list));

    }
    public List<String> convertToUpperCase(List<String> list) {

    	list.replaceAll(s->s.toUpperCase());
    	return list;
    }  
}