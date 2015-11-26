package unitTests;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class simpleUnitTest {
	@Test
	public void multiplicationOfZeroIntegersShouldReturnZero() {
		assertEquals("15 is equal to 3 * 5", 15, 3 * 5);
	}
}
