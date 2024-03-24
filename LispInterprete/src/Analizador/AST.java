package Analizador;

public class AST<T> {
    private Node<T> raiz;

    public AST(T data) {
        this.raiz = new Node<T>(data);
    }

    public void addHijo(AST<T> data){
        raiz.children.add(data.getRaiz());
    }

    public Node<T> getHijo(int index) {
        return raiz.children.get(index);
    }
    
    public Node<T> getRaiz() {
        return raiz;
    }
    
}