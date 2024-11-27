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
public void update(Long id, Entregador entregadorAlterado) {

    Entregador entregador = repository.findById(id).get();
    entregador.setNome(entregadorAlterado.getNome());
    entregador.setDataNascimento(entregadorAlterado.getDataNascimento());
    entregador.setCpf(entregadorAlterado.getCpf());
    entregador.setFoneCelular(entregadorAlterado.getFoneCelular());
    entregador.setFoneFixo(entregadorAlterado.getFoneFixo());
    entregador.setEntregasRealizadas(entregadorAlterado.getEntregasRealizadas());
    entregador.setValorFrete(entregadorAlterado.getValorFrete());
    entregador.setRua(entregadorAlterado.getRua());
    entregador.setNumeroEndereco(entregadorAlterado.getNumeroEndereco());
    entregador.setBairro(entregadorAlterado.getBairro());
    entregador.setCidade(entregadorAlterado.getCidade());
    entregador.setCep(entregadorAlterado.getCep());
    entregador.setUf(entregadorAlterado.getUf());
    entregador.setComplemento(entregadorAlterado.getComplemento());
    
    repository.save(entregador);
}

@Transactional
public void delete(Long id) {

    Entregador entregador = repository.findById(id).get();
    entregador.setHabilitado(Boolean.FALSE);

    repository.save(entregador);
}
}
