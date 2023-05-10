package ClassesDeRepositorios;
import ClassesDeDados.Jogador;
import ClassesDeDados.Pessoas;     //pra tirar os funcionarios so remover isso e onde der erro troca de pessoas pra jogadores
import ClassesDeDados.Funcionario;
import java.util.ArrayList;

//import java.util.;

public class RepositorioUsuarios {

    private ArrayList<Pessoas> populacao;
    //private ArrayList<Funcionario> trabalhadores;


    public void InicializarMeusUsuarios(){

        this.populacao = new ArrayList<Pessoas>();
        preencher_teste(populacao);

        //return populacao;
    }




    public boolean criar_usuario(String NomeDeUsuario, int conta, String resposta){

        Pessoas novo = new Pessoas();
        novo = BuscarEstaPessoa(NomeDeUsuario);
        if(novo != null){
            System.out.println("\nPoxa, este apelido já está em uso, tente novamente.");
            return true;
        }

        novo = new Pessoas();
        novo.nome = NomeDeUsuario;
        novo.id = this.populacao.size();
        if(resposta.equals("sim")) novo.tipo = "Funcionario";
        else novo.tipo = "Jogador";

        novo.biometria_banco(conta);
        this.populacao.add(novo);
        //novo.data_criacao = ;

        return false;
        
    }



    protected void preencher_teste(ArrayList<Pessoas> populacao){

        Jogador cliente = new Jogador();
        Jogador cliente2 = new Jogador();
        Funcionario staff = new Funcionario();
        
        cliente.nome = "Erick de Brito";
        cliente.id = 1;
        cliente.tipo = "Jogador";
        cliente.biometria_banco(1204);
        //cliente.transacao(537.5);

        populacao.add(cliente);

        cliente2.nome = "Andre Castro";
        cliente2.id = 2;
        cliente2.tipo = "Jogador";
        cliente2.biometria_banco(5632);
        //cliente2.transacao(1343.25);

        populacao.add(cliente2);

        staff.nome = "Paola";
        staff.id = 3;
        staff.tipo = "Funcionario";
        staff.biometria_banco(4567);
        //staff.transacao(1234.4);

        populacao.add(staff);

    }


    public Pessoas BuscarEstaPessoa(String NomeDeUsuario){

        int tam;
        tam = this.populacao.size();

        for(int i = 0; i < tam; i++){
            if(this.populacao.get(i).nome.equals(NomeDeUsuario)) return this.populacao.get(i);
        }
        return null;
    }

}