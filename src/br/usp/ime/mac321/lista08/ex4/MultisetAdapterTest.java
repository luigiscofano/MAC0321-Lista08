/*
 * Nome: Luigi Scofano de Araujo e Hugo Spadete
 * Nusp: 13680334 e 14578727
 * 
 * Professor: Marcelo Finger
 * Disciplina: MAC0321 - Laboratório de programação orientada a objetos
 * 
 * Exercício: LISTA 08 - E04
 * 
 */	

package br.usp.ime.mac321.lista08.ex4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.usp.ime.mac321.lista08.ex3.MultisetArrayList;

import java.util.HashSet;
import java.util.Set;

// Classe de teste para o adaptador
public class MultisetAdapterTest {

    @Test
    public void testMultisetAdapter() {
        // Cria um multiconjunto com elementos repetidos
        MultisetArrayList<Integer> multiset = new MultisetArrayList<>();
        multiset.add(1);
        multiset.add(2);
        multiset.add(2);
        multiset.add(3);
        multiset.add(3);
        multiset.add(3);

        // Cria um adaptador para o multiconjunto
        MultisetAdapter<Integer> adapter = new MultisetAdapter<>(multiset);

        // Verifica se o adaptador retorna os elementos únicos
        Set<Integer> uniqueElements = new HashSet<>();
        for (int element : adapter) {
            uniqueElements.add(element);
        }

        // Espera-se que o conjunto único contenha exatamente os elementos 1, 2 e 3
        assertEquals(3, uniqueElements.size());
        assertTrue(uniqueElements.contains(1));
        assertTrue(uniqueElements.contains(2));
        assertTrue(uniqueElements.contains(3));
    }
}

