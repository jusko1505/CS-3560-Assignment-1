public class votingService {
    // grades questions
    //keeps track of # correct and incorrect?
    //String holds uuid, and List holds correct and incorrect answers?
    private Question question;
    private int[] numberCorrectAndIncorrect;
    private int[] numberOfEachAnswerChosen;
    private Set<Student> studentTracker = new HashSet<Student>();

    public int[] getNumberOfEachAnswerChosen() {
        return numberOfEachAnswerChosen;
    }
    public void setNumberOfEachAnswerChosen(int[] numberOfEachAnswerChosen) {
        this.numberOfEachAnswerChosen = numberOfEachAnswerChosen;
    }
    public int[] getNumberCorrectAndIncorrect() {
        return numberCorrectAndIncorrect;
    }
    public void setNumberCorrectAndIncorrect(int[] numberCorrectAndIncorrect) {
        this.numberCorrectAndIncorrect = numberCorrectAndIncorrect;
    }
  
    

    public void gradeStudent(student student){
        Question question = getQuestion();
        boolean[] studentChoices = student.getChoices();
        boolean[] answers = getQuestion().getAnswers();
        int[] numberCorrectAndIncorrect = new int[2];
        int[] numberOfEachAnswerChosen = new int[question.getNumberOfOptions()];

        if(studentTracker.add(student)){
            if(studentChoices.equals(answers)){
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
        else{
            
        }
    }
    public void outputStatistics(){
        
    }
    public void clearQuestion(){
        studentTracker.clear();
    }

    public Question getQuestion() {
        return question;
    }
    public void setQuestion(Question question) {
        this.question = question;
    }
    
}
