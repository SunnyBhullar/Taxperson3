package com.comcast.interview;

import static org.junit.Assert.*;

import org.junit.Test;

public class TaxpersonTest {

	@Test
	public void testInvalidType() {
		try {
			Taxperson.total("invalid type", "100");
			fail();
		} catch (IllegalArgumentException e) {
        // expected
		}
	}
	@Test
	public void testEmptyPennies() {
	    try {
	        Taxperson.total("luxury", "");
	        fail();
	    } catch (IllegalArgumentException e) {
	        // expected
	    }
	}
	@Test
	public void testInvalidPennies() {
	    try {
	        Taxperson.total("luxury", "not valid pennies");
	        fail();
	    } catch (IllegalArgumentException e) {
	        // expected
	    }
	}
	@Test
	public void testNecessary() {
	    assertEquals(101, Taxperson.total("necessary", "100"));
	}
	@Test
	public void testLuxury() {
	    assertEquals(109, Taxperson.total("luxury", "100"));
	}
	@Test
	public void testZero() {
	    assertEquals(0, Taxperson.total("necessary", "0"));
	    assertEquals(0, Taxperson.total("luxury", "0"));
	}
	}
