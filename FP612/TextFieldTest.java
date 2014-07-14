/**
 * @(#)TextFieldTest.java
 *
 *
 * @author
 * @version 1.00 2014/7/14
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextFieldTest extends JFrame {
	private JTextField tField1, tField2, tField3;
	private JPasswordField pField;

	//GUI section
    public TextFieldTest() {
    	super ("Test out JTextField and JPasswordField");

    	Container container = getContentPane();
    	container.setLayout( new FlowLayout());

    	//tField with default size
    	tField1 = new JTextField(10);
    	container.add(tField1);

    	//tField with default text
    	tField2 = new JTextField("Enter something here");
    	container.add(tField2);

    	//20 visible element - no event handler
    	tField3 = new JTextField("Uneditable text field", 20);
    	tField3.setEditable(false);
    	container.add(tField3);

    	//pField with default text
    	pField = new JPasswordField("Hidden text");
    	container.add(pField);

    	//register event handlers
    	TextFieldHandler handler = new TextFieldHandler();
    	tField1.addActionListener(handler);
    	tField2.addActionListener(handler);
    	tField3.addActionListener(handler);
    	pField.addActionListener(handler);

    	setSize( 350, 125);
    	setVisible(true);
    }

    public static void main (String[] args) {
    	TextFieldTest app = new TextFieldTest();
    	app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //private inner class for event handling
    private class TextFieldHandler implements ActionListener {

    	//process textfield events
    	public void actionPerformed(ActionEvent event) {

    		String string = "";

    		//user pressed enter in tField1
    		if (event.getSource() == tField1)
    			string = "tField1: " + event.getActionCommand();

    		//user pressed enter in tField2
    		else if (event.getSource() == tField2)
    			string = "tField2: " + event.getActionCommand();

    		//user pressed enter in tField3
    		else if (event.getSource() == tField3)
    			string = "tField3: " + event.getActionCommand();

    		//user pressed enter in tField1
    		else if (event.getSource() == pField) {

    			string = "pField: " + new String(pField.getPassword() );
    		}

    		JOptionPane.showMessageDialog( null, string);
    	}
    }

}
