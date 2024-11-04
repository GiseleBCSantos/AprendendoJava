package br.com.ifpi.catce.brewer.controller;

import br.com.ifpi.catce.brewer.model.Cerveja;
import br.com.ifpi.catce.brewer.model.Origem;
import br.com.ifpi.catce.brewer.model.Sabor;
import br.com.ifpi.catce.brewer.repository.Estilos;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cervejas")
public class CervejasController {

    @Autowired
    private Estilos estilos;

    @GetMapping("/novo")
    public ModelAndView novo(Cerveja cerveja){
        ModelAndView mv = new ModelAndView("cerveja/cadastroCerveja");
        mv.addObject("sabores", Sabor.values());
        mv.addObject("estilos", estilos.findAll());
        mv.addObject("origens", Origem.values());
        return mv;
    }


    @PostMapping(value="/novo")
    public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes){
        if (result.hasErrors()) {
            return novo(cerveja);
        }
        attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso.");
        System.out.println(cerveja.getNome());
        return new ModelAndView("redirect:/cervejas/novo");
    }

    @GetMapping("cliente")
    public String novoCliente(){
        return "cerveja/cadastroCliente";
    }

}
