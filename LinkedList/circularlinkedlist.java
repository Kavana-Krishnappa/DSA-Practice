public class circularlinkedlist {
    public static void main(String[] args) {
        circular cl= new circular();

        cl.insert_at_begin(0);
        cl.insert_at_begin(1);
        cl.insert_at_begin(3);
        cl.insert_at_end(-1);
        cl.insert_at_end(-2);
        cl.insert_at_mid(5, 3);
        cl.delete_at_beginning();
        cl.delete_at_end();
        cl.delete_at_mid(2);
        //System.out.println(cl.head.next.data);
        cl.traverse();
    }
    
}
class Node {
    int data;
    Node next;

    Node() {}
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class circular{
    Node head=null;
     public void insert_at_begin(int data){
        Node new_node= new Node(data);
        if(head==null){
            head=new_node;
            head.next=head;
            return;
        }
        Node last=head;

        while(last.next!=head){
            last=last.next;
        }
        last.next=new_node;
        new_node.next=head;
        head=new_node;
     }
     public void traverse() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println(head.data);
        Node temp=head.next;
        while(temp!=head){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }

    public void insert_at_end(int data){
        Node new_node = new Node(data);
        if(head==null){
            System.out.println("Empty");
        }
        Node last=head;
        while(last.next!=head){
            last=last.next;
        }
        last.next=new_node;
        new_node.next=head;
        
    }

    public void insert_at_mid(int data,int pos ){
            Node new_node = new Node(data);
            if(head==null){
                head=new_node;
                head.next=head;
                return;
            }
            if(pos==0){
                this.insert_at_begin(data);
            }
            int count=1;
            Node current=head;

            while(count<pos && current.next!=head){
                current=current.next;
                count++;
            }
            if(current.next == head){
                this.insert_at_end(data);
            }
            new_node.next=current.next;
            current.next=new_node;
    }

    public void delete_at_beginning(){
        if(head==null){
            System.out.println("empty list");
        }
        if(head.next==head){
            head=null;
            return;
        }
        Node last=head;
        while (last.next!=head) {
            last=last.next; 
        }
        head=head.next;
        last.next=head;
    }
   public void delete_at_end(){
    if(head==null){
        System.out.println("empty list");
        return;
    }
    if(head.next==head){
        head=null;
        return;
    }
    Node prev=null;
    Node curr=head;

    while(curr.next!=head){
        prev=curr;
        curr=curr.next;
    }
    prev.next=head;
   } 

   public void delete_at_mid(int pos){
    if(head==null){
        System.out.println("empty list");
        return;
    }
    if(pos==0){
        this.delete_at_end();
    }
    Node curr=head;
    int count=1;
    Node prev=null;
    while(count<pos && curr.next!=head){
        prev=curr;
        curr=curr.next;
        count++;

    }
    if(curr.next==head){
        this.delete_at_end();;
    }
    prev.next=curr.next;
   }






}

