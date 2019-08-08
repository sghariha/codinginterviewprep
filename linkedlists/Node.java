public class Node<T> {
  private T data;
  private Node<T> nextNode;

  public Node(T data) {
    this.data = data;
    this.nextNode = null;
  }

  public Node<T> getNext() {
    return this.nextNode;
  }

  public void setNext(Node<T> next) {
    this.nextNode = next;
  }

  public T getData() {
    return this.data;
  }

  
}