import java.util.Scanner;

class Node
{
  private Node parent;
  private Node left;
  private Node right;
  private int value;

  public Node (int v)
  {
    this.value = v;
    this.right = this.left = this.parent = null;
  }
  public Node (int v, Node p, Node left, Node right)
  {
    this.value = v;
    this.parent = p;
    this.left = left;
    this.right = right;
  }
  void setleft (Node n)
  {
    this.left = n;
  }
  void setright (Node n)
  {
    this.right = n;
  }
  void setP (Node n)
  {
    this.parent = n;
  }
  void setValue (int v)
  {
    this.value = v;
  }
  Node getleft ()
  {
    return this.left;
  }
  Node getright ()
  {
    return this.right;
  }
  Node getP ()
  {
    return this.parent;
  }
  int getValue ()
  {
    return this.value;
  }
  boolean isExternal ()
  {
    if ((this.left == null) && (this.right == null))
      return true;
    return false;
  }
}

class BinarySearchTree
{
  Node root;
  int size = 0;
  void PreOrder (Node w)
  {

    if (w != null && !w.isExternal ())
      {
	System.out.print (w.getValue () + " ");
	Node l = w.getleft ();
	  PreOrder (l);
	Node r = w.getright ();
	  PreOrder (r);
      }
  }
  void PostOrder (Node w)
  {
 
    if (w != null && !w.isExternal ())
      {
	Node l = w.getleft ();
	PostOrder (l);
	Node r = w.getright ();
	PostOrder (r);
	System.out.print (w.getValue () + " ");
      }
  }
  void InOrder (Node w)
  {
  

    if (w != null && !w.isExternal ())
      {
	Node l = w.getleft ();
	InOrder (l);

	System.out.print (w.getValue () + " ");
	Node r = w.getright ();
	InOrder (r);
      }
  }
  Node Sibling (Node v)
  {
    Node x;
    if (isRoot (v))
      {
	System.out.println ("Error : Root does not have a sibling");
	return null;
      }
    Node p = v.getP ();
    if (p.getleft () == v)
      {
	if (p.getright () != null)
	  return p.getright ();
	System.out.println ("Error : Node does not have a sibling");
	return null;
      }
    if (p.getleft () != null)
      return p.getleft ();
    System.out.println ("Error : Node does not have a sibling");
    return null;
  }
  boolean isRoot (Node v)
  {
    if (this.root == v)
      return true;
    else
      return false;
  }
  void expandExternal (Node w, int k)
  {

    if (w == null)
      {
	w = new Node (k);
	this.root = w;
      }

    w.setleft (new Node (-1, w, null, null));
    w.setright (new Node (-1, w, null, null));

    w.setValue (k);
  }

  Node Search (int k, Node w)
  {
    Node x = new Node (-1);

    if (w.isExternal ())
      {
	return w;
      }

    if (k < w.getValue ())
      {
	System.out.println (k + "<" + w.getValue ());
	x = Search (k, w.getleft ());
      }
    else if (k == w.getValue ())
      {
	x = w;
      }
    else if (k > w.getValue ())
      {
	System.out.println (k + ">" + w.getValue ());
	x = Search (k, w.getright ());
      }
    return x;
  }

  Node Insert (int k, Node v)
  {
    this.size++;
    if (v == null)
      {
	expandExternal (v, k);
      }
    else
      {
	Node w = Search (k, v);
	if (!w.isExternal ())
	  {
	    return Insert (k, w.getleft ());
	  }
	expandExternal (w, k);
      }
    System.out.println();  
    return null;
  }

  void removeAboveExternal (Node c)
  {
    Node s = Sibling (c);
    Node x = c.getP ();
    Node p = x.getP ();
    if (p != null)
      {
	if (p.getleft () == x)
	  p.setleft (s);
	else if (p.getright () == x)
	  p.setright (s);
      }
    else
      {
	this.root = s;
      }
    s.setP (p);
  }

  void Delete (int k)
  {
    Node x = Search (k, this.root);
    if (x.getValue () == -1)
      {
	System.out.println ("Error : Element does not exist");
      }

    else
      {
	if (x.getleft ().isExternal ())
	  {
	    removeAboveExternal (x.getleft ());
	  }
	else if (x.getright ().isExternal ())
	  {
	    removeAboveExternal (x.getright ());
	  }
	else
	  {
	    Node y = x.getright ();
	    while (!y.getleft ().isExternal ())
	      {
		y = y.getleft ();
	      }
	    x.setValue (y.getValue ());
	    if (y.getP () != x)
	      {
		Node p = y.getP ();
		p.setleft (new Node (-1, p, null, null));
	      }
	    else
	      {
		x.setright (new Node (-1, x, null, null));
	      }
	  }
      }
    this.size--;
  }

}

public class MainProgram
{
  public static void main (String args[])
  {
    Scanner s = new Scanner (System.in);
    BinarySearchTree t = new BinarySearchTree ();
      t.Insert (2, t.root);
      t.Insert (8, t.root);
      t.Insert (5, t.root);
      t.Insert (10, t.root);
      t.Insert (15, t.root);
      t.Insert (6, t.root);
      t.Insert(21,t.root);
    
    Node x = t.Search (4, t.root);
    if (x.isExternal ())
        System.out.println ("Element not found");
    else
        System.out.println ("Element found");
     
     t.Delete(5);
     t.PostOrder(t.root);

     t.PreOrder(t.root);
     t.InOrder(t.root);

  }

}
