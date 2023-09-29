package com.devtools.Junit_proj1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.devtools.Junit_proj1.service.Arithmetic;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@Test
	public void testWithPositive() {

		Arithmetic ar = new Arithmetic();

		float expected = 30.0f;
		float actual = ar.sum(10.0f, 20.0f);
		assertEquals(expected, actual);
	}

	@Test
	public void testWithNegatives() {

		Arithmetic ar = new Arithmetic();

		float expected = -20.0f;
		float actual = ar.sum(-10.0f, -10.0f);
		assertEquals(expected, actual);
	}

	@Test
	public void testWithZeros() {

		Arithmetic ar = new Arithmetic();

		float expected = 0.0f;
		float actual = ar.sum(0.0f, 0.0f);
		assertEquals(expected, actual);
	}

	@Test
	public void testWithMixed() {

		Arithmetic ar = new Arithmetic();

		float expected = 20.0f;
		float actual = ar.sum(-50.0f, 70.0f);
		assertEquals(expected, actual);
	}
}
