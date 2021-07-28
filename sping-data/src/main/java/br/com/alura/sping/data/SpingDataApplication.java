package br.com.alura.sping.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.sping.data.orm.Cargo;
import br.com.alura.sping.data.orm.UnidadeTrabalho;
import br.com.alura.sping.data.repository.CargoRepository;
import br.com.alura.sping.data.service.CrudCargoService;
import br.com.alura.sping.data.service.CrudFuncionarioService;
import br.com.alura.sping.data.service.CrudUnidadeTrabalhoService;
import br.com.alura.sping.data.service.RelatorioFuncionarioDinamico;
import br.com.alura.sping.data.service.RelatoriosService;

@SpringBootApplication
public class SpingDataApplication implements CommandLineRunner{
	
	private final CrudCargoService cargoService;
	private final CrudFuncionarioService funcionarioService;
	private final CrudUnidadeTrabalhoService unidadeTrabalhoService;
	private final RelatoriosService relatoriosService;
	private final RelatorioFuncionarioDinamico relatorioFuncionarioDinamico;
	
	private Boolean system = true;
	
	public SpingDataApplication(CrudCargoService cargoService, 
			CrudFuncionarioService funcionarioService, 
			CrudUnidadeTrabalhoService unidadeTrabalhoService,
			RelatoriosService relatoriosService,
			RelatorioFuncionarioDinamico relatorioFuncionarioDinamico) {
		
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
		this.relatoriosService = relatoriosService;
		this.relatorioFuncionarioDinamico = relatorioFuncionarioDinamico;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpingDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		while(system) {
			System.out.println("Qual ação você deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Unidade de Trabalho");
			System.out.println("3 - Funcionário");
			System.out.println("4 - Relatórios");
			System.out.println("5 - Relatórios de Funcionário Dinâmico");
			
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				cargoService.inicial(scanner);
				break;
				
			case 2:
				unidadeTrabalhoService.inicial(scanner);
				break;
				
			case 3:
				funcionarioService.inicial(scanner);
				break;
				
			case 4:
				relatoriosService.inicial(scanner);
				break;
				
			case 5:
				relatorioFuncionarioDinamico.inicial(scanner);
				break;

			default:
				system = false;
				break;
			}
		}
		
	}

}
