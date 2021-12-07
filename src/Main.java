import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author J. Tonhon
 */
public class Main {
    
    public static void main(String[] args) {
        //Operador para condição de repetição do dowhile
        boolean continuar = true;                                               
        //Instanciamento do scanner
        Scanner ler = new Scanner(System.in);                                  
        
        //Criação do planalto
        System.out.println("Insira a largura do planalto: ");
        int largura = ler.nextInt();
        System.out.println("Insira a altura do planalto: ");
        int altura = ler.nextInt();
        Planalto planalto = new Planalto(largura, altura);
        //Criação da lista de sondas
        ArrayList<Sonda> listaSondas = new ArrayList<>();
        //Nó de repetição para criação e movimentação das sondas
        do { 
            System.out.println("Dê um nome à nova sonda: ");
            String nome = ler.next();
            System.out.println("Insira a coordenada X da posição inicial da Sonda: ");
            int x = ler.nextInt();
            System.out.println("Insira a coordenada Y da posição inicial da Sonda: ");
            int y = ler.nextInt();
            System.out.println("Insira a direção para qual a sonda está apontando: ");
            char orientacao = ler.next().charAt(0);
            System.out.println("Por fim, insira os comandos para a movimentação da sonda:\nUse L para left, R para Right e M para move");
            String movimento = ler.next();
            listaSondas.add(new Sonda(nome, x, y, orientacao));
            System.out.println(listaSondas.size());
            listaSondas.get(listaSondas.size()-1).Mover(planalto, movimento, listaSondas); //Pegando a ultima sonda criada e acessando-a
            System.out.println(listaSondas); 
            System.out.println("Você quer enviar outra sonda? (s/n)");
            if (ler.next().toLowerCase().charAt(0) != 's') continuar = false;
        }
        while(continuar);
    }
}
   
