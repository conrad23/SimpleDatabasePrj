/**********************************************************************
 * Creates the actual database used to contain student information.
 * 
 * @author Conner Toney
 * @version Winter 2015
 *********************************************************************/

package package1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SimpleDatabasePanel extends JPanel
implements ActionListener{

	/* default serial ID */
	private static final long serialVersionUID = 1L;

	/* the panel located at the top */
	private JPanel northPanel;

	/* prompts for name */
	private JLabel nameLbl;

	/* used to parse for name */
	private JTextArea nameTxt;

	/* prompts for gnumber */
	private JLabel gNumberLbl;

	/* used to parse for gnumber */
	private JTextArea gNumberTxt;

	/* prompts for gpa */
	private JLabel gpaLbl;

	/* used to parse for gpa */
	private JTextArea gpaTxt;

	/* placeholder label */
	private JLabel blankLbl1;

	/* placeholder label */
	private JLabel blankLbl2;

	/* inserts student */
	private JButton insertBtn;

	/* deletes student */
	private JButton deleteBtn;

	/* finds student */
	private JButton findBtn;

	/* reverses list */
	private JButton reverseBtn;

	/* removes duplicates */
	private JButton duplicateBtn;

	/* displays database */
	private JButton displayBtn;

	/* loads database */
	private JButton loadBtn;

	/* saves database */
	private JButton saveBtn;

	/* the panel located at the bottom */
	private JPanel southPanel;

	/* allows scrolling ability */
	private JScrollPane scrollPane;

	/* area where database info can be displayed */
	private JTextArea displayArea;

	/* generic simpledatabase object */
	private SimpleDatabase db;

	/******************************************************************
	 * Default constructor creates layout and adds corresponding
	 * objects to the correct positions.
	 *****************************************************************/
	public SimpleDatabasePanel() {
		db = new SimpleDatabase();
		northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(4, 4));
		nameLbl = new JLabel("Name: ");
		nameTxt = new JTextArea();
		gNumberLbl = new JLabel("G Number: ");
		gNumberTxt = new JTextArea();
		gpaLbl = new JLabel("GPA: ");
		gpaTxt = new JTextArea();
		blankLbl1 = new JLabel();
		blankLbl2 = new JLabel();
		insertBtn = new JButton("Insert");
		deleteBtn = new JButton("Delete");
		findBtn = new JButton("Find");
		reverseBtn = new JButton("Reverse");
		duplicateBtn = new JButton("Duplicate");
		displayBtn = new JButton("Display");
		loadBtn = new JButton("Load");
		saveBtn = new JButton("Save");
		northPanel.add(nameLbl);
		northPanel.add(nameTxt);
		northPanel.add(insertBtn);
		insertBtn.addActionListener(this);
		northPanel.add(deleteBtn);
		deleteBtn.addActionListener(this);
		northPanel.add(gNumberLbl);
		northPanel.add(gNumberTxt);
		northPanel.add(findBtn);
		findBtn.addActionListener(this);
		northPanel.add(reverseBtn);
		reverseBtn.addActionListener(this);
		northPanel.add(gpaLbl);
		northPanel.add(gpaTxt);
		northPanel.add(duplicateBtn);
		duplicateBtn.addActionListener(this);
		northPanel.add(displayBtn);
		displayBtn.addActionListener(this);
		northPanel.add(blankLbl1);
		northPanel.add(blankLbl2);
		northPanel.add(loadBtn);
		loadBtn.addActionListener(this);
		northPanel.add(saveBtn);
		saveBtn.addActionListener(this);


		southPanel = new JPanel();
		displayArea = new JTextArea(10, 50);
		southPanel.add(displayArea);
		scrollPane = new JScrollPane(southPanel);

		setLayout(new GridLayout(2, 1));
		add(northPanel);
		add(scrollPane);
	}

	/******************************************************************
	 * Determines which course of action to follow based upon which
	 * button has been selected.
	 * @param e the input action event
	 *****************************************************************/
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == insertBtn) {
			try {
				String pName;
				String pGNumber;
				double pGPA;
				
				pName = nameTxt.getText();
				pGNumber = gNumberTxt.getText();
				pGPA = Double.parseDouble(gpaTxt.getText());
				db.insert(new Student(pName, pGNumber, pGPA));
				
				//resets JTextAreas to empty
				nameTxt.setText("");
				gNumberTxt.setText("");
				gpaTxt.setText("");
			} catch(IllegalArgumentException ex) {
				JOptionPane.showMessageDialog(null, "Incorrect input!");
			}
		}
		if (e.getSource() == deleteBtn) {
			try {
				String pGNumber;
				pGNumber = gNumberTxt.getText();
				db.delete(pGNumber);
				
				//resets JTextAreas to empty
				nameTxt.setText("");
				gNumberTxt.setText("");
				gpaTxt.setText("");
			} catch(IllegalArgumentException ex) {
				JOptionPane.showMessageDialog(null, "Incorrect input!");
			}
		}
		if (e.getSource() == findBtn) {
			try {
				String pGNumber;
				pGNumber = gNumberTxt.getText();
				displayArea.setText(db.find(pGNumber).toString());
				
				//resets JTextAreas to empty
				nameTxt.setText("");
				gNumberTxt.setText("");
				gpaTxt.setText("");
			} catch(IllegalArgumentException ex) {
				JOptionPane.showMessageDialog(null, "Incorrect input!");
			}
		}
		if (e.getSource() == reverseBtn) {
			try {
				db.reverseList();
			} catch(IllegalArgumentException ex) {
				JOptionPane.showMessageDialog(null, "Incorrect input!");
			}
		}
		if (e.getSource() == duplicateBtn) {
			try {
				db.removeDuplicates();
			} catch(IllegalArgumentException ex) {
				JOptionPane.showMessageDialog(null, "Incorrect input!");
			}
		}
		if (e.getSource() == displayBtn) {
			displayArea.setText(db.toString());
		}
		if (e.getSource() == loadBtn) {
			db.loadDB("studentDB.txt");
		}
		if (e.getSource() == saveBtn) {
			db.saveDB("studentDB.txt");
		}
	}
}