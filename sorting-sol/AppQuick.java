package quick;
import java.util.Random;
import java.util.ArrayList;
public class AppQuick{
    public static void main(String[] args){
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        ArrayList<Integer> quicksort = new ArrayList<Integer>();

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
        for(int i = 0; i < array.length/2; i++){    // cria o array como lista parcialmente ordenada
            array[i] = i;
        }
        for(int i = array.length/2; i < array.length; i++){
            array[i] = rdm.nextInt(array.length/2, 100000);
        }
        quick qck = new quick();
        int[] sortedArray5 = qck.sort(array);
     
        quicksort.add(qck.getOp()); 
        qck.zerarOp();
        }
     
       for(int i = 0; i < 99; i++){
        System.out.print(quicksort.get(i) + ",");
       }
       System.out.print(quicksort.get(99));
}}
class quick
{
    private int[] data;
    private int op = 0;

    public quick() {
        
    }

    public int[] sort(int[] data) {
        this.data = data;
        sort(0, data.length-1);
        return data;
        }

    public void sort(int start, int end) {

        if(start < end) {
            int pivot_pos = partition(start, end);
            sort(start, pivot_pos-1);
            sort(pivot_pos+1, end);
        }
    }

    private int partition(int start, int end) {
        Random rand = new Random();
        int pivotIndex = rand.nextInt(end - start + 1) + start;
        
        swap(start, pivotIndex);
        
        int i = start + 1;
        int pivot = data[start];
        for (int j = start + 1; j <= end; j++) {
            op++;
            if (data[j] < pivot) {
                swap(i, j);
                i++;
            }
        }
        swap(start, i - 1);
        return i - 1;
    }
    private void swap(int p1, int p2) {
        int tmp = data[p1];
        data[p1] = data[p2];
        data[p2] = tmp;
    }
    public int getOp(){
        return op;
    }
public void zerarOp(){
    op = 0;
}}

