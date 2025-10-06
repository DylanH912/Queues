public class HelpDesk{
    private int time; // current simulation time in minutes
    private LLNode<Student> currentStudent; // the student currently being helped
    private String status; // current status of the help desk (e.g., "IDLE" or "Helping [Student Name] from [Course Number]")
    private ArrayBlockingQueue<Student>[] queues = new ArrayBlockingQueue[3];

    public HelpDesk(){
        for (int i = 0; i < queues.length; i++) {
            queues[i] = new ArrayBlockingQueue<Student>(3);
        }
    }
/*• Advance the simulation one minute.
• This method handles the time-stepped simulation logic.
• Checks if the current student being helped is finished.
• If no student is being helped, retrieves the next student from the highest-priority non-empty
queue.
*/
public void step(){
    this.time++;


    if(currentStudent = null){
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

        if (course <= 199 &&  !queue[0].isFull()){
            queue[0].enqueue(newStudent)
        } else if (course <= 299 && !queue[1].isFull()){
            queue[1].enqueue(newStudent)
        } else if (course <= 399 && !queue[2].isFull()){
            queue[2].enqueue(newStudent)
        } else if (course <= 499 && !queue[3].isFull()){
            queue[3].enqueue(newStudent)
        } else {
            System.out.print("****Temp Turned Away " + newStudent.getName() + "*****")
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
*/
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

/*Return the entire HelpDesk session log from beginning to end.
 Contains a chronological record of all queuing, helping, and completion events.
*/
public String getLog(){

    return " " + this.time + ", " + this.status;
}

} // end of HelpDesk class

  
