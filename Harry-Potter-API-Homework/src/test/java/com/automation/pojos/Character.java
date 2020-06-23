package com.automation.pojos;

/**
 * {
 "_id": "5a0fa4daae5bc100213c232e",
 "name": "Hannah Abbott",
 "role": "student",
 "house": "Hufflepuff",
 "school": "Hogwarts School of Witchcraft and Wizardry",
 "__v": 0,
 "ministryOfMagic": false,
 "orderOfThePhoenix": false,
 "dumbledoresArmy": true,
 "deathEater": false,
 "bloodStatus": "half-blood",
 "species": "human"
 }
 */

public class Character {
    private String _id;
    private String name;
    private String role;
    private String house;
    private String school;
    private int __v;
    private boolean ministryOfMagic;
    private boolean orderOfThePhoenix;
    private boolean dumbledoresArmy;
    private boolean deathEater;
    private String bloodStatus;
    private String species;

    public String get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getHouse() {
        return house;
    }

    public String getSchool() {
        return school;
    }

    public int get__v() {
        return __v;
    }

    public boolean isMinistryOfMagic() {
        return ministryOfMagic;
    }

    public boolean isOrderOfThePhoenix() {
        return orderOfThePhoenix;
    }

    public boolean isDumbledoresArmy() {
        return dumbledoresArmy;
    }

    public boolean isDeathEater() {
        return deathEater;
    }

    public String getBloodStatus() {
        return bloodStatus;
    }

    public String getSpecies() {
        return species;
    }

    @Override
    public String toString() {
        return "Character{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", house='" + house + '\'' +
                ", school='" + school + '\'' +
                ", __v=" + __v +
                ", ministryOfMagic=" + ministryOfMagic +
                ", orderOfThePhoenix=" + orderOfThePhoenix +
                ", dumbledoresArmy=" + dumbledoresArmy +
                ", deathEater=" + deathEater +
                ", bloodStatus='" + bloodStatus + '\'' +
                ", species='" + species + '\'' +
                '}';
    }
}
