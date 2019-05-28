package javagers.kdw;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main3_1real extends JFrame{
	Font font;
	JPanel NorthPanel;
	JPanel Main1_1,Main1_2,Main1_3;
	JButton	select1_1;
	JLabel[] labels;
	JTextField[] textField;
	String[] label_title= {"영화명","상영관","상영기간"};

	void makeLabel() {
	
		}
	
	void makeTextField() {
		
	}	
	void init() {
		font = new Font("굴림", Font.BOLD,15);
		NorthPanel = new JPanel();
		Main1_1 = new JPanel();
		Main1_2 = new JPanel();
		Main1_3 = new JPanel();
		select1_1 = new JButton("조회");
		select1_1.setFont(font);
		makeLabel(); makeTextField();
		NorthPanel.setPreferredSize(new Dimension(200,60)); 
		
		NorthPanel.add(labels[0]);
		NorthPanel.add(textField[0]);
		NorthPanel.add(labels[1]);
		NorthPanel.add(textField[1]);
		NorthPanel.add(labels[2]);
		NorthPanel.add(textField[2]);
		NorthPanel.add(labels[3]);
		NorthPanel.add(textField[3]);
		NorthPanel.add(labels[4]);
		NorthPanel.add(textField[4]);
		NorthPanel.add(select1_1);
	}
	public Main3_1real(String str) {
		super(str);
		init();
		this.setLayout(new BorderLayout());
		this.add("North", NorthPanel);
		this.add("Center", Main1_1);

		this.setSize(1200,680); 
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Main3_1real("Admin Management");

	}

}