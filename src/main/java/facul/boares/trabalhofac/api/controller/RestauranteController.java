package facul.boares.trabalhofac.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import facul.boares.trabalhofac.api.model.input.AddRestauranteDTO;
import facul.boares.trabalhofac.api.model.input.CreateSenhaDTO;
import facul.boares.trabalhofac.api.model.input.GerarSenhaDTO;
import facul.boares.trabalhofac.domain.repository.RestauranteRepository;
import facul.boares.trabalhofac.domain.repository.SenhaRepository;
import facul.boares.trabalhofac.domain.service.RestauranteService;
import facul.boares.trabalhofac.domain.service.SenhaService;
import jakarta.el.PropertyNotFoundException;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

    private SenhaService senhaService;
    private RestauranteService restauranteService;
    private SenhaRepository senhaRepository;
    private RestauranteRepository restauranteRepository;

    public void estimativaTempoFila(@RequestHeader Integer numero){
        var requestSenha = senhaRepository.findById(numero).orElseThrow(() -> new PropertyNotFoundException("Repository com esse nome não existe"));
    }

    @PostMapping("/cadastrarRestaurante/")
    public void cadastrarRestaurante(@RequestBody AddRestauranteDTO restauranteDTO){
        restauranteService.addRestaurante(restauranteDTO);
    }
    
    @PostMapping("/entrarFila/")
    public void entrarFila(@RequestBody GerarSenhaDTO gerarSenhaDTO){
        var requestRestaurante = restauranteRepository.findByNomeRestaurante(gerarSenhaDTO.getRestauranteNome()).orElseThrow(() -> new PropertyNotFoundException("Repository com esse id não existe"));
        CreateSenhaDTO senhaDTO = new CreateSenhaDTO();
        senhaDTO.setAlunoId(gerarSenhaDTO.getAlunoId());
        senhaDTO.setRestaurante(requestRestaurante);
        
        senhaService.createSenha(senhaDTO);
    }

    @PostMapping("/sairFila/")
    public void sairFila(@RequestBody Long numero){
        restauranteRepository.deleteById(numero);
    }


}
