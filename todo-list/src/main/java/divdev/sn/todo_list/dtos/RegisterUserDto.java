package divdev.sn.todo_list.dtos;

public class RegisterUserDto {

    private String nom;
    private String prenom;
    private String email;
    private String pass;

    public String getPrenom(){
        return prenom;
    }

    public String getNom(){
        return nom;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return pass;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPassword(String pass) {
        this.pass = pass;
    }
}
