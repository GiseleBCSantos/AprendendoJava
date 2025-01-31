package br.com.ifpi.catce.brewer.controller;

import br.com.ifpi.catce.brewer.controller.page.PageWrapper;
import br.com.ifpi.catce.brewer.model.Cerveja;
import br.com.ifpi.catce.brewer.model.Origem;
import br.com.ifpi.catce.brewer.model.Sabor;
import br.com.ifpi.catce.brewer.repository.Cervejas;
import br.com.ifpi.catce.brewer.repository.Estilos;
import br.com.ifpi.catce.brewer.repository.filter.CervejaFilter;
import br.com.ifpi.catce.brewer.service.CadastroCervejaService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cervejas")
public class CervejasController {
    private static final Logger logger = LoggerFactory.getLogger(CervejasController.class);

    @Autowired
    private Estilos estilos;

    @Autowired
    private CadastroCervejaService cadastroCervejaService;

    @Autowired
    private Cervejas cervejas;


    @GetMapping("/novo")
    public ModelAndView novo(Cerveja cerveja){
        ModelAndView mv = new ModelAndView("cerveja/cadastroCerveja");
        mv.addObject("cerveja", cerveja);
        mv.addObject("sabores", Sabor.values());
        mv.addObject("estilos", estilos.findAll());
        mv.addObject("origens", Origem.values());
        return mv;
    }

    @PostMapping(value="/novo")
    public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result, RedirectAttributes attributes){
        if (result.hasErrors()) {
            return novo(cerveja);
        }
        cadastroCervejaService.salvar(cerveja);
        attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso.");
        return new ModelAndView("redirect:/cervejas/novo");
    }

    @GetMapping
    public ModelAndView pesquisar(CervejaFilter cervejaFilter, BindingResult result, @PageableDefault(size = 2 ) Pageable pageable, HttpServletRequest httpServletRequest){
        ModelAndView mv = new ModelAndView("cerveja/PesquisaCervejas");
        mv.addObject("sabores", Sabor.values());
        mv.addObject("estilos", estilos.findAll());
        mv.addObject("origens", Origem.values());



        PageWrapper<Cerveja> paginaWrapper = new PageWrapper<>(cervejas.filtrar(cervejaFilter, pageable), httpServletRequest);
        mv.addObject("pagina", paginaWrapper);

        return mv;
    }
}
