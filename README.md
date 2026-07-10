# @ortiz/mi-primer-plugin

Mi primer plugin con capacitor

## Install

```bash
npm install @ortiz/mi-primer-plugin
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`obtenerInfoDispositivo()`](#obtenerinfodispositivo)
* [`mostrarMensaje(...)`](#mostrarmensaje)
* [`iniciarTareaLarga()`](#iniciartarealarga)
* [`mostrarMensajeToasty(...)`](#mostrarmensajetoasty)
* [`addListener('onProgreso', ...)`](#addlisteneronprogreso-)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### obtenerInfoDispositivo()

```typescript
obtenerInfoDispositivo() => Promise<DeviceInfo>
```

**Returns:** <code>Promise&lt;<a href="#deviceinfo">DeviceInfo</a>&gt;</code>

--------------------


### mostrarMensaje(...)

```typescript
mostrarMensaje(params: ShowMessage) => Promise<void>
```

| Param        | Type                                                |
| ------------ | --------------------------------------------------- |
| **`params`** | <code><a href="#showmessage">ShowMessage</a></code> |

--------------------


### iniciarTareaLarga()

```typescript
iniciarTareaLarga() => Promise<void>
```

--------------------


### mostrarMensajeToasty(...)

```typescript
mostrarMensajeToasty(params: ShowMessageToasty) => Promise<void>
```

| Param        | Type                                                            |
| ------------ | --------------------------------------------------------------- |
| **`params`** | <code><a href="#showmessagetoasty">ShowMessageToasty</a></code> |

--------------------


### addListener('onProgreso', ...)

```typescript
addListener(eventName: 'onProgreso', listenerFunc: (info: { porcentaje: number; }) => void) => Promise<PluginListenerHandle> & PluginListenerHandle
```

| Param              | Type                                                    |
| ------------------ | ------------------------------------------------------- |
| **`eventName`**    | <code>'onProgreso'</code>                               |
| **`listenerFunc`** | <code>(info: { porcentaje: number; }) =&gt; void</code> |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt; & <a href="#pluginlistenerhandle">PluginListenerHandle</a></code>

--------------------


### Interfaces


#### DeviceInfo

Información del dispositivo

| Prop                 | Type                | Description                   |
| -------------------- | ------------------- | ----------------------------- |
| **`modelo`**         | <code>string</code> | Es el modelo del dispositovo  |
| **`versionAndroid`** | <code>string</code> | Es la version del dispositivo |


#### ShowMessage

| Prop                | Type                 |
| ------------------- | -------------------- |
| **`texto`**         | <code>string</code>  |
| **`duracionLarga`** | <code>boolean</code> |


#### ShowMessageToasty


#### PluginListenerHandle

| Prop         | Type                                      |
| ------------ | ----------------------------------------- |
| **`remove`** | <code>() =&gt; Promise&lt;void&gt;</code> |

</docgen-api>
