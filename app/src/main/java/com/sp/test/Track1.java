    package com.sp.test;

class Track1 {
// Alt+ insert to get getters and setters.

   public String getName() {
        return name;
    }

    public String getInstructor() {
        return instructor;
    }

    private String name;
    private String instructor;

    Track1(String name, String instructor){

        this.name = name;
        this.instructor=instructor;

    }
}
