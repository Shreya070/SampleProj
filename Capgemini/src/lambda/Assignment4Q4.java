package lambda;
import java.util.ArrayList;

public class Assignment4Q4 {
    public static ArrayList<String> removeOddLength(ArrayList<String> employeeList){
    	employeeList.removeIf(n -> n.length()%2 != 0);
    	return employeeList;
    	
    }
    public static void main(String[] args) { 
    	ArrayList<String> arr = new ArrayList<>();
    	arr.add("shreya");
    	arr.add("rashi");
    	arr.add("rajesh");
    	arr.add("palak");
    	arr.add("rajat");
    	arr.add("shikha");
    	
    	ArrayList<String> arr1 = removeOddLength(arr);
    	for(String str : arr1)
    		System.out.println(str);
    }
}