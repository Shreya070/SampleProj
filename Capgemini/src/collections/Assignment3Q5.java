package collections;

import java.util.Hashtable;
import java.util.Map;

class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee emp = (Employee) obj;
		return (emp.name.equals(this.name));
		
	}
	public int hashcode() {
		return this.id;
	}
	

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

public class Assignment3Q5 {
    public static void main(String[] args) {
        Employee e1 = new Employee("shreya",1);
        Employee e2 = new Employee("rajat",2);
        Employee e3 = new Employee("rashi",4);

        Hashtable<Employee,String> hs = new Hashtable<>();
        hs.put(e1,"test");
        hs.put(e2,"test2");
        hs.put(e3,"test3");
        System.out.println(hs);
    	for (Map.Entry<Employee,String> emp : hs.entrySet())  
            System.out.println( "Value = " + emp.getValue());
      
    }
}