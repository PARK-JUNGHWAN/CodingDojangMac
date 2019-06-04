package javagers.pjh;

import javax.swing.JFrame;

public class Test extends JFrame {

	
	Test(){
		this.add("Center",new ReservationMovie());
		this.setSize(1000, 700);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Test();

	}

}
