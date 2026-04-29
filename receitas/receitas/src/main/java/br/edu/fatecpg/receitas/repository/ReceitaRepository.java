package br.edu.fatecpg.receitas.repository;

import br.edu.fatecpg.receitas.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    @Query("SELECT r FROM Receita r WHERE r.emPromocao = true")
    List<Receita> buscarEmPromocao();
}