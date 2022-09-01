package controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import domain.UserDTO;
import service.UserService;

@RestController
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/hello")
    public String hello() {
    	return "장기환 화이팅!";
    }
    
    /*
    @GetMapping(value = "/profile")
    public ResponseEntity<UserDTO> profile() throws Exception {
        return new ResponseEntity<>(userService.readUser(), HttpStatus.OK);
    }
    */

    @GetMapping(value = "/logout")
    public ResponseEntity<String> logout(){
        if(userService.logout())
            return new ResponseEntity<>("로그아웃 성공", HttpStatus.OK);
        else
            return new ResponseEntity<>("로그아웃 실패", HttpStatus.INTERNAL_SERVER_ERROR);
    }


    /*@PostMapping(value = "/quit")
    public ResponseEntity<String> quit(@RequestBody String password){
        if(userService.quit(password))
            return new ResponseEntity<>("회원탈퇴 성공", HttpStatus.OK);
        else
            return new ResponseEntity<>("회원탈퇴 실패", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    */

    public MainController() {
    	
    	try {
			signUps(new UserDTO("a", "b", "c", "d", "e"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public static void main(String[] args) {
    	
    	new MainController();
    	
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<String> signUps(@RequestBody UserDTO user) throws SQLException {
        //매개변수를 db에 등록하기위해 Service의 signUp호출
        if(userService.signUp(user))
            //ResponseEntity HttpRequest에 대한 응답 데이터를 포함하는 클래스
            return new ResponseEntity<>("회원가입 성공", HttpStatus.OK);
        else
            return new ResponseEntity<>("회원가입 실패", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody UserDTO user) throws SQLException {
        if(userService.login(user))
            return new ResponseEntity<>("Success", HttpStatus.OK);
        else
            return new ResponseEntity<>("Fail", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}