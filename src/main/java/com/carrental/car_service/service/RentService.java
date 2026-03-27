package com.carrental.car_service.service;

import com.carrental.car_service.dto.RentRequestDTO;
import com.carrental.car_service.entities.Rent;
import com.carrental.car_service.repositories.CarRepository;
import com.carrental.car_service.repositories.RentRepository;
import com.carrental.car_service.service.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class RentService {

    private final RentRepository rentRepository;
    private final CarRepository carRepository;

    public RentService(RentRepository rentRepository, CarRepository carRepository) {
        this.rentRepository = rentRepository;
        this.carRepository = carRepository;
    }

    public List<Rent> findAllRents(int page, int size) {
        int offset = (page - 1) * size;
        return rentRepository.findAll(size, offset);
    }

    public Optional<Rent> findRentById(Long id) {

        return Optional.ofNullable(this.rentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rent not found")));

    }

    public void saveRent(RentRequestDTO rent) {
        var rentEntity = calculateRent(rent);

        var save = this.rentRepository.save(rentEntity);

        Assert.state(save == 1, "Error when trying to save rent for customerId=" + rent.customerId());
    }

    public void updateRent(Rent rent, Long id) {
        var update = this.rentRepository.update(rent, id);

        if (update == 0) {
            throw new RuntimeException("Rent not found");
        }

    }

    public void delete(Long id) {
        var delete = this.rentRepository.delete(id);

        if (delete == 0) {
            throw new RuntimeException("Rent not found");
        }
    }

    private Rent calculateRent(RentRequestDTO dto) {
        var car = this.carRepository.findById(dto.carId())
                .orElseThrow(() -> new RuntimeException("Car not found"));

        var daysCount = BigDecimal.valueOf(dto.endDate().getDayOfYear() - dto.initialDate().getDayOfYear());
        var value = car.getDailyPrice().multiply(daysCount);

        return new Rent(dto, value);
    }
}
