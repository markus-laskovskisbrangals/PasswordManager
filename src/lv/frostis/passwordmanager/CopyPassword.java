package lv.frostis.passwordmanager;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class CopyPassword implements ActionListener{
	static JTextField passwordField;
	static JButton copyButton;
	
	CopyPassword(JTextField passwordField, JButton copyButton){
		this.passwordField = passwordField;
		this.copyButton = copyButton;
		
		copyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String password = passwordField.getText();
				StringSelection selection = new StringSelection(password);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(selection, null);
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
	}
	
}
