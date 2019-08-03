import java.util.*;

public class Search {
  public static void main(String[] args) {
    ArrayList<Node<Integer>> childrenLevel_1 = new ArrayList<>();
    ArrayList<Node<Integer>> childrenLevel_2 = new ArrayList<>();
    childrenLevel_2.add(new Node<Integer>(1, null));
    childrenLevel_2.add(new Node<Integer>(3, null));
    childrenLevel_1.add(new Node<Integer>(4, null));
    childrenLevel_1.add(new Node<Integer>(6, null));
    childrenLevel_1.add(new Node<Integer>(8, childrenLevel_2));
    Node<Integer> root = new Node<Integer>(2, childrenLevel_1);
    System.out.println(dfs(root, 9));
    System.out.println(bfs(root, 9));
  }

  public static <T> boolean bfs(Node<T> root, T search) {
    Queue<Node<T>> queue = new LinkedList<>();
    queue.add(root);
    while (queue.peek() != null) {
      Node<T> current = queue.remove();
      System.out.println(current.getData());
      if (search.equals(current.getData())) {
        return true;
      }
      if (current.getChildren() != null) {
        for (Node<T> child : current.getChildren()) {
          queue.add(child);
        }
      }
    }
    return false;
  }

  public static <T> boolean dfs(Node<T> root, T search) {
    Stack<Node<T>> stack = new Stack<>();
    stack.push(root);
    while (!stack.empty()) {
      Node<T> current = stack.pop();
      System.out.println(current.getData());
      if (search.equals(current.getData())) {
        return true;
      }
      if (current.getChildren() != null) {
        for (Node<T> child : current.getChildren()) {
          stack.push(child);
        }
      }
    }
    return false;
  }
}