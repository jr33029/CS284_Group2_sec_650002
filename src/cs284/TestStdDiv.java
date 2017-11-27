package cs284;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestStdDiv {
	StdDiv std;
	ArrayList<Double> list;
	@Before
	public void setUp() throws Exception {
		list = new ArrayList<>();
		list.add(10.0);
		list.add(20.0);
		list.add(0.0);
		std = new StdDiv(list);
	}

	@After
	public void tearDown() throws Exception {
		std = null;
	}

	@Test
	public void testMax() {
		assertEquals(20, std.getMax(),0);
	}
	@Test
	public void testMin() {
		assertEquals(0, std.getMin(),0);
	}
	@Test
	public void testStd() {
		System.out.println();
		assertEquals(10, std.getDiv(),0);
	}
	@Test
	public void testRange() {
		assertEquals(20, std.getRange(list),0);
	}
}
