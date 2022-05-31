# MenuApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**menuCategoriesGet**](MenuApi.md#menuCategoriesGet) | **GET** /menu/categories | Obtener las categorias del Menu
[**menuDessertpopularGet**](MenuApi.md#menuDessertpopularGet) | **GET** /menu/dessertpopular | Obtener los postrs mas populares
[**menuDessertsGet**](MenuApi.md#menuDessertsGet) | **GET** /menu/desserts | Todos los postres que ofrece el restaurante
[**menuMainPopularGet**](MenuApi.md#menuMainPopularGet) | **GET** /menu/mainPopular | Obtener los platos principales mas populares
[**menuMaindishesGet**](MenuApi.md#menuMaindishesGet) | **GET** /menu/maindishes | Todos los platos principales que ofrece el restaurante
[**menuPlateIdGet**](MenuApi.md#menuPlateIdGet) | **GET** /menu/{plateId} | Obtener la informacion de un plato
[**menuSoupsGet**](MenuApi.md#menuSoupsGet) | **GET** /menu/soups | Todas las sopas que ofrece el restaurante


<a name="menuCategoriesGet"></a>
# **menuCategoriesGet**
> List&lt;Object&gt; menuCategoriesGet()

Obtener las categorias del Menu

Obtener la lista de categorias que tiene el restaurante

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MenuApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    MenuApi apiInstance = new MenuApi(defaultClient);
    try {
      List<Object> result = apiInstance.menuCategoriesGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MenuApi#menuCategoriesGet");
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
**200** | Lista de categorias del restaurante |  -  |
**404** | No se encuentra la lista de categorias |  -  |

<a name="menuDessertpopularGet"></a>
# **menuDessertpopularGet**
> List&lt;Object&gt; menuDessertpopularGet()

Obtener los postrs mas populares

Obtener una lista de los postres populares del restaurante

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MenuApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    MenuApi apiInstance = new MenuApi(defaultClient);
    try {
      List<Object> result = apiInstance.menuDessertpopularGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MenuApi#menuDessertpopularGet");
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
**200** | Lista de los postres mas populares |  -  |
**404** | No se encuentra la lista de postres populares |  -  |

<a name="menuDessertsGet"></a>
# **menuDessertsGet**
> List&lt;Object&gt; menuDessertsGet()

Todos los postres que ofrece el restaurante

Obtener una lista de todos los postres que ofrece el restaurante

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MenuApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    MenuApi apiInstance = new MenuApi(defaultClient);
    try {
      List<Object> result = apiInstance.menuDessertsGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MenuApi#menuDessertsGet");
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
**200** | Lista de todos los platos |  -  |
**404** | No se encontro la lista de sopas |  -  |

<a name="menuMainPopularGet"></a>
# **menuMainPopularGet**
> List&lt;Object&gt; menuMainPopularGet()

Obtener los platos principales mas populares

Obtener una lista de los platos principales populares del restaurante

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MenuApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    MenuApi apiInstance = new MenuApi(defaultClient);
    try {
      List<Object> result = apiInstance.menuMainPopularGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MenuApi#menuMainPopularGet");
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
**200** | Lista de platos principales mas populares |  -  |
**404** | No se encuentra la lista de platos princiaples populares |  -  |

<a name="menuMaindishesGet"></a>
# **menuMaindishesGet**
> List&lt;Object&gt; menuMaindishesGet()

Todos los platos principales que ofrece el restaurante

Obtener una lista de todos los platos principales que ofrece el restaurante

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MenuApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    MenuApi apiInstance = new MenuApi(defaultClient);
    try {
      List<Object> result = apiInstance.menuMaindishesGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MenuApi#menuMaindishesGet");
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
**200** | Lista de todos los platos |  -  |
**404** | No se encontro la lista de platos principales |  -  |

<a name="menuPlateIdGet"></a>
# **menuPlateIdGet**
> List&lt;Object&gt; menuPlateIdGet(plateId)

Obtener la informacion de un plato

Obtener la informacion de un plato

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MenuApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    MenuApi apiInstance = new MenuApi(defaultClient);
    String plateId = "plateId_example"; // String | Obtener datos de un plato
    try {
      List<Object> result = apiInstance.menuPlateIdGet(plateId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MenuApi#menuPlateIdGet");
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
 **plateId** | **String**| Obtener datos de un plato |

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
**200** | Informacion del plato |  -  |
**404** | No se encontro la informacion del plato |  -  |

<a name="menuSoupsGet"></a>
# **menuSoupsGet**
> List&lt;Object&gt; menuSoupsGet()

Todas las sopas que ofrece el restaurante

Obtener una lista de todas las sopas

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MenuApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    MenuApi apiInstance = new MenuApi(defaultClient);
    try {
      List<Object> result = apiInstance.menuSoupsGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MenuApi#menuSoupsGet");
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
**200** | Lista de todas las sopa |  -  |
**404** | No se encontro la lista de sopas |  -  |

