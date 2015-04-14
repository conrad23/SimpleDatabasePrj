/**********************************************************************
 * Node used in LinkedList containing student data.
 * 
 * @author Conner Toney
 * @version Winter 2015
 *********************************************************************/

package package1;

import java.io.Serializable;

public class Node implements Serializable{

	/* default serial ID */
	private static final long serialVersionUID = 1L;

	/* generic student object */
	public Student data;

	/* the node next after this */
	public Node next;

	/* the node previously before this */
	public Node prev;

	/******************************************************************
	 * Default constructor creates an empty node.
	 *****************************************************************/
	public Node() {}

	/******************************************************************
	 * Constructor creates a node with input student data, and sets
	 * the next and previous nodes.
	 * @param data the given student data
	 * @param next the node after this
	 * @param prev the node before this
	 *****************************************************************/
	public Node(Student data, Node next, Node prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}

	/******************************************************************
	 * Constructor creates a node with only input student data.
	 * @param data the given student data
	 *****************************************************************/
	public Node(Student data) {
		next = null;
		this.data = data;
	}

	/******************************************************************
	 * Gets the data from the student object.
	 * @return the student object
	 *****************************************************************/
	public Student getData() {
		return data;
	}

	/******************************************************************
	 * Sets the data of the node.
	 * @param data the given student data
	 *****************************************************************/
	public void setData(Student data) {
		this.data = data;
	}

	/******************************************************************
	 * Gets the next node.
	 * @return the node after this
	 *****************************************************************/
	public Node getNext() {
		return next;
	}

	/******************************************************************
	 * Sets the next node.
	 * @param next the next node in line
	 *****************************************************************/
	public void setNext(Node next) {
		this.next = next;
	}

	/******************************************************************
	 * Gets the previous node.
	 * @return the node before this
	 *****************************************************************/
	public Node getPrev() {
		return prev;
	}

	/******************************************************************
	 * Sets the previous node.
	 * @param prev the node before this
	 *****************************************************************/
	public void setPrev(Node prev) {
		this.prev = prev;
	}
}
