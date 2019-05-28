package javagers.pjh;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReservationConfirm extends JFrame {
	
	ReservationConfirmPan reservationConfirmPan;
	JButton button;
	
	ReservationConfirm(){		
		reservationConfirmPan = new ReservationConfirmPan();
		button = new JButton("다음");
		this.add("South", button);
		this.add("Center",reservationConfirmPan);
		this.setBounds(0,0,1200,800);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ReservationConfirm();

	}

}

class ReservationConfirmPan extends JPanel {
	JLabel warning, movie, screen, time, seat, movieText, scrennText, timeText, seatText;
	
	ReservationConfirmPan(){
		
		this.setLayout(new GridLayout(14,0));
		
		warning = new JLabel("예약하신 목록을 확인해주세요.");
		movie = new JLabel("영    화 : ");
		screen = new JLabel("상영관 : ");
		time = new JLabel("시    간 : ");
		seat = new JLabel("좌    석 : ");
		
		movieText = new JLabel("영    화");
		scrennText = new JLabel("상영관");
		timeText = new JLabel("시    간");
		seatText = new JLabel("좌    석");
		
		this.add(new JPanel());
		this.add(warning);
		this.add(new JPanel());
		this.add(movie); this.add(movieText); this.add(new JPanel());
		this.add(screen); this.add(scrennText); this.add(new JPanel());
		this.add(time); this.add(timeText); this.add(new JPanel());
		this.add(seat); this.add(seatText);
	}
	
}
