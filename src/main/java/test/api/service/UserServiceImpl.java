package test.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.api.entity.UserEntity;
import test.api.repository.UserRepository;

import java.util.List;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {
    //private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository repository;

    @Override
    public List<UserEntity> getAllService() {
        //LOGGER.debug("[[[ start getAllService() ]]]");
        List<UserEntity> db_user = repository.selectAll();
        //LOGGER.debug("[[[ end getAllService() ]]] return = {}", users);
        return db_user;
    }
    //検索
    @Override
    public List<UserEntity> findUsers(String keyword) {
        List<UserEntity> selected_user = repository.selectUser(keyword);
        return selected_user;
    }


}



