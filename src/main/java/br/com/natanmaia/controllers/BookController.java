package br.com.natanmaia.controllers;

import br.com.natanmaia.data.vo.BookVO;
import br.com.natanmaia.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v1/livros")
public class BookController {

    @Autowired
    private BookService bookService;

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
}
