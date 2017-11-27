package cs284;

import static org.junit.Assert.*;

import javax.swing.JLabel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cs284.ExcelFileController;

public class TestReadExel {
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
		assertTrue(ex.readExcelFile(new JLabel("Test")));
	}

}
