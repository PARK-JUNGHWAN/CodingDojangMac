package javagers.kjs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main3_1 extends JFrame{
	Font font;
	JPanel NorthPanel;
	JPanel Main3_1;
	JButton	Calendar,Table,Graph;
	JLabel[] labels;
	JTextField[] textField;
	String[] label_title= {"영화명","   상영관","   상영기간"," ~ ","  ","          "};
	JComboBox combo1;
	JComboBox combo2;
	JPanel SouthPanel;
	JButton ok;

	void makeLabel() {
		labels = new JLabel[6];
		for(int i=0; i<labels.length; i++) {
			labels[i] = new JLabel(label_title[i]);//레이블 생성
			labels[i].setFont(font);
		}
	}
	void makeTextField() {
		textField = new JTextField[4];//배열 생성
		for(int i=0; i<textField.length; i++) {
			textField[i] = new JTextField(10);
			textField[i].setFont(font);
		}
	}	
	void init() {
		font = new Font("굴림", Font.BOLD,15);
		NorthPanel = new JPanel();
		Main3_1 = new JPanel();
		SouthPanel = new JPanel();
		Calendar = new JButton("달력");
		Table = new JButton("Table 조회");
		Table.setFont(font);
		Table.setBackground(new Color(255,153,000));

		Graph = new JButton("Graph 조회");
		Graph.setFont(font);
		Graph.setBackground(new Color(051,255,000));
		makeLabel(); makeTextField();
		combo1 = new JComboBox();
		combo1.addItem("    악인전    ");combo1.addItem("    앤드게임    ");
		combo1.addItem("    피카츄    ");combo1.addItem("    배심원들    ");
		combo2 = new JComboBox();
		combo2.addItem("    1관    ");combo2.addItem("    2관    ");
		combo2.addItem("    3관    ");combo2.addItem("    4관    ");
		
		ok = new JButton("엑셀 조회");
		ok.setBackground(new Color(255,153,000));
		ok.setFont(font);

		NorthPanel.setPreferredSize(new Dimension(200,60)); 
		SouthPanel.setPreferredSize(new Dimension(200,60)); 

		NorthPanel.add(labels[0]);
		NorthPanel.add(combo1);
		NorthPanel.add(labels[1]);
		NorthPanel.add(combo2);
		NorthPanel.add(labels[2]);
		NorthPanel.add(textField[2]);
		NorthPanel.add(labels[3]);
		NorthPanel.add(textField[3]);
		NorthPanel.add(labels[4]);
		NorthPanel.add(Calendar);
		NorthPanel.add(labels[5]);
		NorthPanel.add(Table);
		NorthPanel.add(Graph);

		SouthPanel.add(ok);

	}
	public Main3_1(String str) {
		super(str);
		init();
		this.setLayout(new BorderLayout());
		this.add("North", NorthPanel);
		this.add("Center", Main3_1);
		this.add("South" , SouthPanel);
		this.setSize(1200,650); 
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Main3_1("Admin Management");

	}

}