package dbd.web.service;

import dbd.task5.logic.api.AssignmentLogic;
import dbd.web.dto.AssignmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AssignmentService {

    @Autowired
    private AssignmentLogic assignmentLogic;

    public void add(AssignmentDTO assignmentDTO) {

    }

}
