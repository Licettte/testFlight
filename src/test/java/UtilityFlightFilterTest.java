import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UtilityFlightFilterTest {

    @Test
    @DisplayName("Segments with a departure date after the current time")
    void selectFilter() {
        LocalDateTime dateTime = LocalDateTime.now().plusDays(3);

        List<Flight> flights = FlightBuilder.createFlights();

        Set<Flight> expected = new HashSet<>();
        List<Segment> seg = new ArrayList<>();
        seg.add(new Segment(dateTime, dateTime.minusHours(5), 5)); //+1 hour, but it doesn't work
        expected.add(new Flight(seg, 1));

        Set<Flight> actual = UtilityFlightFilter.selectFilter(flights, TypeOfFilter.FILTERTHIRD);

//        Set<Flight> exp = new HashSet<>();
//        exp.add(flights.get(3));

        assertIterableEquals(expected, actual);
    }
}
