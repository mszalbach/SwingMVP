package com.macd.mvp.presenter;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.macd.domain.Gender;
import com.macd.domain.People;
import com.macd.domain.PeopleDirectory;
import com.macd.mvp.events.PeopleChangeEvent;
import com.macd.mvp.events.PeopleEditEvent;
import com.macd.mvp.events.SortUserEvent;
import com.macd.mvp.view.SwingDisplay;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marcel
 * Date: 10/31/12
 * Time: 11:01 AM
 * To change this template use File | Settings | File Templates.
 */
@Singleton
public class AllPeoplePresenter {

    private Display         display;
    private PeopleDirectory directory;

    private EventBus eventBus;



    @Inject
    public AllPeoplePresenter( Display display, PeopleDirectory directory, EventBus eventBus ) {
        this.directory = directory;
        this.display = display;
        this.eventBus = eventBus;
        this.eventBus.register( this );
        init();
    }



    @Subscribe
    public void recordCustomerChange( SortUserEvent event ) {
        sort( event.getGender() );
    }



    @Subscribe
    public void recordCustomerChange( PeopleChangeEvent event ) {
        clearTable();
        addAllToTable( directory.getAll() );
    }



    private void init() {
        this.display.getEditButton().addActionListener( new ActionListener() {

            public void actionPerformed( ActionEvent e ) {

                eventBus.post( new PeopleEditEvent( display.getPeople() ) );
            }
        } );

        this.display.getFilterComboBox().addActionListener( new ActionListener() {

            public void actionPerformed( ActionEvent e ) {

                eventBus.post( new SortUserEvent( ( Gender )( ( JComboBox )e.getSource() ).getSelectedItem() ) );
                //sort( ( Gender )( ( JComboBox )e.getSource() ).getSelectedItem() );
            }
        } );

        List<People> peopleList = directory.getAll();

        addAllToTable( peopleList );

    }



    private void sort( Gender gender ) {
        clearTable();
        List<People> sortedList = new ArrayList<People>();
        List<People> peopleList = directory.getAll();
        switch ( gender ) {

            case NONE:
                sortedList = peopleList;
                break;
            case MALE:
            case FEMALE:
                for ( People people : peopleList ) {
                    if ( people.getGender() == gender ) {
                        sortedList.add( people );
                    }
                }
                break;
        }
        addAllToTable( sortedList );
    }



    private void clearTable() {
        try {
            DefaultTableModel dm = ( ( DefaultTableModel )this.display.getPeopleTable().getModel() );
            dm.getDataVector().clear();
        } catch ( Exception e ) {
        }
    }



    private void addAllToTable( List<People> peopleList ) {
        JTable table = this.display.getPeopleTable();
        for ( People people : peopleList ) {
            Object[] row = { people.getName(), people.getSurname(), people.getGender() };


            ( ( DefaultTableModel )table.getModel() ).addRow( row );

        }
        ( ( DefaultTableModel )table.getModel() ).fireTableRowsInserted( 0, 0 );

    }



    public Display getDisplay() {
        return display;
    }



    public interface Display
            extends SwingDisplay {

        JButton getEditButton();



        JComboBox getFilterComboBox();



        People getPeople();



        JTable getPeopleTable();

    }

}
