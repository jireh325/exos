package divdev.sn.todo_list.models;

import divdev.sn.todo_list.models.Enums.Status;

import jakarta.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;



@Entity
@Table(name = "users")
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String pass;
    @Enumerated(EnumType.STRING)
    private Status statut;


    public User(){

    }

    public User(String email, String nom, String pass, String prenom, Status statut) {
        this.email = email;
        this.nom = nom;
        this.pass = pass;
        this.prenom = prenom;
        this.statut = statut;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }


    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public int getId(){
        return id;
    }

    public String getNom(){
        return nom;
    }

    public String getPrenom(){
        return prenom;
    }

    public String getEmail(){
        return email;
    }

    @Override
    public String getPassword(){
        return pass;
    }

    public Status getStatut(){
        return statut;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPass(String pass){
        this.pass = pass;
    }

    public void setStatut(Status statut){
        this.statut = statut;
    }


}
