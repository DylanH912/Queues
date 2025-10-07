import java.util.Scanner;
public class HelpDeskSimulator{ //Keeps the log

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        HelpDesk help = new HelpDesk();
        
        boolean moreStudents = true;
        while (moreStudents){
            System.out.print("Enter student info: ");
            String info  = scanner.nextLine();
            String[] parts = info.split(" ");
            String name = parts[1];
            int course = Integer.parseInt(parts[2]); 
            int workload = Integer.parseInt(parts[3]); 
            moreStudents = moreStudents();
            help.addStudent(name, course, workload); //Needs to add the students at the start time given
        }    
    }

    //------ No-Constraints-Constructor--------
    public HelpDeskSimulator(){

    }



    public static boolean moreStudents(){
        String input = "";
        System.out.print("Are there more students to add? (y/n):  ");
        input = scanner.nextLine();
        if (input.equals("y")){
            return true;
        }
        else{
            return false;
        }
    }
}
