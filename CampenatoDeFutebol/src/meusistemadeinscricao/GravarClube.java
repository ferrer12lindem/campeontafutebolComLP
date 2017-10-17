package meusistemadeinscricao;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GravarClube {
	
	private String nomeArquivo;
	
	public void gravarClubeNoArquivo(String nomeArquivo, Clube clube) throws IOException{
	FileOutputStream fileOut = new FileOutputStream(nomeArquivo);
	ObjectOutputStream out = new ObjectOutputStream(fileOut);
	out.writeObject(clube);
	out.close();
	fileOut.close();
	}
	
	public Clube lerClubeDoArquivo(String  nomeArquivo) throws ClassNotFoundException, IOException{
		FileInputStream fileInput = new FileInputStream(nomeArquivo);
		ObjectInputStream leitura = new ObjectInputStream(fileInput);
		Clube clube = (Clube) leitura.readObject();
		leitura.close();
		fileInput.close();
		return clube;
	}
}
