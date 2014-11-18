package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.backend.vfs.Path;
import org.uberfire.rpc.SessionInfo;
import org.uberfire.workbench.events.ResourceDeleted;
import org.uberfire.workbench.events.ResourceDeletedEvent;

public class Marshaller_for_org_uberfire_workbench_events_ResourceDeletedEvent_Impl implements GeneratedMarshaller<ResourceDeletedEvent> {
  private ResourceDeletedEvent[] EMPTY_ARRAY = new ResourceDeletedEvent[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<SessionInfo> org_uberfire_rpc_SessionInfo = Marshalling.getMarshaller(SessionInfo.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ResourceDeletedEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Path _$1978759839__$2084529122_path(ResourceDeletedEvent instance) /*-{
    return instance.@org.uberfire.workbench.events.ResourceDeletedEvent::path;
  }-*/;

  private native static void _$1978759839__$2084529122_path(ResourceDeletedEvent instance, Path value) /*-{
    instance.@org.uberfire.workbench.events.ResourceDeletedEvent::path = value;
  }-*/;

  private native static SessionInfo _$1978759839__291376327_sessionInfo(ResourceDeletedEvent instance) /*-{
    return instance.@org.uberfire.workbench.events.ResourceDeletedEvent::sessionInfo;
  }-*/;

  private native static void _$1978759839__291376327_sessionInfo(ResourceDeletedEvent instance, SessionInfo value) /*-{
    instance.@org.uberfire.workbench.events.ResourceDeletedEvent::sessionInfo = value;
  }-*/;

  private native static String _$721778503__1195259493_message(ResourceDeleted instance) /*-{
    return instance.@org.uberfire.workbench.events.ResourceDeleted::message;
  }-*/;

  private native static void _$721778503__1195259493_message(ResourceDeleted instance, String value) /*-{
    instance.@org.uberfire.workbench.events.ResourceDeleted::message = value;
  }-*/;

  public ResourceDeletedEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ResourceDeletedEvent.class, objId);
    }
    ResourceDeletedEvent entity = new ResourceDeletedEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("path")) && (!obj.get("path").isNull())) {
      _$1978759839__$2084529122_path(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("path"), a1));
    }
    if ((obj.containsKey("sessionInfo")) && (!obj.get("sessionInfo").isNull())) {
      _$1978759839__291376327_sessionInfo(entity, org_uberfire_rpc_SessionInfo.demarshall(obj.get("sessionInfo"), a1));
    }
    if ((obj.containsKey("message")) && (!obj.get("message").isNull())) {
      _$721778503__1195259493_message(entity, java_lang_String.demarshall(obj.get("message"), a1));
    }
    return entity;
  }

  public String marshall(ResourceDeletedEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.workbench.events.ResourceDeletedEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"path\":").append(java_lang_Object.marshall(a0.getPath(), a1)).append(",").append("\"sessionInfo\":").append(org_uberfire_rpc_SessionInfo.marshall(a0.getSessionInfo(), a1)).append(",").append("\"message\":").append(java_lang_String.marshall(a0.getMessage(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}