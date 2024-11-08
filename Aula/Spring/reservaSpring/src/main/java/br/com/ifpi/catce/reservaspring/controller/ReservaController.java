package br.com.ifpi.catce.reservaspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservas")
public class ReservaController {


    @GetMapping("/listar")
    public String listar(Model model) {
        return "reserva/listarReserva";
    }

    @GetMapping("/novo")
    public String novo() {
        return "reserva/cadastroReserva";
    }

}
