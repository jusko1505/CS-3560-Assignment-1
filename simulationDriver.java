import java.util.*;

import javax.xml.stream.events.StartDocument;
public class simulationDriver {
    static Random random = new Random();

    public Question selectTypeOfQuestion(){
        int randomInteger = random.nextInt();
        if(randomInteger%2==0){
            trueFalseQuestion ques = new trueFalseQuestion();
            ques.generateAnswers();
            return ques;
        }
        else{
           multipleChoiceQuestion ques = new multipleChoiceQuestion();
            ques.generateAnswers();
            return ques;
        }
        
    }

    public List<Student> createStudentsAndAnswerQuestions(Question q){
        
        int numberStudents = random.nextInt(50);
        System.out.println("number of students: "+numberStudents);
        List<Student> ll = new ArrayList<Student>(numberStudents);
        for(int i = 0; i < numberStudents; i++){
            Student student = new Student();
            student.answerQuestion(q);
            ll.add(student);
        }
        return ll;
    }



    public static void main(String[] args) {
        simulationDriver sd = new simulationDriver();
        votingService vs = new votingService();
        Question question = sd.selectTypeOfQuestion();
        List<Student> listOfStudents = sd.createStudentsAndAnswerQuestions(question);
        vs.setQuestion(question);

        for(Student student: listOfStudents){
            vs.gradeStudent(student);
        }
        System.out.println("List of students length: "+ listOfStudents.size());
        vs.outputStatistics();
        
    }
    
   

   
}

