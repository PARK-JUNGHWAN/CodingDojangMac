package javagers.pjh;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NotUserReserveSearch extends JFrame {
	
	NursOne nursOne; NursTwo nursTwo; NursThree nursThree;
	
	public NotUserReserveSearch() {
		this.setLayout(new GridLayout(3,1));
		
		nursOne = new NursOne();
		this.add(nursOne);
		nursTwo = new NursTwo();
		this.add(nursTwo);
		nursThree = new NursThree(nursOne, nursTwo);
		this.add(nursThree);
		
		this.setBounds(0,0,1200,800);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	public static void main(String[] args) {
		new NotUserReserveSearch();

	}

}

class NursOne extends JPanel {
	JLabel ticketNumber, phoneNumber, warning;
	JTextField ticketNumberText, phoneNumberText;
	
	NursOne(){
		ticketNumber = new JLabel("발급 번호");
		phoneNumber = new JLabel("전화 번호");
		warning = new JLabel("둘 중 하나만 입력하세요.");
		
		ticketNumberText = new JTextField(30);
		phoneNumberText = new JTextField(30);
		
		this.add(ticketNumber); this.add(ticketNumberText);
		this.add(phoneNumber); this.add(phoneNumberText);
		this.add(warning);
	}
	
}

class NursTwo extends JPanel {
	JLabel movie, screen, time, seat;
	JTextField movieText, scrennText, timeText, seatText;
	
	NursTwo(){
		movie = new JLabel("영    화");
		screen = new JLabel("상영관");
		time = new JLabel("시    간");
		seat = new JLabel("좌    석");
		
		
		movieText = new JTextField(100);
		scrennText = new JTextField(100);
		timeText = new JTextField(100);
		seatText = new JTextField(100);
		
		this.add(movie); this.add(movieText); 
		this.add(screen); this.add(scrennText); 
		this.add(time); this.add(timeText); 
		this.add(seat); this.add(seatText);
	}
	
}

class NursThree extends JPanel implements ActionListener{
	JButton search, cancle, print;
	NursOne nursOne; NursTwo nursTwo;
	
	NursThree(NursOne nursOne, NursTwo nursTwo){
		this.nursOne = nursOne; this.nursTwo = nursTwo; 
		
		search = new JButton("조 회");
		cancle = new JButton("취 소");
		print = new JButton("티켓 출력");
		
		cancle.addActionListener(this);
		
		this.add(search); this.add(cancle); this.add(print);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == search) {
			
		} else if(obj == cancle) {
			nursOne.ticketNumberText.setText("");
			nursOne.phoneNumberText.setText("");
			nursTwo.movieText.setText("");
			nursTwo.scrennText.setText("");
			nursTwo.seatText.setText("");
			nursTwo.timeText.setText("");
		}
		
	}
}
