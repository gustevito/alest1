public class app2 {
    public static void main(String[] args) {
        // criar árvore binária de pesquisa simples
        BinarySearchTree bst = new BinarySearchTree();
        bst.insere(10);
        bst.insere(5);
        bst.insere(15);
        bst.insere(3);
        bst.insere(7);
        bst.insere(12);
        bst.insere(20);
        
        // testar ancestral comum mais próximo
        System.out.println("ancestral de 3 e 7: " + bst.ancestral(3, 7));
        
        // testar caminho da raiz até um nó
        System.out.print("caminho ate 7: ");
        bst.caminho(7);
        System.out.println();
        
        // testar caminho com maior soma
        System.out.println("maior soma: " + bst.maxSoma());
        
        // testar se é árvore binária de pesquisa
        System.out.println("é ABP: " + bst.isABP());
    }
}