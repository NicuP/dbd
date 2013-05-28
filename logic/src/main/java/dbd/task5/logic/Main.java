package dbd.task5.logic;

import dbd.task5.logic.config.ApplicationConfig;
import dbd.task5.logic.api.impl.UserLogicImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Date: 5/28/13
 * Time: 9:01 PM
 * User: nicu
 */
/*This is just for purpose of showing that it works; upper layer should autowire the api classes*/
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        UserLogicImpl userLogic = applicationContext.getBean(UserLogicImpl.class);

        if(userLogic == null) {
            System.out.println("Somewhere something somehow went wrong.");
        }
    }
}
