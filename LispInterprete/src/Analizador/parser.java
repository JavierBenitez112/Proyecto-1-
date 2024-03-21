package Analizador;

import java.util.ArrayList;
import Tokens.tokenizer;

public class parser {
    private tokenizer tokenizer;

    public parser(tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    public AST parse() {
        Node raiz = null;
        for (ArrayList<String> dato : tokenizer.getTokened()) {
            if (dato.contains("defun")) {
                int index = dato.indexOf("defun");
                if (index < dato.size() - 1) {
                    String key = dato.get(index + 1);
                    ArrayList<String> operacion = tokenizer.getTokenMap().get(key);
                    if (operacion != null) {
                        Node nodoDefun = new Node(dato);
                        Node nodoOperacion = new Node(operacion);
                        nodoDefun.agregarHijoDerecho(nodoOperacion);
                        if (raiz == null) {
                            raiz = nodoDefun;
                        } else {
                            // Aquí puedes decidir cómo agregar el nodoDefun al árbol, por ejemplo, como hijo izquierdo de la raíz
                            Node temp = raiz;
                            while (temp.getHijoIzquierdo() != null) {
                                temp = temp.getHijoIzquierdo();
                            }
                            temp.agregarHijoIzquierdo(nodoDefun);
                        }
                    }
                }
            }
        }
        return new AST(raiz);
    }
}