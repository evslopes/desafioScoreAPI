package jhhdev.api.score.controller;

import jhhdev.api.score.model.Pessoa;
import jhhdev.api.score.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {
    @Autowired
    private PessoaService service;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Pessoa criarPessoa(@RequestBody Pessoa pessoa) {
        return service.criarPessoa(pessoa);
    }

    @GetMapping
    public Page<Pessoa> listarPessoas(Pageable pageable) {
        return service.listarPessoas(pageable);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public Pessoa atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        return service.atualizarPessoa(id, pessoa);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void excluirPessoa(@PathVariable Long id) {
        service.excluirPessoaLogicamente(id);
    }
}
