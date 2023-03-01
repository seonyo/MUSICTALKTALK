package source;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class gameover extends JFrame {
	JButton End = new JButton();
	JButton again = new JButton();
	ImageIcon endimg = new ImageIcon (Main.class.getResource("../image/end.png"));
	ImageIcon againimg = new ImageIcon (Main.class.getResource("../image/again.png"));
	
	Image background = new ImageIcon(Main.class.getResource("../image/gameover.png")).getImage();
	
	public void paint (Graphics g) {
		g.drawImage(background,0,0,null);
	}
	public gameover() {
		setTitle("MusicTalkTalk");
		setSize(1200,850);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		End.setLayout(null);
		End.setBounds(200,450,350,50);
		add(End);
		End.setIcon(endimg);
		
		again.setLayout(null);
		again.setBounds(650,450,350,50);
		add(again);
		again.setIcon(againimg);
		cg();
	}
	
	public void cg() {
		End.addMouseListener(new MouseAdapter() {
			@Override 
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
			
		});
		again.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
				new loading();
			}
		});
	}
}
