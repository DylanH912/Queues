public class ArrayBoundedQueue<T> implements QueueInterface<T> {
    private int DEFCAP =3; //hardcoding max value for now
    private T[] elements;
    private int numElements =0;
    private int front =0;
    private int rear;
    
    
    public ArrayBoundedQueue() {
        this.DEFCAP = DEFCAP;
        elements = (T[]) new Object[DEFCAP];
        rear= DEFCAP-1;
    }
    
    
    public T dequeue(){
        T temp = elements[front];
        if(front==DEFCAP-1){
            front=0;
            numElements++;
            return temp;
        }
        front++;
        numElements--;
        return temp;
    }
    public void enqueue(T item){
        if(rear==DEFCAP-1){
            rear=0;
            elements[rear]=item;
            numElements++;
            return;
        }        
        rear++;
        elements[rear]=item;
        numElements++;
        return;
    }
    public boolean isEmpty(){
        return numElements==0;
    }
    public boolean isFull(){
        return numElements==DEFCAP;
    }
    public Integer length(){
        return numElements;
    }

}
