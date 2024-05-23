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

import java.util.Stack;
import java.util.Objects;

public class MultisetStack<T> {
    Stack<T> elements;

    public MultisetStack() {
        elements = new Stack<>();
    }

    public void add(T element) {
        elements.add(element);
    }

    public void addAll(MultisetStack<T> m) {
        elements.addAll(m.elements);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MultisetStack<?> that = (MultisetStack<?>) obj;
        return Objects.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }
}

