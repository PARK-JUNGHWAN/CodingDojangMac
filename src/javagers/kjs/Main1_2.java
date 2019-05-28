package javagers.kjs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main1_2 extends JFrame{
	Font font;
	JPanel NorthPanel;
	JPanel Main1_2;
	JButton	select1_2;
	JLabel[] labels;
	JTextField[] textField;
	String[] label_title= {"이름","   아이디","   전화번호",};
	JLabel[] labels_1;
	String[] labels_1_title = {"이름       ","아이디     ","전화번호   ","생년월일   ","성별   "};
	JTextField[] birtextField_1;
	JPanel[] panels;
	JComboBox combo;
	JPanel SouthPanel;
	JButton ok;
	JButton cancel;
	JLabel empty;
	
	void makeLabel() {
		labels = new JLabel[3];
		for(int i=0; i<labels.length; i++) {
			labels[i] = new JLabel(label_title[i]);//레이블 생성
			labels[i].setFont(font);
		}
		labels_1 = new JLabel[5];
		for(int i=0; i<labels_1.length; i++) {
			labels_1[i] = new JLabel(labels_1_title[i]);//레이블 생성
			labels_1[i].setFont(font);
		}
	}
	void makeTextField() {
		textField = new JTextField[3];//배열 생성
		for(int i=0; i<textField.length-1; i++) {
			textField[i] = new JTextField(10);
			textField[i].setFont(font);
			textField[2] = new JTextField(17);
		}
		birtextField_1 = new JTextField[4];
		for(int i=0; i<birtextField_1.length; i++) {
			birtextField_1[i] = new JTextField(20);
			birtextField_1[i].setFont(font);
		}
	}	
	void makePanel() {
		panels = new JPanel[5];
		for(int i=0; i<panels.length;i++) {
			panels[i] = new JPanel();
			panels[i].setLayout(new FlowLayout());
		}
	}
	void init() {
		font = new Font("굴림", Font.BOLD,15);
		NorthPanel = new JPanel();
		Main1_2 = new JPanel();
		SouthPanel = new JPanel();
		select1_2 = new JButton("조회");
		select1_2.setFont(font);
		makeLabel(); makeTextField(); makePanel();
		combo = new JComboBox();
		combo.addItem("    남    ");combo.addItem("    여    ");
		ok = new JButton("완료");
		cancel = new JButton("취소");
		empty = new JLabel("     ");
		ok.setFont(font);
		cancel.setFont(font);
		NorthPanel.setPreferredSize(new Dimension(200,60)); 
		SouthPanel.setPreferredSize(new Dimension(200,60)); 

		NorthPanel.add(labels[0]);
		NorthPanel.add(textField[0]);
		NorthPanel.add(labels[1]);
		NorthPanel.add(textField[1]);
		NorthPanel.add(labels[2]);
		NorthPanel.add(textField[2]);
		NorthPanel.add(select1_2);
		
		panels[0].add(labels_1[0]);
		panels[0].add(birtextField_1[0]);
		panels[1].add(labels_1[1]);
		panels[1].add(birtextField_1[1]);
		panels[2].add(labels_1[2]);
		panels[2].add(birtextField_1[2]);
		panels[3].add(labels_1[3]);
		panels[3].add(birtextField_1[3]);
		panels[4].add(labels_1[4]);
		panels[4].add(combo);
		
		SouthPanel.add(ok);
		SouthPanel.add(empty);
		SouthPanel.add(cancel);
	}
	public Main1_2(String str) {
		super(str);
		init();
		this.setLayout(new BorderLayout());
		this.add("North", NorthPanel);
		this.add("Center", Main1_2);
		this.add("South", SouthPanel);
		Main1_2.setLayout(new GridLayout(5,1));
		for(int i=0; i<5; i++) {
			Main1_2.add(panels[i]);
		}


		this.setSize(1200,650); 
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Main1_2("Admin Management");

	}

}