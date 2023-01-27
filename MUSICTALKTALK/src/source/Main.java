package source;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Main extends JFrame{
	JButton main_b1 = new JButton();
	JButton main_b2 = new JButton();
	
	Image background=new ImageIcon(Main.class.getResource("../image/main.png")).getImage();//배경이미지
	ImageIcon mainb1_img  = new ImageIcon(Main.class.getResource("../image/main_btn1.png"));//게임설명버튼
	ImageIcon mainb2_img = new ImageIcon(Main.class.getResource("../image/main_btn2.png")); //게임설명버튼
	public Main() {
		homeframe();
		btn();
		cg();
	}
	public void homeframe() {
		setTitle("MusicTalkTalk"); //타이틀 명
		setSize(1200,850); //프레임 사이즈
		setResizable(false); //프레임 크기 조정 못하게
		setLocationRelativeTo(null); //창이 가운데로
		setLayout(null); //레이아웃을 내맘대로 설정 가능
		setVisible(true); //창이 보이게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //정상적으로 종료되게
	}
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
	public void paint(Graphics g) {//그리는 함수
		g.drawImage(background, 0, 0, null);//background를 그려줌
	}
	public void cg() {
		main_b1.addMouseListener(new MouseAdapter(){
			@Override public void mousePressed(MouseEvent e) {
				dispose();
				new loading();
			
			}
			
		});
	}
	public static void main(String[] args) {
		 new Main();
	}
}
