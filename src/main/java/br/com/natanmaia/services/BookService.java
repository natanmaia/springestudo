package br.com.natanmaia.services;

import br.com.natanmaia.converter.DozerConverter;
import br.com.natanmaia.data.models.Books;
import br.com.natanmaia.data.models.Pessoa;
import br.com.natanmaia.data.vo.BookVO;
import br.com.natanmaia.data.vo.PessoaVO;
import br.com.natanmaia.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository repository;

    public BookVO criar(BookVO book) {
        var entity = DozerConverter.parseObject(book, Books.class);
        var vo = DozerConverter.parseObject(repository.save(entity), BookVO.class);
        return vo;
    }

    public BookVO atualizar(BookVO book) {
        var entity = repository.findById(book.getKey())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Sem resultados para esse ID!"));

        entity.setTitle(book.getTitle());
        entity.setPrice(book.getPrice());
        entity.setLaunch_date(book.getLaunch_date());
        entity.setAuthor(book.getAuthor());

        var vo = DozerConverter.parseObject(repository.save(entity), BookVO.class);
        return vo;
    }

    public void deletar(Long id) {
        Books entity = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Sem resultados para esse ID!"));
        repository.delete(entity);
    }

    public BookVO buscarPorId(Long id) {
        var entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Sem resultados para esse ID!"));
        return DozerConverter.parseObject(repository.save(entity), BookVO.class);
    }

    public List<BookVO> buscarTodos() {
        return DozerConverter.parseListObject(repository.findAll(), BookVO.class);
    }

    public Page<BookVO> findAllPaginate(Pageable pageable) {
        var page = repository.findAll(pageable);

        return page.map(this::convertToBookVO);
    }

    public Page<BookVO> findBooksByAuthor(String author, Pageable pageable) {
        var page = repository.findBooksByAuthor(author, pageable);

        return page.map(this::convertToBookVO);
    }

    private BookVO convertToBookVO(Books book) {
        return DozerConverter.parseObject(repository.save(book), BookVO.class);
    }
}
