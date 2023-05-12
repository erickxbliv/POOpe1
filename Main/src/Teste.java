import ClassesDeDados.Jogador;
import ClassesDeDados.Funcionario;
//import ClassesDeDados.Pessoas;
import ClassesDeRepositorios.RepositorioJogador;
import ClassesDeRepositorios.RepositorioFuncionario;
//import ClassesDeRepositorios.RepositorioUsuarios;

import java.util.Scanner;
import java.util.ArrayList;

public class Teste{         //classe de teste (Main)
    public static void main(String[] args){

        //ArrayList<Jogador> apostadores = new ArrayList<Jogador>();
        //ArrayList<Funcionario> trabalhadores = new ArrayList<Funcionario>();
        //apostadores = RepositorioUsuarios.InicializarMeusUsuarios();

        //int data de hj
        RepositorioJogador publico = new RepositorioJogador();
        publico.InicializarMeusJogadores();
        RepositorioFuncionario carteiras = new RepositorioFuncionario();
        carteiras.InicializarMeusFuncionarios();

        
        Scanner myObj = new Scanner(System.in);
        boolean sucesso = false;            //condicao de funcionamento da recepcao
        
        String NomeDeUsuario = null;        //preenchimento de dados sobre a conta
        int funcao = -1;
        int conta;
        String resposta;

        while(!sucesso){

            System.out.println("Olá, parece que você não se identificou! O que você deseja? \n1- login \n2- cadastrar novo \n3 - fechar");
            String escolha = myObj.nextLine();
            
            if(escolha.equals("1")){

                System.out.print("\nDigite seu nome: ");
                NomeDeUsuario = myObj.nextLine();
                funcao = ContaExisteQualFuncao(NomeDeUsuario,publico,carteiras);
                if(funcao != -1) sucesso = true;

            }else if(escolha.equals("2")){

                System.out.print("\nPara criar sua conta, e necessario possuir uma conta bancaria. Informe a seguir: ");
                conta =  myObj.nextInt();
                String lixo = myObj.nextLine();
                System.out.print("Certo! Voce veio para a entrevista de emprego? Caso tenha, digite 'sim': ");
                resposta = myObj.nextLine();

                System.out.print("Vamos criar sua conta! Qual vai ser o seu apelido aqui no Cassino? "); 
                do{ NomeDeUsuario = myObj.nextLine();
                }while(ContaExisteQualFuncao(NomeDeUsuario,publico,carteiras) == -1);

                if(resposta.equals("sim")) carteiras.criar_Funcionario(NomeDeUsuario,conta);
                else publico.criar_Jogador(NomeDeUsuario,conta);
                
                //sucesso = true;           //n da pra encerrar tem q fazer o login
            }else if(escolha.equals("3")) return;

            System.out.print("\n");
        }


        System.out.println("Bem vindo!");
        myObj.close();

        

        

        //a partir daqui acontece a bifurcacao que vai entrrar
        boolean sair = false;

        while(!sair){       //pra caso uma pessoa troque de funcao

            funcao = ContaExisteQualFuncao(NomeDeUsuario,publico,carteiras);

            if(funcao == 1) sair = ElevadorClientes(NomeDeUsuario,publico);
            else if(funcao == 2) sair = ElevadorFuncionarios(NomeDeUsuario,carteiras);
            else if(funcao == 3) sair = ElevadorDeLuxo(NomeDeUsuario);

        }
        

        
        

        //receber dados de um usuario totalmente novo
        //dependendo do seu tipo salvar ele em um local diferente (grupos de dados)
        //dependendo da sua funcao mostrar opcoes diferentes de tarefas a executar
        //todas as funcoes sao automaticas e de apenas impressao da tela, retornando pras opcoes ou sair da conta
        //todas as funcoes lidam com indices aleatorios dos grupos de dados para serem os outros "humanos" das interacoes
        //esses outros humanos tambem sofrem as consequencias que foram mostradas para o usuario
        //salvar os dados no final para guardar o estado atual de cada execucao
        
        return;
    }


    private static int ContaExisteQualFuncao(String NomeDeUsuario, RepositorioJogador publico, RepositorioFuncionario carteiras){

        int funcao = -1;
        funcao = publico.JogadorExiste(NomeDeUsuario);
        if(funcao == -1){
            funcao = carteiras.FuncionarioExiste(NomeDeUsuario);
            if(funcao == -1){
                //se tiver outro repositorio pra olhar..
            }    
        }
        return funcao;      //se a conta nao existe retorna -1, se existe retorna seu tipo
    }






    private static boolean ElevadorClientes(String NomeDeUsuario, RepositorioJogador publico){

        Jogador usuario = new Jogador();
        usuario = publico.BuscarEsteJogador(NomeDeUsuario);

        boolean sair = false;
        String escolha;
        Scanner myObj = new Scanner(System.in);

        while(!sair){

            System.out.println("O que voce deseja " + usuario.getNome() + "? \n1 - Jogar \n2 - configuracoes \n3 - fechar \n");
            escolha = myObj.nextLine();

            if(escolha.equals("1")){
                Jogar();


            }else if(escolha.equals("2")){
                sair = config_conta();
                if(sair) return false; 
                //se a pessoa pedir pra voltar de la, sair recebe falso aqui, se vir verdade, dai e pra retornar daq sem sair do loop main
                

            }else if(escolha.equals("3")) sair = true;
            


        }

        myObj.close();
        return true;
    }


    private static boolean ElevadorFuncionarios(String NomeDeUsuario, RepositorioFuncionario carteiras){





        return true;
    }


    private static boolean ElevadorDeLuxo(String NomeDeUsuario){





        return true;
    }

    private static void Jogar(){




        return;
    }


    private static boolean config_conta(){

        //se a pessoa mudar de classe, retorna verdade, se simplesmente voltar, retorna falso pra nao sair do loop de elevador
        return false;
    }




    
}