package br.com.softctrl.sqlcipher;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;


/**
 * Created by timoshenko on 7/15/15.
 * E-Mail carlostimoshenkorodrigueslopes@gmail.com
 */
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        net.sqlcipher.database.SQLiteDatabase.loadLibs(this);
        DatabaseManager manager = new DatabaseManager(this);
        try {
            Dao<Usuario, Long> usuarioDAO = manager.getDao(Usuario.class);
            for (int i=0; i< 1000; i++){
                Usuario usuario = new Usuario();
                usuario.setId((long) i);
                usuario.setNome(String.format("Carlos Timoshenko %d", i));
                usuarioDAO.create(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
