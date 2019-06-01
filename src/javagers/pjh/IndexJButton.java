package javagers.pjh;

import javax.swing.JButton;

public class IndexJButton extends JButton{
	
	private static final long serialVersionUID = -8557137756382038055L;
    private final int index;

    public IndexJButton(String t, int index) {
    super(t);
    this.index = index;
    }

    public int getIndex() {
    return index;
    }

}
