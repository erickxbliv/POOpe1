package br.edu.ufca.ClassesDeRepositorios;
import br.edu.ufca.ClassesDeDados.Jogador;
import br.edu.ufca.ClassesDeTestes.TesteJogo;

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
        novo.setNome(NomeDeUsuario);
        novo.setId(this.apostadores.size());
        novo.setFuncao(1);

        novo.setConta(conta);
        this.apostadores.add(novo);
        //novo.data_criacao = ;

        return false;
    }

    protected void preencher_teste(ArrayList<Jogador> populacao){

        Jogador cliente = new Jogador();
        Jogador cliente2 = new Jogador();
        Jogador cliente3 = new Jogador();
        Jogador cliente4 = new Jogador();

        String nome = "erick";
        
        cliente.setNome(nome);
        cliente.setId(1);
        cliente.setFuncao(1);
        cliente.setConta(563826);
        populacao.add(cliente);

        nome = "andre";

        cliente2.setNome(nome);
        cliente2.setId(2);
        cliente2.setFuncao(1);
        cliente2.setConta(519460);
        populacao.add(cliente2);

        nome = "a";

        cliente3.setNome(nome);
        cliente3.setId(3);
        cliente3.setFuncao(1);
        cliente3.setConta(671945);
        cliente3.setSaldo(10000.0);
        populacao.add(cliente3);

        nome = "1";

        cliente4.setNome(nome);
        cliente4.setId(4);
        cliente4.setFuncao(1);
        cliente4.setConta(678145);
        cliente4.setSaldo(100000000.12345);
        populacao.add(cliente4);
    }


    public Jogador BuscarEsteJogador(String NomeDeUsuario){

        int tam;
        tam = this.apostadores.size();

        for(int i = 0; i < tam; i++){
            if((this.apostadores.get(i).getNome()).equals(NomeDeUsuario)) return this.apostadores.get(i);
        }
        return null;
    }



    public int JogadorExiste(String NomeDeUsuario){

        int tam;
        tam = this.apostadores.size();
        for(int i = 0; i < tam; i++){
            if((this.apostadores.get(i).getNome()).equals(NomeDeUsuario)) return this.apostadores.get(i).funcao;
        }
        return -1;
    }

    
    public boolean PodeArcar(String NomeDeUsuario, double aposta){

        if(aposta <= 0.0){
            System.out.println("Valor inserido e invalido, tente novamente.\n");
            return false;
        }

        Jogador usuario = new Jogador();
        usuario = BuscarEsteJogador(NomeDeUsuario);
        boolean pode = usuario.tem_suficiente(aposta);
        if(!pode) System.out.println("Poxa, parece que seu saldo e insuficiente, tente novamente.\n");
        return pode;
    }

    public void IniciarJogo(String NomeDeUsuario, TesteJogo Arcade, int escolha, double aposta){

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