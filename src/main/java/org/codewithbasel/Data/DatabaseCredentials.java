package org.codewithbasel.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class DatabaseCredentials {

    private static DatabaseCredentials INSTANCE;

    private String user;
    private String password;
    private String url;

    public static DatabaseCredentials initialize(String url) throws IOException {
        INSTANCE = new DatabaseCredentials(Paths.get(url));
        return INSTANCE;
    }

    public static DatabaseCredentials getInstance() {
        if(INSTANCE == null) throw new IllegalStateException("please initial object first");
        return INSTANCE;
    }


    private DatabaseCredentials(Path path) throws IOException {
        Properties properties = new Properties();
        properties.load(Files.newBufferedReader(path));
        user = properties.getProperty("username");
        password = properties.getProperty("password");
        url = properties.getProperty("url");
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }
}
