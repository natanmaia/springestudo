package br.com.natanmaia.repository;

import br.com.natanmaia.data.models.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Books, Long> {
}
