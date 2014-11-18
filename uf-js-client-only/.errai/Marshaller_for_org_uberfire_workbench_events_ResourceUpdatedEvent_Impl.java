package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.backend.vfs.Path;
import org.uberfire.rpc.SessionInfo;
import org.uberfire.workbench.events.ResourceUpdated;
import org.uberfire.workbench.events.ResourceUpdatedEvent;

public class Marshaller_for_org_uberfire_workbench_events_ResourceUpdatedEvent_Impl implements GeneratedMarshaller<ResourceUpdatedEvent> {
  private ResourceUpdatedEvent[] EMPTY_ARRAY = new ResourceUpdatedEvent[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<SessionInfo> org_uberfire_rpc_SessionInfo = Marshalling.getMarshaller(SessionInfo.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ResourceUpdatedEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Path _2136009215__$2084529122_path(ResourceUpdatedEvent instance) /*-{
    return instance.@org.uberfire.workbench.events.ResourceUpdatedEvent::path;
  }-*/;

  private native static void _2136009215__$2084529122_path(ResourceUpdatedEvent instance, Path value) /*-{
    instance.@org.uberfire.workbench.events.ResourceUpdatedEvent::path = value;
  }-*/;

  private native static SessionInfo _2136009215__291376327_sessionInfo(ResourceUpdatedEvent instance) /*-{
    return instance.@org.uberfire.workbench.events.ResourceUpdatedEvent::sessionInfo;
  }-*/;

  private native static void _2136009215__291376327_sessionInfo(ResourceUpdatedEvent instance, SessionInfo value) /*-{
    instance.@org.uberfire.workbench.events.ResourceUpdatedEvent::sessionInfo = value;
  }-*/;

  private native static String _1788295515__1195259493_message(ResourceUpdated instance) /*-{
    return instance.@org.uberfire.workbench.events.ResourceUpdated::message;
  }-*/;

  private native static void _1788295515__1195259493_message(ResourceUpdated instance, String value) /*-{
    instance.@org.uberfire.workbench.events.ResourceUpdated::message = value;
  }-*/;

  public ResourceUpdatedEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ResourceUpdatedEvent.class, objId);
    }
    ResourceUpdatedEvent entity = new ResourceUpdatedEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("path")) && (!obj.get("path").isNull())) {
      _2136009215__$2084529122_path(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("path"), a1));
    }
    if ((obj.containsKey("sessionInfo")) && (!obj.get("sessionInfo").isNull())) {
      _2136009215__291376327_sessionInfo(entity, org_uberfire_rpc_SessionInfo.demarshall(obj.get("sessionInfo"), a1));
    }
    if ((obj.containsKey("message")) && (!obj.get("message").isNull())) {
      _1788295515__1195259493_message(entity, java_lang_String.demarshall(obj.get("message"), a1));
    }
    return entity;
  }

  public String marshall(ResourceUpdatedEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.workbench.events.ResourceUpdatedEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"path\":").append(java_lang_Object.marshall(a0.getPath(), a1)).append(",").append("\"sessionInfo\":").append(org_uberfire_rpc_SessionInfo.marshall(a0.getSessionInfo(), a1)).append(",").append("\"message\":").append(java_lang_String.marshall(a0.getMessage(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}