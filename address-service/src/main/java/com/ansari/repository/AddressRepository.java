package com.ansari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ansari.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
