package demo.pojo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created By jiabin on 18-5-8.
 */
public class User implements Serializable {
    private static final long serialVersionUID = -6849794470754667710L;
    private Long id;

    private String username;

    private String password;

    private String nickname;

    private String roles;

    private Date birthday;

    private List<String> interests;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", roles='" + roles + '\'' +
                ", birthday='" + birthday + '\'' +
                ", interests='" + Arrays.toString((interests == null ? Collections.emptyList().toArray() : interests.toArray())) + '\'' +
                '}';
    }
}
