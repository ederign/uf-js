package org.jboss.errai.ioc.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class BootstrapperImpl_org_uberfire_client_screens_MoodScreenTemplateResource_default_InlineClientBundleGenerator implements org.jboss.errai.ioc.client.BootstrapperImpl.org_uberfire_client_screens_MoodScreenTemplateResource {
  private static BootstrapperImpl_org_uberfire_client_screens_MoodScreenTemplateResource_default_InlineClientBundleGenerator _instance0 = new BootstrapperImpl_org_uberfire_client_screens_MoodScreenTemplateResource_default_InlineClientBundleGenerator();
  private void getContentsInitializer() {
    getContents = new com.google.gwt.resources.client.TextResource() {
      // file:/Users/ederign/projects/uf-js/uf-js-client-only/target/classes/org/uberfire/client/screens/MoodScreen.html
      public String getText() {
        return "<div>\n    <div style=\"border: 1px solid red; padding: 30px\">\n      <input data-field=moodTextBox type=text placeholder=\"How do you feel?\">\n    </div>\n</div>";
      }
      public String getName() {
        return "getContents";
      }
    }
    ;
  }
  private static class getContentsInitializer {
    static {
      _instance0.getContentsInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return getContents;
    }
  }
  public com.google.gwt.resources.client.TextResource getContents() {
    return getContentsInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.resources.client.TextResource getContents;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      getContents(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("getContents", getContents());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'getContents': return this.@org.jboss.errai.ioc.client.BootstrapperImpl.org_uberfire_client_screens_MoodScreenTemplateResource::getContents()();
    }
    return null;
  }-*/;
}
