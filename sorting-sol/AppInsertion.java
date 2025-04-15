package insertion;
import java.util.ArrayList;
import java.util.Random;
public class AppInsertion{
    public static void main(String[] args){
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        ArrayList<Integer> insertion = new ArrayList<Integer>();

        for(int j = 500; j < 50001; j = j+500){  
            numeros.add(j);
        Random rdm = new Random();
         int[] array = new int[j]; 
        /*

        //cria um array totalmente aleatorio
        for(int i = array.length-1; i >= 0; i--){
            array[i] = rdm.nextInt(1,55000);
        }

        // cria array ordenado em ordem decrescente
        for(int i = array.length-1; i >= 0; i--){
            array[i] = 55000-i;
        }
        
        // cria array em ordem crescente
        for(int i = array.length-1; i >= 0; i--){
            array[i] = i;
        }
        
        */ 
         for(int i = 0; i < array.length/2; i++){   /// cria o array como lista parcialmente ordenada 
            array[i] = i;
        }
        for(int i = array.length/2; i < array.length; i++){
            array[i] = rdm.nextInt(array.length/2, 100000);
        }
        insertion ins = new insertion();
        int[] sortedArray = ins.sort(array); 
       
        int insertionOperacoes = ins.getOp(); ins.zerarOp();
        insertion.add(insertionOperacoes);
        }
       for(int i = 0; i < 99; i++){
        System.out.print(insertion.get(i) + ",");
       }
       System.out.print(insertion.get(99));
       
    }
}
class insertion {
    private int op;

    public insertion() {
        op = 0;
    }

    public int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                op++;
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        return array;
    }

    public int getOp() {
        return op;
    }
    public void zerarOp(){
        op = 0;
    }
    
}