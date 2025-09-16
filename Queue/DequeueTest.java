public class DequeueTest {
    public static void main(String[] args) {
        queue2 q = new queue2(5);

        // Insert from front
        q.insert_front(10);
        q.insert_front(20);
        q.insert_front(30);

        // Insert from rear
        q.insert_rear(40);
        q.insert_rear(50);

        q.display(); // should show 30 20 10 40 50

        // Try inserting when full
        q.insert_rear(60);

        // Deletion tests
        q.delete_front();
        q.delete_rear();

        q.display(); // should show 20 10 40
    }
}

class queue2 {
    int[] Dequeue_Array;
    int front, rear, max_size;

    public queue2(int size) {
        this.max_size = size;
        this.front = -1;
        this.rear = -1;
        this.Dequeue_Array = new int[size];
    }

    public boolean isFull() {
        return ((front == 0 && rear == max_size - 1) || (front == rear + 1));
    }

    public boolean isEmpty() {
        return (front == -1);
    }

    // Insert at front
    public void insert_front(int data) {
        if (isFull()) {
            System.out.println("Dequeue is full");
            return;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else if (front == 0) {
            front = max_size - 1;
        } else {
            front = front - 1;
        }
        Dequeue_Array[front] = data;
    }

    // Insert at rear
    public void insert_rear(int data) {
        if (isFull()) {
            System.out.println("Dequeue is full");
            return;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else if (rear == max_size - 1) {
            rear = 0;
        } else {
            rear = rear + 1;
        }
        Dequeue_Array[rear] = data;
    }

    // Delete from front
    public void delete_front() {
        if (isEmpty()) {
            System.out.println("Dequeue is empty");
            return;
        }
        System.out.println("Deleted from front: " + Dequeue_Array[front]);

        if (front == rear) { // only one element
            front = -1;
            rear = -1;
        } else if (front == max_size - 1) {
            front = 0;
        } else {
            front = front + 1;
        }
    }

    // Delete from rear
    public void delete_rear() {
        if (isEmpty()) {
            System.out.println("Dequeue is empty");
            return;
        }
        System.out.println("Deleted from rear: " + Dequeue_Array[rear]);

        if (front == rear) { // only one element
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = max_size - 1;
        } else {
            rear = rear - 1;
        }
    }

    // Display contents
    public void display() {
        if (isEmpty()) {
            System.out.println("Dequeue is empty");
            return;
        }
        int i = front;
        System.out.print("Deque contents: ");
        while (true) {
            System.out.print(Dequeue_Array[i] + " ");
            if (i == rear) break;
            i = (i + 1) % max_size;
        }
        System.out.println();
    }
}
