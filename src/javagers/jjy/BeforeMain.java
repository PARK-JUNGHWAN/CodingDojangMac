package javagers.jjy;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class BeforeMain extends JFrame {
	JPanel main;	
	BeforeLoginPanel beforeLogin;
	MovieList mList;

	public BeforeMain(String str) {
		super(str);
		doIt();
		this.setLayout(new BorderLayout());
		main.add(beforeLogin);
		main.add(mList);
		
		this.add("Center",mList);
		this.add("North",main);

		this.setSize(1200, 700);
		this.setLocation(180, 140);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
		
	void doIt() {
	main = new JPanel();	//패널을 생성하면서 배치관리자 설정
	beforeLogin = new BeforeLoginPanel();
	mList = new MovieList();
	
	}
	
class MyButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {

		
	}
	
}
	
	
	public static void main(String[] args) {
		new BeforeMain("메인 1차 테스트");
		
	}

}
