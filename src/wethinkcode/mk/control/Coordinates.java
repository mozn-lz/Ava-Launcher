package wethinkcode.mk.control;

public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;

	public Coordinates(int longitude, int latitude, int height) {
	 	this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}

	public int getLongitude() {
		// System.out.println("\t\tlon = " + longitude);
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public int getLatitude() {
		// System.out.println("\t\tlat = " + latitude);
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getHeight() {
		// System.out.println("\t\thei = " + height);
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
