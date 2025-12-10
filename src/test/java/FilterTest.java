import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class FilterTest {

    @Test
    public void testFilterInterface() {
        Filter filter = new Filter() {
            @Override
            public boolean apply(String str) {
                return str.startsWith("Привет");
            }
        };

        assertEquals(true, filter.apply("Привет мир"));
        assertEquals(true, filter.apply("Привет"));
        assertEquals(false, filter.apply("Мир Привет"));
    }

    @Test
    public void testFilterFunctional() {
        Filter beginFilter = new Filter() {
            @Override
            public boolean apply(String str) {
                return str.startsWith("Тест");
            }
        };

        Filter endFilter = new Filter() {
            @Override
            public boolean apply(String str) {
                return str.endsWith("Тест");
            }
        };

        Filter containsFilter = new Filter() {
            @Override
            public boolean apply(String str) {
                return str.contains("ел");
            }
        };

        assertEquals(true, beginFilter.apply("Тестовый"));
        assertEquals(false, beginFilter.apply("Не тест"));

        assertEquals(true, endFilter.apply("Привет Тест"));
        assertEquals(false, endFilter.apply("Тест Привет"));

        assertEquals(true, containsFilter.apply("Привет мир"));
        assertEquals(false, containsFilter.apply("Привет"));
    }
}