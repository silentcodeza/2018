// Building a linked list by first creating a number of nodes and
// then joining them to form a linked list.

public class SLinkedList1Tester1
{
    public static void main (String[] args) throws Exception
    {
        Node pntr1 = new Node("Ben", null);
        Node pntr2 = new Node("Deon", null);
        Node pntr3 = new Node("Fred", null);
        Node pntr4 = new Node("Howie", null);

        Node head = pntr1;

        pntr1.setNext(pntr2);
        pntr2.setNext(pntr3);
        pntr3.setNext(pntr4);


	   // Display data in nodes in liked list
	   System.out.println("Initial linkedlist");
	   System.out.println("------------------");
        for (Node pointer = head; pointer!=null; pointer=pointer.getNext())
	        System.out.println(pointer.getElement());
	  
    }
}

