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
        numElements++;
        if(isEmpty()){
            front = a;
            rear=a;
            return;
        }
        rear.setNext(a);
        rear=a;
    }
    public T dequeue(){
        if(isEmpty()){
            rear=null;
            front=null;
            return null;
        }
        LLNode<T> temp = front;
        front.setNext(front.getNext());
        numElements--;
        return temp.getInfo();
    }
    public Integer length(){
        return numElements;
    }

}
