package repository;

import com.example.demo.Connector;
import domain.UserDTO;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserMapper {
    void quit(UserDTO user)
    {

    }
    
    void signUp(UserDTO user) throws SQLException {
    	
        String command = String.format("INSERT INTO user (account, password, name, email) VALUES (%s#{account}, %s#{password}, %s#{email}, %s#{name}", user.getAccount(), user.getPassword(), user.getEmail(), user.getName());
        Connector.getResultSet(command);
        
    }
    
    public UserDTO login(UserDTO user)
    {
		return user;

    }
    UserDTO findWithUserId(long userID)
    {
		return null;

    }
}