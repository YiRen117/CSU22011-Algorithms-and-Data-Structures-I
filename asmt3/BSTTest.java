import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @version 3.1 09/11/15 11:32:15
 *
 *  @author  Yi Ren
 */

@RunWith(JUnit4.class)
public class BSTTest
{
  
    /** <p>Test {@link BST#delete(Comparable)}.</p> */
    @Test
    public void testPut() {
        BST<Integer, Integer> bst = new BST<Integer, Integer>();
        bst.put(7, null); 
        assertEquals("Test if value is null", false, bst.contains(7));
        
        bst.put(7, 7);   //        _7_
        bst.put(8, 8);   //      /     \
        bst.put(3, 3);   //    _3_      8
        bst.put(1, 1);   //  /     \
        bst.put(2, 2);   // 1       6
        bst.put(6, 6);   //  \     /
        bst.put(4, 4);   //   2   4
        bst.put(5, 5);   //        \
                         //         5
        
        assertEquals("Checking if key 8 is inserted", true, bst.contains(8));
        assertEquals("Checking existent key 8", "8", bst.get(8).toString());
        
        assertEquals("Checking if key 4 is inserted", true, bst.contains(4));
        assertEquals("Checking existent key 4", "4", bst.get(4).toString());
        
        assertEquals("Checking non-existent key", false, bst.contains(10));
        assertEquals("Checking non-existent key", null, bst.get(10));
        
        assertEquals("Checking if key 8 exists", true, bst.contains(8));
        bst.put(8, 18);
        assertEquals("Replacing existent key 8 with a new value", "18", bst.get(8).toString());
        
        assertEquals("Checking if key 3 exists", true, bst.contains(3));
        bst.put(3, 13);
        assertEquals("Replacing existent key 3 with a new value", "13", bst.get(3).toString());
    }
	
    /** <p>Test {@link BST#delete(Comparable)}.</p> */
    @Test
    public void testGet() {
        BST<Integer, Integer> bst = new BST<Integer, Integer>();
        
        assertEquals("Test if empty", true, bst.isEmpty());
        
        bst.put(7, 7);   //        _7_
        bst.put(8, 8);   //      /     \
        bst.put(3, 3);   //    _3_      8
        bst.put(1, 1);   //  /     \
        bst.put(2, 2);   // 1       6
        bst.put(6, 6);   //  \     /
        bst.put(4, 4);   //   2   4
        bst.put(5, 5);   //        \
                         //         5
        
        assertEquals("Checking existent key", true, bst.contains(8));
        assertEquals("Checking existent key", "8", bst.get(8).toString());
        
        assertEquals("Checking existent key", true, bst.contains(4));
        assertEquals("Checking existent key", "4", bst.get(4).toString());
        
        assertEquals("Checking non-existent key", false, bst.contains(10));
        assertEquals("Checking non-existent key", null, bst.get(10));
    }
    
    /** <p>Test {@link BST#delete(Comparable)}.</p> */
    @Test
    public void testHeight() {
        BST<Integer, Integer> bst = new BST<Integer, Integer>();
        
        assertEquals("Test empty tree", -1, bst.height());
        
        bst.put(7, 7);
        assertEquals("Test single-node tree", 0, bst.height());
        
                         //        _7_
        bst.put(8, 8);   //      /     \
        bst.put(3, 3);   //    _3_      8
        bst.put(1, 1);   //  /     \
        bst.put(2, 2);   // 1       6
        bst.put(6, 6);   //  \     /
        bst.put(4, 4);   //   2   4
        bst.put(5, 5);   //        \
                         //         5
        
        assertEquals("Test multiple-node tree", 4, bst.height());
    }
    
    /** <p>Test {@link BST#delete(Comparable)}.</p> */
    @Test
    public void testMedian() {
        BST<Integer, Integer> bst = new BST<Integer, Integer>();
        
        assertEquals("Test empty tree", null, bst.median());
        
        bst.put(7, 7);
        assertEquals("Test single-node tree", "7", bst.median().toString());
        
                         //        _7_
        bst.put(8, 8);   //      /     \
        bst.put(3, 3);   //    _3_      8
        bst.put(1, 1);   //  /     \
        bst.put(2, 2);   // 1       6
        bst.put(6, 6);   //  \     /
        bst.put(4, 4);   //   2   4
        bst.put(5, 5);   //        \
                         //         5
        
        assertEquals("Test multiple-node tree", "4", bst.median().toString());
    }

  
    /** <p>Test {@link BST#prettyPrintKeys()}.</p> */
      
    @Test
    public void testPrettyPrint() {
    	BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	assertEquals("Checking pretty printing of empty tree",
             "-null\n", bst.prettyPrintKeys());
      
                             //  -7
                             //   |-3
                             //   | |-1
                             //   | | |-null
    	bst.put(7, 7);       //   | |  -2
    	bst.put(8, 8);       //   | |   |-null
    	bst.put(3, 3);       //   | |    -null
    	bst.put(1, 1);       //   |  -6
    	bst.put(2, 2);       //   |   |-4
    	bst.put(6, 6);       //   |   | |-null
    	bst.put(4, 4);       //   |   |  -5
    	bst.put(5, 5);       //   |   |   |-null
                             //   |   |    -null
                             //   |    -null
                             //    -8
                             //     |-null
                             //      -null
     
    	String result = 
    			"-7\n" +
    			" |-3\n" + 
    			" | |-1\n" +
    			" | | |-null\n" + 
    			" | |  -2\n" +
    			" | |   |-null\n" +
    			" | |    -null\n" +
    			" |  -6\n" +
    			" |   |-4\n" +
    			" |   | |-null\n" +
    			" |   |  -5\n" +
    			" |   |   |-null\n" +
    			" |   |    -null\n" +
    			" |    -null\n" +
    			"  -8\n" +
    			"   |-null\n" +
    			"    -null\n";
    	assertEquals("Checking pretty printing of non-empty tree", result, bst.prettyPrintKeys());
    }

  
     /** <p>Test {@link BST#delete(Comparable)}.</p> */
     @Test
     public void testDelete() {
         BST<Integer, Integer> bst = new BST<Integer, Integer>();
         bst.delete(1);
         assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());
         
         bst.put(7, 7);   //        _7_
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                          //         5
         
         assertEquals("Checking order of constructed tree",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
         
         bst.delete(9);
         assertEquals("Deleting non-existent key",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
 
         bst.delete(8);
         assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());
 
         bst.delete(6);
         assertEquals("Deleting node with single child",
                 "(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());
 
         bst.delete(1);
         assertEquals("Deleting node with single child",
                 "(((()2())3(()4(()5())))7())", bst.printKeysInOrder());
         
         bst = new BST<Integer, Integer>();
         bst.put(9, 9);   	//	        _9_
         bst.put(6, 6);   	//	      /     \
         bst.put(10, 10);   //	    _6_      10
         bst.put(8, 8);   	//	  /     \
         bst.put(2, 2);   	//	 2       8
         bst.put(1, 1);   	//	/ \     /
         bst.put(3, 3);   	// 1   3   7
         bst.put(7, 7);   	//	    \
         bst.put(5, 5);   	//	     5
         bst.put(4, 4);     //	    /
         					//     4
         
         
         assertEquals("Checking order of constructed tree",
                 "((((()1())2(()3((()4())5())))6((()7())8()))9(()10()))", bst.printKeysInOrder());
         
         bst.delete(6);
         assertEquals("Deleting node with two children",
                 "((((()1())2(()3(()4())))5((()7())8()))9(()10()))", bst.printKeysInOrder());
         
     }
     
}

