package test.api.entity;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="db_user")
@Data
public class UserEntity {
    @Id
    @Column(name="id")
    private int id;
    @Column(name="username")
    private String username;
    @Column(name="dte")
    private String dte;
    @Column(name="email")
    private String email;

    @Override
    public String toString() { //ToStringBuilder使いたい場合は、dependenciesにorg.apache.commons的なのを追加する必要あり
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }


}

