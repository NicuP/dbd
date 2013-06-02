package dbd.web.service;

import dbd.task5.domain.mongo.Assignment;
import dbd.task5.logic.api.AssignmentLogic;
import dbd.web.dto.AssignmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AssignmentService {

    @Autowired
    private AssignmentLogic assignmentLogic;

    public void add(AssignmentDTO assignmentDTO) throws Exception {
        Assignment assignment = new Assignment();

        assignment.setName(assignmentDTO.getName());
        assignment.setText(assignmentDTO.getText());
        assignment.setImage(assignmentDTO.getImage());

        List<CommonsMultipartFile> attachments = new ArrayList<CommonsMultipartFile>();
        addAttachment(assignmentDTO.getAttachment1(), attachments);
        addAttachment(assignmentDTO.getAttachment2(), attachments);
        addAttachment(assignmentDTO.getAttachment3(), attachments);
        addAttachment(assignmentDTO.getAttachment4(), attachments);
        addAttachment(assignmentDTO.getAttachment5(), attachments);

        assignment.setAttachments(attachments);

        assignmentLogic.addAssignment(assignment);
    }

    private void addAttachment(CommonsMultipartFile attachment, List<CommonsMultipartFile> attachments) {
        if (attachment.getSize() > 0) {
            attachments.add(attachment);
        }
    }

}
