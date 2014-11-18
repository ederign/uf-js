package org.uberfire.client.workbench.widgets.notfound;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class ActivityNotFoundView_ActivityNotFoundViewBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.uberfire.client.workbench.widgets.notfound.ActivityNotFoundView>, org.uberfire.client.workbench.widgets.notfound.ActivityNotFoundView.ActivityNotFoundViewBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.uberfire.client.workbench.widgets.notfound.ActivityNotFoundView owner) {


    return new Widgets(owner).get_f_VerticalPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.uberfire.client.workbench.widgets.notfound.ActivityNotFoundView owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickOkButton(event);
      }
    };

    public Widgets(final org.uberfire.client.workbench.widgets.notfound.ActivityNotFoundView owner) {
      this.owner = owner;
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.uberfire.client.workbench.widgets.notfound.ActivityNotFoundView_ActivityNotFoundViewBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.uberfire.client.workbench.widgets.notfound.ActivityNotFoundView_ActivityNotFoundViewBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.uberfire.client.workbench.widgets.notfound.ActivityNotFoundView_ActivityNotFoundViewBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.uberfire.client.workbench.widgets.notfound.ActivityNotFoundView_ActivityNotFoundViewBinderImpl_GenBundle) GWT.create(org.uberfire.client.workbench.widgets.notfound.ActivityNotFoundView_ActivityNotFoundViewBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for f_VerticalPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.VerticalPanel get_f_VerticalPanel1() {
      return build_f_VerticalPanel1();
    }
    private com.google.gwt.user.client.ui.VerticalPanel build_f_VerticalPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel1 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
      // Setup section.
      f_VerticalPanel1.add(get_f_HorizontalPanel2());
      f_VerticalPanel1.add(get_requestedPlaceIdentifierLabel());
      f_VerticalPanel1.add(get_okButton());


      return f_VerticalPanel1;
    }

    /**
     * Getter for f_HorizontalPanel2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HorizontalPanel get_f_HorizontalPanel2() {
      return build_f_HorizontalPanel2();
    }
    private com.google.gwt.user.client.ui.HorizontalPanel build_f_HorizontalPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel2 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
      // Setup section.
      f_HorizontalPanel2.add(get_f_Label3());


      return f_HorizontalPanel2;
    }

    /**
     * Getter for f_Label3 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label3() {
      return build_f_Label3();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label3() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label3 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label3.setText("Activity not found");


      return f_Label3;
    }

    /**
     * Getter for requestedPlaceIdentifierLabel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_requestedPlaceIdentifierLabel() {
      return build_requestedPlaceIdentifierLabel();
    }
    private com.google.gwt.user.client.ui.Label build_requestedPlaceIdentifierLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label requestedPlaceIdentifierLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.requestedPlaceIdentifierLabel = requestedPlaceIdentifierLabel;

      return requestedPlaceIdentifierLabel;
    }

    /**
     * Getter for okButton called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.github.gwtbootstrap.client.ui.Button get_okButton() {
      return build_okButton();
    }
    private com.github.gwtbootstrap.client.ui.Button build_okButton() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.Button okButton = (com.github.gwtbootstrap.client.ui.Button) GWT.create(com.github.gwtbootstrap.client.ui.Button.class);
      // Setup section.
      okButton.setText("OK");
      okButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      return okButton;
    }
  }
}
