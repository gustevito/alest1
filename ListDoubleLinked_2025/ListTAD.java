// Interface ListTAD:
// Define os métodos que qualquer implementação
// de lista deve ter
// (isto é, eles PRECISAM ser implementados)
public interface ListTAD {
    public void add(Integer element);
    public void add(int index, Integer element);
    public Integer get(int index);
    public Integer set(int index, Integer element);
    public boolean remove(Integer element);
    public Integer removeByIndex(int index);
    public boolean isEmpty();
    public int size();
    public boolean contains(Integer element);

    public int indexOf(Integer element);

    public void clear();
}
