package com.bakomotors.backend.Repositories;



import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bakomotors.backend.Model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
