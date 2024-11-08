package br.com.ifpi.catce.reservaspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @GetMapping("/listar")
    public String listar(Model model) {
        return "funcionario/listarFuncionario";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        return "funcionario/cadastroFuncionario";
    }
}
