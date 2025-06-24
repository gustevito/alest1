// Exercícios da 7 à 10 (Lista de Árvores Binárias):

public class BinarySearchTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    //metodo aux pra insercao
    public void insere(int data) {
        root = insereRec(root, data);
    }

    private Node insereRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insereRec(root.left, data);
        } else if (data > root.data) {
            root.right = insereRec(root.right, data);
        }

        return root;
    }

    //exerc7: ancestral() - ancestral comum mais próximo (exerc 1 lista de arv bin)
    public int ancestral(int i, int j) {
        return acharAnc(root, i, j).data;
    }

    private Node acharAnc(Node node, int i, int j) {
        if (node == null) {
            return null;
        }

        //se i e j sao menores que o nó atual, ancestral mais proximo ta na subarvore esquerda
        if (node.data > i && node.data > j) {
            return acharAnc(node.left, i, j);
        }

        //se i e j sao maiores que o nó atual, ancestral mais proximo ta na subarvore direita
        if (node.data < i && node.data < j) {
            return acharAnc(node.right, i, j);
        }

        //se nenhum dos dois, o nó atual é o ancestral mais proximo
        return node;
    }

    //exerc8: caminho() - imprimir caminho da raiz ate o nó (exerc 2 lista de arv bin)
    public void caminho(int val) {
        printCam(root, val);
    }

    private boolean printCam(Node root, int val) {
        if (root == null) {
            return false;
        }

        System.out.print(root.data + " ");

        if (root.data == val) {
            return true;
        }

        if ((val < root.data && printCam(root.left, val)) || 
            (val > root.data && printCam(root.right, val))) {
            return true;
        }

        //se nao encontrado, remove o nó atual do caminho
        System.out.print("\b\b"); //remove o ultimo numero impresso
        return false;
    }

    //exerc9: maxsoma() - caminho com maior soma (exerc 3 lista de arv bin)
    public int maxSoma() {
        return maxSumCam(root);
    }

    private int maxSumCam(Node node) {
        if (node == null) {
            return 0;
        }

        int leftSum = maxSumCam(node.left);
        int rightSum = maxSumCam(node.right);

        return node.data + Math.max(leftSum, rightSum);
    }

    //exerc10: isABP() - verificar se é arvore binaria de pesquisa (exerc 4 lista de arv bin)
    public boolean isABP() {
        return arvBinPesq(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean arvBinPesq(Node node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.data <= min || node.data >= max) {
            return false;
        }

        return arvBinPesq(node.left, min, node.data) && 
               arvBinPesq(node.right, node.data, max);
    }
}