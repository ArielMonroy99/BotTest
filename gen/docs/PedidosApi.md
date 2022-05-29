# PedidosApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**ordersOrderIdGet**](PedidosApi.md#ordersOrderIdGet) | **GET** /orders/{orderId} | Obtener pedido por id
[**ordersOrderIdPut**](PedidosApi.md#ordersOrderIdPut) | **PUT** /orders/{orderId} | actualizar el estado por Id
[**ordersPost**](PedidosApi.md#ordersPost) | **POST** /orders | Crea un nuevo pedido


<a name="ordersOrderIdGet"></a>
# **ordersOrderIdGet**
> Order ordersOrderIdGet(orderId)

Obtener pedido por id

Obtener la informacion de un pedido por el id 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PedidosApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    PedidosApi apiInstance = new PedidosApi(defaultClient);
    String orderId = "orderId_example"; // String | 
    try {
      Order result = apiInstance.ordersOrderIdGet(orderId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PedidosApi#ordersOrderIdGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **orderId** | **String**|  |

### Return type

[**Order**](Order.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Informacion del pedido |  -  |
**404** | No se encontro el pedido |  -  |

<a name="ordersOrderIdPut"></a>
# **ordersOrderIdPut**
> ordersOrderIdPut(orderId, body)

actualizar el estado por Id

Actualizar el estado de un pedido por el id 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PedidosApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    PedidosApi apiInstance = new PedidosApi(defaultClient);
    String orderId = "orderId_example"; // String | Referencia al plato
    Order body = new Order(); // Order | En body se envia la informacion
    try {
      apiInstance.ordersOrderIdPut(orderId, body);
    } catch (ApiException e) {
      System.err.println("Exception when calling PedidosApi#ordersOrderIdPut");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **orderId** | **String**| Referencia al plato |
 **body** | [**Order**](Order.md)| En body se envia la informacion |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | El pedido fue enviado |  -  |
**404** | Error al actualizar el estado del pedido |  -  |

<a name="ordersPost"></a>
# **ordersPost**
> ordersPost(body)

Crea un nuevo pedido

Crea en nuevo pedido 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PedidosApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    PedidosApi apiInstance = new PedidosApi(defaultClient);
    Order body = new Order(); // Order | Pedido que se añadira al servicio
    try {
      apiInstance.ordersPost(body);
    } catch (ApiException e) {
      System.err.println("Exception when calling PedidosApi#ordersPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Order**](Order.md)| Pedido que se añadira al servicio |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Se creo el nuevo pedido satisfactoriamente |  -  |
**400** | Error al crear el nuevo pedido |  -  |

