import java.util.Scanner;
public class HelpDeskSimulator{ //Keeps the log

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        HelpDesk help = new HelpDesk();
        System.out.print("Enter the number of minutes to simulate: ");
        int toDo = scanner.nextInt();
        scanner.nextLine(); //Consume newline
        
        boolean moreStudents = true;
        boolean firstArrival = true;
        while (moreStudents){
            System.out.print("Enter student info: ");
            String info  = scanner.nextLine();
            String[] parts = info.split(" ");
            int start = Integer.parseInt(parts[0]);
            String name = parts[1];
            int course = Integer.parseInt(parts[2]); 
            int workload = Integer.parseInt(parts[3]); 
            help.addStudent(start, name, course, workload); //Needs to add the students at the start time given
            if(firstArrival){
                help.setCurrentStudent(help.nextStudent()); //gets the first student to start the process
                firstArrival = false;
            }
            System.out.println("Current Student: " + help.getCurrentStudent().getName());
            moreStudents = moreStudents();
        }

        for(int i = 0; i <= toDo; i++){
            help.step();
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

