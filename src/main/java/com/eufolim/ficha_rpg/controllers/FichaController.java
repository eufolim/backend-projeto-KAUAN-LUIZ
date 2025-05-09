package com.eufolim.ficha_rpg.controllers;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.eufolim.ficha_rpg.models.Ficha;
import com.eufolim.ficha_rpg.models.FichaJSON;
import com.eufolim.ficha_rpg.services.FichaService;

@RestController
public class FichaController {

    @RequestMapping("/novaficha")
    public ModelAndView novaFicha(){
        ModelAndView view = new ModelAndView();
        view.setViewName("novaFicha.html");
        return view;
    }

    @GetMapping("/sobre")
    @ResponseBody
    public Object sobre() {
        HashMap<String,Object> sobre = new HashMap<>();
        String[] nomes = {"Kauan Martins Pereira","Luiz Antônio Frey Cristiano"};
        sobre.put("integrantes", nomes);
        sobre.put("nome_projeto", "");
        return ResponseEntity.ok().body(sobre);
    }
    
    @PostMapping("/criarficha")
    public Ficha criarFicha(@ModelAttribute FichaJSON json){
        return FichaService.ajustaFicha(json);
    }
}
