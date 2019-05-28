package javagers.jjy;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MyPageReserveInfo extends JFrame{
	
	MyPageUpPanel myPageUpPanel;
	MyPageReserveCenter reserveCenter;
	
	
	public MyPageReserveInfo(String str) {
		super(str);
		myPageUpPanel = new MyPageUpPanel();
		reserveCenter = new MyPageReserveCenter();
		
		this.setLayout(new BorderLayout());
		this.add("North",myPageUpPanel);
		this.add("Center",reserveCenter);
		this.setVisible(true);
		this.setLocation(180, 50);
		this.setSize(1200, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public static void main(String[] args) {
		new MyPageReserveInfo("마이페이지 영화예매목록");
	}

}
