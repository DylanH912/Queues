public class HelpDeskSimulator{ //Keeps the log
    private int time;

    private  ArrayBoundedQueue<Student> levelOne;
    private  ArrayBoundedQueue<Student> levelTwo;
    private  ArrayBoundedQueue<Student> levelThree;
    private  ArrayBoundedQueue<Student> levelFour;

    //private ArrayBoundedQueue<Student>[] waitingArea;

    //------ No-Constraints-Constructor--------
    public HelpDeskSimulator(){
        this.time = 0;

        this.levelOne = new ArrayBoundedQueue<Student>;
        this.levelTwo = new ArrayBoundedQueue<Student>;
        this.levelThree = new ArrayBoundedQueue<Student>;
        this.levelFour = new ArrayBoundedQueue<Student>;

        //ArrayBoundedQueue<Student>[] waitingArea = [levelOne, levelTwo, levelThree, levelFour];
    }

    //-------------- addStudent ----------------
    public void addStudent(String name, int course, int workload){
        Student newStudent = new Student(name, course, workload);

        if (course <= 199 &&  levelOne.length < 3){
            levelOne.enqueue(newStudent)
        } else if (course <= 299 && levelTwo.length < 3){
            levelTwo.enqueue(newStudent)
        } else if (course <= 399 && levelThree.length < 3){
            levelThree.enqueue(newStudent)
        } else if (course <= 499 && levelFour.length < 3){
            levelFour.enqueue(newStudent)
        } else {
            System.out.print("****Temp Turned Away " + newStudent.getName() + "*****")
        }
    }

    public int getTime(){
        return this.time;
    }



}