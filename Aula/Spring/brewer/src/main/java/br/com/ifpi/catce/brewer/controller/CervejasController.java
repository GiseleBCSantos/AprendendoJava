package br.com.ifpi.catce.brewer.controller;

import br.com.ifpi.catce.brewer.model.Cerveja;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cervejas")
public class CervejasController {

    @GetMapping("/novo")
    public String novo(Cerveja cerveja){

        return "cerveja/cadastroCerveja";
    }

    @PostMapping(value="/novo")
    public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes){
        if (result.hasErrors()) {
            return novo(cerveja);
        }
        attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso.");
        System.out.println(cerveja.getNome());
        return "redirect:/cervejas/novo";
    }
}
