/*
 * Nome: Luigi Scofano de Araujo e Hugo Spadete
 * Nusp: 13680334 e 14578727
 * 
 * Professor: Marcelo Finger
 * Disciplina: MAC0321 - Laboratório de programação orientada a objetos
 * 
 * Exercício: LISTA 08 - Eextra
 * 
 */	

package br.usp.ime.mac321.lista08.extra;

public class StringPerformanceTest {

    // Método que mede o tempo de concatenação usando String
    public static long testStringConcatenation(int iterations) {
        long startTime = System.currentTimeMillis();
        
        String str = "";
        for (int i = 0; i < iterations; i++) {
            str += "a"; // Concatena 'a' na String
        }
        
        long endTime = System.currentTimeMillis();
        return endTime - startTime; // Retorna o tempo gasto em milissegundos
    }

    // Método que mede o tempo de concatenação usando StringBuffer
    public static long testStringBufferConcatenation(int iterations) {
        long startTime = System.currentTimeMillis();
        
        StringBuffer strBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            strBuffer.append("a"); // Concatena 'a' no StringBuffer
        }
        
        long endTime = System.currentTimeMillis();
        return endTime - startTime; // Retorna o tempo gasto em milissegundos
    }

    public static void main(String[] args) {
        int iterations = 10000;

        // Mede o tempo de concatenação usando String
        long stringTime = testStringConcatenation(iterations);
        System.out.println("Tempo de concatenação usando String: " + stringTime + " ms");

        // Mede o tempo de concatenação usando StringBuffer
        long stringBufferTime = testStringBufferConcatenation(iterations);
        System.out.println("Tempo de concatenação usando StringBuffer: " + stringBufferTime + " ms");
    }
}

/*

Medição de Tempo com String:

O método testStringConcatenation mede o tempo necessário para concatenar uma string "a" várias vezes usando a classe String.
A concatenação de String cria novas instâncias de String a cada operação, o que é ineficiente.

Medição de Tempo com StringBuffer:

O método testStringBufferConcatenation mede o tempo necessário para concatenar uma string "a" várias vezes usando a classe StringBuffer.
StringBuffer é uma classe mutável que permite a modificação do conteúdo sem criar novas instâncias, tornando a concatenação mais eficiente.


Explicação da Diferença de Desempenho:

A diferença de desempenho entre String e StringBuffer na operação de concatenação ocorre devido à 
forma como essas classes gerenciam a memória:

String:

A classe String é imutável, o que significa que cada operação de concatenação cria uma nova instância de String.
Isso resulta em um grande número de objetos temporários e operações de cópia, o que demora.


StringBuffer:

A classe StringBuffer é mutável, permitindo a modificação do conteúdo sem criar novas instâncias.
As operações de concatenação são realizadas no mesmo objeto, evitando a criação de múltiplos objetos temporários 
e operações de cópia.
Como resultado, StringBuffer oferece um desempenho significativamente melhor para operações de concatenação repetidas.
 
*/
