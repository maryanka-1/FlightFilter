package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class FilterFlightsTest {
    List<Flight> flightList = FlightBuilder.createFlights();

    @Test
    void shouldAllFlightsAfterNow() {
        int expected = 5;
        int actual = FilterFlights.allFlightsAfterNow(flightList).size();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldCorrectSegmentsInFlight() {
        int expected = 5;
        int actual = FilterFlights.correctSegmentsInFlight(flightList).size();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldTimeConnectLessTwoHours() {
        int expected = 4;
        int actual = FilterFlights.timeConnectLessTwoHours(flightList).size();
        assertThat(actual).isEqualTo(expected);
    }
}