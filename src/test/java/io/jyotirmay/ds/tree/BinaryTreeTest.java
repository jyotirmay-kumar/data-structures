package io.jyotirmay.ds.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryTreeTest {

    private BinaryTree<Integer> tree;

    @BeforeEach
    void setUp(){
        tree = new BinaryTree<>();
    }

    @Test
    void testIsEmpty() {
        assertTrue(tree.isEmpty());
    }

    @Test
    void testSize() {
        assertEquals(tree.size(), 0);
    }

    @Test
    void testInsert(){
        assertEquals(tree.size(), 0);
        tree.insert(null, 100);
        tree.insert(null, 10);
        tree.insert(null, 150);
        tree.insert(null, 75);
        tree.insert(null, 190);
        tree.insert(null, 189);
        tree.insert(null, 196);
        tree.insert(null, 5);
        tree.insert(null, 55);
        tree.insert(null, 15);
        tree.insert(null, 100);
        assertEquals(tree.size(), 11);

    }

    @Test
    void testContains(){

        testInsert();
        assertTrue(tree.contains(null, 100));
        assertTrue(tree.contains(null, 10));
        assertTrue(tree.contains(null, 150));
        assertTrue(tree.contains(null, 75));
        assertTrue(tree.contains(null, 190));
        assertTrue(tree.contains(null, 189));
        assertTrue(tree.contains(null, 196));
        assertTrue(tree.contains(null, 5));
        assertTrue(tree.contains(null, 55));
        assertTrue(tree.contains(null, 15));
        assertTrue(tree.contains(null, 100));

    }

    @Test
    void testPrintInOrder(){

        testInsert();
        tree.printInOrder(null);
    }

    @Test
    void testPrintPreOrder(){

        testInsert();
        tree.printPreOrder(null);
    }

    @Test
    void testPrintPostOrder(){

        testInsert();
        tree.printPostOrder(null);
    }
}
