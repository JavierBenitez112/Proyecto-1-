package Analizador;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String value;
    private List<Node> children;

    public Node(String value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public String getValue() {
        return value;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void addChild(Node child) {
        children.add(child);
    }
}
