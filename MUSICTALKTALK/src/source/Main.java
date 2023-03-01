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
		setResizable(false); //프레임 크기 조정 못하게k
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
			@Override 
			public void mousePressed(MouseEvent e) {
				dispose();
				new loading();
			}
			
		});
		
		main_b2.addMouseListener (new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
				new game_explanation();
			}
		});
	}
	
	
	//메인메소드
	public static void main(String[] args) {
		 new Main();
	}
}
