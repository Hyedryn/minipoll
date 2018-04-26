package be.lsinf1225.g16.mini_poll.activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import be.lsinf1225.g16.mini_poll.MiniPollApp;
import be.lsinf1225.g16.mini_poll.R;
import be.lsinf1225.g16.mini_poll.model.Utilisateur;

import static be.lsinf1225.g16.mini_poll.MiniPollApp.connectedUser;
import static be.lsinf1225.g16.mini_poll.MiniPollApp.utilisateurs;
import static be.lsinf1225.g16.mini_poll.activity.ConnexionActivity.login;
import static be.lsinf1225.g16.mini_poll.activity.RegisterActivity.register;
import static be.lsinf1225.g16.mini_poll.model.Utilisateur.utilisateurIsAvailable;

public class ProfileEditActivity extends AppCompatActivity {

    private boolean editid = false;
    private boolean editmdp = false;

    static int RESULT_LOAD_IMAGE = 1;
    static ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);

        ((TextView)findViewById(R.id.mpr_id)).setText(MiniPollApp.connectedUser.getIdentifiant());
        ((TextView)findViewById(R.id.mpr_nom)).setText(MiniPollApp.connectedUser.getNom());
        ((TextView)findViewById(R.id.mpr_prenom)).setText(MiniPollApp.connectedUser.getPrenom());
        ((TextView)findViewById(R.id.mpr_email)).setText(MiniPollApp.connectedUser.getEmail());

        if(MiniPollApp.connectedUser.getPhoto()!=null)
            ((ImageView) findViewById(R.id.mpr_imgView)).setImageBitmap(MiniPollApp.connectedUser.getPhoto());

    }


    public void editpp(View view)
    {

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
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            imageView = (ImageView) findViewById(R.id.mpr_imgView);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));


        }

    }

    public void mainmenu(View view)
    {
        String nom = ((EditText) findViewById(R.id.mpr_nom)).getText().toString();

        String prenom = ((EditText)findViewById(R.id.mpr_prenom)).getText().toString();

        String email = ((EditText)findViewById(R.id.mpr_email)).getText().toString();

        if(!nom.isEmpty()&&!prenom.isEmpty()&&!email.isEmpty()){
            if(nom.length()<25&&prenom.length()<20&&email.length()<=50){
                if (email.contains("@") && email.contains(".")) {

                    //Step ok ouverture de la fenetre de creation du profile
                    connectedUser.setEmail(email);
                    connectedUser.setNom(nom);
                    connectedUser.setPrenom(prenom);

                    //Enregistrement eventuel de la photo de profile
                    if (imageView != null) {
                        imageView.buildDrawingCache();
                        connectedUser.setPhoto(imageView.getDrawingCache().copy(imageView.getDrawingCache().getConfig(), true));
                    }


                    //ajout de l'utilisateur à la liste des utilisateurs et à la base de données
                    MiniPollApp.saveUser(connectedUser);


                    Intent intent = new Intent(ProfileEditActivity.this, MenuMainActivity.class);
                    startActivity(intent);
                    //fermeture des activités précédentes pour ne pas pouvoir retourner en arrière
                    finish();

                } else {
                    MiniPollApp.notifyShort(R.string.error_invalid_email);
                }
            }else{
                MiniPollApp.notifyShort(R.string.error_string_too_long);
            }
        }else{
            MiniPollApp.notifyShort(R.string.error_field_required);
        }


    }


    public void editid(View view)
    {
        String id = ((EditText) findViewById(R.id.mpr_id)).getText().toString();

        String mdp = ((EditText) findViewById(R.id.mpr_id_mdp)).getText().toString();
        if(!id.isEmpty()&&!mdp.isEmpty()){
            if(utilisateurIsAvailable(id)){

                if(connectedUser.checkMdp(mdp)){

                    //PHASE CRITIQUE: UPDATE DE l'ID
                    MiniPollApp.updateID(id);
                    MiniPollApp.notifyLong(R.string.id_modify);

                }else{
                    MiniPollApp.notifyShort(R.string.error_invalid_password);
                    ((TextView)findViewById(R.id.mpr_id_mdp)).setText("");
                }
            }else{
                MiniPollApp.notifyShort(R.string.error_id_already_exist);
                ((TextView)findViewById(R.id.mpr_id_mdp)).setText("");
                ((TextView)findViewById(R.id.mpr_id)).setText("");
            }

        }else{
            MiniPollApp.notifyShort(R.string.error_field_required);
            ((TextView)findViewById(R.id.mpr_id_mdp)).setText("");
        }

    }




    public void editmdp(View view)
    {


    }

}
