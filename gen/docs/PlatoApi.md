# PlatoApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**platePlateIdDelete**](PlatoApi.md#platePlateIdDelete) | **DELETE** /plate/{plateId} | Eliminar plato
[**platePlateIdGet**](PlatoApi.md#platePlateIdGet) | **GET** /plate/{plateId} | Obtener la informacion del plato
[**platePlateIdPut**](PlatoApi.md#platePlateIdPut) | **PUT** /plate/{plateId} | Actualizar informacion del plato
[**platePost**](PlatoApi.md#platePost) | **POST** /plate | Crea un nuevo plato


<a name="platePlateIdDelete"></a>
# **platePlateIdDelete**
> platePlateIdDelete(plateId, body)

Eliminar plato

Elimina el plato 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PlatoApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    PlatoApi apiInstance = new PlatoApi(defaultClient);
    Integer plateId = 56; // Integer | Referencia al plato
    Plate body = new Plate(); // Plate | En body se envia la informacion
    try {
      apiInstance.platePlateIdDelete(plateId, body);
    } catch (ApiException e) {
      System.err.println("Exception when calling PlatoApi#platePlateIdDelete");
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
 **plateId** | **Integer**| Referencia al plato |
 **body** | [**Plate**](Plate.md)| En body se envia la informacion |

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
**200** | Se elimino con exito |  -  |
**400** | Error al eliminar el plato |  -  |

<a name="platePlateIdGet"></a>
# **platePlateIdGet**
> Plate platePlateIdGet(plateId)

Obtener la informacion del plato

Obtiene todos los datos registrados del plato 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PlatoApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    PlatoApi apiInstance = new PlatoApi(defaultClient);
    Integer plateId = 56; // Integer | Referencia al plato
    try {
      Plate result = apiInstance.platePlateIdGet(plateId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PlatoApi#platePlateIdGet");
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
 **plateId** | **Integer**| Referencia al plato |

### Return type

[**Plate**](Plate.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Informacion del plato |  -  |
**400** | Error al obtener la informacion del plato |  -  |
**404** | No se encontraron datos del plato |  -  |

<a name="platePlateIdPut"></a>
# **platePlateIdPut**
> platePlateIdPut(plateId, body)

Actualizar informacion del plato

Actualiza los datos del plato 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PlatoApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    PlatoApi apiInstance = new PlatoApi(defaultClient);
    Integer plateId = 56; // Integer | Referencia al plato
    Plate body = new Plate(); // Plate | En body se envia la informacion
    try {
      apiInstance.platePlateIdPut(plateId, body);
    } catch (ApiException e) {
      System.err.println("Exception when calling PlatoApi#platePlateIdPut");
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
 **plateId** | **Integer**| Referencia al plato |
 **body** | [**Plate**](Plate.md)| En body se envia la informacion |

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
**400** | Error al actualizar la informacion del plato |  -  |

<a name="platePost"></a>
# **platePost**
> platePost(body)

Crea un nuevo plato

Crea en nuevo pedido 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PlatoApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    PlatoApi apiInstance = new PlatoApi(defaultClient);
    Plate body = new Plate(); // Plate | Plato que se añadira al manu
    try {
      apiInstance.platePost(body);
    } catch (ApiException e) {
      System.err.println("Exception when calling PlatoApi#platePost");
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
 **body** | [**Plate**](Plate.md)| Plato que se añadira al manu |

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
**200** | Se creo el nuevo plato satisfactoriamente |  -  |
**400** | Error al crear el nuevo plato |  -  |

