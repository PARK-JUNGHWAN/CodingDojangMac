package javagers.jjy;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MovieList extends JPanel{
	JButton[] btn;
	ImageIcon m1, m2, m3, m4;
	ImageIcon m1_1;
	
//	public MovieList(String str) {
	public MovieList() {
//		super(str);
		
		m1 = new ImageIcon("src\\javagers\\jjy\\m1.jpg");
		m2 = new ImageIcon("src\\javagers\\jjy\\m2.jpg");
		m3 = new ImageIcon("src\\javagers\\jjy\\m3.jpg");
		m4 = new ImageIcon("src\\javagers\\jjy\\m4.jpg");
		m1_1 = new ImageIcon("src\\javagers\\jjy\\m1_1.jpg");
		
		//�̹��� ������ ����
		String imgPath1 = "src\\\\javagers\\\\jjy\\\\m1.jpg";
		ImageIcon originIcon1 = new ImageIcon(imgPath1);
		Image originImg1 = originIcon1.getImage();
		Image changedImg1= originImg1.getScaledInstance(200, 300, Image.SCALE_SMOOTH );
		ImageIcon Icon1 = new ImageIcon(changedImg1);
		
		String imgPath2 = "src\\\\javagers\\\\jjy\\\\m2.jpg";
		ImageIcon originIcon2 = new ImageIcon(imgPath2);
		Image originImg2 = originIcon2.getImage();
		Image changedImg2= originImg2.getScaledInstance(200, 300, Image.SCALE_SMOOTH );
		ImageIcon Icon2 = new ImageIcon(changedImg2);
		
		String imgPath3 = "src\\\\javagers\\\\jjy\\\\m3.jpg";
		ImageIcon originIcon3 = new ImageIcon(imgPath3);
		Image originImg3 = originIcon3.getImage();
		Image changedImg3= originImg3.getScaledInstance(200, 300, Image.SCALE_SMOOTH );
		ImageIcon Icon3 = new ImageIcon(changedImg3);
		
		String imgPath4 = "src\\\\javagers\\\\jjy\\\\m4.jpg";
		ImageIcon originIcon4 = new ImageIcon(imgPath4);
		Image originImg4 = originIcon4.getImage();
		Image changedImg4= originImg4.getScaledInstance(200, 300, Image.SCALE_SMOOTH );
		ImageIcon Icon4 = new ImageIcon(changedImg4);
		
		String imgPath1_1 = "src\\\\javagers\\\\jjy\\\\m1_1.jpg";
		ImageIcon originIcon1_1 = new ImageIcon(imgPath1_1);
		Image originImg1_1 = originIcon1_1.getImage();
		Image changedImg1_1= originImg1_1.getScaledInstance(200, 300, Image.SCALE_SMOOTH );
		ImageIcon Icon1_1 = new ImageIcon(changedImg1_1);
		
		
		btn = new JButton[4];
		for(int i =0; i<btn.length; i++) {
			btn[i] = new JButton();
		}
		
		btn[0].setIcon(Icon1);		//버튼에 이미지 설정
//		btn[0].setPressedIcon(m1);	//버튼을 눌렀을 때 이미지 설정
		btn[0].setRolloverIcon(Icon1_1);	//버튼에 마우스가 위치했을때 이미지설정
		btn[1].setIcon(Icon2);
//		btn[1].setPressedIcon(m2);	
//		btn[1].setRolloverIcon(m2);	
		btn[2].setIcon(Icon3);
//		btn[2].setPressedIcon(m3);	
//		btn[2].setRolloverIcon(m3);	
		btn[3].setIcon(Icon4);
//		btn[3].setPressedIcon(m4);	
//		btn[3].setRolloverIcon(m4);	
//		this.setLayout(new GridLayout(1,4));
		this.add(btn[0]);
		this.add(btn[1]);
		this.add(btn[2]);
		this.add(btn[3]);
//		this.setSize(800, 300);
//		this.setLocation(380, 260);
//		this.setVisible(true);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	
	
	public static void main(String[] args) {
		
//		new MovieList("메인 영화목록");
	}

}
