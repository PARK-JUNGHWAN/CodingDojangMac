package javagers.jjy;

public class Theatre {
	
	public void start () {
		TheatreProgram program = new TheatreProgram();
		program.startProgram();
	}

	public static void main(String[] args) {
		
		Theatre theatre = new Theatre();
		theatre.start();

	}

}
