package lv.frostis.passwordmanager;

import javax.swing.JFrame;

public class AppWindow extends JFrame {
	
	static String appTitle = "Password Manager v0.0.1a";
	static final int WINDOW_WIDTH = 550;
	static final int WINDOW_HEIGHT = 400;
	
	AppWindow(){
		this.setTitle(appTitle);
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new AppUI());
		this.setVisible(true);
	}
	
}
