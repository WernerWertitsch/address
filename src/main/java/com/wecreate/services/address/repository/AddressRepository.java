package com.wecreate.services.address.repository;

import com.wecreate.services.address.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, String> {
    public Iterable<Address> findAddressesByClientid(String clientid);
    public Iterable<Address> findAddressesByZip(String zip);
}



