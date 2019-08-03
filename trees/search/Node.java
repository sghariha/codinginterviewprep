import java.util.*;

public class Node<T> {
  private T data;
  private ArrayList<Node<T>> children;

  public Node(T data, ArrayList<Node<T>> children) {
    this.data = data;
    this.children = children;
  }

  public T getData() {
    return this.data;
  }

  public ArrayList<Node<T>> getChildren() {
    return this.children;
  }
}