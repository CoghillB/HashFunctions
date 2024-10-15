/**
 *   This testfile is only here to help you test whether your hash(s,k) function
 *   works for k=31 by comparing its output to Java's own String .hashCode()
 *   function.
 *   
 *   Your hash(s,k) function should work for any general k and not just 31. But
 *   using k=31 is the easiest way to see if your function generates the correct
 *   values as expected.
 *   
 *   This test class provides 10 tests for you and you do not have to edit this
 *   file. It is here just to help you debug your hash(s,k) function.
 *   
 */
 
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class HashTest {

	@Test
	void testEmpty() {
		String s = "";
		assertEquals(s.hashCode(), Hashing.hash(s, 31));
	}

	@Test
	void testLetter1() {
		String s = "m";
		assertEquals(s.hashCode(), Hashing.hash(s, 31));
	}

	@Test
	void testLetter2() {
		String s = "Y";
		assertEquals(s.hashCode(), Hashing.hash(s, 31));
	}

	@Test
	void testShort1() {
		String s = "cats";
		assertEquals(s.hashCode(), Hashing.hash(s, 31));
	}

	@Test
	void testShort2() {
		String s = "balls";
		assertEquals(s.hashCode(), Hashing.hash(s, 31));
	}

	@Test
	void testMedium1() {
		String s = "arbitraryWord";
		assertEquals(s.hashCode(), Hashing.hash(s, 31));
	}

	@Test
	void testMedium2() {
		String s = "howCanSheSlap?";
		assertEquals(s.hashCode(), Hashing.hash(s, 31));
	}

	@Test
	void testLong1() {
		String s = "A String with five (5) words";
		assertEquals(s.hashCode(), Hashing.hash(s, 31));
	}

	@Test
	void testLong2() {
		String s = "All your base are belong to us";
		assertEquals(s.hashCode(), Hashing.hash(s, 31));
	}

	@Test
	void testLong3() {
		String s = "Your .hash(s,31) value should match Java's .hashCode() value";
		assertEquals(s.hashCode(), Hashing.hash(s, 31));
	}

}
