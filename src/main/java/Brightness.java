public class Brightness {
	private int bright;
	private boolean status;
	
	Brightness(){
		status = true;
		bright = 1023;
	}

	public int getBright() {
		return bright;
	}

	public void setBright(int bright) {
		this.bright = bright;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public int genBright() {
		bright = (int) ((Math.random()*(1023-0)+0));
		return bright;
	}

}
