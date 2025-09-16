public class doublylinkedlists {

    public static void main(String[] args) {
        
      Doubly dl= new Doubly();

      dl.insert_at_begin(0);
      dl.insert_at_end(1);
      dl.insert_at_end(2);
      dl.insert_at_begin(9 );


      dl.traverse();
      dl.backward_traversal();
}
}

class Node{
    int data;
    Node next;
    Node prev;

    Node(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}
class Doubly{
    Node head=null;
    Node tail=null;

    public void traverse() {
        Node current = head;
        if (current == null) {
            System.out.println("List is empty");
            return;
        }
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public void backward_traversal(){
        if(head==null){
            System.out.println("linked list is empty");
            return;
        }
        Node temp=tail;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.prev;
        }
    }

    public void insert_at_begin(int data){
        Node new_node=new Node(data);
        if(head==null){
            head=new_node;
            tail=new_node;
        }else{
        new_node.next=head;
        head.prev=new_node;
        head=new_node;
        }
    }

  

    public void insert_at_end(int data){
        Node new_node= new Node(data);
        if(head==null){
            head=new_node;
            tail=new_node;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=new_node;
        new_node.prev=temp;
        tail=new_node;

    }

}
