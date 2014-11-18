package org.uberfire.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class WorkbenchResources_default_InlineClientBundleGenerator implements org.uberfire.client.resources.WorkbenchResources {
  private static WorkbenchResources_default_InlineClientBundleGenerator _instance0 = new WorkbenchResources_default_InlineClientBundleGenerator();
  private void CSSInitializer() {
    CSS = new org.uberfire.client.resources.WorkbenchCss() {
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
        return "CSS";
      }
      public String getText() {
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GIRWXH-BFP{border:" + ("0")  + ";margin:" + ("0")  + ";padding:" + ("0")  + ";}.GIRWXH-BJP{min-height:" + ("30px")  + ";margin-top:" + ("0")  + ";margin-bottom:" + ("5px")  + ";padding-bottom:" + ("5px")  + ";padding-top:" + ("5px")  + ";background-color:" + ("#f5f5f5")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#e3e3e3")  + ";-webkit-border-radius:") + (("4px")  + ";-moz-border-radius:" + ("4px")  + ";border-radius:" + ("4px")  + ";-webkit-box-shadow:" + ("inset"+ " " +"0"+ " " +"1px"+ " " +"1px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.05" + ")")  + ";-moz-box-shadow:" + ("inset"+ " " +"0"+ " " +"1px"+ " " +"1px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.05" + ")")  + ";box-shadow:" + ("inset"+ " " +"0"+ " " +"1px"+ " " +"1px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.05" + ")")  + ";}.GIRWXH-BDP{z-index:" + ("100000")  + ";background-color:" + ("#a0a0e0")  + ";opacity:" + ("0.5")  + ";}.GIRWXH-BCP{z-index:" + ("200000")  + ";border-style:" + ("none") ) + (";line-height:" + ("0")  + ";}.GIRWXH-BHP{cursor:" + ("default")  + ";height:" + ("36px")  + ";width:" + ("100%")  + ";border-spacing:" + ("0")  + ";background:" + ("#c0c0c0")  + ";padding-top:" + ("0")  + ";padding-bottom:" + ("0")  + ";padding-right:" + ("2px")  + ";padding-left:" + ("2px")  + ";}.GIRWXH-BBP{border-color:") + (("rgba(" + "82"+ ","+ " " +"168"+ ","+ " " +"236"+ ","+ " " +"0.8" + ")")  + ";box-shadow:" + ("0"+ " " +"0"+ " " +"8px"+ " " +"rgba(" + "82"+ ","+ " " +"168"+ ","+ " " +"236"+ ","+ " " +"0.6" + ")")  + ";}.GIRWXH-BIP{float:" + ("none")  + ";margin:" + ("-2px"+ " " +"10px"+ " " +"0"+ " " +"0")  + ";}.GIRWXH-BEP{-moz-box-shadow:" + ("rgba(" + "255"+ ","+ " " +"255"+ ","+ " " +"255"+ ","+ " " +"0.2" + ")"+ " " +"0"+ " " +"1px"+ " " +"0"+ " " +"0"+ " " +"inset"+ ","+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.0470588" + ")"+ " " +"0"+ " " +"1px"+ " " +"2px"+ " " +"0")  + ";-webkit-box-shadow:" + ("rgba(" + "255"+ ","+ " " +"255"+ ","+ " " +"255"+ ","+ " " +"0.2" + ")"+ " " +"0"+ " " +"1px"+ " " +"0"+ " " +"0"+ " " +"inset"+ ","+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.0470588" + ")"+ " " +"0"+ " " +"1px"+ " " +"2px"+ " " +"0")  + ";background:" + ("#f5f5f5"+ " " +"linear-gradient(" + "#fff"+ ","+ " " +"#e6e6e6" + ")"+ " " +"repeat-x")  + ";border-image-outset:" + ("0")  + ";border-image-repeat:" + ("stretch")  + ";border-image-slice:" + ("100%")  + ";border-image-source:" + ("none") ) + (";border-image-width:" + ("1")  + ";border:" + ("1px"+ " " +"solid"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.0980392" + ")")  + ";border-top-width:" + ("0")  + ";border-bottom-color:" + ("#b3b3b3")  + ";box-shadow:" + ("rgba(" + "255"+ ","+ " " +"255"+ ","+ " " +"255"+ ","+ " " +"0.2" + ")"+ " " +"0"+ " " +"1px"+ " " +"0"+ " " +"0"+ " " +"inset"+ ","+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.0470588" + ")"+ " " +"0"+ " " +"1px"+ " " +"2px"+ " " +"0")  + ";box-sizing:" + ("border-box")  + ";color:" + ("#333")  + ";padding-right:" + ("6px")  + ";padding-top:" + ("5px")  + ";text-shadow:" + ("rgba(" + "255"+ ","+ " " +"255"+ ","+ " " +"255"+ ","+ " " +"0.74902" + ")"+ " " +"0"+ " " +"1px"+ " " +"1px")  + ";height:") + (("32px")  + ";}.GIRWXH-BGP{margin-right:" + ("0")  + ";-webkit-transition:" + ("all"+ " " +"0.7s"+ " " +"ease-out")  + ";-moz-transition:" + ("all"+ " " +"0.7s"+ " " +"ease-out")  + ";-ms-transition:" + ("all"+ " " +"0.7s"+ " " +"ease-out")  + ";-o-transition:" + ("all"+ " " +"0.7s"+ " " +"ease-out")  + ";transition:" + ("all"+ " " +"0.7s"+ " " +"ease-out")  + ";}.navbar-fixed-top,.navbar-fixed-bottom{position:" + ("static")  + " !important;}")) : ((".GIRWXH-BFP{border:" + ("0")  + ";margin:" + ("0")  + ";padding:" + ("0")  + ";}.GIRWXH-BJP{min-height:" + ("30px")  + ";margin-top:" + ("0")  + ";margin-bottom:" + ("5px")  + ";padding-bottom:" + ("5px")  + ";padding-top:" + ("5px")  + ";background-color:" + ("#f5f5f5")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#e3e3e3")  + ";-webkit-border-radius:") + (("4px")  + ";-moz-border-radius:" + ("4px")  + ";border-radius:" + ("4px")  + ";-webkit-box-shadow:" + ("inset"+ " " +"0"+ " " +"1px"+ " " +"1px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.05" + ")")  + ";-moz-box-shadow:" + ("inset"+ " " +"0"+ " " +"1px"+ " " +"1px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.05" + ")")  + ";box-shadow:" + ("inset"+ " " +"0"+ " " +"1px"+ " " +"1px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.05" + ")")  + ";}.GIRWXH-BDP{z-index:" + ("100000")  + ";background-color:" + ("#a0a0e0")  + ";opacity:" + ("0.5")  + ";}.GIRWXH-BCP{z-index:" + ("200000")  + ";border-style:" + ("none") ) + (";line-height:" + ("0")  + ";}.GIRWXH-BHP{cursor:" + ("default")  + ";height:" + ("36px")  + ";width:" + ("100%")  + ";border-spacing:" + ("0")  + ";background:" + ("#c0c0c0")  + ";padding-top:" + ("0")  + ";padding-bottom:" + ("0")  + ";padding-left:" + ("2px")  + ";padding-right:" + ("2px")  + ";}.GIRWXH-BBP{border-color:") + (("rgba(" + "82"+ ","+ " " +"168"+ ","+ " " +"236"+ ","+ " " +"0.8" + ")")  + ";box-shadow:" + ("0"+ " " +"0"+ " " +"8px"+ " " +"rgba(" + "82"+ ","+ " " +"168"+ ","+ " " +"236"+ ","+ " " +"0.6" + ")")  + ";}.GIRWXH-BIP{float:" + ("none")  + ";margin:" + ("-2px"+ " " +"0"+ " " +"0"+ " " +"10px")  + ";}.GIRWXH-BEP{-moz-box-shadow:" + ("rgba(" + "255"+ ","+ " " +"255"+ ","+ " " +"255"+ ","+ " " +"0.2" + ")"+ " " +"0"+ " " +"1px"+ " " +"0"+ " " +"0"+ " " +"inset"+ ","+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.0470588" + ")"+ " " +"0"+ " " +"1px"+ " " +"2px"+ " " +"0")  + ";-webkit-box-shadow:" + ("rgba(" + "255"+ ","+ " " +"255"+ ","+ " " +"255"+ ","+ " " +"0.2" + ")"+ " " +"0"+ " " +"1px"+ " " +"0"+ " " +"0"+ " " +"inset"+ ","+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.0470588" + ")"+ " " +"0"+ " " +"1px"+ " " +"2px"+ " " +"0")  + ";background:" + ("#f5f5f5"+ " " +"linear-gradient(" + "#fff"+ ","+ " " +"#e6e6e6" + ")"+ " " +"repeat-x")  + ";border-image-outset:" + ("0")  + ";border-image-repeat:" + ("stretch")  + ";border-image-slice:" + ("100%")  + ";border-image-source:" + ("none") ) + (";border-image-width:" + ("1")  + ";border:" + ("1px"+ " " +"solid"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.0980392" + ")")  + ";border-top-width:" + ("0")  + ";border-bottom-color:" + ("#b3b3b3")  + ";box-shadow:" + ("rgba(" + "255"+ ","+ " " +"255"+ ","+ " " +"255"+ ","+ " " +"0.2" + ")"+ " " +"0"+ " " +"1px"+ " " +"0"+ " " +"0"+ " " +"inset"+ ","+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.0470588" + ")"+ " " +"0"+ " " +"1px"+ " " +"2px"+ " " +"0")  + ";box-sizing:" + ("border-box")  + ";color:" + ("#333")  + ";padding-left:" + ("6px")  + ";padding-top:" + ("5px")  + ";text-shadow:" + ("rgba(" + "255"+ ","+ " " +"255"+ ","+ " " +"255"+ ","+ " " +"0.74902" + ")"+ " " +"0"+ " " +"1px"+ " " +"1px")  + ";height:") + (("32px")  + ";}.GIRWXH-BGP{margin-left:" + ("0")  + ";-webkit-transition:" + ("all"+ " " +"0.7s"+ " " +"ease-out")  + ";-moz-transition:" + ("all"+ " " +"0.7s"+ " " +"ease-out")  + ";-ms-transition:" + ("all"+ " " +"0.7s"+ " " +"ease-out")  + ";-o-transition:" + ("all"+ " " +"0.7s"+ " " +"ease-out")  + ";transition:" + ("all"+ " " +"0.7s"+ " " +"ease-out")  + ";}.navbar-fixed-top,.navbar-fixed-bottom{position:" + ("static")  + " !important;}"));
      }
      public java.lang.String activeNavTabs(){
        return "GIRWXH-BBP";
      }
      public java.lang.String dropTargetCompass(){
        return "GIRWXH-BCP";
      }
      public java.lang.String dropTargetHighlight(){
        return "GIRWXH-BDP";
      }
      public java.lang.String listbar(){
        return "GIRWXH-BEP";
      }
      public java.lang.String notification(){
        return "GIRWXH-BFP";
      }
      public java.lang.String showContext(){
        return "GIRWXH-BGP";
      }
      public java.lang.String statusBar(){
        return "GIRWXH-BHP";
      }
      public java.lang.String tabCloseButton(){
        return "GIRWXH-BIP";
      }
      public java.lang.String toolbar(){
        return "GIRWXH-BJP";
      }
    }
    ;
  }
  private static class CSSInitializer {
    static {
      _instance0.CSSInitializer();
    }
    static org.uberfire.client.resources.WorkbenchCss get() {
      return CSS;
    }
  }
  public org.uberfire.client.resources.WorkbenchCss CSS() {
    return CSSInitializer.get();
  }
  private void imagesInitializer() {
    images = com.google.gwt.core.client.GWT.create(org.uberfire.client.resources.WorkbenchImages.class);
  }
  private static class imagesInitializer {
    static {
      _instance0.imagesInitializer();
    }
    static org.uberfire.client.resources.WorkbenchImages get() {
      return images;
    }
  }
  public org.uberfire.client.resources.WorkbenchImages images() {
    return imagesInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.uberfire.client.resources.WorkbenchCss CSS;
  private static org.uberfire.client.resources.WorkbenchImages images;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      CSS(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("CSS", CSS());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'CSS': return this.@org.uberfire.client.resources.WorkbenchResources::CSS()();
    }
    return null;
  }-*/;
}
