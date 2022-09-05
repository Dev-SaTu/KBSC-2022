package com.foch.springserver.model.user;

import com.foch.springserver.model.store.Store;
import com.foch.springserver.model.store.StoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class UserDao{
    @Autowired
    private UserRepository repository;

    public void addUser(User user){
        repository.save(user);        
    }

    public boolean payPoint(String business_number, int pay, String id)
    {
        StoreDao dao = new StoreDao();

        Store store = dao.findStore(business_number);

        User user = findUser(id);

        User storeUser = findUser(store.getUser_id());

        if(user != null && storeUser != null)
        {
            user.setPoint(user.getPoint()-pay);

            repository.changePoint(user.getPoint(), user.getId());

            storeUser.setPoint(storeUser.getPoint()+pay);

            repository.changePoint(storeUser.getPoint(), storeUser.getId());

            return true;
        }

        return false;
    }

    public List<User> getAllUser(){
        List<User> users = new ArrayList<>();
        Streamable.of(repository.findAll()).forEach(users::add);
        return users;
    }



    public void delete(User user){
        repository.delete(user);
    }

    public User findUser(String userId){
        return repository.findById(userId).orElse(null);
    }

    public void changeType(String userId, int type){
        repository.changeValue(userId, type);
    }
}
