package br.com.fatec.proximatrilhav1.utils;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guilherme Faria on 18/09/2017.
 *
 * Classe gerada para validar as permissões já autorizadas pelo usuario no aplicativo
 */

public class PermissionUtils {

    public static boolean validate(final Activity activity, final int requestCode, String... permissions) {
        List<String> list = new ArrayList<String>();
        for (String permission : permissions) {

            if (ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED) {
                list.add(permission);
            }
        }
        if (list.isEmpty()) {
            return true;
        }
        // Lista de permissões que falta acesso.
        String[] newPermissions = new String[list.size()];
        list.toArray(newPermissions);

        // Solicita permissão
        ActivityCompat.requestPermissions(activity, newPermissions, 1);

        return false;
    }

}
