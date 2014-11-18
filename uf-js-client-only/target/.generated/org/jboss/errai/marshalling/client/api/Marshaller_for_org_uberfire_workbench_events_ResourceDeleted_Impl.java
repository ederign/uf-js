package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.workbench.events.ResourceDeleted;

public class Marshaller_for_org_uberfire_workbench_events_ResourceDeleted_Impl implements GeneratedMarshaller<ResourceDeleted> {
  private ResourceDeleted[] EMPTY_ARRAY = new ResourceDeleted[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ResourceDeleted[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$721778503__1195259493_message(ResourceDeleted instance) /*-{
    return instance.@org.uberfire.workbench.events.ResourceDeleted::message;
  }-*/;

  private native static void _$721778503__1195259493_message(ResourceDeleted instance, String value) /*-{
    instance.@org.uberfire.workbench.events.ResourceDeleted::message = value;
  }-*/;

  public ResourceDeleted demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ResourceDeleted.class, objId);
    }
    ResourceDeleted entity = new ResourceDeleted();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("message")) && (!obj.get("message").isNull())) {
      _$721778503__1195259493_message(entity, java_lang_String.demarshall(obj.get("message"), a1));
    }
    return entity;
  }

  public String marshall(ResourceDeleted a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.workbench.events.ResourceDeleted\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"message\":").append(java_lang_String.marshall(a0.getMessage(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}