import java.util.ArrayList;
/**
 *
 * @author J. Tonhon
 */
public class Sonda {
    
    private String nome;
    private int x,y;
    private char orientacao;
    private String erro;

    public Sonda(String nome, int x, int y, char orientacao) { 
        this.nome = nome;
        this.x = x;
        this.y = y;
        this.orientacao = orientacao;
        this.erro = "";
    }
    
    void Mover(Planalto planalto, String movimento, ArrayList<Sonda> listaSondas){
        
        for(int i = 0;i<movimento.length();i++){
            //Variável auxiliar para a comparação de char
            char aux = movimento.charAt(i);                                     
            switch (aux) {
                case 'M':
                    if(this.Avancar(planalto, listaSondas)); //; para representar um "do nothing"   
                    //Variável auxiliar para identificar e printar o erro
                    else this.erro = "Caminho obstruído ou fora do alcance da missão";
                    break;
                case 'L':
                    this.virarEsquerda();
                    break;
                case 'R':
                    this.virarDireita();
                    break;
                default:
                    break;
            }
            if (!this.erro.isEmpty()){ 
                System.out.println("[LOG - ERROR] - "+ this.nome+": "+this.erro);
                //break para quebrar o for e tirar a sonda do loop
                break;
            }
        }
    }
    
    //Função para modificar a orientação
    void virarEsquerda(){
          switch (this.orientacao){
            case 'N': this.orientacao = 'W';  break;
            case 'S': this.orientacao = 'E';  break;  
            case 'W': this.orientacao = 'S';  break;  
            case 'E': this.orientacao = 'N';  break;  
        }     
    }
    
    //Função para modificar a orientação
    void virarDireita(){
        switch (this.orientacao){
            case 'N': this.orientacao = 'E';  break;
            case 'S': this.orientacao = 'W';  break;  
            case 'W': this.orientacao = 'N';  break;  
            case 'E': this.orientacao = 'S';  break;   
        }
        
    }
     
    boolean Avancar(Planalto planalto, ArrayList<Sonda> listaSondas){
        //Declaração de pontos x e y locais auxiliares
        int x = this.x;
        int y = this.y;
        switch (this.orientacao){  
            case 'N': y += 1;  break;
            case 'S': y -= 1;  break;  
            case 'W': x -= 1;  break;  
            case 'E': x += 1;  break;   
        }
        //Verificação se a sonda está dentro dos limites do planalto
        if(x<0||x>planalto.getLargura()||y<0||y>planalto.getAltura())
            return false;
        //Verificação para verificar colisão de sondas
        for(int i=0;i<listaSondas.size()-1;i++){
            System.out.println(listaSondas.get(i).nome);
            if(x == listaSondas.get(i).x && y == listaSondas.get(i).y) 
            return false;
        }
        this.x = x;
        this.y = y; 
        return true;    
    }
    
   @Override
   //Método para printar o arraylist na main
   public String toString() {
       return("Nome: " + this.getNome() +"   " +
              "Posição Final: "+ this.x + ", " + this.y + "   " +
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
