package com.eufolim.ficha_rpg.models;

public class Ficha {
    String nome;
    String classe;

    Integer hp;

    Integer forca;
    Integer destreza;
    Integer constituicao;
    Integer inteligencia;
    Integer sabedoria;
    Integer carisma;
    
    public Ficha(String nome, String classe, Integer forca, Integer destreza,
            Integer constituicao, Integer inteligencia, Integer sabedoria, Integer carisma, Integer hp) {
        this.nome = nome;
        this.classe = classe;
        this.hp = hp;
        this.forca = forca;
        this.destreza = destreza;
        this.constituicao = constituicao;
        this.inteligencia = inteligencia;
        this.sabedoria = sabedoria;
        this.carisma = carisma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getForca() {
        return forca;
    }

    public void setForca(Integer forca) {
        this.forca = forca;
    }

    public Integer getDestreza() {
        return destreza;
    }

    public void setDestreza(Integer destreza) {
        this.destreza = destreza;
    }

    public Integer getConstituicao() {
        return constituicao;
    }

    public void setConstituicao(Integer constituicao) {
        this.constituicao = constituicao;
    }

    public Integer getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(Integer inteligencia) {
        this.inteligencia = inteligencia;
    }

    public Integer getSabedoria() {
        return sabedoria;
    }

    public void setSabedoria(Integer sabedoria) {
        this.sabedoria = sabedoria;
    }

    public Integer getCarisma() {
        return carisma;
    }

    public void setCarisma(Integer carisma) {
        this.carisma = carisma;
    }
}
