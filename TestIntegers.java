public class TestIntegers{
        
        public static void main(String[] args) {
            
            Integer intObjct1 = new Integer(1);
            Integer intObjct2 = new Integer(1);
            
            
            // Look closely at this case, stored in different places in memory
            if(intObjct1 == intObjct2) {
                System.out.println("1. true");
            }
            
            if(intObjct1.intValue() == intObjct2.intValue()) {
                System.out.println("2. true");
            }
            
            if(intObjct1.equals(intObjct2)) {
                System.out.println("3. true");
            }
            
        } 
        
}
