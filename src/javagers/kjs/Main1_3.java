package javagers.kjs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main1_3 extends JFrame{
	Font font;
	JPanel NorthPanel;
	JPanel Main1_1,Main1_2,Main1_3;
	JPanel SouthPanel;
	JButton	select1_3;
	JLabel[] labels;
	JTextField[] textField;
	String[] label_title= {"이름","   아이디","   전화번호","   가입기간"," ~ ", "  "};
	JLabel deleteLable, empty;
	JTextField deleteText;
	JButton deleteButton;
	
	void makeLabel() {
		labels = new JLabel[6];
		for(int i=0; i<labels.length; i++) {
			labels[i] = new JLabel(label_title[i]);//레이블 생성
			labels[i].setFont(font);
		}
	}
	void makeTextField() {
		textField = new JTextField[5];//배열 생성
		for(int i=0; i<textField.length; i++) {
			textField[i] = new JTextField(10);
			textField[i].setFont(font);
		}
	}	
	void init() {
		font = new Font("굴림", Font.BOLD,15);
		NorthPanel = new JPanel();
		Main1_1 = new JPanel();
		Main1_2 = new JPanel();
		Main1_3 = new JPanel();
		SouthPanel = new JPanel();
		select1_3 = new JButton("조회");
		deleteLable = new JLabel(" 삭제할 아이디를 입력 또는 클릭 (' , '로 복수개 입력가능)  ");
		deleteText = new JTextField(20);
		empty = new JLabel("     ");
		deleteButton = new JButton("삭제");
		select1_3.setFont(font);
		deleteButton.setFont(font);
		deleteLable.setFont(font);
		deleteText.setFont(font);
		makeLabel(); makeTextField();
		NorthPanel.setPreferredSize(new Dimension(200,60)); 
		SouthPanel.setPreferredSize(new Dimension(200,80));
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
		NorthPanel.add(labels[5]);
		NorthPanel.add(select1_3);
		SouthPanel.add(deleteLable);
		SouthPanel.add(deleteText);
		SouthPanel.add(empty);
		SouthPanel.add(deleteButton);
		
	}
	public Main1_3(String str) {
		super(str);
		init();
		this.setLayout(new BorderLayout());
		this.add("North", NorthPanel);
		this.add("Center", Main1_3);
		this.add("South", SouthPanel);
		SouthPanel.setBackground(new Color(255,102,102));

		this.setSize(1200,650); 
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Main1_3("Admin Management");

	}

}
