import java.util.Properties;

public class Student {
    private String name;
    private int numberOfQuestions;
    private char[] answers;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }
    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public void answerQuestion(){
        this.answers = new char[numberOfQuestions];
        for(int i = 0; i<this.getNumberOfQuestions(); i++){
            answers[i] = rand
        }
    }
    
}

/* 
 * int rand = rand.randInt(10)
 * int randNumOfQuestoins = rand.randInt(6)
 * List<Student> students = new ArrayList<Students>();
 * for (int i = 0; i< rand; i++){
 * Student student = new Student();
 * student.setName(i);
 * student.setNumberOfQuestions(randNumOfQuestions);
 * 
 * 
 * }
 * 
 */