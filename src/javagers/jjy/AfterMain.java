package javagers.jjy;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AfterMain extends JFrame {
	JPanel main;	
	MovieList mList;
	AfterLoginPanel afterLogin;

	public AfterMain(String str) {
		super(str);
		doIt();
		this.setLayout(new BorderLayout());
		
		main.add(mList);
		main.add(afterLogin);
		
		this.add("Center",mList);
		this.add("North",main);

		this.setSize(1200, 800);
		this.setLocation(140, 60);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	void doIt() {
	main = new JPanel();	//패널을 생성하면서 배치관리자 설정
	mList = new MovieList();
	afterLogin = new AfterLoginPanel();
	
	}
	
class MyButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {

		
	}
	
}
	
	
	public static void main(String[] args) {
		new AfterMain("메인 1차 테스트");
		
	}

}

