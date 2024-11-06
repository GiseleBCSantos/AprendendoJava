package br.com.ifpi.catce.brewer.controller;

import br.com.ifpi.catce.brewer.model.Estilo;
import br.com.ifpi.catce.brewer.service.CadastroEstiloService;
import br.com.ifpi.catce.brewer.service.exception.NomeEstiloJaCadastradoException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/estilos")
public class EstilosController {

    @Autowired
    private CadastroEstiloService cadastroEstiloService;


    @GetMapping("/novo")
    public ModelAndView novo(Estilo estilo) {

        ModelAndView mv = new ModelAndView("estilo/cadastroEstilo");
        mv.addObject("estilo", estilo);

        return mv;
    }

    @PostMapping("/novo")
    public ModelAndView cadastrar(@Valid Estilo estilo, BindingResult result, RedirectAttributes attributes) {
        if(result.hasErrors()){
            return novo(estilo);
        }

        try{
            cadastroEstiloService.salvar(estilo);
        } catch (NomeEstiloJaCadastradoException e){
            result.rejectValue("nome", e.getMessage(), e.getMessage());
            return novo(estilo);
        }

        attributes.addFlashAttribute("mensagem", "Estilo cadastrado com sucesso!");
        return new ModelAndView("redirect:/estilos/novo");
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody ResponseEntity<?> salvar(@RequestBody Estilo estilo, BindingResult result){
        System.out.println(estilo);
        if(result.hasErrors()){
            return ResponseEntity.badRequest().body(result.getFieldError("nome").getDefaultMessage());
        }

        estilo = cadastroEstiloService.salvar(estilo);


        return ResponseEntity.ok(estilo);
    }
}
