//accumulator class
import java.awt.*;
import java.awt.event.*;
//inherit frame and all of its properties
public class Accumulator extends Frame {
	private TextField tfInput;
	private TextField tfOutput;
	private int square = 0;
public Accumulator () {
		setLayout(new GridLayout(2,2));

		add(new Label("Enter an integer"));

		tfInput = new TextField(10);
		add(tfInput);

		tfInput.addActionListener(new TFInputListener());

		add(new Label("The square is: "));

		tfOutput=new TextField(10);
		tfOutput.setEditable(false);
		add(tfOutput);

		setTitle("AWT Accumulatooor");
		setSize(350, 150);
		setVisible(true);
	
	}

public static void main (String[] args) {
	//executes everything initialized in the constructor
	new Accumulator();
	}

private class TFInputListener implements ActionListener {
	@Override //don't understand why
	public void actionPerformed(ActionEvent evt){
		int numberIn = Integer.parseInt(tfInput.getText());
		square = numberIn * numberIn;
		tfInput.setText(""); //clear input field
		tfOutput.setText(square + ""); //convert int to string
		}
	}

}
