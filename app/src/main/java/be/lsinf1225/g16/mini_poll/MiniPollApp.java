package be.lsinf1225.g16.mini_poll;

import android.app.Application;
import android.view.Gravity;
import android.widget.Toast;

public class MiniPollApp extends Application {

    /**
     * Référence au contexte de l'application
     */
    private static MiniPollApp context;

    /**
     * Fournit le contexte de l'application.
     *
     * @return Contexte de l'application.
     */
    public static MiniPollApp getContext() {
        return context;
    }


    /**
     * Affiche une notification pendant une courte durée à l'utilisateur.
     *
     * @param resId Id de la ressource (R.string.* ) contenant le message à afficher.
     *
     * @see MiniPollApp#notify
     */
    public static void notifyShort(int resId) {
        notify(resId, Toast.LENGTH_SHORT);
    }

    /**
     * Affiche une notification pendant une longue durée à l'utilisateur.
     *
     * @param resId Id de la ressource (R.string.* ) contenant le message à afficher.
     *
     * @see MiniPollApp#notify
     */
    public static void notifyLong(int resId) {
        notify(resId, Toast.LENGTH_LONG);
    }

    /**
     * Affiche une notification à l'utilisateur. Cette notification est centrée sur l'écran afin
     * qu'elle soit bien visible même lorsque le clavier est actif.
     *
     * @param resId    Id de la ressource (R.string.* ) contenant le message à afficher.
     * @param duration Durée d'affichage (Toast.LENGTH_SHORT ou Toast.LENGTH_LONG)
     */
    private static void notify(int resId, int duration) {
        Toast msg = Toast.makeText(getContext(), getContext().getString(resId), duration);
        msg.setGravity(Gravity.CENTER, 0, 0);
        msg.show();
    }

    public void onCreate() {
        super.onCreate();
        context = (MiniPollApp) getApplicationContext();
    }
}


