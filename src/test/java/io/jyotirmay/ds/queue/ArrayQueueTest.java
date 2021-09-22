package io.jyotirmay.ds.queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayQueueTest {

	private Queue<String> queue;
	
	@BeforeEach
	void setUp() throws Exception {
		queue = new ArrayQueue<>(5);
	}

	@Test
	void testIsEmpty() {
		assertTrue(queue.isEmpty());
	}

	@Test
	void testSize() {
		assertEquals(queue.size(), 0);
	}

	@Test
	void testEnqueue() throws FullQueueException {
		assertTrue(queue.isEmpty());
		assertEquals(queue.size(), 0);
		queue.enqueue("First");
		assertFalse(queue.isEmpty());
		assertEquals(queue.size(), 1);
		assertEquals(queue.peek(), "First");
		queue.enqueue("Second");
		assertEquals(queue.size(), 2);
		assertEquals(queue.peek(), "First");
		queue.enqueue("Third");
		assertEquals(queue.size(), 3);
		assertEquals(queue.peek(), "First");

	}

	@Test
	void testDequeue() throws FullQueueException, EmptyQueueException {

		assertThrows(EmptyQueueException.class, () -> queue.dequeue());
		assertTrue(queue.isEmpty());
		assertEquals(queue.size(), 0);
		queue.enqueue("First");
		assertFalse(queue.isEmpty());
		assertEquals(queue.size(), 1);
		assertEquals(queue.peek(), "First");
		assertEquals(queue.dequeue(), "First");
		assertTrue(queue.isEmpty());
		assertEquals(queue.size(), 0);

		queue.enqueue("First");
		queue.enqueue("Second");
		queue.enqueue("Third");
		queue.enqueue("Fourth");
		assertEquals(queue.size(), 4);
		assertEquals(queue.dequeue(), "First");
		assertEquals(queue.size(), 3);
		assertEquals(queue.dequeue(), "Second");
		assertEquals(queue.size(), 2);
		assertEquals(queue.dequeue(), "Third");
		assertEquals(queue.size(), 1);
		assertEquals(queue.dequeue(), "Fourth");
		assertEquals(queue.size(), 0);

	}


}
