public class stack {
    public static void main(String[] args) {
        Stack2 s=new Stack2(5);
        boolean flag=s.isEmpty();
        System.out.println(flag);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.print_data();
        System.out.println("Peek");
        System.out.println(s.peek());
        System.out.println("after pop op:");
        
        while(!s.isEmpty()){
            int top=s.pop();
            System.out.println(top);
        }

        s.recursive(6);

        
       
        
    }
    
}
class Stack2{
    int size;
    int stackArray[];
    int top;

    public Stack2(int size){
        this.size=size;
        this.top=-1;
        this.stackArray=new int[size];
    }
    public void push(int data){
        if(this.isFull()){
            System.out.println("Stackoverflow");
            return;
        }

        this.top++;
        this.stackArray[this.top]=data;

    }
    public boolean isFull(){
        return this.top==(this.size-1);
    }

    public void print_data(){
        for(int i:this.stackArray){
           System.out.println(i);
        }
    }
    public boolean isEmpty(){
        return top==-1;
    }

    public int pop(){
        if(this.isEmpty()){
            System.out.println("Underflow");
        }
        return this.stackArray[this.top--];


    }

    public int peek(){
        if(this.isEmpty()){
            System.out.println("Underflow");
            return -1;
        }
        return this.stackArray[this.top];

    }

    public int recursive(int n){
        if(n==0){
            System.out.println(0);
            return 0;
        }
        System.out.println(n);
        return recursive(n-1);
    }
}
