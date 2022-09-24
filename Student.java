import java.util.Random;
import java.util.UUID;;

/* A Student has a name(UUID),
   can look over a question, 
   and answer a question      */
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
   
    public void answerQuestion(Question question){
        this.choices = new boolean[scanQuestion(question)];
        /* if the question is trueFalse, 
        answers with one choice and its opposite */
        if(scanQuestion(question) == 2){
            boolean bool = random.nextBoolean();
            choices[0] = bool;
            choices[1] = !bool;
        }
        /* if the question is multiple choice, 
        true/false is generated randomly for each choice */
        else{
            for(int i = 0; i<choices.length; i++){
                choices[i] = random.nextBoolean();
            }
        }
    }   
   
    // returns the student's "answer sheet"
    public boolean[] getChoices(){
        return choices;
    }
}
