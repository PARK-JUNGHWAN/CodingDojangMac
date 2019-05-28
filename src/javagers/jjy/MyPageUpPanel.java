package javagers.jjy;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyPageUpPanel extends JPanel{		//로그인 후 마이페이지를 눌렀을 경우
	
	JButton btn,btn1,btn2;
	
	public MyPageUpPanel() {
//		super(str);
		btn = new JButton("홈으로");
		btn1 = new JButton("영화 예매");
		btn2 = new JButton("로그아웃");
		this.setLayout(new GridLayout(1,3));
		this.add(btn);
		this.add(btn1);
		this.add(btn2);
		this.setPreferredSize(new Dimension(1200, 100));
//		this.setSize(1200, 100);
//		this.setVisible(true);
		
	}
	
	
	
	
	public static void main(String[] args) {
//			new MyPageUpPanel("마이페이지 업패널 테스트");
	}

}
