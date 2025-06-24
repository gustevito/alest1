// Exercícios da 1 à 6 (Lista Para P2):

import java.util.LinkedList;
import java.util.Queue;

class Node<T> {
    T data;
    Node<T> primeiroF;
    Node<T> proximoF;

    public Node(T data) {
        this.data = data;
        this.primeiroF = null;
        this.proximoF = null;
    }
}

public class Tree<T> {
    private Node<T> root;

    public Tree(Node<T> root) {
        this.root = root;
    }

    // exec1: breadth - caminhamento em largura (exec 3 de arvores gerais)
    public void breadth() {
        if (root == null) {
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();
            System.out.print(current.data + " ");

            // add todos filhos do nodo 
            Node<T> filho = current.primeiroF;
            while (filho != null) {
                queue.add(filho);
                filho = filho.proximoF;
            }
        }
        System.out.println();
    }

    // exec2: height - calcular altura da arvore (exec 4 de arvores gerais)
    public int height() {
        return height(root);
    }

    private int height(Node<T> node) {
        if (node == null) {
            return -1;
        }

        int maxHeight = -1;
        Node<T> filho = node.primeiroF;
        while (filho != null) {
            int filhoHeight = height(filho);
            if (filhoHeight > maxHeight) {
                maxHeight = filhoHeight;
            }
            filho = filho.proximoF;
        }

        return maxHeight + 1;
    }

    // exec3: level- calcular nivel do nó (exec 5 de arvores gerais)
    public int level(T data) {
        return level(root, data, 0);
    }

    private int level(Node<T> node, T data, int nivelAtual) {
        if (node == null) {
            return -1;
        }

        if (node.data.equals(data)) {
            return nivelAtual;
        }

        
        Node<T> filho = node.primeiroF;
        while (filho != null) {
            int encontrouNivel = level(filho, data, nivelAtual + 1);
            if (encontrouNivel != -1) {
                return encontrouNivel;
            }
            filho = filho.proximoF;
        }

        return -1; 
    }

    //exec4: nodoComMaisFilhos - elemento com mais filhos (exec 2 lista para p2)
    public T nodoComMaisFilhos() {
        if (root == null) {
            return null; //arvore vazia
        }

        Node<T> resultNode = root;
        int maxFilhos = countFilhos(root);

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> atual = queue.poll();

            int filhoAtual = countFilhos(atual);
            if (filhoAtual > maxFilhos) {
                maxFilhos = filhoAtual;
                resultNode = atual;
            }

            Node<T> filho = atual.primeiroF;
            while (filho != null) {
                queue.add(filho);
                filho = filho.proximoF;
            }
        }

        return resultNode.data;
    }

    private int countFilhos(Node<T> node) {
        int count = 0;
        Node<T> filho = node.primeiroF;
        while (filho != null) {
            count++;
            filho = filho.proximoF;
        }
        return count;
    }

    //classe interna pra nós de arv binaria
    static class BinaryNode<T> {
        T data;
        BinaryNode<T> left;
        BinaryNode<T> right;

        public BinaryNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    //exec5: countNaoFolhas() - contar nós n/folha em arv binaria  (exec 3 lista para p2)
    public static <T> int countNaoFolhas(BinaryNode<T> root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }

        return 1 + countNaoFolhas(root.left) + countNaoFolhas(root.right);
    }

    //exec6: acheMax() - achar maior valor na arv binaria (exec 5 lista para p2)
    public static <T extends Comparable<T>> T acheMax(BinaryNode<T> root) {
        if (root == null) {
            throw new IllegalStateException("A arvore esta vazia");
        }
        
        BinaryNode<T> atual = root;
        while (atual.right != null) {
            atual = atual.right;
        }
        
        return atual.data;
    }
}