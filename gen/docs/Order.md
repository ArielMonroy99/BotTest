

# Order

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Integer** |  |  [optional]
**clienteId** | **Integer** |  |  [optional]
**sucursal** | **String** |  |  [optional]
**fecha** | **String** |  |  [optional]
**direccion** | [**OrderDireccion**](OrderDireccion.md) |  |  [optional]
**metodoPago** | [**MetodoPagoEnum**](#MetodoPagoEnum) |  |  [optional]
**delivery** | [**DeliveryEnum**](#DeliveryEnum) |  |  [optional]
**estado** | [**EstadoEnum**](#EstadoEnum) |  |  [optional]
**total** | **BigDecimal** |  |  [optional]
**platos** | [**List&lt;OrderPlatos&gt;**](OrderPlatos.md) |  |  [optional]



## Enum: MetodoPagoEnum

Name | Value
---- | -----
EFECTIVO | &quot;Efectivo&quot;
TARJETA | &quot;Tarjeta&quot;
QR | &quot;Qr&quot;



## Enum: DeliveryEnum

Name | Value
---- | -----
DELIVERY | &quot;Delivery&quot;
ENTREGA_EN_LOCAL | &quot;Entrega en local&quot;



## Enum: EstadoEnum

Name | Value
---- | -----
ENVIADO | &quot;Enviado&quot;
APROBADO | &quot;Aprobado&quot;
RECHAZADO | &quot;Rechazado&quot;
EN_CAMINO | &quot;En camino&quot;
ENTREGADO | &quot;Entregado&quot;



