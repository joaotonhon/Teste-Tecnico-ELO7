import java.util.ArrayList;
/**
 *
 * @author J. Tonhon
 */
public class Sonda {
    
    private String nome;
    private int x,y;
    private char orientacao;

    public Sonda(String nome, int x, int y, char orientacao) { 
        this.nome = nome;
        this.x = x;
        this.y = y;
        this.orientacao = orientacao;
    }
    
    void Mover(Planalto planalto, String movimento, ArrayList listaSondas){
        
        for(int i = 0;i<movimento.length();i++){
            char aux = movimento.charAt(i);                                     //Variável auxiliar para a comparação de char
            if(aux == 'M') moverFrente();
            else if(aux == 'L') virarEsquerda();
            else if(aux == 'R') virarDireita();
        }
    }
    
    void virarEsquerda(){
        
        
       
        
    }
    
    void virarDireita(){
        
    }
    
    void moverFrente(){
        
    }
    
   @Override
   public String toString() {                                                   //Método para printar o arraylist na main
       return("Nome: " + this.getNome()+ "\n" +
              "Posição Inicial: "+ this.x + ", " + this.y + "\n" +
              "Orientação: "+ this.orientacao);
   }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getOrientacao() {
        return orientacao;
    }

    public void setOrientacao(char orientacao) {
        this.orientacao = orientacao;
    }
}
