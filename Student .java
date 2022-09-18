import java.util.Random;
import java.util.UUID;;

public class Student {
    private String name;
    private boolean[] choices;
    private Random random = new Random();
    private UUID uuid = new UUID();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = UUID.randomUUID().toString(); 
    }
    public int scanQuestion(Question question) {
        return question.getNumberOfOptions();
    }
    public void answerQuestion(multipleChoiceQuestion mcq){
        this.choices = new boolean[scanQuestion(mcq)];
        for(int i = 0; i<choices.length; i++){
            choices[i] = random.nextBoolean();
        }
        
    }
    public void answerQuestion(trueFalseQuestion tfq){
        this.choices = new boolean[scanQuestion(tfq)];
        for(int i = 0; i<choices.length; i++){
            choices[i] = random.nextBoolean();
        }
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