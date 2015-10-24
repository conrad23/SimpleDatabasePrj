/**********************************************************************
 * Creates the Linked List data structure and various methods used
 * as a simple database.
 * 
 * @author Conner Toney
 * @version Winter 2015
 *********************************************************************/

package package1;

import java.io.Serializable;

public class LinkedList implements Serializable{

	/* default serial ID */
	private static final long serialVersionUID = 1L;

	/* the current amount of items in the linked list */
	private int count;

	/* the top of the linked list */
	private Node head;

	/* the bottom of the linked list */
	private Node tail;

	/* determines whether or not an item has been found */
	private boolean isFound;

	/******************************************************************
	 * Default constructor creates an empty LinkedList with the tail
	 * pointing to an empty head.
	 *****************************************************************/
	public LinkedList() {
		head = null;
		tail = head;
		count = 0;
	}

	/******************************************************************
	 * Adds a student to the end of the list.
	 * @param data the student's name, gpa, and gnumber
	 *****************************************************************/
	public void add(Student data) {
		Node temp = new Node(data);
		Node current = head;

		//case: empty list
		if (head == null) {
			head = temp;
			tail = head;
			count++;
			return;
		}

		//case: list with 1 item
		if (count == 1) {
			head.setNext(temp);
			temp.setPrev(head);
			temp.setNext(null);
			tail = temp;
			count++;
			return;
		}

		//case: list with at least 2 items
		while (current.getNext() != null)
			current = current.getNext();

		current.setNext(temp);
		temp.setPrev(current);
		temp.setNext(null);
		tail = temp;
		count++;
	}

	/******************************************************************
	 * Deletes a student from the list based on the input gnumber.
	 * 
	 * @param gNumber the desired student to be deleted
	 * @return false if student cannot be deleted, true if student
	 * has been deleted
	 *****************************************************************/
	public boolean delete(String gNumber) {
		Node current = head;

		//case: empty list
		if (head == null)
			return false;

		//case: list with 1 item
		if (head.getData().getGNumber().equals(gNumber)) {
			head = head.getNext();
			count--;
			return true;
		}

		while (current.getNext() != null) {

			//case: middle item
			if (current.getData().getGNumber().equals(gNumber)) {
				current.getNext().setPrev(current.getPrev());
				current.getPrev().setNext(current.getNext());
				count--;
				return true;
			}

			//case: item is last
			if (current.getNext() == tail) {
				tail = tail.getPrev();
				tail.setNext(null);
				count--;
				return true;
			}
			current = current.getNext();
		}
		return false;
	}

	/******************************************************************
	 * Deletes a student from the list based on the input index.
	 * 
	 * @param index the desired location of the student to be deleted
	 * @return false if student cannot be deleted, true if student
	 * has been deleted
	 *****************************************************************/
	public boolean delete(int index) {
		Node current = head;

		if (index < 0 || index > count)
			throw new IllegalArgumentException();

		//case: empty list
		if (index == 0)
			return false;

		//case: list with 1 item
		if (index == 1) {
			head = head.getNext();
			count--;
			return true;
		}

		//case: last item in list
		if (index == count) {
			tail = tail.getPrev();
			tail.setNext(null);
			count--;
			return true;
		}

		//case: item is in middle of list
		for (int i = 0; i < index-1; i++) 
			current = current.getNext();

		current.getNext().setPrev(current.getPrev());
		current.getPrev().setNext(current.getNext());
		count--;
		return true;
	}

	/******************************************************************
	 * Gets the student based on the input index.
	 * 
	 * @param index the desired location of the student
	 * @return null if student can't be found, student's data if found
	 *****************************************************************/
	public Student getStudent(int index) {
		if (index <= 0)
			throw new IndexOutOfBoundsException();

		Node current = head;

		//iterates through list until desired index
		for (int i = 1; i < index; i++) {
			if (current.getNext() == null)
				return null;
			current = current.getNext();
		}
		return current.getData();
	}

	/******************************************************************
	 * Gets the node based on the input index.
	 * @param index the desired location of the node
	 * @return null if node can't be found, node if found
	 *****************************************************************/
	public Node getNode(int index) {
		if (index <= 0)
			throw new IndexOutOfBoundsException();

		Node current = head;

		//iterates through list until index
		for (int i = 1; i < index; i++) {
			if (current.getNext() == null)
				return null;
			current = current.getNext();
		}
		return current;
	}

	/******************************************************************
	 * Sets a node to given student data based on the input index
	 * @param index the desired location of the student to be changed
	 * @param student the data to be set into the node
	 *****************************************************************/
	public void setNode(int index, Student student) {
		if (index <= 0)
			throw new IndexOutOfBoundsException();

		Node current = head;

		//iterates through list until index
		for (int i = 1; i < index; i++) {
			if (current.getNext() == null)
				return;
			current = current.getNext();
		}
		current.setData(student);
	}

	/******************************************************************
	 * Creates a string in which the linked list can be displayed.
	 * @return str a string representation of the linked list
	 *****************************************************************/
	public String display() {
		String str = "";
		Node current = head;

		//iterates through list and adds node data to string
		while (current != null) {
			str += current.getData();
			str += "\n";
			current = current.getNext();
		}
		str += "\n";
		str += ("Total students in database: " + count);
		return str;
	}

	/******************************************************************
	 * Finds the student's information based on the input gnumber
	 * @param gNumber the desired student's gnumber
	 * @return node containing student data, or null if student
	 * isn't found
	 *****************************************************************/
	public Node find(String gNumber) {
		Node current = head;
		isFound = false;

		//iterates through list, returns node containing student data
		//if the student is found
		while (current != null) {
			if (current.getData().getGNumber().equals(gNumber)) {
				isFound = true;
				return current;
			}
			current = current.getNext();
		}
		return null;
	}

	/******************************************************************
	 * Gets the size of the linked list
	 * @return count - the size of the linked list
	 *****************************************************************/
	public int size() {
		return count;
	}

	/******************************************************************
	 * Gets the isFound variable
	 * @return isFound value
	 *****************************************************************/
	public boolean isFound() {
		return isFound;
	}

	/******************************************************************
	 * Determines if the list is empty or not
	 * @return true if empty, false if not
	 *****************************************************************/
	public boolean isEmpty() {
		return size() == 0;
	}

	/******************************************************************
	 * Sorts the list by the students' names alphabetically.
	 *****************************************************************/
	public void sort() {
		if (isEmpty() || size() == 1)
			return;

		int numOfChanges = 0;

		//iterates through list repeatedly until no changes have
		//been made
		do {
			numOfChanges = 0;
			for (int i = 1; i < size()+1; i++) {
				if (i < size()) {

					//compares this node to next node
					if (this.getNode(i).getData().getName().
							toLowerCase().compareTo(this.getNode(i+1).
									getData().getName().
									toLowerCase()) > -1) {
						Student temp = this.getStudent(i);
						this.setNode(i, this.getNode(i+1).getData());
						this.setNode(i+1, temp);
						numOfChanges++;
					}
				}
			}
		} while (numOfChanges != 0);
	}
}