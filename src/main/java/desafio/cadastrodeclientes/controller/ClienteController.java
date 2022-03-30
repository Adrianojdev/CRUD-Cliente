package desafio.cadastrodeclientes.controller;

import desafio.cadastrodeclientes.dto.ClienteDTO;
import desafio.cadastrodeclientes.model.Cliente;
import desafio.cadastrodeclientes.repository.ClienteRepository;
import desafio.cadastrodeclientes.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {


    private ClienteService clienteService;
    private ClienteRepository clienteRepository;


    @GetMapping
    public List<Cliente> listar() { return clienteRepository.findAll(); }


    @GetMapping("/nome/{clienteNome}")
    public ResponseEntity<ClienteDTO> buscaNome(@PathVariable String clienteNome) {
//        return clienteRepository.findByNome(clienteNome)
//                .map(cliente -> ResponseEntity.ok(cliente))
//                .orElse(ResponseEntity.notFound().build());
        ClienteDTO cliNome = clienteRepository.findByNome(clienteNome).get()._converttoDTO();
        return ResponseEntity.ok(cliNome);
    }

    @GetMapping("/cpf/{clienteCpf}")
    public ResponseEntity<ClienteDTO> buscaCpf(@PathVariable String clienteCpf) {
//         clienteRepository.findByCpf(clienteCpf)
//                .map(cliente -> ResponseEntity.ok(cliente))
//                .orElse(ResponseEntity.notFound().build());
        ClienteDTO dto = clienteRepository.findByCpf(clienteCpf).get()._converttoDTO();


        return ResponseEntity.ok(dto);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
          return clienteService.salvar(cliente);
    }

    @PutMapping("/id/{clienteId}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId, @Valid @RequestBody Cliente cliente) {
        if (!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }
        cliente.setId(clienteId);
        cliente = clienteService.salvar(cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/id/{clienteId}")
    public ResponseEntity<Void> remover(@PathVariable Long clienteId) {
        if (!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }
        clienteService.excluir(clienteId);
        return ResponseEntity.noContent().build();
    }

}
