public class EndsStringFilter implements Filter{
    private final String PATTERN;

    public EndsStringFilter(String PATTERN)
    {
        this.PATTERN = PATTERN;
    }

    public boolean apply(String str)
    {
        return str.endsWith(PATTERN);
    }

}
