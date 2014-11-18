package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.backend.vfs.Path;
import org.uberfire.rpc.SessionInfo;
import org.uberfire.workbench.events.ResourceOpenedEvent;

public class Marshaller_for_org_uberfire_workbench_events_ResourceOpenedEvent_Impl implements GeneratedMarshaller<ResourceOpenedEvent> {
  private ResourceOpenedEvent[] EMPTY_ARRAY = new ResourceOpenedEvent[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<SessionInfo> org_uberfire_rpc_SessionInfo = Marshalling.getMarshaller(SessionInfo.class);
  public ResourceOpenedEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Path _$1342399407__$2084529122_path(ResourceOpenedEvent instance) /*-{
    return instance.@org.uberfire.workbench.events.ResourceOpenedEvent::path;
  }-*/;

  private native static void _$1342399407__$2084529122_path(ResourceOpenedEvent instance, Path value) /*-{
    instance.@org.uberfire.workbench.events.ResourceOpenedEvent::path = value;
  }-*/;

  private native static SessionInfo _$1342399407__291376327_sessionInfo(ResourceOpenedEvent instance) /*-{
    return instance.@org.uberfire.workbench.events.ResourceOpenedEvent::sessionInfo;
  }-*/;

  private native static void _$1342399407__291376327_sessionInfo(ResourceOpenedEvent instance, SessionInfo value) /*-{
    instance.@org.uberfire.workbench.events.ResourceOpenedEvent::sessionInfo = value;
  }-*/;

  public ResourceOpenedEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ResourceOpenedEvent.class, objId);
    }
    ResourceOpenedEvent entity = new ResourceOpenedEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("path")) && (!obj.get("path").isNull())) {
      _$1342399407__$2084529122_path(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("path"), a1));
    }
    if ((obj.containsKey("sessionInfo")) && (!obj.get("sessionInfo").isNull())) {
      _$1342399407__291376327_sessionInfo(entity, org_uberfire_rpc_SessionInfo.demarshall(obj.get("sessionInfo"), a1));
    }
    return entity;
  }

  public String marshall(ResourceOpenedEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.workbench.events.ResourceOpenedEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"path\":").append(java_lang_Object.marshall(a0.getPath(), a1)).append(",").append("\"sessionInfo\":").append(org_uberfire_rpc_SessionInfo.marshall(a0.getSessionInfo(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}