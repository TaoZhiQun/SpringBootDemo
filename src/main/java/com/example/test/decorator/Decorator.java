package com.example.test.decorator;

public abstract class Decorator implements Person{
    private Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public void eat() {
        person.eat();
    }
}
