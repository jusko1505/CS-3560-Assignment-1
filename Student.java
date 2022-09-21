import java.util.Random;
import java.util.UUID;;

public class Student {
    private String name;
    private boolean[] choices;
    private Random random = new Random();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = UUID.randomUUID().toString(); 
    }
    public int scanQuestion(Question question) {
        return question.getNumberOfOptions();
    }
    public void answerQuestion(multipleChoiceQuestion q){
        this.choices = new boolean[scanQuestion(q)];
        for(int i = 0; i<choices.length; i++){
            choices[i] = random.nextBoolean();
        }
    }
    public void answerQuestion(trueFalseQuestion q){
        this.choices = new boolean[scanQuestion(q)];
        boolean bool = random.nextBoolean();
        choices[0] = bool;
        choices[1] = !bool;
    }
   
    public boolean[] getChoices(){
        return choices;
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