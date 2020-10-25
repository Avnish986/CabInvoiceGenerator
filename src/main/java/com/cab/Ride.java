package com.cab;

public class Ride {
	public double distance;
	public int time;

	enum RideType {
		NORMAL, PREMIUM
	}

	public RideType rideType;

	public Ride(double distance, int time, RideType rideType) {
		this.distance = distance;
		this.time = time;
		this.rideType = rideType;
	}
}