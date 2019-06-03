package javagers.pjh;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReservationBoard extends JFrame {

	ReservationBoardPan1 reservationBoardPan1;
	ReservationBoardPan2 reservationBoardPan2;

	ReservationBoard() {

		reservationBoardPan1 = new ReservationBoardPan1(this);
		reservationBoardPan1.setBackground(new Color(98, 2, 0));
		reservationBoardPan2 = new ReservationBoardPan2();

		this.add("North", reservationBoardPan1);
		this.add("Center", reservationBoardPan2);

		reservationBoardPan2.setVisible(false);

		this.setBounds(0, 0, 1200, 800);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ReservationBoard();

	}

}

class ReservationBoardPan1 extends JPanel implements ActionListener {
	JLabel label;
	JTextField text;
	JButton calendar, search;
	ReservationBoard rb;

	ReservationBoardPan1(ReservationBoard rb) {
		this.rb = rb;

		label = new JLabel("상영일");
		label.setForeground(Color.white);
		text = new JTextField(10);
		calendar = new JButton("달력");
		calendar.addActionListener(this);
		search = new JButton("조회");
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 조회버튼을 누르면 정보창 온, 상영일이 null 이면 경고
				if (text.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "달력을 눌러서 상영일을 입력하시오.");
				} else {
					rb.reservationBoardPan2.setVisible(true);
				}
			}

		});

		this.add(label);
		this.add(text);
		this.add(calendar);
		this.add(search);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		new CalendarBySwing(this).setLocation(0, 0);

		rb.reservationBoardPan2.setVisible(false);
	}
}

class ReservationBoardPan2 extends JPanel {

	ReservationBoardPan3[] pan;
	List<RemainSeat> rlist;
	List<ScreenInfo> list;
	ReservationSeatBoardPanSeatNumberPan rsbpnp;

	ReservationBoardPan2() {

		rlistSet();

		this.setLayout(new GridLayout(1, 4));
		
		pan = new ReservationBoardPan3[4];
		
		for(int i=0; i<4;i++) {
			pan[i] = new ReservationBoardPan3(this, i);
			this.add(pan[i]);
		}
	}

	public void rlistSet() {
		list = new ArrayList<>();
		rlist = new ArrayList<>(); // 순서대로 1관 1회부터 1-2,1-3 좌석정보 클래스 저장

		CRUDprocess cp = new CRUDprocess();
		list = cp.selectScreenInfo();

		for (ScreenInfo i : list) {

			if (i.screen_screen == 1) {

				if (i.screen_round == 1)
					rlist.add(new RemainSeat(1, 1, i.screen_begin));
				if (i.screen_round == 2)
					rlist.add(new RemainSeat(1, 2, i.screen_begin));
				if (i.screen_round == 3)
					rlist.add(new RemainSeat(1, 3, i.screen_begin));
				if (i.screen_round == 4)
					rlist.add(new RemainSeat(1, 4, i.screen_begin));
				if (i.screen_round == 5)
					rlist.add(new RemainSeat(1, 5, i.screen_begin));

			}

			if (i.screen_screen == 2) {

				if (i.screen_round == 1)
					rlist.add(new RemainSeat(2, 1, i.screen_begin));
				if (i.screen_round == 2)
					rlist.add(new RemainSeat(2, 2, i.screen_begin));
				if (i.screen_round == 3)
					rlist.add(new RemainSeat(2, 3, i.screen_begin));
				if (i.screen_round == 4)
					rlist.add(new RemainSeat(2, 4, i.screen_begin));
				if (i.screen_round == 5)
					rlist.add(new RemainSeat(2, 5, i.screen_begin));

			}

			if (i.screen_screen == 3) {

				if (i.screen_round == 1)
					rlist.add(new RemainSeat(3, 1, i.screen_begin));
				if (i.screen_round == 2)
					rlist.add(new RemainSeat(3, 2, i.screen_begin));
				if (i.screen_round == 3)
					rlist.add(new RemainSeat(3, 3, i.screen_begin));
				if (i.screen_round == 4)
					rlist.add(new RemainSeat(3, 4, i.screen_begin));
				if (i.screen_round == 5)
					rlist.add(new RemainSeat(3, 5, i.screen_begin));

			}
		}
	}
}

class ReservationBoardPan3 extends JPanel {
	
	String str;
	JLabel label;
	ReservationBoardPan2 r2;

	ReservationBoardPan3(ReservationBoardPan2 r2, int screen) {

		this.r2 = r2;
		this.setLayout(new BorderLayout());
		str = (screen+1) + " 관:  " + r2.list.get(screen).screen_mname; 
		label = new JLabel(str);
		this.add("North", new JPanel().add(label));
		this.add("Center", new ReservationBoardPan4(screen+1));

	}
}

class ReservationBoardPan4 extends JPanel { // 상영시간과 좌석수 보여주는 패널, 생성시 마다 상영관 입력 값 받음

//	ReservationBoardPan3 r3;
//	ReservationBoardPan2 r2;
	JLabel[] screenTime; // 상영시작 시간 표시 배열
	String startTime, startSeat, endSeat;
	String totalSeat = startSeat + " / " + endSeat;
	JCheckBox[] ck; // 좌석수 체크 박스, 클릭시 시트초이스 팬 프레임 오픈
	List<RemainSeat> rlist; List<RemainSeat> temp_rlist; List<ScreenInfo> list;

	static int screenNumber = 5;

	ReservationBoardPan4(int round) {
		
		rlistSet(); temp_rlist = new ArrayList<>(); 

		
		this.setLayout(new GridLayout(screenNumber * 2, 1));
		this.setBackground(Color.WHITE);
		screenTime = new JLabel[screenNumber];
		ck = new JCheckBox[screenNumber];
		
		for(RemainSeat i:rlist) { //리스트 중 입력 받은 상영관 정보만 저장할 임시 리스트 생성
			if(i.screen == round) {
				temp_rlist.add(i);
			}
		}
		
		for (int i = 0; i < temp_rlist.size(); i++) {

			screenTime[i] = new JLabel(""+temp_rlist.get(i).reserve_time);
			ck[i] = new JCheckBox(""+temp_rlist.get(i).remainNumber + " / " + "160" + "   예약된 좌석수 :  "+(160-temp_rlist.get(i).remainNumber));
			this.add(screenTime[i]);
			this.add(ck[i]);
		}

	}
	
	public void rlistSet() {
		list = new ArrayList<>();
		rlist = new ArrayList<>(); // 순서대로 1관 1회부터 1-2,1-3 좌석정보 클래스 저장

		CRUDprocess cp = new CRUDprocess();
		list = cp.selectScreenInfo();

		for (ScreenInfo i : list) {

			if (i.screen_screen == 1) {

				if (i.screen_round == 1)
					rlist.add(new RemainSeat(1, 1, i.screen_begin));
				if (i.screen_round == 2)
					rlist.add(new RemainSeat(1, 2, i.screen_begin));
				if (i.screen_round == 3)
					rlist.add(new RemainSeat(1, 3, i.screen_begin));
				if (i.screen_round == 4)
					rlist.add(new RemainSeat(1, 4, i.screen_begin));
				if (i.screen_round == 5)
					rlist.add(new RemainSeat(1, 5, i.screen_begin));

			}

			if (i.screen_screen == 2) {

				if (i.screen_round == 1)
					rlist.add(new RemainSeat(2, 1, i.screen_begin));
				if (i.screen_round == 2)
					rlist.add(new RemainSeat(2, 2, i.screen_begin));
				if (i.screen_round == 3)
					rlist.add(new RemainSeat(2, 3, i.screen_begin));
				if (i.screen_round == 4)
					rlist.add(new RemainSeat(2, 4, i.screen_begin));
				if (i.screen_round == 5)
					rlist.add(new RemainSeat(2, 5, i.screen_begin));

			}

			if (i.screen_screen == 3) {

				if (i.screen_round == 1)
					rlist.add(new RemainSeat(3, 1, i.screen_begin));
				if (i.screen_round == 2)
					rlist.add(new RemainSeat(3, 2, i.screen_begin));
				if (i.screen_round == 3)
					rlist.add(new RemainSeat(3, 3, i.screen_begin));
				if (i.screen_round == 4)
					rlist.add(new RemainSeat(3, 4, i.screen_begin));
				if (i.screen_round == 5)
					rlist.add(new RemainSeat(3, 5, i.screen_begin));

			}
		}
	}

}