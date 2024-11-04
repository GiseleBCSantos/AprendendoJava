package br.com.ifpi.catce.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    @GetMapping("/novo")
    public ModelAndView novo(){
        ModelAndView mv = new ModelAndView("usuario/cadastroUsuario");

        return mv;
    }

}
