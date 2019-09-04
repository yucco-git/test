package test.api.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import test.api.entity.UserEntity;
import test.api.repository.UserRepository;
import test.api.service.UserService;

import java.util.List;
import java.util.Locale;

//@RestController
@Controller
@RequestMapping(path = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private UserRepository repository;


    @RequestMapping(path = "/all")
    public String retrieveUserList(Model model) {
        //LOGGER.debug("[[[ start retrieveUserList() ]]]");
        List<UserEntity> userList = service.getAllService();
        //LOGGER.debug("[[[ end retrieveUseList() ]]] return = {}", userList);
        model.addAttribute("userList", userList);
        return "/index.html";
    }

    // 検索
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView search(@RequestParam("keyword") String keyword) {
    //public String search(Model model, @RequestParam String keyword) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/User/index");
        if (StringUtils.isNotEmpty(keyword)) {
            List<UserEntity> list = service.findUsers(keyword);
            if (CollectionUtils.isEmpty(list)) {
                //String message = msg.getMessage("user.list.empty", null, Locale.JAPAN);
                String message = "non data";
                mv.addObject("emptyMessage", message);
            }
            mv.addObject("list", list);
            //model.addAttribute("userList", list);
            //return "/index.html";
        }
        return mv;
        //return "/index.html";
    }







}


