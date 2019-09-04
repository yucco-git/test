package test.api;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import test.api.controller.UserController;
import test.api.entity.UserEntity;
import test.api.repository.UserRepository;
import test.api.service.UserService;
import java.util.List;

//@RunWith(SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApiApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserController userController;

	@Autowired
	UserService userService;

	@Test
	public void userRepository() {
		List<UserEntity> userList_Repository = userRepository.selectAll();
		assertTrue(userList_Repository != null);
	}

	@Test
	public void UserController() {
		List<UserEntity> userList_Controller = userController.retrieveUserList();
		assertTrue(userList_Controller != null);
	}

	@Test
	public void UserService() {
		List<UserEntity> userList_Service = userService.getAllService();
		assertTrue(userList_Service != null);
	}

}
