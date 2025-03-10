import java.util.Scanner;

class Node {
    private int data;
    private Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return this.data;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setData(int data) {
        this.data = data;
    }
}

class Stack {
    private int size;
    private Node top;

    public Stack() {
        this.size = 0;
        this.top = null;
    }

    public void push(int data) {
        Node newNode = new Node(data, this.top);
        this.top = newNode;
        this.size++;
    }

    public int pop() {
        if (isEmpty()) {
            return -1; // Trả về -1 nếu stack rỗng
        }
        int tmp = this.top.getData();
        this.top = this.top.getNext();
        this.size--;
        return tmp;
    }

    public int search(int x) {
        Node tmp = this.top;
        int index = 1; 

        while (tmp != null) {
            if (tmp.getData() == x) {
                return index; 
            }
            tmp = tmp.getNext();
            index++;
        }
        return -1; 
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack rỗng!");
        } else {
            Node tmp = this.top;
            System.out.print("Stack: ");
            while (tmp != null) {
                System.out.print(tmp.getData() + " ");
                tmp = tmp.getNext();
            }
            System.out.println();
        }
    }
}


class Queue {
    private Node last, head;
    private int size; 

    public Queue() {
        this.last = this.head = null;
        this.size = 0; 
    }

    public void push(int data) {
        Node newNode = new Node(data, null);
        //TH: queue có 1 value
        if (this.last == null) {
            this.head = this.last = newNode;
        } else {
            //có 2 value trở lên
            this.last.setNext(newNode);
            this.last = newNode;
        }
        size++; 
    }

    public int pop() {
        if (this.head == null) {
            return -1;
        }
        int tmp = this.head.getData();
        this.head = this.head.getNext();
        if (this.head == null) {
            this.last = null;
        }
        size--;
        return tmp;
    }


    public boolean isEmpty() {
        return this.head == null;
    }

    public void display() {
        if (this.head == null) {
            System.out.println("Queue rỗng");
            return;
        }
        Node tmp = this.head;
        while (tmp != null) {
            System.out.print(tmp.getData() + " ");
            tmp = tmp.getNext();
        }
        System.out.println(); 
    }


    public boolean search(int data) {
        Node tmp = this.head;
        while (tmp != null) {
            if (tmp.getData() == data) {
                return true; // 
            }
            tmp = tmp.getNext();
        }
        return false; // 
    }

    public int size() {
        return size;
    }
}

public class MainSub {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();

        // while (true) {
        //     System.out.println("\n===== MENU =====");
        //     System.out.println("1. Push vào stack");
        //     System.out.println("2. Pop khỏi stack");
        //     System.out.println("3. Tìm kiếm phần tử trong stack");
        //     System.out.println("4. Kiểm tra stack rỗng");
        //     System.out.println("5. Hiển thị stack");
        //     System.out.println("6. Thoát");
        //     System.out.print("Chọn chức năng: ");

        //     if (!sc.hasNextInt()) {
        //         System.out.println("Lỗi! Vui lòng nhập số nguyên.");
        //         sc.next(); 
        //         continue;
        //     }

        //     int tt = sc.nextInt();

        //     switch (tt) {
        //         case 1:
        //             System.out.print("Nhập giá trị cần push: ");
        //             if (sc.hasNextInt()) {
        //                 int value = sc.nextInt();
        //                 stack.push(value);
        //                 System.out.println("Đã push " + value + " vào stack.");
        //             } else {
        //                 System.out.println("Lỗi! Vui lòng nhập số nguyên.");
        //                 sc.next();
        //             }
        //             break;
        //         case 2:
        //             int valuePop = stack.pop();
        //             if (valuePop != -1) {
        //                 System.out.println("Đã pop: " + valuePop);
        //             } else {
        //                 System.out.println("Không thể pop vì stack rỗng.");
        //             }
        //             break;
        //         case 3:
        //             System.out.print("Nhập giá trị cần tìm: ");
        //             if (sc.hasNextInt()) {
        //                 int x = sc.nextInt();
        //                 int position = stack.search(x);
        //                 if (position != -1) {
        //                     System.out.println("Phần tử " + x + " được tìm thấy ở vị trí: " + position);
        //                 } else {
        //                     System.out.println("Phần tử " + x + " không có trong stack.");
        //                 }
        //             } else {
        //                 System.out.println("Lỗi! Vui lòng nhập số nguyên.");
        //                 sc.next();
        //             }
        //             break;
        //         case 4:
        //             if (stack.isEmpty()) {
        //                 System.out.println("Stack rỗng.");
        //             } else {
        //                 System.out.println("Stack không rỗng.");
        //             }
        //             break;
        //         case 5:
        //             stack.display();
        //             break;
        //         case 6:
        //             System.out.println("Thoát chương trình.");
        //             sc.close();
        //             return;
        //         default:
        //             System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại.");
        //     }
        // }

        Queue queue = new Queue();
        queue.push(10);
        queue.push(20);
        queue.push(30);
        queue.display();
        queue.pop();
        queue.display();
        queue.size();
    }
}
