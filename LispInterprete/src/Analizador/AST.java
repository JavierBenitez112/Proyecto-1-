package Analizador;

public class AST {

    private Node raiz;
        // Constructor
        public AST(Node raiz) {
            this.raiz = raiz;
        }
    
        // Método privado para recorrer inorden recursivamente
        private void recorridoInorden(Node nodo) {
            if (nodo != null) {
                recorridoInorden(nodo.getHijoIzquierdo());
                System.out.print(nodo.getDatos() + " ");
                recorridoInorden(nodo.getHijoDerecho());
            }
        }
    
        // Método público para iniciar el recorrido inorden
        public void recorridoInorden() {
            recorridoInorden(raiz);
        }
    
}
