public class LinkedStackInteger
{
    // Stack implementation using a single linked list
    SLinkedlistInteger llst; // Implement the stack using a singly linked list
    
    public int getHeight()
    {
        return llst.length();
    }
    
    public boolean isEmpty()
    {
        return llst.length() == 0;
    }

    public void push(SNodeInteger e)
    {   llst.addANodeToStart(e.getElement());
    }

    public  SNodeInteger pop()
    {   SNodeInteger tmp = llst.deleteHeadNode();
    }

    public  SNodeInteger head()
    {
        return llst.head();
    }
}