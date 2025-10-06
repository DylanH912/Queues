public class Student{                           //No clue how neccessary -SZ 
    private String  name = "";
    private int     course,
                    workload;
    
    public Student(String name, int course, int workload){
        this.name = name;
        this.course = course;
        this.workload = workload;
    }

    //========= Mutators ================
    public void setName(){
        this.name = name;
    }

    public void setCourse(){
        this.course = course;
    }

    public void setWorkload(){
        this.workload = workload;
    }

    public void subtractWorkload(int sub){
        workload -= sub;
    }

    //========= Accessors =============
    public String getName(){
        return name;
    }

    public int getCourse(){
        return course;
    }

    public int getWorkload(){
        return workload;
    }


}