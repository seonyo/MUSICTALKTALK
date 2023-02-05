package source;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class loading extends JFrame {
	Image loading_ready=new ImageIcon(loading.class.getResource("../image/ready'.png")).getImage();//배경이미지
	Image loading_start=new ImageIcon(loading.class.getResource("../image/start.png")).getImage();//배경이미지
	public loading() {
		setTitle("MusicTalkTalk"); //타이틀 명
		setSize(1200,850); //프레임 사이즈
		setResizable(false); //프레임 크기 조정 못하게
		setLocationRelativeTo(null); //창이 가운데로
		setLayout(null); //레이아웃을 내맘대로 설정 가능
		setVisible(true); //창이 보이게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //정상적으로 종료되게
	}
	
	public void paint (Graphics g) {
		g.drawImage(loading_ready, 0 , 0, null);
		time();
		g.drawImage(loading_start, 0, 0,null);
		time();
		dispose();
		new play();
}
	
	public void time(){
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
