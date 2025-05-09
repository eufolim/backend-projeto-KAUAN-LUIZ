package com.eufolim.ficha_rpg.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.eufolim.ficha_rpg.models.Ficha;
import com.eufolim.ficha_rpg.models.FichaJSON;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FichaService {

    static RestClient dnd = RestClient.create("https://www.dnd5eapi.co/api/2014/");

    public static Ficha ajustaFicha(FichaJSON json){
        ArrayList<Integer> n = rollAtributos();
        Ficha ficha = new Ficha(
            json.getNome(), 
            json.getClasse(), 
            n.get(json.getForca()-1), 
            n.get(json.getDestreza()-1), 
            n.get(json.getConstituicao()-1), 
            n.get(json.getInteligencia()-1), 
            n.get(json.getSabedoria()-1), 
            n.get(json.getCarisma()-1), 
            (getHitDie(json.getClasse())+calcModifier(n.get(json.getConstituicao()-1)))
            );
        try {
            save(ficha);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ficha;
    }

    public static ArrayList<Integer> rollAtributos(){
        ArrayList<Integer> n = new ArrayList<>();
        while (n.size() < 6) {
            n.add(rollAtributo());
        }
        Collections.sort(n);
        return n;
    }

    public static Integer rollAtributo(){
        Random rand = new Random();
        IntStream stream = rand.ints(4, 1, 7);
        Integer res = stream.sorted().skip(1).sum();
        return res;
    };         

    public static Integer getHitDie(String classe){
        @SuppressWarnings("unchecked")
        LinkedHashMap<String,Object> hit = dnd.get().uri("classes/"+classe).retrieve().body(LinkedHashMap.class);
        return (Integer) hit.get("hit_die");
    }

    public static Integer calcModifier(Integer score){
        Integer mod = score - 10;
        return Math.floorDiv(mod, 2);
    }
        
    public static void save(Ficha ficha) throws StreamWriteException, DatabindException, IOException{
        ObjectMapper m = new ObjectMapper();
        m.writeValue(new File("src/main/java/com/eufolim/ficha_rpg/storage/"+ficha.getNome()+".json"),ficha);
    }

}




