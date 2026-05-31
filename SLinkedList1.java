public class SLinkedList1 {

  private Node head;  //head node of the list
  private long size; //number of nodes in the list

/** Default constructor that creates an empty list */
  public SLinkedList1(){
    head=null;
    size=0;
  }
/**return the size of the list */
  public long getSize(){
    return size;
}

/**return the head of the list*/
public Node getHead(){
  return head;
}

/**is the list empty?*/
public boolean isEmpty(){
  return(head==null);
}
/**add new node at front of list */
  public void addFirst(Node n){
    n.setNext(head);
    head=n;
    size+=1;
}

/** remove node from front of list */
  public void removeFirst(){
    head=head.getNext(); //come back to this
    size=-1;
  }

/** add node to front of list containing a given value */
  public void addValue(String s){
    Node temp = new Node(s,null);
    addFirst(temp);
  }

/** display contents of linked list */
  public void display(){
    for (Node pointer = this.getHead(); pointer != null; pointer = pointer.getNext())
    	    System.out.println(pointer.getElement());
  }
}
