package com.wgc.lab.designpattern.template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 8/14/2018.
 */
public class CoffeeWithHook extends CaffeineBeverageWithHook {

    @Override
    public boolean customerWantsCondiments() {
        if ("y".equalsIgnoreCase(getUserInput())) {
            return true;
        } else {
            return false;
        }
    }

    public String getUserInput() {
        String answer = null;
        System.out.println("Would you like milk and sugar with your coffee(y/n):");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (null == answer) {
            return "n";
        }
        return answer;
    }

    @Override
    void brew() {
        System.out.println("Dripping Coffee through filter...");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Sugar and Milk...");
    }
}
