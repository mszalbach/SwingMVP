package com.macd.domain;

/**
 * Created with IntelliJ IDEA.
 * User: marcel
 * Date: 10/31/12
 * Time: 10:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class People {

    private String name;
    private String surname;
    private Gender gender;



    public People( String name, String surname, Gender gender ) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }



    public String getName() {
        return name;
    }



    public void setName( String name ) {
        this.name = name;
    }



    public String getSurname() {
        return surname;
    }



    public void setSurname( String surname ) {
        this.surname = surname;
    }



    public Gender getGender() {
        return gender;
    }



    public void setGender( Gender gender ) {
        this.gender = gender;
    }



    @Override
    public boolean equals( Object o ) {
        if ( this == o ) {
            return true;
        }
        if ( !( o instanceof People ) ) {
            return false;
        }

        People people = ( People )o;

        if ( gender != people.gender ) {
            return false;
        }
        if ( name != null ? !name.equals( people.name ) : people.name != null ) {
            return false;
        }
        if ( surname != null ? !surname.equals( people.surname ) : people.surname != null ) {
            return false;
        }

        return true;
    }



    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + ( surname != null ? surname.hashCode() : 0 );
        result = 31 * result + ( gender != null ? gender.hashCode() : 0 );
        return result;
    }
}
