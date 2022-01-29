package bjtmastermind.umrc.program.display;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import bjtmastermind.umrc.program.Main;
import bjtmastermind.umrc.program.fileManipulation.Convert;

public class Display {
	public static JFileChooser fc = new JFileChooser();
	public static JFrame frame;
	static JLabel platformText, javareicon, javatxicon, bedrockicon, instructions, example, from, to, filename, javareicon2, javatxicon2, bedrockicon2;
	static JButton back, Continue;

	public static void createWindow() {
		frame = new JFrame("Universal Minecraft Resource Converter");
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 546, 459);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		populateWindow();
	}
	
	private static void populateWindow() {
		platformText = new JLabel("Pick The Pack Format To Convert From");
		platformText.setForeground(Color.WHITE);
		platformText.setFont(new Font("Minecraftia", Font.PLAIN, 14));
		platformText.setBounds(85, 11, 370, 50);
		frame.getContentPane().add(platformText);
		
		javareicon = new JLabel("<html>Resource Pack</html>");
		javareicon.setForeground(Color.WHITE);
		javareicon.setBounds(123, 80, 80, 66);
		javareicon.setToolTipText("Java Resource Pack");
		ImageIcon reicon = new ImageIcon(Display.class.getClassLoader().getResource("icons/javarepk.png"));
		Image img = reicon.getImage();
		Image img1 = img.getScaledInstance(javareicon.getWidth(), javareicon.getHeight(), Image.SCALE_SMOOTH);
		reicon = new ImageIcon(img1);
		javareicon.setIcon(reicon);
		javareicon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.FromType = 1;
				Main.FromPack = "Java Resource Pack";
				SceneSwitcher.convertTo();
			}
		});
		javareicon.setVisible(true);
		frame.getContentPane().add(javareicon);
		
		javareicon2 = new JLabel("<html>Resource Pack</html>");
		javareicon2.setForeground(Color.WHITE);
		javareicon2.setBounds(123, 80, 80, 66);
		javareicon2.setToolTipText("Java Resource Pack");
		ImageIcon reicon2 = new ImageIcon(Display.class.getClassLoader().getResource("icons/javarepk.png"));
		Image img2 = reicon.getImage();
		Image img3 = img2.getScaledInstance(javareicon2.getWidth(), javareicon2.getHeight(), Image.SCALE_SMOOTH);
		reicon2 = new ImageIcon(img3);
		javareicon2.setIcon(reicon2);
		javareicon2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (Main.FromType == 2) {
					FileNameExtensionFilter filter = new FileNameExtensionFilter("Minecraft Texture Pack (*.zip)","zip");
					fc.setFileFilter(filter);
					fc.setAcceptAllFileFilterUsed(false);
					if (e.getSource() == javareicon2) {
						Main.returnVal = fc.showOpenDialog(null);
						if (Main.returnVal == JFileChooser.APPROVE_OPTION) {
							Main.ToType = 1;
							Main.ToPack = "Java Resource Pack";
							Main.file = fc.getSelectedFile();
						}
					}
				} else if (Main.FromType == 3) {
					FileNameExtensionFilter filter = new FileNameExtensionFilter("Minecraft Bedrock Texture Pack (directory, *.zip, *.mcpack)", "zip", "mcpack");
					fc.setFileFilter(filter);
					fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					fc.setAcceptAllFileFilterUsed(false);
					if (e.getSource() == javareicon2) {
						Main.returnVal = fc.showOpenDialog(null);
						if (Main.returnVal == JFileChooser.APPROVE_OPTION) {
							Main.ToType = 1;
							Main.ToPack = "Java Resource Pack";
							Main.file = fc.getSelectedFile();
						}
					}
				}
			}
		});
		javareicon2.setVisible(false);
		frame.getContentPane().add(javareicon2);
		
		javatxicon = new JLabel("<html>Texture Pack</html>");
		javatxicon.setForeground(Color.WHITE);
		javatxicon.setBounds(230, 80, 80, 66);
		javatxicon.setToolTipText("Java Texture Pack");
		ImageIcon txicon = new ImageIcon(Display.class.getClassLoader().getResource("icons/javatxpk.png"));
		Image img4 = txicon.getImage();
		Image img5 = img4.getScaledInstance(javatxicon.getWidth(), javatxicon.getHeight(), Image.SCALE_SMOOTH);
		txicon = new ImageIcon(img5);
		javatxicon.setIcon(txicon);
		javatxicon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.FromType = 2;
				Main.FromPack = "Java Texture Pack";
				SceneSwitcher.convertTo();
			}
		});
		javatxicon.setVisible(true);
		frame.getContentPane().add(javatxicon);
		
		javatxicon2 = new JLabel("<html>Texture Pack</html>");
		javatxicon2.setForeground(Color.WHITE);
		javatxicon2.setBounds(230, 80, 80, 66);
		javatxicon2.setToolTipText("Java Texture Pack");
		ImageIcon txicon2 = new ImageIcon(Display.class.getClassLoader().getResource("icons/javatxpk.png"));
		Image img6 = txicon2.getImage();
		Image img7 = img6.getScaledInstance(javatxicon2.getWidth(), javatxicon2.getHeight(), Image.SCALE_SMOOTH);
		txicon2 = new ImageIcon(img7);
		javatxicon2.setIcon(txicon2);
		javatxicon2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (Main.FromType == 1) {
					fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					fc.setAcceptAllFileFilterUsed(false);
					if (e.getSource() == javatxicon2) {
						Main.returnVal = fc.showOpenDialog(null);
						if (Main.returnVal == JFileChooser.APPROVE_OPTION) {
							Main.ToType = 2;
							Main.ToPack = "Java Texture Pack";
							Main.file = fc.getSelectedFile();
						}
					}
				} else if (Main.FromType == 3) {
					fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					fc.setAcceptAllFileFilterUsed(false);
					if (e.getSource() == javatxicon2) {
						Main.returnVal = fc.showOpenDialog(null);
						if (Main.returnVal == JFileChooser.APPROVE_OPTION) {
							Main.ToType = 2;
							Main.ToPack = "Java Texture Pack";
							Main.file = fc.getSelectedFile();
						}
					}
				}
			}
		});
		javatxicon2.setVisible(false);
		frame.getContentPane().add(javatxicon2);
		
		bedrockicon = new JLabel("<html>Bedrock Texture Pack</html>");
		bedrockicon.setForeground(Color.WHITE);
		bedrockicon.setBounds(325, 51, 105, 105);
		bedrockicon.setToolTipText("Bedrock Texture Pack");
		ImageIcon bricon = new ImageIcon(Display.class.getClassLoader().getResource("icons/bedrock.png"));
		Image img8 = bricon.getImage();
		Image img9 = img8.getScaledInstance(bedrockicon.getWidth(), bedrockicon.getHeight(), Image.SCALE_SMOOTH);
		bricon = new ImageIcon(img9);
		bedrockicon.setIcon(bricon);
		bedrockicon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.FromType = 3;
				Main.FromPack = "Bedrock Texture Pack";
				SceneSwitcher.convertTo();
			}
		});
		bedrockicon.setVisible(true);
		frame.getContentPane().add(bedrockicon);
		
		bedrockicon2 = new JLabel("<html>Bedrock Texture Pack</html>");
		bedrockicon2.setForeground(Color.WHITE);
		bedrockicon2.setBounds(325, 51, 105, 105);
		bedrockicon2.setToolTipText("Bedrock Texture Pack");
		ImageIcon bricon2 = new ImageIcon(Display.class.getClassLoader().getResource("icons/bedrock.png"));
		Image img10 = bricon2.getImage();
		Image img11 = img10.getScaledInstance(bedrockicon2.getWidth(), bedrockicon2.getHeight(), Image.SCALE_SMOOTH);
		bricon2 = new ImageIcon(img11);
		bedrockicon2.setIcon(bricon2);
		bedrockicon2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (Main.FromType == 1) {
					fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					fc.setAcceptAllFileFilterUsed(false);
					if (e.getSource() == bedrockicon2) {
						Main.returnVal = fc.showOpenDialog(null);
						if (Main.returnVal == JFileChooser.APPROVE_OPTION) {
							Main.ToType = 3;
							Main.ToPack = "Bedrock Texture Pack";
							Main.file = fc.getSelectedFile();
						}
					}
				} else if (Main.FromType == 2) {
					FileNameExtensionFilter filter = new FileNameExtensionFilter("Minecraft Texture Pack (*.zip)","zip");
					fc.setFileFilter(filter);
					fc.setAcceptAllFileFilterUsed(false);
					if (e.getSource() == bedrockicon2) {
						Main.returnVal = fc.showOpenDialog(null);
						if (Main.returnVal == JFileChooser.APPROVE_OPTION) {
							Main.ToType = 3;
							Main.ToPack = "Bedrock Texture Pack";
							Main.file = fc.getSelectedFile();
						}
					}
				}
			}
		});
		bedrockicon2.setVisible(false);
		frame.getContentPane().add(bedrockicon2);
		
		instructions = new JLabel("<html>[Instructions]: To start what you want to do is click the icon to convert from.</html>");
		instructions.setVerticalAlignment(SwingConstants.TOP);
		instructions.setFont(new Font("Minecraftia", Font.PLAIN, 12));
		instructions.setForeground(Color.WHITE);
		instructions.setBounds(99, 163, 342, 36);
		instructions.setVisible(true);
		frame.getContentPane().add(instructions);
		
		example = new JLabel("<html>[Example]: If you want to convert a Java Resource Pack to a Java Texture Pack you will want to click the icon that says 'Resource Pack'</html>");
		example.setForeground(Color.WHITE);
		example.setFont(new Font("Minecraftia", Font.PLAIN, 12));
		example.setVerticalAlignment(SwingConstants.TOP);
		example.setBounds(99, 210, 342, 72);
		example.setVisible(true);
		frame.getContentPane().add(example);
		
		back = new JButton("Back");
		back.setBounds(10, 396, 89, 23);
		back.setVisible(false);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.FromType = 0;
				Main.ToType = 0;
				fc = new JFileChooser();
				SceneSwitcher.convertFrom();
			}
		});
		frame.getContentPane().add(back);
		
		Continue = new JButton("Continue");
		Continue.setBounds(441, 396, 89, 23);
		Continue.setVisible(false);
		Continue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.path = Main.fileCopied + "/";
				if (Main.ToType == 0) {
					@SuppressWarnings("unused")
					Dialog dialog = new Dialog();
					Dialog.pickOne();
				} else if (Main.FromType == 1 && Main.ToType == 2) {
					Main.fileCopied = new File(Main.file + "-Converted");
					SceneSwitcher.converted();
					try {
						Convert.ResourceToTexture();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else if (Main.FromType == 1 && Main.ToType == 3) {
					Main.fileCopied = new File(Main.file + "-Converted");
					SceneSwitcher.converted();
					try {
						Convert.ResourceToBedrock();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else if (Main.FromType == 2 && Main.ToType == 1) {
					String file2 = Main.file.toString();
					file2 = file2.substring(0, file2.lastIndexOf('.'));
					Main.file = new File(file2);
					Main.fileCopied = new File(Main.file + "-Converted");
					SceneSwitcher.converted();
					try {
						Convert.TextureToResource();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else if (Main.FromType == 2 && Main.ToType == 3) {
					String file2 = Main.file.toString();
					file2 = file2.substring(0, file2.lastIndexOf("."));
					Main.file = new File(file2);
					Main.fileCopied = new File(Main.file + "-Converted");
					SceneSwitcher.converted();
					try {
						Convert.TextureToBedrock();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else if (Main.FromType == 3 && Main.ToType == 1) {
					Main.fileCopied = new File(Main.file + "-Converted");
					SceneSwitcher.converted();
					try {
						Convert.BedrockToResource();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else if (Main.FromType == 3 && Main.ToType == 2) {
					Main.fileCopied = new File(Main.file + "-Converted");
					SceneSwitcher.converted();
					try {
						Convert.BedrockToTexture();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		frame.getContentPane().add(Continue);
		
		from = new JLabel();
		from.setForeground(Color.WHITE);
		from.setFont(new Font("Minecraftia", Font.PLAIN, 10));
		from.setBounds(169, 79, 202, 14);
		from.setVisible(false);
		frame.getContentPane().add(from);
		
		to = new JLabel();
		to.setForeground(Color.WHITE);
		to.setFont(new Font("Minecraftia", Font.PLAIN, 10));
		to.setBounds(169, 104, 202, 14);
		to.setVisible(false);
		frame.getContentPane().add(to);
		
		filename = new JLabel();
		filename.setVerticalAlignment(SwingConstants.TOP);
		filename.setHorizontalAlignment(SwingConstants.LEFT);
		filename.setForeground(Color.WHITE);
		filename.setFont(new Font("Minecraftia", Font.PLAIN, 10));
		filename.setBounds(10, 164, 520, 255);
		filename.setVisible(false);
		frame.getContentPane().add(filename);
		
		frame.invalidate();
		frame.validate();
		frame.repaint();
	}
}
