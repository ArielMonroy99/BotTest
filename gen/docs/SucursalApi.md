# SucursalApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**sucursalGet**](SucursalApi.md#sucursalGet) | **GET** /sucursal/ | Todos los datos de las sucursales
[**sucursalPost**](SucursalApi.md#sucursalPost) | **POST** /sucursal | Crea una nueva sucursal
[**sucursalSucursalIDGet**](SucursalApi.md#sucursalSucursalIDGet) | **GET** /sucursal/{sucursalID} | Obtener la informacion de una sucursal


<a name="sucursalGet"></a>
# **sucursalGet**
> List&lt;Object&gt; sucursalGet()

Todos los datos de las sucursales

Obtener datos sobre las sucursales

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SucursalApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    SucursalApi apiInstance = new SucursalApi(defaultClient);
    try {
      List<Object> result = apiInstance.sucursalGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SucursalApi#sucursalGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

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
**200** | Lista de todas las sucursales |  -  |
**404** | No se encontro la lista de sucursales |  -  |

<a name="sucursalPost"></a>
# **sucursalPost**
> sucursalPost(body)

Crea una nueva sucursal

Crea una nueva sucursal 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SucursalApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    SucursalApi apiInstance = new SucursalApi(defaultClient);
    SucursalData body = new SucursalData(); // SucursalData | Se añadira a las sucursales
    try {
      apiInstance.sucursalPost(body);
    } catch (ApiException e) {
      System.err.println("Exception when calling SucursalApi#sucursalPost");
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
 **body** | [**SucursalData**](SucursalData.md)| Se añadira a las sucursales |

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
**200** | Se creo una nueva sucursal |  -  |
**400** | Error al crear una nueva sucursal |  -  |

<a name="sucursalSucursalIDGet"></a>
# **sucursalSucursalIDGet**
> SucursalData sucursalSucursalIDGet(sucursalID)

Obtener la informacion de una sucursal

Obtener la informacion de una sucursal

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SucursalApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    SucursalApi apiInstance = new SucursalApi(defaultClient);
    String sucursalID = "sucursalID_example"; // String | Obtener datos de una sucursal
    try {
      SucursalData result = apiInstance.sucursalSucursalIDGet(sucursalID);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SucursalApi#sucursalSucursalIDGet");
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
 **sucursalID** | **String**| Obtener datos de una sucursal |

### Return type

[**SucursalData**](SucursalData.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Informacion de una sucursal |  -  |
**404** | No se encontro la informacion del plato |  -  |

