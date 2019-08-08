public class Stack<T> {
  private Node<T> head;

  public static void main(String[] args) {
    Stack<String> s = new Stack<>();
    s.push("First");
    s.push("Second");
    s.push("Third");
    s.pop();
    s.push("Fourth");
    System.out.println(s.toString());
  }

  public void push(T data) {
    Node<T> newNode = new Node<>(data);
    newNode.setNext(this.head);
    this.head = newNode;
  }

  public T pop() {
    if (this.head == null) {
      return null;
    }
    T data = this.head.getData();
    this.head = this.head.getNext();
    return data;
  }

  public T peek() {
    if (this.head == null) {
      return null;
    }
    return this.head.getData();
  }

  public boolean isEmpty() {
    return this.head == null;
  }

  public String toString() {
    StringBuilder toPrint = new StringBuilder();
    Node<T> current = this.head;
    while (current != null) {
      toPrint.append(current.getData() + "; ");
      current = current.getNext();
    }
    return toPrint.toString();
  }
}