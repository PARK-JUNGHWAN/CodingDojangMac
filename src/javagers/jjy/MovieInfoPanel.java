package javagers.jjy;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MovieInfoPanel extends JPanel{

	JButton btn,btn1,btn2;
	
	public MovieInfoPanel() {
		//super(str);
		
		btn = new JButton("홈으로");
		btn1 = new JButton("영화 예매");
		btn2 = new JButton("로그아웃");
		this.setLayout(new GridLayout(1,3));
		this.add(btn);			
		this.add(btn1);
		this.add(btn2);
		this.setPreferredSize(new Dimension(1200, 100));
//		this.setSize(380, 380);
//		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {

		//new MovieInfoPanel();
	}

}
