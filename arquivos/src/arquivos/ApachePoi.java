package arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi {

	public static void main(String[] args) throws IOException {
		// TODO Criando Planilha Excel XLS com Apache POI
		
		File file = new File("D:\\PROJETOS_DEV_2021\\JDEVTREINAMENTO\\Leitura-e-escrita-TXT-e-Excel-com-Apache-POI-em-Java\\arquivos\\src\\arquivos\\arquivo_excel.xls");
 
		if(!file.exists()) {
			file.createNewFile();
		}
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setEmail("pessoa1@gmail.com");
		pessoa1.setIdade(50);
		pessoa1.setNome("Alex Egidio");
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setEmail("pessoa2@gmail.com");
		pessoa2.setIdade(25);
		pessoa2.setNome("Jose Queiroz");
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setEmail("pessoa3@gmail.com");
		pessoa3.setIdade(40);
		pessoa3.setNome("Lana Queiroz");
		
		//Lista que pode vir do banco de dados ou qualquer fonte de dados
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); //Usado para escrever na panhilha.
		HSSFSheet linhasPessoa = hssfWorkbook.createSheet("Planilha de pessoa JDEV Treinamento");//Cria a planinha
		
		int numeroLinha = 0;
		for (Pessoa p : pessoas) {
			Row linha = linhasPessoa.createRow(numeroLinha++); //Criando a linha na planilha
			
			int celula = 0;
			
			Cell celNome = linha.createCell(celula++);//Celula 1º
			celNome.setCellValue(p.getNome());
			
			Cell celEmail = linha.createCell(celula++);//Celula 2º
			celEmail.setCellValue(p.getEmail());
			
			Cell celIdade = linha.createCell(celula++);//Celula 3º
			celIdade.setCellValue(p.getIdade());
		}//Termino da montagem da planilha
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida);//Escreve planilha em arquivo
		saida.flush();
		saida.close();
		
		System.out.println("Planilha foi criada");
	}

}
