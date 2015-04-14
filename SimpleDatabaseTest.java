/**********************************************************************
 * Uses JUnit test cases to test the ISimpleDatabase interface methods
 * in the SimpleDatabase class.
 * 
 * @author Conner Toney
 * @version Winter 2015
 *********************************************************************/
package package1;

import static org.junit.Assert.*;
import org.junit.Test;

public class SimpleDatabaseTest {

	//name containing numbers
	@Test (expected = IllegalArgumentException.class)
	public void testName1() {
		ISimpleDatabase db1 = new SimpleDatabase();
		db1.insert(new Student("12", "123456789", 4.0));
	}

	//name containing special characters
	@Test (expected = IllegalArgumentException.class)
	public void testName2() {
		ISimpleDatabase db1 = new SimpleDatabase();
		db1.insert(new Student("$@", "123456789", 4.0));
	}

	//empty name
	@Test (expected = IllegalArgumentException.class)
	public void testName3() {
		ISimpleDatabase db1 = new SimpleDatabase();
		db1.insert(new Student("", "123456789", 4.0));
	}

	//gnumber containing letters
	@Test (expected = IllegalArgumentException.class)
	public void testGNumber1() {
		ISimpleDatabase db1 = new SimpleDatabase();
		db1.insert(new Student("John", "a", 4.0));
	}

	//empty gnumber
	@Test (expected = IllegalArgumentException.class)
	public void testGNumber2() {
		ISimpleDatabase db1 = new SimpleDatabase();
		db1.insert(new Student("John", "", 4.0));
	}

	//gnumber containing special characters
	@Test (expected = IllegalArgumentException.class)
	public void testGNumber3() {
		ISimpleDatabase db1 = new SimpleDatabase();
		db1.insert(new Student("John", "$@#", 4.0));
	}

	//gnumber with <9 numbers
	@Test (expected = IllegalArgumentException.class)
	public void testGNumber4() {
		ISimpleDatabase db1 = new SimpleDatabase();
		db1.insert(new Student("John", "12345678", 4.0));
	}

	//gnumber with >9 numbers
	@Test (expected = IllegalArgumentException.class)
	public void testGNumber5() {
		ISimpleDatabase db1 = new SimpleDatabase();
		db1.insert(new Student("John", "1234567890", 4.0));
	}

	//gnumber with neg number
	@Test (expected = IllegalArgumentException.class)
	public void testGPA1() {
		ISimpleDatabase db1 = new SimpleDatabase();
		db1.insert(new Student("John", "123456789", -1.0));
	}

	//gnumber with >4 number
	@Test (expected = IllegalArgumentException.class)
	public void testGPA2() {
		ISimpleDatabase db1 = new SimpleDatabase();
		db1.insert(new Student("John", "123456789", 4.01));
	}

	//adding 1 item to list
	@Test
	public void testInsert1() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		db1.insert(new Student("John", "123456789", 4.0));
		db2.insert(new Student("John", "123456789", 4.0));
		assertEquals(db1.toString(), db2.toString());
	}

	//making sure tostring works correctly
	@Test
	public void testInsert2() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		db1.insert(new Student("John", "123456789", 4.0));
		db2.insert(new Student("Joe", "123456789", 4.0));
		assertNotEquals(db1.toString(), db2.toString());
	}

	//adding >1 item to list
	@Test
	public void testInsert3() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		db1.insert(new Student("John", "123456789", 4.0));
		db1.insert(new Student("Joe", "234567890", 3.5));
		db2.insert(new Student("John", "123456789", 4.0));
		db2.insert(new Student("Joe", "234567890", 3.5));
		assertEquals(db1.toString(), db2.toString());
	}

	//making sure tostring works correctly
	@Test
	public void testInsert4() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		db1.insert(new Student("John", "123456789", 4.0));
		db1.insert(new Student("Joe", "234567890", 3.5));
		db2.insert(new Student("John", "123456789", 4.0));
		db2.insert(new Student("Drew", "123456789", 3.5));
		assertNotEquals(db1.toString(), db2.toString());
	}

	//making sure tostring works correctly
	@Test
	public void testInsert5() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		db1.insert(new Student("John", "123456789", 4.0));
		assertNotEquals(db1.toString(), db2.toString());
	}

	//list with 0 items
	@Test
	public void testInsert6() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		assertEquals(db1.toString(), db2.toString());
	}

	//deleting list with 1 item
	@Test
	public void testDelete1() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		db1.insert(new Student("John", "123456789", 4.0));
		db1.delete("123456789");
		assertEquals(db1.toString(), db2.toString());
	}

	//deletion with <9 numbers
	@Test (expected = IllegalArgumentException.class)
	public void testDelete2() {
		ISimpleDatabase db1 = new SimpleDatabase();
		db1.insert(new Student("John", "123456789", 4.0));
		db1.delete("123");
	}

	//deletion with special chars
	@Test (expected = IllegalArgumentException.class)
	public void testDelete3() {
		ISimpleDatabase db1 = new SimpleDatabase();
		db1.insert(new Student("John", "123456789", 4.0));
		db1.delete("$#@");
	}

	//empty deletion
	@Test (expected = IllegalArgumentException.class)
	public void testDelete4() {
		ISimpleDatabase db1 = new SimpleDatabase();
		db1.insert(new Student("John", "123456789", 4.0));
		db1.delete("");
	}

	//deletion with <9 numbers
	@Test (expected = IllegalArgumentException.class)
	public void testDelete5() {
		ISimpleDatabase db1 = new SimpleDatabase();
		db1.insert(new Student("John", "123456789", 4.0));
		db1.delete("12345678");
	}

	//deletion with >10 numbers
	@Test (expected = IllegalArgumentException.class)
	public void testDelete6() {
		ISimpleDatabase db1 = new SimpleDatabase();
		db1.insert(new Student("John", "123456789", 4.0));
		db1.delete("1234567890");
	}

	//deletion of first item in list
	@Test
	public void testDelete7() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		db1.insert(new Student("John", "123456789", 4.0));
		db1.insert(new Student("Joe", "123123123", 3.5));
		db1.insert(new Student("Kyle", "234234234", 2.5));
		db2.insert(new Student("Joe", "123123123", 3.5));
		db2.insert(new Student("Kyle", "234234234", 2.5));
		db1.delete("123456789");
		assertEquals(db1.toString(), db2.toString());
	}

	//deletion of middle item in list
	@Test
	public void testDelete8() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		db1.insert(new Student("John", "123456789", 4.0));
		db1.insert(new Student("Joe", "123123123", 3.5));
		db1.insert(new Student("Kyle", "234234234", 2.5));
		db2.insert(new Student("John", "123456789", 4.0));
		db2.insert(new Student("Kyle", "234234234", 2.5));
		db1.delete("123123123");
		assertEquals(db1.toString(), db2.toString());
	}

	//deletion of last item in list
	@Test
	public void testDelete9() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		db1.insert(new Student("John", "123456789", 4.0));
		db1.insert(new Student("Joe", "123123123", 3.5));
		db1.insert(new Student("Kyle", "234234234", 2.5));
		db2.insert(new Student("John", "123456789", 4.0));
		db2.insert(new Student("Joe", "123123123", 3.5));
		db1.delete("234234234");
		assertEquals(db1.toString(), db2.toString());
	}

	//correct update
	@Test
	public void testUpdate1() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		db1.insert(new Student("John", "123123123", 4.0));
		db2.insert(new Student("Joe", "123123123", 3.5));
		db1.update("123123123", new Student("Joe", "123123123", 3.5));
		assertEquals(db1.toString(), db2.toString());
	}

	//update with letters
	@Test (expected = IllegalArgumentException.class)
	public void testUpdate2() {
		ISimpleDatabase db1 = new SimpleDatabase();
		db1.insert(new Student("John", "123123123", 4.0));
		db1.update("a", new Student("Joe", "123123123", 3.5));
	}

	//update with special characters
	@Test (expected = IllegalArgumentException.class)
	public void testUpdate3() {
		ISimpleDatabase db1 = new SimpleDatabase();
		db1.insert(new Student("John", "123123123", 4.0));
		db1.update("$%#", new Student("Joe", "123123123", 3.5));
	}

	//update with <9 numbers
	@Test (expected = IllegalArgumentException.class)
	public void testUpdate4() {
		ISimpleDatabase db1 = new SimpleDatabase();
		db1.insert(new Student("John", "123123123", 4.0));
		db1.update("12345678", new Student("Joe", "123123123", 3.5));
	}

	//update with >9 numbers
	@Test (expected = IllegalArgumentException.class)
	public void testUpdate5() {
		ISimpleDatabase db1 = new SimpleDatabase();
		db1.insert(new Student("John", "123123123", 4.0));
		db1.update("1234567890", new Student("Joe", "123123123", 3.5));
	}

	//update student that doesn't exist
	@Test
	public void testUpdate6() {
		ISimpleDatabase db1 = new SimpleDatabase();
		db1.insert(new Student("John", "123123123", 4.0));
		assertFalse(db1.update("456456456", 
				new Student("Joe", "456456456", 3.5)));
	}

	//update with empty input
	@Test (expected = IllegalArgumentException.class)
	public void testUpdate7() {
		ISimpleDatabase db1 = new SimpleDatabase();
		db1.insert(new Student("John", "123123123", 4.0));
		db1.update("", new Student("Joe", "123123123", 3.5));
	}

	//tostring with empty list
	@Test
	public void testToString1() {
		ISimpleDatabase db1 = new SimpleDatabase();
		String str = "\nTotal students in database: 0";
		assertEquals(db1.toString(), str);
	}

	//tostring with 1 item list
	@Test
	public void testToString2() {
		ISimpleDatabase db1 = new SimpleDatabase();
		db1.insert(new Student("John", "123123123", 4.0));
		String str = "Name: John GPA: 4.0 GNumber: 123123123";
		str += "\n\n";
		str += "Total students in database: 1";
		assertEquals(db1.toString(), str);
	}

	//tostring with 2 item list
	@Test
	public void testToString3() {
		ISimpleDatabase db1 = new SimpleDatabase();
		db1.insert(new Student("John", "123123123", 4.0));
		db1.insert(new Student("Kyle", "234234234", 3.5));
		String str = "Name: John GPA: 4.0 GNumber: 123123123\n";
		str += "Name: Kyle GPA: 3.5 GNumber: 234234234\n\n";
		str += "Total students in database: 2";
		assertEquals(db1.toString(), str);
	}

	//finding 1st item in list
	@Test
	public void testFind1() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		db1.insert(new Student("John", "123456789", 4.0));
		db1.insert(new Student("Joe", "123123123", 3.5));
		db1.insert(new Student("Kyle", "234234234", 2.5));
		db2.insert(new Student("John", "123456789", 4.0));
		assertEquals(db1.find("123456789").toString(), 
				db2.find("123456789").toString());
	}

	//finding 2nd item in list
	@Test
	public void testFind2() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		db1.insert(new Student("John", "123456789", 4.0));
		db1.insert(new Student("Joe", "123123123", 3.5));
		db1.insert(new Student("Kyle", "234234234", 2.5));
		db2.insert(new Student("Joe", "123123123", 3.5));
		assertEquals(db1.find("123123123").toString(), 
				db2.find("123123123").toString());
	}

	//finding last item in list
	@Test
	public void testFind3() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		db1.insert(new Student("John", "123456789", 4.0));
		db1.insert(new Student("Joe", "123123123", 3.5));
		db1.insert(new Student("Kyle", "234234234", 2.5));
		db2.insert(new Student("Kyle", "234234234", 2.5));
		assertEquals(db1.find("234234234").toString(), 
				db2.find("234234234").toString());
	}

	//finding empty input
	@Test (expected = IllegalArgumentException.class)
	public void testFind4() {
		ISimpleDatabase db1 = new SimpleDatabase();
		db1.insert(new Student("John", "123123123", 4.0));
		db1.find("");
	}

	//finding input with letters
	@Test (expected = IllegalArgumentException.class)
	public void testFind5() {
		ISimpleDatabase db1 = new SimpleDatabase();
		db1.insert(new Student("John", "123123123", 4.0));
		db1.find("a");
	}

	//finding input with special characters
	@Test (expected = IllegalArgumentException.class)
	public void testFind6() {
		ISimpleDatabase db1 = new SimpleDatabase();
		db1.insert(new Student("John", "123123123", 4.0));
		db1.find("$3@");
	}

	//finding input with <9 numbers
	@Test (expected = IllegalArgumentException.class)
	public void testFind7() {
		ISimpleDatabase db1 = new SimpleDatabase();
		db1.insert(new Student("John", "123123123", 4.0));
		db1.find("12345678");
	}

	//finding input with >9 numbers
	@Test (expected = IllegalArgumentException.class)
	public void testFind8() {
		ISimpleDatabase db1 = new SimpleDatabase();
		db1.insert(new Student("John", "123123123", 4.0));
		db1.find("1234567890");
	}

	//reverse empty list
	@Test
	public void testReverse1() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		db1.reverseList();
		assertEquals(db1.toString(), db2.toString());
	}

	//reversing list with 1 item
	@Test
	public void testReverse2() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		db1.insert(new Student("John", "123123123", 4.0));
		db2.insert(new Student("John", "123123123", 4.0));
		db1.reverseList();
		assertEquals(db1.toString(), db2.toString());
	}

	//reversing 2 item list
	@Test
	public void testReverse3() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		db1.insert(new Student("John", "123123123", 4.0));
		db1.insert(new Student("Kyle", "234234234", 3.5));
		db2.insert(new Student("Kyle", "234234234", 3.5));
		db2.insert(new Student("John", "123123123", 4.0));
		db1.reverseList();
		assertEquals(db1.toString(), db2.toString());
	}

	//reversing 3 item list
	@Test
	public void testReverse4() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		db1.insert(new Student("John", "123123123", 4.0));
		db1.insert(new Student("Kyle", "234234234", 3.5));
		db1.insert(new Student("Joe", "345345345", 2.5));
		db2.insert(new Student("Joe", "345345345", 2.5));
		db2.insert(new Student("Kyle", "234234234", 3.5));
		db2.insert(new Student("John", "123123123", 4.0));
		db1.reverseList();
		assertEquals(db1.toString(), db2.toString());
	}
	//remove duplicates in empty list
	@Test
	public void testRemoveDuplicates1() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		db1.removeDuplicates();
		assertEquals(db1.toString(), db2.toString());
	}

	//remove duplicates with 1 item list
	@Test
	public void testRemoveDuplicates2() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		db1.insert(new Student("John", "123123123", 4.0));
		db2.insert(new Student("John", "123123123", 4.0));
		db1.removeDuplicates();
		assertEquals(db1.toString(), db2.toString());
	}

	//remove duplicates in 2 item list
	@Test
	public void testRemoveDuplicates3() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		db1.insert(new Student("John", "123123123", 4.0));
		db1.insert(new Student("Joe", "123123123", 3.5));
		db2.insert(new Student("John", "123123123", 4.0));
		db1.removeDuplicates();
		assertEquals(db1.toString(), db2.toString());
	}

	//remove duplicates in 3 item list
	@Test
	public void testRemoveDuplicates4() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		db1.insert(new Student("John", "123123123", 4.0));
		db1.insert(new Student("Joe", "123123123", 3.5));
		db1.insert(new Student("John", "123123123", 2.6));
		db2.insert(new Student("John", "123123123", 2.6));
		db1.removeDuplicates();
		assertEquals(db1.toString(), db2.toString());
	}

	//making sure correct duplicate is removed
	@Test
	public void testRemoveDuplicates5() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		db1.insert(new Student("Joe", "123123123", 4.0));
		db1.insert(new Student("John", "123123123", 3.5));
		db2.insert(new Student("John", "123123123", 4.0));
		db1.removeDuplicates();
		assertNotEquals(db1.toString(), db2.toString());
	}

	//sorting empty list
	@Test
	public void testSort1() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		db1.sort();
		assertEquals(db1.toString(), db2.toString());
	}

	//sorting list with 1 item
	@Test
	public void testSort2() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		db1.insert(new Student("John", "123123123", 4.0));
		db2.insert(new Student("John", "123123123", 4.0));
		db1.sort();
		assertEquals(db1.toString(), db2.toString());
	}

	//sorting 2 item list
	@Test
	public void testSort3() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		db1.insert(new Student("John", "123123123", 4.0));
		db1.insert(new Student("Joe", "234234234", 3.5));
		db2.insert(new Student("Joe", "234234234", 3.5));
		db2.insert(new Student("John", "123123123", 4.0));
		db1.sort();
		assertEquals(db1.toString(), db2.toString());
	}

	//sorting already sorted list
	@Test
	public void testSort4() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		db1.insert(new Student("John", "123123123", 4.0));
		db1.insert(new Student("Marty", "234234234", 3.5));
		db2.insert(new Student("John", "123123123", 4.0));
		db2.insert(new Student("Marty", "234234234", 3.5));
		db1.sort();
		assertEquals(db1.toString(), db2.toString());
	}

	//sorting 3 item list
	@Test
	public void testSort5() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		db1.insert(new Student("John", "123123123", 4.0));
		db1.insert(new Student("Aaron", "234234234", 3.5));
		db1.insert(new Student("Chris", "345345345", 2.1));
		db2.insert(new Student("Aaron", "234234234", 3.5));
		db2.insert(new Student("Chris", "345345345", 2.1));
		db2.insert(new Student("John", "123123123", 4.0));
		db1.sort();
		assertEquals(db1.toString(), db2.toString());
	}

	//making sure comparison is correct
	@Test
	public void testSort7() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		db1.insert(new Student("John", "123123123", 4.0));
		db1.insert(new Student("Marty", "234234234", 3.5));
		db2.insert(new Student("Marty", "234234234", 3.5));
		db1.sort();
		assertNotEquals(db1.toString(), db2.toString());
	}

	//saving/loading empty list
	@Test
	public void testSaveLoadDB1() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		db1.saveDB("testSaveLoad");
		db1 = new SimpleDatabase();
		db1.loadDB("testSaveLoad");
		assertEquals(db1.toString(), db2.toString());
	}

	//saving/loading list with item
	@Test
	public void testSaveLoadDB2() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		db1.insert(new Student("John", "123123123", 4.0));
		db2.insert(new Student("John", "123123123", 4.0));
		db1.saveDB("testSaveLoad");
		db1 = new SimpleDatabase();
		db1.loadDB("testSaveLoad");
		assertEquals(db1.toString(), db2.toString());
	}

	//saving/loading list with 2 items
	@Test
	public void testSaveLoadDB3() {
		ISimpleDatabase db1 = new SimpleDatabase();
		ISimpleDatabase db2 = new SimpleDatabase();
		db1.insert(new Student("John", "123123123", 4.0));
		db1.insert(new Student("Alex", "234234234", 3.5));
		db2.insert(new Student("John", "123123123", 4.0));
		db2.insert(new Student("Alex", "234234234", 3.5));
		db1.saveDB("testSaveLoad");
		db1 = new SimpleDatabase();
		db1.loadDB("testSaveLoad");
		assertEquals(db1.toString(), db2.toString());
	}
}
