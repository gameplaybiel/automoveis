package br.project.gameplay.automoveis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class AutomoveisController {

    @Autowired AutomoveisDao dao;

    @PostMapping("/automoveis")
    public Automoveis incluir(@RequestBody Automoveis a) throws Exception {
        return dao.incluir(a);
    }

    @GetMapping("/automoveis")
    public List<Automoveis> listar() throws Exception {
        return dao.listar();
    }

    @GetMapping("/automoveis/{id}")
    public Automoveis obter(@PathVariable int id) throws Exception {
        return dao.obter(id);
    }
}
