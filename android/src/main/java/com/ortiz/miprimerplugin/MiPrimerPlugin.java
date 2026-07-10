package com.ortiz.miprimerplugin;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "MiPrimer")
public class MiPrimerPlugin extends Plugin {

    private MiPrimer implementation = new MiPrimer();

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod
    public void obtenerInfoDispositivo(PluginCall call) {
        JSObject ret = implementation.obtenerInfo();
        call.resolve(ret);
    }

    @PluginMethod
    public void mostrarMensaje(PluginCall call) {
        String texto = call.getString("texto");
        boolean duracionLarga = call.getBoolean("duracionLarga", false);

        if(texto == null) {
            call.reject("El texto no puede ser nulo");
            return;
        }

        getActivity().runOnUiThread(() -> {
            implementation.lanzarToast(getContext(), texto, duracionLarga);
            call.resolve();
        });
    }

    @PluginMethod
    public void iniciarTareaLarga(PluginCall call) {
        call.resolve();

        implementation.ejecutarTareaLarga(porcentaje -> {
            JSObject ret = new JSObject();
            ret.put("porcentaje", porcentaje);
            notifyListeners("onProgreso", ret);
        });
    }

    @PluginMethod
    public void mostrarMensajeToasty(PluginCall call) {
        String mensaje = call.getString("texto", "¡Éxito desde Toasty!");

        try {
            implementation.mostrarToastyExito(getActivity(), getContext(), mensaje, new MiPrimer.ActionCallback() {
                @Override
                public void onSuccess() {
                    call.resolve();
                }

                @Override
                public void onError(String error) {
                    call.reject(error);
                }
            });
        } catch (Exception e){
            call.reject(e.getMessage());
        }
    }
}
