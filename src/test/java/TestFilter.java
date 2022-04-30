//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.util.*;
//
//
//import static org.junit.jupiter.api.Assertions.assertIterableEquals;
//
//public class TestFilter {
//
//
//    @Test
//    @DisplayName("Segments with a departure date after the current time")
//    void searchFlight() {
//        FlightBuilder flightBuilder = new FlightBuilder();
//        List<Flight> flightList = flightBuilder.createFlights();
//
//
//        List<Segment> sortSegments= List.of(new Segment(L));
//
//        Set<Flight> expectedFlightsSet  = new HashSet<>();
//        expectedFlightsSet .add(new Flight(sortSegments, 0));
//



//        UtilityFlightFilter.selectFilter(flightList, TypeOfFilter.FILTERFIRST);
//
//
//        List<Flight> expectedFlights = List.of(Flight number - 1
//        Arrival time: 2022-05-03T22:32,
//        Departure time: 2022-05-03T20:32
//        Flight number - 2
//        Arrival time: 2022-05-03T22:32
//        Departure time: 2022-05-03T20:32
//        Flight number - 3
//        Arrival time: 2022-05-04T01:32
//        Departure time: 2022-05-03T23:32
//        Flight number - 5
//        Arrival time: 2022-05-03T14:32
//        Departure time: 2022-05-03T20:32
//        Flight number - 6
//        Arrival time: 2022-05-03T22:32
//        Departure time: 2022-05-03T20:32
//        Flight number - 7
//        Arrival time: 2022-05-04T02:32
//        Departure time: 2022-05-04T01:32
//        Flight number - 8
//        Arrival time: 2022-05-03T22:32
//        Departure time: 2022-05-03T20:32
//        Flight number - 9
//        Arrival time: 2022-05-04T00:32
//        Departure time: 2022-05-03T23:32
//        Flight number - 10
//        Arrival time: 2022-05-04T03:32
//        Departure time: 2022-05-04T02:32
//
//
//        assertIterableEquals(expectedFlights, actualFlight,
//                String.join(", ", String.format("%nExpected:%s%n%nActual:%s%n%n",
//                        stringify(expectedFlights),
//                        stringify(actualFlight))
//                ));
//
//


//    }
