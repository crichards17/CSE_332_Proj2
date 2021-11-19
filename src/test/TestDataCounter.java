package test;
import static org.junit.Assert.*;
import org.junit.*;
import providedCode.DataCounter;


/**
 * OPTIONAL: If you want to refactor out the common code for external behavior.
 * It is provided for people who want to factor out common test cases
 * for DataCounters. For example, AVLTree and MoveToFrontList are all
 * DataCounters, so their external behavior should be the same.
 * So if you don't want to have the same test methods in multiple files,
 * you can put them in TestDataCounter and make your other test
 * classes extend it.
 * The superclass & subclass relationship works the same here -- subclass
 * inherits all superclass's methods.
 * 
 * However, you don't have to use it if you prefer to have copy of
 * code in different test classes (in that case just leave this file
 * blank). We don't care too much about style in testing code other
 * than naming & number of assertions, as long as your tests are
 * thorough.
 */
public abstract class TestDataCounter<E> {
	protected DataCounter<E> dc;
	protected abstract DataCounter<E> getDataCounter();
	
	@Before
	public void setUp() {
		dc = getDataCounter();
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
}
