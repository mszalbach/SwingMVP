package com.macd.mvp.events;

import com.macd.domain.Gender;

/**
 * Created with IntelliJ IDEA.
 * User: marcel
 * Date: 10/31/12
 * Time: 3:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class SortUserEvent {

    private Gender gender;



    public SortUserEvent( Gender gender ) {
        this.gender = gender;
    }



    public Gender getGender() {
        return gender;
    }
}
