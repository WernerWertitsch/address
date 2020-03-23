package com.wecreate.services.address.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.wecreate.services.address.repository.AddressRepository;
import com.wecreate.services.address.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private AddressRepository addressRepository;


    public Iterable<Address> findAllAddresses() {return this.addressRepository.findAll();
    }

    public Iterable<Address> getAddressesFor(String clientid) {
        return this.addressRepository.findAddressesByClientid(clientid);
    }

    public Iterable<Address> findAddressesByZip(String zip) {
        return this.addressRepository.findAddressesByZip(zip);
    }

    public Long countAddresses(){return this.addressRepository.count();}

    public Iterable<Address> findFuzzyAddress(String clientid) {
        return this.addressRepository.findAddressesByClientid(clientid);
    }

}
