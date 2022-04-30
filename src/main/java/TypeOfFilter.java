public enum TypeOfFilter {
    FILTERFIRST("departure date after the current time"),
    FILTERSECOND("arrival date earlier than the departure date"),
    FILTERTHIRD("Transfer time over two hours");

    public final String filterName;

    private TypeOfFilter(String filterName) {
        this.filterName = filterName;
    }

    public String getFilterName() {
        return filterName;
    }
}