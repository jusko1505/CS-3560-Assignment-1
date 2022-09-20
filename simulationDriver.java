import java.util.List;
import java.util.Random;

import javax.xml.stream.events.StartDocument;
public class simulationDriver {
    static Random random = new Random();

    public Question createQuestion(){
        int randomInteger = random.nextInt();
        Question ques;
        if(randomInteger%2==0){
            ques = new trueFalseQuestion();
            ques.generateAnswers();
        }
        else{
            ques = new multipleChoiceQuestion();
            ques.generateAnswers();
        }
        return ques;
    }

    public List<Students> createStudentsAndAnswerQuestions(Question q){
        
        int numberStudents = random.nextInt(50);
        List ll = new ArrayList(50);
        for(int i = 0; i < numberStudents; i++){
            Student student = new Student();
            student.answerQuestion(q);
            ll.add(student);
        }
    }


    public static void main(String[] args) {
        
    }
    
   

   
}

