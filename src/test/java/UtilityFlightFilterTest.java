import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UtilityFlightFilterTest {

    @Test
    @DisplayName("Segments with a departure date after the current time")
    void selectFilter() {
        LocalDateTime dateDeparture = LocalDateTime.now().plusDays(3);
        LocalDateTime dateArrival = LocalDateTime.now().plusDays(3).minusHours(6);

        List<Flight> flights = FlightBuilder.createFlights();
        Set<Flight> actual = UtilityFlightFilter.selectFilter(flights, TypeOfFilter.FILTERTHIRD);

        boolean actual1 = actual.stream().flatMap(a -> a.getSegments().stream())
                .collect(toList())
                .stream().allMatch(d -> d.getDepartureDate().isEqual(dateDeparture));

        boolean actual2 = actual.stream().flatMap(a -> a.getSegments().stream())
                .collect(toList())
                .stream().allMatch(d -> d.getArrivalDate().isEqual(dateArrival));

//         assertTrue(actual1 && actual2);
        
        Set<LocalDateTime> printActual = actual.stream().map(a -> a.getSegments().get(0).getArrivalDate()).collect(Collectors.toSet());
        Set<LocalDateTime> printActual1 = actual.stream().map(a -> a.getSegments().get(0).getDepartureDate()).collect(Collectors.toSet());

        assertTrue(actual2, String.join(", ", String.format("%nExpected Arrival time:%s%n%nActual Arrival time:%s%n%n",
                 "[" + dateArrival + "]",  printActual)));

        assertTrue(actual1, String.join(", ", String.format("%nExpected Departure time:%s%n%nActual Departure time:%s%n%n",
                "[" + dateDeparture + "]", printActual1)));
    }
}
