/**
 *
 * @author 10032603
 */
public class GenericTreeApp {

    public static void main(String[] args){
        GenericTreeStr arv;

        arv = new GenericTreeStr("A");

        arv.insert("B", "A");
        arv.insert("C", "A");

        arv.insert("D", "B");
        arv.insert("E", "B");
        arv.insert("F", "B");

        arv.insert("I", "D");
        arv.insert("J", "D");

        arv.insert("G", "C");
        arv.insert("H", "C");

        arv.insert("K", "H");

        arv.showTree();

        System.out.println("Tamanho da árvore: " + arv.size());

        System.out.println("Pré-ordem: " + arv.preOrderStr());
        System.out.println("Pós-ordem: " + arv.posOrderStr());
    }

    
}
