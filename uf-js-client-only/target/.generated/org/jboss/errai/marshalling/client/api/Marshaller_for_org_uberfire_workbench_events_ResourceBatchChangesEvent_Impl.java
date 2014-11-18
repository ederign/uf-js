package org.jboss.errai.marshalling.client.api;

import java.util.Collection;
import java.util.Map;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.backend.vfs.Path;
import org.uberfire.rpc.SessionInfo;
import org.uberfire.workbench.events.ResourceBatchChangesEvent;
import org.uberfire.workbench.events.ResourceChange;

public class Marshaller_for_org_uberfire_workbench_events_ResourceBatchChangesEvent_Impl implements GeneratedMarshaller<ResourceBatchChangesEvent> {
  private ResourceBatchChangesEvent[] EMPTY_ARRAY = new ResourceBatchChangesEvent[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<SessionInfo> org_uberfire_rpc_SessionInfo = Marshalling.getMarshaller(SessionInfo.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  public ResourceBatchChangesEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _939234961__1195259493_message(ResourceBatchChangesEvent instance) /*-{
    return instance.@org.uberfire.workbench.events.ResourceBatchChangesEvent::message;
  }-*/;

  private native static void _939234961__1195259493_message(ResourceBatchChangesEvent instance, String value) /*-{
    instance.@org.uberfire.workbench.events.ResourceBatchChangesEvent::message = value;
  }-*/;

  private native static SessionInfo _939234961__291376327_sessionInfo(ResourceBatchChangesEvent instance) /*-{
    return instance.@org.uberfire.workbench.events.ResourceBatchChangesEvent::sessionInfo;
  }-*/;

  private native static void _939234961__291376327_sessionInfo(ResourceBatchChangesEvent instance, SessionInfo value) /*-{
    instance.@org.uberfire.workbench.events.ResourceBatchChangesEvent::sessionInfo = value;
  }-*/;

  private native static Map _939234961__$1383349348_batch(ResourceBatchChangesEvent instance) /*-{
    return instance.@org.uberfire.workbench.events.ResourceBatchChangesEvent::batch;
  }-*/;

  private native static void _939234961__$1383349348_batch(ResourceBatchChangesEvent instance, Map<Path, Collection<ResourceChange>> value) /*-{
    instance.@org.uberfire.workbench.events.ResourceBatchChangesEvent::batch = value;
  }-*/;

  public ResourceBatchChangesEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ResourceBatchChangesEvent.class, objId);
    }
    ResourceBatchChangesEvent entity = new ResourceBatchChangesEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("message")) && (!obj.get("message").isNull())) {
      _939234961__1195259493_message(entity, java_lang_String.demarshall(obj.get("message"), a1));
    }
    if ((obj.containsKey("sessionInfo")) && (!obj.get("sessionInfo").isNull())) {
      _939234961__291376327_sessionInfo(entity, org_uberfire_rpc_SessionInfo.demarshall(obj.get("sessionInfo"), a1));
    }
    if ((obj.containsKey("batch")) && (!obj.get("batch").isNull())) {
      a1.setAssumedMapKeyType("org.uberfire.backend.vfs.Path");
      a1.setAssumedMapValueType("java.util.Collection");
      _939234961__$1383349348_batch(entity, java_util_Map.demarshall(obj.get("batch"), a1));
      a1.resetAssumedTypes();
    }
    return entity;
  }

  public String marshall(ResourceBatchChangesEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.workbench.events.ResourceBatchChangesEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"message\":").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"sessionInfo\":").append(org_uberfire_rpc_SessionInfo.marshall(a0.getSessionInfo(), a1)).append(",").append("\"batch\":").append(java_util_Map.marshall(a0.getBatch(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}