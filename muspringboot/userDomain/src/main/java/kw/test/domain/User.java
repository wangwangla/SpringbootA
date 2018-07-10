package kw.test.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * auther   kangwang
 * 2018/7/8
 */
@Entity
public class User implements Serializable {
    /*	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.TABLE,generator="table_gen")
	@TableGenerator(
			name = "table_gen",
		    table="fendo_generator",
		    pkColumnName="seq_name",     //指定主键的名字
		    pkColumnValue="fendos",      //指定下次插入主键时使用默认的值
		    valueColumnName="seq_id",    //该主键当前所生成的值，它的值将会随着每次创建累加
		    initialValue = 1,            //初始化值
		    allocationSize=1             //累加值
*/
    @Id
    @GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(generator="idGenerator")/*这句是必须的，不写会有问题。*/
    private String id;
    private String username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;


    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;

    }

    public User() {
    }
}
