package br.com.ifpe.oxefood.modelo.entregador;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntregadorService {

@Autowired
private EntregadorRepository repository;

@Transactional
public Entregador save(Entregador entregador) {

    entregador.setHabilitado(Boolean.TRUE);
    return repository.save(entregador);
}

public List<Entregador> listarTodos() {

        return repository.findAll();
    }

    public Entregador obterPorID(Long id) {

        return repository.findById(id).get();
    }

@Transactional
public void update(Long id, Entregador clienteAlterado) {

    Entregador entregador = repository.findById(id).get();
    entregador.setNome(clienteAlterado.getNome());
    entregador.setDataNascimento(clienteAlterado.getDataNascimento());
    entregador.setCpf(clienteAlterado.getCpf());
    entregador.setFoneCelular(clienteAlterado.getFoneCelular());
    entregador.setFoneFixo(clienteAlterado.getFoneFixo());
    
    repository.save(entregador);
}

@Transactional
public void delete(Long id) {

    Entregador entregador = repository.findById(id).get();
    entregador.setHabilitado(Boolean.FALSE);

    repository.save(entregador);
}
}
