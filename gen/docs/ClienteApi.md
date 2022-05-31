# ClienteApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**clientClientIdGet**](ClienteApi.md#clientClientIdGet) | **GET** /client/{clientId} | Obtener informacion del cliente
[**clientClientIdOrdersGet**](ClienteApi.md#clientClientIdOrdersGet) | **GET** /client/{clientId}/orders | Obtener pedidos del cliente
[**clientClientIdPaymentsGet**](ClienteApi.md#clientClientIdPaymentsGet) | **GET** /client/{clientId}/payments | Obtiene datos de la ultima tarjeta usada por el cliente
[**clientClientIdPaymentsPost**](ClienteApi.md#clientClientIdPaymentsPost) | **POST** /client/{clientId}/payments | Guardar la informacion de pago de un usuario
[**clientClientIdPut**](ClienteApi.md#clientClientIdPut) | **PUT** /client/{clientId} | Actualizar informacion del cliente


<a name="clientClientIdGet"></a>
# **clientClientIdGet**
> Client clientClientIdGet(clientId)

Obtener informacion del cliente

Actualiza la informacion del cliente 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ClienteApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    ClienteApi apiInstance = new ClienteApi(defaultClient);
    String clientId = "clientId_example"; // String | Referencia de usuario
    try {
      Client result = apiInstance.clientClientIdGet(clientId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ClienteApi#clientClientIdGet");
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
 **clientId** | **String**| Referencia de usuario |

### Return type

[**Client**](Client.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Se Obtienen datos del cliente |  -  |
**400** | Error al obtener datos |  -  |
**404** | Cliente no encontrado |  -  |

<a name="clientClientIdOrdersGet"></a>
# **clientClientIdOrdersGet**
> List&lt;Object&gt; clientClientIdOrdersGet(clientId)

Obtener pedidos del cliente

Obtener la lista de pedidos hechos por el cliente 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ClienteApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    ClienteApi apiInstance = new ClienteApi(defaultClient);
    String clientId = "clientId_example"; // String | Referencia de usuario
    try {
      List<Object> result = apiInstance.clientClientIdOrdersGet(clientId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ClienteApi#clientClientIdOrdersGet");
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
 **clientId** | **String**| Referencia de usuario |

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
**200** | Lista de pedidos |  -  |
**404** | El usuario no tiene pedidos anteriores |  -  |

<a name="clientClientIdPaymentsGet"></a>
# **clientClientIdPaymentsGet**
> Payment clientClientIdPaymentsGet(clientId)

Obtiene datos de la ultima tarjeta usada por el cliente

Obtiene datos de la ultima tarjeta usada por el cleiente 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ClienteApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    ClienteApi apiInstance = new ClienteApi(defaultClient);
    Integer clientId = 56; // Integer | Referencia al usuario
    try {
      Payment result = apiInstance.clientClientIdPaymentsGet(clientId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ClienteApi#clientClientIdPaymentsGet");
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
 **clientId** | **Integer**| Referencia al usuario |

### Return type

[**Payment**](Payment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Metodo de pago |  -  |
**400** | Error al obtener metodo de pago |  -  |
**404** | No se encontraron metodo de pago |  -  |

<a name="clientClientIdPaymentsPost"></a>
# **clientClientIdPaymentsPost**
> clientClientIdPaymentsPost(clientId, body)

Guardar la informacion de pago de un usuario

Guarda informacion del pago  

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ClienteApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    ClienteApi apiInstance = new ClienteApi(defaultClient);
    Integer clientId = 56; // Integer | Referencia al usuario
    Payment body = new Payment(); // Payment | Informacion del metodo de pago
    try {
      apiInstance.clientClientIdPaymentsPost(clientId, body);
    } catch (ApiException e) {
      System.err.println("Exception when calling ClienteApi#clientClientIdPaymentsPost");
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
 **clientId** | **Integer**| Referencia al usuario |
 **body** | [**Payment**](Payment.md)| Informacion del metodo de pago |

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
**200** | Se guardaron los datos correctamente |  -  |
**400** | Error al guardar los datos |  -  |

<a name="clientClientIdPut"></a>
# **clientClientIdPut**
> clientClientIdPut(clientId, body)

Actualizar informacion del cliente

Actualiza la informacion del cliente 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ClienteApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    ClienteApi apiInstance = new ClienteApi(defaultClient);
    String clientId = "clientId_example"; // String | Referencia de usuario
    Client body = new Client(); // Client | En body se envia la informacion
    try {
      apiInstance.clientClientIdPut(clientId, body);
    } catch (ApiException e) {
      System.err.println("Exception when calling ClienteApi#clientClientIdPut");
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
 **clientId** | **String**| Referencia de usuario |
 **body** | [**Client**](Client.md)| En body se envia la informacion |

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
**200** | Se guardaron satisfactoriamente los cambios |  -  |
**400** | Error al actualizar la informacion |  -  |
**404** | No se encontro al usuario |  -  |

