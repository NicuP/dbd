package dbd.task5.logic.api.impl;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import dbd.task5.db.mongo.config.MongoConfig;
import dbd.task5.db.mongo.repository.AssignmentRepository;
import dbd.task5.domain.mongo.Assignment;
import dbd.task5.domain.mongo.Homework;
import dbd.task5.logic.api.AssignmentLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 5/28/13
 * Time: 9:00 PM
 * User: nicu
 */
@Component
public class AssignmentLogicImpl implements AssignmentLogic {
    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private MongoConfig mongoConfig;

    public Assignment addAssignment(Assignment assignment) throws Exception {
        saveFile(assignment.getImage(), "image-user" + assignment.getUserId() + "-" + assignment.getId(), "photo");

        List<CommonsMultipartFile> attachments = assignment.getAttachments();
        int i = 0;
        for (CommonsMultipartFile attachment : attachments) {
            saveFile(attachment, "attachment-user" + assignment.getUserId() + "-number-" + i + "-" +
                    assignment.getId(), "attachment");
        }

        return assignmentRepository.save(assignment);
    }

    private void saveFile(CommonsMultipartFile file, String identifier, String namespace) throws Exception {
        Mongo mongo = mongoConfig.mongo();
        DB db = mongo.getDB(mongoConfig.getDatabaseName());

        GridFS gfsPhoto = new GridFS(db, namespace);

        // get image file from local drive
        GridFSInputFile gfsFile = gfsPhoto.createFile(file.getInputStream());

        // set a new filename for identify purpose
        gfsFile.setFilename(identifier);

        // save the image file into mongoDB
        gfsFile.save();
    }

    private String getFile(String identifier) throws Exception {
        Mongo mongo = mongoConfig.mongo();
        DB db = mongo.getDB(mongoConfig.getDatabaseName());

        // create a "photo" namespace
        GridFS gfsPhoto = new GridFS(db, "photo");

        GridFSDBFile imageForOutput = gfsPhoto.findOne(identifier);

//        String file = "d:\\DBD\\images\\" + identifier + ".png";
        String file = identifier;

        // save it into a new image file
        imageForOutput.writeTo(file);

        return file;
    }
}
