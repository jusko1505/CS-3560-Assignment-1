public class votingService {
    // grades questions
    //keeps track of # correct and incorrect?
    //String holds uuid, and List holds correct and incorrect answers?
    private Question question;
    private int[] numberCorrectAndIncorrect;
    private int[] numberOfEachAnswerChosen;
    static private Map<Student, boolean[]> studentTracker = new HashMap<Student, boolean[]>();

    private void setNumberCorrectAndIncorrect(int[] numberCorrectAndIncorrect) {
        this.numberCorrectAndIncorrect = numberCorrectAndIncorrect;
    }
    private void setNumberOfEachAnswerChosen(int[] numberOfEachAnswerChosen) {
        this.numberOfEachAnswerChosen = numberOfEachAnswerChosen;
    }

    public int[] getNumberOfEachAnswerChosen() {
        return numberOfEachAnswerChosen;
    }
    
    public int[] getNumberCorrectAndIncorrect() {
        return numberCorrectAndIncorrect;
    }
   
    public void gradeStudent(student student){
        Question question = getQuestion();
        boolean[] studentChoices = student.getChoices();
        boolean[] answers = getQuestion().getAnswers();
        int[] numberCorrectAndIncorrect = new int[2];
        int[] numberOfEachAnswerChosen = new int[question.getNumberOfOptions()];

        //if !studentTracker.containsKey(student) -> studentTracker.put(Student, new List.add(studentChoices))
        if(studentTracker.put(student, studentChoices)){
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
            //revert the student's old responses
            boolean[] oldStudentChoices = studentTracker.get(student);
            if(oldStudentChoices.equals(answers)){
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
            //maybe instead of a set, studentTracker can be a HashMap<Student, boolean[]>
            //in this else statement, access at key student to retrieve the boolean[]
            //then we do the reverse of what happens in the if statement using the old boolean[]
            // so, if student choices equals answers then numbercorrectincorrect[0]--;
            // else number correct and incorrect[i]--;
            //and so on with the for loop after it -> if studentchoices[i] then numberofeach[i]--;
            //then we do the original logic(if statement) with the updated student choices[]
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
    }
    
}
