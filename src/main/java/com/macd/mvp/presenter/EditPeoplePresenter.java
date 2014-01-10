package com.macd.mvp.presenter;

import com.google.common.eventbus.EventBus;
import com.google.inject.assistedinject.Assisted;
import com.macd.domain.People;
import com.macd.domain.PeopleDirectory;
import com.macd.mvp.events.PeopleChangeEvent;
import com.macd.mvp.view.SwingJDialogDisplay;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: marcel
 * Date: 10/31/12
 * Time: 3:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class EditPeoplePresenter {

    private EditPeoplePresenter.Display display;
    private People                      people;
    private PeopleDirectory             directory;
    private EventBus                    eventBus;



    @Inject
    EditPeoplePresenter( Display display, PeopleDirectory directory, EventBus eventBus, @Assisted @Nullable People people ) {
        this.display = display;
        this.directory = directory;
        this.eventBus = eventBus;
        this.people = people;
        display.setPeople( people );
        this.eventBus.register( this );
        init();

    }


    public void init() {

        this.display.getSaveButton().addActionListener( new ActionListener() {

            public void actionPerformed( ActionEvent e ) {
                directory.add( display.getPeople() );
                eventBus.post( new PeopleChangeEvent( display.getPeople() ) );
                display.closeDialog();
            }
        } );

        this.display.getCancelButton().addActionListener( new ActionListener() {

            public void actionPerformed( ActionEvent e ) {
                display.closeDialog();
            }
        } );

    }

    public Display getDisplay() {
        return display;
    }



    public interface Display extends SwingJDialogDisplay {

        JButton getSaveButton();

        People getPeople();

        public JButton getCancelButton();

        public void showDialog();

        public void closeDialog();

        public void setPeople( People people );


    }
}
