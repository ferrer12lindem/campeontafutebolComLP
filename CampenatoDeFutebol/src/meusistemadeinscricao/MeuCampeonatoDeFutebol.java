package meusistemadeinscricao;

import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

public class MeuCampeonatoDeFutebol {

	public static void main(String args[]) {
		JOptionPane.showMessageDialog(null, "MEU CAMPEONATO DE FUTEBOL!");

			CriandoUmaCompeticaoList competicao = new CriandoUmaCompeticaoList();
			JOptionPane.showMessageDialog(null, "Vamos cadastrar alguns clubes...");
			GravarClube gc = new GravarClube();
			String nomeClube = JOptionPane.showInputDialog("Informe um clube"); 
			String estadioDeClube = JOptionPane.showInputDialog("Informe o estádio de futebol do "+nomeClube);
			Clube clube = new Clube(nomeClube, estadioDeClube);
				try {
					competicao.cadastraClubes(clube);
					JOptionPane.showMessageDialog(null, "Cadastro foi um sucesso!");
				} catch (ClubeJaCadastradoException e3) {
					e3.getMessage();
				}
				try {
					JOptionPane.showMessageDialog(null,"Gravando os clubes em um arquivo...");
					gc.gravarClubeNoArquivo("arquivo", clube);
				} catch (IOException e2) {
					e2.printStackTrace();
				}		
				try {
					JOptionPane.showMessageDialog(null,"Agora, lendo o clube no arquivo...");
					Clube c2 = gc.lerClubeDoArquivo("arquivo");
					JOptionPane.showMessageDialog(null, c2);
				} catch (ClassNotFoundException | IOException e2) {
					e2.printStackTrace();
				}		
				try {
					JOptionPane.showMessageDialog(null, "Vamos cadastrar jogadores nos clubes...");
					String nomeJogador = JOptionPane.showInputDialog("Informe o nome do jogador");
					String idadeJogador = JOptionPane.showInputDialog("Informe a idade de "+nomeJogador); 
					String posicaoJogador = JOptionPane.showInputDialog("Informe a posiçaõ de "+nomeJogador); 
					String cpfJogador = JOptionPane.showInputDialog("Informe o cpf de "+nomeJogador); 
					
					clube.cadastrarJogador(new Jogador(nomeJogador, idadeJogador, posicaoJogador, cpfJogador));
					JOptionPane.showMessageDialog(null, "Cadastro foi sucesso!");
				} catch (JogadorJaExisteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (LimiteExcedidoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					e.printStackTrace();
				}			
				JOptionPane.showMessageDialog(null, "Pesquise um jogador...");
				String nome = JOptionPane.showInputDialog("Informe o nome do jogador");
				Jogador jogadorClub;
				try {
					jogadorClub = competicao.pesquisaJogador(nome);
						JOptionPane.showMessageDialog(null, "O jogador já está cadastrado! " + jogadorClub.toString());
				} catch (JogadorNaoExisteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Pesquise se tem algum estádio de futebol disponível...");
				String estadio = JOptionPane.showInputDialog("Informe o nome do estádio");
				List<Clube> lista = competicao.pesquisaEstadioDisponivel(estadio);
				if (lista.size() != 0) {
					for (Clube c : lista) {
						JOptionPane.showMessageDialog(null, "Estádio indisponível: " + c.toString());
					}
				} else {
					JOptionPane.showMessageDialog(null, "O estádio está disponível! ");
				}
				JOptionPane.showMessageDialog(null,"Vamos pesquisar se seu clube foi cadastrado?" );
				String clubeEquipe = JOptionPane.showInputDialog("Informe o nome do clube");
				Clube lequipe;
				try {
					lequipe = competicao.pesquisaSeExisteClube(clubeEquipe);
					JOptionPane.showMessageDialog(null, "Clube já cadastrado");
				} catch (ClubeNaoCadastradoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				JOptionPane.showMessageDialog(null, "Agora, pesquise se um jogador foi resgistrado!...");
				String cpf = JOptionPane.showInputDialog("Informe o cpf");
				Jogador list = competicao.pesquisaSeJogadorEstaRegistrado(cpf);
				if (list != null) {
					JOptionPane.showMessageDialog(null, "Jogador está registrado: ");
				} else {
					JOptionPane.showMessageDialog(null, "Jogador não está registrado: ");
				}
	}
}
