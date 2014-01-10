package com.macd.mvp.view;

import com.macd.domain.Gender;
import com.macd.domain.People;
import com.macd.mvp.presenter.AllPeoplePresenter;
import net.miginfocom.swing.MigLayout;

import javax.inject.Singleton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Created with IntelliJ IDEA.
 * User: marcel
 * Date: 10/31/12
 * Time: 11:00 AM
 * To change this template use File | Settings | File Templates.
 */
@Singleton
public class AllPeopleView
        extends javax.swing.JPanel
        implements AllPeoplePresenter.Display {


    private JButton   editButton;
    private JComboBox filterComboBox;
    private JTable    table;



    public AllPeopleView() {
        this.setName( "People Gui" );
        init();
    }



    private void init() {
        this.setLayout( new MigLayout( "gap 30px" ) );


        editButton = new JButton( "Edit" );

        Gender comboBoxItems[] = Gender.values();
        filterComboBox = new JComboBox( comboBoxItems );


        String[] columnNames = { "First Name",
                                 "Last Name",
                                 "Gender" };

        String[][] data = { };


        DefaultTableModel tbm = new DefaultTableModel( data, columnNames );
        table = new JTable( tbm );
        JScrollPane tableScrollPane = new JScrollPane( table );


        this.add( filterComboBox, "wrap, gapy 10px" );
        this.add( tableScrollPane, "wrap" );
        this.add( editButton );

    }



    public JButton getEditButton() {
        return editButton;
    }



    public JComboBox getFilterComboBox() {
        return filterComboBox;
    }



    public People getPeople() {
        People people = null;
        try {
            int row = getPeopleTable().getSelectedRow();


            String name = ( String )getPeopleTable().getValueAt( row, 0 );
            String surname = ( String )getPeopleTable().getValueAt( row, 1 );
            Gender gender = ( Gender )getPeopleTable().getValueAt( row, 2 );

            people = new People( name, surname, gender );
        } catch ( Exception exception ) {

        }
        return people;
    }



    public JTable getPeopleTable() {
        return this.table;
    }



    public JComponent asComponent() {
        return this;
    }
}
