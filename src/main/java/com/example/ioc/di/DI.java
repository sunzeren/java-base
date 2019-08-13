package com.example.ioc.di;

import org.springframework.boot.web.servlet.server.Session;

/**
 * Author by Sun, Date on 2019/3/14.
 * PS: Not easy to write code, please indicate.
 * 使用依赖注入的案例
 * 依赖注入的观念就是将所有东西先在“外面”准备好，然后再带入“内部”的程式中
 * 如此一来你就能够在检视程式码的时候，一目了然地知道这个程式依赖著哪些类
 */
public class DI {

    //依赖注入的观念就是将所有东西先在“外面”准备好，然后再带入“内部”的程式中
    public void login(String username,String password){
        Database database = new Database("root", "root");
        Session session = new Session();
        Auth auth = new Auth(database,session);
        auth.validate(username,password);
    }


    class Auth{
        Database database;
        Session session;

        public Auth(Database database, Session session) {
            this.database = database;
            this.session = session;
        }

        public void validate(String username, String password) {
            if (database.where(username, password)) {
                saveSession(session);
            }else{
                return ;
            }
        }
        public void saveSession(Session session){
            //saveSession
        }
    }


    public class Database{
        String dataBaseUri;
        String DataBasePassword;

        public Database(String dataBaseUrl, String dataBasePassword) {
            dataBaseUri = dataBaseUrl;
            DataBasePassword = dataBasePassword;
        }

        public boolean where(String username, String password){
            //检查账号密码是否正确
            if(true){
                return true;
            }
            return false;
        }
    }

}
