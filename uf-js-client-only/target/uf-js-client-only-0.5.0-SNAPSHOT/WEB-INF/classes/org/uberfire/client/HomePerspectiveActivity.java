/*
 * Copyright 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.uberfire.client;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import javax.annotation.Generated;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import javax.inject.Named;
import org.uberfire.workbench.model.PerspectiveDefinition;
import org.uberfire.workbench.model.impl.PerspectiveDefinitionImpl;
import java.util.HashMap;
import java.util.Map;
import org.uberfire.client.annotations.Perspective;
import org.uberfire.client.mvp.AbstractWorkbenchPerspectiveActivity;
import org.uberfire.client.mvp.PlaceManager;

import org.uberfire.mvp.PlaceRequest;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import org.uberfire.client.mvp.TemplatedActivity;
import org.uberfire.client.workbench.panels.impl.TemplatedWorkbenchPanelPresenter;
import org.uberfire.mvp.impl.DefaultPlaceRequest;
import org.uberfire.workbench.model.NamedPosition;
import org.uberfire.workbench.model.PanelDefinition;
import org.uberfire.workbench.model.Position;
import org.uberfire.workbench.model.impl.PanelDefinitionImpl;
import org.uberfire.workbench.model.impl.PartDefinitionImpl;

@Dependent
@Generated("org.uberfire.annotations.processors.WorkbenchPerspectiveProcessor")
@Named("HomePerspective")
/*
 * WARNING! This class is generated. Do not modify.
 */
public class HomePerspectiveActivity extends AbstractWorkbenchPerspectiveActivity implements TemplatedActivity {

    private static final Collection<String> ROLES = Collections.emptyList();

    private static final Collection<String> TRAITS = Collections.emptyList();

    @Inject
    private HomePerspective realPresenter;

    @Inject
    //Constructor injection for testing
    public HomePerspectiveActivity(final PlaceManager placeManager) {
        super( placeManager );
    }

    @Override
    public String getIdentifier() {
        return "HomePerspective";
    }

    @Override
    public boolean isDefault() {
        return true;
    }

    @Override
    public Collection<String> getRoles() {
        return ROLES;
    }

    @Override
    public Collection<String> getTraits() {
        return TRAITS;
    }

    @Override
    public String getSignatureId() {
        return "org.uberfire.client.HomePerspectiveActivity";
    }

    @Override
    public IsWidget getRootWidget() {
        return realPresenter;
    }

    @Override
    public HasWidgets resolvePosition( NamedPosition position ) {
        final String fieldName = position.getFieldName();
        if ( fieldName.equals( "moodScreen" ) ) {
            return realPresenter.moodScreen;
        }
        if ( fieldName.equals( "homeScreen" ) ) {
            return realPresenter.homeScreen;
        }
        if ( fieldName.equals( "anotherScreen" ) ) {
            return realPresenter.anotherScreen;
        }
        return null;
    }

    @Override
    public PerspectiveDefinition getDefaultPerspectiveLayout() {
        final PerspectiveDefinition p = new PerspectiveDefinitionImpl( TemplatedWorkbenchPanelPresenter.class.getName() );
        p.setName( realPresenter.getClass().getName() );


        PanelDefinition panelDefinition0 = new PanelDefinitionImpl( "PARENT_CHOOSES_TYPE" );
        Map properties0 = new HashMap<String,String>();
        properties0.put( "uber","fire" );
        properties0.put( "uber1","fire1" );
        panelDefinition0.addPart(
                new PartDefinitionImpl( new DefaultPlaceRequest( "MoodScreen", properties0 ) ) );
        p.getRoot().appendChild( new NamedPosition( "moodScreen" ), panelDefinition0 );
        PanelDefinition panelDefinition1 = new PanelDefinitionImpl( "PARENT_CHOOSES_TYPE" );
        Map properties1 = new HashMap<String,String>();
        properties1.put( "uber","fire" );
        panelDefinition1.addPart(
                new PartDefinitionImpl( new DefaultPlaceRequest( "HomeScreen", properties1 ) ) );
        p.getRoot().appendChild( new NamedPosition( "homeScreen" ), panelDefinition1 );
        PanelDefinition panelDefinition2 = new PanelDefinitionImpl( "PARENT_CHOOSES_TYPE" );
        panelDefinition2.addPart(
                new PartDefinitionImpl( new DefaultPlaceRequest( "AnotherScreen" ) ) );
        p.getRoot().appendChild( new NamedPosition( "anotherScreen" ), panelDefinition2 );
        return p;
    }

}
