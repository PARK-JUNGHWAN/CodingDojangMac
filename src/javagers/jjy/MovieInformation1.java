package javagers.jjy;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MovieInformation1 extends JFrame {

	MovieInfoPanel mip;
	JPanel main;
	ImageIcon m1, m2, m3, m4;
	JButton btn1;
	MovieInfoText movieInfoText;
	MovieInfoButton mib;
	
	public MovieInformation1(String str) {
		super(str);
		m1 = new ImageIcon("src\\javagers\\jjy\\m1.jpg");
		String imgPath1 = "src\\javagers\\jjy\\m1.jpg";
		btn1 = new JButton();
		movieInfoText = new MovieInfoText();
		mib = new MovieInfoButton();
		
		ImageIcon originIcon1 = new ImageIcon(imgPath1);
		Image originImg1 = originIcon1.getImage();
		Image changedImg1= originImg1.getScaledInstance(361, 300, Image.SCALE_SMOOTH );
		ImageIcon Icon1 = new ImageIcon(changedImg1);
		
		btn1.setIcon(Icon1);		//버튼에 이미지 설정
		
		doIt();
		this.setLayout(new BorderLayout());
		main.add(mip);
		main.add(btn1);
		main.add(movieInfoText);
		main.add(mib);
		
		this.add("West",btn1);
		this.add("North",mip);	
		this.add("East",movieInfoText);
		this.add("South",mib);
		this.setSize(1200, 800);
		this.setLocation(180, 80);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	void doIt() {
		main = new JPanel();	
		mip = new MovieInfoPanel();
		
		}
	
	
	public static void main(String[] args) {
		new MovieInformation1("영화정보 테스트1");
	}
	
}
