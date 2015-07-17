/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 ******************************************************************************/
package in.co.itasca.hms.api;

import static in.co.itasca.hms.api.CarEdmProvider.ENTITY_SET_NAME_CARS;
import static in.co.itasca.hms.api.CarEdmProvider.ENTITY_SET_NAME_MANUFACTURERS;
import in.co.itasca.hms.api.service.IService;
import in.co.itasca.hms.api.service.ServiceFactory;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.olingo.odata2.api.edm.EdmEntitySet;
import org.apache.olingo.odata2.api.edm.EdmLiteralKind;
import org.apache.olingo.odata2.api.edm.EdmProperty;
import org.apache.olingo.odata2.api.edm.EdmSimpleType;
import org.apache.olingo.odata2.api.ep.EntityProvider;
import org.apache.olingo.odata2.api.ep.EntityProviderWriteProperties;
import org.apache.olingo.odata2.api.ep.EntityProviderWriteProperties.ODataEntityProviderPropertiesBuilder;
import org.apache.olingo.odata2.api.exception.ODataException;
import org.apache.olingo.odata2.api.exception.ODataNotFoundException;
import org.apache.olingo.odata2.api.exception.ODataNotImplementedException;
import org.apache.olingo.odata2.api.processor.ODataResponse;
import org.apache.olingo.odata2.api.processor.ODataSingleProcessor;
import org.apache.olingo.odata2.api.uri.KeyPredicate;
import org.apache.olingo.odata2.api.uri.info.GetEntitySetUriInfo;
import org.apache.olingo.odata2.api.uri.info.GetEntityUriInfo;

public class CarODataSingleProcessor extends ODataSingleProcessor {

  private final CarDataStore dataStore;
  private HttpServletRequest request ;
  
  public CarODataSingleProcessor(HttpServletRequest request) {
	  this.request=request;
	  
	  dataStore = new CarDataStore();
  
  }

  @Override
  public ODataResponse readEntitySet(final GetEntitySetUriInfo uriInfo, final String contentType) 
      throws ODataException {

    EdmEntitySet entitySet;

    if (uriInfo.getNavigationSegments().size() == 0) {
      entitySet = uriInfo.getStartEntitySet();
      String entitySetName = entitySet.getName();
      IService service =ServiceFactory.getInstance(null).getService(entitySetName);
     List<Map<String, Object>> result = service.getRecords();
       return EntityProvider.writeFeed(contentType, entitySet, result,
            EntityProviderWriteProperties.serviceRoot(getContext().getPathInfo().getServiceRoot()).build());
//      if (ENTITY_SET_NAME_CARS.equals(entitySet.getName())) {
//        return EntityProvider.writeFeed(contentType, entitySet, dataStore.getCars(),
//            EntityProviderWriteProperties.serviceRoot(getContext().getPathInfo().getServiceRoot()).build());
//      } else if (ENTITY_SET_NAME_MANUFACTURERS.equals(entitySet.getName())) {
//        return EntityProvider.writeFeed(contentType, entitySet, dataStore.getManufacturers(),
//            EntityProviderWriteProperties.serviceRoot(getContext().getPathInfo().getServiceRoot()).build());
//      }

   //   throw new ODataNotFoundException(ODataNotFoundException.ENTITY);

    } else if (uriInfo.getNavigationSegments().size() == 1) {
      // navigation first level, simplified example for illustration purposes only
      entitySet = uriInfo.getTargetEntitySet();
     String name = uriInfo.getNavigationSegments().get(0).getNavigationProperty().getName();
     int key = getKeyValue(uriInfo.getKeyPredicates().get(0));
     ServiceFactory sf =ServiceFactory.getInstance(null);
     IService service =sf.getService(entitySet.getName());
     List<Map<String, Object>>  menu= service.getAssociation(key, name);
     return EntityProvider.writeFeed(contentType, entitySet, menu, EntityProviderWriteProperties.serviceRoot(
             getContext().getPathInfo().getServiceRoot()).build());
     
//     if (ENTITY_SET_NAME_CARS.equals(entitySet.getName())) {
//        int manufacturerKey = getKeyValue(uriInfo.getKeyPredicates().get(0));
//
//        List<Map<String, Object>> cars = new ArrayList<Map<String, Object>>();
//        cars.addAll(dataStore.getCarsFor(manufacturerKey));
//
//        return EntityProvider.writeFeed(contentType, entitySet, cars, EntityProviderWriteProperties.serviceRoot(
//            getContext().getPathInfo().getServiceRoot()).build());
//      }

//      throw new ODataNotFoundException(ODataNotFoundException.ENTITY);
    }

    throw new ODataNotImplementedException();
  }

  @Override
  public ODataResponse readEntity(final GetEntityUriInfo uriInfo, final String contentType) throws ODataException {

    if (uriInfo.getNavigationSegments().size() == 0) {
      EdmEntitySet entitySet = uriInfo.getStartEntitySet();
      int id = getKeyValue(uriInfo.getKeyPredicates().get(0));
      Map<String, Object> data =ServiceFactory.getInstance(null).getService(entitySet.getName()).getRecord(id);
      if (data != null) {
        URI serviceRoot = getContext().getPathInfo().getServiceRoot();
        ODataEntityProviderPropertiesBuilder propertiesBuilder =
            EntityProviderWriteProperties.serviceRoot(serviceRoot);

        return EntityProvider.writeEntry(contentType, entitySet, data, propertiesBuilder.build());
 }
      
    }
      
//      if (ENTITY_SET_NAME_CARS.equals(entitySet.getName())) {
//        int id = getKeyValue(uriInfo.getKeyPredicates().get(0));
//        Map<String, Object> data = dataStore.getCar(id);
//
//        if (data != null) {
//          URI serviceRoot = getContext().getPathInfo().getServiceRoot();
//          ODataEntityProviderPropertiesBuilder propertiesBuilder =
//              EntityProviderWriteProperties.serviceRoot(serviceRoot);
//
//          return EntityProvider.writeEntry(contentType, entitySet, data, propertiesBuilder.build());
//        }
//      } else if (ENTITY_SET_NAME_MANUFACTURERS.equals(entitySet.getName())) {
//        int id = getKeyValue(uriInfo.getKeyPredicates().get(0));
//        Map<String, Object> data = dataStore.getManufacturer(id);
//
//        if (data != null) {
//          URI serviceRoot = getContext().getPathInfo().getServiceRoot();
//          ODataEntityProviderPropertiesBuilder propertiesBuilder =
//              EntityProviderWriteProperties.serviceRoot(serviceRoot);
//
//          return EntityProvider.writeEntry(contentType, entitySet, data, propertiesBuilder.build());
//        }
//      }
//
//      throw new ODataNotFoundException(ODataNotFoundException.ENTITY);
//
//    } else if (uriInfo.getNavigationSegments().size() == 1) {
//      // navigation first level, simplified example for illustration purposes only
//      EdmEntitySet entitySet = uriInfo.getTargetEntitySet();
//
//      Map<String, Object> data = null;
//
//      if (ENTITY_SET_NAME_MANUFACTURERS.equals(entitySet.getName())) {
//        int carKey = getKeyValue(uriInfo.getKeyPredicates().get(0));
//        data = dataStore.getManufacturerFor(carKey);
//      }
//
//      if (data != null) {
//        return EntityProvider.writeEntry(contentType, uriInfo.getTargetEntitySet(),
//            data, EntityProviderWriteProperties.serviceRoot(getContext().getPathInfo().getServiceRoot()).build());
//      }
//
//      throw new ODataNotFoundException(ODataNotFoundException.ENTITY);
//    }

    throw new ODataNotImplementedException();
  }

  private int getKeyValue(final KeyPredicate key) throws ODataException {
    EdmProperty property = key.getProperty();
    EdmSimpleType type = (EdmSimpleType) property.getType();
    return type.valueOfString(key.getLiteral(), EdmLiteralKind.DEFAULT, property.getFacets(), Integer.class);
  }
}
