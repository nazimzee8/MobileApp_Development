package authenticate;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import edu.tacoma.uw.nazimz.datalab.R;
import main.MainMenuActivity;

public class SignInActivity extends AppCompatActivity
    implements LoginFragment.LoginFragmentListener{

    private SharedPreferences mSharedPreferences;
    private boolean mTest = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mSharedPreferences = getSharedPreferences(getString(R.string.LOGIN_PREFS), Context.MODE_PRIVATE);
        if (!mSharedPreferences.getBoolean(getString(R.string.LOGGEDIN), false) || mTest) {
            launchLoginFragment();
        }
        else {
            Intent intent = new Intent(this, MainMenuActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void launchLoginFragment() {
        LoginFragment loginFragment = new LoginFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.sign_in_fragment_id, loginFragment)
                .commit();
    }

    @Override
    public void login(String email, String pwd) {
        //Context context = getApplicationContext();
        //Toast toast = Toast.makeText(context, "Login!", Toast.LENGTH_SHORT);
        mSharedPreferences
                .edit()
                .putBoolean(getString(R.string.LOGGEDIN), true)
                .commit();
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
        finish();
    }
}
