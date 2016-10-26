package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;


public class Gui extends JFrame {
	
	private final JFrame startScreen;
		private final JPanel startScreenPicture;
			private final JLabel pictureLabel;
		private final JPanel startScreenFunctionPanel;
			private final JButton start;
			private final JButton option;
			private final JButton help;
			private final JButton exit;
	
	private final JFrame optionScreen;
		private final JPanel optionScreenFunctionPanel;
			private final JButton life;
			private final JButton difficulty;
	
	private final JFrame helpScreen;
		private final JPanel helpScreenTextPanel;
			private final JTextArea instructionText;
	
	public 	Gui() {
		startScreen = new JFrame("Start Screen");
		optionScreen = new JFrame("Option");
		helpScreen = new JFrame("Help");
		
		//--JFrame setup
			Dimension d = new Dimension(300, 300);
			startScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			startScreen.setPreferredSize(d);
			startScreen.setResizable(false);
			startScreen.setLayout(new GridLayout(0, 1));
			optionScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			optionScreen.setPreferredSize(d);
			optionScreen.setResizable(false);
			optionScreen.setLayout(new GridLayout(0, 1));
			helpScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			helpScreen.setPreferredSize(d);
			helpScreen.setResizable(false);
			helpScreen.setLayout(new GridLayout(0, 1));
		
		//--startScreen
			pictureLabel = new JLabel(new ImageIcon(this.getClass().getResource("/Stick_figure.png")));
			startScreenPicture = new JPanel(null);
			startScreenPicture.add(pictureLabel);
			
			start = new JButton("Start");
			start.setSize(new Dimension(300, 50));
			start.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					startScreen.dispose();
					try {
						AppGameContainer container = new AppGameContainer(new Slick2d());
						container.setTargetFrameRate(60);
						container.setDisplayMode(1600, 900, false);
						container.start();
					} catch (SlickException e) {
						e.printStackTrace();
					}
				}
			});
			
			option = new JButton("Option");
			option.setSize(new Dimension(300, 50));
			option.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					startScreen.dispose();
					optionScreen.pack();
					optionScreen.setVisible(true);
				}
			});
			
			help = new JButton("Help");
			help.setSize(new Dimension(300, 50));
			help.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					startScreen.dispose();
					helpScreen.pack();
					helpScreen.setVisible(true);
				}
			});
			
			exit = new JButton("Exit");
			exit.setSize(new Dimension(200, 50));
			exit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			
			startScreenFunctionPanel = new JPanel(null);
			startScreenFunctionPanel.setLayout(new GridLayout(0, 1));
			startScreenFunctionPanel.add(start);
			startScreenFunctionPanel.add(option);
			startScreenFunctionPanel.add(help);
			startScreenFunctionPanel.add(exit);
			
			startScreen.add(startScreenPicture);
			startScreen.add(startScreenFunctionPanel);
			
			//--optionScreen
			life = new JButton("Life");
			difficulty = new JButton("Difficulty");
			
			optionScreenFunctionPanel = new JPanel(null);
			optionScreenFunctionPanel.setLayout(new GridLayout(0, 1));
			optionScreenFunctionPanel.add(life);
			optionScreenFunctionPanel.add(difficulty);
			
			optionScreen.add(optionScreenFunctionPanel);
			
			//--helpScreen
			instructionText = new JTextArea();
			
			helpScreenTextPanel = new JPanel(null);
			helpScreenTextPanel.setLayout(new GridLayout(0, 1));
			helpScreenTextPanel.add(instructionText);
			
			helpScreen.add(helpScreenTextPanel);
			
			//--Start the Gui
			startScreen.pack();
			startScreen.setVisible(true);
	}
}
