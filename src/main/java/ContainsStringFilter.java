public class ContainsStringFilter implements Filter {
    private final String PATTERN;

    public ContainsStringFilter(String PATTERN)
    {
        this.PATTERN = PATTERN;
    }

    public boolean apply(String str)
    {
        return str.contains(PATTERN);
    }
}
