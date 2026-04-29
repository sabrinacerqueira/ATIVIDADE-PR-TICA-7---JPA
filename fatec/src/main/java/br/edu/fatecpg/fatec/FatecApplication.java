package br.edu.fatecpg.fatec;

import br.edu.fatecpg.fatec.model.Aluno;
import br.edu.fatecpg.fatec.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class FatecApplication implements CommandLineRunner {
	@Autowired
	private AlunoRepository rep;
	public static void main(String[] args) {
		SpringApplication.run(FatecApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Aluno a1 = new Aluno("Ale","123.456.789-00");
		Aluno a2 = new Aluno("Maria","321.456.789-00");
		Aluno a3 = new Aluno("João","222.456.789-00");
		rep.save(a1);
		rep.save(a2);
		rep.save(a3);

		Aluno a4 = new Aluno("Sabrina","111.456.789-00");
		Aluno a5 = new Aluno("Davi","333.456.789-00");
		Aluno a6 = new Aluno("Manito","444.456.789-00");
		rep.save(a4);
		rep.save(a5);
		rep.save(a6);
		*/

		List<Aluno> alunos = rep.findAll();
		alunos.forEach(System.out::println);

		for (Aluno a : alunos) {
			System.out.println("Nome: "+ a.getNome() + " - Cpf: " + a.getCpf());
		}

		List<Aluno> porNome = rep.buscarPorNome("Davi");
		porNome.forEach(a -> System.out.println("Nome: " + a.getNome() + " - CPF: " + a.getCpf()));

		Optional<Aluno> porId = rep.findById(1L);
		porId.ifPresent(a -> System.out.println("Nome: " + a.getNome() + " - CPF: " + a.getCpf()));

		rep.deleteById(2L);
		System.out.println("Aluno com ID 2 removido!");


	}
}
