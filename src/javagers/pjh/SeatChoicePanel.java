package javagers.pjh;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SeatChoicePanel extends JPanel {

	SeatChoicePan0 one; List<String> list;
	ReservationSeatBoard rsb;
	int movie_price;

	SeatChoicePanel(ReservationSeatBoard rsb) {
		rsb = rsb;
		this.setLayout(new BorderLayout());

		one = new SeatChoicePan0(rsb);

		this.add("North", new JPanel().add(new JButton("SCREEN")));
		this.add("Center", one);

	}

}

class SeatChoicePan0 extends JPanel {

	SeatChoicePan1 one;
	SeatChoicePanel scp;
	ReservationSeatBoard rsb;

	SeatChoicePan0(ReservationSeatBoard rsb) {
		
		this.rsb = rsb;
		
		this.setLayout(new BorderLayout());

		one = new SeatChoicePan1(rsb);

		this.add("North", new JPanel().add(new JLabel(" \r\n ← \r\n EXIT")));
		this.add("Center", one);
	}

}

class SeatChoicePan1 extends JPanel implements ActionListener{//인원수를 받아와야 함
	
	ReservationSeatBoard rsb;
	SeatChoicePanel scp;
	String temp;
	String[] alph = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
	int[] x; // 영문 배열 숫자로 치환 (a는0, b는 18...)

	int[] disable; // 좌석 정보 db 중 영문자 치환 번호 + 좌석 번호 를 입력

	JButton[] button;
	
	int maxNumber; // 숫자는 인원수 받음
	int number, price;

	SeatChoicePan1(ReservationSeatBoard rsb) {
		this.rsb = rsb;
		
		this.setLayout(new GridLayout(10, 17));
		button = new JButton[170]; 
		int j = 0;
		x = new int[alph.length];
		
		for(int i=0;i<alph.length;i++) {
			x[i] = 18*i;
		}

		for (int i = 0; i < 170; i++) {
			button[i] = new JButton();
			this.add(button[i]);

			if (i % 17 == 0 || i == 0) {// 영문자열 시트 삽입
				temp = alph[j];
				this.button[i].setText(temp); 
				this.button[i].setEnabled(false);
//				this.button[i].setText("<html><font color = red>A</font></html>");
				j++;

			} 
			
			else {//일반 숫자 시트
				int num = i % 17;
				temp = "" + num;
				this.button[i].setText(temp);
				this.button[i].addActionListener(this);
			}
			
			if(i<34) {
				button[i].setBackground(Color.ORANGE);
			} else if(i>101) {
				button[i].setBackground(Color.PINK);
			} else {
				button[i].setBackground(Color.GREEN);
			}
		}

		button[100].setEnabled(false); // for 문으로 button[disable[i]] false 처리

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼을 클릭하면 1.색이 변하고 2.인원수 만큼만 눌리고 
		// 3.한번 더 누르면 색이 원래대로 변하고 클릭수 복원
		// 4.사우스 2번째의 인원수 와 가격 증감해서 표시: 복원 되면 차감해야 함
		//   (가격은 영화 프라이스 * 클릭 인원수)
		// 선택한 좌석 정보를 배열에 저장, 취소 한것은 마이너스 메인의 seatList
		
		JButton bt = (JButton) e.getSource();
		System.out.println(bt.getLocation());
		int x = bt.getLocation().x; int y = bt.getLocation().y; // 52의 배수로 증가, x행 y열
		
		List<ButtonPoint> templist = new ArrayList<>(160);
		
		if(bt.getBackground() != Color.RED && number < maxNumber) { // 한번 클릭하면 빨간색
			bt.setBackground(Color.RED);
			number++; 
			rsb.south2.peopleText.setText(number+""); // 사우스 2번 패널 인원수 변경
			price = number * 10000;
			rsb.south2.priceText.setText(price+""); // 사우스 2번 패널 금액수 변경
			
			//사우스 2번 패널 리로드
//			scp.rsb.south.add(scp.rsb.south2);

			ButtonPoint temp = new ButtonPoint(bt.getLocation().x, bt.getLocation().y);
			templist.add(temp);
		} else if(bt.getBackground() == Color.RED) { // 또 클릭하면 원래색
			int i = bt.getLocation().y;
			if(i<104) {
				bt.setBackground(Color.ORANGE);
			} else if(i>=312) {
				bt.setBackground(Color.PINK);
			} else {
				bt.setBackground(Color.GREEN);
			}
			number--;
			rsb.south2.peopleText.setText(number+""); // 사우스 2번 패널 인원수 변경
			price = number * 10000;
			rsb.south2.priceText.setText(price+""); // 사우스 2번 패널 금액수 변경

			ButtonPoint temp = new ButtonPoint(bt.getLocation().x, bt.getLocation().y);
			templist.remove(temp);
		} else {
			
		}
		
		// templist 를 좌석 정보로 변경해 string list에 저장(null 없는 사이즈 만큼 list 생성)
		
	}
}

class ButtonPointPan {
	int x; int y;
	
	ButtonPointPan(int x, int y){
		this.x = x;
		this.y = y;
	}
}