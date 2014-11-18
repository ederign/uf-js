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

package org.uberfire.client.screens;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import javax.annotation.Generated;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import com.google.gwt.user.client.ui.InlineLabel;

import org.uberfire.client.mvp.PlaceManager;
import org.uberfire.client.mvp.AbstractSplashScreenActivity;
import javax.inject.Named;
import org.uberfire.mvp.PlaceRequest;
import org.uberfire.workbench.model.SplashScreenFilter;
import org.uberfire.client.mvp.IsSplashScreen;

import com.google.gwt.user.client.ui.IsWidget;

@ApplicationScoped
@Generated("org.uberfire.annotations.processors.WorkbenchSplashScreenProcessor")
@Named("demo.splash")
@IsSplashScreen
/*
 * WARNING! This class is generated. Do not modify.
 */
public class DemoSplashScreenActivity extends AbstractSplashScreenActivity {

    private static final Collection<String> ROLES = Collections.emptyList();

    private static final Collection<String> TRAITS = Collections.emptyList();

    @Inject
    private DemoSplashScreen realPresenter;

    @Inject
    //Constructor injection for testing
    public DemoSplashScreenActivity(final PlaceManager placeManager) {
        super( placeManager );
    }

    @Override
    public String getTitle() {
        return realPresenter.getTitle();
    }

    @Override
    public IsWidget getWidget() {
        return realPresenter.getView();
    }

    @Override
    public Integer getBodyHeight() {
        return realPresenter.getBodySize();
    }

    @Override
    public SplashScreenFilter getFilter() {
        return realPresenter.getFilter();
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
        return "org.uberfire.client.screens.DemoSplashScreenActivity";
    }
}
