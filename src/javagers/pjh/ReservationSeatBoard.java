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
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ReservationSeatBoard extends JPanel {
	
	ReservationMovie rm;

	int reserve_people, reserve_price, reserve_seat, reserve_screen, reserve_round, reserve_title, reserve_mnum;
	Date reserve_date; 
//	int dataNum;
	List<ScreenInfo> list; List<String> seatList = new ArrayList<>(160);
	// 다음 패널에 정보를 보낼때는 최종 인원수 만큼만 좌석 정보에서 리스트에서 읽어옴
	
	String movieName = "";

	ReservationSeatBoardPanSeat north;
	ReservationSeatBoardPanDate west;
	SeatChoicePanel center;
	JPanel south;
	ReservationSeatBoardPan2 south1;
	ReservationSeatBoardPan3 south2;
	
	JButton bt;

	ReservationSeatBoard(ReservationMovie rm) {
		
		this.rm = rm;

		this.setLayout(new BorderLayout());
		
		CRUDprocess cp = new CRUDprocess(); //생성시 db내 상영관 정보 리스트 불러옴
		list = new ArrayList<>();
		list = cp.selectScreenInfo();
//		dataNum = list.size();
		
		north = new ReservationSeatBoardPanSeat(this);
		west = new ReservationSeatBoardPanDate(this);
		center = new SeatChoicePanel(this); 
		//center - 비활성화할 좌석 정보 받아야 함: where 영화넘버, 날짜, 회차, (좌석 정보 배열로)
		//최대 인원수 
		
		south = new JPanel();
		south.setLayout(new GridLayout(1, 3));
		south1 = new ReservationSeatBoardPan2(this);
		south2 = new ReservationSeatBoardPan3();
		south.add(south1);
		south.add(south2);
		bt = new JButton("다음"); bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 다음 버튼을 눌렀을때 모든 정보 다음 패널에 전송
				// 영화명, 좌석 list, 시작시간, 상영관 - 클래스로 전송?
				// 상태가 비회원일 경우에는 다이어로그 오픈 비회원 로그인
				// 리저베이션컨펌 패널 오픈
				System.out.println(rm.reservationMoviePan.movieName);
			}
			
		});
		south.add(new JPanel().add(bt));
		
		this.add("North", north);
		this.add("West", west);
		this.add("Center", center);
		this.add("South", south);

		center.setVisible(false); // 좌석 선택 감춤
//		north.one.one.setVisible(false); // 시간 선택 감춤
//		south2.setVisible(false);

//		this.setBounds(0, 0, 1200, 800);
//		this.setVisible(true);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
//		new ReservationSeatBoard();

	}

}

class ReservationSeatBoardPanSeat extends JPanel { // 노스 최상단, 메인

	ReservationSeatBoard rsb;
	
	ReservationSeatBoardPanSeatNumber one;

	ReservationSeatBoardPanSeat(ReservationSeatBoard rsb) {
		
		this.rsb = rsb;
		this.setLayout(new BorderLayout());

		this.add("North", new JPanel().add(new JButton("시간")));
		
//		one = new ReservationSeatBoardPanSeatNumber(rsb);
//		this.add("Center", one);

	}

}

class ReservationSeatBoardPanSeatNumber extends JPanel {// 노스 2번째 상단

	ReservationSeatBoard rsb;
	ReservationSeatBoardPanSeatNumberPan one;

	ReservationSeatBoardPanSeatNumber(ReservationSeatBoard rsb) {
		
		this.rsb = rsb;

		one = new ReservationSeatBoardPanSeatNumberPan(rsb);

		this.setLayout(new BorderLayout());
		this.add("North", new JPanel().add(new JLabel(
				"                                                                                                                          시간을 선택하시오.")));
		this.add("Center", one);
	}
}

class ReservationSeatBoardPanSeatNumberPan extends JPanel implements ActionListener{
	// 노스 마지막, 상영시간 , 잔여좌석수 출력
	ReservationSeatBoard rsb;
	JButton[] button; 
	JLabel[] label; // 좌석 표시 라벨
	String[] seatNumber; // 좌석 정보 저장 배열 
	StringBuffer seat;
	String[] str;
	String[] number;
	
	int remainSeat, inSeat; int maxSeat = 160;
	
	List<ScreenInfo> list; List<ReserveInfo> Relist;
	int j=0; int t=0;
	String movieName;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservationSeatBoardPanSeatNumberPan other = (ReservationSeatBoardPanSeatNumberPan) obj;
		if (movieName == null) {
			if (other.movieName != null)
				return false;
		} else if (!movieName.equals(other.movieName))
			return false;
		return true;
	}

	ReservationSeatBoardPanSeatNumberPan(ReservationSeatBoard rsb) {
		
		this.rsb = rsb;
		this.list = rsb.list;
		
		// 잔여 좌석 계산
		Relist = new ArrayList<>();
		CRUDprocess cp = new CRUDprocess();
		Relist = cp.selectReserveInfo();
		//리스트에서 좌석 정보를 배열에 저장하는데 ,를 구분하며 null 값은 넣지 않는다.
		seatNumber = new String[Relist.size()];
		seat = new StringBuffer("");
		for(ReserveInfo i:Relist) {
			if(i != null) {
				
				if(i.reserve_seat.contains(",")) {
					i.reserve_seat.replace(", ","");
					seat.append(i.reserve_seat);
					System.out.println("1");
				} else {
					seat.append(i.reserve_seat);
				}
			}
		}
		System.out.println(seat);
		
		
		str = new String[list.size()];
		
		for(ScreenInfo i:list) {
			
			movieName = i.screen_mname;
			
			if(movieName.equals(rsb.movieName)) { //초이스 영화명과 같으면
				str[j] =i.screen_begin;
				j++;
			}
		}
		
		number = new String[j]; // 리메인시트 정보를 삽입, 스크린과 회차 맞춰서
		
		button = new JButton[j];
		label = new JLabel[j];

		for (int i = 0; i < j; i++) {
			button[i] = new JButton(str[i] + ""); // 시간 표시 버튼 생성 및 최초 입력
			
			label[i] = new JLabel(number[i] + ""); // 좌석 표시 라벨 생성
			this.add(button[i]); button[i].addActionListener(this);
			this.add(label[i]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {//좌석 선택 패널 활성화
		rsb.center.setVisible(true);
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
		int dayOfWeek = today.get(Calendar.DAY_OF_WEEK);
		dayOfWeek = dayOfWeek - 1;

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

class ReservationSeatBoardPan2 extends JPanel implements ItemListener{// 사우스 그리드 1번째
	
	ReservationSeatBoard rsb;
	JComboBox[] combo;
	JLabel[] label;
	String[] str = { "0", "1", "2", "3", "4", "5", "6", "7", "8" };
	int adultNumber, youngNumber, totalNumber;

	ReservationSeatBoardPan2(ReservationSeatBoard rsb) {
		
		this.rsb = rsb;
		
		combo = new JComboBox[2];
		label = new JLabel[2];

		combo[0] = new JComboBox(str); combo[0].addItemListener(this);
		combo[1] = new JComboBox(str); combo[1].addItemListener(this);
//		combo[2] = new JComboBox(str);
		label[0] = new JLabel("일반");
		label[1] = new JLabel("청소년"); 
//		label[2] = new JLabel("우대");

		this.setLayout(new GridLayout(2, 2));
		this.add(label[0]); 
		this.add(combo[0]);
		this.add(label[1]);
		this.add(combo[1]);
//		this.add(label[2]);
//		this.add(combo[2]);

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// 이걸 클릭하면 시트초이스 팬의 최대 클릭 인원수 변경
		// 일반+청소년 
		
		adultNumber = Integer.parseInt(combo[0].getSelectedItem().toString());
		youngNumber = Integer.parseInt(combo[1].getSelectedItem().toString());
		
		totalNumber = adultNumber + youngNumber;
		
		rsb.center.one.one.maxNumber = totalNumber;
	}
}

class ReservationSeatBoardPan3 extends JPanel {// 사우스 그리드 2번째, 인원, 금액
	//rsb.south2

	JLabel people, price;
	JTextField peopleText, priceText;

	ReservationSeatBoardPan3() {

		this.setLayout(new GridLayout(2, 2));
	
		people = new JLabel("  인원:   ");
		peopleText = new JTextField("0"); peopleText.setEditable(false);
		price = new JLabel("  가격:   ");
		priceText = new JTextField("0"); priceText.setEditable(false);
		this.add(people);
		this.add(peopleText);
		this.add(price);
		this.add(priceText);
	}
}