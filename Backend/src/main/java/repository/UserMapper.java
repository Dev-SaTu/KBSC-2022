package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.catalina.connector.Connector;
import org.springframework.stereotype.Repository;

import domain.UserDTO;
	
@Repository
public class UserMapper {

	static String ip;
	static Connection con;
	static Statement stmt;

	public UserMapper() throws SQLException {

		Connection con = DriverManager.getConnection("jdbc:mysql://54.180.107.89:3306/kb_db", "gihwan", "0319");

		Statement stmt = con.createStatement();

		String sql = "select * from manager";
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {

			rs.getInt(1);

		}

	}

	public static ResultSet getResultSet(String sql) throws SQLException {

		return stmt.executeQuery(sql);

	}

	/*public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		new Connector();

	}*/
	
    public void signUp(UserDTO user) throws SQLException {
    	
        String command = String.format("INSERT INTO user (id, pw, type, name, address, tel) VALUES (%s, %s, %s, %s, %s)", user.getAccount(), user.getPassword(), user.getType(), user.getName(), user.getAddress(), user.getTel());
       getResultSet(command);
        
    }

    public UserDTO login(UserDTO user) throws SQLException {
    	
        String command = String.format("SELECT * FROM user WHERE id = %s", user.getAccount());
        ResultSet result = getResultSet(command);
        UserDTO tmpUser;

        if(result.next()) {
        	
            tmpUser = new UserDTO(result.getString("id"), result.getString("password"), result.getString("name"), result.getString("address"), result.getString("tel"));
            return tmpUser;
            
        }
        return null;
        
    }
}

