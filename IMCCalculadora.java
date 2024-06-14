import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IMCCalculadora extends JFrame {
    private JTextField pesoField;
    private JTextField alturaField;
    private JLabel resultadoLabel;

    public IMCCalculadora() {
        setTitle("Calculadora de IMC");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        // Labels e campos de texto
        add(new JLabel("Peso (Kg):"));
        pesoField = new JTextField();
        add(pesoField);

        add(new JLabel("Altura (Cm):"));
        alturaField = new JTextField();
        add(alturaField);

        // Botão para calcular
        JButton calcularButton = new JButton("Calcular IMC");
        add(calcularButton);

        // Label para exibir o resultado
        resultadoLabel = new JLabel();
        add(resultadoLabel);

        // Configurar o listener do botão
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularIMC();
            }
        });
    }

    private void calcularIMC() {
        try {
            double peso = Double.parseDouble(pesoField.getText());
            double altura = Double.parseDouble(alturaField.getText()) / 100; // converter cm para metros
            double imc = peso / (altura * altura);

            String classificacao = getClassificacaoIMC(imc);
            resultadoLabel.setText(String.format("IMC: %.2f - %s", imc, classificacao));
        } catch (NumberFormatException e) {
            resultadoLabel.setText("Por favor, insira valores válidos.");
        }
    }

    private String getClassificacaoIMC(double imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc >= 18.5 && imc < 24.9) {
            return "Peso normal";
        } else if (imc >= 25 && imc < 29.9) {
            return "Sobrepeso";
        } else if (imc >= 30 && imc < 34.9) {
            return "Obesidade grau I";
        } else if (imc >= 35 && imc < 39.9) {
            return "Obesidade grau II";
        } else {
            return "Obesidade grau III";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new IMCCalculadora().setVisible(true);
            }
        });
    }
}
