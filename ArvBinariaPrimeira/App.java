public class App {
    public static void main(String[] args) {
        Arvore arvore = new Arvore(new Folha(30));

        arvore.insert(new Folha(15));
        arvore.insert(new Folha(45));
        arvore.insert(new Folha(7));
        arvore.insert(new Folha(19));
    }
}
