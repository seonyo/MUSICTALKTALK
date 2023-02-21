package source;

import java.awt.AlphaComposite;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class TimerBar extends JLabel implements Runnable{
	int width = 550, height=50; //크기
	int x=330, y=25; //위치
	int second;
	//타임바
	public TimerBar(int second) {
		setBackground(Color.yellow);
		setOpaque(true);
		setBounds (x,y,width,height);
		this.second = second;
	}
	
	@Override
	public void run() {
		while(true) {
			if(getWidth()>270) {
				width-=3;
				setBounds(x,y,width, height);
			}
			else if(getWidth()>=110){
				width-=3;
				setBounds(x,y,width, height);
				setBackground(Color.ORANGE);
			}
			else if(getWidth()>=25) {
				width-=3;
				setBounds(x,y,width, height);
				setBackground(Color.RED);
			}
			else{			
				new gameover();
				break;
			}
			try {
				Thread.sleep(1000/ (120/second));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}





class stage1 extends JFrame implements KeyListener{
	
	//배경이미지 그리기
	JPanel panel = new JPanel() {
		Image playpage = new ImageIcon(Main.class.getResource("../image/gameplay.png")).getImage();
		public void paint(Graphics g) {
			g.drawImage(playpage, 0,0,null);
		}
	};
	//gameover 이미지 그리기
	JPanel gameover = new JPanel() {
		Image gameoverimg = new ImageIcon(Main.class.getResource("../image/gameover.png")).getImage();
		public void paint (Graphics g) {
			g.drawImage(gameoverimg, 0,0,null);
		}
	};
	
	ArrayList <Integer> arrow_num = new ArrayList<Integer>();
	ArrayList <JPanel> arrow= new ArrayList <JPanel>();
	ArrayList <JPanel> heart = new ArrayList <JPanel>();
	static int score=0;
	JLabel scoreJL;
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

		int second = 20;
		TimerBar timerbar = new TimerBar(second);
		Thread threadBar = new Thread(timerbar);
		threadBar.start();
		add(timerbar);
		
		//화살표 랜덤
		int x=350, y=200;
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
				arrow.add(left);
				add(arrow.get(i-1));
					arrow.get(i-1).setLayout(null);
					arrow.get(i-1).setBounds(x,y,50,50);
					break;
			
			case 1 : 
				JPanel right = new JPanel() {
					Image right = new ImageIcon(Main.class.getResource("../image/right.png")).getImage();
					public void paint(Graphics g) {
						g.drawImage(right, 0,0,null);
					}
				};
				arrow.add(right);
				add(arrow.get(i-1));
					arrow.get(i-1).setLayout(null);
					arrow.get(i-1).setBounds(x,y,50,50);
					break;
					
			case 2 :
				JPanel up = new JPanel() {
					Image up = new ImageIcon(Main.class.getResource("../image/up.png")).getImage();
					public void paint(Graphics g) {
						g.drawImage(up, 0,0,null);
					}
				};
				arrow.add(up);
				add(arrow.get(i-1));
					arrow.get(i-1).setLayout(null);
					arrow.get(i-1).setBounds(x,y,50,50);
					break;
					
			case 3 :
				
				JPanel down = new JPanel() {
					Image down = new ImageIcon(Main.class.getResource("../image/down.png")).getImage();
					public void paint(Graphics g) {
						g.drawImage(down, 0,0,null);
					}
				};
				arrow.add(down);
				add(arrow.get(i-1));
					arrow.get(i-1).setLayout(null);
					arrow.get(i-1).setBounds(x,y,50,50);
					break;
					
			case 4 :
				JPanel space = new JPanel() {
					Image space = new ImageIcon(Main.class.getResource("../image/space.png")).getImage();
					public void paint(Graphics g) {
						g.drawImage(space, 0,0,null);
					}
				};				
				arrow.add(space);
				add(arrow.get(i-1));
					arrow.get(i-1).setLayout(null);
					arrow.get(i-1).setBounds(x,y,50,50);
					break;
			}
			if(i>0 && i<=6) x+=80;
			else if(i<=8) y+=80;
			else if(i<=15) x-=80;
			else if(i<=17) y+=80;
			else if(i<=25) x+=80;
		}
		
		JPanel yellow = new JPanel() {
			Image yellow = new ImageIcon (Main.class.getResource("../image/yellow.png")).getImage();
			public void paint (Graphics g) {
				g.drawImage (yellow, 0,0,null);
			}
		};
		heart.add(yellow);

		JPanel orange = new JPanel() {
			Image orange = new ImageIcon (Main.class.getResource("../image/orange.png")).getImage();
			public void paint (Graphics g) {
				g.drawImage(orange,0,0,null);
				}
		};
		heart.add(orange);

		JPanel blue = new JPanel() {
			Image blue = new ImageIcon(Main.class.getResource("../image/blue.png")).getImage();
			public void paint (Graphics g) {
				g.drawImage(blue,0,0,null);
			}
		};
		
		heart.add(blue);
		
		//아이콘 추가
		
		for(int i=0; i<heart.size(); i++) {
			add(heart.get(i));
			heart.get(i).setLayout(null);
			heart.get(i).setBounds(270-(i*80),200,60,60);
		}

		//scoreLabel
		scoreJL = new JLabel();
		scoreJL.setBounds(1075,45,150,50);
		scoreJL.setText(Integer.toString(score));
		scoreJL.setForeground(Color.YELLOW);
		scoreJL.setFont(cnt.getFont().deriveFont(30.0f));
		add(scoreJL);
		
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
	
	int cnt=0, flag=0, heart_cnt=0, life=3;
	int y_x=350,y_y=200;
	int o_x=270,o_y=200;
	int b_x=190, b_y=200;
	
	@Override
	public void keyPressed (KeyEvent e) {
		int result;
		int key = e.getKeyCode();
			if(key==e.VK_LEFT) {
				result=0; flag=0;
				if(result==arrow_num.get(cnt)) {
					arrow.get(cnt).setSize(0,0);
					heart.get(0).setLocation(y_x,y_y);
					heart.get(1).setLocation(o_x,o_y);
					heart.get(2).setLocation(b_x, b_y);
					cnt++; flag=1; score+=50;
					scoreJL.setText(Integer.toString(score));
				}
			}
			else if(key==e.VK_RIGHT) {
				result=1; flag=0;
				if(result==arrow_num.get(cnt)) {
					arrow.get(cnt).setSize(0,0);
					heart.get(0).setLocation(y_x,y_y);
					heart.get(1).setLocation(o_x,o_y);
					heart.get(2).setLocation(b_x, b_y);
					cnt++; flag=1; score+=50;
					scoreJL.setText(Integer.toString(score));

				}
			}
			else if(key==e.VK_UP) {
				result=2; flag=0;
				if(result==arrow_num.get(cnt)) {
					arrow.get(cnt).setSize(0,0);
					heart.get(0).setLocation(y_x,y_y);
					heart.get(1).setLocation(o_x,o_y);
					heart.get(2).setLocation(b_x, b_y);
					cnt++; flag=1; score+=50;
					scoreJL.setText(Integer.toString(score));

				}
			}
			else if(key==e.VK_DOWN) {
				result=3; flag=0;
				if(result==arrow_num.get(cnt)) {
					arrow.get(cnt).setSize(0,0);
					heart.get(0).setLocation(y_x,y_y);
					heart.get(1).setLocation(o_x,o_y);
					heart.get(2).setLocation(b_x, b_y);
					cnt++; flag=1; score+=50;
					scoreJL.setText(Integer.toString(score));

				}
			}
			else if(key==e.VK_SPACE) {
				result=4; flag=0;
				if(result==arrow_num.get(cnt)) {
					arrow.get(cnt).setSize(0,0);
					heart.get(0).setLocation(y_x,y_y);
					heart.get(1).setLocation(o_x,o_y);
					heart.get(2).setLocation(b_x, b_y);
					cnt++; flag=1; score+=50;		
					scoreJL.setText(Integer.toString(score));
				}
			}
			//yellow 위치
			if(flag==1) {
				if(cnt>0 && cnt<=6) y_x+=80;
				else if(cnt<=8) y_y+=80;
				else if(cnt<=15) y_x-=80;
				else if(cnt<=17) y_y+=80;
				else if(cnt<=25) y_x+=80;
				
				//orange 위치
				if(cnt>0 && cnt<=7) o_x+=80;
				else if(cnt<=9) o_y+=80;
				else if(cnt<=16) o_x-=80;
				else if(cnt<=18) o_y+=80;
				else if(cnt<=25) o_x+=80;
				
				//blue 위치
				if(cnt>0 && cnt<=8) b_x+=80;
				else if(cnt<=10) b_y+=80;
				else if(cnt<=17) b_x-=80;
				else if(cnt<=19) b_y+=80;
				else if(cnt<=25) b_x+=80;
			}
			else {
				heart.get(0).setSize(0,0);
				heart_cnt++;
				Collections.swap(heart, 0, 1);
				Collections.swap(heart, 1,2);
				--life;
				
				if(life==0) {
					new gameover();
				}
			}
	}
}