package javagers.kdw;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginSystem extends JFrame {
	JLabel id_info, pwd_info;
	JTextField id_txt, pwd_txt;
	JButton login, notuserIdReserve, createnew, findIDPW, checkReserve;
	JPanel pan_id, pan_pwd, pan_button;


	public LoginSystem(String str) {
    	super(str);
    	this.setLayout(new BorderLayout());
		id_info = new JLabel("ID"); 
		id_txt = new JTextField(10); 
		pwd_info = new JLabel("비밀번호"); 
		pwd_txt = new JTextField(10); 
		pan_id = new JPanel();
		pan_id.add(id_info); pan_id.add(id_txt);
		pan_pwd = new JPanel();
		pan_pwd.add(pwd_info); pan_pwd.add(pwd_txt);
		
		
		login = new JButton("로그인");
		notuserIdReserve = new JButton("비회원 예매");
		findIDPW = new JButton("아이디/PW 찾기");
		createnew = new JButton("회원가입");
		checkReserve = new JButton("예매조회");
		
		pan_button = new JPanel();
		pan_button.add(login); 
		pan_button.add(notuserIdReserve);
		pan_button.add(findIDPW);
		pan_button.add(checkReserve);
		pan_button.add(createnew);
	
		
		
		JPanel north = new JPanel(); north.setLayout(new GridLayout(2,1));
		north.add(pan_id); north.add(pan_pwd);
		
		
		this.add("North",north); this.add("South",pan_button);
		this.setBackground(Color.ORANGE);
    	this.setSize(400,300);
		this.setBackground(Color.orange);
     	this.setVisible(true);
	}

	public static void main(String[] args) {
		new LoginSystem("영화정보시스템");

		
	}

}


