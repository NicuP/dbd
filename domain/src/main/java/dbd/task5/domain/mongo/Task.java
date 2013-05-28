package dbd.task5.domain.mongo;

import org.springframework.data.annotation.Id;

/**
 * Created with IntelliJ IDEA.
 * Date: 5/28/13
 * Time: 8:29 PM
 * User: nicu
 */
public class Task {
    @Id
    private Long id;
    private String name;
    //add whatever you need here; if the field is a new class and you need it as another instance,
    //not to be embedded in this field, just annotate with @DBRef

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
