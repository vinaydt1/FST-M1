package activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane {

	private List<String> passengers;
	private int maxPassengers;
	private Date lastTimeTookOf;
	private Date lastTimeLanded;

	public Plane(int maxPassengers) {
		this.setMaxPassengers(maxPassengers);
		this.passengers = new ArrayList<>();
	}

	public void onboard(String passenger) {
		this.passengers.add(passenger);
	}

	public Date takeOff() {
		this.lastTimeTookOf = new Date();
		return lastTimeTookOf;
	}

	public void land() {
		this.lastTimeLanded = new Date();
		this.passengers.clear();
	}

	public Date getLastTimeLanded() {
		return lastTimeLanded;
	}

	public List<String> getPassengers() {
		return passengers;
	}

	public int getMaxPassengers() {
		return maxPassengers;
	}

	public void setMaxPassengers(int maxPassengers) {
		this.maxPassengers = maxPassengers;
	}
}