package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.mvp.PlaceRequest;
import org.uberfire.workbench.model.impl.ContextDefinitionImpl;

public class Marshaller_for_org_uberfire_workbench_model_impl_ContextDefinitionImpl_Impl implements GeneratedMarshaller<ContextDefinitionImpl> {
  private ContextDefinitionImpl[] EMPTY_ARRAY = new ContextDefinitionImpl[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public ContextDefinitionImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ContextDefinitionImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ContextDefinitionImpl.class, objId);
    }
    ContextDefinitionImpl entity = new ContextDefinitionImpl();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("place")) && (!obj.get("place").isNull())) {
      entity.setPlace((PlaceRequest) ((ObjectMarshaller) java_lang_Object).demarshall(PlaceRequest.class, obj.get("place"), a1));
    }
    return entity;
  }

  public String marshall(ContextDefinitionImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.workbench.model.impl.ContextDefinitionImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"place\":").append(java_lang_Object.marshall(a0.getPlace(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}