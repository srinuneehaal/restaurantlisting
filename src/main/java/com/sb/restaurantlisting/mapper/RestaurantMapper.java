package com.sb.restaurantlisting.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.sb.restaurantlisting.dto.RestaurantDTO;
import com.sb.restaurantlisting.entity.Restaurant;

@Mapper
public interface RestaurantMapper {

	RestaurantMapper iNSTANCEMapper = Mappers.getMapper(RestaurantMapper.class);

	Restaurant mapRestaurantDTOTORestaurant(RestaurantDTO restaurantDTO);

	RestaurantDTO mapRestaurantTORestaurantDTO(Restaurant restaurant);

}
