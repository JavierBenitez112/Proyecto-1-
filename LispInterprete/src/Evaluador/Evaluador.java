package Evaluador;

import Analizador.AST;
import Analizador.Node;
import java.util.ArrayList;


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

    // SETQ, a la hora de encontrar un setq se recibe el arbol y se reemplaza el valor de la variable

    /*
     *          SETQ
     *           |
     *         Variable
     *           |
     *          Valor
     */

    public String  setq(AST<String> ast) {
        return findnreplace(ast.getRaiz(), ast);
    }

    private String findnreplace(Node<String> node, AST<String> ast) {
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
        return ast.getRaiz().getHijo(0).getData();
        
    }

    

    

    
    
    

}