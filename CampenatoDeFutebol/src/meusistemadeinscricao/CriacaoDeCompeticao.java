package meusistemadeinscricao;
import java.util.List;

public interface CriacaoDeCompeticao {
	public void cadastraClubes(Clube clube) throws ClubeJaCadastradoException;
	public int getMaxDeClubes();
	public Jogador pesquisaJogador(String nome) throws JogadorNaoExisteException;
	public Clube pesquisaSeExisteClube(String clube) throws ClubeJaCadastradoException, ClubeNaoCadastradoException;
	public Jogador pesquisaSeJogadorEstaRegistrado(String cartao);
	public List<Clube> pesquisaEstadioDisponivel(String estadio);
	public Clube pesquisaSeCLubeTemEstadio(String clube);

}
