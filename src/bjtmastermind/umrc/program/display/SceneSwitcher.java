package bjtmastermind.umrc.program.display;

import bjtmastermind.umrc.program.Main;

public class SceneSwitcher extends Main {

	public static void convertFrom() {
		Display.platformText.setText("Pick The Pack Format To Convert From");

		Display.javareicon2.setVisible(false);
		Display.javatxicon2.setVisible(false);
		Display.bedrockicon2.setVisible(false);
		Display.javareicon2.setEnabled(true);
		Display.javatxicon2.setEnabled(true);
		Display.bedrockicon2.setEnabled(true);
		
		Display.javareicon.setVisible(true);
		Display.javatxicon.setVisible(true);
		Display.bedrockicon.setVisible(true);		
		Display.javareicon.setEnabled(true);
		Display.javatxicon.setEnabled(true);
		Display.bedrockicon.setEnabled(true);

		Display.instructions.setText("<html>[Instructions]: To start what you want to do is click the icon to convert from.</html>");
		Display.instructions.setBounds(99, 163, 342, 36);
		
		Display.example.setText("<html>[Example]: If you want to convert a Java Resource Pack to a Java Texture Pack you will want to click the icon that says 'Resource Pack'</html>");
		Display.example.setBounds(99, 210, 342, 72);
		
		Display.back.setVisible(false);
		Display.Continue.setVisible(false);

		Display.frame.invalidate();
		Display.frame.validate();
		Display.frame.repaint();
	}

	public static void convertTo() {
		Display.platformText.setText("Pick The Pack Format To Convert To");
		
		if(FromType == 1) {
			Display.javareicon.setVisible(false);
			Display.javatxicon.setVisible(false);
			Display.bedrockicon.setVisible(false);
			Display.javareicon2.setVisible(true);
			Display.javatxicon2.setVisible(true);
			Display.bedrockicon2.setVisible(true);
			Display.javareicon2.setEnabled(false);
		} else if(FromType == 2) {
			Display.javareicon.setVisible(false);
			Display.javatxicon.setVisible(false);
			Display.bedrockicon.setVisible(false);
			Display.javareicon2.setVisible(true);
			Display.javatxicon2.setVisible(true);
			Display.bedrockicon2.setVisible(true);
			Display.javatxicon2.setEnabled(false);
		} else if(FromType == 3) {
			Display.javareicon.setVisible(false);
			Display.javatxicon.setVisible(false);
			Display.bedrockicon.setVisible(false);
			Display.javareicon2.setVisible(true);
			Display.javatxicon2.setVisible(true);
			Display.bedrockicon2.setVisible(true);
			Display.bedrockicon2.setEnabled(false);
		}

		Display.instructions.setText("<html>[Instructions]: Click the icon of the platform you want your pack to work for, find the pack your converting from, press the 'Continue' button so the program can convert a copy of it.</html>");
		Display.instructions.setBounds(99, 163, 332, 90);
		
		Display.example.setText("<html>[Example]: If you want to convert a Java Resource Pack to a Java Texture Pack you will want to click the icon that says 'Texture Pack' then find the Resource Pack.</html>");
		Display.example.setBounds(99, 264, 342, 90);

		Display.back.setVisible(true);
		Display.Continue.setVisible(true);

		Display.frame.invalidate();
		Display.frame.validate();
		Display.frame.repaint();
	}

	public static void converted() {
		Display.platformText.setText("Your Pack Has Been Converted");
		Display.platformText.setBounds(120, 11, 370, 50);

		Display.javareicon2.setVisible(false);
		Display.javatxicon2.setVisible(false);
		Display.bedrockicon2.setVisible(false);
		Display.instructions.setVisible(false);
		Display.example.setVisible(false);
		Display.back.setVisible(false);
		Display.Continue.setVisible(false);
		
		Display.from.setVisible(true);
		Display.from.setText("From:  " + Main.FromPack);
		Display.to.setVisible(true);
		Display.to.setText("To:  " + Main.ToPack);
		Display.filename.setVisible(true);
		if (FromType == 2 && Main.ToType == 1) {
			Display.filename.setText("<html>Path: " + file + ".zip</html>");
		} else if (FromType == 2 && Main.ToType == 3) {
			Display.filename.setText("<html>Path: " + file + ".zip</html>");
		} else {
			Display.filename.setText("<html>Path: " + file + "</html>");
		}

		Display.frame.invalidate();
		Display.frame.validate();
		Display.frame.repaint();
	}
}
