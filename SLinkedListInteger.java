public interface SLinkedListInteger{
    
    // Note, an interface and not a java class!
    
    public void displayList();	// displays the data on the list
    
    public int length();		// returns the number of nodes on the list
    
    public void addANodeToStart(Integer itemToAdd); // adds a node in front of the
    // first node
    
    public SNodeInteger deleteHeadNode();                // deletes the first node on the list
    
    public boolean isOnList(Integer dataItem); // return true if the first node contains the integer dataItem else return false
}