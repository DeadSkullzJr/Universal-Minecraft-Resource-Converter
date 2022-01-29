package bjtmastermind.umrc.program.display;

import javax.swing.JDialog;
import javax.swing.JTextPane;

import bjtmastermind.umrc.program.Main;

@SuppressWarnings("serial")
public class Dialog extends JDialog {
	
	static JTextPane msgText;
	
	public Dialog() {
		setTitle("Message");
		setBounds(100, 100, 325, 70);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

		msgText = new JTextPane();
		msgText.setEditable(false);
		add(msgText);
		pack();
	}
	
	public static void pickOne() {
		msgText.setText("You must pick one to continue.");
	}
	
	public static void convertDone() {
		msgText.setText("Convertsion from "+Main.FromPack+" to "+Main.ToPack+" is finished!");
	}
}
