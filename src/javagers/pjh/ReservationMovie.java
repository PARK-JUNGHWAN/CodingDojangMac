package javagers.pjh;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ReservationMovie extends JFrame {
	ReservationMoviePan reservationMoviePan;
	JButton button;
	
	ReservationMovie(){
		reservationMoviePan = new ReservationMoviePan();
		button = new JButton("다음");
		
		this.add("Center",reservationMoviePan);
		this.add("South", button);
		this.setBounds(0,0,1200,800);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ReservationMovie();

	}

}

class ReservationMoviePan extends JPanel {
	
	String [] movie = {"명탐정 피카츄","어벤져서 엔드게임","걸캅스","자전거왕 엄복동"};
	ButtonGroup group;
	JRadioButton[] button;
	
	ReservationMoviePan(){
		group = new ButtonGroup();
		button = new JRadioButton[movie.length];
		
		for(int i=0;i<movie.length;i++) {
			button[i] = new JRadioButton();
			button[i].setText(movie[i]);
			group.add(button[i]);
			this.add(button[i]);
		}
		
	}
	
}