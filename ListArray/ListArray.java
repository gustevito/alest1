/**
 * Classe que implementa uma lista linear usando arranjo.
 * @author Isabel H. Manssour
 */

public class ListArray implements ListTAD{

    // Atributos
    private static final int TAM_DEFAULT = 10;
    private Integer[] data;
    private int count;

    /**
     * Construtor da lista.
     */
    public ListArray() {
        this(TAM_DEFAULT);
    }

    /**
     * Construtor da lista.
     * @param tam tamanho inicial a ser alocado para data[]
     */
    public ListArray(int tam) {
        if (tam <= 0) {
            tam = TAM_DEFAULT;
        }
        data = new Integer[tam];
        count = 0;
    }

    /**
     * Esvazia a lista.
     */
    public void clear() {
        data = new Integer[TAM_DEFAULT];
        count = 0;
    }

    /**
     * Retorna true se a lista nao contem elementos.
     * @return true se a lista nao contem elementos
     */

    // *** IMPLEMENTADO
    public boolean isEmpty() {
        //if(count == 0) return true;
        return (count == 0);
    }

    /**
     * Retorna o numero de elementos armazenados na lista.
     * @return o numero de elementos da lista
     */
    public int size() {
        return count;
    }

    /**
     * Adiciona um elemento ao final da lista.
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element) {
        if (count == data.length) {
            setCapacity(data.length * 2);
        }
        data[count] = element;
        count++;
    }

    /**
     * Retorna o elemento de uma determinada posicao da lista.
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer get(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        return data[index];
    }


    @Override
    public String toString() {
        String aux = "[ ";
        for (int i = 0; i < count; i++) {
         aux = aux + data[i] + " ";   
        }
        aux = aux + " ]";
        return aux;
    }

    private void setCapacity(int newCapacity) {
        if (newCapacity != data.length) {
            int min = 0;
            Integer[] newData = new Integer[newCapacity];
            if (data.length < newCapacity) {
                min = data.length;
            } else {
                min = newCapacity;
            }
            for (int i = 0; i < min; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    ////////////////////////////////////////////
    
    /**
     * Substitui o elemento armazenado em uma determinada posicao da lista pelo
     * elemento passado por parametro, retornando o elemento que foi substituido.
     * @param index a posicao da lista
     * @param element o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posicao da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */

    // *** IMPLEMENTADO
    public Integer set(int index, Integer element) {
        if (index < 0 || index >= size()){
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        Integer anterior =  data[index];
        data[index] = element;
        return anterior;
    }

    /**
     * Procura pelo elemento passado por parametro na lista e retorna true se a 
	 * lista contem este elemento.
     * @param element o elemento a ser procurado
     * @return true se a lista contem o elemento passado por parametro
     */
    public boolean contains(Integer element) {
       // Implemente este metodo
        return false;
    }

    @Override
    public void add(int index, Integer element) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean remove(Integer e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int capacity() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int indexOf(Integer e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
