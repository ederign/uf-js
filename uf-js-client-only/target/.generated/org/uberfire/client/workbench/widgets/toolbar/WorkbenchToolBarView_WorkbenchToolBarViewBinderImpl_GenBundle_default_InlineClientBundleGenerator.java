package org.uberfire.client.workbench.widgets.toolbar;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class WorkbenchToolBarView_WorkbenchToolBarViewBinderImpl_GenBundle_default_InlineClientBundleGenerator implements org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarView_WorkbenchToolBarViewBinderImpl_GenBundle {
  private static WorkbenchToolBarView_WorkbenchToolBarViewBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new WorkbenchToolBarView_WorkbenchToolBarViewBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarView_WorkbenchToolBarViewBinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GIRWXH-BEQ{height:" + ("5px")  + ";}.GIRWXH-BCQ{border-left-width:" + ("1px")  + " !important;border-bottom-width:" + ("1px")  + " !important;padding-left:" + ("0")  + " !important;}.GIRWXH-BFQ{float:" + ("right")  + " !important;margin-top:" + ("0")  + " !important;margin-bottom:" + ("0")  + " !important;position:" + ("absolute")  + " !important;}.GIRWXH-BDQ{float:" + ("left")  + ";border-left-width:" + ("1px")  + ";padding-left:") + (("1px")  + ";padding-right:" + ("1px")  + ";}")) : ((".GIRWXH-BEQ{height:" + ("5px")  + ";}.GIRWXH-BCQ{border-right-width:" + ("1px")  + " !important;border-bottom-width:" + ("1px")  + " !important;padding-right:" + ("0")  + " !important;}.GIRWXH-BFQ{float:" + ("left")  + " !important;margin-top:" + ("0")  + " !important;margin-bottom:" + ("0")  + " !important;position:" + ("absolute")  + " !important;}.GIRWXH-BDQ{float:" + ("right")  + ";border-right-width:" + ("1px")  + ";padding-right:") + (("1px")  + ";padding-left:" + ("1px")  + ";}"));
      }
      public java.lang.String container(){
        return "GIRWXH-BCQ";
      }
      public java.lang.String expand(){
        return "GIRWXH-BDQ";
      }
      public java.lang.String margin(){
        return "GIRWXH-BEQ";
      }
      public java.lang.String reset_toolbar_margin(){
        return "GIRWXH-BFQ";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarView_WorkbenchToolBarViewBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarView_WorkbenchToolBarViewBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarView_WorkbenchToolBarViewBinderImpl_GenCss_style style;
  
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
      case 'style': return this.@org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarView_WorkbenchToolBarViewBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
