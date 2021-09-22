package io.jyotirmay.ds.stack;

import static io.jyotirmay.ds.common.Constants.FIRST;
import static io.jyotirmay.ds.common.Constants.SECOND;
import static io.jyotirmay.ds.common.Constants.THIRD;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedStackTest {

	private Stack<String> stack;

	@BeforeEach
	void setUp() throws Exception {
		stack = new LinkedStack<>();
	}

	@Test
	void testIsEmpty() {
		assertTrue(stack.isEmpty());
	}

	@Test
	void testSize() {
		assertEquals(stack.size(), 0);
	}

	@Test
	void testPush() throws FullStackException {
		assertTrue(stack.isEmpty());
		assertEquals(stack.size(), 0);

		stack.push(FIRST);
		assertEquals(stack.size(), 1);
		stack.push(SECOND);
		assertEquals(stack.size(), 2);
		stack.push(THIRD);
		assertEquals(stack.size(), 3);
		stack.push("Fourth");
		assertEquals(stack.size(), 4);
	}

	@Test
	void testPeek() throws FullStackException {
		assertNull(stack.peek());
		stack.push(FIRST);
		assertEquals(stack.peek(), FIRST);
		stack.push(SECOND);
		assertEquals(stack.peek(), SECOND);
		stack.push(THIRD);
		assertEquals(stack.peek(), THIRD);
	}

	@Test
	void testPop() throws FullStackException, EmptyStackException {
		assertTrue(stack.isEmpty());
		assertThrows(EmptyStackException.class, () -> stack.pop());

		stack.push(FIRST);
		assertEquals(stack.size(), 1);
		assertEquals(stack.pop(), FIRST);
		assertEquals(stack.size(), 0);

		stack.push(FIRST);
		assertEquals(stack.peek(), FIRST);
		assertEquals(stack.size(), 1);

		stack.push(SECOND);
		assertEquals(stack.peek(), SECOND);
		assertEquals(stack.size(), 2);

		stack.push(THIRD);
		assertEquals(stack.peek(), THIRD);
		assertEquals(stack.size(), 3);

		assertEquals(stack.pop(), THIRD);
		assertEquals(stack.size(), 2);
		assertEquals(stack.peek(), SECOND);

		assertEquals(stack.pop(), SECOND);
		assertEquals(stack.size(), 1);
		assertEquals(stack.peek(), FIRST);

		assertEquals(stack.pop(), FIRST);
		assertEquals(stack.size(), 0);
		assertNull(stack.peek());
	}

}
