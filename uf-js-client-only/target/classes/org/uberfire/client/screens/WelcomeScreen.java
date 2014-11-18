package org.uberfire.client.screens;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;

import com.github.gwtbootstrap.client.ui.TextBox;
import com.google.gwt.uibinder.client.UiField;
import org.uberfire.client.annotations.WorkbenchContextId;
import org.uberfire.client.annotations.WorkbenchPartTitle;
import org.uberfire.client.annotations.WorkbenchScreen;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import org.uberfire.lifecycle.OnStartup;
import org.uberfire.mvp.PlaceRequest;

@Dependent
@WorkbenchScreen(identifier = "welcome")
public class WelcomeScreen
        extends Composite {


    @UiField
    TextBox name;

    interface ViewBinder
            extends
            UiBinder<Widget, WelcomeScreen> {

    }

    private static ViewBinder uiBinder = GWT.create( ViewBinder.class );


    @OnStartup
    public void onStartup( final PlaceRequest place ) {
        name.setText( place.getParameter( "name", "Who is there?" ) );
    }

    @PostConstruct
    public void init() {
        initWidget( uiBinder.createAndBindUi( this ) );
    }

    @WorkbenchPartTitle
    public String getTitle() {
        return "Welcome";
    }

    @WorkbenchContextId
    public String getMyContextRef() {
        return "welcomeContext";
    }

}
