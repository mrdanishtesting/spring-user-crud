package com.crud.crudproject.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.crudproject.model.Role;

<<<<<<< HEAD
<<<<<<< HEAD
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(String name);
=======
public interface RoleRepository extends JpaRepository<Role, Long>{
    Optional<Role> findByName(String name);
>>>>>>> 3dbdd575f46192be287b31a54040bce9212b8dd6
=======
public interface RoleRepository extends JpaRepository<Role, Long>{
    Optional<Role> findByName(String name);
>>>>>>> refs/remotes/origin/main
}
