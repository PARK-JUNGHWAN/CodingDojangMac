package javagers.pjh;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ReservationMovie extends JPanel {
	ReservationMoviePan reservationMoviePan;
	ReservationSeatBoard rsb;
	ReservationTicket rt; // 좌석선택 완료후 다음 눌렀을 때 오픈되야 함
	BackgroundImage bi;
	
	public ReservationMovie() {

		rsb = new ReservationSeatBoard(this);
		reservationMoviePan = new ReservationMoviePan(rsb); reservationMoviePan.setBackground(new Color(98,2,3));
		bi = new BackgroundImage(this);
		
		this.setLayout(new BorderLayout());
		this.add("North", reservationMoviePan);
		this.add("Center",bi);
//		this.add("Center", rsb);

		bi.setVisible(true);
//		rsb.setVisible(false);

//	    rt = new ReservationTicket();
//	    this.add("Center",rt);
//	    rt.setVisible(false);

//		this.setBounds(0, 0, 1000, 700);
		this.setVisible(true);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
//		new ReservationMovie();

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

				if (i.screen_round == 1)
					rlist.add(new RemainSeat(1, 1, i.screen_begin));
				if (i.screen_round == 2)
					rlist.add(new RemainSeat(1, 2, i.screen_begin));
				if (i.screen_round == 3)
					rlist.add(new RemainSeat(1, 3, i.screen_begin));
				if (i.screen_round == 4)
					rlist.add(new RemainSeat(1, 4, i.screen_begin));
				if (i.screen_round == 5)
					rlist.add(new RemainSeat(1, 5, i.screen_begin));

			}

			if (i.screen_screen == 2) {

				if (i.screen_round == 1)
					rlist.add(new RemainSeat(2, 1, i.screen_begin));
				if (i.screen_round == 2)
					rlist.add(new RemainSeat(2, 2, i.screen_begin));
				if (i.screen_round == 3)
					rlist.add(new RemainSeat(2, 3, i.screen_begin));
				if (i.screen_round == 4)
					rlist.add(new RemainSeat(2, 4, i.screen_begin));
				if (i.screen_round == 5)
					rlist.add(new RemainSeat(2, 5, i.screen_begin));

			}

			if (i.screen_screen == 3) {

				if (i.screen_round == 1)
					rlist.add(new RemainSeat(3, 1, i.screen_begin));
				if (i.screen_round == 2)
					rlist.add(new RemainSeat(3, 2, i.screen_begin));
				if (i.screen_round == 3)
					rlist.add(new RemainSeat(3, 3, i.screen_begin));
				if (i.screen_round == 4)
					rlist.add(new RemainSeat(3, 4, i.screen_begin));
				if (i.screen_round == 5)
					rlist.add(new RemainSeat(3, 5, i.screen_begin));

			}

			if (i.screen_screen == 4) {

				if (i.screen_round == 1)
					rlist.add(new RemainSeat(4, 1, i.screen_begin));
				if (i.screen_round == 2)
					rlist.add(new RemainSeat(4, 2, i.screen_begin));
				if (i.screen_round == 3)
					rlist.add(new RemainSeat(4, 3, i.screen_begin));
				if (i.screen_round == 4)
					rlist.add(new RemainSeat(4, 4, i.screen_begin));
				if (i.screen_round == 5)
					rlist.add(new RemainSeat(4, 5, i.screen_begin));

			}

		}

		group = new ButtonGroup();
		button = new JRadioButton[movie.length];

		for (int i = 0; i < movie.length; i++) {

			if (movie[i] != null) {
				button[i] = new JRadioButton();
				button[i].setText(movie[i]);
				button[i].addActionListener(this);
				button[i].setBackground(new Color(98,2,3));
				button[i].setForeground(Color.WHITE);
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
	public void actionPerformed(ActionEvent e) {// 영화명 클릭하면 상영시간 창 생성
		// 클릭하면 영화명 저장, 날짜 창만 보이고 시간 선택창은 안보이게
		
		movieName = e.getActionCommand();

		rsb.movieName = movieName;

		if (check < 1) {
			

			rsb.rm.add("Center", rsb);

			rsb.rm.bi.setVisible(false);
			rsb.setVisible(true);
			
			// 시간선택 패널 생성
			rsb.north.one.one = new ReservationSeatBoardPanSeatNumberPan(rsb);
			rsb.north.one.add("Center", rsb.north.one.one);
			rsb.setVisible(true);
			rsb.north.one.one.setVisible(false);
		} else {
//			System.out.println(check+" 번 이상 클릭");
			
			rsb.north.one.one.setVisible(false);
			rsb.north.one.one = new ReservationSeatBoardPanSeatNumberPan(rsb);
			rsb.north.one.add("Center", rsb.north.one.one);
			rsb.setVisible(true);
			rsb.north.one.one.setVisible(false);
		}

//		if (check > 0) {
//
//			for (ScreenInfo i : list) {
//
//				movieName = i.screen_mname;
//
//				if (movieName.equals(rsb.movieName)) { // 초이스 영화명과 같으면
//					temp[j] = i.screen_begin + "";
//					j++;
//				}
//			}
//
//			for (int i = 0; i < rsb.north.one.one.button.length; i++) {
//				if(temp[i] != null) {
//					rsb.north.one.one.button[i].setText(temp[i]);
//				} else {
//					rsb.north.one.one.button[i].setText("상영예정");
//				}
//			}
//
//			j = 0;
//
//		} else {
//		
//		}
//
		check++;
	}

}

class BackgroundImage extends JPanel {
	
	ImageIcon icon;
	ReservationMovie rm;
	
	BackgroundImage(ReservationMovie rm) {
		this.rm = rm;
		
		icon = new ImageIcon("src\\javagers\\image\\mainImage.jpg");
		
	}
	
	public void paintComponent(Graphics g) {
        //  Approach 1: Dispaly image at at full size
        g.drawImage(icon.getImage(), 0, 0, null);
        
        //  Approach 2: Scale image to size of component
        // Dimension d = getSize();
        // g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
        // Approach 3: Fix the image position in the scroll pane
        // Point p = scrollPane.getViewport().getViewPosition();
        // g.drawImage(icon.getImage(), p.x, p.y, null);
        setOpaque(false);
        super.paintComponent(g);
    }
	
}