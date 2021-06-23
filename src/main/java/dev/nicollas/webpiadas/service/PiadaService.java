package dev.nicollas.webpiadas.service;

import dev.nicollas.webpiadas.domain.Piada;
import dev.nicollas.webpiadas.repositories.PiadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PiadaService {

    @Autowired
    private PiadaRepository repository;

    public List<Piada> getAll() {
        return repository.findAll();
    }

    public Piada findById(Integer id) {
        Optional<Piada> piadaOptional = repository.findById(id);
        return piadaOptional.orElse(new Piada());
    }

    public Piada save(Piada piada) {
        Piada piadaSaved = repository.save(piada);
        piada.setId(piadaSaved.getId());
        return piada;
    }

    public void remove(Integer id) {
        repository.deleteById(id);
    }

    public Piada update(Piada piada) {
        return repository.save(piada);
    }

}
