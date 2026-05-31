public class LinkedListInteger implements SLinkedListInteger
{
    // Implements a single linked list using a node that stores an Integer object
    
    int size = 0;
    SLinkedListNode head;
    
    public SLinkedListNode getHead()
    {   return head;
    }
    
    public void displayList()	// displays the data on the list
    {   for (SNodeInteger tmp = head; tmp != null; tmp= tmp.getNext())
            System.out.println(tmp.getElement()+", ");
    }
    
    public int length()		// returns the number of nodes on the list
    {   return size;
    }

    public void addANodeToStart(Integer itemToAdd); // adds a node in front of the
    // first node
    {   SLinkedListNode newNode = new SLinkedListNode(itemToAdd);
        if (head == null)
            head = newNode;
        else
        {   newNode.setNext(head);
            head = newNode;
        }
    }
    
    public SNodeInteger deleteHeadNode();                // deletes the first node on the list
    if (head == null)
    {   System.out.println("Cannot delete from an empty list!");
        System.exit(0);
    }
    else
    {   SNodeInteger tmp = head;
        head = head.getNext());
        return tmp;
    }

    public boolean isOnList(Integer dataItem); // returns true if node appears in list
    {   SNodeInteger tmp = head;
        for (SNodeInteger tmp = head; tmp != null, tmp.getElement()!= dataItem; tmp= tmp.getNext());
        
        if (tmp.getElement() == dataItem)
            return true;
        else
            return false;
    }
}