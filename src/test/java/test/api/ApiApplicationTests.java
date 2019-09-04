package test.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
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
	private MockMvc mockMvc;

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserController userController;

	@Autowired
	UserService userService;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
		//List<UserEntity> userList = userService.getAllService();
	}

	//Repositoryのテスト
	@Test
	public void userRepository() {
		List<UserEntity> userList_Repository = userRepository.selectAll();
		assertTrue(userList_Repository != null);
	}

	//ControllerのretrieveUserListメソッドのテスト
	@Test
	public void userControllerTest() throws Exception {
		List<UserEntity> userList = userService.getAllService();
		mockMvc.perform(get("/user/all")) //リクエスト実行
				.andExpect(status().isOk()) //レスポンスのテスト
				.andExpect(view().name("/index.html")) //指定のViewを返すか確認
				.andExpect(model().attribute("userList", userList)); //viewで使う変数を正しくmodelに詰められているかmodelの状態をテスト
	}

	//Serviceのテスト
	@Test
	public void userServiceTest() {
		String keyword = "cmt";
		List<UserEntity> userList_Service_g = userService.getAllService();
		List<UserEntity> userList_Service_f = userService.findUsers(keyword);
		assertTrue(userList_Service_g != null);
		assertTrue(userList_Service_f != null);
		//assertThat(userService.findUsers(keyword), is(""));
	}


}
