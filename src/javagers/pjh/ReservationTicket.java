package javagers.pjh;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReservationTicket extends JFrame {
	
	ReservationTicketPan reservationTicketPan;
	ReservationButtonPan reservationButtonPan;
//	JButton button, buttonTicket;
	
	ReservationTicket(){		
		reservationTicketPan = new ReservationTicketPan();
		reservationButtonPan = new ReservationButtonPan();
//		buttonTicket = new JButton("티켓출력");
//		button = new JButton("다음");
		this.add("South", reservationButtonPan);
		this.add("Center",reservationTicketPan);
		this.setBounds(0,0,1200,800);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ReservationTicket();

	}

}

class ReservationTicketPan extends JPanel {
	JLabel warning, movie, screen, time, seat, 
	movieText, scrennText, timeText, seatText, reservation, reservationNumber;
	
	ReservationTicketPan(){
		
		this.setLayout(new GridLayout(18,0));
		
		warning = new JLabel("예약하신 목록을 확인해주세요.");
		movie = new JLabel("영    화 : ");
		screen = new JLabel("상영관 : ");
		time = new JLabel("시    간 : ");
		seat = new JLabel("좌    석 : ");
		reservation = new JLabel("예약번호 : ");
		
		movieText = new JLabel("영    화");
		scrennText = new JLabel("상영관");
		timeText = new JLabel("시    간");
		seatText = new JLabel("좌    석");
		reservationNumber = new JLabel("예약번호");
		
		this.add(new JPanel());
		this.add(warning);
		this.add(new JPanel());
		this.add(movie); this.add(movieText); this.add(new JPanel());
		this.add(screen); this.add(scrennText); this.add(new JPanel());
		this.add(time); this.add(timeText); this.add(new JPanel());
		this.add(seat); this.add(seatText); this.add(new JPanel());
		this.add(reservation); this.add(reservationNumber); this.add(new JPanel());
	}
	
}

class ReservationButtonPan extends JPanel {
	
	JButton button, buttonTicket;
	
	ReservationButtonPan(){
		
		this.setLayout(new GridLayout(1,2));
		
		buttonTicket = new JButton("티켓출력");
		buttonTicket.setBackground(Color.GREEN);
		button = new JButton("다음");
		
		this.add(buttonTicket); this.add(button);
	}
}
