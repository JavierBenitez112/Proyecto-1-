package Evaluador;

import Analizador.AST;
import Analizador.Node;


public class Evaluador {

    //Evaluador Aritmetico para defun pero aplicable para todo

    //Va a recibir un arbol que tenga una key y expresiones anidadas

    /*
     *                  -
     *                /   \
     *            +       -
     *           / \    /   \
     *          2  3    4    5
     */
    
    public String evaluate(AST<String> ast) {
        return CalculadoraInfix(ast.getRaiz());
    }

    private String CalculadoraInfix(Node<String> node) {
        if (node.getData().matches("[+\\-*/]")) {
            float result = Float.parseFloat(CalculadoraInfix(node.getHijo(0)));
            for (int i = 1; i < node.getHijos().size(); i++) {
                result = Operadores(result, node.getData(),
                        Float.parseFloat(CalculadoraInfix(node.getHijo(i))));
            }
            return Float.toString(result);
        } else {
            return node.getData();
        }
    }

    private float Operadores(float hijo1, String raiz, float hijo2) {
        switch (raiz) {
            case "+":
                return hijo1 + hijo2;
            case "-":
                return hijo1 - hijo2;
            case "*":
                return hijo1 * hijo2;
            case "/":
                return hijo1 / hijo2;
            default:
                throw new IllegalArgumentException("Operador aritmético no válido: " + raiz);
        }
    }

}