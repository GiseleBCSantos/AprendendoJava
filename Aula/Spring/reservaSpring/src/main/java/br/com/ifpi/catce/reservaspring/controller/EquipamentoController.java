package br.com.ifpi.catce.reservaspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/equipamentos")
public class EquipamentoController {

    @GetMapping("/listar")
    public String listar(Model model) {
        return "equipamento/listarEquipamento";
    }

    @GetMapping("/novo")
    public String cadastro() {
        return "equipamento/cadastroEquipamento";
    }

}
