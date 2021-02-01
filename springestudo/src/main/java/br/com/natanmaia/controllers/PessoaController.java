package br.com.natanmaia.controllers;

//HATEOAS

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

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

import br.com.natanmaia.data.vo.PessoaVO;
import br.com.natanmaia.services.PessoaService;

@Api(value = "API Pessoas", description = "API para desenvolvimento das requests referentes a entidade pessoas", tags = {"Pessoas"})
@RestController
@RequestMapping("/api/v1/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PagedResourcesAssembler<PessoaVO> assembler;

    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public PessoaVO buscarPorId(@PathVariable("id") Long id) {
        PessoaVO vo = pessoaService.buscarPorId(id);
        vo.add(linkTo(methodOn(PessoaController.class).buscarPorId(id)).withSelfRel());
        return vo;
    }

    @GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    public List<PessoaVO> buscarTodos() {
        List<PessoaVO> vos = pessoaService.buscarTodos();
        vos
                .forEach(p -> p.add(
                        linkTo(methodOn(PessoaController.class).buscarPorId(p.getKey())).withSelfRel()
                        )
                );
        return vos;
    }

    @GetMapping(value = "/paginate", produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<?> findAllPaginate(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "limit", defaultValue = "10") int limit,
            @RequestParam(value = "direction", defaultValue = "asc") String direction) {

        var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "nome"));

        Page<PessoaVO> vos = pessoaService.findAllPaginate(pageable);
        vos.stream()
                .forEach(p -> p.add(
                        linkTo(methodOn(PessoaController.class).buscarPorId(p.getKey())).withSelfRel()
                        )
                );

        PagedResources<?> resources = assembler.toResource(vos);

        return new ResponseEntity<>(resources, HttpStatus.OK);
    }

    @GetMapping(value = "/nome/{fistname}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<?> findPersonByName(
            @PathVariable("fistname") String fistname,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "limit", defaultValue = "10") int limit,
            @RequestParam(value = "direction", defaultValue = "asc") String direction) {

        var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "nome"));

        Page<PessoaVO> vos = pessoaService.findPersonByName(fistname, pageable);
        vos.stream()
                .forEach(p -> p.add(
                        linkTo(methodOn(PessoaController.class).buscarPorId(p.getKey())).withSelfRel()
                        )
                );

        PagedResources<?> resources = assembler.toResource(vos);

        return new ResponseEntity<>(resources, HttpStatus.OK);
    }

    @PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"}, consumes = {
            "application/json", "application/xml", "application/x-yaml"})
    public PessoaVO criar(@RequestBody PessoaVO pessoaVO) {
        PessoaVO vo = pessoaService.criar(pessoaVO);
        vo.add(linkTo(methodOn(PessoaController.class).buscarPorId(vo.getKey())).withSelfRel());
        return vo;

    }

    @PutMapping(produces = {"application/json", "application/xml", "application/x-yaml"}, consumes = {
            "application/json", "application/xml", "application/x-yaml"})
    public PessoaVO atualizar(@RequestBody PessoaVO pessoaVO) {
        PessoaVO vo = pessoaService.atualizar(pessoaVO);
        vo.add(linkTo(methodOn(PessoaController.class).buscarPorId(vo.getKey())).withSelfRel());
        return vo;

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
        pessoaService.deletar(id);
        return ResponseEntity.ok().build();

    }

    @PatchMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public PessoaVO disablePerson(@PathVariable("id") Long id) {
        PessoaVO vo = pessoaService.disablePerson(id);
        vo.add(linkTo(methodOn(PessoaController.class).buscarPorId(id)).withSelfRel());
        return vo;
    }
}
