package javagers.pjh;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ReservationSeatBoard extends JFrame {

	int reserve_people, reserve_price, reserve_seat, reserve_screen, reserve_round, reserve_title;
	Date reserve_date; int dataNum;
	List<ScreenInfo> list;

	ReservationSeatBoardPanSeat north;
	ReservationSeatBoardPanDate west;
	SeatChoicePanel center;
	JPanel south;
	ReservationSeatBoardPan2 south1;
	ReservationSeatBoardPan3 south2;

	ReservationSeatBoard() {

		this.setLayout(new BorderLayout());

		north = new ReservationSeatBoardPanSeat(this);
		west = new ReservationSeatBoardPanDate(this);
		center = new SeatChoicePanel();
		south = new JPanel();
		south.setLayout(new GridLayout(1, 3));
		south1 = new ReservationSeatBoardPan2();
		south2 = new ReservationSeatBoardPan3(this);
		south.add(south1);
		south.add(south2);
		south.add(new JPanel().add(new JButton("다음")));
		
		CRUDprocess cp = new CRUDprocess(); //생성시 db내 상영관 정보 리스트 불러옴
		list = new ArrayList<>();
		list = cp.selectScreenInfo();
		dataNum = list.size();

		this.add("North", north);
		this.add("West", west);
		this.add("Center", center);
		this.add("South", south);

		center.setVisible(false); // 좌석 선택 감춤
		north.one.one.setVisible(false); // 시간 선택 감춤

		this.setBounds(0, 0, 1200, 800);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ReservationSeatBoard();

	}

}

class ReservationSeatBoardPanSeat extends JPanel { // 노스 최상단, 메인

	ReservationSeatBoard rsb;
	
	ReservationSeatBoardPanSeatNumber one;

	ReservationSeatBoardPanSeat(ReservationSeatBoard rsb) {
		
		this.rsb = rsb;
		this.setLayout(new BorderLayout());

		one = new ReservationSeatBoardPanSeatNumber(rsb);

		this.add("North", new JPanel().add(new JButton("시간")));
		this.add("Center", one);

	}

}

class ReservationSeatBoardPanSeatNumber extends JPanel {// 노스 2번째 상단

	ReservationSeatBoard rsb;
	ReservationSeatBoardPanSeatNumberPan one;

	ReservationSeatBoardPanSeatNumber(ReservationSeatBoard rsb) {
		
		this.rsb = rsb;
		rsb.dataNum = 0;

		one = new ReservationSeatBoardPanSeatNumberPan(rsb);

		this.setLayout(new BorderLayout());
		this.add("North", new JPanel().add(new JLabel(
				"                                                                                                                          시간을 선택하시오.")));
		this.add("Center", one);
	}
}

class ReservationSeatBoardPanSeatNumberPan extends JPanel {// 노스 마지막
	ReservationSeatBoard rsb;
	JButton[] button; 
	JLabel[] label;
	String[] str;
	String[] number = { "10석", "12석", "14석", "16석", "18석" };
	List<ScreenInfo> list;
	int j = 0;

	ReservationSeatBoardPanSeatNumberPan(ReservationSeatBoard rsb) {
		
		this.rsb = rsb; this.list = rsb.list;
//		CRUDprocess cp = new CRUDprocess();
//		list = new ArrayList<>();
//		list = cp.selectScreenInfo();
//		len = list.size();
		str = new String[rsb.dataNum];
		
		for(ScreenInfo i:list) {
			str[j] =i.screen_begin;
			System.out.println(str[j]);
			j++;
		}
		
		button = new JButton[rsb.dataNum];
		label = new JLabel[rsb.dataNum];

		for (int i = 0; i < rsb.dataNum; i++) {
			button[i] = new JButton(str[i] + "");
			label[i] = new JLabel(number[i] + "");
			this.add(button[i]);
			this.add(label[i]);
		}
	}
}

class ReservationSeatBoardPanDate extends JPanel {// 웨스트 메인

	GregorianCalendar today;
	ReservationSeatBoardPanday one;
	ReservationSeatBoardPanTime two;
	
	ReservationSeatBoard rsb;

	ReservationSeatBoardPanDate(ReservationSeatBoard rsb) {
		
		this.rsb = rsb;

		today = new GregorianCalendar();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH);

		one = new ReservationSeatBoardPanday(year, month);
		two = new ReservationSeatBoardPanTime(rsb);

		this.setLayout(new BorderLayout());

		this.add("North", one);
		this.add("Center", two);
//		this.add("South",new JPanel().add(new JButton("Month")));
	}
}

class ReservationSeatBoardPanday extends JPanel {// 웨스트 2번째

	JLabel[] label;
	String[] str;

	ReservationSeatBoardPanday(int year, int month) {

		this.setLayout(new GridLayout(3, 1));

		label = new JLabel[3];
		str = new String[3];
		month = month + 1;
		str[0] = "    날짜    ";
		str[1] = "    " + year;
		str[2] = "    " + month + "월";

		for (int i = 0; i < 3; i++) {
			label[i] = new JLabel();
			label[i].setText(str[i]);
			this.add(label[i]);
		}
	}
}

class ReservationSeatBoardPanTime extends JPanel implements ListSelectionListener {// 웨스트 센터

	GregorianCalendar today;
	ReservationSeatBoard rsb;

	JList jlist;
	String[] str;
	String[] dateNumber;
	String[] kor = { "일", "월", "화", "수", "목", "금", "토", "일", "월", "화", "수", "목", "금", "토", "일" };

	ReservationSeatBoardPanTime(ReservationSeatBoard rsb) {

		this.rsb = rsb;

		today = new GregorianCalendar();
		int date = today.get(Calendar.DATE);
		System.out.println(date);
		int dayOfWeek = today.get(Calendar.DAY_OF_WEEK);
		dayOfWeek = dayOfWeek - 1;
		System.out.println(dayOfWeek);

		str = new String[7];
		dateNumber = new String[7];

		for (int i = 0; i < 7; i++) {
			dateNumber[i] = "" + date;
			date = date + 1;
			str[i] = new String(kor[dayOfWeek + i] + "     " + dateNumber[i]);
		}

		jlist = new JList(str);
		jlist.addListSelectionListener(this);

		this.add(jlist);
		this.setBackground(Color.orange);

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		if(!e.getValueIsAdjusting()) {
			rsb.north.one.one.setVisible(true);
		}
	}
}

class ReservationSeatBoardPan2 extends JPanel {// 사우스 그리드 1번째

	JComboBox[] combo;
	JLabel[] label;
	String[] str = { "0", "1", "2", "3", "4", "5", "6", "7", "8" };

	ReservationSeatBoardPan2() {
		combo = new JComboBox[3];
		label = new JLabel[3];

		combo[0] = new JComboBox(str);
		combo[1] = new JComboBox(str);
		combo[2] = new JComboBox(str);
		label[0] = new JLabel("일반");
		label[1] = new JLabel("청소년");
		label[2] = new JLabel("우대");

		this.setLayout(new GridLayout(3, 2));
		this.add(label[0]);
		this.add(combo[0]);
		this.add(label[1]);
		this.add(combo[1]);
		this.add(label[2]);
		this.add(combo[2]);

	}
}

class ReservationSeatBoardPan3 extends JPanel {// 사우스 그리드 2번째, 인원, 금액

	ReservationSeatBoard rsb;
	JLabel people, peopleText, price, priceText;
	int peopleNum, priceNum;

	ReservationSeatBoardPan3(ReservationSeatBoard rsb) {
		this.rsb = rsb;
		this.setLayout(new GridLayout(2, 2));
		peopleNum = rsb.reserve_people;
		priceNum = rsb.reserve_price;
		people = new JLabel("  인원:   ");
		peopleText = new JLabel(peopleNum + "");
		price = new JLabel("  가격:   ");
		priceText = new JLabel(priceNum + "");
		this.add(people);
		this.add(peopleText);
		this.add(price);
		this.add(priceText);
	}
}
