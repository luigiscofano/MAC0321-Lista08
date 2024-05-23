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

package br.usp.ime.mac321.lista08.ex1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FactorialView {
    public JFrame frame; // Janela principal do aplicativo
    public JTextField inputField; // Campo de texto para o usuário inserir número
    public JButton calculateButton; // Botão para iniciar o cálculo
    public JLabel resultLabel; // Rótulo para mostrar o resultado
    private FactorialController controller; // Controlador que faz a conta em si

    public FactorialView() {
        controller = new FactorialController();
        frame = criaJanela(); // Cria a janela principal da aplicação
        
        // Adiciona os componentes à janela
        frame.add(criaRotuloDeInstrucao());
        frame.add(criaCampoDeTexto());
        frame.add(criaBotaoDeCalculo());
        frame.add(criaRotuloDeResultado());
        
        // Adiciona o ActionListener ao botão de cálculo
        calculateButton.addActionListener(new BotaNaEscuta());

        // Torna a janela visível
        frame.setVisible(true);
    }

    private JFrame criaJanela() {
        JFrame frame = new JFrame("Calculadora de Fatorial");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define o comportamento de fechar a janela
        frame.setSize(300, 200); // Tamanho da janela
        frame.setLayout(null); // Define o layout da janela como "null" para posicionamento absoluto dos componentes
        return frame;
    }

    private JLabel criaRotuloDeInstrucao() {
        JLabel inputLabel = new JLabel("Digite um número:");
        inputLabel.setBounds(10, 20, 150, 25); // Define a posição e o tamanho do rótulo
        return inputLabel;
    }

    private JTextField criaCampoDeTexto() {
        inputField = new JTextField();
        inputField.setBounds(150, 20, 100, 25); // Define a posição e o tamanho do campo de texto
        return inputField;
    }

    private JButton criaBotaoDeCalculo() {
        calculateButton = new JButton("Calcular");
        calculateButton.setBounds(10, 60, 100, 25); // Define a posição e o tamanho do botão de cálculo
        return calculateButton;
    }

    private JLabel criaRotuloDeResultado() {
        resultLabel = new JLabel("Resultado: ");
        resultLabel.setBounds(10, 100, 250, 25); // Define a posição e o tamanho do rótulo
        return resultLabel;
    }

    private class BotaNaEscuta implements ActionListener {
    	
    	public BotaNaEscuta(){
    	}
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int number = leNumero();
                long result = controller.calculateFactorial(number);
                resultLabel.setText("Resultado: " + result);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(FactorialView.this.frame, "Erro: Digite um número válido.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(FactorialView.this.frame, "Erro: " + ex.getMessage(), "Erro de Argumento", JOptionPane.ERROR_MESSAGE);
            }
        }

        private int leNumero() throws NumberFormatException {
            String inputText = inputField.getText();
            int n = Integer.parseInt(inputText);
            if (n < 0) {
                throw new IllegalArgumentException("O número não pode ser negativo.");
            }
            return n;
        }
    }

    
    public static void main(String[] args) {
        new FactorialView();
    }
}
