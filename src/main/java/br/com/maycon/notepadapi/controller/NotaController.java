package br.com.maycon.notepadapi.controller;


import br.com.maycon.notepadapi.Component.NotaComponent;
import br.com.maycon.notepadapi.model.Nota;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/nota")
public class NotaController {

    private NotaComponent notaComponent;

    public NotaController(NotaComponent notaComponent) {
        this.notaComponent = notaComponent;
    }

    @GetMapping
    private List<Nota> findAll() {
        return notaComponent.buscarTodos();
    }

    @GetMapping(value = "/titulo/{titulo}")
    private Nota findAll(@PathVariable(value = "titulo") String titulo) {
        return notaComponent.buscarNota(titulo);
    }

    @PostMapping
    private void save(@RequestBody Nota nota) {
        notaComponent.Salvar(nota);
    }

    @DeleteMapping
    private void deleteAll() {
        notaComponent.apagarTodos();
    }
}