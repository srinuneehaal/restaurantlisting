package com.sb.restaurantlisting.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sb.restaurantlisting.dto.RestaurantDTO;
import com.sb.restaurantlisting.entity.Restaurant;
import com.sb.restaurantlisting.mapper.RestaurantMapper;
import com.sb.restaurantlisting.repo.RestaurantRepo;

@Service
public class RestaurantService {

	@Autowired
	RestaurantRepo restaurantRepo;

	public List<RestaurantDTO> findAllRestaurants() {
		// TODO Auto-generated method stub

		List<Restaurant> restaurants = restaurantRepo.findAll();

		List<RestaurantDTO> restaurantDTOs = restaurants.stream()
				.map(restaurant -> RestaurantMapper.iNSTANCEMapper.mapRestaurantTORestaurantDTO(restaurant))
				.collect(Collectors.toList());
		return restaurantDTOs;
	}

	public RestaurantDTO addRestaurantInDB(RestaurantDTO restaurantDTO) {
		// TODO Auto-generated method stub

		Restaurant savedRestaurant = restaurantRepo
				.save(RestaurantMapper.iNSTANCEMapper.mapRestaurantDTOTORestaurant(restaurantDTO));

		return RestaurantMapper.iNSTANCEMapper.mapRestaurantTORestaurantDTO(savedRestaurant);
	}

	public ResponseEntity<RestaurantDTO> fetchRestaurantById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Restaurant> restaurant = restaurantRepo.findById(id);

		if (restaurant.isPresent()) {

			return new ResponseEntity<>(RestaurantMapper.iNSTANCEMapper.mapRestaurantTORestaurantDTO(restaurant.get()),
					HttpStatus.OK);

		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

}
