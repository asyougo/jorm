package com.liang.proxy;

import ca.krasnay.sqlbuilder.InsertCreator;
import ca.krasnay.sqlbuilder.Predicate;
import ca.krasnay.sqlbuilder.Predicates;
import ca.krasnay.sqlbuilder.SelectCreator;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class TemplateDao<T> {
    public int put(T model, Class<T> clazz) throws SQLException {
        // 遍历clazz的所有字段，生成insert语句
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb");

        Field[] fields = clazz.getFields();
        new InsertCreator("class_alpha")
                .setValue("name", "张三")
                .setValue("age", 10)
                .createPreparedStatement(connection).execute();
        return 1;
    }

    public List<T> search(T model) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb");
        new SelectCreator().
                from("class_alpha").
                where(Predicates.and(
                        Predicates.eq("name", "张三"),
                        Predicates.eq("name", "张三")
                        )
                ).createPreparedStatement(connection);
        SelectCreator b = new SelectCreator();
//        b.column("xx").where(b.and(b.equals("xx", "b")))
        return null;
    }

//    public AggerationResult
//    T get(T model);
//    List<T> list(T model);
//    void delete(T model);
//    void update(T model);
}
