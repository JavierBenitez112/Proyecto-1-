package Evaluador;
import Analizador.Parser;


public class Evaluador {
    
    public int evaluate(Parser.Node root) {
        if (root == null) {
            return 0;
        }
        if (root.type.equals("Expression")) {
            // Evaluar los hijos recursivamente
            int result = evaluate(root.children.get(0));
            for (int i = 1; i < root.children.size(); i += 2) {
                String operator = root.children.get(i).value;
                int operand = evaluate(root.children.get(i + 1));
                result = applyOperator(result, operator, operand);
            }
            return result;
        } else {
            return Integer.parseInt(root.value);
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
