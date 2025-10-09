public class LinkedGlassQueue<T> extends LinkedQueue<T> {
    public LinkedGlassQueue(){
        super();
    }    
    public T peekFront(){
        if(isEmpty()){
            return null;
        }
        return front.getInfo();
    }
    public T peekRear(){
        if(isEmpty()){
            return null;
        }
        return rear.getInfo();
    }

    
    public T peekAt(int i){
        LLNode<T> tempFront = front;
        for(int j = 0; j < i; j++){
            tempFront = tempFront.getNext();
        }
        return tempFront.getInfo();
    }
}
