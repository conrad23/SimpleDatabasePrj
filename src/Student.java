/**********************************************************************
 * The Student object contains the student's name, gnumber, and GPA.
 * It also has ways to access/set that information.
 * 
 * @author Conner Toney
 * @version Winter 2015
 *********************************************************************/

package package1;

import java.io.Serializable;

public class Student implements Serializable{

	/* default serial ID */
	private static final long serialVersionUID = 1L;

	/* name of student */
	private String name;

	/* gnumber of student */
	private String gNumber;

	/* gpa of student */
	private double gpa;

	/******************************************************************
	 * Default constructor creates student object with a given name,
	 * gnumber, and gpa.
	 * @param name input student name
	 * @param gNumber input student gnumber
	 * @param gpa input student gpa
	 *****************************************************************/
	public Student(String name, String gNumber, double gpa) {
		if (gNumber.length() != 9 || !gNumber.matches("[0-9]+"))
			throw new IllegalArgumentException();
		if (!name.matches("[a-zA-Z]+") || name.length() == 0)
			throw new IllegalArgumentException();
		if (gpa > 4.0 || gpa < 0.0)
			throw new IllegalArgumentException();
		this.name = name;
		this.gNumber = gNumber;
		this.gpa = gpa;
	}

	/******************************************************************
	 * Gets the student's name.
	 * @return name of student
	 *****************************************************************/
	public String getName() {
		return name;
	}

	/******************************************************************
	 * Sets the name of the student.
	 * @param name name of student
	 *****************************************************************/
	public void setName(String name) {
		this.name = name;
	}

	/******************************************************************
	 * Gets the gnumber of the student.
	 * @return gnumber of student
	 *****************************************************************/
	public String getGNumber() {
		return gNumber;
	}

	/******************************************************************
	 * Sets the gnumber of the student.
	 * @param gNumber gnumber of student
	 *****************************************************************/
	public void setGNumber(String gNumber) {
		this.gNumber = gNumber;
	}

	/******************************************************************
	 * Gets the GPA of the student.
	 * @return gpa of student
	 *****************************************************************/
	public double getGPA() {
		return gpa;
	}

	/******************************************************************
	 * Sets the GPA of the student.
	 * @param gpa gpa of student
	 *****************************************************************/
	public void setGPA(double gpa) {
		this.gpa = gpa;
	}

	/******************************************************************
	 * Creates a string representation of the student object.
	 * @return string representation of Student
	 *****************************************************************/
	public String toString() {
		String str = "";
		str += ("Name: " + name);
		str += (" GPA: " + gpa);
		str += (" GNumber: " + gNumber);
		return str;
	}
}