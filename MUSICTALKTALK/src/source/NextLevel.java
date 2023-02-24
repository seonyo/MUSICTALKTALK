package source;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

class NextLevel extends JFrame{
	int nextFlag = 0;
	JButton nextbtn = new JButton();
	Image background = new ImageIcon(Main.class.getResource("../image/LevelClear.png")).getImage();
	ImageIcon nextimg = new ImageIcon(Main.class.getResource("../image/next.png"));
	public NextLevel(){
		setTitle("MusicTalkTalk"); //타이틀 명
		setSize(1200,850); //프레임 사이즈
		setResizable(false); //프레임 크기 조정 못하게
		setLocationRelativeTo(null); //창이 가운데로
		setLayout(null); //레이아웃을 내맘대로 설정 가능
		nextbtn();
		setVisible(true); //창이 보이게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //정상적으로 종료되게
		cg();
	}
	public void nextbtn() {
		nextbtn.setLayout(null);
		nextbtn.setBounds(410,470,290,50);
		add(nextbtn);
		nextbtn.setIcon(nextimg);
	}
	public void paint(Graphics g) {
		g.drawImage(background,0,0,null);
	}
	public void cg() {
		nextbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
				new stage2();
			}
		});	
	}
	
	/*
	 * //키보드리스너
	 * 
	 * @Override public void keyTyped(KeyEvent e) { }
	 * 
	 * @Override public void keyReleased(KeyEvent e) { }
	 * 
	 * @Override public void keyPressed (KeyEvent e) { int key = e.getKeyCode();
	 * if(key==e.VK_SPACE) { nextFlag=1; } if(nextFlag==1) { dispose(); new
	 * stage2(); } }
	 */

}
