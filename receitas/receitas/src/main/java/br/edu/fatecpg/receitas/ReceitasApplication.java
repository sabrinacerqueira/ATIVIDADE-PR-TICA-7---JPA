package br.edu.fatecpg.receitas;

import br.edu.fatecpg.receitas.model.Receita;
import br.edu.fatecpg.receitas.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ReceitasApplication implements CommandLineRunner {

	@Autowired
	private ReceitaRepository rep;

	public static void main(String[] args) {
		SpringApplication.run(ReceitasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		rep.save(new Receita("Bolo de Chocolate", "Sobremesa", 25.90, true));
		rep.save(new Receita("Frango Grelhado", "Prato Principal", 38.50, false));
		rep.save(new Receita("Salada Caesar", "Entrada", 18.00, true));
		rep.save(new Receita("Lasanha", "Prato Principal", 45.00, false));
		rep.save(new Receita("Pudim", "Sobremesa", 15.00, true));

		System.out.println(" Todas as receitas");
		rep.findAll().forEach(r ->
				System.out.println(r.getNome() + " - R$" + r.getPreco() + " - Promoção: " + r.getEmPromocao())
		);

		System.out.println("\nReceitas em promoção");
		rep.buscarEmPromocao().forEach(r ->
				System.out.println(r.getNome() + " - R$" + r.getPreco())
		);
	}
}