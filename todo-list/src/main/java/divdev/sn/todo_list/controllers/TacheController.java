package divdev.sn.todo_list.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import divdev.sn.todo_list.services.TacheService;
import java.util.List;
import divdev.sn.todo_list.models.Tache;

@RestController
@RequestMapping(path = "taches")
public class TacheController {

    private final TacheService tacheService;

    public TacheController(TacheService tacheService) {
        this.tacheService = tacheService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tache createTache(@RequestBody Tache tache) {
        return this.tacheService.createTache(tache);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void supprimerTache(@PathVariable int id) {
        tacheService.supprimerTache(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Tache modifierTache(@PathVariable int id, @RequestBody Tache tache) {
        return tacheService.modifierTache(id, tache);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Tache modifierTitreTache(@PathVariable int id, @RequestBody Tache titre) {
        return tacheService.modifierTitreTache(id, titre);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Tache> listerTaches() {
        return tacheService.listerTaches();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Tache listerTache(@PathVariable int id) {
        return tacheService.listerTache(id);
    }
}
