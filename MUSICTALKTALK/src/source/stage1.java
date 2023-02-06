package source;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class stage1 extends JFrame{
	
	JPanel panel = new JPanel() {
		Image playpage = new ImageIcon(Main.class.getResource("../image/gameplay.png")).getImage();
		public void paint(Graphics g) {
			g.drawImage(playpage, 0,0,null);
		}
	};
	
	public stage1() {
		
		setTitle("MusicTalkTalk"); //타이틀 명
		setSize(1200,850); //프레임 사이즈
		setResizable(false); //프레임 크기 조정 못하게
		setLocationRelativeTo(null); //창이 가운데로
		setLayout(null);
		int stage_cnt=1;
		
		JLabel cnt = new JLabel();
		cnt.setBounds(1080,5,50,50);
		cnt.setText(Integer.toString(stage_cnt));
		cnt.setForeground(Color.WHITE);
		cnt.setFont(cnt.getFont().deriveFont(33.0f));
		add(cnt);
		
		int x=350, y=200;
		Random random = new Random();
		
		for(int i=1; i<=25; i++) {
			int dira = random.nextInt(5);
			switch (dira) {
			case 0 : 
				JPanel left = new JPanel() {
					Image left = new ImageIcon(Main.class.getResource("../image/left.png")).getImage();
					public void paint(Graphics g) {
						g.drawImage(left, 0,0,null);
					}
				};
				
				add(left);
					left.setLayout(null);
					left.setBounds(x,y,50,50);
					System.out.println(x);
					break;
			
			case 1 : 
				JPanel right = new JPanel() {
					Image right = new ImageIcon(Main.class.getResource("../image/right.png")).getImage();
					public void paint(Graphics g) {
						g.drawImage(right, 0,0,null);
					}
				};
				add(right);
					right.setLayout(null);
					right.setBounds(x,y,50,50);
					System.out.println(x);
					break;
					
			case 2 :
				JPanel up = new JPanel() {
					Image up = new ImageIcon(Main.class.getResource("../image/up.png")).getImage();
					public void paint(Graphics g) {
						g.drawImage(up, 0,0,null);
					}
				};
					add(up);
					up.setLayout(null);
					up.setBounds(x,y,50,50);
					System.out.println(x);
					break;
					
			case 3 :
				
				JPanel down = new JPanel() {
					Image down = new ImageIcon(Main.class.getResource("../image/down.png")).getImage();
					public void paint(Graphics g) {
						g.drawImage(down, 0,0,null);
					}
				};
				add(down);
					down.setLayout(null);
					down.setBounds(x,y,50,50);
					System.out.println(x);
					break;
					
			case 4 :
				JPanel space = new JPanel() {
					Image space = new ImageIcon(Main.class.getResource("../image/space.png")).getImage();
					public void paint(Graphics g) {
						g.drawImage(space, 0,0,null);
					}
				};
				add(space);
					space.setLayout(null);
					space.setBounds(x,y,50,50);
					System.out.println(x);
					break;
			}
			if(i>0 && i<=6) x+=80;
			else if(i<=8) y+=80;
			else if(i<=15) x-=80;
			else if(i<=17) y+=80;
			else if(i<=25) x+=80;
		}
		panel.setLayout(null);
		panel.setBounds(0,0,1200,850);
		add(panel);
		
		setVisible(true); //프레임 보이게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //정상적으로 종료되게
	}
}