package cs284;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cs284.ExcelFileController;

public class TestWriteExel {
	ExcelFileController ex;
	@Before
	public void setUp() throws Exception {
		ex = new ExcelFileController();
	}

	@After
	public void tearDown() throws Exception {
		ex = null;
	}

	@Test
	public void testRead() {
		assertTrue(ex.writeExcelFile());
	}

}