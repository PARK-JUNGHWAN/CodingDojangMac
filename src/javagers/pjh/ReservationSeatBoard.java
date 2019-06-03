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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ReservationSeatBoard extends JPanel {

	ReservationMovie rm;

	int reserve_people, reserve_price, reserve_seat, reserve_screen, reserve_round, reserve_title, reserve_mnum;
	Date reserve_date;
//	int dataNum;
	List<ScreenInfo> list;
	List<String> seatList = new ArrayList<>(160);
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

		CRUDprocess cp = new CRUDprocess(); // 생성시 db내 상영관 정보 리스트 불러옴
		list = new ArrayList<>();
		list = cp.selectScreenInfo();
//		dataNum = list.size();

		north = new ReservationSeatBoardPanSeat(this);
		west = new ReservationSeatBoardPanDate(this);

		center = new SeatChoicePanel(this);

		south = new JPanel();
		south.setLayout(new GridLayout(1, 3));
		south1 = new ReservationSeatBoardPan2(this);
		south2 = new ReservationSeatBoardPan3();
		south.add(south1);
		south.add(south2);
		bt = new JButton("다음");
		bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 다음 버튼을 눌렀을때 모든 정보 다음 패널에 전송
				// 영화명, 좌석 list, 시작시간, 상영관 - 클래스로 전송?
				// 상태가 비회원일 경우에는 다이어로그 오픈 비회원 로그인
				// 리저베이션컨펌 패널 오픈

				int[] temp = new int[rm.rsb.south1.totalNumber];
				int j = 0;
				int t = 0;

				if (rm.rsb.west.two.dayDate == 0) {
					JOptionPane.showMessageDialog(null, "날짜를 선택하세요.");
				} else {
					try {

						for (JButton i : rm.rsb.center.one.one.button) { // 배열안에 디서블 숫자 입력
							if (i.getBackground() == Color.RED) {
								temp[j] = t;
								j++;
							}
							t++;
						}

						if (rm.rsb.south1.totalNumber > j || j == 0) {
							JOptionPane.showMessageDialog(null, "인원수가 맞지 않거나 선택되지 않았습니다.");
						} else { // 성공시 넘어갈 작업 - 배열 안의 숫자로 좌석 넘버 계산해서 17나눠서 몫은 문자, 나머지는 숫자
							// 예약 성공화면 비저블 또는 생성? 나머지 다른 패널은 인비저블
							// 좌석정보, 인원, 금액, 영화명 정보 필요 - 리저브인포 값으로 전달?
							String str = "";
							String[] alph = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };

							for (int i = 0; i < temp.length; i++) {

								int a = temp[i] / 17;
								int b = temp[i] % 17;

								if (temp[i] % 17 > 9) {
									str = str + alph[a] + "" + b; // 좌석 정보 저장한 문자열
								} else {
									str = str + alph[a] + "0" + b; // 좌석 정보 저장한 문자열
								}
							}

							rm.reservationMoviePan.setVisible(false);
							rm.rsb.setVisible(false);

//							ReserveInfo ri = new ReserveInfo(rm.rsb.movieName, str, rm.rsb.center.one.one.rs.screen,
//									rm.rsb.center.one.one.rs.round, rm.rsb.center.one.one.price,
//									rm.rsb.center.one.one.rs.reserve_time, rm.rsb.west.two.dayDate);
							
							ReserveInfo ri = new ReserveInfo(rm.rsb.north.one.one.tempRlist.get(rm.rsb.north.one.one.index),rm.rsb.movieName, 
									rm.rsb.center.one.one.price, rm.rsb.west.two.dayDate, str);

//							ri.reserve_date.setDate(rm.rsb.west.two.dayDate); // 선택한 날짜로 변경

							rm.rt = new ReservationTicket(ri);
							rm.add("Center", rm.rt);
							rm.rt.setVisible(true);

						}

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "상영시간과 좌석을 선택하세요.");
					}
				}

			}

		});
		south.add(new JPanel().add(bt));

		this.add("North", north);
		this.add("West", west);
		this.add("Center", center);
		this.add("South", south);

		center.setVisible(false); // 좌석 선택 감춤

	}

}

class ReservationSeatBoardPanSeat extends JPanel { // 노스 최상단, 메인

	ReservationSeatBoard rsb;
	ReservationSeatBoardPanSeatNumber one;
//	JButton time;

	ReservationSeatBoardPanSeat(ReservationSeatBoard rsb) {

		this.rsb = rsb;
		this.setLayout(new BorderLayout());
		one = new ReservationSeatBoardPanSeatNumber(rsb);
		
//		time = new JButton("시간"); time.setEnabled(false); time.setForeground(Color.BLUE);

//		this.add("North", new JPanel().add(time));
		this.add("Center",one);

	}

}

class ReservationSeatBoardPanSeatNumber extends JPanel {// 노스 2번째 상단

	ReservationSeatBoard rsb;
	ReservationSeatBoardPanSeatNumberPan one;
	JPanel label;
	JButton labeltxt;

	ReservationSeatBoardPanSeatNumber(ReservationSeatBoard rsb) {

		this.rsb = rsb;
		this.setLayout(new BorderLayout());

//		one = new ReservationSeatBoardPanSeatNumberPan(rsb);
		label = new JPanel();
		labeltxt = new JButton("날짜 및 시간을 선택해주세요."); labeltxt.setEnabled(false);

		this.add("North", label.add(labeltxt));
//		this.add("Center", one);

	}
}

class ReservationSeatBoardPanSeatNumberPan extends JPanel implements ActionListener {
	// 노스 마지막, 상영시간 , 잔여좌석수 출력, rsb.north.one.one
	ReservationSeatBoard rsb;
	IndexJButton[] button; // 시간 선택 버튼
	JLabel[] label; // 좌석 표시 라벨
	String[] seatNumber; // 좌석 정보 저장 배열
	StringBuffer seat;
	String[] str;
	int[] number;

	int remainSeat, countNumber;

	List<ScreenInfo> list;
	List<RemainSeat> rlist; // 메인에서 저장한 잔여좌석 리스트
	List<RemainSeat> tempRlist; // 버튼 생성시 추가한 잔여좌석 리스트
//	int j = 0;
	int t = 0;
	int index;
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
		this.rlist = rsb.rm.reservationMoviePan.rlist; // 남은좌석 정보 리스트 추가
		tempRlist = new ArrayList<>();
		int j = 0; // 버튼 인덱스
		movieName = rsb.movieName;

		// 잔여 좌석 계산

		str = new String[list.size()];
		number = new int[list.size()]; // 리메인시트 정보를 삽입, 스크린과 회차 맞춰서

		for (ScreenInfo i : list) {

//			movieName = i.screen_mname;

			if (movieName.equals(i.screen_mname)) { // 초이스 영화명과 같으면
				str[j] = i.screen_begin; // str 배열에 시간을 저장
				
				for(RemainSeat r:rlist) { //rlist 중 스크린과 회차가 같으면 해당 남은 좌석수를 라벨에 입력
					if(i.screen_screen==r.screen && i.screen_round == r.round) {
						number[j] = r.remainNumber;
						tempRlist.add(r); // 버튼 순서대로 임시리스트에 저장
					}
					
				}
				j++;
			}
		}

		button = new IndexJButton[j];
		label = new JLabel[j];

		for (int i = 0; i < j; i++) {
			button[i] = new IndexJButton(str[i] + "", i); // 시간 표시 버튼 생성 및 최초 입력

			label[i] = new JLabel(number[i] + " / " + 160); // 좌석 표시 라벨 생성
			this.add(button[i]);
			button[i].addActionListener(this);
			this.add(label[i]);
		}

		j = 0; // 시간 순서 초기화

	}

	@Override
	public void actionPerformed(ActionEvent e) {// 좌석 선택 패널 활성화, 버튼별로 스크린, 회차 구분해서 시트초이스패널 생성

		System.out.println(((IndexJButton) e.getSource()).getIndex());
		int j = ((IndexJButton) e.getSource()).getIndex(); //상영 시간 버튼 인덱스
		
		if(rsb.west.two.dayDate == 0) {
			JOptionPane.showMessageDialog(null, "날짜를 먼저 선택해주세요.");
		} else {
			rsb.west.two.jlist.enable(false);
			
			rsb.center.one.one = new SeatChoicePan1(rsb, tempRlist.get(j)); // 좌석 선택 패널 생성
			index = j; //임시리스트 인덱스 저장
			rsb.add("Center", rsb.center.one.one);
			rsb.center.setVisible(true);
			// 영화 라디오 버튼 비활성화
			for (int i = 0; i < rsb.rm.reservationMoviePan.button.length; i++) {
				rsb.rm.reservationMoviePan.button[i].hide();
			}
			rsb.north.one.labeltxt.setText(rsb.west.two.dayDate+ "일 " +rsb.movieName + " 의 상영정보 입니다. 관람하실 인원수 및 좌석을 선택해주세요."); // 선택한 영화명 표시
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

class ReservationSeatBoardPanTime extends JPanel implements ListSelectionListener {// 웨스트 센터, rm.west.two

	GregorianCalendar today;
	ReservationSeatBoard rsb;
	int dayDate;

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
	public void valueChanged(ListSelectionEvent e) {// 날짜를 선택 했을 때 동작, 날짜를 date에 저장, 영화선택 라디오 디서블

		if (!e.getValueIsAdjusting()) {

			System.out.println(jlist.getSelectedValue() + "");

			String temp = jlist.getSelectedValue().toString().substring(6);

			dayDate = Integer.parseInt(temp);
			
			rsb.north.one.one.setVisible(true);

//			System.out.println(temp);

		} else {

//			JOptionPane.showMessageDialog(this, "날짜를 선택하세요.");
		}
	}
}

class ReservationSeatBoardPan2 extends JPanel implements ItemListener {// 사우스 그리드 1번째

	ReservationSeatBoard rsb;
	JComboBox[] combo;
	JLabel[] label;
	String[] str = { "0", "1", "2", "3", "4", "5", "6", "7", "8" };
	int adultNumber, youngNumber, totalNumber;

	ReservationSeatBoardPan2(ReservationSeatBoard rsb) {

		this.rsb = rsb;

		combo = new JComboBox[2];
		label = new JLabel[2];

		combo[0] = new JComboBox(str);
		combo[0].addItemListener(this);
		combo[1] = new JComboBox(str);
		combo[1].addItemListener(this);
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
		// 무비네임 where 무비인포 테이블의 무비 에이지 스트링을 호출해 해당 스트링의 2번째 글자만 읽어서 그 9이상이면 청소년 클릭 제한 걸음

		try {

			adultNumber = Integer.parseInt(combo[0].getSelectedItem().toString());
			youngNumber = Integer.parseInt(combo[1].getSelectedItem().toString());

			totalNumber = adultNumber + youngNumber;

			rsb.center.one.one.maxNumber = totalNumber;

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "날짜와 시간을 먼저 선택하세요.");
		}

	}
}

class ReservationSeatBoardPan3 extends JPanel {// 사우스 그리드 2번째, 인원, 금액
	// rsb.south2

	JLabel people, price;
	JTextField peopleText, priceText;

	ReservationSeatBoardPan3() {

		this.setLayout(new GridLayout(2, 2));

		people = new JLabel("  인원:   ");
		peopleText = new JTextField("0");
		peopleText.setEditable(false);
		price = new JLabel("  가격:   ");
		priceText = new JTextField("0");
		priceText.setEditable(false);
		this.add(people);
		this.add(peopleText);
		this.add(price);
		this.add(priceText);
	}
}