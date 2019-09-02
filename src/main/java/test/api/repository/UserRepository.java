package test.api.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import test.api.entity.UserEntity;
import java.util.List;

@Mapper
@Component
@Repository
public interface UserRepository {
    //全件取得
    public List<UserEntity> selectAll();
    //検索
    @Query("select u from UserEntity u where u.dte like %:keyword% order by u.id asc")
    public List<UserEntity> findUsers(@Param("keyword") String keyword);

}
