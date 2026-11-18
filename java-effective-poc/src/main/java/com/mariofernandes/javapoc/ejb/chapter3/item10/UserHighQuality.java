package com.mariofernandes.javapoc.ejb.chapter3.item10;

public final class UserHighQuality {
    private final String email;
    private final int age;
    private final float salary;
    private String name;

    public UserHighQuality(String email, int age, float salary) {
        this.email = email;
        this.age = age;
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public float getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        // 1. Check if the objects are the same reference
        if (this == o) return true;
        // 2. Check if the object is of the correct type
        if (!(o instanceof UserHighQuality)) return false;
        // 3. Cast the object to the correct type
        UserHighQuality user = (UserHighQuality) o;
        // 4. Compare the fields
        return this.age == user.age
                // 4.1. no need to be creative, use the equals method of the String class
                && this.email.equals(user.email)
                // 4.2. Compare the float field using Float.compare to handle NaN and -0.0/+0.0 correctly
                && Float.compare(this.salary, user.salary) == 0;
    }

    @Override
    public int hashCode() {
        // it works but it is not the best implementation.
        return 666;
    }
}
