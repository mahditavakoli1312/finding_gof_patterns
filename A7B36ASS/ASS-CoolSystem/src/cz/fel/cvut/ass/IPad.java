package cz.fel.cvut.ass;

public class IPad extends Thing {
	private long serial;

	public long getSerial() {
		return serial;
	}

	public void setSerial(long serial) {
		this.serial = serial;
	}
	
	IPad(){}
	public IPad clone(){
		IPad p = (IPad) super.clone();
		p.setSerial(serial);
		return p;
	}
}
