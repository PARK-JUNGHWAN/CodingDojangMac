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
	String reserve_time;

	RemainSeat(int x, int y) {

		CRUDprocess cp = new CRUDprocess();
		list = new ArrayList();
		list = cp.selectReserveInfo();

		cal(x, y);

		countNumber = remainSeat.length / 3;
		remainNumber = maxNumber - countNumber;

	}

	RemainSeat(int x, int y, String reserve_time) {

		this.reserve_time = reserve_time;

		CRUDprocess cp = new CRUDprocess();
		list = new ArrayList();
		list = cp.selectReserveInfo();

		cal(x, y);

		countNumber = remainSeat.length / 3;
		remainNumber = maxNumber - countNumber;

	}

	RemainSeat(ReserveInfo ri) {

		CRUDprocess cp = new CRUDprocess();
		list = new ArrayList();
		list = cp.selectReserveInfo();

		cal(ri.reserve_screen, ri.reserve_round);

		countNumber = remainSeat.length / 3;
		remainNumber = maxNumber - countNumber;

		this.reserve_time = ri.reserve_time;

	}

	public void cal(int screen, int round) {
		// list 순차검색해 있는 좌석을 새로운 배열에 입력
		// 입력이 끝나면 좌석수 계산해서 입력
		// 입력받는 상영관과 회차는 바로 저장: 1관 1회의 남은 좌석 저장하는 클래
		// 좌석은 무조건 3자리씩 입력하고 읽어오

		this.screen = screen;
		this.round = round;

		str = "";

		for (ReserveInfo i : list) { //예약정보에서 해당 스크린과 라운드에 해당하는 좌석만 입력
			
			if(screen == i.reserve_screen && round == i.reserve_round)
			
			str = str + i.reserve_seat;
		}

		remainSeat = new int[str.length()];

		String temp = "";
		String temp1 = "";
		int j = 0;

		for (int i = 0; i < str.length() / 3; i++) { //리저브인포에서 좌석넘버 불러서 와서 해당 인덱스 버튼 비활성화
			temp = str.substring(3 * i, 3 * i + 1);
			int r = 0;

			switch (temp) {

			case "A":
				r = 0;
				break;
			case "B":
				r = 17 * 1;
				break;
			case "C":
				r = 17 * 2;
				break;
			case "D":
				r = 17 * 3;
				break;
			case "E":
				r = 17 * 4;
				break;
			case "F":
				r = 17 * 5;
				break;
			case "G":
				r = 17 * 6;
				break;
			case "H":
				r = 17 * 7;
				break;
			case "I":
				r = 17 * 8;
				break;
			case "J":
				r = 17 * 9;
				break;
			}

			temp1 = str.substring(1 + i * 3, 3 + 3 * i);

			remainSeat[j] = r + Integer.valueOf(temp1); // 시트 위치 배열 숫자, 디서블할 인덱스
			j++;

		}

	}

}