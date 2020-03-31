import java.util.*;

class StudentNode{

  int id;
  String name;
  double cgpa;
  StudentNode left, right;

  public StudentNode(int id, String name, double cgpa){

    this.id = id;
    this.name = name;
    this.cgpa = cgpa;
    this.left = this.right = null;
  }
}

class MyBST{

  StudentNode root;

  public MyBST(){

    this.root = null;
  }

  public boolean find(int idno){

    if(findHelper(root, idno)){
      System.out.println("\nRecord found with id : " + idno);
      return true;
    }
    System.out.println("\nReccord not found with id : " + idno);
    return false;
  }

  public boolean findHelper(StudentNode root, int idno){
    // helper function so that there is no need to collect root at every function call
    if(root == null){
      return false;
    }
    if(root.id == idno){
      return true;      // is found
    }
    if(idno < root.id){
      return findHelper(root.left, idno);
    }
    else if(idno > root.id){
      return findHelper(root.right, idno);
    }
    return false;     // not found
  }

  public void insert(int id, String name, double cgpa){

    root = insertHelper(root, id, name, cgpa);
  }

  public StudentNode insertHelper(StudentNode root, int id, String name, double cgpa){
    // helper function so that there is no need to collect root at every function call
    if(root == null){     // Base case
      root = new StudentNode(id, name, cgpa);
      return root;
    }
    if(id < root.id){
      root.left = insertHelper(root.left, id, name, cgpa);
    }
    else if(id > root.id){
      root.right = insertHelper(root.right, id, name, cgpa);
    }
    return root;
  }

  public void delete(int id){

    root = deleteHelper(root, id);
  }

  public StudentNode deleteHelper(StudentNode root, int idno){
    // helper function so that there is no need to collect root at every function call
    if(root == null){     // Base case
      return root;
    }
    if(idno < root.id){
      root.left = deleteHelper(root.left, idno);
    }
    else if(idno > root.id){
      root.right = deleteHelper(root.right, idno);
    }
    else{

      if(root.left != null && root.right != null){    // if node to be deleted has both left and right children
        StudentNode temp1 = root;
        StudentNode temp2 = inOrderSuccessor(temp1.right);   // finding minimum element in right sub tree

        root.id = temp2.id;
        root.name = temp2.name;
        root.cgpa = temp2.cgpa;

        root.right = deleteHelper(root.right, temp2.id);
      }
      else if(root.left != null){     // to be deleted node has only left child
        root = root.left;
      }
      else if(root.right != null){    // to be deleted node has only right child
        root = root.right;
      }
      else{
        root = null;
      }
    }
    return root;
  }

  public StudentNode inOrderSuccessor(StudentNode root){
    // recursive function to find out the in-order successor of a node ie. the minimum value element in the right subtree of a node
    if(root.left == null){
      return root;
    }
    else{
      return inOrderSuccessor(root.left);
    }
  }

  public void inOrder(StudentNode root){
    // in-order traversal
    if(root == null){
      return;
    }
    inOrder(root.left);
    System.out.println(" " + root.id + " " + root.name + " " + root.cgpa + " ");
    inOrder(root.right);
  }

  public void preOrder(StudentNode root){
    // pre-order traversal
    if(root == null){
      return;
    }
    System.out.println(" " + root.id + " " + root.name + " " + root.cgpa + " ");
    preOrder(root.left);
    preOrder(root.right);
  }

  public void postOrder(StudentNode root){
    // post-order traversal
    if(root == null){
      return;
    }
    postOrder(root.left);
    postOrder(root.right);
    System.out.println(" " + root.id + " " + root.name + " " + root.cgpa + " ");
  }
}

public class Program_BST{

  public static void main(String[] args) {

    MyBST tree = new MyBST();

    tree.insert(249, "John Ray", 8.6);
    tree.insert(247, "Chris Mat", 7.5);
    tree.insert(24, "Anubhav Sinha", 9.3);
    tree.insert(310, "Pedro Rodri", 8.1);
    tree.insert(86, "Luis Arano", 9.9);
    tree.insert(99, "Will Joe", 8.5);
    tree.insert(255, "Chris Prat", 9.4);
    tree.insert(135, "Leo Garcia", 9.7);
    tree.insert(303, "David James", 6.5);
    tree.insert(67, "Chritian Ben", 7.4);

    System.out.println("\nRunning in-order traversal : ");
    tree.inOrder(tree.root);

    System.out.println("\nDeleting record with id no. 99");
    tree.delete(99);

    System.out.println();
    System.out.println("\nRunning in-order traversal : ");
    tree.inOrder(tree.root);

    System.out.println();
    System.out.println("\nRunning pre-order traversal : ");
    tree.preOrder(tree.root);

    System.out.println();
    System.out.println("\nRunning post-order traversal : ");
    tree.postOrder(tree.root);

    tree.find(249);

    System.out.println("\nDeleting record with id no. 310");
    tree.delete(310);

    System.out.println("\nRunning in-order traversal : ");
    tree.inOrder(tree.root);
    System.out.println();

  }
}
