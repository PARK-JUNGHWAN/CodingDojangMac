package javagers.pjh;

import java.util.Date;

public class ReserveInfo {
	
	String reserve_date;
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
	
	ReserveInfo(){
		
	}
	
	ReserveInfo(int reserve_screen, int reserve_round){
		this.reserve_screen = reserve_screen;
		this.reserve_round = reserve_round;
	}
	
	ReserveInfo(String reserve_title, String reserve_seat, int reserve_screen, int reserve_round, int reserve_price, String reserve_time){
		this.reserve_screen = reserve_screen;
		this.reserve_round = reserve_round;
		this.reserve_title = reserve_title;
		this.reserve_seat = reserve_seat;
		
		this.reserve_date = "190530"; //데이터 객체 받아와서 현재 시간으로 입력
		
		String temp = "";
		double r = (int)(Math.random()*1000) + 10001;
		temp = ""+ (int)r; //String.valueOf(reserve_date) data 값을 넣어야 함
		this.reserve_rnum = Integer.valueOf(temp); //예매번호 생성, 형식? 날짜 + 번호 순차 증감
		
		this.reserve_id = "a"; // 로그인 된 상황이면 현재 아이디 받아와서 입력
		this.reserve_people = (reserve_seat.length()/3 != 0) ? reserve_seat.length()/3 :0 ;
		
		this.reserve_mnum = "1";
		this.reserve_price = reserve_price;
		this.reserve_time = reserve_time;
		this.reserve_num = "2"; //전화번호는 입력 필요 어떻게 할지 문제? 기본값 0으로 두기?
	}

}