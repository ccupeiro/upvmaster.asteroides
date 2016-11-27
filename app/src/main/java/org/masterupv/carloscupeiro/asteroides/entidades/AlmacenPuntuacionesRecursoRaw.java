package org.masterupv.carloscupeiro.asteroides.entidades;

import android.content.Context;
import android.util.Log;

import org.masterupv.carloscupeiro.asteroides.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos on 09/11/2016.
 */

public class AlmacenPuntuacionesRecursoRaw implements AlmacenPuntuaciones {
    private Context context;
    public AlmacenPuntuacionesRecursoRaw(Context context) {
        this.context = context;
    }
    public void guardarPuntuacion(int puntos, String nombre, long fecha){

    }
    public List<String> listaPuntuaciones(int cantidad) {
        List<String> result = new ArrayList<String>();
        try {
            InputStream f = context.getResources().openRawResource(R.raw.puntuaciones);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(f));
            int n = 0;
            String linea;
            do {
                linea = entrada.readLine();
                if (linea != null) {
                    result.add(linea);
                    n++;
                }
            } while (n < cantidad && linea != null);
            f.close();
        } catch (Exception e) {
            Log.e("Asteroides", e.getMessage(), e);
        }
        return result;
    }
}
