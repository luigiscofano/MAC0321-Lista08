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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import br.usp.ime.mac321.lista08.ex3.MultisetArrayList;

// Adaptador que permite que um Multiset seja utilizado como um Set
public class MultisetAdapter<T> implements Iterable<T> {
    private MultisetArrayList<T> multiset; // Utiliza MultisetArrayList do exercício 3

    // Construtor que recebe um multiconjunto
    public MultisetAdapter(MultisetArrayList<T> multiset) {
        this.multiset = multiset;
    }

    // Método que retorna um iterador que ignora as repetições
    @Override
    public Iterator<T> iterator() {
        // Cria um conjunto (Set) a partir dos elementos do multiconjunto para eliminar duplicatas
        Set<T> uniqueElements = new HashSet<>(multiset.elements);
        return uniqueElements.iterator();
    }
}

