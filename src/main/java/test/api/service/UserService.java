package test.api.service;

import org.apache.ibatis.annotations.Param;
import test.api.entity.UserEntity;

import java.util.List;

public interface UserService {
    //全件取得
    public List<UserEntity> getAllService();
    //検索

}
