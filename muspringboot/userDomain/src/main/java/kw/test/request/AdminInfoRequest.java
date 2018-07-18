package kw.test.request;

/**
 * auther   kangwang
 * 20918/7/17
 */
public class AdminInfoRequest {
    private String username;
    private String password;

    public AdminInfoRequest() {
    }

    @Override
    public String toString() {
        return "AdminInfoRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
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

    public AdminInfoRequest(String username, String password) {

        this.username = username;
        this.password = password;
    }
}
