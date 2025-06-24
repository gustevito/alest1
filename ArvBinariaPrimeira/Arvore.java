// public class Arvore {
//     private Folha folha;
//     private Arvore esquerda;
//     private Arvore direita;

//     public Arvore(){
//         this.folha = null;
//         this.esquerda = null;
//         this.direita = null;
//     }

//     public Arvore(Folha folha){
//         this.folha = folha;
//         this.esquerda = null;
//         this.direita = null;
//     }

//     public boolean isEmpty(){ 
//         return this.folha == null;
//     }

//     public void insert(Folha novaFolha){
//         if(isEmpty()) { 
//             this.folha = novaFolha;
//         } else {
//             Arvore novaArvore = new Arvore(novaFolha);
//             if (novaFolha.getValor() < this.folha.getValor()) {
//                 if (this.esquerda == null){
//                     this.esquerda = novaArvore;
//                     System.out.println("Folha: " + novaFolha.getValor() + " a esquerda de: " + this.folha.getValor());
//                 }
//                 else {
//                     this.esquerda.insert(novaFolha);
//                 }
//             }
//             else if (novaFolha.getValor() > this.folha.getValor()) {
//                 if (this.direita == null){
//                     this.direita = novaArvore;
//                     System.out.println("Folha: " + novaFolha.getValor() + " a direita de: " + this.folha.getValor());
//                 } else {
//                     this.direita.insert(novaFolha);
//                 }
//             }
//         }
//     }
// }













