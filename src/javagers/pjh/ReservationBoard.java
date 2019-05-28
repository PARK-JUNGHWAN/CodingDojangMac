package javagers.pjh;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReservationBoard extends JFrame {
	
	ReservationBoardPan1 reservationBoardPan1; 
	ReservationBoardPan2 reservationBoardPan2;
	
	ReservationBoard(){
		
		reservationBoardPan1 = new ReservationBoardPan1();
		reservationBoardPan2 = new ReservationBoardPan2();
		
		this.add("North",reservationBoardPan1);
		this.add("Center",reservationBoardPan2);
		
		this.setBounds(0, 0, 1200, 800);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ReservationBoard();

	}

}

class ReservationBoardPan1 extends JPanel implements ActionListener {
	JLabel label; JTextField text; JButton calendar, search;
	
	
	ReservationBoardPan1(){
		label = new JLabel("상영일");
		text = new JTextField(10);
		calendar = new JButton("달력"); calendar.addActionListener(this);
		search = new JButton("조회");
		
		this.add(label); this.add(text); this.add(calendar); this.add(search);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		new CalendarBySwing(this).setLocation(0, 0);
	}
}


class ReservationBoardPan2 extends JPanel {
	
	ReservationBoardPan3 pan1, pan2, pan3, pan4;
	
	ReservationBoardPan2(){
		
		this.setLayout(new GridLayout(1,4));
		
		pan1 = new ReservationBoardPan3();
		pan2 = new ReservationBoardPan3();
		pan3 = new ReservationBoardPan3();
		pan4 = new ReservationBoardPan3();
		
		this.add(pan1); this.add(pan2); this.add(pan3); this.add(pan4);
	}
}

class ReservationBoardPan3 extends JPanel {
	
	static int one = 1;
	String str = "        "+one+" 관 ";
	JLabel label= new JLabel(str);
	ReservationBoardPan4 reservationBoardPan4;
	
	ReservationBoardPan3(){
		
		this.setLayout(new BorderLayout());
		
		this.add("North",new JPanel().add(label));
		one++;
		this.add("Center",new ReservationBoardPan4());
	}
}

class ReservationBoardPan4 extends JPanel {
	
	JLabel[] screenTime;
	String startTime, endTime, startSeat, endSeat;
	String totalTime = startTime+" ~ "+endTime;
	String totalSeat = startSeat+ " / " + endSeat;
	JCheckBox[] ck;
	
	static int screenNumber = 5;
	
	ReservationBoardPan4(){
		this.setLayout(new GridLayout(screenNumber*2,1));
		this.setBackground(Color.WHITE);
		screenTime = new JLabel[screenNumber];
		ck = new JCheckBox[screenNumber];
		
		for(int i=0;i<screenNumber;i++) {

			screenTime[i] = new JLabel(totalTime);
			ck[i] = new JCheckBox(totalSeat);
			this.add(screenTime[i]);
			this.add(ck[i]);
		}
		
	}
	
}