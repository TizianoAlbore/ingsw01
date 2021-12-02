
public class ElectroMagn {
	private int magn;
	private boolean status;
	
	ElectroMagn(){
		status = true;
		magn = 1023;
	}

	public int getMagn() {
		return magn;
	}

	public void setBright(int magn) {
		this.magn = magn;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public int genMagn() {
		magn = (int) ((Math.random()*(1023-0)+0));
		return magn;
	}

}
