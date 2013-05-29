package com.qsoft.longdt;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void shouldReturn0() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void shouldReturnNumber() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void shouldReturnSumWithComma() {
		assertEquals(3, Calculator.add("1, 2"));
	}

	@Test
	public void shouldReturnSumWithCommaAndMultipleNumber() {
		assertEquals(6, Calculator.add("1, 2,    3"));
	}

	@Test
	public void shouldReturnSumWithNotValidDelemiterAndMultipleNumber() {
		assertEquals(6, Calculator.add("1, 2\n3"));
	}

	@Test
	public void shouldReturnSumWithNotValidDelemiter() {
		assertEquals(6, Calculator.add("///:asdf1, 2\n3"));
	}

	@Test
	public void shouldReturnSumWithNotValidDelemiterFinal() {
		assertEquals(10, Calculator.add("///sdfggfasdf:asdf1, 2\n3sdfsffgret4"));
	}
}
