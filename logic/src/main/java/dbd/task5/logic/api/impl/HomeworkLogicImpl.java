package dbd.task5.logic.api.impl;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;
import dbd.task5.db.mongo.config.MongoConfig;
import dbd.task5.db.mongo.repository.HomeworkRepository;
import dbd.task5.domain.mongo.Homework;
import dbd.task5.logic.api.HomeworkLogic;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Date: 5/28/13
 * Time: 9:00 PM
 * User: nicu
 */
@Component
public class HomeworkLogicImpl implements HomeworkLogic {
    @Autowired
    private HomeworkRepository homeworkRepository;


    @Autowired
    private MongoConfig mongoConfig;
        public Homework addHomework(Homework homework,String userID) throws Exception{
            saveFile(homework.getFile(), homework.getFile()+"-"+userID);
            return homework;
        }
         private void saveFile(String filename, String identifier) throws Exception {
        Mongo mongo = mongoConfig.mongo();
        DB db = mongo.getDB(mongoConfig.getDatabaseName());

        File imageFile = new File(filename);

        // create a "photo" namespace
        GridFS gfsPhoto = new GridFS(db, "homework");

        // get image file from local drive
        GridFSInputFile gfsFile = gfsPhoto.createFile(imageFile);

        // set a new filename for identify purpose
        gfsFile.setFilename(identifier);

        // save the image file into mongoDB
        gfsFile.save();
    }

}
