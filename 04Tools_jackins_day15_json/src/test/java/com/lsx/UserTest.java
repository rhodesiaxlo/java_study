package com.lsx;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lsx.domain.User;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class UserTest {

    @Test
    /**
     * object to json string
     */
    public void stringToObjectTest() {
        ObjectMapper mapper = new ObjectMapper();
        User u = new User("lushixin", 20, new Date());

        try {
            String s = mapper.writeValueAsString(u);
            System.out.println("object to json string " + s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }

    @Test
    /*
    writevalue
     */
    public void objToStringTest() {
        User u = new User("name", 20 , new Date());
        System.out.println("user info " + u);
        ObjectMapper mapper = new ObjectMapper();
        try {
            FileOutputStream fos = new FileOutputStream("json.txt");
            mapper.writeValue(fos, u);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void writeValueTest() {
        User u = new User("tom cruise", 50, new Date());
        ObjectMapper mapper = new ObjectMapper();
        FileWriter fw = null;
        try {
            fw = new FileWriter("writer.txt");
            mapper.writeValue(fw, u);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    /**
     * 字符串转换为 对象
     */
    public void stringToObject() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            User user = mapper.readValue("{\"name\":\"lushixin\",\"age\":20,\"birthday\":\"2019-08-08\"}", User.class);
            System.out.println(" json string to object " + user);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
