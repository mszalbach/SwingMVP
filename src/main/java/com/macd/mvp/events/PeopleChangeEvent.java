package com.macd.mvp.events;

import com.macd.domain.People;

/**
 * Created with IntelliJ IDEA.
 * User: marcel
 * Date: 10/31/12
 * Time: 3:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class PeopleChangeEvent {

    private People people;



    public PeopleChangeEvent( People people ) {
        this.people = people;

    }



    public People getPeople() {
        return people;
    }
}
