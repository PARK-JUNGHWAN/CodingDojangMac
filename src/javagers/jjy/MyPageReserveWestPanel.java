package javagers.jjy;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyPageReserveWestPanel extends JPanel {
	JLabel movie, seat, time, screen;
//	JTextField movieText, seatText, timeText, screenText;
	JTextField movieText, seatText, timeText, screenText;
	MyPageReserveWestPanel(){
//			super(str);
			this.setLayout(new GridLayout(4, 1));
			movie = new JLabel("영    화");
			seat = new JLabel("좌    석");
			time = new JLabel("시    간");
			screen = new JLabel("상영관");
			
			movieText = new JTextField(100);
			seatText = new JTextField(100);
			timeText = new JTextField(100);
			screenText = new JTextField(100);
			
			this.add(movie); this.add(movieText); 
			this.add(seat); this.add(seatText);
			this.add(time); this.add(timeText); 
			this.add(screen); this.add(screenText); 
			this.setPreferredSize(new Dimension(300, 500));
//			this.setVisible(true);
//			this.setSize(400, 200);
		}
	
	
	public static void main(String[] args) {
//			new MyPageReserveEastPanel("웨스트 패널 테스트");
//			new MyPageReserveSouthPanel("웨스트 패널 테스트");
	}

}

class MyPageReserveEastPanel extends JPanel {
	JLabel point;
	JTextField pointText;
	
	MyPageReserveEastPanel(){
//		super(str);
	point = new JLabel("누적포인트 : ");
	pointText = new JTextField(50);
	this.setLayout(new GridLayout(1,1));
	this.add(point);
	this.add(pointText);
	this.setPreferredSize(new Dimension(500, 70));
//	this.setVisible(true);
//	this.setSize(500, 70);
	
	
	}
}

class MyPageReserveSouthPanel extends JPanel {
	JButton cancel;
	MyPageReserveSouthPanel(){
//		super(str);
		cancel = new JButton("취 소");
		this.setLayout(new GridLayout(1, 1));
		this.add(cancel);
//		this.setPreferredSize(new Dimension(100, 70));
		this.setPreferredSize(new Dimension(100, 50));
//		this.setVisible(true);
//		this.setSize(100, 50);
		
	}
}
