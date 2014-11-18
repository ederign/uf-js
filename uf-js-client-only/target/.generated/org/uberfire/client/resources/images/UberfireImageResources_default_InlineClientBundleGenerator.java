package org.uberfire.client.resources.images;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class UberfireImageResources_default_InlineClientBundleGenerator implements org.uberfire.client.resources.images.UberfireImageResources {
  private static UberfireImageResources_default_InlineClientBundleGenerator _instance0 = new UberfireImageResources_default_InlineClientBundleGenerator();
  private void typeGenericFileInitializer() {
    typeGenericFile = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "typeGenericFile",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage),
      0, 0, 24, 24, false, false
    );
  }
  private static class typeGenericFileInitializer {
    static {
      _instance0.typeGenericFileInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return typeGenericFile;
    }
  }
  public com.google.gwt.resources.client.ImageResource typeGenericFile() {
    return typeGenericFileInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static final java.lang.String externalImage = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAAwklEQVR42mNgGAhgYGAgYGRkVGBiYtJALjY1NTXAaQFIQWRk5P/9+/f/P3PmDMm4p6fnv7Gx8XucFgAl94MUUgJADgQ61IFmFqSlpY1aMGrBqAWjFoxaMPgs+PTpE0qlQ9X6AGS4g4MD2FCQy4H6wTUasOpVoIoFe/fuBRsOsqi4uBhk+HmchsMsANXHxICnT5/+X7t2LdgCEAbqXQ9qNOBtVQAVBYC8DKq8Z86ciROD5FtbW/8XFBSAgwUY5v3oZgEAHoyQg9qq+sUAAAAASUVORK5CYII=";
  private static com.google.gwt.resources.client.ImageResource typeGenericFile;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      typeGenericFile(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("typeGenericFile", typeGenericFile());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'typeGenericFile': return this.@org.uberfire.client.resources.images.UberfireImageResources::typeGenericFile()();
    }
    return null;
  }-*/;
}
