package io.jyotirmay.ds.list;

import static io.jyotirmay.ds.common.Constants.FIRST;
import static io.jyotirmay.ds.common.Constants.FOURTH;
import static io.jyotirmay.ds.common.Constants.SECOND;
import static io.jyotirmay.ds.common.Constants.THIRD;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SinglyLinkedListTest {
	
	private LinkedList<String> list;

	@BeforeEach
	void setUp() throws Exception {
		
		list = new SinglyLinkedList<>();
	}

	@Test
	void testIsEmpty() {
		assertTrue(list.isEmpty());
	}

	@Test
	void testSize() {
		assertEquals(list.size(), 0);
	}

	@Test
	void testAddFirst() {
		
		assertNull(list.getFirst());
		
		list.addFirst(FIRST);
		assertFalse(list.isEmpty());
		assertEquals(list.size(), 1);
		assertEquals(list.getFirst(), FIRST);
		assertEquals(list.getLast(), FIRST);
		list.addFirst(SECOND);
		assertEquals(list.size(), 2);
		assertEquals(list.getFirst(), SECOND);
		assertEquals(list.getLast(), FIRST);
	}

	@Test
	void testAddLast() {
		
		assertNull(list.getLast());
		
		list.addLast(FIRST);
		assertFalse(list.isEmpty());
		assertEquals(list.size(), 1);
		assertEquals(list.getLast(), FIRST);
		assertEquals(list.getFirst(), FIRST);
		list.addLast(SECOND);
		assertEquals(list.size(), 2);
		assertEquals(list.getFirst(), FIRST);
		assertEquals(list.getLast(), SECOND);
	}

	@Test
	void testDeleteFirst() throws EmptyListException {
		
		assertThrows(EmptyListException.class, () -> list.deleteFirst());
		list.addLast(FIRST);
		assertFalse(list.isEmpty());
		assertEquals(list.size(), 1);
		assertEquals(list.getFirst(), FIRST);
		assertEquals(list.deleteFirst(), FIRST);
		assertTrue(list.isEmpty());
		assertEquals(list.size(), 0);

		list.addFirst(FIRST);
		list.addFirst(SECOND);
		list.addFirst(THIRD);
		list.addFirst(FOURTH);
		assertEquals(list.size(), 4);
		assertEquals(list.getFirst(), FOURTH);
		assertEquals(list.getLast(), FIRST);
		assertEquals(list.deleteFirst(), FOURTH);
		assertEquals(list.size(), 3);
	}

	@Test
	void testDeleteLast() throws EmptyListException {
		
		assertThrows(EmptyListException.class, () -> list.deleteLast());
		list.addLast(FIRST);
		assertFalse(list.isEmpty());
		assertEquals(list.size(), 1);
		assertEquals(list.getLast(), FIRST);

		assertEquals(list.deleteLast(), FIRST);
		assertTrue(list.isEmpty());

		list.addLast(FIRST);
		list.addLast(SECOND);
		list.addLast(THIRD);
		list.addLast(FOURTH);
		assertEquals(list.size(), 4);
		assertEquals(list.getFirst(), FIRST);
		assertEquals(list.getLast(), FOURTH);

		assertEquals(list.deleteLast(), FOURTH);
		assertEquals(list.size(), 3);
	}

}
