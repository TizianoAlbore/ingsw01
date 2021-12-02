
public class Temperature {
	private boolean status;
	private int temp, hum;
	
	Temperature(){
		status = true;
		temp = 93;
		hum = 70;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	public int getHum() {
		return hum;
	}

	public void setHum(int hum) {
		this.hum = hum;
	}
	
	public int genTemp() {
		temp = (int) ((Math.random()*(93-0)+0));
		return temp - 25;
	}
	
	public int genHum() {
		hum = (int) ((Math.random()*(70-0)+0));
		return hum + 20;
	}

}
