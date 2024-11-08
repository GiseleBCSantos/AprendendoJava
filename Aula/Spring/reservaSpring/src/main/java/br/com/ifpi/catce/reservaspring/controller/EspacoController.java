package br.com.ifpi.catce.reservaspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/espacos")
public class EspacoController {

    @GetMapping("/listar")
    public String listar() {
        return "espaco/listarEspaco";
    }

    @GetMapping("/novo")
    public String novo() {
        return "espaco/cadastroEspaco";
    }
}
