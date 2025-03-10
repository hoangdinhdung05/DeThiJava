class Node {
    private int data; //dữ liệu
    private Node next; //vị trí trỏ tiếp theo (NULL)

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
}