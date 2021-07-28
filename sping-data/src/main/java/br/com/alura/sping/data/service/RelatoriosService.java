package br.com.alura.sping.data.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import br.com.alura.sping.data.orm.Cargo;
import br.com.alura.sping.data.orm.Funcionario;
import br.com.alura.sping.data.orm.FuncionarioProjecao;
import br.com.alura.sping.data.repository.CargoRepository;
import br.com.alura.sping.data.repository.FuncionarioRepository;

@Service
public class RelatoriosService {
	private Boolean system = true;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private final FuncionarioRepository funcionarioRepository; 
	
	public RelatoriosService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public void inicial(Scanner scanner) {
		while(system) {
			System.out.println("Qual relatório você deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Busca Funcionário por nome");
			System.out.println("2 - Busca Funcionário por nome, data de contratação e salário maior");
			System.out.println("3 - Busca Funcionário por data de contratação maior");
			System.out.println("4 - Busca Funcionário e salários");
			
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				buscaFuncionarioNome(scanner);
				break;
				
			case 2:
				buscaFuncionarioNomeSalarioMaiorData(scanner);
				break;
				
			case 3:
				buscaDataContratacaocaoMaior(scanner);
				break;
				
			case 4:
				buscaFuncionarioSalario();
				break;

			default:
				system = false;
				break;
			}
		}
	}
	
	private void buscaFuncionarioNome(Scanner scanner) {
		System.out.println("Digite o nome a ser pesquisado:" );
		String nome = scanner.next();
		
		List<Funcionario> list = funcionarioRepository.findByNome(nome);
		
		list.forEach(System.out::println);
	}
	
	private void buscaFuncionarioNomeSalarioMaiorData(Scanner scanner) {
		System.out.println("Digite o nome a ser pesquisado:" );
		String nome = scanner.next();
		
		System.out.println("Qual a Data de Contratação:" );
		String data = scanner.next();
		LocalDate localDate = LocalDate.parse(data, formatter);
		
		System.out.println("Qual o salário:" );
		Double salario = scanner.nextDouble();
		
		List<Funcionario> list = funcionarioRepository.findNomeSalarioMaiorDataContratacao(nome, salario, localDate);
		
		list.forEach(System.out::println);
	}
	
	private void buscaDataContratacaocaoMaior(Scanner scanner) {
		System.out.println("Digite a Data de Contratação a ser pesquisada:" );
		String data = scanner.next();
		LocalDate localDate = LocalDate.parse(data, formatter);
		
		List<Funcionario> list = funcionarioRepository.findDataContratacaoMaior(localDate);
		
		list.forEach(System.out::println);
	}

	private void buscaFuncionarioSalario() {
		List<FuncionarioProjecao> list = funcionarioRepository.findFuncionarioSalario();
		
		list.forEach(f -> System.out.println("Funcionário - id: " + f.getId() + " - Nome: " + f.getNome() + " - Salário: " + f.getSalario()));
	}
}
