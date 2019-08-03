import java.util.*;

public class Traversal {

  public static void main(String args[]) {
    BTNode<Integer> root = new BTNode<Integer>(5);
    root.setLeft(new BTNode<Integer>(3));
    root.setRight(new BTNode<Integer>(7));
    System.out.print("In-order traversal: ");
    inOrder(root);
    System.out.print("\nPre-order traversal: ");
    preOrder(root);
    System.out.print("\nPost-order traversal: ");
    postOrder(root);
    System.out.println();
  }

  public static <T> void inOrder(BTNode<T> root) {
    if (root != null) {
      inOrder(root.getLeft());
      System.out.print(root.getData() + ", ");
      inOrder(root.getRight());
    }
  }

  public static <T> void preOrder(BTNode<T> root) {
    if (root != null) {
      System.out.print(root.getData() + ", ");
      inOrder(root.getLeft());
      inOrder(root.getRight());
    }
  }

  public static <T> void postOrder(BTNode<T> root) {
    if (root != null) {
      inOrder(root.getLeft());
      inOrder(root.getRight());
      System.out.print(root.getData() + ", ");
    }
  }
}