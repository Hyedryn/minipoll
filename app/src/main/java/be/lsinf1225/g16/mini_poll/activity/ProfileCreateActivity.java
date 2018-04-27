package be.lsinf1225.g16.mini_poll.activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import be.lsinf1225.g16.mini_poll.MiniPollApp;
import be.lsinf1225.g16.mini_poll.R;
import be.lsinf1225.g16.mini_poll.model.Utilisateur;

import static be.lsinf1225.g16.mini_poll.MiniPollApp.connectedUser;
import static be.lsinf1225.g16.mini_poll.MiniPollApp.utilisateurs;
import static be.lsinf1225.g16.mini_poll.activity.ConnexionActivity.login;
import static be.lsinf1225.g16.mini_poll.activity.RegisterActivity.register;

public class ProfileCreateActivity extends AppCompatActivity {

    static int RESULT_LOAD_IMAGE = 1;
    static ImageView imageView;
    Bitmap image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_create);
    }


    public void setpp(View view) {
        Intent i = new Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            imageView = (ImageView) findViewById(R.id.cr_imgView);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
            imageView.buildDrawingCache();
            image = imageView.getDrawingCache().copy(imageView.getDrawingCache().getConfig(), true);
        }

    }

    public void mainmenu(View view) {
        String nom = ((EditText) findViewById(R.id.cr_nom)).getText().toString();

        String prenom = ((EditText)findViewById(R.id.cr_prenom)).getText().toString();

        String email = ((EditText)findViewById(R.id.cr_email)).getText().toString();

        if(nom.isEmpty()||prenom.isEmpty()||email.isEmpty()) {
            MiniPollApp.notifyShort(R.string.error_field_required);
            return;
        }

        if(nom.length()>25||prenom.length()>20||email.length()>50) {
            MiniPollApp.notifyShort(R.string.error_string_too_long);
            return;
        }

        if (!email.contains("@") || !email.contains(".")) {
            MiniPollApp.notifyShort(R.string.error_invalid_email);
            return;
        }

        if(!MiniPollApp.isValidCharacter(nom+prenom)||!MiniPollApp.isValidCharacterNoSpace(email)){
            MiniPollApp.notifyShort(R.string.error_invalid_char);
            return;
        }

        //Step ok ouverture de la fenetre de creation du profile
        connectedUser.setEmail(email);
        connectedUser.setNom(nom);
        connectedUser.setPrenom(prenom);

        //Enregistrement eventuel de la photo de profile
        if (imageView != null) {
            connectedUser.setPhoto(image);
        }


        //ajout de l'utilisateur à la liste des utilisateurs et à la base de données
        utilisateurs.add(connectedUser);
        MiniPollApp.saveUser(connectedUser);

        Intent intent = new Intent(ProfileCreateActivity.this, MenuMainActivity.class);
        startActivity(intent);
        //fermeture des activités précédentes pour ne pas pouvoir retourner en arrière
        register.finish();
        login.finish();
        finish();

    }
}
