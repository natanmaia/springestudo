package br.com.natanmaia.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.natanmaia.data.models.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Modifying
    @Query("UPDATE Pessoa p SET p.enabled = false WHERE p.id =:id")
    void disablePerson(@Param("id") Long id);

    @Query("SELECT p FROM Pessoa p WHERE p.nome LIKE LOWER(CONCAT ('%', :fistname, '%'))")
    Page<Pessoa> findPersonByName(@Param("fistname") String fistname, Pageable pageable);

}
