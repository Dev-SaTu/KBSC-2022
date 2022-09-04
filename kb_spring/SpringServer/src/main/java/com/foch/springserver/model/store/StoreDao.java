package com.foch.springserver.model.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreDao {
    @Autowired
    private StoreRepository repository;

    public void addStore(Store store){
        repository.save(store);        
    }

    public Store findStore(String storeId){
        return repository.findById(storeId).orElse(null);
    }
}
