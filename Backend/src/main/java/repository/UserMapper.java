package repository;

import com.example.demo.Connector;
import domain.UserDTO;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserMapper {

    public void signUp(UserDTO user) throws SQLException {
        String command = String.format("INSERT INTO user (id, pw, type, name, address, tel) VALUES (%s, %s, %s, %s, %s)", user.getAccount(), user.getPassword(), user.getType(), user.getName(), user.getAddress(), user.getTel());
        Connector.getResultSet(command);
    }

    public UserDTO login(UserDTO user) throws SQLException {
        String command = String.format("SELECT * FROM user WHERE id = %s", user.getAccount());
        ResultSet result = Connector.getResultSet(command);
        UserDTO tmpUser;

        if(result.next())
        {
            tmpUser = new UserDTO(result.getString("id"), result.getString("password"), result.getString("name"), result.getString("address"), result.getString("tel"));
            return tmpUser;
        }
        return null;
    }
}

