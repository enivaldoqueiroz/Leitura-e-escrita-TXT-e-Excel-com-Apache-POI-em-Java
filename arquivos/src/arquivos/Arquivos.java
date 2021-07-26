package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {

	public static void main(String[] args) throws IOException {
		// TODO Modulo 16 - Escrevendo em arquivo de TXT
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setEmail("pessoa1@gmail.com");
		pessoa1.setIdade(50);
		pessoa1.setNome("Alex Egidio");
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setEmail("pessoa2@gmail.com");
		pessoa2.setIdade(50);
		pessoa2.setNome("Jose Queiroz");
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setEmail("pessoa3@gmail.com");
		pessoa3.setIdade(50);
		pessoa3.setNome("Lana Queiroz");
		
		//Lista que pode vir do banco de dados ou qualquer fonte de dados
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		
		File arquivo = new File("D:\\PROJETOS_DEV_2021\\JDEVTREINAMENTO\\Leitura-e-escrita-TXT-e-Excel-com-Apache-POI-em-Java\\arquivos\\src\\arquivos\\arquivo.txt");

		if (!arquivo.exists()) {
			
				arquivo.createNewFile();
						
		}
		
		FileWriter escrever_no_arquivo = new FileWriter(arquivo);
		
//		escrever_no_arquivo.write("Texto no arquivo");
//		escrever_no_arquivo.write("\n");
//		escrever_no_arquivo.write("Segunda linha no arquivo");
		
//		for (int i = 1; i<= 10; i++) {
//			escrever_no_arquivo.write("Texto da minha linha " + i + " \n");
//		}
		
		for (Pessoa p : pessoas) {
			escrever_no_arquivo.write(p.getNome() + ";" + p.getEmail() + ";" + p.getIdade() + "\n");
		}
		
		escrever_no_arquivo.flush();
		escrever_no_arquivo.close();
	}

}
