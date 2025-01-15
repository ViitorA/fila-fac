package facul.boares.trabalhofac.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import facul.boares.trabalhofac.api.model.input.CreateSenhaDTO;
import facul.boares.trabalhofac.api.model.input.GerarSenhaDTO;
import facul.boares.trabalhofac.domain.exception.PropertyNotFoundException;
import facul.boares.trabalhofac.domain.repository.RestauranteRepository;

import facul.boares.trabalhofac.domain.service.SenhaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/senha")
public class SenhaController {
    
    private SenhaService senhaService;
    private RestauranteRepository restauranteRepository;

    @PostMapping("/gerarSenha/")
    public void gerarSenha(@RequestBody GerarSenhaDTO gerarSenhaDTO){
        var requestRestaurante = restauranteRepository.findByNomeRestaurante(gerarSenhaDTO.getRestauranteNome()).orElseThrow(() -> new PropertyNotFoundException("Repository com esse id não existe"));
        CreateSenhaDTO senhaDTO = new CreateSenhaDTO();
        senhaDTO.setAlunoId(gerarSenhaDTO.getAlunoId());
        senhaDTO.setRestaurante(requestRestaurante);
        
        senhaService.createSenha(senhaDTO);
    }

}
