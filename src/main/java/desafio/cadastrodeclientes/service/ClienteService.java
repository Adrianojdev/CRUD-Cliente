package desafio.cadastrodeclientes.service;

import desafio.cadastrodeclientes.exception.NegocioException;
import desafio.cadastrodeclientes.model.Cliente;
import desafio.cadastrodeclientes.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@AllArgsConstructor
@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar(Cliente cliente) {
        if(cliente.getId() == null) {
            boolean cpfEmUso = clienteRepository.findByCpf(cliente.getCpf())
                    .stream()
                    .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
            if (cpfEmUso) {
                throw new NegocioException("Cpf já cadastrado");
            }
        }


        Cliente aaa =  clienteRepository.save(cliente);

        return aaa;
    }

    public void excluir(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }

}
