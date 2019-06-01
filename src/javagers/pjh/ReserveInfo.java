package javagers.pjh;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReserveInfo {

	Date reserve_date;
	int reserve_rnum;
	String reserve_id;
	String reserve_num;
	String reserve_title;
	int reserve_screen;
	int reserve_round;
	int reserve_people;
	int reserve_price;
	String reserve_seat;
	String reserve_mnum;
	String reserve_time;

	ReserveInfo() {

	}

	ReserveInfo(RemainSeat rs, String movie_name, int price, int dayDate, String seat) {
		
		this.reserve_screen = rs.screen;
		this.reserve_round = rs.round;
		this.reserve_title = movie_name;
		this.reserve_seat = seat;
		this.reserve_time = rs.reserve_time;
		this.reserve_price = price;
		
		Date today = new Date();
		this.reserve_date = today;
		
		int year = today.getYear();
		int mon = today.getMonth();
		int date = today.getDate();
		
		String temp = year+mon+date+"";
		double r = (int) (Math.random() * 1000) + 10001;
		temp = ""+(int) r; 
		System.out.println(temp);
		this.reserve_rnum = Integer.valueOf(temp); // 예약번호 문자열로 바꿔야 할듯, '-'등 구분 문자열을 못들어감, 날짜도 안들어감

		this.reserve_id = "a"; // 로그인 된 상황이면 현재 아이디 받아와서 입력
		this.reserve_num = "0"; // 전화번호는 입력은 비회원 로그인 시 받아옴, null 값은 업로드 안됨
		
		this.reserve_people = (reserve_seat.length() / 3 != 0) ? reserve_seat.length() / 3 : 0;
		this.reserve_mnum = "0"; // null 값은 업로드 안됨
		
	}

	ReserveInfo(int reserve_screen, int reserve_round) {
		this.reserve_screen = reserve_screen;
		this.reserve_round = reserve_round;
	}

	ReserveInfo(String reserve_title, String reserve_seat, int reserve_screen, int reserve_round, int reserve_price,
			String reserve_time, int dayDate) {
		this.reserve_screen = reserve_screen;
		this.reserve_round = reserve_round;
		this.reserve_title = reserve_title;
		this.reserve_seat = reserve_seat;

		Date today = new Date();
//		SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		System.out.println(today);
		this.reserve_date = today; // 데이터 객체 받아와서 현재 시간으로 입력
		this.reserve_date.setDate(dayDate); // 날짜를 선택한 날짜로 변경
		System.out.println(reserve_date);

		String temp = "";
		double r = (int) (Math.random() * 1000) + 10001;
		temp = "" + (int) r; // String.valueOf(reserve_date) data 값을 넣어야 함
		this.reserve_rnum = Integer.valueOf(temp); // 예매번호 생성, 형식? 날짜 + 번호 순차 증감

		this.reserve_id = "a"; // 로그인 된 상황이면 현재 아이디 받아와서 입력
		this.reserve_people = (reserve_seat.length() / 3 != 0) ? reserve_seat.length() / 3 : 0;

		this.reserve_mnum = "1";
		this.reserve_price = reserve_price;
		this.reserve_time = reserve_time;
		this.reserve_num = "2"; // 전화번호는 입력 필요 어떻게 할지 문제? 기본값 0으로 두기?
	}

}