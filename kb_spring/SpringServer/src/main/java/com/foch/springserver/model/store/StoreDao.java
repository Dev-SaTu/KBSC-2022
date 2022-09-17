package com.foch.springserver.model.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreDao {
    @Autowired
    private StoreRepository repository;

    //스토어 추가하는 함수
    public void addStore(Store store){
        repository.save(store); 
    }

    //스토어 찾는 함수
    public Store findStore(String id) {
        return repository.findById(id).orElse(null);
    }


    public List<Store> searchStores(String location){
        return repository.searchStoresWithLocation(location);
    }
}
