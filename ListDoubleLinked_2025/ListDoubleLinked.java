//
//  exercício: reescrever todos os métodos
//             para implementar uma lista duplamente encadeada
//


public class ListDoubleLinked implements ListTAD{

  private class Node {
    public Integer element ;
    public Node next ;
   
    public Node(Integer e) {
       element = e ;
       next = null ;
    }
  }

  private Node head ;
  private Node tail ;
  private int count ;
  
  // Construtor
  public ListSingleLinked ( ) {
      head = null ;
      tail = null ;
      count = 0;
  }

  @Override
  public void add(Integer element) {

      Node novo = new Node(element);

      if ( isEmpty() ) {
        head = novo;
        tail = novo;
        //count++;
      } else {
        tail.next = novo;
        tail = novo;
        //count++;
      }

      count++;

  }

  public void insereOrdenado(int valor) {
    // lembrete... 
    //    preciso fazer funcionar para estes casos
    //        1. se lista está vazia?
    //        2. se é o primeiro?
    //        3. se é o último?
    //        4. então é um do meio...

    Node novo = new Node(valor);

    if ( isEmpty() ) {                 // caso 1 - lista vazia
       head = novo;
       tail = novo;

    } else if ( valor <= head.element) {  // caso 2 - novo primeiro
      novo.next = head;
      head = novo;
    } else if (valor >= tail.element) {   // caso 3 - novo último
        tail.next = novo;
        tail = novo;  
    } else {                              // caso 4 - é um do meio    
      Node target = head;
      Node aux = null;
      while (valor > target.element) {
        aux = target;
        target = target.next;
      }  
      aux.next = novo;
      novo.next = target;            

    }

    count++;
  }

  
  @Override
  public void add(int index, Integer element) {
    if (index<0 || index>count) {
      throw new IndexOutOfBoundsException("Indice Inválido ");
    }

    Node novo = new Node(element);

    if (index == 0) {
      novo.next = head;
      head = novo;
    } else {
      Node aux = head;
      for (int i = 0; i<index-1; i++) {
        aux = aux.next;
      }
      novo.next = aux.next;
      aux.next = novo;
    }
    if (novo.next == null) {
      tail = novo;
    }
    count++;

  }
  

  @Override
  public Integer get(int index) {
    if (index<0 || index>count) {
      throw new IndexOutOfBoundsException("Indice Inválido ");
    }
    Node aux = head;
    for (int i = 0; i<index; i++) {
      aux = aux.next;
    }
    return aux.element;
  }

  @Override
  public Integer set(int index, Integer element) {
      if (index<0 || index>count) {
        throw new IndexOutOfBoundsException("Indice Inválido ");
      }
      Node aux = head;
      for (int i = 0; i<index; i++) {
        aux = aux.next;
      }

      Integer val = aux.element;
      aux.element = element;

      return val;
    }

  @Override
  public boolean remove(Integer element) {

    int index = indexOf(element);
    if (index == -1) {
      return false;
    } else {
      removeByIndex(index);
      return true;
    }
    /* 
    Node aux = head;
    Node prev = null;

    while (aux != null) {
      if (aux.element.equals(element)) {
        if (prev == null) { // remove o primeiro
          head = head.next;
        } else {
          prev.next = aux.next;
        }
        count--;
        return true;
      }
      prev = aux;
      aux = aux.next;
    }
    return false; // se nao achou
    */
  }

  @Override
  public Integer removeByIndex(int index) {
    if (index<0 || index>count) {
      throw new IndexOutOfBoundsException("Indice Inválido ");
    }

    Integer val = null;

    if (index == 0) {
      val = head.element;
      head = head.next;
    } else {

      Node aux = head;
      for (int i = 0; i<index-1; i++) {
        aux = aux.next;
      }
      Node target = aux.next;
      val = target.element;   //aux.next.element;
      aux.next = target.next; // aux.next.next;
      if (target == tail) {
        tail = aux;
      }
    }
    count--;
    return val;
  }

  @Override
  public boolean isEmpty() {
    if (count == 0) {  // ou: head == null  ou: tail == null
      return true;
    } else {
      return false;
    }
    // return count == 0
  }

  @Override
  public int size() {
     return count;
  }

  @Override
  public boolean contains(Integer element) {
    if (indexOf(element) == -1) {
      return false;
    } else {
      return true;
    }
    
  }

  @Override
  public int indexOf(Integer element) {
     int pos = 0;
     Node aux = head;
     while ( aux != null) {
      if ( aux.element.equals(element)) {
        return pos;
      } // nao vou usar else pq se achou deu return...
      pos = pos + 1;
      aux = aux.next;
     }
     // se nao achou retorna -1
     return -1;
     
  }

  @Override
  public void clear() {
      head = null ;
      tail = null ;
      count = 0;
  }

  @Override
  public String toString() {
    String result = "[ ";
    Node aux = head;
    while ( aux != null) {
      result = result + aux.element + " ";
      aux = aux.next;
    }

    return result+"]";
  }

  public Integer getLast() {
    if (isEmpty()) {
      return null;
    } else {
      return tail.element;
    }
  }

  
}