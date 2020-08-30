
/* Name: Shiyun Lian
 * Description: this is a LinkedStack class that implements StackInterface
 */

import java.util.EmptyStackException;

public final class LinkedStack<T> implements StackInterface<T> {
	
	private Node topNode;	// references the first node in the chain
	
	public LinkedStack() {
		topNode = null;
	}
	
	// a private class Node
	private class Node <T>{
		private T data;  // entry in list
		private Node next;  // link to next node
			
		private Node(T dataPortion) {
				this(dataPortion, null);
		}// end constructor

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}// end constructor
			
		private T getData() {
			return data;
		}// end getData
			
		private void setData(T newData) {
			data = newData;
		}// end setData
			
		private Node getNextNode() {
			return next;
		}// end getNextNode
			
		private void setNextNode(Node nextNode) {
			next = nextNode;
		}// end setNextNode
	}// end Node
	
	public void push(T newEntry) {
		Node newNode = new Node(newEntry, topNode);
		topNode = newNode;
	}
	
	public T pop() {
		T top = peek();	// might throw EmptyStackException
		assert topNode != null;
		topNode = topNode.getNextNode();
		return top;
	}
	
	public boolean isEmpty() {
		return topNode == null;
	} // end isEmpty
	
	public void clear() {
		topNode = null;
	} // end clear
	
	public T peek() {
		if(isEmpty())
			throw new EmptyStackException();
		else
			return (T) topNode.getData();
	} // end peek
	

}
