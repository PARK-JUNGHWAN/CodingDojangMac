package javagers.kjs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main2_2 extends JFrame {
	Font font;
	JPanel NorthPanel;
	JPanel Main2_2;
	JButton	select2_2,Calandar;
	JLabel[] labels;
	JTextField[] textField;
	String[] label_title= {"   상영관  ","            상영일  ","     ", "                          "};
	JComboBox combo1;
	JComboBox combo2;
	
	JPanel[] panels;
	JLabel[] labels_1;
	JTextField[] birtextField_1;
	String[] labels_1_title = {"상영관     ","회차       ","시작시간   ","종료시간   ","상영시간   "};
	JTextArea textarea;
	JScrollPane scrollPane;
	
	JPanel SouthPanel;
	JButton ok;
	JButton cancel;
	JLabel empty;
	
	void makeLabel() {
		labels = new JLabel[4];
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
		textField = new JTextField[4];//배열 생성
		for(int i=0; i<textField.length; i++) {
			textField[i] = new JTextField(10);
			textField[i].setFont(font);
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
		Main2_2 = new JPanel();
		SouthPanel = new JPanel();
		Calandar = new JButton("달력");
		select2_2 = new JButton("조회");
		select2_2.setFont(font);
		Calandar.setFont(font);
		makeLabel(); makeTextField(); makePanel();
		NorthPanel.setPreferredSize(new Dimension(200,60)); 
		combo1 = new JComboBox();
		combo1.addItem("    악인전    ");combo1.addItem("    앤드게임    ");
		combo1.addItem("    피카츄    ");combo1.addItem("    배심원들    ");
		textarea = new JTextArea("DB연동",5,30);
		scrollPane = new JScrollPane(textarea);
		ok = new JButton("완료");
		cancel = new JButton("취소");
		empty = new JLabel("     ");
		ok.setFont(font);
		cancel.setFont(font);
		SouthPanel.setPreferredSize(new Dimension(200,60));
		
		
		NorthPanel.add(labels[0]);
		NorthPanel.add(combo1);
		NorthPanel.add(labels[1]);
		NorthPanel.add(textField[1]);
		NorthPanel.add(labels[2]);
		NorthPanel.add(Calandar);
		NorthPanel.add(labels[3]);
		NorthPanel.add(select2_2);
		
		panels[0].add(labels_1[0]);
		panels[0].add(birtextField_1[0]);
		panels[1].add(labels_1[1]);
		panels[1].add(birtextField_1[1]);
		panels[2].add(labels_1[2]);
		panels[2].add(birtextField_1[2]);
		panels[3].add(labels_1[3]);
		panels[3].add(birtextField_1[3]);
		panels[4].add(labels_1[4]);
		panels[4].add(scrollPane);
		
		SouthPanel.add(ok);
		SouthPanel.add(empty);
		SouthPanel.add(cancel);

	}
	public Main2_2(String str) {
		super(str);
		init();
		this.setLayout(new BorderLayout());
		this.add("North", NorthPanel);
		this.add("Center", Main2_2);
		this.add("South", SouthPanel);
		Main2_2.setLayout(new GridLayout(5,1));
		for(int i=0; i<5; i++) {
			Main2_2.add(panels[i]);
		}
		this.setSize(1200,650); 
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Main2_2("Admin Management");

	}

}