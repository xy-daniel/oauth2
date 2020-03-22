package org.javaboy.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Oauth2Application {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2Application.class, args);
    }

    /*
    获取token
    post---->localhost:8080/oauth/token?username=javaboy&password=123&grant_type=password&client_id=password&scope=all&client_secret=123
    result---->{
                    "access_token": "f9117194-6efb-4ece-b7fb-a555724b25db",
                    "token_type": "bearer",
                    "refresh_token": "cfc0089e-75f2-4e8e-8845-9f91002e11e4",
                    "expires_in": 1799,
                    "scope": "all"
                }
     资源访问
     get---->http://localhost:8080/hello?access_token=f9117194-6efb-4ece-b7fb-a555724b25db
     result---->hello oauth2/  {
                                    "error": "access_denied",
                                    "error_description": "Access is denied"
                                }
     刷新token
     post---->http://localhost:8080/oauth/token?grant_type=refresh_token&refresh_token=cfc0089e-75f2-4e8e-8845-9f91002e11e4&client_id=password&client_secret=123
     result---->{
                    "access_token": "991a1152-fd0c-46b1-8e51-0afb27b44ffe",
                    "token_type": "bearer",
                    "refresh_token": "cfc0089e-75f2-4e8e-8845-9f91002e11e4",
                    "expires_in": 1799,
                    "scope": "all"
                }

     */
}
