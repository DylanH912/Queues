public class HelpDeskSimulator{ //Keeps the log
    private static int step;

    private static ArrayBoundedQueue<Student> levelOne = new ArrayBoundedQueue<Student>;
    private static ArrayBoundedQueue<Student> levelTwo = new ArrayBoundedQueue<Student>;
    private static ArrayBoundedQueue<Student> levelThree = new ArrayBoundedQueue<Student>;
    private static ArrayBoundedQueue<Student> levelFour = new ArrayBoundedQueue<Student>;

    private static ArrayBoundedQueue<Student>[] waitingArea = [levelOne, levelTwo, levelThree, levelFour];


}