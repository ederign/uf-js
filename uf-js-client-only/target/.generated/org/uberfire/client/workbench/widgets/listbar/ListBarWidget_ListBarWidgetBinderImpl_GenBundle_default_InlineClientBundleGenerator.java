package org.uberfire.client.workbench.widgets.listbar;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class ListBarWidget_ListBarWidgetBinderImpl_GenBundle_default_InlineClientBundleGenerator implements org.uberfire.client.workbench.widgets.listbar.ListBarWidget_ListBarWidgetBinderImpl_GenBundle {
  private static ListBarWidget_ListBarWidgetBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new ListBarWidget_ListBarWidgetBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new org.uberfire.client.workbench.widgets.listbar.ListBarWidget_ListBarWidgetBinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GIRWXH-BPP{font-size:" + ("18px")  + ";}.GIRWXH-BLP{padding-left:" + ("10px")  + ";}.GIRWXH-BOP{float:" + ("left")  + ";}.GIRWXH-BNP{display:" + ("inline")  + ";}.GIRWXH-BMP{position:" + ("relative")  + ";top:" + ("0")  + ";bottom:" + ("0")  + ";width:" + ("100%")  + ";height:" + ("100%")  + ";}")) : ((".GIRWXH-BPP{font-size:" + ("18px")  + ";}.GIRWXH-BLP{padding-right:" + ("10px")  + ";}.GIRWXH-BOP{float:" + ("right")  + ";}.GIRWXH-BNP{display:" + ("inline")  + ";}.GIRWXH-BMP{position:" + ("relative")  + ";top:" + ("0")  + ";bottom:" + ("0")  + ";width:" + ("100%")  + ";height:" + ("100%")  + ";}"));
      }
      public java.lang.String better_margin(){
        return "GIRWXH-BLP";
      }
      public java.lang.String fillParent(){
        return "GIRWXH-BMP";
      }
      public java.lang.String inline(){
        return "GIRWXH-BNP";
      }
      public java.lang.String pullRight(){
        return "GIRWXH-BOP";
      }
      public java.lang.String title(){
        return "GIRWXH-BPP";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static org.uberfire.client.workbench.widgets.listbar.ListBarWidget_ListBarWidgetBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public org.uberfire.client.workbench.widgets.listbar.ListBarWidget_ListBarWidgetBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.uberfire.client.workbench.widgets.listbar.ListBarWidget_ListBarWidgetBinderImpl_GenCss_style style;
  
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
      case 'style': return this.@org.uberfire.client.workbench.widgets.listbar.ListBarWidget_ListBarWidgetBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
