package facul.boares.trabalhofac.domain.service;

import org.springframework.stereotype.Service;

import facul.boares.trabalhofac.api.assembler.RestauranteAssembler;
import facul.boares.trabalhofac.api.model.input.AddRestauranteDTO;
import facul.boares.trabalhofac.api.model.output.ViewRestauranteDTO;
import facul.boares.trabalhofac.domain.model.Restaurante;
import facul.boares.trabalhofac.domain.repository.RestauranteRepository;
import jakarta.el.PropertyNotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RestauranteService {

    private final RestauranteAssembler restauranteAssembler;
    private final RestauranteRepository restauranteRepository;
    
    public ViewRestauranteDTO viewRestaurante(String restauranteNome){
        var requestRestaurante = restauranteRepository.findByNomeRestaurante(restauranteNome).orElseThrow(() -> new PropertyNotFoundException("Repository com esse nome não existe"));
        
        return restauranteAssembler.entityToViewRestauranteDTO(requestRestaurante);
    }

    public Restaurante addRestaurante(AddRestauranteDTO restauranteDTO){
        var requestRestaurante = restauranteAssembler.addRestauranteDTOToEntity(restauranteDTO);
        restauranteRepository.findByNomeRestaurante(requestRestaurante.getNomeRestaurante()).orElseThrow(() -> new PropertyNotFoundException("Repository com esse nome não existe"));

        return restauranteRepository.save(requestRestaurante);
    }

    public void deleteRestaurante(Long id){
        restauranteRepository.deleteById(id);
    }
}
