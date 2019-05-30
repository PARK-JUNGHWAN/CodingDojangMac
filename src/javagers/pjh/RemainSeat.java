package javagers.pjh;

import java.util.List;

public class RemainSeat {
	// 이 클래스는 한 관의 한 회차의 남은 좌석 정보를 저장하는 클래
	// RSB가 실행될 때 상영관 정보를 읽어와서 순서대로 이 클래스를 리스트에 저장
	// 라벨에 한번에 다 입력해놓음 - 갱신은 예매현황을 새로 눌러야 가
	
	int remainNumber, countNumber, screen, round;
	int maxNumber = 160;
	static int[] remainSeat;

	public static void main(String[] args) {
		
		String[] temp = new String[] {"A01","A02A03"};
		
		String str = new String("");
		str = str+temp[0]; 
		str = str+temp[1];
		
		int i = 0; int j=0; int r = 0;
		
		remainSeat = new int[3];
		
		while(i<str.length()) {
			
			String s = str.substring(0, 0);
			
			switch(s) {
			
			case "A": 
				r=1;
				System.out.println(r);
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
			
			int t = Integer.parseInt(str.substring(i+1, i+2));
			
			System.out.println(t);
			
			remainSeat[j] = r+t;
			
			System.out.println(remainSeat[j]);
			
			i= i+3;
			j++;
		}
		
	}
	
	public void cal(List<ReserveInfo> list,int screen, int round) {
		// list 순차검색해 있는 좌석을 새로운 배열에 입력
		// 입력이 끝나면 좌석수 계산해서 입력
		// 입력받는 상영관과 회차는 바로 저장: 1관 1회의 남은 좌석 저장하는 클래
		// 좌석은 무조건 3자리씩 입력하고 읽어오
		
		this.screen = screen; this.round = round;
		
		String[] temp = new String[list.size()];
		int j = 0;
		
		for(ReserveInfo i: list) {
			temp[j] = i.reserve_seat;
			j++;
		}
		
		
	}

}
