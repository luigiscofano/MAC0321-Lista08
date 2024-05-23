/*
 * Nome: Luigi Scofano de Araujo e Hugo Spadete
 * Nusp: 13680334 e 14578727
 * 
 * Professor: Marcelo Finger
 * Disciplina: MAC0321 - Laboratório de programação orientada a objetos
 * 
 * Exercício: LISTA 08 - E03
 * 
 */	

package br.usp.ime.mac321.lista08.ex3;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultisetTest {

    @Test
    public void testMultisetArrayList() {
        MultisetArrayList<Integer> set1 = new MultisetArrayList<>();
        MultisetArrayList<Integer> set2 = new MultisetArrayList<>();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(4);
        set2.add(5);

        set1.addAll(set2);

        assertEquals(5, set1.elements.size());
        assertTrue(set1.elements.contains(1));
        assertTrue(set1.elements.contains(4));
    }

    @Test
    public void testMultisetHashSet() {
        MultisetHashSet<Integer> set1 = new MultisetHashSet<>();
        MultisetHashSet<Integer> set2 = new MultisetHashSet<>();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(3);
        set2.add(4);

        set1.addAll(set2);

        assertEquals(4, set1.elements.size());
        assertTrue(set1.elements.contains(1));
        assertTrue(set1.elements.contains(4));
    }

    @Test
    public void testMultisetLinkedList() {
        MultisetLinkedList<Integer> set1 = new MultisetLinkedList<>();
        MultisetLinkedList<Integer> set2 = new MultisetLinkedList<>();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(4);
        set2.add(5);

        set1.addAll(set2);

        assertEquals(5, set1.elements.size());
        assertTrue(set1.elements.contains(1));
        assertTrue(set1.elements.contains(4));
    }

    @Test
    public void testMultisetStack() {
        MultisetStack<Integer> set1 = new MultisetStack<>();
        MultisetStack<Integer> set2 = new MultisetStack<>();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(4);
        set2.add(5);

        set1.addAll(set2);

        assertEquals(5, set1.elements.size());
        assertTrue(set1.elements.contains(1));
        assertTrue(set1.elements.contains(4));
    }
}

