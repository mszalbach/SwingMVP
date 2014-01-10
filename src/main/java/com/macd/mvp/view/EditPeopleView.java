package com.macd.mvp.view;

import com.macd.domain.Gender;
import com.macd.domain.People;
import com.macd.mvp.presenter.EditPeoplePresenter;
import net.miginfocom.swing.MigLayout;

import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Frame;

/**
 * Created with IntelliJ IDEA.
 * User: marcel
 * Date: 10/31/12
 * Time: 3:45 PM
 * To change this template use File | Settings | File Templates.
 */

public class EditPeopleView
        extends JDialog
        implements EditPeoplePresenter.Display {


    private JLabel     nameLabel;
    private JTextField nameText;
    private JLabel     surnameLabel;
    private JTextField surnameText;
    private JLabel     genderLabel;
    private JComboBox genderComboBox;
    private JButton    saveButton;
    private JButton    cancelButton;


    @Inject
    EditPeopleView() {
        init();
    }



    public void init() {
        //Create and set up the window.

        this.setLayout( new MigLayout( "gap 30px" ) );


        nameLabel = new JLabel( "Name:" );
        nameText = new JTextField();
        nameText.setColumns( 10 );

        surnameLabel = new JLabel( "Surname:" );
        surnameText = new JTextField();
        surnameText.setColumns( 10 );

        genderLabel = new JLabel( "Gender:" );
        genderComboBox = new JComboBox(Gender.values());

        saveButton = new JButton( "Save" );
        cancelButton = new JButton( "Cancel" );


        this.add( nameLabel );
        this.add( nameText, "wrap" );
        this.add( surnameLabel );
        this.add( surnameText, "wrap" );
        this.add( genderLabel );
        this.add( genderComboBox, "wrap" );
        this.add( saveButton );
        this.add( cancelButton );
    }



    public JButton getSaveButton() {
        return saveButton;
    }



    public People getPeople() {
        return new People( nameText.getText(), surnameText.getText(), Gender.valueOf( genderComboBox.getSelectedItem().toString() ) );
    }



    public JButton getCancelButton() {
        return cancelButton;
    }


    public void setPeople( People people ) {

        if ( people != null ) {
            nameText.setText( people.getName() );
            surnameText.setText( people.getSurname() );
            genderComboBox.setSelectedItem( people.getGender() );
        }
    }



    public void showDialog() {
        this.pack();
        this.setVisible( true );
    }



    public void closeDialog() {
       this.dispose();
    }



    public JDialog asJDialog() {
        return this;
    }
}
