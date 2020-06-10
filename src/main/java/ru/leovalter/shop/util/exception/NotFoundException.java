package ru.leovalter.shop.util.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String arg) {
        System.out.println(arg + " Not Found");
    }
}
