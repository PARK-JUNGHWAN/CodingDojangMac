package javagers.jjy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MovieInfoText extends JPanel{
	
	Panel[] MovieText;
	JTextArea[] area;
	
	public MovieInfoText() {
//		super();
		this.setLayout(new GridLayout(6,1));
		this.setBackground(Color.LIGHT_GRAY);
		MovieText = new Panel[6];
		for(int i =0; i<MovieText.length;i++) {
			MovieText[i] = new Panel(new GridLayout(6,1));
		}
		area = new JTextArea[6];
		for(int i = 0; i<area.length;i++) {
			area[i] = new JTextArea();
		}
		
		area[0].setText(" 영화명 : 악인전 ");
		area[1].setText(" 장르 : 범죄, 액션 ");
		area[2].setText(" 등급 : 청소년 관람불가 ");
		area[3].setText(" 감독 : 이원태 ");
		area[4].setText(" 주연 : 마동석, 김무열, 김성규 ");
		area[5].setText(" 설명 : 우연히 연쇄살인마의 표적이 되었다. \n" +
				 " 살아난 조직 보스 장동수와 범인잡기에 혈안이 된 강력반 미친개 정태석. \n"
				+ " 타협할 수 없는 두 사람이 연쇄살인마 K를 잡기 위해 손잡는다. \n"
				+ " 표적은 하나, 룰도 하나! \n"
				+ " 먼저 잡는 놈이 갖는다!");
		this.add(area[0]);
		this.add(area[1]);
		this.add(area[2]);
		this.add(area[3]);
		this.add(area[4]);
		this.add(area[5]);
		
//		MovieText[0].add(new Label("��ȭ�� : ������"));	
//		MovieText[1].add(new Label("�帣 : �׼�"));	
//		MovieText[2].add(new Label("��� : û�ҳ� ���� �Ұ�"));			
//		MovieText[3].add(new Label("���� : �̿���"));	
//		MovieText[4].add(new Label("�ֿ� : ������, �蹫��, �輺��"));	
//		MovieText[5].add(new Label("���� : �쿬�� ������θ��� ǥ���� �Ǿ���. \n" +"\n"+
//				 " ��Ƴ� ���� ���� �嵿���� \n" 
//				+ " ������⿡ ������ �� ���¹� ��ģ�� ���¼�. \n"
//				+ " Ÿ���� �� ���� �� ����� ������θ� K�� ��� ���� ����´�.\n"
//				+ " ǥ���� �ϳ�, �굵 �ϳ�!\n"
//				+ " ���� ��� ���� ���´�!"));	
//		this.add(MovieText[0]);
//		this.add(MovieText[1]);
//		this.add(MovieText[2]);
//		this.add(MovieText[3]);
//		this.add(MovieText[4]);
//		this.add(MovieText[5]);
		this.setPreferredSize(new Dimension(790, 1000));
//		this.setSize(500, 550);
//		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
//		new MovieInfoText("�����ؽ�Ʈ�׽�Ʈ");

	}
}

class MovieInfoText2 extends JPanel{
	
	Panel[] MovieText;
	JTextArea[] area;
	
	public MovieInfoText2() {
//		super();
		this.setLayout(new GridLayout(6,1));
		this.setBackground(Color.LIGHT_GRAY);
		MovieText = new Panel[6];
		for(int i =0; i<MovieText.length;i++) {
			MovieText[i] = new Panel(new GridLayout(6,1));
		}
		area = new JTextArea[6];
		for(int i = 0; i<area.length;i++) {
			area[i] = new JTextArea();
		}
		
		area[0].setText(" 영화명 : 어벤져스 : 엔드게임 ");
		area[1].setText(" 장르 : 액션, SF");
		area[2].setText(" 등급 : 12세 관람가");
		area[3].setText(" 감독 : 안소니 루소, 조 루소");
		area[4].setText(" 주연 : 로버트 다우니 주니어, 크리스 에반스, 크리스 헴스워스, 마크 러팔로 등");
		area[5].setText(" 설명 : 인피니티 워 이후 절반만 살아남은 지구 \n" 
				+ " 마지막 희망이 된 어벤져스 \n"
				+ " 먼저 떠난 그들을 위해 모든 것을 걸었다! \n"
				+ " 위대한 어벤져스 \n"
				+ " 운명을 바꿀 최후의 전쟁이 펼쳐진다! ");
		this.add(area[0]);
		this.add(area[1]);
		this.add(area[2]);
		this.add(area[3]);
		this.add(area[4]);
		this.add(area[5]);

		this.setPreferredSize(new Dimension(790, 1000));
//		this.setSize(500, 550);
//		this.setVisible(true);
		
	}
}

class MovieInfoText3 extends JPanel{
	
	Panel[] MovieText;
	JTextArea[] area;
	
	public MovieInfoText3() {
//		super();
		this.setLayout(new GridLayout(6,1));
		this.setBackground(Color.LIGHT_GRAY);
		MovieText = new Panel[6];
		for(int i =0; i<MovieText.length;i++) {
			MovieText[i] = new Panel(new GridLayout(6,1));
		}
		area = new JTextArea[6];
		for(int i = 0; i<area.length;i++) {
			area[i] = new JTextArea();
		}
		
		area[0].setText(" 영화명 : 명탐정 피카츄 ");
		area[1].setText(" 장르 : 액션, 모험, 코미디");
		area[2].setText(" 등급 : 전체 관람가");
		area[3].setText(" 감독 : 롭 레터맨");
		area[4].setText(" 주연 : 라이언 레이놀즈(피카츄 역), 저스티스 스미스(팀 굿맨 역), 캐서린 뉴튼(루시 역) 등 ");
		area[5].setText(" 설명 : 기억을 잃은 채 깨어난 피카츄, 난 누구? 여긴 어디? \n" 
				+ " 유일한 단서는 탐정모자에 적힌 해리란 이름과 주소.  \n"
				+ " 주소 속 아파트에서 자신의 말을 유일하게 알아 듣는 실종된 해리의 아들 팀 굿맨을 만나게 된다.   \n"
				+ " 명탐정의 촉으로 이건 그야말로 대.박.사.건! \n"
				+ " 사라진 아빠를 찾기 위해 피카츄와 떠나는 기상천외한 모험이 시작된다. ");
		this.add(area[0]);
		this.add(area[1]);
		this.add(area[2]);
		this.add(area[3]);
		this.add(area[4]);
		this.add(area[5]);
		this.setPreferredSize(new Dimension(790, 1000));
		
//		this.setSize(500, 550);
//		this.setVisible(true);
		
	}
}

class MovieInfoText4 extends JPanel{
	
	Panel[] MovieText;
	JTextArea[] area;
	
	public MovieInfoText4() {
//		super();
		this.setLayout(new GridLayout(6,1));
		this.setBackground(Color.LIGHT_GRAY);
		MovieText = new Panel[6];
		for(int i =0; i<MovieText.length;i++) {
			MovieText[i] = new Panel(new GridLayout(6,1));
		}
		area = new JTextArea[6];
		for(int i = 0; i<area.length;i++) {
			area[i] = new JTextArea();
		}
		
		area[0].setText(" 영화명 : 배심원들 ");
		area[1].setText(" 장르 : 드라마 ");
		area[2].setText(" 등급 : 12세 관람가");
		area[3].setText(" 감독 : 홍승완");
		area[4].setText(" 주연 : 문소리, 박형식 등");
		area[5].setText(" 설명 : 국민이 참여하는 역사상 최초의 재판이 열리는 날. 모두의 이목이 집중된 가운데,   \n" 
				+ " 나이도 직업도 제각각인 8명의 보통 사람들이 배심원단으로 선정된다.   \n"
				+ " 생애 처음 누군가의 죄를 심판해야 하는 배심원들과 사상 처음으로 일반인들과 재판을 함께해야 하는 재판부.   \n"
				+ " 처음이라 더 잘하고 싶었던 \n"
				+ " 보통 사람들의 가장 특별한 재판이 시작된다! ");
		this.add(area[0]);
		this.add(area[1]);
		this.add(area[2]);
		this.add(area[3]);
		this.add(area[4]);
		this.add(area[5]);
		
		this.setPreferredSize(new Dimension(790, 1000));
//		this.setSize(500, 550);
//		this.setVisible(true);
		
	}
}