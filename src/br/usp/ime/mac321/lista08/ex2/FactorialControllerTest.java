/*
 * Nome: Luigi Scofano de Araujo e Hugo Spadete
 * Nusp: 13680334 e 14578727
 * 
 * Professor: Marcelo Finger
 * Disciplina: MAC0321 - Laboratório de programação orientada a objetos
 * 
 * Exercício: LISTA 08 - E01
 * 
 */	

package br.usp.ime.mac321.lista08.ex2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import br.usp.ime.mac321.lista08.ex1.FactorialController;

public class FactorialControllerTest {

    // Teste de unidade para o método de cálculo do fatorial
    @Test
    public void testCalculateFactorial() {
        // Cria uma instância do controlador
        FactorialController controller = new FactorialController();
        
        // Verifica se o cálculo do fatorial está correto para um número positivo
        assertEquals(120, controller.calculateFactorial(5));
        // Verifica se o fatorial de 0 é 1
        assertEquals(1, controller.calculateFactorial(0));

        // Verifica se uma exceção é lançada para um número negativo
        assertThrows(IllegalArgumentException.class, () -> {
            controller.calculateFactorial(-1);
        });
    }
}


