package dbd.web.dto;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class AssignmentDTO {

    private String name;
    private String text;
    private CommonsMultipartFile image;
    private CommonsMultipartFile attachment1;
    private CommonsMultipartFile attachment2;
    private CommonsMultipartFile attachment3;
    private CommonsMultipartFile attachment4;
    private CommonsMultipartFile attachment5;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CommonsMultipartFile getImage() {
        return image;
    }

    public void setImage(CommonsMultipartFile image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public CommonsMultipartFile getAttachment1() {
        return attachment1;
    }

    public void setAttachment1(CommonsMultipartFile attachment1) {
        this.attachment1 = attachment1;
    }

    public CommonsMultipartFile getAttachment2() {
        return attachment2;
    }

    public void setAttachment2(CommonsMultipartFile attachment2) {
        this.attachment2 = attachment2;
    }

    public CommonsMultipartFile getAttachment3() {
        return attachment3;
    }

    public void setAttachment3(CommonsMultipartFile attachment3) {
        this.attachment3 = attachment3;
    }

    public CommonsMultipartFile getAttachment4() {
        return attachment4;
    }

    public void setAttachment4(CommonsMultipartFile attachment4) {
        this.attachment4 = attachment4;
    }

    public CommonsMultipartFile getAttachment5() {
        return attachment5;
    }

    public void setAttachment5(CommonsMultipartFile attachment5) {
        this.attachment5 = attachment5;
    }
}
