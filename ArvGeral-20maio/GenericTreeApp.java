/**
 *
 * @author 10032603
 */
public class GenericTreeApp {

    public static void main(String[] args){
        GenericTreeStr arv;

        arv = new GenericTreeStr("A");

        System.out.println("\n"+arv.toString());
        System.out.println("Altura: "+arv.altura());

        arv.insert("B", "A");
        arv.insert("C", "A");
        System.out.println("\n"+arv.toString());
        System.out.println("Altura: "+arv.altura());

        arv.insert("D", "B");
        arv.insert("E", "B");
        arv.insert("F", "B");
        System.out.println("\n"+arv);
        System.out.println("Altura: "+arv.altura());

        arv.insert("I", "D");
        arv.insert("J", "D");
        System.out.println("\n"+arv);
        System.out.println("Altura: "+arv.altura());

        arv.insert("G", "C");
        arv.insert("H", "C");
        System.out.println("\n"+arv);
        System.out.println("Altura: "+arv.altura());

        arv.insert("K", "H");
        System.out.println("\n"+arv);
        System.out.println("Altura: "+arv.altura());

        //arv.insert("Z", "K");
        //System.out.println("\n"+arv);
        //System.out.println("Altura: "+arv.altura());

        System.out.println("\nNivel de A: "+arv.nivel("A"));
        System.out.println("Nivel de D: "+arv.nivel("D"));
        System.out.println("Nivel de G: "+arv.nivel("G"));
        System.out.println("Nivel de K: "+arv.nivel("K"));

        arv.showTree();
        System.out.println();

        System.out.println("Nro de elementos: "+arv.size());

        // DFS v1. escrever caminhamento em profundidade "pre ordem"
        System.out.println("\nCaminhamento em profundidade: \n");
        arv.DFSv1();

        System.out.println("\nCaminhamento em largura: \n" + arv.BFS());
        System.out.println("\nCaminhamento em largura (str): \n" + arv.BFS_str());

        ;

    }

    
}
