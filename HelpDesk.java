public class HelpDesk{
    private int time; // current simulation time in minutes
    private Student currentStudent; // the student currently being helped
    private String status; // current status of the help desk (e.g., "IDLE" or "Helping [Student Name] from [Course Number]")
    private String[] log = new String[1000]; //Holds every line in the log
    private int logSpot = 0;
    private LinkedGlassQueue<Student> queue100 = new LinkedGlassQueue<Student>();
    private LinkedGlassQueue<Student> queue200 = new LinkedGlassQueue<Student>();
    private LinkedGlassQueue<Student> queue300 = new LinkedGlassQueue<Student>(); 
    private LinkedGlassQueue<Student> queue400 = new LinkedGlassQueue<Student>(); //this may work better idk tho, might revert later 
    private LinkedGlassQueue<Student> overflow = new LinkedGlassQueue<Student>();
                                                                                        //This works great the code was missing increments when enqueue items
                                                                 
/*• Advance the simulation one minute.
• This method handles the time-stepped simulation logic.
• Checks if the current student being helped is finished.
• If no student is being helped, retrieves the next student from the highest-priority non-empty
queue.
*/
    private boolean idle = true;
    public void step(){

        if(!idle){ //Skip all code for helping current students for steps with no student
            
            if (currentStudent != null && currentStudent.getWorkload() == 0){ //Remove Student if no more work is to be done
            //update log
            addLog("\n Time " + this.time + ", Finished helping " + currentStudent.getName() + " from CSC" + currentStudent.getCourse());
            System.out.println(currentStudent.getName() + " is done -------------"); //--------------------------------------------- temp
            currentStudent = null;
            //System.out.println("New Student: " + currentStudent.getName()); //--------------------------------------------- temp
        }
    }

    if (currentStudent != null && currentStudent.getWorkload() > 0) { //Remove 1 Workload from student
            idle = false;
            currentStudent.subtractWorkload(1);
            System.out.printf("Time %d, Helping %s from CSC%d %n", time, currentStudent.getName(), currentStudent.getCourse());
            for(int i = 0; i < queue100.length(); i++){
                if(queue100.peekAt(i).getStart() == time){
                    addLog("\n Time " + this.time + ", Queued " + queue100.peekAt(i).getName() + " from CSC" + queue100.peekAt(i).getCourse());
                }
                else{
                    break;
                }
            }
            for(int i = 0; i < queue200.length(); i++){
                if(queue200.peekAt(i).getStart() == time){
                    addLog("\n Time " + this.time + ", Queued " + queue200.peekAt(i).getName() + " from CSC" + queue200.peekAt(i).getCourse());
                }
                else{
                    break;
                }
            }
            for(int i = 0; i < queue300.length(); i++){
                if(queue300.peekAt(i).getStart() == time){
                    addLog("\n Time " + this.time + ", Queued " + queue300.peekAt(i).getName() + " from CSC" + queue300.peekAt(i).getCourse());
                }
                else{
                    break;
                }
            }
            for(int i = 0; i < queue400.length(); i++){
                if(queue400.peekAt(i).getStart() == time){
                    addLog("\n Time " + this.time + ", Queued " + queue400.peekAt(i).getName() + " from CSC" + queue400.peekAt(i).getCourse());
                }
                else{
                    break;
                }
            }
            for(int i = 0; i < overflow.length(); i++){
                if(overflow.peekFront().getStart() == time){
                    addLog("\n Time " + this.time + ", Turned Away " + overflow.peekFront().getName() + " from CSC" + overflow.peekFront().getCourse());
                    overflow.dequeue();
                }
                else{
                    break;
                }
            }
            this.time++;
            return;
        } 
        
        
        //----- Check if IDLE -------
        boolean isStudentInQueue = checkForStudent();

        if (isStudentInQueue == false) //Nothing in queues
        {
            //System.out.println("In HelpDesk > Step() No Students in Queue"); //--------------------------------------------------- temp
            status = "IDLE";
            //update log with IDLE
            System.out.println("Time " + time + ", IDLE");  //Output IDLE
            this.time++;
            return;
        }

        //Find new currentStudent                   //Dont have to worry about not finding one ----------------------------------- temp
        if(currentStudent == null){
            //System.out.println("In HelpDesk > Step() Finding next Student"); //---------------------------------------------------- temp
            currentStudent = nextStudent();
            addLog("\n Time " + this.time + ", Started helping " + currentStudent.getName() + " from CSC" + currentStudent.getCourse());
            step();
            //update log Started helping studentName
            
            
        } 

    }

    public boolean checkForStudent(){
        //System.out.println(queue100.length() + " " + queue200.length() + " " + queue300.length() + " " + queue400.length()); //Temp ------------------------------
        if(queue100.length() > 0 && queue100.peekFront().getStart() <= time){
            return true;
        }
        if (queue200.length() > 0 && queue200.peekFront().getStart() <= time){
            return true;
        } 
        if (queue300.length() > 0  && queue300.peekFront().getStart() <= time){
            return true;
        }
        if (queue400.length() > 0  && queue400.peekFront().getStart() <= time){
            return true;
        }
        return false;
    }

    public Student nextStudent(){
        Student tempStudent = null;

        if(queue100.length() > 0 && queue100.peekFront().getStart() <= time){
            tempStudent = queue100.dequeue();
        } else if(queue200.length() > 0 && queue200.peekFront().getStart() <= time){
            tempStudent = queue200.dequeue();
        } else if(queue300.length() > 0 && queue300.peekFront().getStart() <= time){
            tempStudent = queue300.dequeue();
        } else if(queue400.length() > 0 && queue400.peekFront().getStart() <= time){
            tempStudent = queue400.dequeue();
        } else{
            System.out.println("*** ERROR SOMETHING WENT WRONG IN NEXTSTUDENT() *****"); //TEMP --------------------------------
        }

        return tempStudent;
    }

/*• Add an arriving student with the indicated name, course number, and workload (minutes
needed).
• Determines the appropriate priority queue based on course number (course/100 * 100).
• Attempts to enqueue the student in their priority level's queue.
• If that queue is full, attempts escalation to higher-numbered course queues.
• If all escalation attempts fail, logs that the student was turned away.
*/

    public void addStudent(int start, String name, int course, int workload){
        Student newStudent = new Student(start, name, course, workload);

            if (course <= 199 &&  queue100.length() < 4){               
                queue100.enqueue(newStudent);
                //System.out.println("Level-1 " + newStudent.getName() + "  " + (queue100.length() + 1));
            } else if (course <= 299 && queue200.length() < 4){
                queue200.enqueue(newStudent);
                //System.out.println("Level-2 " + newStudent.getName());
            } else if (course <= 399 && queue300.length() < 4){
                queue300.enqueue(newStudent);
                //System.out.println("Level-3 " + newStudent.getName());
            } else if (course <= 499 && queue400.length() < 4){
                queue400.enqueue(newStudent);
                //System.out.println("Level-4 " + newStudent.getName());
            } else {
                overflow.enqueue(newStudent);
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
        String name = currentStudent.getName();
        int course = currentStudent.getCourse();

        if (status == "IDLE"){
            return String.format("Time %d, IDLE", this.time);
        }
        else{
            return String.format("Time %d, Helping %s from %s", this.time, name, course);
        }
    
    }

    public void addLog(String newLog){
        log[logSpot] = newLog;
        logSpot++;
        return;
    }

    public void setCurrentStudent(Student currentStudent){
        this.currentStudent = currentStudent;
    }

    public Student getCurrentStudent(){
        return currentStudent;
    }

    /*Return the entire HelpDesk session log from beginning to end.
    Contains a chronological record of all queuing, helping, and completion events.
    */
    public String[] getLog(){
        return log;
    }

} // end of HelpDesk class




