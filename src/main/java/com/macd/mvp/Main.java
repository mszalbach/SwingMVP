package com.macd.mvp;

import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.macd.mvp.presenter.AllPeoplePresenter;
import com.macd.mvp.presenter.EditPeoplePresenter;
import com.macd.mvp.presenter.EditPeoplePresenterFactory;
import com.macd.mvp.presenter.MainPresenter;
import com.macd.mvp.view.AllPeopleView;
import com.macd.mvp.view.EditPeopleView;

import javax.swing.JFrame;

/**
 * Created with IntelliJ IDEA.
 * User: marcel
 * Date: 10/31/12
 * Time: 11:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main
        extends JFrame {

    public void init() {
        GuiceFactory.getInjector().getInstance( MainPresenter.class ).init();
    }



    public static final class GuiceFactory {

        private static final Injector inj = Guice.createInjector( new MyModule() );



        public static Injector getInjector() {
            return inj;
        }



        public static final class MyModule
                extends AbstractModule {


            @Override
            protected void configure() {
                bind( EventBus.class ).toInstance( new EventBus( "MVP EventBus" ) );
                bind( AllPeoplePresenter.Display.class ).to( AllPeopleView.class );
                bind( EditPeoplePresenter.Display.class ).to( EditPeopleView.class );
                install( new FactoryModuleBuilder().build( EditPeoplePresenterFactory.class ) );

            }
        }
    }



    public static void main( String[] args ) {

        javax.swing.SwingUtilities.invokeLater( new Runnable() {

            public void run() {
                new Main().init();
            }
        } );

    }

}
