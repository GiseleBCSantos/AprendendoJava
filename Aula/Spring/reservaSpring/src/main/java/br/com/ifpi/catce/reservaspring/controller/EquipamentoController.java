package br.com.ifpi.catce.reservaspring.controller;

import br.com.ifpi.catce.reservaspring.model.Equipamento;
import br.com.ifpi.catce.reservaspring.repository.EquipamentoRepository;
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
@RequestMapping("/equipamentos")
public class EquipamentoController {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @GetMapping("/listar")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("/equipamento/listarEquipamento");
        return mv;
    }

    @GetMapping("/novo")
    public ModelAndView cadastro(Equipamento equipamento) {
        ModelAndView mv = new ModelAndView("/equipamento/cadastroEquipamento");
        mv.addObject("equipamento", equipamento);
        return mv;
    }

    @PostMapping("/novo")
    public ModelAndView cadastroSubmit(@Valid Equipamento equipamento, BindingResult result, RedirectAttributes attributes) {
        System.out.println(equipamento);
        if (result.hasErrors()) {
            return cadastro(equipamento);
        }
        equipamentoRepository.save(equipamento);
        attributes.addFlashAttribute("mensagem", "Equipamento cadastrado com sucesso!");
        return new ModelAndView("redirect:/equipamentos/listar");
    }

}
