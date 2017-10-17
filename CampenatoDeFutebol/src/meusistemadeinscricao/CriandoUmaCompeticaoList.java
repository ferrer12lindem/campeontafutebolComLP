package meusistemadeinscricao;

import java.util.List;
import java.util.ArrayList;

public class CriandoUmaCompeticaoList implements CriacaoDeCompeticao {

	private List<Clube> clubes;
	private int maxDeClubes;

	public CriandoUmaCompeticaoList() {
		this.maxDeClubes = 32;
		this.clubes = new ArrayList<Clube>();
	}

	@Override
	public void cadastraClubes(Clube clube) throws ClubeJaCadastradoException {
		for(Clube b: this.clubes){
			if(b.getNomeClube().equals(clube.getNomeClube())){
				throw new ClubeJaCadastradoException("O clube já está cadastrado! "+clube.getNomeClube());
			}
		}
		this.clubes.add(clube);
	}
	
	@Override
	public int getMaxDeClubes() {
		return this.maxDeClubes;
	}

	@Override
	public Jogador pesquisaJogador(String nome) throws JogadorNaoExisteException {
		for (Clube c : this.clubes) {
			Jogador jogador = c.pesquisaJogador(nome);
			if (jogador != null) {
				return jogador;
			}
		}
		throw new JogadorNaoExisteException("O jogador não existe");
	}

	@Override
	public Clube pesquisaSeExisteClube(String clube) throws ClubeNaoCadastradoException{
		for (Clube c : this.clubes) {
			if (c.getNomeClube().equals(clube)) {
				return c;
			}
		}
		throw new ClubeNaoCadastradoException("O clube não está cadastrado!");
	}

	public Jogador pesquisaSeJogadorEstaRegistrado(String cpf) {
		for (Clube c : this.clubes) {
			Jogador jogador = c.pesquisaSeJogadorEstaRegistrado(cpf);
			if (jogador != null) {
				return jogador;
			}
		}
		return null;
	}

	@Override
	public List<Clube> pesquisaEstadioDisponivel(String estadio) {
		List<Clube> lista = new ArrayList<Clube>();
		for (Clube c : this.clubes) {
			if (c.getEstadio().equals(estadio)) {
				lista.add(c);
			}
		}
		return lista;
	}

	@Override
	public Clube pesquisaSeCLubeTemEstadio(String estadio) {
		for (Clube c : this.clubes) {
			if (c.getEstadio().equals(estadio)) {
				return c;
			}
		}
		return null;
	}

}
