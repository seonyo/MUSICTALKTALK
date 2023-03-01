package source;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class stage2  extends JFrame{
	JPanel panel = new JPanel() {
		Image playpage = new ImageIcon(Main.class.getResource("../image/gameplay.png")).getImage();
		public void paint(Graphics g) {
			g.drawImage(playpage, 0,0,null);
		}
	};
	public stage2() {
		setTitle("MusicTalkTalk"); //타이틀 명
		setSize(1200,850); //프레임 사이즈
		setResizable(false); //프레임 크기 조정 못하게
		setLocationRelativeTo(null); //창이 가운데로
		setLayout(null);

		int second = 20;
		TimerBar timerbar = new TimerBar(second);
		Thread threadBar = new Thread(timerbar);
		threadBar.start();
		add(timerbar);
		
		JLabel scoreJL = new JLabel();
		scoreJL.setBounds(1075,45,150,50);
		scoreJL.setText(Integer.toString(2));
		scoreJL.setForeground(Color.YELLOW);
		scoreJL.setFont(scoreJL.getFont().deriveFont(30.0f));
		add(scoreJL);
		
		panel.setLayout(null);
		panel.setBounds(0,0,1200,850);
		add(panel);
		
		setVisible (true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
