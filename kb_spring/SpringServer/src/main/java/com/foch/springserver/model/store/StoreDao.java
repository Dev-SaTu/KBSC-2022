package com.foch.springserver.model.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreDao {
    @Autowired
    private StoreRepository repository;

    public boolean addStore(Store store){
        Store st = findStore(store.getBusiness_number());
        if(st == null)
        {
            repository.save(store);
            return true;
        }
        else
            return false;
    }

    public Store findStore(String storeId){
        return repository.findById(storeId).orElse(null);
    }

}
