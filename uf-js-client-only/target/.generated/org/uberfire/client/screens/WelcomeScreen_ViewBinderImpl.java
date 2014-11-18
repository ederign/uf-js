package org.uberfire.client.screens;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class WelcomeScreen_ViewBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.uberfire.client.screens.WelcomeScreen>, org.uberfire.client.screens.WelcomeScreen.ViewBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.uberfire.client.screens.WelcomeScreen owner) {


    return new Widgets(owner).get_f_Hero1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.uberfire.client.screens.WelcomeScreen owner;


    public Widgets(final org.uberfire.client.screens.WelcomeScreen owner) {
      this.owner = owner;
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.uberfire.client.screens.WelcomeScreen_ViewBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.uberfire.client.screens.WelcomeScreen_ViewBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.uberfire.client.screens.WelcomeScreen_ViewBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.uberfire.client.screens.WelcomeScreen_ViewBinderImpl_GenBundle) GWT.create(org.uberfire.client.screens.WelcomeScreen_ViewBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for style called 1 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.uberfire.client.screens.WelcomeScreen_ViewBinderImpl_GenCss_style get_style() {
      return build_style();
    }
    private org.uberfire.client.screens.WelcomeScreen_ViewBinderImpl_GenCss_style build_style() {
      // Creation section.
      final org.uberfire.client.screens.WelcomeScreen_ViewBinderImpl_GenCss_style style = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().style();
      // Setup section.
      style.ensureInjected();


      return style;
    }

    /**
     * Getter for f_Hero1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.github.gwtbootstrap.client.ui.Hero get_f_Hero1() {
      return build_f_Hero1();
    }
    private com.github.gwtbootstrap.client.ui.Hero build_f_Hero1() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.Hero f_Hero1 = (com.github.gwtbootstrap.client.ui.Hero) GWT.create(com.github.gwtbootstrap.client.ui.Hero.class);
      // Setup section.
      f_Hero1.add(get_f_Heading2());
      f_Hero1.add(get_name());
      f_Hero1.addStyleName("" + get_style().welcome() + "");


      return f_Hero1;
    }

    /**
     * Getter for f_Heading2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.github.gwtbootstrap.client.ui.Heading get_f_Heading2() {
      return build_f_Heading2();
    }
    private com.github.gwtbootstrap.client.ui.Heading build_f_Heading2() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.Heading f_Heading2 = new com.github.gwtbootstrap.client.ui.Heading(2);
      // Setup section.
      f_Heading2.setText("Welcome to UberFire,");


      return f_Heading2;
    }

    /**
     * Getter for name called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.github.gwtbootstrap.client.ui.TextBox get_name() {
      return build_name();
    }
    private com.github.gwtbootstrap.client.ui.TextBox build_name() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.TextBox name = (com.github.gwtbootstrap.client.ui.TextBox) GWT.create(com.github.gwtbootstrap.client.ui.TextBox.class);
      // Setup section.


      owner.name = name;

      return name;
    }
  }
}
