package DAO;

import Entity.AddressEmployee;

import java.util.List;

public interface AddressDAO {


    //create
    void add(AddressEmployee address);

    //read
    List<AddressEmployee> getAll();

    //findId
    AddressEmployee getAddressById(Long id);

    //update
    void update(AddressEmployee addressEmployee);

    //delete
    void remove(Long id);
}
