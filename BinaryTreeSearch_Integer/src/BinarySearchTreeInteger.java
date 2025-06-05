import java.util.List;
import java.util.LinkedList;

public class BinarySearchTreeInteger {

    private static final class Node {

        public Node parent;
        public Node left;
        public Node right;
        public Integer element;

        public Node(Integer element) {
            parent = null;
            left = null;
            right = null;
            this.element = element;
        }

        // Retorna o grau do nó: 0, 1 ou 2
        public int degree() {
            int res = 0;
            if (left != null)
                res++;
            if (right != null)
                res++;
            return res;
        }
    }

    // Atributos
    private int count; // contagem do número de nodos
    private Node root; // referência para o nodo raiz

    public BinarySearchTreeInteger() {
        clear();
    }

    public void clear() {
        count = 0;
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return count;
    }

    public Integer getRoot() {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        return root.element;
    }

    public void add(Integer element) {
        Node aux = new Node(element);
        if (root == null) { // Se for o primeiro elemento, cria como raiz e retorna
            root = aux;
            count++;
            return;
        }
        // Completar
        boolean inseriu = false;
        Node atual = root;
        while (!inseriu) {
            if (element.compareTo(atual.element) < 0) {
                if (atual.left == null) {
                    atual.left = aux;
                    aux.parent = atual;
                    inseriu = true;
                } else
                    atual = atual.left;
            } else {
                if (atual.right == null) {
                    atual.right = aux;
                    aux.parent = atual;
                    inseriu = true;
                } else
                    atual = atual.right;
            }
        }
        count++;
    }

    private Node searchNode(Integer element) {
        Node atual = root;
        while (atual != null) {
            if (atual.element.equals(element))
                return atual;
            if (element.compareTo(atual.element) < 0)
                atual = atual.left;
            else
                atual = atual.right;
        }
        return null;
    }

    public boolean contains(Integer element) {
        if (searchNode(element) != null)
            return true;
        return false;
    }

    public boolean remove2(Integer value) {
        Node aux;
        if (value == null || root == null)
            return false;
        aux = searchNode(value);
        if (aux == null)
            return false;
        remove2(aux);
        count--;
        return true;
    }

    private void remove2(Node n) {
        Node aux, m;
        aux = n.parent;
        System.out.println("Vou remover o " + n.element);
        if (n.left == null) {
            if (n.right == null) { // Nodo a excluir é folha?
                if (root == n) {
                    root = null;
                    return;
                }
                if (aux.left == n)
                    aux.left = null;
                else
                    aux.right = null;
                return;
            } else { // Esquerda nula e direita não
                if (root == n) {
                    root = n.right;
                    root.parent = null;
                    return;
                }
                if (aux.left == n) {
                    aux.left = n.right;
                    n.right.parent = aux;
                } else {
                    aux.right = n.right;
                    n.right.parent = aux;
                }
            }
            return;
        }

        if (n.right == null) { // Direita nula e esquerda não
            if (root == n) {
                root = n.left;
                root.parent = null;
                return;
            }
            if (aux.left == n) {
                aux.left = n.left;
                n.left.parent = aux;
            } else {
                aux.right = n.left;
                n.left.parent = aux;
            }
            return;
        }

        // Esquerda e direita não nulas
        m = smallest(n.right);
        System.out.println("Menor da direita: " + m.element);
        n.element = m.element;
        remove2(m);
    }

    /**
     * Retorna referência para o nodo que contém o menor elemento da subárvore
     * cuja raiz foi passada por parâmetro.
     * 
     * @param n nodo a partir do qual deve-se procurar o menor elemento.
     * @return referência para o nodo que contém o menor elemento.
     */
    private Node smallest(Node n) {
        while (n != null && n.left != null) {
            n = n.left;
        }
        return n;
    }

    public boolean remove(Integer value) {
        Node parent = null, current = root;
        boolean hasLeft = false;

        if (root == null)
            return true;

        while (current != null) {
            if (current.element.equals(value)) {
                break;
            }

            parent = current;
            if (value.compareTo(current.element) < 0) {
                hasLeft = true;
                current = current.left;
            } else {
                hasLeft = false;
                current = current.right;
            }
        }
        if (current == null) // não existe
            return false;

        if (parent == null) {
            remove(current);
            return true;
        }

        if (hasLeft) {
            parent.left = remove(current);
        } else {
            parent.right = remove(current);
        }

        return true;
    }

    private Node remove(Node node) {

        if (node != null) {
            if (node.left == null && node.right == null) {
                return null;
            }

            if (node.left != null && node.right != null) {
                Node inOrderSuccessor = removeDuplicate(node);
                node.element = inOrderSuccessor.element;
            } else if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return node;
    }

    private Node removeDuplicate(Node node) {
        Node parent = node;
        node = node.right;
        boolean rightChild = node.left == null;

        while (node.left != null) {
            parent = node;
            node = node.left;
        }

        if (rightChild) {
            parent.right = node.right;
        } else {
            parent.left = node.right;
        }

        node.right = null;
        return node;
    }

    public List<Integer> positionsCentral() {
        List<Integer> res = new LinkedList<>();
        positionsCentralAux(root, res);
        return res;
    }

    private void positionsCentralAux(Node n, List<Integer> res) {
        if (n != null) {
            positionsCentralAux(n.left, res); // Visita a subárvore da esquerda
            res.add(n.element); // Visita o nodo
            positionsCentralAux(n.right, res); // Visita a subárvore da direita
        }
    }

    public String positionsCentralStr() {
        String res = "";
        res = positionsCentralAuxStr(root, res);
        return res;
    }

    private String positionsCentralAuxStr(Node n, String  res) {
        if (n == null) {
            return "";
        } else {
            String esq =positionsCentralAuxStr(n.left, res); 
            String dir = positionsCentralAuxStr(n.right, res); 
         
            return esq + " " + n.element + " " + dir;
        }
    }

    private void geraConexoesDOT(StringBuilder sb, Node nodo) {
        if (nodo == null) {
            return;
        }

        geraConexoesDOT(sb, nodo.left);
        // "nodeA":esq -> "nodeB" [color="0.650 0.700 0.700"]
        if (nodo.left != null) {
            sb.append("\"node" + nodo.element + "\":esq -> \"node" + nodo.left.element + "\" \n");
        }

        geraConexoesDOT(sb, nodo.right);
        // "nodeA":dir -> "nodeB";
        if (nodo.right != null) {
            sb.append("\"node" + nodo.element + "\":dir -> \"node" + nodo.right.element + "\" \n");
        }
        // "[label = " << nodo->hDir << "]" <<endl;
    }

    private void geraNodosDOT(StringBuilder sb, Node nodo) {
        if (nodo == null) {
            return;
        }
        geraNodosDOT(sb, nodo.left);
        // node10[label = "<esq> | 10 | <dir> "];
        sb.append("node" + nodo.element + "[label = \"<esq> | " + nodo.element + " | <dir> \"]\n");
        geraNodosDOT(sb, nodo.right);
    }

    public void geraConexoesDOT(StringBuilder sb) {
        geraConexoesDOT(sb, root);
    }

    public void geraNodosDOT(StringBuilder sb) {
        geraNodosDOT(sb, root);
    }

    // Gera uma saida no formato DOT
    // Esta saida pode ser visualizada no GraphViz
    // Versoes online do GraphViz pode ser encontradas em
    // http://www.webgraphviz.com/
    // http://viz-js.com/
    // https://dreampuf.github.io/GraphvizOnline
    public String toDOT() {
        StringBuilder sb = new StringBuilder();
        sb.append("digraph g { \nnode [shape = record,height=.1];\n");
        geraNodosDOT(sb);
        geraConexoesDOT(sb);
        sb.append("}\n");
        return sb.toString();
    }
}
