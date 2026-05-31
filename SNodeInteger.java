public class SNodeInteger{
    
    //Instance variables:
    private Integer element;
    
    private SNodeInteger next;
    
    /**Creates node with null refs to element and next node */
    public SNodeInteger(){
        this(null,null);
    }
    
    /** Creates a node with the given element and next node */
    public SNodeInteger(Integer e, SNodeInteger n){
        element = e;
        next = n;
    }
    
    // Accessors
    public Integer getElement()
    {   return element;
    }
    
    public SNodeInteger getNext()
    {   return next;
    }
    
    // Mutators
    public void setElement(Integer e)
    {   element = e;
    }
    
    public void setNext(SNodeInteger n)
    {   next = n;
    }
    
    public toString()
    {   return element;
    }
}