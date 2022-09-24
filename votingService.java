import java.util.*;

// grades questions
public class votingService {
    private Question question;
    private int[] numberCorrectAndIncorrect = new int[2];

    //tracks how many A's, B's, etc are chosen 
    private int[] numberOfEachAnswerChosen;

    //maps a student with their answer sheet
    static private Map<Student, boolean[]> studentTracker = new HashMap<Student, boolean[]>();

    private void setNumberCorrectAndIncorrect(int[] numberCorrectAndIncorrect) {
        this.numberCorrectAndIncorrect = numberCorrectAndIncorrect;
    }
    private void setNumberOfEachAnswerChosen(int[] numberOfEachAnswerChosen) {
        this.numberOfEachAnswerChosen = numberOfEachAnswerChosen;
    }

    private int[] getNumberOfEachAnswerChosen() {
        return numberOfEachAnswerChosen;
    }
    
    private int[] getNumberCorrectAndIncorrect() {
        return numberCorrectAndIncorrect;
    }

    /* an answer is counted as correct if all of a student's choices
     * matches the answer sheet: credit/ no credit 
     */
    public void gradeStudent(Student student){
        boolean[] studentChoices = student.getChoices();
        boolean[] answers = getQuestion().getAnswers();

        // first time a student submits an answer 
        if(!studentTracker.containsKey((student))){
            studentTracker.put(student, studentChoices);
            
            if(Arrays.equals(studentChoices, answers)){
                numberCorrectAndIncorrect[0]++;
            }
            else{
                numberCorrectAndIncorrect[1]++;
            }
            for(int i = 0; i < answers.length; i++){
                if(studentChoices[i]){
                    numberOfEachAnswerChosen[i]++;
                }
            }
        }
        //a student submits an answer more than once
        else{
            // remove the student's old responses
            boolean[] oldStudentChoices = studentTracker.get(student);
            if(Arrays.equals(studentChoices, answers)){
                numberCorrectAndIncorrect[0]--;
            }
            else{
                numberCorrectAndIncorrect[1]--;
            }
            for(int i = 0; i < answers.length; i++){
                if(oldStudentChoices[i]){
                    numberOfEachAnswerChosen[i]--;
                }
            }
            //update the student's new response in the hashmap
            studentTracker.put(student, studentChoices);
            //add the student's new response into the hashmap
            if(Arrays.equals(studentChoices, answers)){
                numberCorrectAndIncorrect[0]++;
            }
            else{
                numberCorrectAndIncorrect[1]++;
            }
            for(int i = 0; i < answers.length; i++){
                if(studentChoices[i]){
                    numberOfEachAnswerChosen[i]++;
                }
            }
        }
        setNumberCorrectAndIncorrect(numberCorrectAndIncorrect);
        setNumberOfEachAnswerChosen(numberOfEachAnswerChosen);
    }
    public void outputStatistics(){
        int[] correctIncorrect = getNumberCorrectAndIncorrect();
        int[] numberofEachChosen = getNumberOfEachAnswerChosen();

        System.out.println("The number of each answer choicen:");
        for(int i = 0; i < numberofEachChosen.length; i++){
            System.out.println(i +": " + numberofEachChosen[i]);
        }
        System.out.println("Number correct: "+ correctIncorrect[0]);
        System.out.println("Number incorrect: " + correctIncorrect[1]);
    }
    
    public void clearQuestion(){
        studentTracker.clear();
    }

    public Question getQuestion() {
        return question;
    }
    public void setQuestion(Question question) {
        this.question = question;
        numberOfEachAnswerChosen(question);
    }
    private void numberOfEachAnswerChosen(Question question){
        this.numberOfEachAnswerChosen = new int[question.getNumberOfOptions()];
    }
    
}
