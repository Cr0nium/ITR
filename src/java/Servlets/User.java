
package Servlets;


public class User {

    private String userName;
    private String password;
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public void setUsername(String username) {
        this.userName = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
            
    public String getUsername() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
    
}
