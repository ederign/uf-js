package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.backend.vfs.Path;
import org.uberfire.workbench.events.ResourceCopied;

public class Marshaller_for_org_uberfire_workbench_events_ResourceCopied_Impl implements GeneratedMarshaller<ResourceCopied> {
  private ResourceCopied[] EMPTY_ARRAY = new ResourceCopied[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ResourceCopied[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Path _$319649244__$2084529122_destinationPath(ResourceCopied instance) /*-{
    return instance.@org.uberfire.workbench.events.ResourceCopied::destinationPath;
  }-*/;

  private native static void _$319649244__$2084529122_destinationPath(ResourceCopied instance, Path value) /*-{
    instance.@org.uberfire.workbench.events.ResourceCopied::destinationPath = value;
  }-*/;

  private native static String _$319649244__1195259493_message(ResourceCopied instance) /*-{
    return instance.@org.uberfire.workbench.events.ResourceCopied::message;
  }-*/;

  private native static void _$319649244__1195259493_message(ResourceCopied instance, String value) /*-{
    instance.@org.uberfire.workbench.events.ResourceCopied::message = value;
  }-*/;

  public ResourceCopied demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ResourceCopied.class, objId);
    }
    ResourceCopied entity = new ResourceCopied();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("destinationPath")) && (!obj.get("destinationPath").isNull())) {
      _$319649244__$2084529122_destinationPath(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("destinationPath"), a1));
    }
    if ((obj.containsKey("message")) && (!obj.get("message").isNull())) {
      _$319649244__1195259493_message(entity, java_lang_String.demarshall(obj.get("message"), a1));
    }
    return entity;
  }

  public String marshall(ResourceCopied a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.workbench.events.ResourceCopied\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"destinationPath\":").append(java_lang_Object.marshall(a0.getDestinationPath(), a1)).append(",").append("\"message\":").append(java_lang_String.marshall(a0.getMessage(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}