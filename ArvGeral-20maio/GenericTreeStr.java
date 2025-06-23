import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class GenericTreeStr {
    
    private Node root;
    // 
    // será que quero/preciso guardar o numero de elementos?
    // se sim...
    // private int count;
    // neste exercício vamos calcular...
    
    private static class Node {
        Node Parent;
        String Elem;
        List<Node> Children;
        
        public Node(String  valor) {
            Elem = valor;
            Parent = null;
            Children = new ArrayList<>();
        }
    }

    // será que quero um constutor vazio?
    // se minha aplicação permite árvores vazias -> sim
    // caso contrário -> não
    //public GenericTreeStr() {
    //}

    public GenericTreeStr() {
        root = null;
        //count = 0;
  }  
    public GenericTreeStr(String elem) {
          root = new Node(elem);
          //count = 1;
    }  
      
    // troquei o tipo de retorno
    // SE paiSTR == null, entá inserindo como raiz
    //      se já tiver elementos - substitui e perde a árvore anterior
    public boolean insert(String elem, String paiStr) {
         Node pai = searchNodeRef(paiStr, root); 

         if (pai == null) {
            // o que fazer se não achou o pai?
            // 1. lançar excecão? -> problema da app
            // 2. retornar false? -> trocar o tipo do método
            // 3. fazer nada? -> pior de todas  
            return false;
         }
         else {
             Node novo = new Node(elem);
             novo.Parent = pai;
             pai.Children.add(novo);
             return true;
         }
      }
      
      private Node searchNodeRef(String e, Node r) {
          if (r.Elem.equals(e))
              return r;
          //for (int i =0; i<r.Children.size();i++) {
          //  Node f = r.Children.get(i);
             // mais eficiente se escrever assim...
          for (Node f : r.Children) {
              Node aux = searchNodeRef(e, f);
              if ( aux != null) return aux;
          }  
          return null;
      }
      
      public int size() {
            // como não estou armazenando vou ter de 
            // "percorrer a árvore contando"
            // técnica importante:
            // --> visão do usuário X visão da classse
            // --> para poder realizar a recursão repassamos
            //     para um método interno
            return size(root);
      }

      private int size(Node r) {
        // temos dois tipos de caminhamento:
        // 1. em profundidade -> usa recursão
        //    DFD - death first search
        // 2. em largura -> usa uma fila
        //    BFS - breath first search
        // grande maioiria dos algoritmos de árvores
        // são variações dos algoritmos de profindidade
        // DFS para o tamanho...
        int result = 1;   // o elemento do nodo atual
        for (Node f: r.Children) {
            result = result + size(f);
        }
        return result;
      }

      public void showTree() {
        showTree(root,"");
      }
      
      private void showTree(Node atual, String espacos) {
          System.out.println(espacos+atual.Elem);
          for (Node f : atual.Children) {
              showTree(f, espacos+"  | ");       
          }
      }

    public void DFSv1() {
       DFSv1(root);
    }

    private void DFSv1(Node atual) {
        // pré-ordem: faço algo com o pai antes da recursão
        System.out.print(atual.Elem + " - ");
        for (Node filho : atual.Children) {
            DFSv1(filho);        
        }

    }

    // caminhamento em largura (por níveis)
    // BFS --> Breath First Search
    public ArrayList<String> BFS() {
        // algoritmo:
        //  Fila<Nodo> f
        //  insere root na fila f
        //  enquanto fila não vazia
        //     retira n da fila e "visita"
        //     insere filhos de n na fila f
        ArrayList<String> result = new ArrayList<>();
        Queue<Node> fila = new LinkedList<>();
        fila.add(root);
        while ( !fila.isEmpty()) {
            Node atual = fila.remove();
            result.add(atual.Elem);
            for (Node filho: atual.Children) {
                fila.add(filho);
            }
        }
        return result;
    }

    //
    //  mesmo método anterior, mas que devolve uma string e nao uma lista
    //
    public String BFS_str() {
        // algoritmo:
        //  Fila<Nodo> f
        //  insere root na fila f
        //  enquanto fila não vazia
        //     retira n da fila e "visita"
        //     insere filhos de n na fila f
        String result = "";
        Queue<Node> fila = new LinkedList<>();
        fila.add(root);
        while ( !fila.isEmpty()) {
            Node atual = fila.remove();
            result = result + atual.Elem + " ";  // <-- visita

            for (Node filho: atual.Children) {
                fila.add(filho);
            }
        }
        return result;
    }







    public String toString() {
        return toString(root);
    }

    private String toString(Node atual) {
        String aux = "";
        for(Node filho: atual.Children) {
            aux = aux + ", "+toString(filho);
        }
        return "{" + atual.Elem + aux +"}";

    }

    public int altura(){
        return altura(root);
    }

    private int altura(Node atual) {
        int maiorH = 0;
        for(Node filho: atual.Children) {
            //maiorH = Math.max(maiorH, altura(filho) + 1);
            // codigo acima igual a...
            int aux = altura(filho) + 1;
            if (aux>maiorH)
                maiorH = aux; 
    
        }
        return maiorH;
    }

    public int nivel(String elem) {
        int nivel = 0;
        Node n = searchNodeRef(elem, root);
        if (n==null)
            return -1;
        else {
            while (n.Parent != null) {
                nivel++;
                n = n.Parent;
            }
        return nivel;
        }    


    }
      
}
   