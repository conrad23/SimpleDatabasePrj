/**********************************************************************
 * An interface containing methods that are required for creating
 * a SimpleDatabase class.
 * 
 * @author Conner Toney
 * @version Winter 2015
 *********************************************************************/

package package1;

public interface ISimpleDatabase {
	/* inserts a student into the DB */
	void insert(Student student);

	/* deletes a student from the DB */
	boolean delete(String gNumber);

	/* only updates name & gpa, uses gNumber to locate student */
	boolean update(String gNumber, Student student);

	/* returns a string of the entire DB */
	String toString();

	/* finds a Student, otherwise returns null */
	Student find(String gNumber);

	/* reverses the database */
	void reverseList();

	/* removes duplicates from the database */
	void removeDuplicates();

	/* sort the DB using the compareTo method in Student */
	void sort();

	/* undo the previous command */
	boolean undo();

	/* loads serialized file containing DB */
	void loadDB(String filename);

	/* saves serialized file containing DB */
	void saveDB(String filename);
}