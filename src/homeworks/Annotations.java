package homeworks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;

public class Annotations {

	@Before
	public void setUp() throws Exception {
		System.out.println("Before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After");
	}
	
	@BeforeClass
	public static void BeforeClass() {
		System.out.println("BeforeClass");
	}
	
	@AfterClass
	public static void AfterClass() {
		System.out.println("AfterClass");
	}
	
	@Ignore
	public void Ignore() {
		System.out.println("Ignore");
	}

	@Test
	public void test1() {
		System.out.println("Test 1");
	}

	@Test
	public void test2() {
		System.out.println("Test 2");
	}
	
	@Test(expected = ArithmeticException.class)
    public void testDivisionWithException() {
        int i = 1 / 0;
    }
	
}
