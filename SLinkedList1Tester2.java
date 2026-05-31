// Building a linked list by using the methods of the SLinkedList class

public class SLinkedList1Tester2
{
    public static void main (String[] args) throws Exception
    {
	  SLinkedList1 Slst = new SLinkedList1();

	  Slst.addFirst(new Node("Ben", null));
	  Slst.addFirst(new Node("Deon",null));
	  Slst.addFirst(new Node("Fred", null));
	  Slst.addFirst(new Node("Howie", null));
	  Slst.addValue("Abe");


	   // Display data stored in nodes in linkedlist

	   System.out.println("Initial linked list");
	   Slst.display();
	   Slst.removeFirst();
	   System.out.println("Linked list after removing front node");
	   Slst.display();
	}
}

