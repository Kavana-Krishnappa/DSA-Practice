public class CircularQueue {
 
    public static void main(String[] args) {
queue q = new queue(5);
q.Enqueue(2);
q.Enqueue(3);
q.Enqueue(4);
System.out.println( "removed "+q.Dequeue());
q.Enqueue(5);
q.Enqueue(6);

q.display();

        
        }
        
    }
    

class queue{
    int max_size;
    int Circular_Array[];
    int front;
    int rear;

    public queue(int size){
        this.max_size=size;
        this.Circular_Array=new int[size];
        this.front=-1;
        this.rear=-1;
    }

    public boolean isFull(){
        if(this.front==0 && this.rear==this.max_size-1){
            return true;
        }
        return false;
    }
    
    public void Enqueue(int data){
        if(this.isFull()){
            System.out.println("Queue is Full");
            return;
        }
        if(this.front==-1){
            front=0;
        }
        this.rear=(this.rear+1)%this.max_size;
        this.Circular_Array[this.rear]=data;
    }

    public void display() {
    if (isEmpty()) {
        System.out.println("Queue is empty");
        return;
    }
    int i = front;
    while (true) {
        System.out.println(Circular_Array[i]);
        if (i == rear) break;
        i = (i + 1) % max_size;
    }
}


    public boolean isEmpty(){
        return this.front==-1;
    }

    public int Dequeue(){
        if(this.isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        int element=this.Circular_Array[this.front];
        if(this.front==this.rear){
            this.front=-1;
            this.rear=-1;
        }else{
            this.front=(this.front+1)%this.max_size;
        }
        return element;
    }


}









