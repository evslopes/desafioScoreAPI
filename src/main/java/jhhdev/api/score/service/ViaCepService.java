package jhhdev.api.score.service;

import jhhdev.api.score.model.Pessoa;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {
    private final RestTemplate restTemplate = new RestTemplate();

    public Pessoa preencherEnderecoPorCep(Pessoa pessoa) {
        String url = "https://viacep.com.br/ws/" + pessoa.getCep() + "/json/";
        EnderecoResponse endereco = restTemplate.getForObject(url, EnderecoResponse.class);

        if (endereco != null) {
            pessoa.setEstado(endereco.getUf());
            pessoa.setCidade(endereco.getLocalidade());
            pessoa.setBairro(endereco.getBairro());
            pessoa.setLogradouro(endereco.getLogradouro());
        }
        return pessoa;
    }
}

class EnderecoResponse {
    private String uf;
    private String localidade;
    private String bairro;
    private String logradouro;


    // Getters e setters
    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }


}
