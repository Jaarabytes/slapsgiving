import java.awt.*;
import java.awt.event.*;

//GUI component that countsdown days, hours, minutes and seconds to 2100 hours, thanksgiving
//create a class that inherits all properties from frame
public class SlapsGiving extends Frame {
	//initialize variables
	private Label lblCount;
	private TextField txtCount;
	private Button btnCount;
	private int count = 0;

	//constructor to setup components and event handlers
	public SlapsGiving () {
	//components flow from left to right
	setLayout(new FlowLayout());		
	lblCount = new Label("Counter");
	add(lblCount);

	txtCount = new TextField(count + "" + 10);
	txtCount.setEditable(false); //read-only
	add(txtCount);

	btnCount = new Button("Count");
	add(btnCount);

	btnCount.addActionListener(new BtnCountListener());

	setTitle("AWT counter");
	setSize(300, 100);


	setVisible(true);
	}

	public static void main (String[] args) {
	SlapsGiving app = new SlapsGiving();
	}

	//inner class that handles the Count button click;
	private class BtnCountListener implements ActionListener {
	@Override
	public void actionPerformed (ActionEvent evt) {
	++count; //pre-counts are better than post-counts
	txtCount.setText(count + ""); //Convert int to String
	}
	}
}
