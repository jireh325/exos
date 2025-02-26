package divdev.sn.todo_list.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import divdev.sn.todo_list.models.Enums.Status;

@Entity
@Table(name = "TACHE")
public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titre;
    private String description;
    private Status statut;

    public Tache(){

    }

    public Tache(String titre, String description, Status statut){

        this.titre = titre;
        this.description = description;
        this.statut = statut;
        
    }

    public String getTitre(){
        return titre;
    }

    public String getDescription(){
        return description;
    }

    public Status getstatut(){
        return statut;
    }

    public void setTitre(String titre){
        this.titre = titre;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setStatut(Status statut){
        this.statut = statut;
    }

}
