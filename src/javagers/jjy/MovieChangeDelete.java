package javagers.jjy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class MovieChangeDelete extends JFrame {
	JButton btn1, btn2;
	JPanel listPanel;
	JPanel[] panels;
	JLabel[] labels;
	JList jlist;
	JTextField[] textField;
	JComboBox movieName, movieAge, movieScreen;
	JTextArea movieTime, movieInfo;
	String[] labels_title = {"영화번호", "영화명", "영화장르", "영화등급", "상영관", "회차", "금액",
								"영화이미지","영화설명","감독","주연"};
	
	void makeButton() {
		btn1 = new JButton("완 료");
		btn2 = new JButton("취 소");
	}
	
	void makeJlist() {
		listPanel = new JPanel();
		String[] listModel = {"09:00~11:00","11:30~13:30","14:00~16:00","16:30~18:30","19:00~21:00"
								,"21:30~23:30"};
		jlist = new JList(listModel);
		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlist.setBorder(BorderFactory.createLineBorder(Color.black,1));
		jlist.setVisibleRowCount(4);
		JScrollPane scrollPane = new JScrollPane(jlist);
		scrollPane.setPreferredSize(new Dimension(200, 50));
		listPanel.add(scrollPane);
		
		
		
	}
	
	void makeJTextArea() {
		
		movieInfo = new JTextArea(5,20);
		JScrollPane scrollPane = new JScrollPane(movieInfo);
		movieInfo.setPreferredSize(new Dimension(200,50));
		
	}
	
	void makeName() {
		movieName = new JComboBox();		//콤보박스생성 (AWT의 초이스)
		movieName.addItem("영화 선택");
		movieName.addItem("악인전");
		movieName.addItem("어벤져스 : 엔드게임");
		movieName.addItem("명탐정 피카츄");
		movieName.addItem("배심원들");
		
		panels[1].add(movieName);	//panels[1]패널에 콤보박스를 붙임
	}
	
	void makeAge() {
		movieAge = new JComboBox();		
		movieAge.addItem("관람등급 선택");
		movieAge.addItem("전체관람가");
		movieAge.addItem("12세 관람가");
		movieAge.addItem("15세 관람가");
		movieAge.addItem("청소년 관람불가");
		
		panels[3].add(movieAge);
	}
	
	void makeScreen() {
		movieScreen = new JComboBox();		
		movieScreen.addItem("상영관 선택");
		movieScreen.addItem("1관");
		movieScreen.addItem("2관");
		movieScreen.addItem("3관");
		movieScreen.addItem("4관");
		
		panels[4].add(movieScreen);	
	}
	
	void makePanel() {
		panels = new JPanel[12];
		for(int i = 0; i < panels.length; i++) {
			panels[i] = new JPanel();
		}
	}
	
	void makeTextField() {
		textField = new JTextField[6];	
		for(int i = 0 ; i < textField.length; i++) {
			textField[i] = new JTextField(30);
		}
	}
	
	void makeLabel() {
		labels = new JLabel[11];
		for(int i = 0 ; i < labels.length; i++) {
			labels[i] = new JLabel(labels_title[i]);
		}
	}
	
	public MovieChangeDelete(String str) {
		super(str);
		this.setLayout(new GridLayout(12, 2));
		makeJlist();
		makePanel();
		makeAge();
		makeJTextArea();
		makeLabel();
		makeName();
		makeScreen();
		makeTextField();
		makeButton();
		this.setVisible(true);
		this.setLocation(550, 50);
		this.setSize(550, 800);
		panels[0].add(labels[0]);
		panels[0].add(textField[0]);
		panels[1].add(labels[1]);
		panels[1].add(movieName);
		panels[2].add(labels[2]);
		panels[2].add(textField[1]);
		panels[3].add(labels[3]);
		panels[3].add(movieAge);
		panels[4].add(labels[4]);
		panels[4].add(movieScreen);
		panels[5].add(labels[5]);
		panels[5].add(listPanel);
		panels[6].add(labels[6]);
		panels[6].add(textField[2]);
		panels[7].add(labels[7]);
		panels[7].add(textField[3]);
		panels[8].add(labels[8]);
		panels[8].add(movieInfo);
		panels[9].add(labels[9]);
		panels[9].add(textField[4]);
		panels[10].add(labels[10]);
		panels[10].add(textField[5]);
		panels[11].add(btn1);
		panels[11].add(btn2);
		for(int i = 0 ; i < panels.length; i++) {
			this.add(panels[i]);
		}
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public static void main(String[] args) {
		new MovieChangeDelete("테스트");

	}

}