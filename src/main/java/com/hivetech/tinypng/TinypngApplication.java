package com.hivetech.tinypng;

import com.tinify.Tinify;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TinypngApplication {

    public static void main(String[] args) {
        Tinify.setKey("Nyr3nyYbGzyLpyHxV0CCgskkY6ZlV4xr");
        SpringApplication.run(TinypngApplication.class, args);
    }

}
