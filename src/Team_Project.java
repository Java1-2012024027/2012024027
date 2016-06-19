import java.awt.event.ActionEvent;

public class Team_Project {
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.charAt(0) == 'C') {
			startOfNumber = true;
			result = 0;
			operator = "=";
			display.setText("0.0");
		} else if (command.charAt(0) >= '0' && command.charAt(0) <= '9' || command.equals(".")) {
			if (startOfNumber == true)
				display.setText(command);
			else
				display.setText(display.getText() + command);
			startOfNumber = false;
		} else {
			if (startOfNumber) {
				if (command.equals("-")) {
					display.setText(command);
					startOfNumber = false;
				} else
					operator = command;
			} else {
				double x = Double.parseDouble(display.getText());
				calculate(x);
				operator = command;
				startOfNumber = true;
			}
		}
	}

	private void calculate(double n) {
		if (operator.equals("+"))
			result += n;
		else if (operator.equals("-"))
			result -= n;
		else if (operator.equals("*"))
			result *= n;
		else if (operator.equals("/"))
			result /= n;
		else if (operator.equals("="))
			result = n;
		display.setText(" " + result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator s = new Calculator();
	}

}
