package testA;

import org.junit.Before;
import org.junit.Test;
import phaseA.StringComparator;
import static org.junit.Assert.*;

public class TestStringComparator {
    protected StringComparator comp;

    @Before
    public void setup() {
        comp = new StringComparator();
    }

    @Test
    public void test_chars() {
        assertEquals("Comparing strings 'a' and 'b':", -1, comp.compare("a", "b"));
    }

    @Test
    public void test_chars_reverse() {
        assertEquals("Comparing strings 'q' and 'd':", 1, comp.compare("q", "d"));
    }

    @Test
    public void test_upper_lower() {
        assertEquals("Comparing strings 'A' and 'h':", -1, comp.compare("A", "h"));
    }

    @Test
    public void test_lower_upper() {
        assertEquals("Comparing strings 'Q' and 'c':", 1, comp.compare("Q", "c"));
    }

    @Test
    public void test_same_string() {
        assertEquals("Comparing strings 'apple' and 'ApPlE':", 0, comp.compare("apple", "ApPLE"));
    }

    @Test
    public void test_shortened_string() {
        assertEquals("Comparing strings 'apple' and 'ap':", 1, comp.compare("apple", "ap"));
    }

    @Test
    public void test_mixed_strings() {
        assertEquals("Comparing strings 'cabki' and 'cahka':", -1, comp.compare("cabki", "cahka"));
    }
}
