
public class Mic {
	private int loud;
	private boolean status;
	
	Mic(){
		status = true;
		loud = 1023;
	}

	public int getLoud() {
		return loud;
	}

	public void setLoud(int loud) {
		this.loud = loud;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public int genLoud() {
		loud = (int) ((Math.random()*(1023-0)+0));
		return loud;
	}
}
