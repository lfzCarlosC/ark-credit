package com.cryptal.ark.db;

import java.util.ResourceBundle;

/**
 * 可以重构，这里只是为了表示可以把关于db连接的类发到此
 */
public class DbResourcesConfiguration
{
    private static Object lock = new Object();
    private static DbResourcesConfiguration config = null;
    private static ResourceBundle rb = null;
    private static final String CONFIG_FILE = "database";

    private DbResourcesConfiguration()
    {
        rb = ResourceBundle.getBundle("database");
    }

    public static DbResourcesConfiguration getInstance() {
        synchronized (lock) {
            if (config == null) {
                config = new DbResourcesConfiguration();
            }
        }
        return config;
    }

    public String getValue(String key) {
        return rb.getString(key);
    }

    public static void main(String[] args) {
        System.out.println(getInstance().getValue("REGISTER"));
    }
}