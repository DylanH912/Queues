public class HelpDesk{
    private int time; // current simulation time in minutes
    private LLNode<Student> currentStudent; // the student currently being helped
    private String status; // current status of the help desk (e.g., "IDLE" or "Helping [Student Name] from [Course Number]")
    private ArrayBoundedQueue<Student> queue100 = new ArrayBoundedQueue<Student>();
    private ArrayBoundedQueue<Student> queue200 = new ArrayBoundedQueue<Student>();
    private ArrayBoundedQueue<Student> queue300 = new ArrayBoundedQueue<Student>(); //I have overthought everything and now understand
    private ArrayBoundedQueue<Student> queue400 = new ArrayBoundedQueue<Student>(); //this may work better idk tho, might revert later 

/*• Advance the simulation one minute.
• This method handles the time-stepped simulation logic.
• Checks if the current student being helped is finished.
• If no student is being helped, retrieves the next student from the highest-priority non-empty
queue.
*/
public void step(){
    this.time++;


    if(currentStudent == null){
        this.status = "IDLE";
    }
    else{
        this.status = "Helping " + currentStudent.toString();
    }
    

}

/*• Add an arriving student with the indicated name, course number, and workload (minutes
needed).
• Determines the appropriate priority queue based on course number (course/100 * 100).
• Attempts to enqueue the student in their priority level's queue.
• If that queue is full, attempts escalation to higher-numbered course queues.
• If all escalation attempts fail, logs that the student was turned away.
*/

public void addStudent(String name, int course, int workload){
    Student newStudent = new Student(name, course, workload);

        if (course <= 199 &&  !queue100.isFull()){
            queue100.enqueue(newStudent);
            System.out.println("Level-1 " + newStudent.getName());
        } else if (course <= 299 && !queue200.isFull()){
            queue200.enqueue(newStudent);
            System.out.println("Level-2 " + newStudent.getName());
        } else if (course <= 399 && !queue300.isFull()){
            queue300.enqueue(newStudent);
            System.out.println("Level-3 " + newStudent.getName());
        } else if (course <= 499 && !queue400.isFull()){
            queue400.enqueue(newStudent);
            System.out.println("Level-4 " + newStudent.getName());
        } else {
            System.out.print("****Temp Turned Away " + newStudent.getName() + "*****");
        }
}

/*Get the current simulation time in minutes.
  Returns the current value of the simulation clock.
*/
public int getTime(){

return this.time;
}

/*Return the status of the simulation at the current time.
  Example: "Time 2, Helping Jack from CSC110" or "Time 0, IDLE"

public String toString(){
    name = currentStudent.getName()
    course = currentStudent.getCourse()

    if (status == "IDLE"){
        System.out.printf("Time %d, IDLE", this.time);
    }
    else{
        System.out.printf("Time %d, Helping %s from %s", this.time, name, course);
    }
}
*/
/*Return the entire HelpDesk session log from beginning to end.
 Contains a chronological record of all queuing, helping, and completion events.
*/
public String getLog(){

    return " " + this.time + ", " + this.status;
}

} // end of HelpDesk class

  

