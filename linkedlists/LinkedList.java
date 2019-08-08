public class LinkedList<T> {
  private Node<T> head;

  public static void main(String[] args) {
    LinkedList<String> ll = new LinkedList<>();
    ll.addItem("First");
    ll.addItem("Second");
    ll.addItem("Third");
    ll.removeItem("Third");
    System.out.println(ll.toString());
  }

  public void addItem(T data) {
    Node<T> newNode = new Node<>(data);
    this.addNode(newNode);
  }

  public void addNode(Node<T> newNode) {
    if (this.head == null) {
      this.head = newNode;
      return;
    }
    Node<T> current = this.head;
    while (current.getNext() != null) {
      current = current.getNext();
    }
    current.setNext(newNode);
  }

  public boolean removeItem(T data) {
    Node<T> current = this.head;
    if (current.getData().equals(data)) {
      this.head = this.head.getNext();
    }
    while (current.getNext() != null) {
      if (current.getNext().getData().equals(data)) {
        current.setNext(current.getNext().getNext());
        return true;
      }
      current = current.getNext();
    }
    return false;
  }

  public String toString() {
    Node<T> current = this.head;
    StringBuilder toPrint = new StringBuilder();
    while (current != null) {
      toPrint.append(current.getData() + "; ");
      current = current.getNext();
    }
    return toPrint.toString();
  }
}