package com.cab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
	InvoiceService invoiceService;

	@Before
	public void setUp() {
		invoiceService = new InvoiceService();
	}

	@Test
	public void givenDistanceTimeReturnFare() {
		double distance = 2.0;
		int time = 5;
		double fare = invoiceService.calculateFare(distance, time);
		Assert.assertEquals(25, fare, 0.0);
	}

	@Test
	public void givenLessDistanceTimeReturnMinFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceService.calculateFare(distance, time);
		Assert.assertEquals(5, fare, 0.0);
	}

	@Test
	public void givenMultipleRideReturnInvoiceSummary() {
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		InvoiceSummary summary = invoiceService.calculateFare(rides);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
		Assert.assertEquals(expectedSummary, summary);
	}
	
	@Test
	public void givenUserIDAndRides_ShouldReturnInvoiceSummary() {
		String userId="a@b.com";
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		invoiceService.addRides(userId, rides);
		Ride[] rides1 = { new Ride(2.0, 5), new Ride(0.1, 1) };
		invoiceService.addRides(userId, rides1);
		InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(4, 60.0);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}

}
