package javagers.pjh;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReservationTicket extends JPanel {

	ReservationTicketPan reservationTicketPan;
	ReservationButtonPan reservationButtonPan;
	ReserveInfo ri;
//	JButton button, buttonTicket;

	ReservationTicket(ReserveInfo ri) {
		this.ri = ri;
		reservationTicketPan = new ReservationTicketPan(ri);
		reservationButtonPan = new ReservationButtonPan(reservationTicketPan);
//		buttonTicket = new JButton("티켓출력");
//		button = new JButton("다음");
		this.setLayout(new BorderLayout());
		this.add("South", reservationButtonPan);
		this.add("Center", reservationTicketPan);
//		this.setBounds(0,0,1200,800);
//		this.setVisible(true);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class ReservationTicketPan extends JPanel {
	JLabel warning, movie, screen, time, seat, movieText, scrennText, timeText, seatText, reservation,
			reservationNumber;
	ReserveInfo ri;

	ReservationTicketPan(ReserveInfo ri) {

		this.ri = ri;

		this.setLayout(new GridLayout(18, 0));

		warning = new JLabel("예약하신 목록을 확인해주세요.");
		movie = new JLabel("영    화 : ");
		screen = new JLabel("상영관 : ");
		time = new JLabel("시    간 : ");
		seat = new JLabel("좌    석 : ");
		reservation = new JLabel("예약번호 : ");

		movieText = new JLabel(ri.reserve_title);
		scrennText = new JLabel(ri.reserve_screen + " 관");
		timeText = new JLabel(ri.reserve_time);
		seatText = new JLabel(ri.reserve_seat);
		reservationNumber = new JLabel(String.valueOf(ri.reserve_rnum));

		this.add(new JPanel());
		this.add(warning);
		this.add(new JPanel());
		this.add(movie);
		this.add(movieText);
		this.add(new JPanel());
		this.add(screen);
		this.add(scrennText);
		this.add(new JPanel());
		this.add(time);
		this.add(timeText);
		this.add(new JPanel());
		this.add(seat);
		this.add(seatText);
		this.add(new JPanel());
		this.add(reservation);
		this.add(reservationNumber);
		this.add(new JPanel());
	}

}

class ReservationButtonPan extends JPanel {// 완료 눌렀을 때 예약번호 생성하고 커밋, 다이얼로그로 예약번호 알림

	JButton button, buttonTicket;
	ReservationTicketPan rtp;

	ReservationButtonPan(ReservationTicketPan rtp) {

		this.rtp = rtp;

		this.setLayout(new GridLayout(1, 2));

		buttonTicket = new JButton("티켓출력");
		buttonTicket.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 제출 버튼 누르라고 요구, 
				if(button.getText().equals("제출")) {
					JOptionPane.showMessageDialog(null, "제출 버튼을 눌러 완료 하세요.");
				} else {
					JOptionPane.showMessageDialog(null, "프린터 연결상태를 확인하세요.");
				}
				
			}
			
		});
		buttonTicket.setBackground(Color.GREEN);

		button = new JButton("제출");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 제출 버튼 누르면 커밋하고 완료로 라벨 하고 색 바꿈 

				CRUDprocess cp = new CRUDprocess();
				cp.insertReserveInfo(rtp.ri);
				
				JOptionPane.showMessageDialog(null, rtp.ri.reserve_rnum);
				
				button.setText("완료"); button.setBackground(Color.BLUE);

				System.out.println("커밋성공");

				System.out.println(rtp.ri.reserve_id);
				System.out.println(rtp.ri.reserve_mnum);
				System.out.println(rtp.ri.reserve_num);
				System.out.println(rtp.ri.reserve_people);
				System.out.println(rtp.ri.reserve_price);
				System.out.println(rtp.ri.reserve_rnum);
				System.out.println(rtp.ri.reserve_round);
				System.out.println(rtp.ri.reserve_screen);
				System.out.println(rtp.ri.reserve_seat);
				System.out.println(rtp.ri.reserve_time);
				System.out.println(rtp.ri.reserve_title);
				System.out.println(rtp.ri.reserve_date);

			}

		});

		this.add(buttonTicket);
		this.add(button);
	}
}
