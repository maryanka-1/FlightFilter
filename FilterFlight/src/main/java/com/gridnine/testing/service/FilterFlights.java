package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FilterFlights {
    public static List<Flight> allFlightsAfterNow(List<Flight> list) {
        return list.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate().isAfter(LocalDateTime.now())))
                .collect(Collectors.toList());
    }

    public static List<Flight> correctSegmentsInFlight(List<Flight> list) {
        return list.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate().isBefore(segment.getArrivalDate())))
                .collect(Collectors.toList());
    }

    public static List<Flight> timeConnectLessTwoHours(List<Flight> list) {
        return list.stream()
                .filter(flight -> {
                    if (flight.getSegments().size() == 1) {
                        return true;
                    } else {
                        List<Segment> listSeg = flight.getSegments().stream()
                                .sorted(Comparator.comparing(Segment::getDepartureDate))
                                .toList();
                        long timeConnect = 0;
                        for (int i = 0; i < listSeg.size() - 1; i++) {
                            long timeBetween = Duration.between(listSeg.get(i).getArrivalDate(),
                                    listSeg.get(i + 1).getDepartureDate()).toHours();
                            if (timeBetween > 0) {
                                timeConnect += timeBetween;
                            }
                        }
                        return timeConnect < 3;
                    }
                })
                .collect(Collectors.toList());
    }
}
