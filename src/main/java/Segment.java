import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Segment {
    private final Integer segmentId;
    private final LocalDateTime departureDate;
    private final LocalDateTime arrivalDate;

    Segment(final LocalDateTime dep, final LocalDateTime arr, final Integer id) {
        departureDate = Objects.requireNonNull(dep);
        arrivalDate = Objects.requireNonNull(arr);
        segmentId = Objects.requireNonNull(id);
    }

    LocalDateTime getDepartureDate() {
        return departureDate;
    }

    LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    Integer getId() {
        return segmentId;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt =
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return '[' + departureDate.format(fmt) + '|' + arrivalDate.format(fmt)
                + ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Segment segment = (Segment) o;
        return segmentId.equals(segment.segmentId) && departureDate.equals(segment.departureDate) && arrivalDate.equals(segment.arrivalDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(segmentId, departureDate, arrivalDate);
    }
}