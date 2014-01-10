package com.macd.mvp.presenter;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Injector;
import com.macd.domain.People;
import com.macd.mvp.Main;
import com.macd.mvp.events.PeopleEditEvent;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JFrame;

/**
 * Created with IntelliJ IDEA.
 * User: marcel
 * Date: 11/7/12
 * Time: 11:34 AM
 * To change this template use File | Settings | File Templates.
 */
@Singleton
public class MainPresenter
        extends JFrame {

    @Inject
    private EditPeoplePresenterFactory editPeoplePresenterFactory;



    @Inject
    MainPresenter( EventBus bus ) {

        bus.register( this );
    }



    @Subscribe
    public static void deadEventQueue( DeadEvent e ) {
        throw new IllegalStateException( "Found event "+ e.getEvent() + " from source " + e.getSource() + " which is not handled." );
    }



    @Subscribe
    public void openEditDialog( PeopleEditEvent event ) {

        People people = event.getPeople();

        EditPeoplePresenter editPeople = editPeoplePresenterFactory.create( people );

        editPeople.getDisplay().setPeople( null );
        editPeople.getDisplay().showDialog();
    }



    public void init() {
        Injector injector = Main.GuiceFactory.getInjector();


        AllPeoplePresenter presenter = injector.getInstance( AllPeoplePresenter.class );

        this.add( presenter.getDisplay().asComponent() );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setVisible( true );
        this.pack();

    }

}
