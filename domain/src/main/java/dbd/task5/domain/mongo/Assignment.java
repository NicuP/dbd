package dbd.task5.domain.mongo;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Assignment {
    @Id
    private Long id;
    private String name;
    //add whatever you need here; if the field is a new class and you need it as another instance,
    //not to be embedded in this field, just annotate with @DBRef

    private Long userId;

    private String text;
    private String image;
    private List<String> attachments;

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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<String> attachments) {
        this.attachments = attachments;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Assignment homework = (Assignment) o;

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
