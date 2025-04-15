import java.util.List;

public class App {
  public static void main(String[] args) {
    System.out.println();

    ListSingleLinked lista;
    lista  = new ListSingleLinked();
    System.out.println("vazia: "+lista.isEmpty());
    System.out.println(lista.toString());
    //lista.insereFim(10);
    lista.add(5);
    lista.add(7);
    lista.add(3);
    lista.add(9);
    System.out.println(lista.toString());

    lista.add(0,6);
    lista.add(3,4);
    System.out.println(lista.toString());
   // lista.add(6,1);
    System.out.println(lista.toString());
    
     
    
    //System.out.println("vazia: "+lista.isEmpty());
    //System.out.println(lista.toString());
    System.out.println("indexOf(7): "+lista.indexOf(7));
    System.out.println("indexOf(15): "+lista.indexOf(15));

    System.out.println("elemento na posição 0: "+lista.get(0));
    System.out.println("elemento na posição 3: "+lista.get(3));
    System.out.println("elemento ultima posicao: "+lista.get(lista.size()-1));

    lista.set(0, 0);
    System.out.println(lista.set(1,1));
    System.out.println(lista.toString());
    
    System.out.println("\n teste removeByValue");
    System.out.println(lista.toString());
    System.out.println();
    lista.removeByIndex(0);
    System.out.println(lista.toString());
    System.out.println(lista.getLast());
    lista.removeByIndex(3);
    System.out.println(lista.toString());
    System.out.println(lista.getLast());
    lista.removeByIndex(lista.size()-1);
    System.out.println(lista.toString());
    System.out.println(lista.getLast());

    // teste da inserçao ordenada
    // nao pode usar addindex e nem add...
    
    ListSingleLinked listaOrd = new ListSingleLinked();

    System.out.println("\nteste de uma lista ordenada");
    listaOrd.insereOrdenado(10);
    listaOrd.insereOrdenado(5);
    listaOrd.insereOrdenado(20);
    listaOrd.insereOrdenado(7);
    listaOrd.insereOrdenado(33);
    listaOrd.insereOrdenado(1);
    
    System.out.println(listaOrd.toString());
    





    /*

    lista.show();
    lista.add(2, 6);
    lista.add(3, 8);
    System.out.println("antes do insert nas pontas...");
    lista.show();
    lista.add(0, 0);
    lista.add(7, 99);
    lista.show();
    System.out.printf("indexOf(6): %d\n", lista.indexOf(6));
    System.out.printf("indexOf(16): %d\n", lista.indexOf(16));
    */
  }
}
