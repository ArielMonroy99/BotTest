# OrdenApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**orderClientIdOrderPost**](OrdenApi.md#orderClientIdOrderPost) | **POST** /order/{clientId}/Order | Enviar la orden al listado
[**platoPlateIdGet**](OrdenApi.md#platoPlateIdGet) | **GET** /plato/{plateId} | Obtener la informacion del plato


<a name="orderClientIdOrderPost"></a>
# **orderClientIdOrderPost**
> orderClientIdOrderPost(clientId, body)

Enviar la orden al listado

Enviar la orden al listado

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OrdenApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    OrdenApi apiInstance = new OrdenApi(defaultClient);
    String clientId = "clientId_example"; // String | Referencia de cliente
    List<Object> body = null; // List<Object> | 
    try {
      apiInstance.orderClientIdOrderPost(clientId, body);
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdenApi#orderClientIdOrderPost");
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
 **clientId** | **String**| Referencia de cliente |
 **body** | [**List&lt;Object&gt;**](Object.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Se envio la orden |  -  |
**400** | Error al enviar la orden |  -  |

<a name="platoPlateIdGet"></a>
# **platoPlateIdGet**
> List&lt;Object&gt; platoPlateIdGet(plateId)

Obtener la informacion del plato

Obtener la informacion del plato selecionado

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OrdenApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    OrdenApi apiInstance = new OrdenApi(defaultClient);
    String plateId = "plateId_example"; // String | Obtener datos del plato
    try {
      List<Object> result = apiInstance.platoPlateIdGet(plateId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdenApi#platoPlateIdGet");
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
 **plateId** | **String**| Obtener datos del plato |

### Return type

**List&lt;Object&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Informacion del Plato |  -  |
**404** | No se encuentra el plato |  -  |

