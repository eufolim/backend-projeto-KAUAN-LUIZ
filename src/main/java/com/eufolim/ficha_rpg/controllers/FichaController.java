package com.eufolim.ficha_rpg.controllers;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.eufolim.ficha_rpg.models.Ficha;
import com.eufolim.ficha_rpg.models.FichaJSON;
import com.eufolim.ficha_rpg.services.FichaService;
import com.fasterxml.jackson.databind.ObjectMapper;

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
        sobre.put("nome_projeto", "Ficha RPG");
        return ResponseEntity.ok().body(sobre);
    }

    @GetMapping("/verficha/{nome}")
    @ResponseBody
    public Object verFicha(@PathVariable String nome) throws IOException{
        ObjectMapper m = new ObjectMapper();
        FileReader r = new FileReader("src/main/java/com/eufolim/ficha_rpg/storage/"+nome+".json");
        Object res = m.readValue(r, Object.class);
        return res;
    }
    
    @PostMapping("/criarficha")
    public Ficha criarFicha(@ModelAttribute FichaJSON json){
        return FichaService.ajustaFicha(json);
    }
}
