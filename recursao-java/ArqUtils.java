
/**
 * Write a description of class ArqUtils here.
 * 
 * @author aa, flash 
 * 
 */
import java.io.File;
import java.util.ArrayList;

public class ArqUtils
{
   public static void main(String[] args) {
       File inicio = new File(args[0]);
       if (inicio != null) {
           int nroArqs = contaArquivos(inicio);
           System.out.println(nroArqs +" em "+inicio.toString());
           System.out.println();
       
           ArrayList<File> arqs = pesquisaArquivos(inicio, "png");
           System.out.println(arqs.size() +" arquivos encontrados ");
           for(File f : arqs)
               System.out.println(f.getName() + "  em "+f.getPath());
          
       }
    }
    
    public static int contaArquivos(File f) {
        if (f.isFile()) {
            return 1;
        }
        //else
        //   System.out.println("--> "+f.toString());
        // Conta "filhos" e processa recursivamente
        // os subdiretorios
        int total = 0;
        File[] arqs = f.listFiles();
        if (arqs != null) 
           for (File arquivoOuDir : arqs) {
               total += contaArquivos(arquivoOuDir);
           }
        return total;
    }
    
    public static ArrayList<File> pesquisaArquivos(File f, String pesq) {
        ArrayList<File> result = new ArrayList<File>();
    
        if (f.isFile())
        {
           if(f.getName().indexOf(pesq) != -1) {
                result.add(f); 
           }
           return result;
        }
        //else
        //   System.out.println("--> "+f.toString());
        // Conta "filhos" e processa recursivamente
        // os subdiretorios
        File[] arqs = f.listFiles();
        if (arqs != null) 
           for (File arquivoOuDir : arqs) 
               result.addAll(pesquisaArquivos(arquivoOuDir, pesq));
            
        return result;
    }
}
