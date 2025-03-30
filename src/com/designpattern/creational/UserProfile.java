package com.designpattern.creational;

/*
The Builder Pattern is particularly useful when creating objects with many optional parameters,
complex configurations, or readability concerns.

Example Without Builder Pattern: The Problem
Suppose we have a Car class that has multiple optional features like color, engineType, sunroof, and automaticTransmission.
Without the Builder Pattern, we typically use constructor overloading or setter methods, both of which lead to problems:

If your object has only 2-3 parameters, a simple constructor is fine. But if you have 5+ parameters (especially optional ones), the Builder Pattern is the best choice! 🎯

Would you like another example with a different use case? 😊
*/
public class UserProfile {

    private String name;
    private String email;
    private String phone;
    private String address;
    private int age;

    private UserProfile(UserProfileBuilder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.phone = builder.phone;
        this.address = builder.address;
        this.age = builder.age;
    }

    public static class  UserProfileBuilder {
        private String name;
        private String email;
        private String phone;
        private String address;
        private int age;

        public UserProfileBuilder(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public UserProfileBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserProfileBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public UserProfileBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public UserProfile build() {
            return new UserProfile(this);
        }

    }
    @Override
    public String toString() {
        return String.format("UserProfile [ name : %s, email : %s, phone : %s, address : %s, age : %d ]", name, email, phone, address, age);
    }

}
