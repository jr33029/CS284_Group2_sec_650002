package cs284;

import static org.junit.Assert.assertTrue;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

class TestGrade {
	Course cos;
	@Before
	public void setUp()throws Exception{
		cos = new Course();
	}
	
	@After
	public void Down()throws Exception{
		cos = null;
	}
	
	@Test
	public void test() {
		//assertTrue("error",Course.ExamPoint);
		assertNull("error",Course.ExamPoint);
	}

}
