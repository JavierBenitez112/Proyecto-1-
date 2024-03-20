package Analizador;

import java.util.ArrayList;
import java.util.HashMap;

public class parser {
    private HashMap<String, ArrayList<String>> tokenMap;
    private ArrayList<String> keys;

    public parser(HashMap<String, ArrayList<String>> tokenMap, ArrayList<String> keys) {
        this.tokenMap = tokenMap;
        this.keys = keys;
    }

    public Node parse() {
        Node root = new Node("Programa"); // Nodo raíz representando el programa completo
        buildAST(root, keys);
        return root;
    }

    private void buildAST(Node parent, ArrayList<String> tokens) {
        for (String token : tokens) {
            if (tokenMap.containsKey(token)) {
                Node child = new Node(token); // Crea un nuevo nodo con el nombre del token
                parent.addChild(child); // Agrega el nodo como hijo del nodo padre

                // Verifica si el token representa una función definida
                if (token.equals("defun")) {
                    // El siguiente token debe ser el nombre de la función
                    String functionName = tokens.get(tokens.indexOf(token) + 1);
                    Node functionNode = new Node("Function"); // Crea un nodo para representar la función
                    functionNode.addChild(new Node(functionName)); // Agrega un nodo hijo para el nombre de la función
                    ArrayList<String> functionBody = tokenMap.get(token); // Obtiene el cuerpo de la función
                    // Construye el AST para el cuerpo de la función
                    buildAST(functionNode, functionBody);
                    child.addChild(functionNode); // Agrega el nodo de la función como hijo del nodo de la definición de función
                } else if (token.equals("setq")) {
                    // El siguiente token debe ser el nombre de la variable
                    String variableName = tokens.get(tokens.indexOf(token) + 1);
                    Node variableNode = new Node("Variable"); // Crea un nodo para representar la variable
                    variableNode.addChild(new Node(variableName)); // Agrega un nodo hijo para el nombre de la variable
                    // El siguiente token debe ser el valor de la variable
                    String variableValue = tokens.get(tokens.indexOf(token) + 2);
                    variableNode.addChild(new Node(variableValue)); // Agrega un nodo hijo para el valor de la variable
                    child.addChild(variableNode); // Agrega el nodo de la variable como hijo del nodo de la definición de variable
                } else {
                    // Construye recursivamente el AST para el token actual
                    buildAST(child, tokenMap.get(token));
                }
            } else {
                parent.addChild(new Node(token)); // Agrega un nodo para el token como hijo del nodo padre
            }
        }
    }
}
