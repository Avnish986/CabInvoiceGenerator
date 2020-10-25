package com.cab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class RideRepository {
	Map<String, ArrayList<Ride>> userRides;

	public RideRepository() {
		this.userRides = new HashMap<>();
	}

	public void addRides(String userId, Ride[] rides) {
		ArrayList<Ride> rideList = this.userRides.get(userId);
		if(rideList == null) {
			this.userRides.put(userId, new ArrayList<>(Arrays.asList(rides)));
		}
		else {
			List<Ride> temp = new ArrayList<>();
			for (Map.Entry<String,ArrayList<Ride>> entry : userRides.entrySet())  
	            if(entry.getKey().equalsIgnoreCase(userId)) {
	            	temp = entry.getValue();
	            }
			for(int i=0;i<rides.length;i++) {
				temp.add(rides[i]);
			}
			userRides.put(userId, (ArrayList<Ride>) temp);
		}
		

	}

	public Ride[] getRides(String userId) {
		if (userRides.containsKey(userId))
			return userRides.get(userId).toArray(new Ride[0]);
		return null;
	}
}
