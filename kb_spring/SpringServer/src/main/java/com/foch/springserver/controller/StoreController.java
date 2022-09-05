package com.foch.springserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.foch.springserver.model.store.Store;
import com.foch.springserver.model.store.StoreDao;

@RestController
public class StoreController {
    
	@Autowired
    private StoreDao storeDao;

    @RequestMapping(value = "/stores/{storeId}", method = RequestMethod.GET)
    public Store findUser(@PathVariable("storeId") String storeId){
        Store store = storeDao.findStore(storeId);
        return store;
    }

    @RequestMapping(value = "/stores/register", method = RequestMethod.POST)
    public boolean registerStore(@RequestBody Store store){
        return storeDao.addStore(store);
    }


}
