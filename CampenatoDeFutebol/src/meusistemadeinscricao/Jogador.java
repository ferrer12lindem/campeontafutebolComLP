package meusistemadeinscricao;
import java.io.Serializable;

public class Jogador implements Serializable {
	
	private String nome;
	private String idade;
	private String posicao;
	private String cpf;
	
	public Jogador(){
		this(" "," "," ", " ");
	}
	
	public Jogador(String nome, String idade, String posicao, String cpf){
		this.nome = nome;
		this.idade = idade;
		this.posicao = posicao;
		this.cpf = cpf;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getIdade(){
		return this.idade;
	}
	
	public String getPosicao(){
		return this.posicao;
	}
	
	public String getCpf(){
		return this.cpf;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void setIdade(String idade){
		this.idade = idade;
	}
	
	public void setPosicao(String posicao){
		this.posicao = posicao;
	}
	
	public void setCpf(String cpf){
		this.cpf = cpf;
	}
	
	public String toString(){
		return "Nome: "+this.nome+"\nIdade: "+this.idade+"\nPosição: "+this.posicao+"\nCPF: "+this.cpf;
	}
}
