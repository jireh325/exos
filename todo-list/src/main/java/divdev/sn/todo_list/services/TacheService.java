package divdev.sn.todo_list.services;

import divdev.sn.todo_list.models.Tache;
import divdev.sn.todo_list.repository.TacheRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TacheService {

    private TacheRepository tacheRepository;

    public TacheService(TacheRepository tacheRepository) {
        this.tacheRepository = tacheRepository;
    }

    public Tache createTache(Tache tache) {
        return this.tacheRepository.save(tache);
    }

    public void supprimerTache(int id) {
        this.tacheRepository.deleteById(id);
    }

    public Tache modifierTache(int id, Tache tache) {
     
        Tache tacheExistante = this.tacheRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tâche non trouvée avec l'ID : " + id));
    
        tacheExistante.setTitre(tache.getTitre());
        tacheExistante.setDescription(tache.getDescription());
        tacheExistante.setStatut(tache.getstatut());
    
        return this.tacheRepository.save(tacheExistante);
    }
    

    public Tache modifierTitreTache(int id, Tache titre) {
        Tache tache = this.tacheRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tâche non trouvée avec l'ID : " + id));
        tache.setTitre(titre.getTitre());
        return this.tacheRepository.save(tache);
    }

    public List<Tache> listerTaches() {
        return this.tacheRepository.findAll();
    }

    public Tache listerTache(int id) {
        return this.tacheRepository.findById(id).orElseThrow();
    }
}