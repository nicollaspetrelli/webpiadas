package dev.nicollas.webpiadas.api;

import dev.nicollas.webpiadas.domain.Piada;
import dev.nicollas.webpiadas.service.PiadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("/api/v1/piada")
@RestController
public class PiadaApi {

    @Autowired
    private PiadaService service;

    @GetMapping("/all")
    public ResponseEntity<List<Piada>> getAll() {
        List<Piada> piadas = service.getAll();
        return ResponseEntity.ok().body(piadas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Piada> findById(@PathVariable Integer id) {
        Piada piada = service.findById(id);
        return ResponseEntity.ok().body(piada);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> add (@RequestBody Piada piada) {
        Piada piadaSaved = service.save(piada);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(piadaSaved.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> destroy(@PathVariable Integer id) {
        service.remove(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Piada piadaContent) {
        Piada piadaModel = service.findById(id);

        piadaModel.setPergunta(piadaContent.getPergunta());
        piadaModel.setResposta(piadaContent.getResposta());
        Piada updated = service.update(piadaModel);

        return ResponseEntity.noContent().build();
    }
}
