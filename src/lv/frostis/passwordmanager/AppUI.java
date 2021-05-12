package lv.frostis.passwordmanager;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class AppUI extends JPanel{
	static int width = AppWindow.WINDOW_WIDTH;
	static int height = AppWindow.WINDOW_HEIGHT;
	static JButton generateButton = createButton("Generate password", 20, 195, 255, 40);
	static JButton copyPassword = createButton("Copy to clipboard", 355, 315, 155, 30);
	static JTextField passwordField = createTextBox(1, false, 20, 315, 330, 30);
	static JSpinner spinner = createSpinner(8, 4, 128, 1, 125, 75, 45, 20);
	static JCheckBox capitalLetters = createCheckBox("Include capitalized letters", 20, 110, 250, 20);
	static JCheckBox numbers = createCheckBox("Include numbers", 20, 160, 250, 20);
	static JCheckBox symbols = createCheckBox("Include special symbols", 20, 135, 250, 20);
	
	AppUI(){
		this.setBounds(0, 0, width, height);
		this.setBackground(new Color(50, 50, 50));
		this.setLayout(null);
		this.add(createText("Generate new password", 20, 20, 150, 20));
		this.add(createText("Password name:", 20, 50, 150, 20));
		this.add(createText("Password length:", 20, 75, 150, 20));
		this.add(createTextBox(1, true, 125, 50, 150, 20));
		this.add(spinner);
		this.add(capitalLetters);
		this.add(symbols);
		this.add(numbers);
		this.add(generateButton);
		this.add(createText("Manage passwords", 310, 20, 150, 20));
		this.add(createButton("Retreive password", 310, 50, 200, 35));
		this.add(createButton("Regenerate password", 310, 100, 200, 35));
		this.add(createButton("Show all passwords", 310, 150, 200, 35));
		this.add(createButton("Delete all passwords", 310, 200, 200, 35));
		this.add(createText("Password:", 20, 290, 150, 20));
		this.add(passwordField);
		this.add(copyPassword);
		new PasswordGenerator(generateButton, passwordField, spinner, capitalLetters, numbers, symbols);
		new CopyPassword(passwordField, copyPassword);
	}
	
	private static JButton createButton(String name, int x, int y, int width, int height) {
		JButton button = new JButton(name);
		button.setBounds(x, y, width, height);
		return button;
	}
	
	private static JLabel createText(String text, int x, int y, int width, int height) {
		JLabel label = new JLabel(text);
		label.setForeground(new Color(250, 250, 250));
		label.setBounds(x, y, width, height);
		return label;
	}
	
	private static JTextField createTextBox(int columns, boolean editable, int x, int y, int width, int height) {
		JTextField textArea = new JTextField(columns);
		textArea.setEditable(editable);
		textArea.setBounds(x, y, width, height);
		return textArea;
	}
	
	private static JSpinner createSpinner(int defaultVal, int minVal, int maxVal, int step, int x, int y, int width, int height) {
		SpinnerModel value = new SpinnerNumberModel(defaultVal, minVal, maxVal, step);
		JSpinner spinner = new JSpinner(value);
		spinner.setBounds(x, y, width, height);
		return spinner;
	}
	
	private static JCheckBox createCheckBox(String text, int x, int y, int width, int height) {
		JCheckBox box = new JCheckBox(text);
		box.setBackground(new Color(50, 50, 50));
		box.setForeground(new Color(250, 250, 250));
		box.setBounds(x, y, width, height);
		return box;
	}
}
