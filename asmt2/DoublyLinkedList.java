import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  Yi Ren
 *  @version 02/11/21 11:13
 */


/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * @param <T> This is a type parameter. T is used as a class name in the
 * definition of this class.
 *
 * When creating a new DoublyLinkedList, T should be instantiated with an
 * actual class name that extends the class Comparable.
 * Such classes include String and Integer.
 *
 * For example to create a new DoublyLinkedList class containing String data: 
 *    DoublyLinkedList<String> myStringList = new DoublyLinkedList<String>();
 *
 * The class offers a toString() method which returns a comma-separated sting of
 * all elements in the data structure.
 * 
 * This is a bare minimum class you would need to completely implement.
 * You can add additional methods to support your code. Each method will need
 * to be tested by your jUnit tests -- for simplicity in jUnit testing
 * introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>>
{

    /**
     * private class DLLNode: implements a *generic* Doubly Linked List node.
     */
    private class DLLNode
    {
        public final T data; // this field should never be updated. It gets its
                             // value once from the constructor DLLNode.
        public DLLNode next;
        public DLLNode prev;
    
        /**
         * Constructor
         * @param theData : data of type T, to be stored in the node
         * @param prevNode : the previous Node in the Doubly Linked List
         * @param nextNode : the next Node in the Doubly Linked List
         * @return DLLNode
         */
        public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) 
        {
          data = theData;
          prev = prevNode;
          next = nextNode;
        }
    }

    // Fields head and tail point to the first and last nodes of the list.
    private DLLNode head, tail;

    /**
     * Constructor of an empty DLL
     * @return DoublyLinkedList
     */
    public DoublyLinkedList() 
    {
      head = null;
      tail = null;
    }

    /**
     * Tests if the doubly linked list is empty
     * @return true if list is empty, and false otherwise
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification:
     *  This method only consists of one constant time operation. Therefore, the cost of isEmpty is Theta(1).
     */
    public boolean isEmpty()
    {
      return (head == null);
    }

    /**
     * Inserts an element in the doubly linked list
     * @param pos : The integer location at which the new data should be
     *      inserted in the list. We assume that the first position in the list
     *      is 0 (zero). If pos is less than 0 then add to the head of the list.
     *      If pos is greater or equal to the size of the list then add the
     *      element at the end of the list.
     * @param data : The new data of class T that needs to be added to the list
     * @return none
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     *  We assume the input position is N.
     *  All lines except the for-loop are constant time operations, so their cost are all Theta(1).
     *  Thus, every one iteration of the for-loop will have cost Theta(1).
     *  Since the for-loop will iterate all N positions, the cost of the for-loop will be N*Theta(1)=Theta(N)
     *  Hence, the total cost is Theta(N).
     */
    public void insertBefore( int pos, T data ) 
    {
      DLLNode newNode = new DLLNode(data, null, null);
      if(isEmpty()){
    	  head = newNode;
    	  tail = newNode;
      }
      else if(pos <= 0){
    	  newNode.next = head;
    	  head.prev = newNode;
    	  head = newNode;
      }
      else{
    	  DLLNode current = head;
    	  for(int i=0; i < pos; i++) {
    		  if(current != null) {
    			  current = current.next;
    		  }
    	  }
    	  if(current == null) {
        	  tail.next = newNode;
        	  newNode.prev = tail;
        	  tail = newNode;
    	  }
    	  else {
    		  current.prev.next = newNode;
    		  newNode.prev = current.prev;
    		  current.prev = newNode;
    		  newNode.next = current;
    	  }
      }
      return;
    }

    /**
     * Returns the data stored at a particular position
     * @param pos : the position
     * @return the data at pos, if pos is within the bounds of the list, and null otherwise.
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     *  We assume the input position is N.
     *  All lines except the for-loop are constant time operations, so their cost are all Theta(1).
     *  Thus, every one iteration of the for-loop will have cost Theta(1).
     *  Since the for-loop will iterate all N positions, the cost of the for-loop will be N*Theta(1)=Theta(N)
     *  Hence, the total cost is Theta(N).
     */
    public T get(int pos) 
    {
      if(pos >= 0) {
    	  DLLNode current = head;
    	  for(int i=0; i < pos; i++) {
    		  if(current != null) {
    			  current = current.next;
    		  }
    	  }
    	  return (current != null) ? current.data : null;
      }
      else return null;
    }

    /**
     * Deletes the element of the list at position pos.
     * First element in the list has position 0. If pos points outside the
     * elements of the list then no modification happens to the list.
     * @param pos : the position to delete in the list.
     * @return true : on successful deletion, false : list has not been modified. 
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     *  We assume the input position is N.
     *  All lines except the for-loop are constant time operations, so their cost are all Theta(1).
     *  Thus, every one iteration of the for-loop will have cost Theta(1).
     *  Since the for-loop will iterate all N positions, the cost of the for-loop will be N*Theta(1)=Theta(N)
     *  Hence, the total cost is Theta(N).
     */
    public boolean deleteAt(int pos) 
    {
      if(pos >= 0 && !isEmpty()) {
    	  if(pos == 0) {
        	  head = head.next;
        	  return true;
          }
    	  else {
    		  DLLNode current = head;
        	  for(int i=0; i < pos; i++) {
        		  if(current != null) {
        			  current = current.next;
        		  }
        	  }
        	  if(current != null) {
        		  if(current.next != null) {
        			  current.prev.next = current.next;
            		  current.next.prev = current.prev;
        		  }
        		  else {
        			  tail = current.prev;
        			  tail.next = null;
        		  }
        		  return true;
        	  }
    	  }
      }
      return false;
    }

    /**
     * Reverses the list.
     * If the list contains "A", "B", "C", "D" before the method is called
     * Then it should contain "D", "C", "B", "A" after it returns.
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     *  We assume the size of the list is N.
     *  All lines except the while-loop are constant time operations, so their cost are all Theta(1).
     *  Thus, every one iteration of the while-loop will have cost Theta(1).
     *  Since the while-loop will iterate N-1 elements in the list(the loop exits when it reaches the tail), 
     *  the cost of the while-loop will be (N-1)*Theta(1)=Theta(N-1)=Theta(N)
     *  Hence, the total cost is Theta(N).
     */
    public void reverse()
    {
    	if(!isEmpty() && head.next != null) {
    		DLLNode current = head;
    		tail = current;
    		DLLNode temp;
        	while(current.next != null) {
        	  temp = current.prev;
          	  current.prev = current.next;
          	  current.next = temp;
          	  current = current.prev;
            }
        	temp = current.prev;
        	current.prev = current.next;
        	current.next = temp;
        	head = current;
    	}
    	return;
    }

    /**
     * Removes all duplicate elements from the list.
     * The method should remove the _least_number_ of elements to make all elements uniqueue.
     * If the list contains "A", "B", "C", "B", "D", "A" before the method is called
     * Then it should contain "A", "B", "C", "D" after it returns.
     * The relative order of elements in the resulting list should be the same as the starting list.
     *
     * Worst-case asymptotic running time cost: Theta(N^2)
     *
     * Justification:
     *  We assume the size of the list is N.
     *  All lines except the double while-loop are constant time operations, so their cost are all Theta(1).
     *  Thus, every one iteration of the inner while-loop will have cost Theta(1).
     *  In the worst-case situation, the inner while-loop will iterate N-1 elements in the list(the loop starts from the next element of head)
     *  and the outer while-loop will iterate all N elements in the list.
     *  Therefore, the cost of the inner while-loop will be (N-1)*Theta(1)=Theta(N-1)=Theta(N) and the outer loop cost will be N*Theta(N) = Theta(N^2).
     *  Hence, the total cost will be Theta(N^2).
     */
     public void makeUnique()
    {
      DLLNode current = head;
      int pos = 0;
      int count = 1;
      while(current != null) {
          DLLNode element = current.next;
          while(element != null) {
        	  if(current.data == element.data) {
        		  int index = pos + count;
        		  element = element.next;
        		  deleteAt(index);
        		  count--;
        	  }
        	  else {
        		  element = element.next;
        	  }
        	  count++;
          }
          current = current.next;
          pos++;
          count = 1;
      }
    }


    /*----------------------- STACK API 
     * If only the push and pop methods are called the data structure should behave like a stack.
     */

    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to push on the stack
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     *  In push method I simply called insertBefore method here, so the running time cost of push should be the same as insertBefore.
     *  Since the cost of insertBefore is Theta(N), the cost of push will be Theta(N).
     */
    public void push(T item) 
    {
      insertBefore(0, item);
    }

    /**
     * This method returns and removes the element that was most recently added by the push method.
     * @return the last item inserted with a push; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     *  In pop method I simply called deleteAt method and used a constant time operation whose cost is Theta(1).
     *  Since the cost of deleteAt is Theta(N), the cost of pop will be T(N)=Theta(N)+Theta(1)=Theta(N).
     */
    public T pop() 
    {
      T element = isEmpty() ? null : head.data;
      deleteAt(0);
      return element;
    }

    /*----------------------- QUEUE API
     * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
     */
 
    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to be enqueued to the stack
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     *  We assume the size of the queue is N.
     *  All lines except the while-loop are constant time operations, so their cost are all Theta(1).
     *  Thus, every one iteration of the while-loop will have cost Theta(1).
     *  Since the while-loop will iterate all N elements in the list, the cost of the while-loop will be N*Theta(1)=Theta(N).
     *  Hence, the total cost is Theta(N).
     */
    public void enqueue(T item) 
    {
    	int count = 0;
    	DLLNode current = head;
    	while(current != null) {
    		current = current.next;
    		count++;
    	}
    	insertBefore(count+1, item);
    }

     /**
     * This method returns and removes the element that was least recently added by the enqueue method.
     * @return the earliest item inserted with an equeue; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     *  In dequeue method I simply called deleteAt method and used several constant time operations whose cost are all Theta(1).
     *  Since the cost of deleteAt is Theta(N), the cost of dequeue will be T(N)=Theta(N)+Theta(1)=Theta(N).
     */
    public T dequeue() 
    {
        T element = isEmpty() ? null : head.data;
        deleteAt(0);
        return element;
    }
 

    /**
     * @return a string with the elements of the list as a comma-separated
     * list, from beginning to end
     *
     * Worst-case asymptotic running time cost:   Theta(n)
     *
     * Justification:
     *  We know from the Java documentation that StringBuilder's append() method runs in Theta(1) asymptotic time.
     *  We assume all other method calls here (e.g., the iterator methods above, and the toString method) will execute in Theta(1) time.
     *  Thus, every one iteration of the for-loop will have cost Theta(1).
     *  Suppose the doubly-linked list has 'n' elements.
     *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n).
     */
    public String toString() 
    {
      StringBuilder s = new StringBuilder();
      boolean isFirst = true; 

      // iterate over the list, starting from the head
      for (DLLNode iter = head; iter != null; iter = iter.next)
      {
        if (!isFirst)
        {
          s.append(",");
        } else {
          isFirst = false;
        }
        s.append(iter.data.toString());
      }

      return s.toString();
    }


}



