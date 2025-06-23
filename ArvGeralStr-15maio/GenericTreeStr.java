import java.util.LinkedList;
import java.util.List;

public class GenericTreeStr {
    
    private Node root;
    
    private static class Node {
        String Elem;

        Node Parent;
        List<Node> Children;
        
        public Node(String  valor) {
            Elem = valor;
            Parent = null;
            Children = new LinkedList<>();
        }
    }

    public GenericTreeStr(String elem) {
          root = new Node(elem);
    }  
      
    public void insert(String elem, String paiStr) {
         Node pai = searchNodeRef(paiStr, root); 
         if (pai!=null) {
             Node novo = new Node(elem);
             novo.Parent = pai;
             pai.Children.add(novo);
         }
      }
      
      private Node searchNodeRef(String e, Node r) {
          if (r.Elem.equals(e))
              return r;
          for (Node f : r.Children) {
              Node aux = searchNodeRef(e, f);
              if ( aux != null) return aux;
          }  
          return null;
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


      public int size() {
            return size(root);
        }

        private int size(Node atual) {
            int cont = 1;
            for (Node f : atual.Children) {
                cont += size(f);
            }
            System.out.println("\t " + atual.Elem + " -> " + cont);
            return cont;
        }

        public String preOrderStr() {
            return preOrderStr(root);
        }

        private String preOrderStr(Node atual) {
            String result = atual.Elem + " ";
            for (Node f : atual.Children) {
                result += preOrderStr(f);
            }
            System.out.println("\t"+atual.Elem + " -> " + result);
            return result;
        }

        public String posOrderStr() {
            return posOrderStr(root);
        }

        private String posOrderStr(Node atual) {
            String result = "";
            for (Node f : atual.Children) {
                result += posOrderStr(f);
            }
            result += atual.Elem + " ";
            System.out.println("\t"+atual.Elem + " -> " + result);
            return result;
        }




	

      
}
   