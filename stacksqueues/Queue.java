public class Queue<T> {
  private Node<T> head;

  public static void main(String[] args) {
    Queue<String> q = new Queue<>();
    q.add("First");
    q.add("Second");
    q.add("Third");
    q.remove();
    q.add("Fourth");
    System.out.println(q.toString());
  }

  public void add(T data) {
    Node<T> newNode = new Node<>(data);
    Node<T> current = this.head;
    if (this.head == null) {
      this.head = newNode;
    } else {
      while (current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(newNode);
    }
  }

  public T remove() {
    T data = this.head.getData();
    this.head = this.head.getNext();
    return data;
  }

  public T peek() {
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