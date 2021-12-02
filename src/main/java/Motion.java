import java.util.Random;

public class Motion {
	private boolean move;
	private boolean status;
	private Random rd = new Random();
	
	Motion(){
		status = true;
		move = false;
	}
	
	public boolean isMove() {
		return move;
	}

	public void setMove(boolean move) {
		this.move = move;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Random getRd() {
		return rd;
	}

	public void setRd(Random rd) {
		this.rd = rd;
	}

	public boolean genMove() {
		move = rd.nextBoolean();
		return move;
	}
}
