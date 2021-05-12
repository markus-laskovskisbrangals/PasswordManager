package lv.frostis.passwordmanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class PasswordGenerator implements ActionListener {
	static JButton genButton;
	static JTextField passField;
	static JSpinner spinner;
	static JCheckBox capitalLetters;
	static JCheckBox numbers;
	static JCheckBox symbols;
	static String userDir = System.getProperty("user.dir");

	PasswordGenerator(JButton genButton, JTextField passField, JSpinner spinner, JCheckBox capitalLetters,
			JCheckBox numbers, JCheckBox symbols) {
		this.genButton = genButton;
		this.passField = passField;
		this.spinner = spinner;
		this.capitalLetters = capitalLetters;
		this.numbers = numbers;
		this.symbols = symbols;
		genButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				generatePassword();
			}

		});
	}

	private void generatePassword() {
		int passLength = (Integer) spinner.getValue();
		String password = "";
		for (int i = 0; i < passLength; i++) {
			int passLetter = (int) (Math.random() * 90) + 33;
			if (checkLetter(passLetter)) {
				password += (char) passLetter;
			} else {
				i--;
			}

		}
		passField.setText(password);
	}

	private boolean checkLetter(int num) {
		if(num >= 65 && num <= 90 && this.capitalLetters.isSelected() || num >= 97 && num <= 122 || 
				num >= 48 && num <= 57 && numbers.isSelected() || (num >= 33 && num <= 47 || 
				num >= 58 && num <= 64 || num >= 91 && num <= 96) && symbols.isSelected()) {
			return true;
		}
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
