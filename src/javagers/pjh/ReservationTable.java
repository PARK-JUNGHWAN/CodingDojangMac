package javagers.pjh;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class ReservationTable extends JPanel {
	ReservationTableSearchPanOne reservationTableSearchPanOne;
	ReservationTableSearchPanTwo reservationTableSearchPanTwo;
	
	public ReservationTable(){
		
		reservationTableSearchPanOne = new ReservationTableSearchPanOne(this);
		reservationTableSearchPanTwo = new ReservationTableSearchPanTwo(this);
		
		this.setLayout(new BorderLayout());
		this.add("North",reservationTableSearchPanOne);
		this.add("Center",reservationTableSearchPanTwo);
		
//		this.setBounds(0, 0, 1200, 800);
		this.setVisible(true);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
//		new ReservationTable();

	}

}

class ReservationTableSearchPanOne extends JPanel {
	ReservationTable rt;
	JLabel label;
	JTextField txt;
	TableRowSorter<TableModel> trs;
	
	ReservationTableSearchPanOne(ReservationTable rt){
		this.rt = rt;
		
		label = new JLabel("검색할 날짜를 입력하세요 :  ");
		txt = new JTextField(10);
		txt.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				String val = txt.getText();
				trs = new TableRowSorter<TableModel>(rt.reservationTableSearchPanTwo.table.getModel());
				rt.reservationTableSearchPanTwo.table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
				
			}
			
		});
		
		
		this.add(label); this.add(txt);
	}
	
}

class ReservationTableSearchPanTwo extends JPanel {
	
	JTable table;
	String[] columnName= {"예매 날짜","예매 번호","아이디","전화번호","영화명","상영관","회차","인원","금액","좌석"};
	String[][] data; // db갯수로 행 크기 입력
	JPanel panel;
	JScrollPane scroll;
	List<ReserveInfo> info;
	int number = 0;
	ReservationTable rt;
	TableRowSorter trs;
	
	ReservationTableSearchPanTwo(ReservationTable rt){
		
		this.rt = rt;
		
		CRUDprocess crud = new CRUDprocess();
		ReserveInfo ri = new ReserveInfo();
		
		info = new ArrayList<>();
		info = crud.selectReserveInfo();
		
		data = new String[info.size()][10];
		
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
			int screen = i.reserve_screen;
			data[number][5] = String.valueOf(screen);
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