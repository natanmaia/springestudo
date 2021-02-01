package br.com.natanmaia.controllers;

import br.com.natanmaia.data.vo.BookVO;
import br.com.natanmaia.services.BookService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Api(value = "API Livros", description = "API para desenvolvimento das requests referentes a entidade livros", tags = {"Livros"})
@RestController
@RequestMapping("/api/v1/livros")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private PagedResourcesAssembler<BookVO> assembler;

    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public BookVO buscarPorId(@PathVariable("id") Long id) {
        BookVO vo = bookService.buscarPorId(id);
        vo.add(linkTo(methodOn(BookController.class).buscarPorId(id)).withSelfRel());
        return vo;
    }

    @GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    public List<BookVO> buscarTodos() {
        List<BookVO> vos = bookService.buscarTodos();
        vos.stream()
                .forEach(p -> p.add(
                        linkTo(methodOn(BookController.class).buscarPorId(p.getKey())).withSelfRel()
                        )
                );
        return vos;

    }

    @PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"}, consumes = {
            "application/json", "application/xml", "application/x-yaml"})
    public BookVO criar(@RequestBody BookVO bookVO) {
        BookVO vo = bookService.criar(bookVO);
        vo.add(linkTo(methodOn(BookController.class).buscarPorId(vo.getKey())).withSelfRel());
        return vo;

    }

    @PutMapping(produces = {"application/json", "application/xml", "application/x-yaml"}, consumes = {
            "application/json", "application/xml", "application/x-yaml"})
    public BookVO atualizar(@RequestBody BookVO bookVO) {
        BookVO vo = bookService.atualizar(bookVO);
        vo.add(linkTo(methodOn(BookController.class).buscarPorId(vo.getKey())).withSelfRel());
        return vo;

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
        bookService.deletar(id);
        return ResponseEntity.ok().build();

    }

    @GetMapping(value = "/paginate", produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<?> findAllPaginate(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "limit", defaultValue = "10") int limit,
            @RequestParam(value = "direction", defaultValue = "asc") String direction) {

        var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "author"));

        Page<BookVO> vos = bookService.findAllPaginate(pageable);
        vos.stream()
                .forEach(p -> p.add(
                        linkTo(methodOn(BookController.class).buscarPorId(p.getKey())).withSelfRel()
                        )
                );

        PagedResources<?> resources = assembler.toResource(vos);

        return new ResponseEntity<>(resources, HttpStatus.OK);
    }

    @GetMapping(value = "/author/{author}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<?> findBooksByAuthor(
            @PathVariable("author") String author,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "limit", defaultValue = "10") int limit,
            @RequestParam(value = "direction", defaultValue = "asc") String direction) {

        var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "author"));

        Page<BookVO> vos = bookService.findBooksByAuthor(author, pageable);
        vos.stream()
                .forEach(p -> p.add(
                        linkTo(methodOn(PessoaController.class).buscarPorId(p.getKey())).withSelfRel()
                        )
                );

        PagedResources<?> resources = assembler.toResource(vos);

        return new ResponseEntity<>(resources, HttpStatus.OK);
    }
}
