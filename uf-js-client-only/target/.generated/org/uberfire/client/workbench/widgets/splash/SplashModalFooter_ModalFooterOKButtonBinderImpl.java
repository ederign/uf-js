package org.uberfire.client.workbench.widgets.splash;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeUri;
import com.google.gwt.safehtml.shared.UriUtils;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class SplashModalFooter_ModalFooterOKButtonBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.uberfire.client.workbench.widgets.splash.SplashModalFooter>, org.uberfire.client.workbench.widgets.splash.SplashModalFooter.ModalFooterOKButtonBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("Don't show again")
    SafeHtml html1();
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.uberfire.client.workbench.widgets.splash.SplashModalFooter owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.uberfire.client.workbench.widgets.splash.SplashModalFooter owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onOKButtonClick(event);
      }
    };

    public Widgets(final org.uberfire.client.workbench.widgets.splash.SplashModalFooter owner) {
      this.owner = owner;
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
    }

    SafeHtml template_html1() {
      return template.html1();
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.uberfire.client.workbench.widgets.splash.SplashModalFooter_ModalFooterOKButtonBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.uberfire.client.workbench.widgets.splash.SplashModalFooter_ModalFooterOKButtonBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.uberfire.client.workbench.widgets.splash.SplashModalFooter_ModalFooterOKButtonBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.uberfire.client.workbench.widgets.splash.SplashModalFooter_ModalFooterOKButtonBinderImpl_GenBundle) GWT.create(org.uberfire.client.workbench.widgets.splash.SplashModalFooter_ModalFooterOKButtonBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for style called 2 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.uberfire.client.workbench.widgets.splash.SplashModalFooter_ModalFooterOKButtonBinderImpl_GenCss_style style;
    private org.uberfire.client.workbench.widgets.splash.SplashModalFooter_ModalFooterOKButtonBinderImpl_GenCss_style get_style() {
      return style;
    }
    private org.uberfire.client.workbench.widgets.splash.SplashModalFooter_ModalFooterOKButtonBinderImpl_GenCss_style build_style() {
      // Creation section.
      style = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().style();
      // Setup section.
      style.ensureInjected();


      return style;
    }

    /**
     * Getter for f_FlowPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel1() {
      return build_f_FlowPanel1();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel1 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel1.add(get_dontShowAgain());
      f_FlowPanel1.add(get_closeButton());


      return f_FlowPanel1;
    }

    /**
     * Getter for dontShowAgain called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.github.gwtbootstrap.client.ui.CheckBox get_dontShowAgain() {
      return build_dontShowAgain();
    }
    private com.github.gwtbootstrap.client.ui.CheckBox build_dontShowAgain() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.CheckBox dontShowAgain = (com.github.gwtbootstrap.client.ui.CheckBox) GWT.create(com.github.gwtbootstrap.client.ui.CheckBox.class);
      // Setup section.
      dontShowAgain.setHTML(template_html1().asString());
      dontShowAgain.addStyleName("" + get_style().checkOnLeft() + "");


      owner.dontShowAgain = dontShowAgain;

      return dontShowAgain;
    }

    /**
     * Getter for closeButton called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.github.gwtbootstrap.client.ui.Button get_closeButton() {
      return build_closeButton();
    }
    private com.github.gwtbootstrap.client.ui.Button build_closeButton() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.Button closeButton = (com.github.gwtbootstrap.client.ui.Button) GWT.create(com.github.gwtbootstrap.client.ui.Button.class);
      // Setup section.
      closeButton.addStyleName("" + get_style().closeOnRight() + "");
      closeButton.setText("Close");
      closeButton.setType(com.github.gwtbootstrap.client.ui.constants.ButtonType.LINK);
      closeButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.closeButton = closeButton;

      return closeButton;
    }
  }
}
