public class Queue {
    public static void main(String[] args) {

        queue2 q=new queue2(5);
        q.Enqueue(1);
        q.Enqueue(2);
        q.Enqueue(3);
        q.Enqueue(4);
        q.Enqueue(5);
        q.Enqueue(6);

        while(!q.isEmpty()){
            int element=q.Dequeue();
            System.out.println(element);
        }
        
    }
    
}
class queue2{
    int front=-1;
    int rear=-1;
    int max_size=0;
    int queue_array[];

    public queue2(int max_size){
        this.max_size=max_size;
        this.queue_array=new int[max_size];
    }
    public boolean isFull(){
        return this.rear==(this.max_size-1);
    }
    public void Enqueue(int data){
        if(this.isFull()){
            System.out.println("Queue is Full");
            return;
        }
        if(this.front==-1){
            this.front=0;
        }
        this.rear++;
        this.queue_array[this.rear]=data;
    }
    public boolean isEmpty(){
        return this.front==-1;
    }

   public int Dequeue(){
    if(this.isEmpty()){
        System.out.println("Queue is empty");
        return -1;
    }
    int current_element=this.queue_array[this.front];
    if(this.front==this.rear){
        this.front=-1;
        this.rear=-1;
    }else{
        this.front++;
    }
    return current_element;
   }







}
