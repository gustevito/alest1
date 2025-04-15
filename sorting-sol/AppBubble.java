import java.util.ArrayList;
import java.util.Random;

public class AppBubble{
    public static void main(String[] args){
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        ArrayList<Integer> bubble = new ArrayList<Integer>();
       
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
        for(int i = 0; i < array.length/2; i++){  // cria o array como lista parcialmente ordenada
            array[i] = i;
        }
        for(int i = array.length/2; i < array.length; i++){
            array[i] = rdm.nextInt(array.length/2, 100000);
        }
      

        bubble bolha = new bubble();
        int[] sortedArray = bolha.sort(array); 
        int bolhaOperacoes = bolha.getOp();
        bolha.zerarOp();
        bubble.add(bolhaOperacoes);
        }
       for(int i = 0; i < 99; i++){
        System.out.print(bubble.get(i) + ",");
       }
       System.out.print(bubble.get(99));

 }  }  

class bubble{
    private int op;
    public bubble(){
        op = 0;
    }
    public int[] sort(int[] array){
        for(int i = 0; i<array.length-1; i++){
            for(int j = i; j<array.length; j++){
                if(array[i] > array[j]){
                    int aux = array[j];
                    array[j] = array[i];
                    array[i] = aux;
                    op++;
                }
            }
        }
        return array;
    }
    public int getOp(){
        return op;
    }
    public void zerarOp(){
        this.op = 0;
    }
}
 
