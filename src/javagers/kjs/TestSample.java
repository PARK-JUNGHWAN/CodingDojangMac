package javagers.kjs;

import javax.swing.JFrame;

public class TestSample extends JFrame{
	adminMain1 adminmain1;
	
	public TestSample(String str) {
		super(str);
		adminmain1 = new adminMain1("1");
		this.add(adminmain1);
		
		this.setSize(1200,800); 
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
	public static void main(String[] args) {
		new TestSample("Admin Management");

	}

}
