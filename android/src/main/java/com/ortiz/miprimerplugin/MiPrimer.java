package com.ortiz.miprimerplugin;

import com.getcapacitor.JSObject;
import com.getcapacitor.Logger;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import es.dmoral.toasty.Toasty;

public class MiPrimer {

    public String echo(String value) {
        Logger.info("Echo", value);
        return value;
    }

    public JSObject obtenerInfo() {
        JSObject ret = new JSObject();
        ret.put("modelo", android.os.Build.MODEL);
        ret.put("versionAndroid", android.os.Build.VERSION.RELEASE);
        return ret;
    }

    public void lanzarToast(Context context, String text, Boolean duracionLarga) {
        int duracion = duracionLarga ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duracion).show();
    }

    public interface ProgresoListener {
        void alActualizar(int porcentaje);
    }

    public void ejecutarTareaLarga(ProgresoListener listener) {
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(listener != null) {
                    listener.alActualizar(i * 10);
                }
            }
        }).start();
    }

    public void mostrarToastyExito(Activity activity, Context context, String mensaje, final ActionCallback callback) {
        activity.runOnUiThread(() -> {
            try {
                Toasty.warning(context, mensaje, Toasty.LENGTH_LONG, true).show();
                callback.onSuccess();
            } catch (Exception e){
                callback.onError("Error al mostar el toasty: " + e.getMessage());
            }
        });
    }

    public interface ActionCallback {
        void onSuccess();
        void onError(String error);
    }

    public interface DialogoCallback {
        void onResponse(boolean aceptado);
    }
}
