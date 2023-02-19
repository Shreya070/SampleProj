package oopsassignment;
abstract class Persistence {
    abstract public String persist();
}
class FilePersistence extends Persistence{
    @Override
    public String persist() {
        return "File is persisted";
    }
}
class DatabasePersistence extends Persistence{
    @Override
    public String persist() {
        return "Data is persisted";
    }
}
public class Assignment2Q6 {

    public static void main(String[] args) {

       
    	Persistence i = new FilePersistence();
    	Persistence j = new DatabasePersistence();
        System.out.println(i.persist());
        System.out.println(j.persist());

    }
}