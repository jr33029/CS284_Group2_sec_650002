package cs284;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestScore {
	ExamPoint ep;
	@Before
	public void setUp() throws Exception {
		ep= new ExamPoint("ex1", 20, 40);
	}

	@After
	public void tearDown() throws Exception {

		ep=null;
	}

	@Test
	public void test() {
		assertTrue("error",ep.getExamPoint()==8);
		
	}

}
