package facul.boares.trabalhofac.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import facul.boares.trabalhofac.api.model.input.AddRestauranteDTO;
import facul.boares.trabalhofac.api.model.output.ViewRestauranteDTO;
import facul.boares.trabalhofac.domain.model.Restaurante;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class RestauranteAssembler {
    
    private final ModelMapper modelMapper;

    public Restaurante addRestauranteDTOToEntity(AddRestauranteDTO restauranteDTO){
        return modelMapper.map(restauranteDTO, Restaurante.class);
    }

    public ViewRestauranteDTO entityToViewRestauranteDTO(Restaurante restaurante){
        return modelMapper.map(restaurante, ViewRestauranteDTO.class);
    }
}
