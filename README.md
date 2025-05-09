# Gerador de Ficha de D&D
Aplicação com o intuito de facilitar a criação da ficha de jogador para D&D 5ª edição.

### Integrantes
- Kauan Martins Pereira
- Luiz Antônio Frey

## Rotas

### *POST /criarficha*
Rota que recebe as informações do usuario no formato Json e retorna uma ficha adequada com as regras do D&D 5ª edição, também salva o arquivo Json.

Exemplo de requisição:
```json
{
  "nome" : "Mario",
  "Classe" : "barbarian",
  "forca" : 6,
  "destreza" : 3,
  "constituicao" : 5,
  "inteligencia" : 1,
  "sabedoria" : 2,
  "carisma" : 4
}
```
Exemplo de resposta:
```json
{
  "nome": "Mario",
  "classe": "barbarian",
  "forca": 15,
  "destreza": 11,
  "constituicao": 14,
  "inteligencia": 10,
  "sabedoria": 10,
  "carisma": 13,
  "hp": 14
}
```

### *GET /verficha/{nome}*
Rota que acessa uma ficha já criada.

Exemplo:
```curl
/verficha/Mario
```

### *GET /sobre*
rota que trás informações sobre o projeto.

## Crud
Interface minima para a aplicação atraves da rota
```curl
/novaficha
```

## Models / DTOs

### FichaJSON
Classe que recebe as informações do usuario.
Nome e classe são salvos em String e são transferidos para a Ficha final.
Já os valores inteiros representam a *prioridade* de cada atributo.

```java
  String nome;
  String classe;

  Integer forca;
  Integer destreza;
  Integer constituicao;
  Integer inteligencia;
  Integer sabedoria;
  Integer carisma;
```

### Ficha
Classe que retorna ao usuario após manipulação.

#### Atributos
Atributos agora possuem seus valores de acordo com a prioridade enviada pelo usuario e as regras do D&D 5ª edição.

Atributos são calculados jogando 4d6. Ex: ``` [4,6,3,3] ```
Removendo um dado com o menor numero. Ex: ``` [4,6,3] ``` 
Por fim soman-se os 3 restantes. Ex: ``` [13] ```

### Modificadores

Modificadores são calculados a partir dos Atributos como Constituição.

- Subtraindo 10 do valor base de um atributo. Ex: ``` 14 - 10 = 4 ```
- E então dividindo o resultado por 2. (Arredondando para baixo) Ex: ``` 4 // 2 = 2 ```

Resultando no modificador de Contituição: +2

#### HitDie

HitDie ou HitPoints(hp) é calculado atraves de um valor especifico para cada *Classe* somado ao *Modificador* de Contituição 

Exemplo de requisição:
``` https://www.dnd5eapi.co/api/2014/classes/barbarian ```

Valor separado:
``` 
"hit_die" = 12
```

HitDie:
``` 12 + 2 = 14 ```

## APIs
- D&D 5th Edition API ```https://www.dnd5eapi.co/api/2014/```
- Projeto RPG Dice Roller ```https://dice-api.up.railway.app/``` *(API fora do ar)*



