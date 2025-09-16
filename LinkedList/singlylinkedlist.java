public class singlylinkedlist {
    public static void main(String[] args) {
        Singly sl = new Singly();
        sl.insert_at_begin(7);
        sl.insert_at_begin(8);
        sl.insert_at_begin(9);
        sl.insert_at_end(6);
        sl.insert_at_end(5);
        sl.insert_at_begin(11);
        sl.insert_at_mid(1,10);
        sl.delete_at_beginning();
        sl.delete_at_end();
        sl.delete_at_mid(2);
        int ans=sl.Search(7);
        System.err.println(ans);

        System.out.println("Head: " + sl.head.data);

        // Call traversal
        sl.traverse();
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

class Singly {
    Node head = null;

    public void insert_at_begin(int data) {
        Node new_node = new Node(data);

        if (head == null) {
            head = new_node;
            return;
        }
        new_node.next = head;
        head = new_node;
    }
    public void insert_at_end(int data){
        Node new_node=new Node(data);

        if(head==null){
            head=new_node;
            return;
        }
        Node current_node=head;
        while(current_node.next != null){
            current_node=current_node.next;
        }
        current_node.next=new_node;
    }

    // Traversal method
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

    public void insert_at_mid(int pos,int data){
        Node new_node= new Node(data);

        if(pos==0){
            new_node.next=head;
            head=new_node;
            return;
        }
        Node current_node=head;
        int count=0;

        while(current_node!=null && count<pos-1){
            current_node=current_node.next;
            count++;

        }
        if(current_node==null){
            System.out.println("Position out of linked list");
            return;
        }
        new_node.next=current_node.next;
        current_node.next=new_node;
    }

    public void delete_at_beginning(){
        if(head==null){
            System.out.println("No element to delete");
            return;
        }
        head=head.next;
    }
    public void delete_at_end(){
        if(head==null){
            System.out.println("No element to delete");
            return;
        }
        if(head.next==null){
            head=null;
            return;
        }
        Node current=head;
        Node prev=null;

        while(current.next!=null){
            prev=current;
            current=current.next;
        }
        prev.next=null;
    }

    public void delete_at_mid(int pos){
        if(head==null){
            System.out.println("Linked list is empty");
        }
        if(pos==0){
            head=head.next;
            return;
        }
        Node current=head;
        Node prev=null;
        int count=0;

        while(current!=null&& count<pos){
            prev=current;
            current=current.next;
            count++;
        }
        if(current==null){
            System.out.println("Position is greater");
            return;
        }
        prev.next=current.next;

    }

    public int Search(int value){
        if(head==null){
            return -1;
        }
        if(head.next==null && value==head.data){
            return 0;
        }
        Node curr=head;
        int pos=0;


        while(curr!=null){
            if(curr.data==value){
                return pos; 
            }
            curr=curr.next;
            pos++;
        }
        return -1;
    }
}
