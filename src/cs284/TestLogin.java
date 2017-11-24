package cs284;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestLogin {
	DatabaseConnection database;
	@Before
	public void setUp() throws Exception {
		database = new DatabaseConnection();
	}
	@After
	public void tearDown() throws Exception {
		database = null;
	}
	@Test
	public void testPasswordMissmatch() throws SQLException {
		assertFalse(database.registerID("a", "a", "b", "a", "a", "a", "a"));
	}
	@Test
	public void testhasDuplicatedUser(){
		assertTrue(database.hasDuplicatedUser("j"));	
	}
	@Test
	public void testDuplicatedUser(){
		assertFalse(database.hasDuplicatedUser("Toch"));	
	}
	@Test
	public void testloginWrongIDPassword(){
		assertFalse(database.login("toch", "mimi"));	
	}
	@Test
	public void testlogintrueIDPassword(){
		assertTrue(database.login("j", "r"));
	}
	@Test
	public void testlogintrueIDWrongPassword(){
		assertFalse(database.login("j", "mimi"));	
	}
	@Test
	public void testloginWrongIDtruePassword(){
		assertFalse(database.login("toch", "r"));	
	}
		
}
