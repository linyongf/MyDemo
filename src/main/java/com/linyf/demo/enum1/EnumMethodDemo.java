package com.linyf.demo.enum1;

public class EnumMethodDemo {
    enum Color {RED, GREEN, BLUE;}

    public static void main(String args[]) {
        System.out.println("=========== Print all Color ===========");
        for (Color c : Color.values()) {
            System.out.println(c + " ordinal: " + c.ordinal());
        }
        System.out.println("======================");
        Color green = Color.GREEN;
        System.out.println("green name(): " + green.name());
        System.out.println("green getDeclaringClass(): " + green.getDeclaringClass());
        System.out.println("green hashCode(): " + green.hashCode());
        System.out.println("green compareTo Color.GREEN: " + green.compareTo(Color.GREEN));
        System.out.println("green equals Color.GREEN: " + green.equals(Color.GREEN));
        System.out.println("green equals 1: " + green.equals(1));
        System.out.println("green == Color.BLUE: " + (green == Color.BLUE));
    }
}
