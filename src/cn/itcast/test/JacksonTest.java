package cn.itcast.test;

import cn.itcast.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class JacksonTest {


    //java对象转为json字符串
    @Test
    public void test1() throws IOException {
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");

        //创建Jackson的核心对象    ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //3.转换
        /*
                转换方法：
                    writerValue(参数1，obj）；
                        参数1：
                            File:将obj对象转换为json字符串，并存入文件中
                            Writer:将obj对象转为json字符串，并将json数据填充到字符串输出流中
                            OutputStream:将obj对象转为json字符串，并将json数据填充到字节输出流中

                    writerValueAsString(obj):将对象转换为json字符串
         */

        //String json = mapper.writeValueAsString(p);
        //System.out.println(json);

        //writerValue,将数据写到d：//a.txt文件中
        mapper.writeValue(new File("d://a.txt"),p);

    }

    @Test
    public void test2() throws IOException {
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());

        //转换
        ObjectMapper mapp = new ObjectMapper();
        String json = mapp.writeValueAsString(p);

        System.out.println(json);

    }

    @Test
    public void test3() throws IOException {
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());

        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(23);
        p1.setGender("男");
        p1.setBirthday(new Date());

        Person p2 = new Person();
        p2.setName("张三");
        p2.setAge(23);
        p2.setGender("男");
        p2.setBirthday(new Date());


        List<Person> list = new ArrayList<Person>();
        list.add(p);
        list.add(p1);
        list.add(p2);

        //转换
        ObjectMapper mapp = new ObjectMapper();
        String json = mapp.writeValueAsString(list);

        System.out.println(json);

    }

    @Test
    public void test4() throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();

        map.put("name","张三");
        map.put("age",23);
        map.put("gender","男");

        //转换
        ObjectMapper mapp = new ObjectMapper();
        String json = mapp.writeValueAsString(map);

        System.out.println(json);

    }

    @Test
    public void test5() throws IOException {
        String json = "{\"name\":\"张三\",\"age\":23,\"gender\":\"男\",\"birthday\":\"2019-09-05\"}";

        ObjectMapper ma = new ObjectMapper();

        Person person = ma.readValue(json, Person.class);

        System.out.println(person);

    }

}
