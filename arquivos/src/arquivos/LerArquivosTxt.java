package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivosTxt {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Lendo as linhas do arquivo de TXT
		
		FileInputStream entradaArquivo  = 
				new FileInputStream(new File("D:\\PROJETOS_DEV_2021\\JDEVTREINAMENTO\\Leitura-e-escrita-TXT-e-Excel-com-Apache-POI-em-Java\\arquivos\\src\\arquivos\\arquivo.txt"));

		Scanner lerArquivo = new Scanner(entradaArquivo, "UTF-8");
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		while (lerArquivo.hasNext()) {
			String linha = lerArquivo.nextLine();
			
			if(linha != null && !linha.isEmpty()) {
				String[] dados = linha.split("\\;");
				
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(dados[0]);
				pessoa.setEmail(dados[1]);
				pessoa.setIdade(Integer.parseInt(dados[2]));
				
				pessoas.add(pessoa);
			}
			
		}
		
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		}
	}

}
