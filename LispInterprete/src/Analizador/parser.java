package Analizador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class parser {
    private HashMap<String, AST<String>> functions = new HashMap<>();
    private HashMap<String, LinkedList<String>> variables = new HashMap<>();
    private LinkedList<AST<String>> logicalOrder = new LinkedList<>();
    private HashMap<String, ArrayList<String>> nestedLists = new HashMap<>();

    // Constructor que recibe las listas anidadas
    public parser(HashMap<String, ArrayList<String>> nestedLists){
        this.nestedLists = nestedLists;
    }

    // Método para analizar y crear el árbol
    public void parse(ArrayList<ArrayList<String>> currentList){
        if (currentList.isEmpty()) {
            return; // Si la lista está vacía, no se realiza ningún análisis
        }

        for (int i = 0; i < currentList.size(); i++) {
            String firstToken = currentList.get(i).get(0);
        if ("defun".equals(firstToken)) {
            functions.put(currentList.get(i).get(currentList.get(i).size() - 1), CrearAST(currentList.get(i)));
        } else if ("setq".equals(firstToken) || "cond".equals(firstToken)) {
            logicalOrder.add(CrearAST(currentList.get(i)));
        } else {
            logicalOrder.add(CrearAST(currentList.get(i)));
        }
        }
        
    }
    
    // Método para generar el árbol AST
    private AST<String> CrearAST(ArrayList<String> currentList){
        AST<String> currentAST = null;
        switch (currentList.get(0)) {
            case "defun":
                String functionName = currentList.get(1);
                currentList.remove(0); 
                currentList.remove(0);

                currentAST = new AST<>(new Node<>(functionName));

                for (String token : nestedLists.get(currentList.get(0))) {
                    currentAST.getRaiz().addHijo(new Node<>(token));
                }
                currentList.remove(0);
                
                for (String token: currentList){
                    if (nestedLists.containsKey(token)){
                        currentAST.getRaiz().addHijo(CrearAST(nestedLists.get(token)).getRaiz());
                    }
                    else{
                        currentAST.getRaiz().addHijo(new Node<>(token));
                    }
                }
                break;
            case "cond":
                currentAST = new AST<>(new Node<>(currentList.get(0)));
                currentList.remove(0);
                for (String token : currentList){
                    currentAST.getRaiz().addHijo(CrearAST(nestedLists.get(token)).getRaiz());
                }
                break;
            case "setq":
                String variable = currentList.get(1);
                String value = currentList.get(2);

                if (variables.containsKey(variable)){
                    variables.get(variable).add(value);
                } else {
                    LinkedList<String> values = new LinkedList<>();
                    values.add(value);
                    variables.put(variable, values);
                }
                currentAST = new AST<>(new Node<>(currentList.get(0)));
                currentAST.getRaiz().addHijo(new Node<>(variable));
                currentAST.getRaiz().addHijo(new Node<>(String.valueOf(variables.get(variable).size())));
                break;
            default:
                if (nestedLists.containsKey(currentList.get(0))){
                    currentAST = CrearAST(nestedLists.get(currentList.get(0)));
                }
                else{
                    currentAST = new AST<>(new Node<>(currentList.get(0)));
                }
                currentList.remove(0); 
                for (String token : currentList){
                    if (nestedLists.containsKey(token)){
                        currentAST.getRaiz().addHijo(CrearAST(nestedLists.get(token)).getRaiz());
                    }
                    else{
                        currentAST.getRaiz().addHijo(new Node<>(token));
                    }
                }
                break;
        }
        return currentAST;
    }

    // Getters para acceder a las estructuras de datos
    public HashMap<String, AST<String>> getFunctions() {
        return functions;
    } 

    public HashMap<String, LinkedList<String>> getVariables() {
        return variables;
    }

    public LinkedList<AST<String>> getLogicalOrder() {
        return logicalOrder;
    }

    //Prueba imprimir arbol
    // Método para imprimir el árbol AST recursivamente
private void printAST(Node<String> node, int depth) {
    if (node == null) {
        return;
    }

    // Imprimir el nodo actual con su nivel de profundidad
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < depth; i++) {
        sb.append("  "); // Añadir espacios para indicar la profundidad
    }
    sb.append(node.getData());
    System.out.println(sb.toString());

    // Recorrer recursivamente los hijos del nodo actual
    List<Node<String>> children = node.getHijos();
    for (Node<String> child : children) {
        printAST(child, depth + 1);
    }
}

    public void printCurrentAST() {
        for (AST<String> currentAST : logicalOrder) {
            Node<String> root = currentAST.getRaiz();
            printAST(root, 0); // Comenzar la impresión desde la raíz con profundidad 0
        }
    }

    public AST<String> getAST(String functionName) {
        return functions.get(functionName);
    }
}
