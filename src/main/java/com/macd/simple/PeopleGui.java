package com.macd.simple;

import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: marcel
 * Date: 10/30/12
 * Time: 11:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class PeopleGui {


    private static void createAndShowGUI() {
        //Create and set up the window.
        final JFrame frame = new JFrame( "People Gui" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );


        JPanel panel = new JPanel();
        panel.setLayout( new MigLayout( "gap 30px" ) );


        final JButton editButton = new JButton( "Edit" );

        String comboBoxItems[] = { "male", "female" };
        JComboBox filterComboBox = new JComboBox( comboBoxItems );


        String[] columnNames = { "First Name",
                                 "Last Name",
                                 "Gender" };

        String[][] data = {
                { "Betty", "Boo", "female" },
                { "Anton", "Alt", "male" },

        };

        JTable table = new JTable( data, columnNames );
        JScrollPane tableScrollPane = new JScrollPane( table );


        panel.add( filterComboBox, "wrap, gapy 10px" );
        panel.add( tableScrollPane, "wrap" );
        panel.add( editButton );

        //actions
        editButton.addActionListener( new ActionListener() {

            public void actionPerformed( ActionEvent e ) {
                EditPeopleGui.createAndShowGUI();
            }
        } );

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
