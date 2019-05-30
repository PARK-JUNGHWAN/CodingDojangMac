package javagers.pjh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ReservationMovie extends JFrame {
	ReservationMoviePan reservationMoviePan;
	ReservationSeatBoard rsb;

	ReservationMovie() {

		rsb = new ReservationSeatBoard(this);
		reservationMoviePan = new ReservationMoviePan(rsb);

		this.add("North", reservationMoviePan);
		this.add("Center", rsb);

		rsb.setVisible(false);

		this.setBounds(0, 0, 1200, 800);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ReservationMovie();

	}

}

class ReservationMoviePan extends JPanel implements ActionListener {

	String[] movie;
	// db 무비 인포에서 영화이름 가져옴- 그냥 스크린정보에서 불러와도 들듯, 중복제거 set?
	// 영화 넘버는 필요 없는듯? 스크린 정보에서도 영화명으로 통일 하는게 나을듯

	String movieName;
	ButtonGroup group;
	JRadioButton[] button;
	ReservationSeatBoard rsb;
	List<ScreenInfo> list; 
	int check = 0; String[] temp; int j;

	ReservationMoviePan(ReservationSeatBoard rsb) {
		this.rsb = rsb;
		this.list = rsb.list;

		movie = new String[list.size()];
		
		temp = new String[list.size()];
		
		for(int i=0;i<list.size();i++) {
			temp[i] = new String();
		}

		for (ScreenInfo i : list) {
			
			if(Integer.parseInt(i.screen_screen)==1) {
				movie[0] = i.screen_mname;
			}
			
			if(Integer.parseInt(i.screen_screen)==2) {
				movie[1] = i.screen_mname;
			}
			
			if(Integer.parseInt(i.screen_screen)==3) {
				movie[2] = i.screen_mname;
			}
			
			if(Integer.parseInt(i.screen_screen)==4) {
				movie[3] = i.screen_mname;
			}
			
		}

		group = new ButtonGroup();
		button = new JRadioButton[movie.length];

		for (int i = 0; i < movie.length; i++) {
			
			if(movie[i] != null) {
				button[i] = new JRadioButton();
				button[i].setText(movie[i]);
				button[i].addActionListener(this);
				group.add(button[i]);
				this.add(button[i]);
			}
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservationMoviePan other = (ReservationMoviePan) obj;
		if (movieName == null) {
			if (other.movieName != null)
				return false;
		} else if (!movieName.equals(other.movieName))
			return false;
		return true;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// 클릭하면 영화명 저장후 시간선택창 보이게
		movieName = e.getActionCommand();

		rsb.movieName = movieName;
		
		if(check>0) {
			
			for(ScreenInfo i:list) {
				
				movieName = i.screen_mname;
							
				if(movieName.equals(rsb.movieName)) { //초이스 영화명과 같으면
					temp[j] = i.screen_begin+"";
					j++;
				}
			}
			
			for(int i=0;i<rsb.north.one.one.button.length;i++) {
				rsb.north.one.one.button[i].setText(temp[i]);	
			}
			
			j=0;
			
		} else {
			rsb.north.one = new ReservationSeatBoardPanSeatNumber(rsb);
			rsb.north.add("Center", rsb.north.one);
			rsb.setVisible(true);
		}
		
		check++;
	}

}