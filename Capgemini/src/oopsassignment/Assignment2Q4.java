package oopsassignment;
abstract class Question{

    public void isHard(){
        System.out.println("it is hard...");
    }
    public void isEasy() {
        System.out.println("it is easy...");
    }
   
    public abstract void skip();
}

class levelOfDifficulty extends Question{

    @Override
    public void skip() {
        System.out.println("question is skipped...");
    }
}
public class Assignment2Q4{
    public static void main(String[] args) {
        Question an = new levelOfDifficulty( );
        an.isEasy();
        an.isHard();
        an.skip();

        //Question q = new Question();
    }
}  