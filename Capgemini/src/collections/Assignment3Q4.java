package collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class DateClass {
    private int date;
    private int month;
    private int year;
    
    public DateClass(int date, int month, int year) {
		this.date = date;
		this.month = month;
		this.year = year;
	}
    
    public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	

	   @Override
	    public String toString() {
	        return "DateClass{" +
	                "date=" + date +
	                ", month=" + month +
	                ", year=" + year +
	                '}';
	    }		
}
public class Assignment3Q4 {
	

	    public String getEmployee(HashMap<DateClass, String> dob, String employeeName){
	        Set<Entry<DateClass, String>> set = dob.entrySet();
	        Iterator<Entry<DateClass, String>>  itr = set.iterator();
	        Iterator<Entry<DateClass, String>> itr2 = set.iterator();
	        int day=0;
	        int month=0;
	        int year=0;
	        while (itr.hasNext()){
	            Map.Entry<DateClass,String>  m1 = itr.next();
	            DateClass dateClass = (DateClass)m1.getKey();
	            if(m1.getValue().equals(employeeName)){

	                day= dateClass.getDate();
	                month=dateClass.getMonth();
	                year = dateClass.getYear();
	            }         
	        }

	        while (itr2.hasNext()){
	            Map.Entry<DateClass,String>  m1 =itr2.next();
	            DateClass dateClass = (DateClass)m1.getKey();
	            if( (day==dateClass.getDate() && month==dateClass.getMonth() && year!=dateClass.getYear()) && (!m1.getValue().equals(employeeName)) ){
	                return "get method fails";
	            }

	        }
	        return employeeName;
	    }

	public static void main(String[] args) {
		
        HashMap<DateClass,String> employee = new HashMap<>();

        DateClass dateClass1 = new DateClass(04,07,1995);
        DateClass dateClass2 = new DateClass(04,03,1997);
        DateClass dateClass3 = new DateClass(06,07,1996);
        DateClass dateClass4 = new DateClass(04,03,1995);
 
        employee.put(dateClass1,"Shreya");
        employee.put(dateClass2,"rashi");
        employee.put(dateClass3,"shree");
        employee.put(dateClass4,"amit");
        
        Assignment3Q4 assignment3Q4 = new Assignment3Q4();
        System.out.println(assignment3Q4.getEmployee(employee,"rashi"));



    }
}


