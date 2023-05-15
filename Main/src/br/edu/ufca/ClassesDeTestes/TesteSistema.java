//bug no login, contas criadas e nomes com espaco       //nao deu mais esse bug.. mas nao corrigi
//nao posso fechar o scanner

//polimorfismo, vip subclasse
//deletar conta, ver ranking, ver seu ranking

package br.edu.ufca.ClassesDeTestes;
import br.edu.ufca.ClassesDeRepositorios.RepositorioJogador;

import java.util.Scanner;
import java.util.ArrayList;

public class TesteSistema{         //classe de teste (Main)
    public static void main(String[] args){

        //int data de hj
        RepositorioJogador publico = new RepositorioJogador(); //intanciando um repositório jogadores
        publico.InicializarMeusJogadores();
        TesteJogo Arcade = new TesteJogo();
        Arcade.inicializar();
        //RepositorioFuncionario carteiras = new RepositorioFuncionario();
        //carteiras.InicializarMeusFuncionarios();

        
        Scanner myObj = new Scanner(System.in);
        boolean sucesso = false;            //condicao de funcionamento da recepcao
        
        String NomeDeUsuario = null;        //preenchimento de dados sobre a conta
        int funcao = -1;
        int conta;
        //String resposta;

        while(!sucesso){

            System.out.println("Olá, parece que você não se identificou! O que você deseja? \n1- login \n2- cadastrar novo \n3 - fechar");
            String escolha = myObj.nextLine();
            
            if(escolha.equals("1")){

                System.out.print("\nDigite seu nome: ");
                NomeDeUsuario = myObj.nextLine();
                funcao = ContaExisteQualFuncao(NomeDeUsuario,publico);
                if(funcao != -1) sucesso = true;

            }else if(escolha.equals("2")){

                System.out.print("\nPara criar sua conta, e necessario possuir uma conta bancaria. Informe seus 6 digitos a seguir: ");
                do{
                    conta =  myObj.nextInt();
                }while(conta < 100000 || conta > 999999);
                String lixo = myObj.nextLine();
                //System.out.print("Certo! Voce veio para a entrevista de emprego? Caso tenha, digite 'sim': ");
                //resposta = myObj.nextLine();

                System.out.print("Vamos criar sua conta! Qual vai ser o seu apelido aqui no Cassino? "); 
                do{ NomeDeUsuario = myObj.nextLine();
                }while(ContaExisteQualFuncao(NomeDeUsuario,publico) != -1);

                //if(resposta.equals("sim")) carteiras.criar_Funcionario(NomeDeUsuario,conta); else 
                publico.criar_Jogador(NomeDeUsuario,conta);
                
                //sucesso = true;           //n da pra encerrar tem q fazer o login
            }else if(escolha.equals("3")) return;

            System.out.print("\n");
        }


        System.out.println("Bem vindo!");
        //myObj.close();

        

        

        //a partir daqui acontece a bifurcacao que vai entrrar
        boolean sair = false;

        while(!sair){       //pra caso uma pessoa troque de funcao
            //System.out.println("TESTEEEEEEEEEEEE");
            funcao = ContaExisteQualFuncao(NomeDeUsuario,publico);

            if(funcao == 1) sair = ElevadorClientes(NomeDeUsuario,publico,Arcade);
            //else if(funcao == 2) sair = ElevadorFuncionarios(NomeDeUsuario,carteiras);
            else if(funcao == 3) sair = ElevadorDeLuxo(NomeDeUsuario);
            else return;
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


    //private static int ContaExisteQualFuncao(String NomeDeUsuario, RepositorioJogador publico, RepositorioFuncionario carteiras){
    private static int ContaExisteQualFuncao(String NomeDeUsuario, RepositorioJogador publico){

        int funcao = -1;
        funcao = publico.JogadorExiste(NomeDeUsuario);
        if(funcao == -1){
            //funcao = carteiras.FuncionarioExiste(NomeDeUsuario);
            if(funcao == -1){
                //se tiver outro repositorio pra olhar..
            }    
        }
        return funcao;      //se a conta nao existe retorna -1, se existe retorna seu tipo
    }






    private static boolean ElevadorClientes(String NomeDeUsuario, RepositorioJogador publico, TesteJogo Arcade){

        boolean sair = false;
        String escolha;
        Scanner myObj = new Scanner(System.in);

        while(!sair){

            System.out.println("\nO que voce deseja " + NomeDeUsuario + "? \n1 - Jogar \n2 - configuracoes \n3 - fechar");
            escolha = myObj.nextLine();

            if(escolha.equals("1")){
                Jogar(NomeDeUsuario,publico,Arcade);


            }else if(escolha.equals("2")){
                sair = config_conta(NomeDeUsuario,publico);
                if(sair) return false; 
                //se a pessoa pedir pra voltar de la, sair recebe falso aqui, se vir verdade, dai e pra retornar daq sem sair do loop main
                

            }else if(escolha.equals("3")) sair = true;
            


        }

        //myObj.close();
        return true;
    }


    /* 

    private static boolean ElevadorFuncionarios(String NomeDeUsuario, RepositorioFuncionario carteiras){





        return true;
    }

    */

    private static boolean ElevadorDeLuxo(String NomeDeUsuario){

        return true;
    }

    private static void Jogar(String NomeDeUsuario, RepositorioJogador publico, TesteJogo Arcade){

        Scanner myObj = new Scanner(System.in);
        TesteJogo arcade = new TesteJogo();

        int escolha;
        boolean sucesso = false;
        int total = 0;
        double aposta;

        while(!sucesso){

            System.out.println("\nDe qual jogo voce deseja participar?");
            total = Arcade.mostrar_biblioteca();
            System.out.println((total+1) + " - Voltar\n");
            escolha = myObj.nextInt();

            if(escolha == (total+1)) return;
            else{
                
                do{
                    System.out.print("\nQuanto vc deseja apostar em Reais? Utilize ',' para centavos, ok? R$ ");
                    aposta = myObj.nextDouble();
                }while(!publico.PodeArcar(NomeDeUsuario,aposta));
                publico.IniciarJogo(NomeDeUsuario,Arcade,escolha,aposta);
                sucesso = true;
            }
        }

        //myObj.close();
        return;
    }


    private static boolean config_conta(String NomeDeUsuario, RepositorioJogador publico){

        //se a pessoa mudar de classe, retorna verdade, se simplesmente voltar, retorna falso pra nao sair do loop de elevador
        int escolha;
        Scanner myObj = new Scanner(System.in);
        boolean sempre = true;
        double saldo_atual;

        while(sempre){

            System.out.println("\nO que vc deseja fazer? \n1 - consultar saldo \n2 - matricula vip \n3 - tornar-se patrocinador");
            //System.out.println("4 - entrevista de emprego");
            System.out.println("4 - apagar conta \n5 - seu ranking \n6 - voltar");      //ver top 5
            escolha = myObj.nextInt();

            if(escolha == 1){

                saldo_atual = publico.ConsultarSaldo(NomeDeUsuario);
                System.out.println("Seu saldo atual e: R$ " + saldo_atual);

            }else if(escolha == 2){

                //return true;      //se vip for uma classe diferente.. precisa dessa linha
            }else if(escolha == 3){

                return true;
            }else if(escolha == 4){

                return true;
            }else if(escolha == 5){

                
            }else if(escolha == 6) return false;

        }

        //myObj.close();

        return false;
    }

}