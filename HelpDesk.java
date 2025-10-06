public class HelpDesk{
    private int time; // current simulation time in minutes
    private LLNode<Student> currentStudent; // the student currently being helped
    private String status; // current status of the help desk (e.g., "IDLE" or "Helping [Student Name] from [Course Number]")
    private Student[] queue100 = new Student[3];
    private Student[] queue200 = new Student[3];
    private Student [] queue300 = new Student[3];
    private Student[] queue400 = new Student[3];

public void step(){
/*• Advance the simulation one minute.
• This method handles the time-stepped simulation logic.
• Checks if the current student being helped is finished.
• If no student is being helped, retrieves the next student from the highest-priority non-empty
queue.
*/
    if(currentStudent = null){
        this.status = "IDLE";
    }
    else{
        this.status = "Helping " + currentStudent.toString();
    }
    this.time++;

}
public void addStudent(String name, int course, int workload){
/*• Add an arriving student with the indicated name, course number, and workload (minutes
needed).
• Determines the appropriate priority queue based on course number (course/100 * 100).
• Attempts to enqueue the student in their priority level's queue.
• If that queue is full, attempts escalation to higher-numbered course queues.
• If all escalation attempts fail, logs that the student was turned away.
*/

}
public int getTime(){
/*• Get the current simulation time in minutes.
• Returns the current value of the simulation clock.
*/
return this.time;

}
public String toString(){
/*• Return the status of the simulation at the current time.
• Example: "Time 2, Helping Jack from CSC110" or "Time 0, IDLE"
*/
}
public String getLog(){
/*• Return the entire HelpDesk session log from beginning to end.
• Contains a chronological record of all queuing, helping, and completion events.
*/
    return " " + this.time + ", " + this.status;
}

} // end of HelpDesk class

  
