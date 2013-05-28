package dbd.task5.domain.mongo;

import org.springframework.data.annotation.Id;

/**
 * Created with IntelliJ IDEA.
 * Date: 5/28/13
 * Time: 8:33 PM
 * User: nicu
 */
public class Homework {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Homework homework = (Homework) o;

        if (id != null ? !id.equals(homework.id) : homework.id != null) return false;
        if (name != null ? !name.equals(homework.name) : homework.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
