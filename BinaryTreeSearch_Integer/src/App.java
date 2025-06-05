import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        BinarySearchTreeInteger b = new BinarySearchTreeInteger();
        b.add(15);
        b.add(23);
        b.add(9);
        b.add(11);
        b.add(2);
        b.add(20);
        b.add(38);
        b.add(17);
        b.add(25);
        b.add(27);

        List<Integer> central = b.positionsCentral();
        System.out.println("Central:\n" + central);
        
        String centralStr = b.positionsCentralStr();
        System.out.println("Central:\n" + centralStr);

        System.out.println("\n\nContem 2? " + b.contains(2));
        System.out.println("Contem 38? " + b.contains(38));
        System.out.println("Contem 55? " + b.contains(55));
        System.out.println("Contem 32? " + b.contains(32));
/* 
        System.out.println("-------------");
        System.out.println(b.toDOT());
        System.out.println("-------------");
        if (b.remove2(23))
            System.out.println("23 removido!");
        else
            System.out.println("Não tem 23!!!");
        System.out.println("-------------");
        System.out.println(b.toDOT());
        if (b.remove2(15))
            System.out.println("15 removido!");
        else
            System.out.println("Não tem 15!!!");
        System.out.println("-------------");
        System.out.println(b.toDOT());

        Random r = new Random(42);
        for (int i = 0; i < 100; i++)
            b.add(Math.abs(r.nextInt() % 10000));
        System.out.println("-------------");
        //System.out.println(b.toDOT());
        System.out.println();
        System.out.println("Removendo o 5035");
        b.remove2(5035);
        System.out.println("-------------");
       // System.out.println(b.toDOT());
    */
    }

}
