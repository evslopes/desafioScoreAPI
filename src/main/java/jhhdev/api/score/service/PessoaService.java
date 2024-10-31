package jhhdev.api.score.service;

import jhhdev.api.score.model.Pessoa;
import jhhdev.api.score.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    @Autowired
    private ViaCepService viaCepService;

    public Pessoa criarPessoa(Pessoa pessoa) {
        viaCepService.preencherEnderecoPorCep(pessoa);
        return repository.save(pessoa);
    }

    public Page<Pessoa> listarPessoas(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Pessoa atualizarPessoa(Long id, Pessoa pessoaAtualizada) {
        Pessoa pessoa = repository.findById(id).orElseThrow();
        pessoa.setNome(pessoaAtualizada.getNome());
        pessoa.setIdade(pessoaAtualizada.getIdade());
        // Atualizar outros campos conforme necessário
        return repository.save(pessoa);
    }

    public void excluirPessoaLogicamente(Long id) {
        Pessoa pessoa = repository.findById(id).orElseThrow();
        pessoa.setAtivo(false);
        repository.save(pessoa);
    }
}

