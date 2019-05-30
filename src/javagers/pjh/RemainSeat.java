package javagers.pjh;

import java.util.ArrayList;
import java.util.List;

public class RemainSeat {
	// 이 클래스는 한 관의 한 회차의 남은 좌석 정보를 저장하는 클래
	// RSB가 실행될 때 상영관 정보를 읽어와서 순서대로 이 클래스를 리스트에 저장
	// 라벨에 한번에 다 입력해놓음 - 갱신은 예매현황을 새로 눌러야 가
	
	List<ReserveInfo> list;
	int remainNumber, countNumber, screen, round;
	int maxNumber = 160;
	int[] remainSeat;
	String str; // 리스트에 있는 좌석 정보를 저장할 문자열
	
	RemainSeat(int x, int y){
		
		CRUDprocess cp = new CRUDprocess();
		list = new ArrayList();
		list = cp.selectReserveInfo();
		
		cal(x, y);
		
		countNumber = remainSeat.length;
		remainNumber = maxNumber - countNumber;
		
	}

	public void cal(int screen, int round) {
		// list 순차검색해 있는 좌석을 새로운 배열에 입력
		// 입력이 끝나면 좌석수 계산해서 입력
		// 입력받는 상영관과 회차는 바로 저장: 1관 1회의 남은 좌석 저장하는 클래
		// 좌석은 무조건 3자리씩 입력하고 읽어오

		this.screen = screen;
		this.round = round;

		str = "";

		for (ReserveInfo i : list) {
			str = str + i.reserve_seat;
		}
		
		remainSeat = new int[str.length()];

		String temp = "";
		String temp1 = "";
		int j = 0;

		for (int i = 0; i < str.length()/3; i++) {
			temp = str.substring(3*i, 3*i+1);
			int r=0;
			
			switch(temp) {
			
			case "A": 
				r=1;
				break;
			case "B": 
			
				break;
			case "C": 
				
				break;
			case "D": 
				
				break;
			case "E": 
				
				break;
			case "F": 
				
				break;
			case "G": 
				
				break;
			case "H": 
				
				break;
			case "I": 
				
				break;
			case "J": 
				
				break;
			}
			
			temp1 = str.substring(1+i*3, 3+3*i);
			
			remainSeat[j] = r + Integer.valueOf(temp1);
			j++;
			
		}

	}

}