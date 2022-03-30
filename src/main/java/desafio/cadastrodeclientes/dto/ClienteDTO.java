package desafio.cadastrodeclientes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {


    private String nome;
    private String cpf;
    private String rg;
    private String cep;


}
