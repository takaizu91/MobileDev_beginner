/**
 * @(#)ListTest.java
 *
 *
 * @author
 * @version 1.00 2014/7/14
 */
import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListTest extends JFrame {
	private JList colorList;
	private Container container;

	private final String colorNames[] = { "Black", "Blue", "Cyan", "Dark Gery", "Grey", "Green", "Light Grey", "Magenta", "Orange", "Pink", "Red", "White", "Yellow" };

	private final Color colors[] = { Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW };

	//set GUI
    public ListTest() {
    	super("List Test");

    	//get content pane and set layout
    	container = getContentPane();
    	container.setLayout(new FlowLayout() );

    	//create a list with items in colorNames array
    	colorList = new JList(colorNames);
    	colorList.setVisibleRowCount(5);

    	//not allow multiple selection
    	colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    	//add JScrollPane contain JList to content pane
    	container.add( new JScrollPane( colorList));
    	colorList.addListSelectionListener(
    		new ListSelectionListener() { //inner class
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    			//handle list selection events
    			public void valueChanged(ListSelectionEvent event) {
    				container.setBackground ( colors [ colorList.getSelectedIndex() ]);
    			}
    		} //end inner class

    	); //end call to addListSelectionListener

    	setSize(350, 150);
    	setVisible( true);
    }

    public static void main (String args[]) {
    	ListTest app = new ListTest();
    	app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
    }
}
