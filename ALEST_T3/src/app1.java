public class app1 {
    public static void main(String[] args) {
        // criar árvore geral simples: A com filhos B, C, D
        Node<String> nodeA = new Node<>("A");
        Node<String> nodeB = new Node<>("B");
        Node<String> nodeC = new Node<>("C");
        Node<String> nodeD = new Node<>("D");
        
        nodeA.primeiroF = nodeB;
        nodeB.proximoF = nodeC;
        nodeC.proximoF = nodeD;
        
        Tree<String> tree = new Tree<>(nodeA);
        
        // testar caminhamento em largura
        System.out.print("breadth: ");
        tree.breadth();
        
        // testar altura
        System.out.println("altura: " + tree.height());
        
        // testar nível
        System.out.println("nivel de B: " + tree.level("B"));
        
        // testar nó com mais filhos
        System.out.println("nodo com mais filhos: " + tree.nodoComMaisFilhos());
        
        // testar árvore binária
        Tree.BinaryNode<Integer> root = new Tree.BinaryNode<>(10);
        root.left = new Tree.BinaryNode<>(5);
        root.right = new Tree.BinaryNode<>(15);
        root.left.left = new Tree.BinaryNode<>(3);
        
        System.out.println("nos nao-folha: " + Tree.countNaoFolhas(root));
        System.out.println("maior valor: " + Tree.acheMax(root));
    }
}