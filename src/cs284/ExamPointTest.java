package cs284;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

class ExamPointTest {
	ExamPoint expoint;

	@Before
	public void up() {
	}

	@After
	public void down() {
	}

	@Test
	void test() {
		expoint = new ExamPoint("n", 30, 20, 60);
		boolean x = false;
		if (10 == expoint.getExamPoint()) {
			x = true;
		}
		assertTrue(x);
		expoint = null;
	}

}
