package com.foch.springserver.model.donate;


import com.foch.springserver.model.user.User;
import com.foch.springserver.model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonateDao{

    @Autowired
    private DonateRepository repository;

    @Autowired
    private UserRepository userRepository;

    public boolean donateUser(int pay, String userId){

        User user = userRepository.findById(userId).orElse(null);

        if(user!= null){
            userRepository.changePoint(user.getPoint()-pay, userId);

            int point = repository.getPoint();
            repository.changePoint(pay+point);
            return true;
        }

        return false;
    }
}
