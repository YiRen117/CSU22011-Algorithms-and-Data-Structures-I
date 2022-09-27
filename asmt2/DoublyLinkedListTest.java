import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author  Yi Ren
 *  @version 02/11/21 09:35
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */
    @Test
    public void testInsertBefore()
    {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);       
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);        
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);        
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);        
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
     }
    
    @Test
    public void testIsEmpty()
    {
    	// test empty list
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	assertEquals( "Checking isEmpty to an empty list - expected true", true, testDLL.isEmpty());
    	// test non-empty list
    	testDLL = new DoublyLinkedList<Integer>();
    	testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
    	assertEquals( "Checking isEmpty to a non-empty list - expected false", false, testDLL.isEmpty());
    	
    }
    
    @Test
    public void testGet()
    {
    	// test empty list
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	assertEquals( "Checking get from an empty list at position 1 - expected null", null, testDLL.get(1));
    	
        // test if pos is within the bounds of the non-empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        assertEquals( "Checking get from a list containing 3 elements at position 0", "1", testDLL.get(0).toString());
        assertEquals( "Checking get from a list containing 3 elements at position 1", "2", testDLL.get(1).toString());
        assertEquals( "Checking get from a list containing 3 elements at position 2", "3", testDLL.get(2).toString());
        
        // test if pos is not within the bounds of the non-empty list
        assertEquals( "Checking get from a list containing 3 elements at position -10 - expected null", null, testDLL.get(-10));
        assertEquals( "Checking get from a list containing 3 elements at position -1 - expected null", null, testDLL.get(-1));
        assertEquals( "Checking get from a list containing 3 elements at position 700 - expected null", null, testDLL.get(700));
     }

    @Test
    public void testDeleteAt()
    {
    	// test empty list
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	assertEquals( "Checking deleteAt from an empty list at position 1 - expected false", false, testDLL.deleteAt(1));
    	assertEquals( "Checking deleteAt from an empty list at position 0 - expected false", false, testDLL.deleteAt(0));
    	
        //test non-empty list
    	testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(3,4);
        testDLL.insertBefore(4,5);

    	// test if pos points at the head of the list
        testDLL.deleteAt(0);
        assertEquals( "Checking deleteAt from a list containing 5 elements at position 0 - expected the deleted element at the head of the list", "2,3,4,5", testDLL.toString());
    	// test if pos points at the tail of the list
        testDLL.deleteAt(3);
        assertEquals( "Checking deleteAt from a list containing 4 elements at position 3 - expected the deleted element at the tail of the list", "2,3,4", testDLL.toString());
        // test if pos points within the bounds of the list (except head and tail)
        testDLL.deleteAt(1);
        assertEquals( "Checking deleteAt from a list containing 3 elements at position 1", "2,4", testDLL.toString());
        
        // test if pos points outside the bounds of the list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        assertEquals( "Checking deleteAt from a list containing 3 elements at position -10 - expected false", false, testDLL.deleteAt(-10));
        assertEquals( "Checking deleteAt from a list containing 3 elements at position -10", "1,2,3", testDLL.toString());
        assertEquals( "Checking deleteAt from a list containing 3 elements at position 700 - expected false", false, testDLL.deleteAt(700));
        assertEquals( "Checking deleteAt from a list containing 3 elements at position 700", "1,2,3", testDLL.toString());
     }
    // TODO: add more tests here. Each line of code in DoublyLinkedList.java should
    // be executed at least once from at least one test.

    @Test
    public void testReverse()
    {
    	// test empty list
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.reverse();
    	assertEquals( "Checking reverse with an empty list", "", testDLL.toString());
    	
        // test single-element list
    	testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.reverse();
        assertEquals( "Checking reverse with a list containing 1 element", "1", testDLL.toString());
        
    	// test multiple-element list
    	testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(3,4);
        testDLL.insertBefore(4,5);
        testDLL.reverse();
        assertEquals( "Checking reverse with a list containing 5 elements", "5,4,3,2,1", testDLL.toString());
     }
    
    @Test
    public void testMakeUnique()
    {
    	// test empty list
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.makeUnique();
    	assertEquals( "Checking makeUnique with an empty list", "", testDLL.toString());
    	
        // test single-element list
    	testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.makeUnique();
        assertEquals( "Checking makeUnique with a list containing 1 element", "1", testDLL.toString());
        
    	// test multiple-element list
    	testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,2);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(3,4);
        testDLL.insertBefore(4,3);
        testDLL.makeUnique();
        assertEquals( "Checking reverse with a 5-element list containing 2 duplicate elements", "2,3,4", testDLL.toString());
     }
    
    @Test
    public void testPush()
    {
        // test pushing elements onto a stack
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.push(1);
        testDLL.push(2);
        testDLL.push(3);

        assertEquals( "Checking push onto a stack", "3,2,1", testDLL.toString() );
        testDLL.push(4);
        assertEquals( "Checking push onto a stack", "4,3,2,1", testDLL.toString() );
        testDLL.push(5);       
        assertEquals( "Checking push onto a stack", "5,4,3,2,1", testDLL.toString() );
    }
    
    @Test
    public void testPop()
    {
        // test pushing elements onto a stack
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.push(1);
        testDLL.push(2);
        testDLL.push(3);

        assertEquals( "Checking pop from the stack", "3", testDLL.pop().toString() );
        assertEquals( "Checking elements on the stack", "2,1", testDLL.toString() );
        assertEquals( "Checking pop from the stack", "2", testDLL.pop().toString() );
        assertEquals( "Checking pop from the stack", "1", testDLL.pop().toString() );
        assertEquals( "Checking elements on the stack", "", testDLL.toString() );
        assertEquals( "Checking pop from an empty stack", null, testDLL.pop());
    }
    
    @Test
    public void testEnqueue()
    {
        // test enqueuing elements to a queue
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.enqueue(1);
        testDLL.enqueue(2);
        testDLL.enqueue(3);

        assertEquals( "Checking enqueue to a queue", "1,2,3", testDLL.toString() );
        testDLL.enqueue(4);
        assertEquals( "Checking enqueue to a queue", "1,2,3,4", testDLL.toString() );
        testDLL.enqueue(5);       
        assertEquals( "Checking enqueue to a queue", "1,2,3,4,5", testDLL.toString() );
    }
    
    @Test
    public void testDequeue()
    {
        // test dequeuing elements from a queue
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.enqueue(1);
        testDLL.enqueue(2);
        testDLL.enqueue(3);

        assertEquals( "Checking dequeue from the queue", "1", testDLL.dequeue().toString() );
        assertEquals( "Checking elements in the queue", "2,3", testDLL.toString() );
        assertEquals( "Checking dequeue from the queue", "2", testDLL.dequeue().toString() );
        assertEquals( "Checking dequeue from the queue", "3", testDLL.dequeue().toString() );
        assertEquals( "Checking elements in the queue", "", testDLL.toString() );
        assertEquals( "Checking dequeue from an empty queue", null, testDLL.dequeue());
    }
    
}

