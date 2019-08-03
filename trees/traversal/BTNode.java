import java.util.*;

public class BTNode<T> {
  private T data;
  private BTNode<T> left;
  private BTNode<T> right;

  public BTNode(T data) {
    this.data = data;
  }

  public void setLeft(BTNode<T> left) {
    this.left = left;
  }

  public void setRight(BTNode<T> right) {
    this.right = right;
  }

  public BTNode<T> getLeft() {
    return this.left;
  }

  public BTNode<T> getRight() {
    return this.right;
  }

  public T getData() {
    return this.data;
  }
}