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

        assertTrue(actual1 && actual2);
    }
}
