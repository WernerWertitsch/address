package com.wecreate.services.address.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.wecreate.services.address.model.Address;
import com.wecreate.services.address.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.logging.Logger;

@Component
public class Mutation implements GraphQLMutationResolver {

    Logger logger = Logger.getLogger(Mutation.class.getName());

    @Autowired
    AddressRepository addressRepository;

    public Address createAddress(String clientid,
                                 String type,
                                 String addressline1,
                                 String addressline2,
                                 String zip,
                                 String city,
                                 String country ) {
        Address ret = new Address();
        ret.setClientid(clientid);
        ret.setType(type);
        ret.setAddressline1(addressline1);
        ret.setAddressline2(addressline2);
        ret.setZip(zip);
        ret.setCity(city);
        ret.setCountry(country);

        this.addressRepository.save(ret);
        return (ret);

    }

    public void updateAddress(Address address) {
        this.addressRepository.save(address);
    }
}