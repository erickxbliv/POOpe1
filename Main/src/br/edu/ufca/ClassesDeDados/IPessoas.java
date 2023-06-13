package br.edu.ufca.ClassesDeDados;

public interface IPessoas {

    public void setId(int id);
    public int getId();

    public int getFuncao();
    public void setFuncao(int funcao);

    public double getSaldo();
    public void setSaldo(double saldo);

    public void setConta(int conta);
    public int getConta();

    public String getNome();
    public void setNome(String nome);

    public void depositar(double valor);
    public void transacao(double montante);
    public void patrocinar(Jogador recebedor,double montante);

    public boolean tem_suficiente(double aposta);
    public double getScore();
    //private void setScore(double score);
    public void propina(double pacote);
    public int compareTo(Jogador outroJogador);

    public void setTaxaBonus();

    public void cheque();
    
}
