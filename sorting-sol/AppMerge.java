package merge;
import java.util.ArrayList;
import java.util.Random;
public class AppMerge{
    public static void main(String[] args){
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        ArrayList<Integer> merge = new ArrayList<Integer>();
        
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
        for(int i = 0; i < array.length/2; i++){   // cria o array como lista parcialmente ordenada 
            array[i] = i;
        }
        for(int i = array.length/2; i < array.length; i++){
            array[i] = rdm.nextInt(array.length/2, 100000);
        }
        
        merge mer = new merge();
        int[] sortedArray = mer.sort(array);
      
        merge.add(mer.getOp());
        mer.zerarOp();

        }
       for(int i = 0; i < 99; i++){
        System.out.print(merge.get(i) + ",");
       }
       System.out.print(merge.get(99));
}}

class merge {
    private int op;

    public merge() {
        op = 0;
    }

    public int[] sort(int[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;

            // separa em duas partes
            int[] left = new int[mid];
            int[] right = new int[array.length - mid];

            System.arraycopy(array, 0, left, 0, mid);
            System.arraycopy(array, mid, right, 0, array.length - mid);

            // sort recursivo em cada metade
            sort(left);
            sort(right);

            // merge nas metades ordenadas
            merge(array, left, right);
        }
        return array;
    }

    private void merge(int[] result, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            op++;
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
            op++;
        }

        while (j < right.length) {
            result[k++] = right[j++];
            op++;
        }
    }

    public int getOp() {
        return op;
    }
    public void zerarOp(){
        op = 0;}

}