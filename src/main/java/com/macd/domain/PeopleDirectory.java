package com.macd.domain;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marcel
 * Date: 10/31/12
 * Time: 10:51 AM
 * To change this template use File | Settings | File Templates.
 */
@Singleton
public class PeopleDirectory {

    private List<People> directory = new ArrayList<People>();



    public PeopleDirectory() {
        directory.add( new People( "Marcel", "Szalbach", Gender.MALE ) );
        directory.add( new People( "Betty", "Boo", Gender.FEMALE ) );
    }



    public void add( People people ) {
        directory.add( people );
    }



    public void remove( People people ) {
        directory.remove( people );
    }



    public List<People> getAll() {
        return Collections.unmodifiableList( directory );
    }


}
