


public class App {
    public static void main(String[] args) {
        ListArray lista = new ListArray();
        System.out.println("Lista vazia? " + lista.isEmpty());
        lista.add(2);
        lista.add(4);
        lista.add(6);
        lista.add(8);
        
        System.out.println(lista.toString());
        System.out.println("Lista vazia? " + lista.isEmpty());

        
        System.out.println("Elemento armazenado na "
                + "primeira posicao da lista: " +lista.get(0));

    }
}
