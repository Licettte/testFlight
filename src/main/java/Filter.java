import java.util.List;
import java.util.Set;

public interface Filter {
    static void selectFilter(List<?> typeOfObject, TypeOfFilter... typeOfFilter) {
    }

    static void show(Set<?> typeOfObject) {
    }
}