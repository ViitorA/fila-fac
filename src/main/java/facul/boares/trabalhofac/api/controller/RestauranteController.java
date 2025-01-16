package facul.boares.trabalhofac.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import facul.boares.trabalhofac.api.model.input.AddRestauranteDTO;
import facul.boares.trabalhofac.api.model.input.CreateSenhaDTO;
import facul.boares.trabalhofac.api.model.input.GerarSenhaDTO;
import facul.boares.trabalhofac.domain.exception.PropertyNotFoundException;
import facul.boares.trabalhofac.domain.model.Senha;
import facul.boares.trabalhofac.domain.repository.RestauranteRepository;
import facul.boares.trabalhofac.domain.repository.SenhaRepository;
import facul.boares.trabalhofac.domain.service.RestauranteService;
import facul.boares.trabalhofac.domain.service.SenhaService;


@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

    private SenhaService senhaService;
    private RestauranteService restauranteService;
    private SenhaRepository senhaRepository;
    private RestauranteRepository restauranteRepository;


    // Colocar essa logica de codigo la no Service 
    public float estimativaTempoFilaSenhaEspecifica(@RequestHeader Integer numero, Long restauranteId) {
        var requestSenha = senhaRepository.findById(numero).orElseThrow(() -> new PropertyNotFoundException("Repository com esse id não existe"));
        var requestRestaurante = restauranteRepository.findById(restauranteId).orElseThrow(() -> new PropertyNotFoundException("Repository com esse id não existe"));
        var tempoMedioFilaSegundos = restauranteService.estimativaTempoFilaSenhaSegundos(restauranteRepository.countSenhasByRestaurante(restauranteId), 60);
    
        var senhaEncontrada = requestRestaurante.getSenhas().stream()
                .filter(senha -> senha.getNumero().equals(requestSenha.getNumero()))
                .findFirst();
    
        if (senhaEncontrada.isPresent()) {
            // Lista senhas em ordem
            List<Senha> senhasOrdenadasTempo = restauranteRepository.findSenhasByRestauranteOrderByDataCriacaoDesc(restauranteId);
    
            // Achar a posicao da senha na fila
            int posicao = 1; 
            for (Senha senha : senhasOrdenadasTempo) {
                if (senha.getNumero().equals(numero)) {
                    // Retorna a posicao quando encontra a senha
                    // Fazer calculo da estimativa em minutos
                    return tempoMedioFilaSegundos * posicao / 60;
                }
                posicao++;
            }
        }
        throw new PropertyNotFoundException("Senha não encontrada na fila");
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
