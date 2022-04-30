public enum TypeOfFilter {
    FILTERFIRST("departure date after the current time"),
    FILTERSECOND("arrival date earlier than the departure date"),
    FILTERTHIRD("Transfer time over two hours");

   private final String filterName;

    TypeOfFilter(String filterName) {
        this.filterName = filterName;
    }

    public String getFilterName() {
        return filterName;
    }
}