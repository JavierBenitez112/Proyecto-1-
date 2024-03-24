package Analizador;

public class AST<T> {
    private Node<T> raiz;

    public AST(Node<T> raiz) {
        this.raiz = raiz;
    }
    
    public Node<T> getRaiz() {
        return raiz;
    }
    
}