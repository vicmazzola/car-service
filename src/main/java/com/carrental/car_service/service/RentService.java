package com.carrental.car_service.service;

import com.carrental.car_service.entities.Rent;
import com.carrental.car_service.repositories.RentRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class RentService {

    private final RentRepository rentRepository;

    public RentService(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    public List<Rent> findAllRents(int page, int size) {
        int offset = (page - 1) * size;
        return rentRepository.findAll(size, offset);
    }

    public Optional<Rent> findRentById(Long id) {
        return this.rentRepository.findById(id);
    }

    public void saveRent(Rent rent) {
        var save = this.rentRepository.save(rent);
        Assert.state(save == 1, "Error when trying to save rent" + rent.getCustomerName());
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
}
