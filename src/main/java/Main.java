import java.util.List;

public class Main {
    public static void main(String[] args) {
      
        List<Flight> flightList = FlightBuilder.createFlights();


        UtilityFlightFilter.selectFilter(flightList, TypeOfFilter.FILTERFIRST);

        System.out.println(".........................");

        UtilityFlightFilter.selectFilter(flightList,  TypeOfFilter.FILTERFIRST, TypeOfFilter.FILTERSECOND);

        System.out.println(".........................");

        UtilityFlightFilter.selectFilter(flightList, TypeOfFilter.FILTERSECOND, TypeOfFilter.FILTERFIRST, TypeOfFilter.FILTERTHIRD);
    }
}
