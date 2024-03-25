package Evaluador;

import Analizador.AST;
import Analizador.Node;
import java.util.ArrayList;

/**
 * Clase que proporciona métodos para evaluar y manipular árboles AST.
 */
public class Evaluador {

    // Evaluador Aritmetico para defun pero aplicable para todo
    // Va a recibir un arbol que tenga una key y expresiones anidadas
    /*
     *                  -
     *                /   \
     *            +       -
     *           / \    /   \
     *          2  3    4    5
     */
    
    /**
     * Evalúa un árbol AST aritmético.
     *
     * @param ast El árbol AST a evaluar.
     * @return El resultado de la evaluación como una cadena.
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

    // SETQ, a la hora de encontrar un setq se recibe el arbol y se reemplaza el valor de la variable
    /*
     *          SETQ
     *           |
     *         Variable
     *           |
     *          Valor
     */

    /**
     * Realiza la operación SETQ para asignar un valor a una variable en el árbol AST.
     *
     * @param ast El árbol AST en el que se realizará la operación SETQ.
     * @return El árbol AST con la variable actualizada.
     */
    public AST<String> setq(AST<String> ast) {
        return findnreplace(ast.getRaiz(), ast);
    }

    private AST<String> findnreplace(Node<String> node, AST<String> ast) {
        String variable = "";
        String valor = "";

        for (int i = 0; i < node.getHijos().size(); i++) {
            
            if (node.getHijo(i).getData().toLowerCase().equals("setq")) {
                variable = node.getHijo(i).getHijo(0).getData();
                valor = node.getHijo(i).getHijo(0).getHijo(0).getData();
                break;
            } 
        }
        
        if (!variable.equals("")) {
            for (int i = 0; i < ast.getRaiz().getHijos().size(); i++) {
                if (ast.getRaiz().getHijo(i).getData().equals(variable)) {
                    ast.getRaiz().getHijo(i).changedata(valor);
                }
            }
        }else {
            for (int j = 0; j < node.getHijos().size(); j++) {
                findnreplace(node.getHijo(j), ast);
            }
        }
        return ast;
        
    }

    /**
     * Evalúa la operación COND en el árbol AST.
     *
     * @param ast El árbol AST en el que se realizará la operación COND.
     * @return El resultado de la evaluación de COND como una cadena.
     */
    public String cond(AST<String> ast) {
        return findcond(ast.getRaiz(), ast);
    }

    private String findcond(Node<String> node, AST<String> ast) {
        String result = "";
        for (int i = 0; i < node.getHijos().size(); i++) {
            if (node.getHijo(i).getData().toLowerCase().equals("cond")) {
                String opcion = node.getHijo(i).getHijo(0).getData();
                int valor1 = Integer.parseInt(node.getHijo(i).getHijo(0).getHijo(0).getData());
                int valor2 = Integer.parseInt(node.getHijo(i).getHijo(0).getHijo(1).getData());
                switch (opcion) {
                    case ">":
                        if (valor1 > valor2) {
                            result = node.getHijo(i).getHijo(0).getHijo(2).getData();
                        } else {
                            if (node.getHijo(i).getHijo(0).getHijos().size() > 3) {
                                result = node.getHijo(i).getHijo(0).getHijo(3).getData();
                            } else {
                                result = "False";
                            }
                        }
                        break;
                    case "<":
                        if (valor1 < valor2) {
                            result = node.getHijo(i).getHijo(0).getHijo(2).getData();
                        } else {
                            if (node.getHijo(i).getHijo(0).getHijos().size() > 3) {
                                result = node.getHijo(i).getHijo(0).getHijo(3).getData();
                            } else {
                                result = "False";
                            }
                        }
                        break;
                    default:
                        if (valor1 == valor2) {
                            result = node.getHijo(i).getHijo(0).getHijo(2).getData();
                        } else {
                            if (node.getHijo(i).getHijo(0).getHijos().size() > 3) {
                                result = node.getHijo(i).getHijo(0).getHijo(3).getData();
                            } else {
                                result = "False";
                            }
                        }
                        break;
                }
            }
        }
        return result;
    }

}
