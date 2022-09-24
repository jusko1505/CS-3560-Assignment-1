import java.util.*;

// Pulls all the pieces together
public class simulationDriver {
    static Random random = new Random();

    public trueFalseQuestion createTrueFalseQuestion(){
        trueFalseQuestion ques = new trueFalseQuestion();
        ques.generateAnswers();
        return ques;
    }

    public multipleChoiceQuestion createMultipleChoiceQuestion(){
        multipleChoiceQuestion ques = new multipleChoiceQuestion();
        ques.generateAnswers();
        return ques;
    }

    /* 
     * Creates a random number of students between 0 and 49
     * Returns a list of Students who've already answered
     * the given question
    */
    public List<Student> createStudentsAndAnswerQuestions(Question q){
        int numberStudents = random.nextInt(50);
        System.out.println("Number of students: "+numberStudents);
        List<Student> ll = new ArrayList<Student>(numberStudents);
        for(int i = 0; i < numberStudents; i++){
            Student student = new Student();
            student.answerQuestion(q);
            ll.add(student);
        }
        return ll;
    }

    /* 
     * Main force driving the simulation
     * Calls above method to create students and their choices
     * Calls votingService to grade the students
     * Prints the results into standard output
     */
    public void simDrive(Question question){
        simulationDriver sd = new simulationDriver();
        votingService vs = new votingService();
        List<Student> listOfStudents = sd.createStudentsAndAnswerQuestions(question);
        vs.setQuestion(question);

        for(Student student: listOfStudents){
            vs.gradeStudent(student);
        }
        vs.outputStatistics();
    }

    public static void main(String[] args) {
        simulationDriver sd = new simulationDriver();
        int randomInteger = random.nextInt();
        if(randomInteger%2==0){
            trueFalseQuestion question = sd.createTrueFalseQuestion();
            sd.simDrive(question);
        }
        else{
            multipleChoiceQuestion question = sd.createMultipleChoiceQuestion();
            sd.simDrive(question);
        }
    }
}

