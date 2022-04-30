import org.apache.commons.collections4.CollectionUtils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class UtilityFlightFilter {

    private UtilityFlightFilter() {
        throw new java.lang.UnsupportedOperationException("Utility class and cannot be instantiated");
    }

    private static final List<TypeOfFilter> filterFirst = List.of(TypeOfFilter.FILTERFIRST);
    private static final List<TypeOfFilter> filterSecond = List.of(TypeOfFilter.FILTERSECOND);
    private static final List<TypeOfFilter> filterFirstAndSecond = List.of(TypeOfFilter.FILTERFIRST, TypeOfFilter.FILTERSECOND);
    private static final List<TypeOfFilter> filterFirstAndSecondAndThird = List.of(TypeOfFilter.FILTERFIRST, TypeOfFilter.FILTERSECOND, TypeOfFilter.FILTERTHIRD);

    public static void selectFilter(List<Flight> flights, TypeOfFilter... typeOfFilter) {

        ArrayList<TypeOfFilter> filters = new ArrayList<>(Arrays.asList(typeOfFilter));

        if (CollectionUtils.isEqualCollection(filters, filterFirst)) {
            Set<Flight> filter1 = getDepartureDateAfterCurrentTime(flights);
            System.out.println("Filter applied: " +
                    "\n" + "Segments with a departure date after the current time");
            show(filter1);
        }
        if (CollectionUtils.isEqualCollection(filters, filterSecond)) {
            Set<Flight> filter2 = getArrivalDateEarlierDepartureDate(flights);
            System.out.println("Filter applied: " +
                    "\n" + "Segments with an arrival date earlier than the departure date");
            show(filter2);
        }

        if (CollectionUtils.isEqualCollection(filters, filterFirstAndSecond)) {
            Set<Flight> filter1 = getArrivalDateEarlierDepartureDate(flights);
            Set<Flight> filter2 = getArrivalDateEarlierDepartureDate(flights);
            if (!filter2.isEmpty()) {
                System.out.println("Filter applied: " + "\n" + "Segments with a departure date after the current time" +
                        "\n" + "Segments with an arrival date earlier than the departure date");
                show(filter2);
            } else System.out.println("Object not found");
        }
            if (CollectionUtils.isEqualCollection(filters, filterFirstAndSecondAndThird)) {
                Set<Flight> filter1 = getArrivalDateEarlierDepartureDate(flights);
                Set<Flight> filter2 = getArrivalDateEarlierDepartureDate(flights);
                Set<Flight> filter3 = getTransferTimeOverTwoHours(flights);

                if (filter3 == null || filter3.equals("\"\"")) {
                    System.out.println("Filter applied: " +
                            "\n" + "Segments with a departure date after the current time" +
                            "\n" + "Segments with an arrival date earlier than the departure date" +
                            "\n" + "Transfer time over two hours");
                    show(filter3);
                } else System.out.println("Object not found");
            }

        }

//    private static Set<Flight> selectTwoFilter(List<Flight> flights) {
//
//        Function<Set<Flight>, Set<Flight>> firstFilter = f -> getDepartureDateAfterCurrentTime(flights);
//        Set<Flight> apply1 = firstFilter.apply(flights.stream().collect(Collectors.toSet()));
//
//        Function<List<Flight>, Set<Flight>> secondFilter = f -> getArrivalDateEarlierDepartureDate(new ArrayList<>(apply1));
//
//        Set<Flight> apply = secondFilter.apply(apply1.stream().collect(Collectors.toList()));
//
//        return apply;
//    }
//
//    private static Set<Flight> selectThreeFilter(List<Flight> flights) {
//        Set<Flight> filterFirstAndSecond = selectTwoFilter(flights);
//
//        Function<List<Flight>, Set<Flight>> thirdFilter = f -> getTransferTimeOverTwoHours(new ArrayList<>(filterFirstAndSecond));
//
//        return thirdFilter.apply(flights);
//    }

    private static Set<Flight> getDepartureDateAfterCurrentTime(List<Flight> flights) {

        LocalDateTime localDateTime = LocalDateTime.now(ZoneOffset.UTC);

        List<Segment> sortSegments = flights.stream()
                .flatMap(s -> s.getSegments().stream())
                .collect(toList())
                .stream()
                .filter(t -> t.getDepartureDate().isAfter(localDateTime))
                .collect(toList());

        Set<Flight> sortFlight = new HashSet<>();
        sortFlight.add(new Flight(sortSegments, 0));

        return sortFlight;
    }

    private static Set<Flight> getArrivalDateEarlierDepartureDate(List<Flight> flights) {

        List<Segment> sortSegments = flights.stream()
                .flatMap(s -> s.getSegments().stream())
                .collect(toList())
                .stream()
                .filter(t -> t.getArrivalDate().truncatedTo(ChronoUnit.DAYS).isAfter(t.getDepartureDate().truncatedTo(ChronoUnit.DAYS)))
                .collect(toList());

        Set<Flight> sortFlight = new HashSet<>();
        sortFlight.add(new Flight(sortSegments, 0));

        return sortFlight;
    }

    private static Set<Flight> getTransferTimeOverTwoHours(List<Flight> flights) {

        List<Segment> sortSegments = flights.stream()
                .flatMap(s -> s.getSegments().stream())
                .collect(toList())
                .stream()
                .filter(t -> t.getDepartureDate().truncatedTo(ChronoUnit.SECONDS)
                        .isAfter(t.getArrivalDate().truncatedTo(ChronoUnit.SECONDS).plusHours(2)))
                .collect(toList());

        Set<Flight> sortFlight = new HashSet<>();
        sortFlight.add(new Flight(sortSegments, 0));

        return sortFlight;
    }

    private static void show(Set<Flight> flights) {

        System.out.println(flights.stream().flatMap(a -> a.getSegments().stream())
                .map(b -> "\n" + "Flight number - " + b.getId() + "\n" + "Arrival time: "
                        + b.getArrivalDate().truncatedTo(ChronoUnit.MINUTES) + "\n" + "Departure time: "
                        + b.getDepartureDate().truncatedTo(ChronoUnit.MINUTES))
                .collect(joining()));
    }
}
