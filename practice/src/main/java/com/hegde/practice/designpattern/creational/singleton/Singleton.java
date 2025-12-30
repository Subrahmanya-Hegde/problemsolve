package com.hegde.practice.designpattern.creational.singleton;

public class Singleton {

    private final int value;
    private Singleton(){
        this.value = 0;
    }

    public static Singleton getInstance(){
        return SingletonObjectHolder.INSTANCE;
    }

    private static class SingletonObjectHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
}
