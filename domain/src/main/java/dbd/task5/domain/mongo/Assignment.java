package dbd.task5.domain.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

public class Assignment {
    @Id
    private String id;
    private String name;
    //add whatever you need here; if the field is a new class and you need it as another instance,
    //not to be embedded in this field, just annotate with @DBRef

    private Long userId;

    private String text;

    @Transient
    private CommonsMultipartFile image;

    @Transient
    private List<CommonsMultipartFile> attachments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public CommonsMultipartFile getImage() {
        return image;
    }

    public void setImage(CommonsMultipartFile image) {
        this.image = image;
    }

    public List<CommonsMultipartFile> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<CommonsMultipartFile> attachments) {
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
