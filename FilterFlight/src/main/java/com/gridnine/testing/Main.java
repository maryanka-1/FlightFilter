package com.gridnine.testing;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.FlightBuilder;
import com.gridnine.testing.service.FilterFlights;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flightList = FlightBuilder.createFlights();
        List<Flight> flightsAfterTimeNow = FilterFlights.allFlightsAfterNow(flightList);
        System.out.println("Перелеты с датой вылета позже текущей");
        flightsAfterTimeNow.forEach(System.out::println);

        List<Flight> correctConnectFlight = FilterFlights.correctSegmentsInFlight(flightList);
        System.out.println("Перелеты с корректными временем вылета и прилета сегментов");
        correctConnectFlight.forEach(System.out::println);

        List<Flight> flightsConnectLessTwoHour = FilterFlights.timeConnectLessTwoHours(flightList);
        System.out.println("Перелеты с общей длительностью стыковок менее 2 часов");
        flightsConnectLessTwoHour.forEach(System.out::println);
    }
}