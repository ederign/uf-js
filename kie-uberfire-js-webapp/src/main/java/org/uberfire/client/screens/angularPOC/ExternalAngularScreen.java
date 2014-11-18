package org.uberfire.client.screens.angularPOC;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import org.uberfire.client.annotations.WorkbenchPartTitle;
import org.uberfire.client.annotations.WorkbenchScreen;
import org.uberfire.lifecycle.OnStartup;
import org.uberfire.mvp.PlaceRequest;

@Dependent
@WorkbenchScreen(identifier = "ExternalAngularScreen")
public class ExternalAngularScreen
        extends Composite {

    interface ViewBinder
            extends
            UiBinder<Widget, ExternalAngularScreen> {

    }

    @UiField
    FlowPanel angularContent;

    private static ViewBinder uiBinder = GWT.create( ViewBinder.class );

    @PostConstruct
    public void init() {
        initWidget( uiBinder.createAndBindUi( this ) );
    }

    @OnStartup
    public void onStartup( final PlaceRequest place ) {
        String angularTemplateUrl = place.getParameter( "angularTemplateUrl", "http://127.0.0.1:8888/angular-test.html" );
        String domElementId = place.getParameter( "domElementId", "template" );
        angularContent.add( new DynamicAngularComposite( angularTemplateUrl, domElementId ) );
    }

    @WorkbenchPartTitle
    public String getTitle() {
        return "AngularScreen";
    }

}
