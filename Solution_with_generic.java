


class Node<T> {
	
	Node<T> prev = null;
	Node<T> next = null;
	T data;
	
	public Node(T data) {
		this.data = data;
	}
}

public class Solution_with_generic {

	static class Deque<T> {

		private Node<T> head = null;
		private Node<T> tail = null;
		private int size = 0;

		public void addFirst(T val) {
			Node node = new Node(val);
			addFirstNode(node);
		}

		private void addFirstNode(Node node) {
			if (this.size == 0) {
				this.head = this.tail = node;
			} else {
				node.next = this.head;
				this.head.prev = node;
				this.head = node;
			}

			this.size++;
		}

		public void addLast(T val) {
			Node node = new Node(val);
			addLastNode(node);
		}

		private void addLastNode(Node node) {
			if (this.size == 0) {
				this.head = this.tail = node;
			} else {
				this.tail.next = node;
				node.prev = this.tail;
				this.tail = node;
			}
			this.size++;
		}
		
		private boolean ListIsEmptyException() {
			if( this.size == 0 ) {
				System.out.println("ListIsEmpty: ");
				return true;
			}
			return false;
		}
		
		public T removeFirst() {
             if( ListIsEmptyException() ) {
            	 return  null;
             }
             
             return  (T) removeFirstNode().data;
		}
		
		private Node removeFirstNode() {
			Node node = this.head;
			if( this.size == 1 ) {
				this.head = this.tail = null;
			} else {
				// forward node
				// storing curr head's next node's address
				Node forw = node.next;
				node.next = null;
				forw.prev = null;
				
				this.head = forw;
			}
			
			this.size--;
			return node;
		}

		public T removeLast() {
			if( ListIsEmptyException() ) {
           	  return null;
            }
            
            T val = this.tail.data;
            if(size == 1) {
            	head = tail = null;
            }
            else {
            	// new tail
            	Node nt = this.tail.prev;
            	nt.next = this.tail.prev = null;
            	this.tail = nt;
            }
            
            this.size--;
            return val;
		}

		public T peekFirst() {
			try {
                if( this.head != null ) {
            	    return head.data;
                }
			}
			catch(Exception e) {
			    throw new RuntimeException("method not implemented");
			}
			return null;
		}

		public T peekLast() {
			try {
                if( this.tail != null  ) {
            	    return tail.data; 
                }
			}
			catch(Exception e) {
			    throw new RuntimeException("method not implemented");
			}
			return null;
		}

		public int size() {
			try {
			   return size;
			}
			catch(Exception e) {
			   throw new RuntimeException("method not implemented");
			}
		}
	}

	public static void main(String[] args) {
		try {
			doTestsPass();
			System.out.println("All tests passed");
		} catch (Exception ex) {
			System.out.println("Test failed");
			ex.printStackTrace();
		}
	}

	private static void doTestsPass() throws Exception {

		final Deque<String> deque = new Deque();

		// enqueue
		deque.addLast("a");
		deque.addLast("b");

		assertTrue(deque.size() == 2, "Test failed, size should be 2");
		assertTrue("a".equals(deque.peekFirst()), "First element should be 'a'");

		// TODO: add your test cases here
	};

	private static void assertTrue(boolean condition, String message) throws Exception {
		if (!condition)
			throw new Exception(message);
	}

}
