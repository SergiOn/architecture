package com.so.authentication;

import io.quarkus.runtime.LaunchMode;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Main {

    public static void main(final String[] args) {
        System.out.println("Running application");
        System.out.println("Launch Mode: " + LaunchMode.current());
        Quarkus.run(args);
    }
}
