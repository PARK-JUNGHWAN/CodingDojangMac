package javagers.pjh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ReservationMovie extends JFrame {
	ReservationMoviePan reservationMoviePan;
	ReservationSeatBoard rsb;
	
	ReservationMovie(){
		
		rsb = new ReservationSeatBoard(this);
		reservationMoviePan = new ReservationMoviePan(rsb);
		
		this.add("North",reservationMoviePan);
		this.add("Center",rsb); 
		
		rsb.setVisible(false);

		this.setBounds(0,0,1200,800);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ReservationMovie();

	}

}

class ReservationMoviePan extends JPanel implements ActionListener{
	
	String [] movie= {"명탐정 피카츄","어벤져서 엔드게임","걸캅스","자전거왕 엄복동"}; 
	// db 무비 인포에서 영화이름 가져옴- 그냥 스크린정보에서 불러와도 들듯, 중복제거 set?
	// 영화 넘버는 필요 없는듯? 스크린 정보에서도 영화명으로 통일 하는게 나을듯
	
	String movieName;
	ButtonGroup group;
	JRadioButton[] button;
	ReservationSeatBoard rsb;
	
	ReservationMoviePan(ReservationSeatBoard rsb){
		this.rsb = rsb;
		group = new ButtonGroup();
		button = new JRadioButton[movie.length];
		
		for(int i=0;i<movie.length;i++) {
			button[i] = new JRadioButton();
			button[i].setText(movie[i]); 
			button[i].addActionListener(this);
			group.add(button[i]);
			this.add(button[i]);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		movieName = e.getActionCommand();
		System.out.println(movieName);
		
		rsb.setVisible(true);
		
	}
	
}