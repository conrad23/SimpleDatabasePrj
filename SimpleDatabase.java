/**********************************************************************
 * Creates the actual database used to contain student information.
 * 
 * @author Conner Toney
 * @version Winter 2015
 *********************************************************************/

package package1;

import java.io.*;

public class SimpleDatabase implements ISimpleDatabase {

	/* generic LinkedList object used as database */
	private LinkedList list;

	/******************************************************************
	 * Default constructor creates a new LinkedList object.
	 *****************************************************************/
	public SimpleDatabase() {
		list = new LinkedList();
	}

	/******************************************************************
	 * Inserts a student into the database.
	 * @param student the student to be input
	 *****************************************************************/
	@Override
	public void insert(Student student) {
		list.add(student);
	}

	/******************************************************************
	 * Deletes a student based on the given gnumber.
	 * @param gNumber the gnumber of the student to be deleted
	 * @return true if student has been deleted
	 *****************************************************************/
	@Override
	public boolean delete(String gNumber) {
		if (gNumber.length() != 9 || !gNumber.matches("[0-9]+"))
			throw new IllegalArgumentException();
		list.delete(gNumber);
		return true;
	}

	/******************************************************************
	 * Updates the content of the given student.
	 * @param gNumber the student's gnumber to be updated
	 * @param student the new data the student will be set to
	 * @return true if student was updated, false if not
	 *****************************************************************/
	@Override
	public boolean update(String gNumber, Student student) {
		if (gNumber.length() != 9 || !gNumber.matches("[0-9]+"))
			throw new IllegalArgumentException();
		list.find(gNumber);
		if (list.isFound()) {
			list.find(gNumber).setData(student);
			return true;
		}
		return false;
	}

	/******************************************************************
	 * Reverses the formation of the database.
	 *****************************************************************/
	@Override
	public void reverseList() {
		if (list.size() == 1 || list.size() == 0)
			return;

		//a temporary list is created, and items are added to it
		//starting from the end of the original list and ending at the
		//start of the original list
		LinkedList tempList = new LinkedList();
		for (int i = list.size(); i > 0; i--) {
			tempList.add(list.getStudent(i));
		}
		list = tempList;
	}

	/******************************************************************
	 * Sorts the database by the students' names, alphabetically.
	 *****************************************************************/
	@Override
	public void sort() {
		list.sort();
	}

	/******************************************************************
	 * Finds the student based on the given gnumber.
	 * @return the student based on the given gnumber
	 *****************************************************************/
	@Override
	public Student find(String gNumber) {
		if (gNumber.length() != 9 || !gNumber.matches("[0-9]+"))
			throw new IllegalArgumentException();
		if (list.size() == 0)
			throw new IllegalArgumentException();
		return list.find(gNumber).getData();
	}

	/******************************************************************
	 * Creates a string representation of the database.
	 * @return string representation of database
	 *****************************************************************/
	@Override
	public String toString() {
		return list.display();
	}

	/******************************************************************
	 * Loads a serialized database file.
	 * @param filename name of the file loaded
	 *****************************************************************/
	@Override
	public void loadDB(String filename) {
		try {
			FileInputStream fileInput = new FileInputStream(filename);
			ObjectInputStream objectInput;
			objectInput = new ObjectInputStream(fileInput);
			list = (LinkedList) objectInput.readObject();
			objectInput.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/******************************************************************
	 * Saves a serialized database file.
	 * @param filename name of the file saved
	 *****************************************************************/
	@Override
	public void saveDB(String filename) {
		try {
			FileOutputStream fileOutput;
			fileOutput = new FileOutputStream(filename);
			ObjectOutputStream objectOutput;
			objectOutput = new ObjectOutputStream(fileOutput);
			objectOutput.writeObject(list);
			objectOutput.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/******************************************************************
	 * Undoes the previous command.
	 * @return true if command was undone, false if undo failed
	 *****************************************************************/
	@Override
	public boolean undo() {
		return false;
	}

	/******************************************************************
	 * Removes all duplicates of a gnumber.
	 *****************************************************************/
	@Override
	public void removeDuplicates() {
		int size = list.size();

		//nested loop compares students from first loop to students in
		//second loop, and deletes duplicates in second loop as long
		//as index don't match
		for (int i = 1; i < size+1; i++)
			for (int j = 1; j < size+1; j++) {
				if (i != j) {
					if (list.getStudent(i).getGNumber().
							equals(list.getStudent(j).getGNumber())) {
						list.delete(j);
						size--;
					}
				}
			}
	}
}
