package org.uberfire.client.screens.angularPOC;/*
 * Copyright 2014 JBoss, by Red Hat, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import org.jboss.errai.common.client.ui.ElementWrapperWidget;
import org.jboss.errai.ui.shared.Visit;
import org.jboss.errai.ui.shared.VisitContext;
import org.jboss.errai.ui.shared.VisitContextMutable;
import org.jboss.errai.ui.shared.Visitor;

import com.google.gwt.dom.client.Element;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;

public class DynamicAngularComposite extends Composite {

    public DynamicAngularComposite(final String angularTemplateUrl, final String domElementId) {
        this(angularTemplateUrl, domElementId, null);
    }

    public DynamicAngularComposite(final String angularTemplateUrl, final String domElementId, final String angularModule) {
        final ElementWrapperWidget widget = ElementWrapperWidget.getWidget(DOM.createDiv());
        this.initWidget(widget);

        // Just for testing purposes. The angular template could be downloaded using
        // Errai RPC or an Errai CDI event.
        try {
            new RequestBuilder(RequestBuilder.GET, angularTemplateUrl).sendRequest(null, new RequestCallback() {

                @Override
                public void onResponseReceived(Request request, Response response) {

                    //maybe this is angular job
                    String template = response.getText();
                    Element domEl = DOM.createElement("div");
                    domEl.setInnerHTML(template);

                    VisitContext<Element> context = Visit.depthFirst(domEl, new Visitor<Element>() {
                        @Override
                        public boolean visit(VisitContextMutable<Element> context, Element element) {
                            if (element.hasAttribute("id")) {
                                String id = element.getAttribute("id");
                                if (id.equals(domElementId)) {
                                    context.setResult(element);
                                }
                            }
                            return true;
                        }
                    });

                    widget.setHTML(context.getResult().getString());

                    templateIsReady(domElementId,  widget.getHTML() );
                    if (angularModule == null || angularModule.isEmpty()) {
                        //bootstrap(domElementId);
                    }
                    else {
                        //bootstrap(domElementId, angularModule);
                    }
                }

                @Override
                public void onError(Request request, Throwable exception) {
                    throw new RuntimeException(exception);
                }

            });
        } catch (RequestException e) {
            throw new RuntimeException(e);
        }

    }

    private native void templateIsReady(String id, String template) /*-{
        $wnd.templateIsReady(id, template);
    }-*/;

    private native void bootstrap(String id) /*-{
        $wnd.angular.bootstrap($doc.getElementById(id));
    }-*/;

    private native void bootstrap(String id, String moduleName) /*-{
        $wnd.angular.bootstrap($doc.getElementById(id), [moduleName]);
    }-*/;

}