package javagers.pjh;

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
		
		this.reserve_date = null; //데이터 객체 받아와서 현재 시간으로 입력
		
		double r = (int)(Math.random()*1000) + 10001;
		String temp = String.valueOf(reserve_date) +""+ r;
		this.reserve_rnum = Integer.valueOf(temp); //예매번호 생성, 형식? 날짜 + 번호 순차 증감
		
		this.reserve_id = null; // 로그인 된 상황이면 현재 아이디 받아와서 입력
		this.reserve_people = (reserve_seat.length()/3 != 0) ? reserve_seat.length()/3 :0 ;
		
		this.reserve_price = reserve_price;
		this.reserve_time = reserve_time;
	}

}