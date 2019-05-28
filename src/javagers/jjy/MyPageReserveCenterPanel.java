package javagers.jjy;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MyPageReserveCenterPanel extends JPanel{
	
	JButton btn1,btn2;
	
	MyPageReserveCenterPanel(){
//		super(str);
		btn1 = new JButton("예매 정보 확인");
		btn2 = new JButton("회원정보 수정");
		this.setLayout(new GridLayout(1,2));
		this.add(btn1);
		this.add(btn2);
		this.setPreferredSize(new Dimension(1200, 100));
//		this.setSize(1200, 100);
//		this.setVisible(true);
		
	}

	
	
	
	public static void main(String[] args) {
//		new MyPageReserveCenterPanel("마이페이지 센터패널 테스트");
	}	

}
