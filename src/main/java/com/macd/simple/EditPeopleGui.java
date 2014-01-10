package com.macd.simple;

import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Created with IntelliJ IDEA.
 * User: marcel
 * Date: 10/30/12
 * Time: 3:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class EditPeopleGui {

    public static void createAndShowGUI() {
        //Create and set up the window.
        final JFrame frame = new JFrame( "Edit People" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );


        JPanel panel = new JPanel();
        panel.setLayout( new MigLayout( "gap 30px" ) );


        JLabel nameLabel = new JLabel( "Name:" );
        JTextField nameText = new JTextField();
        nameText.setColumns( 10 );

        JLabel surnameLabel = new JLabel( "Surname:" );
        JTextField surnameText = new JTextField();
        surnameText.setColumns( 10 );

        JLabel genderLabel = new JLabel( "Surname:" );
        JTextField genderText = new JTextField();
        genderText.setColumns( 10 );

        JButton saveButton = new JButton( "Save" );
        JButton cancelButton = new JButton( "Cancel" );


        panel.add( nameLabel );
        panel.add( nameText, "wrap" );
        panel.add( surnameLabel );
        panel.add( surnameText, "wrap" );
        panel.add( genderLabel );
        panel.add( genderText, "wrap" );
        panel.add( saveButton );
        panel.add( cancelButton );

        //actions

        frame.add( panel );
        //Display the window.
        frame.pack();
        frame.setVisible( true );
    }



    public static void main( String[] args ) {
        javax.swing.SwingUtilities.invokeLater( new Runnable() {

            public void run() {
                createAndShowGUI();
            }
        } );
    }

}
