package divdev.sn.todo_list.domain.model;
import divdev.sn.todo_list.domain.model.Enum.Status;

public class Todo {

    private String id;
    private String title;
    private String description;
    private Status status;

    public Todo(String id, String description, String title, Status status) {
        this.id = id;
        this.description = description;
        this.title = title;
        this.status = status;
    }

    public Todo() {
    }


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
