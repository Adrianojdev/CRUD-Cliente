package desafio.cadastrodeclientes.model;

import desafio.cadastrodeclientes.dto.ClienteDTO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String cpf;

    @NotNull
    private String nome;

    @NotNull
    private String cep;

    @NotNull
    private String endereco;

    @NotNull
    private String numero;

    @NotNull
    private String bairro;

    @NotNull
    private String complemento;

    @NotNull
    private String municipio;

    @NotNull
    private String uf;

    @NotNull
    private String rg;

    public ClienteDTO _converttoDTO(){
        ClienteDTO dto = new ClienteDTO();
        dto.setCep(this.getCep());
        dto.setCpf(this.getCpf());
        dto.setNome(this.getNome());
        dto.setRg(this.getRg());

        return dto;
    }

}