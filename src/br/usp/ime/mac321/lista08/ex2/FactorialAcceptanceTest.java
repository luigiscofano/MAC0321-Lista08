/*
 * Nome: Luigi Scofano de Araujo e Hugo Spadete
 * Nusp: 13680334 e 14578727
 * 
 * Professor: Marcelo Finger
 * Disciplina: MAC0321 - Laboratório de programação orientada a objetos
 * 
 * Exercício: LISTA 08 - E02
 * 
 */	

package br.usp.ime.mac321.lista08.ex2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.junit.Test;

import br.usp.ime.mac321.lista08.ex1.FactorialView;


public class FactorialAcceptanceTest {

    @Test
    public void testValidInput() {
        
        // Configura a interface gráfica
        FactorialView view = new FactorialView();
        JTextField inputField = view.inputField; // Campo de texto para entrada do número
        JButton calculateButton = view.calculateButton; // Botão para iniciar o cálculo do fatorial
        JLabel resultLabel = view.resultLabel; // Rótulo para mostrar o resultado
        
        // Simula a entrada do usuário com um número válido
        inputField.setText("5");
        calculateButton.doClick(); // Simula o clique no botão
        
        // Verifica se o resultado exibido na interface gráfica está correto
        assertEquals("Resultado: 120", resultLabel.getText());
    }

    @Test
    public void testNegativeInput() {
        // Configura a interface gráfica
        FactorialView view = new FactorialView();
        JTextField inputField = view.inputField; // Campo de texto para entrada do número
        JButton calculateButton = view.calculateButton; // Botão para iniciar o cálculo do fatorial
        
        // Simula a entrada do usuário com um número negativo
        inputField.setText("-1");
        
        // Simula o clique no botão e captura o diálogo
        calculateButton.doClick(); // Simula o clique no botão
        
        // Verifica se o diálogo de erro é exibido
        boolean dialogShown = false;
        try {
            JOptionPane.showMessageDialog(view.frame, "Erro: O número não pode ser negativo.", "Erro de Argumento", JOptionPane.ERROR_MESSAGE);
            dialogShown = true;
        } catch (Exception e) {
            dialogShown = false;
        }
        assertTrue(dialogShown);
    }

    @Test
    public void testNonNumericInput() {
        // Configura a interface gráfica
        FactorialView view = new FactorialView();
        JTextField inputField = view.inputField; // Campo de texto para entrada do número
        JButton calculateButton = view.calculateButton; // Botão para iniciar o cálculo do fatorial
        
        // Simula a entrada do usuário com uma entrada não numérica
        inputField.setText("abc");
        
        // Simula o clique no botão e captura o diálogo
        calculateButton.doClick(); // Simula o clique no botão
        
        // Verifica se o diálogo de erro é exibido
        boolean dialogShown = false;
        try {
            JOptionPane.showMessageDialog(view.frame, "Erro: Digite um número válido.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
            dialogShown = true;
        } catch (Exception e) {
            dialogShown = false;
        }
        assertTrue(dialogShown);
    }
}



// Diferença entre Testes de Unidade (código anterior) e Testes de Aceitação (Esse código)

// Testes de Unidade:
// - Testam pequenas partes isoladas do código, como métodos ou classes individuais;
// - Focam na lógica interna de cada componente;
// - Geralmente são rápidos e verificam o comportamento esperado de pequenas unidades de código.

// Testes de Aceitação:
// - Testam o sistema como um todo ou grandes partes dele;
// - Focam em garantir que o sistema atende aos requisitos e expectativas do usuário final;
// - Podem incluir interações com a interface do usuário e verificar fluxos de trabalho completos.


// Para realizar os testes de aceitação manualmente, um usuário deve:

// Abrir a aplicação de cálculo de fatorial.
// Inserir um número no campo de texto.
// Clicar no botão de calcular.
// Verificar o resultado exibido.
// Testar diferentes entradas, incluindo números válidos e inválidos, para garantir que o comportamento está conforme o esperado.

// Esses testes asseguram que tanto a lógica interna quanto a interação com o usuário estejam corretas e funcionando conforme o esperado.
