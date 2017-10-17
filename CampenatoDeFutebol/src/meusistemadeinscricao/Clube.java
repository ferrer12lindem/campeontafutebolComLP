package meusistemadeinscricao;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

public class Clube implements Serializable{

	private String nomeClube;
	private String estadio;
	private List<Jogador> jogadores;
	private static final int MAX_JOGADORES = 25;

	public Clube() {
		this(" ", " ");
	}

	public Clube(String nomeClube, String estadio) {
		this.nomeClube = nomeClube;
		this.estadio = estadio;
		this.jogadores = new ArrayList<Jogador>();
	}

	public void cadastrarJogador(Jogador j) throws JogadorJaExisteException, LimiteExcedidoException {
		if (jogadores.contains(j)) {
			throw new JogadorJaExisteException("Jogador já existe!");
		}
		if (jogadores.size() == MAX_JOGADORES) {
				throw new LimiteExcedidoException("Já foi atingido o limite de jogadores!");
		}
		jogadores.add(j);
	}

	public Jogador pesquisaJogador(String nomeJogador) {
		for (Jogador j : this.jogadores) {
			if (j.getNome().equals(nomeJogador)) {
				return j;
			}
		}
		return null;
	}

	public Jogador pesquisaSeJogadorEstaRegistrado(String cpf) {
		for (Jogador j : this.jogadores) {
			if (j.getCpf().equals(cpf)) {
				return j;
			}
		}
		return null;
	}

	public String getNomeClube() {
		return this.nomeClube;
	}

	public String getEstadio() {
		return this.estadio;
	}

	public List<Jogador> getJogador() {
		return this.jogadores;
	}

	public void setNomeClube(String nomeClube) {
		this.nomeClube = nomeClube;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public String toString() {
		return "Nome de clube: " + this.nomeClube + "\nEstádio: " + this.estadio;
	}

}
