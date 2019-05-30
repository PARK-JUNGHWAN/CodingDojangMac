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

}