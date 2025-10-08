public class LinkedQueue<T> implements QueueInterface<T> {
    LLNode<T> rear;
    LLNode<T> front;
    Integer numElements;

    public LinkedQueue(){
        rear=null;
        front=null;
        numElements=0;
    }
    public boolean isFull(){
        return false;
    }
    public boolean isEmpty(){
        return numElements==0;
    }
    public void enqueue(T item){
        LLNode<T> a = new LLNode<T>(item);
        if(numElements==0){
            front = a;
            rear=a;
            numElements++;
            return;
        }
        rear.setNext(a);
        rear=a;
        numElements++;
    }
    public T dequeue(){
        if(numElements==0){
            rear=null;
            front=null;
            return null;
        }
        LLNode<T> temp = front;
        front = front.getNext();
        numElements--;
        return temp.getInfo();
    }
    public Integer length(){
        return numElements;
    }

}
