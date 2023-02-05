package source;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class play extends JFrame{
	JPanel panel = new JPanel() {
		Image playpage = new ImageIcon(Main.class.getResource("../image/gameplay.png")).getImage();
		public void paint(Graphics g) {
			g.drawImage(playpage, 0,0,null);
		}
	};
	JPanel left = new JPanel() {
		Image left = new ImageIcon(Main.class.getResource("../image/left.png")).getImage();
		public void paint(Graphics g) {
			g.drawImage(left, 0,0,null);
		}
	};
	JPanel right = new JPanel() {
		Image right = new ImageIcon(Main.class.getResource("../image/right.png")).getImage();
		public void paint(Graphics g) {
			g.drawImage(right, 0,0,null);
		}
	};
	JPanel up = new JPanel() {
		Image up = new ImageIcon(Main.class.getResource("../image/up.png")).getImage();
		public void paint(Graphics g) {
			g.drawImage(up, 0,0,null);
		}
	};
	JPanel down = new JPanel() {
		Image down = new ImageIcon(Main.class.getResource("../image/down.png")).getImage();
		public void paint(Graphics g) {
			g.drawImage(down, 0,0,null);
		}
	};
	JPanel space = new JPanel() {
		Image space = new ImageIcon(Main.class.getResource("../image/space.png")).getImage();
		public void paint(Graphics g) {
			g.drawImage(space, 0,0,null);
		}
	};
	public play() {
		
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
		
		
		Random random = new Random();
		int dira = random.nextInt(5);
		switch (dira) {
		case 0 : add(left);
				left.setLayout(null);
				left.setBounds(500,100,50,50);
				break;
		
		case 1 : add(right);
				right.setLayout(null);
				right.setBounds(500,100,50,50);
				break;
		case 2 : add(up);
				up.setLayout(null);
				up.setBounds(500,100,50,50);
				break;
		case 3 : add(down);
				down.setLayout(null);
				down.setBounds(500,100,50,50);
				break;
		case 4 : add(space);
				space.setLayout(null);
				space.setBounds(500,100,50,50);
				break;
		}
		panel.setLayout(null);
		panel.setBounds(0,0,1200,850);
		add(panel);
		setVisible(true); //프레임 보이게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //정상적으로 종료되게
	}
}

public class Main extends JFrame{
	JButton main_b1 = new JButton();
	JButton main_b2 = new JButton();
	
	Image background=new ImageIcon(Main.class.getResource("../image/main.png")).getImage();//배경이미지
	ImageIcon mainb1_img  = new ImageIcon(Main.class.getResource("../image/main_btn1.png"));//게임시작버튼
	ImageIcon mainb2_img = new ImageIcon(Main.class.getResource("../image/main_btn2.png")); //게임설명버튼
	//메인생성자
	public Main() {
		homeframe();
		btn();
		cg();
	}
	//메인 프레임 메소드
	public void homeframe() {
		setTitle("MusicTalkTalk"); //타이틀 명
		setSize(1200,850); //프레임 사이즈
		setResizable(false); //프레임 크기 조정 못하게
		setLocationRelativeTo(null); //창이 가운데로
		setLayout(null); //레이아웃을 내맘대로 설정 가능
		setVisible(true); //창이 보이게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //정상적으로 종료되게
	}
	//메인화면 버튼 메소드
	public void btn() {
		main_b1.setLayout(null);
		main_b1.setBounds(800, 500, 290, 50);
		main_b2.setLayout(null);
		main_b2.setBounds(800, 600, 290, 50);
		add(main_b1);
		add(main_b2);
		main_b1.setIcon(mainb1_img);
		main_b2.setIcon(mainb2_img);
	}
	//메인화면 그리기 함수
	public void paint(Graphics g) {//그리는 함수
		g.drawImage(background, 0, 0, null);//background를 그려줌
	}
	// 게임시작 버튼 눌렀을때
	public void cg() {
		main_b1.addMouseListener(new MouseAdapter(){
			@Override public void mousePressed(MouseEvent e) {
				dispose();
				new loading();
			}
			
		});
	}
	
	
	//메인메소드
	public static void main(String[] args) {
		 new Main();
	}
}
