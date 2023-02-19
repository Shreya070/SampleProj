package oopsassignment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Employee implements Comparable<Employee> {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
        try {
			if(salary==0)
			{
				throw new myCustomException("salary should not be zero");
			}
		} catch (myCustomException e) {
			//System.out.println("caught the exception");
			System.out.println(e.getMessage());
		}
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
    	
        return salary;
    }

    @Override
    public int compareTo(Employee e) {
        return Integer.compare(e.salary, this.salary);
    }

    @Override
    public String toString() {
        return name + " " + salary;
    }
}
@SuppressWarnings("serial")
class myCustomException extends Exception
{
	public myCustomException(String s)
	{
		super(s); 
	}
}
public class ab {
    public static void main(String[] args) {
       
			List<Employee> employees = new ArrayList<>();
			employees.add(new Employee("shreya", 9000));
			employees.add(new Employee("Jane", 6000));
			employees.add(new Employee("Jim", 3000));
			employees.add(new Employee("rashi", 4000));
			employees.add(new Employee("rajat", 0000));

			Collections.sort(employees);
			for (Employee employee : employees) {
			    System.out.println(employee);
			}
    }
}