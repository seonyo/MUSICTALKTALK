package source;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
	
	public class game_explanation extends JFrame {
		Image game_explanation=new ImageIcon(loading.class.getResource("../image/게임방법.png")).getImage();//배경이미지
		public game_explanation() {
			setTitle("MusicTalkTalk"); //타이틀 명
			setSize(1200,850); //프레임 사이즈
			setResizable(false); //프레임 크기 조정 못하게
			setLocationRelativeTo(null); //창이 가운데로
			setLayout(null); //레이아웃을 내맘대로 설정 가능
			setVisible(true); //창이 보이게
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //정상적으로 종료되게
		}
		
		public void paint (Graphics g) {
			g.drawImage(game_explanation, 0 , 0, null);
		}	
		
	}

