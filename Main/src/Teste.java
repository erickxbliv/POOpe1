import ClassesDeDados.Jogador;
import ClassesDeDados.Funcionario;
import ClassesDeRepositorios.Repositorio;

import java.util.Scanner;
import java.util.ArrayList;

public class Teste{         //classe de teste (Main)
    public static void main(String[] args){

        ArrayList<Jogador> apostadores = new ArrayList<Jogador>();
        ArrayList<Funcionario> trabalhadores = new ArrayList<Funcionario>();
        preencher_teste(apostadores);
        


        System.out.println("Bem vindo! Como e o seu nome? Identifique-se: ");
        getNome()



        //receber dados de um usuario totalmente novo
        //dependendo do seu tipo salvar ele em um local diferente (grupos de dados)
        //dependendo da sua funcao mostrar opcoes diferentes de tarefas a executar
        //todas as funcoes sao automaticas e de apenas impressao da tela, retornando pras opcoes ou sair da conta
        //todas as funcoes lidam com indices aleatorios dos grupos de dados para serem os outros "humanos" das interacoes
        //esses outros humanos tambem sofrem as consequencias que foram mostradas para o usuario
        //salvar os dados no final para guardar o estado atual de cada execucao
        

    }










    public static void preencher_teste(ArrayList<Jogador> apostadores){

        Jogador cliente = new Jogador();
        
        cliente.nome = "Erick de Brito";
        cliente.id = 1;
        cliente.tipo = "Jogador";
        cliente.cadastro(1000);
        cliente.transacao(537.5);

        apostadores.add(cliente);

        cliente.nome = "Andre Castri";
        cliente.id = 2;
        cliente.tipo = "Jogador";
        cliente.cadastro(1001);
        cliente.transacao(1343.25);

        apostadores.add(cliente);



    }
}