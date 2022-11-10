package com.bakomotors.backend.Repositories;


import org.springframework.data.repository.CrudRepository;

import com.bakomotors.backend.Model.Role;


public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByName(String name);
}
