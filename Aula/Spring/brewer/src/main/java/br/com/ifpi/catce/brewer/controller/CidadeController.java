package br.com.ifpi.catce.brewer.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cidades")
public class CidadeController {

//    @Autowired
//    private Estados estados;

    @GetMapping("/novo")
    public ModelAndView novo() {
        ModelAndView mv =  new ModelAndView("/cidade/cadastroCidade");

//        mv.addObject("estados", estados);

        return mv;
    }
}
