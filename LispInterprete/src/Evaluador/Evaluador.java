package Evaluador;
import Analizador.Node;


public class Evaluador {

    public int evaluate(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.getValue().equals("Expression")) {
            // Evaluar los hijos recursivamente
            int result = evaluate(root.getChildren().get(0));
            for (int i = 1; i < root.getChildren().size(); i += 2) {
                String operator = root.getChildren().get(i).getValue();
                int operand = evaluate(root.getChildren().get(i + 1));
                result = applyOperator(result, operator, operand);
            }
            return result;
        } else {
            // Verificar si el valor del nodo es un número
            try {
                return Integer.parseInt(root.getValue());
            } catch (NumberFormatException e) {
                // Manejar el caso en que el valor no sea un número
                throw new IllegalArgumentException("El valor del nodo no es un número válido: " + root.getValue());
            }
        }
    }

    private int applyOperator(int leftOperand, String operator, int rightOperand) {
        switch (operator) {
            case "+":
                return leftOperand + rightOperand;
            case "-":
                return leftOperand - rightOperand;
            case "*":
                return leftOperand * rightOperand;
            case "/":
                if (rightOperand == 0) {
                    throw new ArithmeticException("División por cero");
                }
                return leftOperand / rightOperand;
            default:
                throw new IllegalArgumentException("Operador no válido: " + operator);
        }
    }
}