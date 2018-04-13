/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import static com.imos.sample.model.tables.Author.AUTHOR;
import static com.imos.sample.model.tables.Book.BOOK;
import java.sql.Connection;
import java.sql.DriverManager;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

/**
 *
 * @author ameher
 */
public class Main {

    public static void main(String[] args) {
        String userName = "root";
        String password = "rockwell9+";
        String url = "jdbc:mysql://localhost:3306/library?useSSL=false";

        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
            Result<Record> result = create.select().from(AUTHOR).fetch();

            System.out.println("Author");
            result.forEach((r) -> {
                Integer id = r.getValue(AUTHOR.ID);
                String firstName = r.getValue(AUTHOR.FIRST_NAME);
                String lastName = r.getValue(AUTHOR.LAST_NAME);

                System.out.println("ID: " + id + " first name: " + firstName + " last name: " + lastName);
            });

            System.out.println("Author and Books");
            result = create.select()
                    .from(AUTHOR)
                    .join(BOOK)
                    .on(BOOK.AUTHOR_ID.eq(AUTHOR.ID))
                    .fetch();
            result.forEach((r) -> {
                Integer id = r.getValue(AUTHOR.ID);
                String firstName = r.getValue(AUTHOR.FIRST_NAME);
                String lastName = r.getValue(AUTHOR.LAST_NAME);
                String title = r.getValue(BOOK.TITLE);
                String language = r.getValue(BOOK.LANGUAGE);

                System.out.println("ID: " + id + " first name: " + firstName + " last name: " + lastName
                        + " title: " + title + " language: " + language);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
