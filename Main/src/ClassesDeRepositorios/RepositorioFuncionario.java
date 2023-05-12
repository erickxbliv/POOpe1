/* 

package ClassesDeRepositorios;
import ClassesDeDados.Funcionario;
import java.util.ArrayList;

//import java.util.;

public class RepositorioFuncionario {

    private ArrayList<Funcionario> equipe;
    //private ArrayList<Funcionario> trabalhadores;


    public void InicializarMeusFuncionarios(){

        this.equipe = new ArrayList<Funcionario>();
        preencher_teste(equipe);

        //return populacao;
    }




    public boolean criar_Funcionario(String NomeDeUsuario, int conta){

        Funcionario novo = new Funcionario();
        novo = BuscarEsteFuncionario(NomeDeUsuario);
        if(novo != null){
            System.out.println("\nPoxa, este apelido já está em uso, tente novamente.");
            return true;
        }

        novo = new Funcionario();
        novo.nome = NomeDeUsuario;
        novo.id = this.equipe.size();
        novo.tipo = "Jogador";

        novo.setConta(conta);
        this.equipe.add(novo);
        //novo.data_criacao = ;

        return false;
        
    }



    protected void preencher_teste(ArrayList<Funcionario> populacao){

        Funcionario staff = new Funcionario();
        Funcionario staff2 = new Funcionario();
        Funcionario staff3 = new Funcionario();
        
        staff.nome = "Paola";
        staff.id = 1;
        //cliente.tipo = "Jogador";
        staff.funcao = 2;
        staff.setConta(2675);
        //cliente.transacao(537.5);

        populacao.add(staff);

        staff2.nome = "Pedro";
        staff2.id = 2;
        //cliente.tipo = "Jogador";
        staff2.funcao = 2;
        staff2.setConta(7462);
        //cliente.transacao(537.5);

        populacao.add(staff2);

        staff3.nome = "Lucas";
        staff3.id = 3;
        //cliente.tipo = "Jogador";
        staff3.funcao = 2;
        staff3.setConta(5793);
        //cliente.transacao(537.5);

        populacao.add(staff3);

    }


    public Funcionario BuscarEsteFuncionario(String NomeDeUsuario){

        int tam;
        tam = this.equipe.size();

        for(int i = 0; i < tam; i++){
            if(this.equipe.get(i).nome.equals(NomeDeUsuario)) return this.equipe.get(i);
        }
        return null;
    }



    public int FuncionarioExiste(String NomeDeUsuario){

        int tam;
        tam = this.equipe.size();
        for(int i = 0; i < tam; i++){
            if(this.equipe.get(i).nome.equals(NomeDeUsuario)) return this.equipe.get(i).funcao;
        }
        return -1;
    }

}

*/