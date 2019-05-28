package javagers.pjh;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NotUserReserve extends JFrame {
	NotUserReservePan notUserReservePan;
	JButton button;
	
	NotUserReserve() {
		notUserReservePan = new NotUserReservePan();
		button = new JButton("비회원 로그인");
		this.add("Center", notUserReservePan);
		this.add("South", button);

		this.setBounds(0, 0, 1200, 800);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new NotUserReserve();

	}

}

class NotUserReservePan extends JPanel {
	JLabel phoneNumber;
	JTextField phoneNumberText;

	NotUserReservePan() {

		phoneNumber = new JLabel("전화번호를 입력하세요.");
		phoneNumberText = new JTextField(30);

		this.add(phoneNumber);
		this.add(phoneNumberText);

	}
}
