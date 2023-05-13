package ClassesDeRepositorios;
import ClassesDeDados.Jogador;
import ClassesDeDados.Jogo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;


public class RepositorioJogador {

    private ArrayList<Jogador> apostadores; //Arraylist de jogadores

    public ArrayList<Jogador> rank = new ArrayList<Jogador>();      //que isso?


    public void InicializarMeusJogadores(){

        this.apostadores = new ArrayList<Jogador>(); //instanciando arraylist de jogadores  -> apostadores
        preencher_teste(apostadores);

    }

    public boolean criar_Jogador(String NomeDeUsuario, int conta){

        Jogador novo = new Jogador();
        novo = BuscarEsteJogador(NomeDeUsuario);
        if(novo != null){
            System.out.println("\nPoxa, este apelido já está em uso, tente novamente.");
            return true;
        }

        novo = new Jogador();
        novo.nome = NomeDeUsuario;
        novo.id = this.apostadores.size();
        novo.tipo = "Jogador";

        novo.setConta(conta);
        this.apostadores.add(novo);
        //novo.data_criacao = ;

        return false;
        
    }

    protected void preencher_teste(ArrayList<Jogador> populacao){

        Jogador cliente = new Jogador();
        Jogador cliente2 = new Jogador();
        Jogador cliente3 = new Jogador();
        
        cliente.nome = "Erick de Brito";
        cliente.id = 1;
        //cliente.tipo = "Jogador";
        cliente2.funcao = 1;
        cliente.setConta(120445);
        //cliente.transacao(537.5);

        populacao.add(cliente);

        cliente2.nome = "Andre Castro";
        cliente2.id = 2;
        //cliente2.tipo = "Jogador";
        cliente2.funcao = 1;
        cliente2.setConta(563282);
        //cliente2.transacao(1343.25);

        populacao.add(cliente2);


        cliente3.nome = "a";
        cliente3.id = 3;
        cliente3.funcao = 1;
        cliente3.setConta(639264);

        populacao.add(cliente3);

    }


    public Jogador BuscarEsteJogador(String NomeDeUsuario){

        int tam;
        tam = this.apostadores.size();

        for(int i = 0; i < tam; i++){
            if(this.apostadores.get(i).nome.equals(NomeDeUsuario)) return this.apostadores.get(i);
        }
        return null;
    }



    public int JogadorExiste(String NomeDeUsuario){

        int tam;
        tam = this.apostadores.size();
        for(int i = 0; i < tam; i++){
            if(this.apostadores.get(i).nome.equals(NomeDeUsuario)) return this.apostadores.get(i).funcao;
        }
        return -1;
    }

    
    public boolean PodeArcar(String NomeDeUsuario, double aposta){

        Jogador usuario = new Jogador();
        usuario = BuscarEsteJogador(NomeDeUsuario);

        if(usuario.getSaldo() < aposta) return false;
        else return true;
    }

    public void IniciarJogo(String NomeDeUsuario, Jogo Arcade, int escolha, double aposta){

        Jogador usuario = new Jogador();
        usuario = BuscarEsteJogador(NomeDeUsuario);

        double montante = Arcade.Desktop(escolha,aposta);
        usuario.transacao(montante);
        return;
    }

    
    public double ConsultarSaldo(String NomeDeUsuario){

        Jogador usuario;
        double saldo = 0.0;
        usuario = BuscarEsteJogador(NomeDeUsuario);
        if(usuario != null) saldo = usuario.getSaldo();
        return saldo;
    }



/* 
    public static void serializeDataOut(IHandler ish)throws IOException{
        String fileName= "Test.txt";
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(ish);
        oos.close();
    }
    
    public static IHandler serializeDataIn(){
       String fileName= "Test.txt";
       FileInputStream fin = new FileInputStream(fileName);
       ObjectInputStream ois = new ObjectInputStream(fin);
       IHandler iHandler= (IHandler) ois.readObject();
       ois.close();
       return iHandler;
    }


    try{
        FileOutputStream fileOutputStream = new FileOutputStream("Dog.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        //Writing the Dog object 
        objectOutputStream.writeObject(dog);
        //Close the ObjectOutputStream
        objectOutputStream.close();
        }catch(IOException e){
          e.printStackTrace
        }

        */

}