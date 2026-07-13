import { PluginListenerHandle } from "@capacitor/core";

/**
 * Información del dispositivo
 * 
 * @interface DeviceInfo
 * 
 * @property {string} modelo - Modelo del dispositivo
 * @property {string} versionAndroid - Versión de Android
 */
export interface DeviceInfo {
  /**
   * Es el modelo del dispositovo
   */
  modelo: string;
  /**
   * Es la version del dispositivo
   */
  versionAndroid: string;
}

export interface ShowMessage {
  texto: string,
  duracionLarga?: boolean
}

export interface ShowMessageToasty extends Omit<ShowMessage, 'duracionLarga'> { }


export interface MiPrimerPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  obtenerInfoDispositivo(): Promise<DeviceInfo>;
  mostrarMensaje(params: ShowMessage): Promise<void>;
  iniciarTareaLarga(): Promise<void>;
  mostrarMensajeToasty(params: ShowMessageToasty): Promise<void>;
  addListener(
    eventName: 'onProgreso',
    listenerFunc: (info: { porcentaje: number }) => void
  ): Promise<PluginListenerHandle> & PluginListenerHandle;
}
