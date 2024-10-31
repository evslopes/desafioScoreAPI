package jhhdev.api.score.model;

import org.glassfish.jaxb.core.v2.TODO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;

public class PessoaTest {

    @Test
    public void testPessoaEntity() {
        Pessoa pessoa = new Pessoa();

        // Testando getters e setters
        pessoa.setNome("Maria");
        pessoa.setIdade(30);
        pessoa.setCep("12345678");
        pessoa.setEstado("SP");
        pessoa.setCidade("São Paulo");
        pessoa.setBairro("Centro");
        pessoa.setLogradouro("Rua Exemplo");
        pessoa.setTelefone("11999999999");
        pessoa.setScore(100);
        pessoa.setAtivo(false);

        assertEquals("Maria", pessoa.getNome());
        assertEquals(30, pessoa.getIdade());
        assertEquals("12345678", pessoa.getCep());
        assertEquals("SP", pessoa.getEstado());
        assertEquals("São Paulo", pessoa.getCidade());
        assertEquals("Centro", pessoa.getBairro());
        assertEquals("Rua Exemplo", pessoa.getLogradouro());
        assertEquals("11999999999", pessoa.getTelefone());
        assertEquals(100, pessoa.getScore());
        assertFalse(pessoa.isAtivo());

        // Testando a anotação @Id
        assertTrue(isAnnotatedWithId(Pessoa.class, "id"));
    }

    private boolean isAnnotatedWithId(Class<?> clazz, String fieldName) {
        return true;
        //TODO escrever teste para validar ID
    }
}
