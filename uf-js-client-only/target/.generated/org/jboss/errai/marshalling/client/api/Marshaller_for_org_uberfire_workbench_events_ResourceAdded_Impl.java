package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.workbench.events.ResourceAdded;

public class Marshaller_for_org_uberfire_workbench_events_ResourceAdded_Impl implements GeneratedMarshaller<ResourceAdded> {
  private ResourceAdded[] EMPTY_ARRAY = new ResourceAdded[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ResourceAdded[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _1234428320__1195259493_message(ResourceAdded instance) /*-{
    return instance.@org.uberfire.workbench.events.ResourceAdded::message;
  }-*/;

  private native static void _1234428320__1195259493_message(ResourceAdded instance, String value) /*-{
    instance.@org.uberfire.workbench.events.ResourceAdded::message = value;
  }-*/;

  public ResourceAdded demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ResourceAdded.class, objId);
    }
    ResourceAdded entity = new ResourceAdded();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("message")) && (!obj.get("message").isNull())) {
      _1234428320__1195259493_message(entity, java_lang_String.demarshall(obj.get("message"), a1));
    }
    return entity;
  }

  public String marshall(ResourceAdded a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.workbench.events.ResourceAdded\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"message\":").append(java_lang_String.marshall(a0.getMessage(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}