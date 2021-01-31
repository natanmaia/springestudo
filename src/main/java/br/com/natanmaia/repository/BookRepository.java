package br.com.natanmaia.repository;

import br.com.natanmaia.data.models.Books;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Books, Long> {

    @Query("SELECT b FROM Books b WHERE b.author LIKE LOWER(CONCAT ('%', :author, '%'))")
    Page<Books> findBooksByAuthor(@Param("author") String author, Pageable pageable);
}
