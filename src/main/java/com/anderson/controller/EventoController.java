package com.anderson.controller;

import com.anderson.model.Convidado;
import com.anderson.model.Evento;
import com.anderson.repository.ConvidadoRepository;
import com.anderson.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Anderson on 18/09/2019.
 */
@Controller
public class EventoController {


    @Autowired
    private EventoRepository evr;
    @Autowired
    private ConvidadoRepository cr;

    @GetMapping("/cadastrarEvento")
    public String form() {
        return "evento/formEvento";
    }

    @PostMapping("/cadastrarEvento")
    public String form(@Valid Evento evento, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("msg", "Campos vazios não são aceitos!");
            return "redirect:/cadastrarEvento";
        }

        evr.save(evento);
        attributes.addFlashAttribute("msg", "Cadastro efetuado com sucesso!");

        return "redirect:/cadastrarEvento";
    }

    @RequestMapping("/eventos")
    public ModelAndView listaEventos() {
        ModelAndView mv = new ModelAndView("index");
        Iterable<Evento> eventos = evr.findAll();
        mv.addObject("eventos", eventos);
        return mv;

    }

    @GetMapping("/{codigo}")
    public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo) {
        Evento evento = evr.findByCodigo(codigo);

        ModelAndView mv = new ModelAndView("evento/detalhesEvento");
        mv.addObject("evento", evento);

        List<Convidado> convidados = cr.findByEvento(evento);
        mv.addObject("convidados", convidados);
        return mv;
    }

    @PostMapping("/{codigo}")
    public String detalhesEventoPost(@PathVariable("codigo") long codigo, @Valid Convidado convidado, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("msg", "Campos vazios não são aceitos!");
            return "redirect:/{codigo}";
        }

        Evento evento = evr.findByCodigo(codigo);
        convidado.setEvento(evento);
        cr.save(convidado);
        attributes.addFlashAttribute("msg", "Convidado adicionado com sucessso!");

        return "redirect:/{codigo}";
    }

}
