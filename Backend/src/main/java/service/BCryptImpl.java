package service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class BCryptImpl{

    //패스워드 암호화 BCrypt.gensalt()는 랜덤한 솔트를 인자로 주는것것
    public String encrypt(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    //원문과 암호화된것이 일치하는지 확인하는 메소드
    public boolean isMatch(String password, String hashed) {
        return BCrypt.checkpw(password, hashed);
    }

}