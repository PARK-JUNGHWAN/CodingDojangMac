package javagers.jjy;

import java.awt.Dimension;
import java.awt.Panel;

import javax.swing.JButton;

public class MovieInfoButton extends Panel{
	JButton btn;

	public MovieInfoButton() {
//	super(str);
	btn = new JButton("예매하기");
	this.add(btn);
//	this.setVisible(true);
//	this.setSize(50, 20);
//	this.setLayout(new GridLayout(1,1));
	this.setPreferredSize(new Dimension(30, 50));
}


	public static void main(String[] args) {
		
	}

}
