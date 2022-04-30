import java.util.List;
import java.util.logging.Filter;

public class Main {
    public static void main(String[] args) {

        FlightBuilder flightBuilder = new FlightBuilder();
        List<Flight> flightList = flightBuilder.createFlights();

      FlightFilter filter = new FlightFilter();

        filter.selectFilter(flightList, TypeOfFilter.FILTERFIRST);

        System.out.println(".........................");

        filter.selectFilter(flightList,  TypeOfFilter.FILTERFIRST, TypeOfFilter.FILTERSECOND);

        System.out.println(".........................");

        filter.selectFilter(flightList, TypeOfFilter.FILTERSECOND, TypeOfFilter.FILTERFIRST, TypeOfFilter.FILTERTHIRD);
    }
}