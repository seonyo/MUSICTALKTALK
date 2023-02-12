package source;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class TimerBar extends JLabel implements Runnable{
	int width = 550, height=50;
	int x=320, y=20;
	Color color  = new Color(255,0,0);
	
	int second;
	
	public TimerBar(int second) {
		setBackground(color);
		setOpaque(true);
		setBounds (x,y,width,height);
		this.second = second;
	}
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000/ (width/second));
			}catch(Exception e) {
				e.printStackTrace();
			}
			if(getWidth()>0) {
				width-=1;
				setBounds(x,y,width, height);
			}else {
				break;
			}
		}
	}
}

class arrow{
	Image image;
	int x;
	int y;
	int widht;
	int height;
	int score;
}

class stage1 extends JFrame implements KeyListener{
	
	//배경이미지 그리기
	JPanel panel = new JPanel() {
		Image playpage = new ImageIcon(Main.class.getResource("../image/gameplay.png")).getImage();
		public void paint(Graphics g) {
			g.drawImage(playpage, 0,0,null);
		}
	};
	
	JPanel yellow = new JPanel() {
		Image yellow = new ImageIcon (Main.class.getResource("../image/yellow.png")).getImage();
		public void paint (Graphics g) {
			g.drawImage (yellow, 0,0,null);
		}
	};
	
	JPanel orange = new JPanel() {
		Image orange = new ImageIcon (Main.class.getResource("../image/orange.png")).getImage();
		public void paint (Graphics g) {
			g.drawImage(orange,0,0,null);
			}
	};
	
	JPanel blue = new JPanel() {
		Image blue = new ImageIcon(Main.class.getResource("../image/blue.png")).getImage();
		public void paint (Graphics g) {
			g.drawImage(blue,0,0,null);
		}
	};
	
	ArrayList <Integer> arrow_num = new ArrayList<Integer>();

	public stage1() {
		//stage1 프레임
		setTitle("MusicTalkTalk"); //타이틀 명
		setSize(1200,850); //프레임 사이즈
		setResizable(false); //프레임 크기 조정 못하게
		setLocationRelativeTo(null); //창이 가운데로
		setLayout(null);
		int stage_cnt=1;
		
		//stage JLabel
		JLabel cnt = new JLabel();
		cnt.setBounds(1080,5,50,50);
		cnt.setText(Integer.toString(stage_cnt));
		cnt.setForeground(Color.WHITE);
		cnt.setFont(cnt.getFont().deriveFont(33.0f));
		add(cnt);
		
		int second = 40;
		TimerBar timerbar = new TimerBar(second);
		Thread threadBar = new Thread(timerbar);
		threadBar.start();
		add(timerbar);
		
		//화살표 랜덤
		int x=350, y=200;
		List <arrow> arrowList = new ArrayList<>();
		Random random = new Random();
		for(int i=1; i<=25; i++) {
			arrow_num.add(random.nextInt(5));
			switch (arrow_num.get(i-1)) {
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
					break;
			}
			if(i>0 && i<=6) x+=80;
			else if(i<=8) y+=80;
			else if(i<=15) x-=80;
			else if(i<=17) y+=80;
			else if(i<=25) x+=80;
		}
		
		//아이콘 추가
		add (yellow);
		yellow.setLayout(null);
		yellow.setBounds(260,200,60,50);
		
		add (orange);
		orange.setLayout(null);
		orange.setBounds(180,200,60,50);
		
		add (blue);
		blue.setLayout(null);
		blue.setBounds(100,200,60,50);

		
		// 배경 패널 추가
		panel.setLayout(null);
		panel.setBounds(0,0,1200,850);
		add(panel);
		setVisible(true); //프레임 보이게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //정상적으로 종료되게
		addKeyListener(this);
		
	}
	
	//키보드리스너
	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyReleased(KeyEvent e) {	
	}
	
	
	@Override
	public void keyPressed (KeyEvent e) {
		int result,cnt=0,flag;
		int key = e.getKeyCode();
		if(key==e.VK_LEFT) {
			result=0;
			if(result==arrow_num.get(cnt)) {
				yellow.setLocation(350,200);
			}
		}
		else if(key==e.VK_RIGHT) {
			result=1;
			if(result==arrow_num.get(cnt)) {
				yellow.setLocation(350,200);
			}
		}
		else if(key==e.VK_UP) {
			result=2;
			if(result==arrow_num.get(cnt)) {
				yellow.setLocation(350,200);
			}
		}
		else if(key==e.VK_DOWN) {
			result=3;
			if(result==arrow_num.get(cnt)) {
				yellow.setLocation(350,200);
			}
		}
		else if(key==e.VK_SPACE) {
			result=4;
			if(result==arrow_num.get(cnt)) {
				yellow.setLocation(350,200);
			}
		}
	}
}