package org.uberfire.client.workbench.widgets.splash;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class SplashModalFooter_ModalFooterOKButtonBinderImpl_GenBundle_default_InlineClientBundleGenerator implements org.uberfire.client.workbench.widgets.splash.SplashModalFooter_ModalFooterOKButtonBinderImpl_GenBundle {
  private static SplashModalFooter_ModalFooterOKButtonBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new SplashModalFooter_ModalFooterOKButtonBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new org.uberfire.client.workbench.widgets.splash.SplashModalFooter_ModalFooterOKButtonBinderImpl_GenCss_style() {
      private boolean injected;
      public boolean ensureInjected() {
        if (!injected) {
          injected = true;
          com.google.gwt.dom.client.StyleInjector.inject(getText());
          return true;
        }
        return false;
      }
      public String getName() {
        return "style";
      }
      public String getText() {
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GIRWXH-BAQ{float:" + ("right")  + ";}.GIRWXH-BBQ{float:" + ("left")  + ";}")) : ((".GIRWXH-BAQ{float:" + ("left")  + ";}.GIRWXH-BBQ{float:" + ("right")  + ";}"));
      }
      public java.lang.String checkOnLeft(){
        return "GIRWXH-BAQ";
      }
      public java.lang.String closeOnRight(){
        return "GIRWXH-BBQ";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static org.uberfire.client.workbench.widgets.splash.SplashModalFooter_ModalFooterOKButtonBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public org.uberfire.client.workbench.widgets.splash.SplashModalFooter_ModalFooterOKButtonBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.uberfire.client.workbench.widgets.splash.SplashModalFooter_ModalFooterOKButtonBinderImpl_GenCss_style style;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      style(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("style", style());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'style': return this.@org.uberfire.client.workbench.widgets.splash.SplashModalFooter_ModalFooterOKButtonBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
