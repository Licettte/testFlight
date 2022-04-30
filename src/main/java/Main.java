import java.util.List;

public class Main {
    public static void main(String[] args) {

        FlightBuilder flightBuilder = new FlightBuilder();
        List<Flight> flightList = flightBuilder.createFlights();


        UtilityFlightFilter.selectFilter(flightList, TypeOfFilter.FILTERFIRST);

        System.out.println(".........................");

        UtilityFlightFilter.selectFilter(flightList,  TypeOfFilter.FILTERFIRST, TypeOfFilter.FILTERSECOND);

        System.out.println(".........................");

        UtilityFlightFilter.selectFilter(flightList, TypeOfFilter.FILTERSECOND, TypeOfFilter.FILTERFIRST, TypeOfFilter.FILTERTHIRD);
    }
}