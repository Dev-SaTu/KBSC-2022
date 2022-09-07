package com.foch.springserver.model.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreDao {
    @Autowired
    private StoreRepository repository;

    //스토어 추가하는 함수
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

    //스토어 찾는 함수
    public Store findStore(String business_number) {
        return repository.findById(business_number).orElse(null);
    }


    public List<Store> searchStores(String location)
    {
        return repository.searchStoresWithLocation(location);
    }
}
