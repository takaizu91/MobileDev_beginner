/**
 * @(#)CheckBoxTest.java
 *
 *
 * @author
 * @version 1.00 2014/7/14
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckBoxTest extends JFrame {
	private JTextField field1;
	private JCheckBox bold, italic;

	//set GUI
    public CheckBoxTest() {
    	super ("JCheckBox Test");

    	//get content pane
    	Container container = getContentPane();
    	container.setLayout( new FlowLayout() );

    	//set up JTextField
    	field1 = new JTextField("Hohohoho", 20);
    	field1.setFont( new Font("Serif", Font.PLAIN, 14));
    	container.add(field1);

    	//create checkbox objects
    	bold = new JCheckBox ("Bold");
    	container.add( bold);

    	italic = new JCheckBox ("Italic");
    	container.add( italic);

    	//register listenenr
    	CheckBoxHandler handler = new CheckBoxHandler();
    	bold.addItemListener( handler);
    	italic.addItemListener( handler);

    	setSize( 275, 100);
    	setVisible (true);
    }

    public static void main (String[] args) {
    	CheckBoxTest app = new CheckBoxTest();
    	app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
    }

    //private inner class
    private class CheckBoxHandler implements ItemListener {
    	private int valBold = Font.PLAIN;
    	private int valItalic = Font.PLAIN;

    	public void itemStateChanged( ItemEvent event) {

    		if ( event.getSource() == bold )
    			valBold = bold.isSelected() ? Font.BOLD : Font.PLAIN;

    		if ( event.getSource() == bold )
    			valItalic = italic.isSelected() ? Font.ITALIC : Font.PLAIN;

    		//set text field
    		field1.setFont( new Font( "Serif", valBold + valItalic, 14) );
    	}
    }


}
