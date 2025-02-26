package divdev.sn.todo_list.responses;

public class LoginResponse {
    private String token;

    private long expiresIn;

    public LoginResponse(String token, long expiresIn){
        this.token = token;
        this.expiresIn = expiresIn;
    }

    public String getToken() {
        return token;
    }

    public long getExpiresIn(){
        return expiresIn;
    }

    public void setToken(String token){
        this.token = token;
    }

    public void setExpiresIn(long expiresIn){
        this.expiresIn = expiresIn;
    }
}
