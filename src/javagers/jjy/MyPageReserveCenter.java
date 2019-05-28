package javagers.jjy;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyPageReserveCenter extends JPanel{
		
	MyPageReserveCenterPanel centerPanel;
	MyPageReserveWestPanel westPanel;
	MyPageReserveEastPanel eastPanel;
	MyPageReserveSouthPanel southPanel;
	
	MyPageReserveCenter(){
//			super(str);
			centerPanel = new MyPageReserveCenterPanel();
			westPanel = new MyPageReserveWestPanel();
			eastPanel = new MyPageReserveEastPanel();
			southPanel = new MyPageReserveSouthPanel();
			
			this.setLayout(new BorderLayout());
			this.add("North", centerPanel);
			this.add("West",westPanel);
			this.add("East", eastPanel);
			this.add("South", southPanel);
//			this.setVisible(true);
//			this.setSize(1200, 100);
//			this.setPreferredSize(new Dimension(300, 100));
			
			
		}

	public static void main(String[] args) {
//			new MyPageReserveCenter("센터");
	}

}
