package cs284;

import static org.junit.Assert.*;

import javax.swing.JLabel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

class ExcelFileControllerTest {
	ExcelFileController e;

	@Before
	public void up() {
		e = new ExcelFileController();
	}

	@After
	public void down() {
		e = null;
	}

	@Test
	void testOpenfile() {
		assertTrue(e.readExcelFile(new JLabel("test")));
	}

}
