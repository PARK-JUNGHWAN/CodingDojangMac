package javagers.pjh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
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
	// rsb - rm.reservationMoviePan
	String[] movie;
	// 스크린 인포에서 영화이름 가져와서 영화선택 라디오 버튼 생성, 메인 노스

	String movieName;
	ButtonGroup group;
	JRadioButton[] button;
	ReservationSeatBoard rsb;
	List<ScreenInfo> list;
	List<RemainSeat> rlist; // 좌석정보 클래스를 저장하는 리스트
	List<MovieInfo> mlist;
	int check = 0;
	String[] temp;
	int j;

	ReservationMoviePan(ReservationSeatBoard rsb) {
		this.rsb = rsb;
		this.list = rsb.list;

		temp = new String[list.size()];

		for (int i = 0; i < list.size(); i++) {
			temp[i] = new String();
		}

		rlist = new ArrayList<>(); // 순서대로 1관 1회부터 1-2,1-3 좌석정보 클래스 저장

		mlist = new ArrayList<>(); // 무비인포 에서 영화목록 불러옴

		CRUDprocess cp = new CRUDprocess();
		mlist = cp.selectMovieInfo();
		
		movie = new String[mlist.size()]; // 영화목록 배열 생성

		int j = 0;

		for (MovieInfo i : mlist) {
			movie[j] = i.MOVIE_NAME;
			j++;
		}

		for (ScreenInfo i : list) {

			if (i.screen_screen == 1) {
//				movie[0] = i.screen_mname;
				for (int t = 1; t < 6; t++) {
					if (i.screen_round == t) {
						rlist.add(new RemainSeat(1, t));
					}
				}
			}

			if (i.screen_screen == 2) {
//				movie[1] = i.screen_mname;
				for (int t = 1; t < 6; t++) {
					if (i.screen_round == t) {
						rlist.add(new RemainSeat(2, t));
					}
				}
			}

			if (i.screen_screen == 3) {
//				movie[2] = i.screen_mname;
				for (int t = 1; t < 6; t++) {
					if (i.screen_round == t) {
						rlist.add(new RemainSeat(3, t));
					}
				}
			}

			if (i.screen_screen == 4) {
//				movie[3] = i.screen_mname;
				for (int t = 1; t < 6; t++) {
					if (i.screen_round == t) {
						rlist.add(new RemainSeat(4, t));
					}
				}
			}

		}

		group = new ButtonGroup();
		button = new JRadioButton[movie.length];

		for (int i = 0; i < movie.length; i++) {

			if (movie[i] != null) {
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

		if (check > 0) {

			for (ScreenInfo i : list) {

				movieName = i.screen_mname;

				if (movieName.equals(rsb.movieName)) { // 초이스 영화명과 같으면
					temp[j] = i.screen_begin + "";
					j++;
				}
			}

			for (int i = 0; i < rsb.north.one.one.button.length; i++) {
				if(temp[i] != null) {
					rsb.north.one.one.button[i].setText(temp[i]);
				} else {
					rsb.north.one.one.button[i].setText("상영예정");
				}
//				rsb.north.one.one.button[i].setText(temp[i]);
			}

			j = 0;

		} else {
			rsb.north.one = new ReservationSeatBoardPanSeatNumber(rsb);
			rsb.north.add("Center", rsb.north.one);
			rsb.setVisible(true);
		}

		check++;
	}

}