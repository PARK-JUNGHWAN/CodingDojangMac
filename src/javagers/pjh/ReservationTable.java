package javagers.pjh;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class ReservationTable extends JFrame {
	ReservationTableSearchPanOne reservationTableSearchPanOne;
	ReservationTableSearchPanTwo reservationTableSearchPanTwo;
	
	ReservationTable(){
		
		reservationTableSearchPanOne = new ReservationTableSearchPanOne();
		reservationTableSearchPanTwo = new ReservationTableSearchPanTwo();
		
		this.add("North",reservationTableSearchPanOne);
		this.add("Center",reservationTableSearchPanTwo);
		
		this.setBounds(0, 0, 1200, 800);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ReservationTable();

	}

}

class ReservationTableSearchPanOne extends JPanel {
	
	JLabel name, reservationNumber, date, dateBar, movieName, screen;
	JTextField nameText, reservationNumberText, startDateText, endDateText, movieNameText, screenText;
	JButton search, totalSearch, calendar;
	String[] strMovie = {"명탐정 피카츄","어벤져스 엔드게임","걸캅스","자전거왕 엄복동"};
	String[] strScreen = {"1","2","3","4"};
	JPanel pan1, pan2; 
	JComboBox movieNameCombo, screenCombo;
	
	
	ReservationTableSearchPanOne(){
		this.setLayout(new GridLayout(2,1));
		
		name = new JLabel("회원명");
		reservationNumber = new JLabel("예매번호");
		date = new JLabel("상영기간");
		dateBar = new JLabel(" ~ ");
		movieName = new JLabel("영화명");
		screen = new JLabel("상영관");
		
		search = new JButton("조회"); totalSearch = new JButton("전체조회"); calendar = new JButton("달력");
		totalSearch.setBackground(Color.GREEN);
		
		nameText = new JTextField(10);
		reservationNumberText = new JTextField(20);
		startDateText = new JTextField(10);
		endDateText = new JTextField(10);
		movieNameCombo = new JComboBox<>();
		screenCombo = new JComboBox<>();
		
		for(int i=0;i<strMovie.length;i++) {
			movieNameCombo.addItem(strMovie[i]);
			screenCombo.addItem(i+1);
		}
		
		
		pan1 = new JPanel(); pan2 = new JPanel();
		
		pan1.add(name); pan1.add(nameText); pan1.add(reservationNumber); pan1.add(reservationNumberText); 
		pan1.add(date); pan1.add(startDateText); pan1.add(dateBar); pan1.add(endDateText); pan1.add(calendar); 
		pan2.add(movieName); pan2.add(movieNameCombo); pan2.add(screen); pan2.add(screenCombo); pan2.add(search); pan2.add(totalSearch);
		
		this.add(pan1); this.add(pan2);
	}
	
}

class ReservationTableSearchPanTwo extends JPanel {
	
	JTable table;
	String[] columnName= {"예매 날짜","예매 번호","아이디","전화번호","영화명","상영관","회차","인원","금액","좌석"};
	String[][] data = new String[10][10]; // db갯수로 행 크기 입력
	JPanel panel;
	JScrollPane scroll;
	List<ReserveInfo> info;
	int number = 0;
	
	ReservationTableSearchPanTwo(){
		
		CRUDprocess crud = new CRUDprocess();
		ReserveInfo ri = new ReserveInfo();
		
		info = new ArrayList<>();
		info = crud.selectReserveInfo();
		
		for(ReserveInfo i: info) {
			
			Date date = i.reserve_date;
			data[number][0] = String.valueOf(date);
			int num = i.reserve_rnum;
			data[number][1] = String.valueOf(num);
			String id = i.reserve_id;
			data[number][2] = id;
			String p_num = i.reserve_num;
			data[number][3] = p_num;
			String title = i.reserve_title;
			data[number][4] = title;
			String screen = i.reserve_screen;
			data[number][5] = screen;
			int round = i.reserve_round;
			data[number][6] = String.valueOf(round);
			int people = i.reserve_people;
			data[number][7] = String.valueOf(people);
			int price = i.reserve_price;
			data[number][8] = String.valueOf(price);
			String seat = i.reserve_seat;
			data[number][9] = seat;

			number++;
		}
		
		table = new JTable(data,columnName); table.setEnabled(false);
		table.setPreferredScrollableViewportSize(new Dimension(1200,600));
		scroll = new JScrollPane(table);
		panel = new JPanel();		
		panel.add(scroll);
		this.add(panel); this.setBackground(Color.ORANGE);
		
	}
}
