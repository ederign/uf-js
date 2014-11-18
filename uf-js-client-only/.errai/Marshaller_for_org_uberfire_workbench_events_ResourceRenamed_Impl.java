package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.backend.vfs.Path;
import org.uberfire.workbench.events.ResourceRenamed;

public class Marshaller_for_org_uberfire_workbench_events_ResourceRenamed_Impl implements GeneratedMarshaller<ResourceRenamed> {
  private ResourceRenamed[] EMPTY_ARRAY = new ResourceRenamed[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ResourceRenamed[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Path _$1179907706__$2084529122_destinationPath(ResourceRenamed instance) /*-{
    return instance.@org.uberfire.workbench.events.ResourceRenamed::destinationPath;
  }-*/;

  private native static void _$1179907706__$2084529122_destinationPath(ResourceRenamed instance, Path value) /*-{
    instance.@org.uberfire.workbench.events.ResourceRenamed::destinationPath = value;
  }-*/;

  private native static String _$1179907706__1195259493_message(ResourceRenamed instance) /*-{
    return instance.@org.uberfire.workbench.events.ResourceRenamed::message;
  }-*/;

  private native static void _$1179907706__1195259493_message(ResourceRenamed instance, String value) /*-{
    instance.@org.uberfire.workbench.events.ResourceRenamed::message = value;
  }-*/;

  public ResourceRenamed demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ResourceRenamed.class, objId);
    }
    ResourceRenamed entity = new ResourceRenamed();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("destinationPath")) && (!obj.get("destinationPath").isNull())) {
      _$1179907706__$2084529122_destinationPath(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("destinationPath"), a1));
    }
    if ((obj.containsKey("message")) && (!obj.get("message").isNull())) {
      _$1179907706__1195259493_message(entity, java_lang_String.demarshall(obj.get("message"), a1));
    }
    return entity;
  }

  public String marshall(ResourceRenamed a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.workbench.events.ResourceRenamed\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"destinationPath\":").append(java_lang_Object.marshall(a0.getDestinationPath(), a1)).append(",").append("\"message\":").append(java_lang_String.marshall(a0.getMessage(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}