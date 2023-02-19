package oopsassignment;

class SingletonInheritanceCheck{
    public static SingletonInheritanceCheck sic = null;
    private SingletonInheritanceCheck(){
        System.out.println("Instance created");
    }
    public static SingletonInheritanceCheck getInstance(){
        if(sic ==  null){
            sic = new SingletonInheritanceCheck();
        }
        return sic;
    }
}

public class Assignment2Q1 {
    public static void main(String[] args) {
        SingletonInheritanceCheck sIC = SingletonInheritanceCheck.getInstance();
        System.out.println(sIC);
        SingletonInheritanceCheck s = SingletonInheritanceCheck.getInstance();
        System.out.println(s);
   
    }
}