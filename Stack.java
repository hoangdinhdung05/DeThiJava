class Stack {
    private Node top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0; 
    }

    public void push(int data) {
        Node newNode = new Node(data, top);
        this.top = newNode;
        this.size++;
    }

    public int pop() {
        if(isEmpty()) {
            return -1;
        } else {
            int tmp = top.getData();
            top = top.getNext();
            this.size--;
            return tmp;
        }
    }

    //Lấy phần tử đầu stack
    public int getFistStack() {
        return this.top.getData();
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int numOfElement() {
        return this.size;
    }

    public boolean search(int x) {
        Node tmp = top;
        while(tmp != null) {
            if(tmp.getData() == x) return true;
            tmp = tmp.getNext();
        }
        return false;
    }

    public void display() {
        Node tmp = top;
        while(tmp != null) {
            System.out.print(tmp.getData() + " ");
            tmp = tmp.getNext();
        }
        System.out.println();
    }

}
