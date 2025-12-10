public class BeginStringFilter
{
    public final String PATTERN;

    public BeginStringFilter(String PATTERN)
    {
        this.PATTERN = PATTERN;
    }

    public boolean apply(String str)
    {
        return str.startsWith(PATTERN);
    }

}
