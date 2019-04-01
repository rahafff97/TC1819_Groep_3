package nl.group3.techlab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import nl.group3.techlab.database.FillDatabase;
import nl.group3.techlab.database.ItemDatabaseHelper;
import nl.group3.techlab.models.Item;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ItemDatabaseHelper myDB = new ItemDatabaseHelper(this);
        FillDatabase.FillDatabaseWithTestData(myDB);

        Intent i = new Intent(getBaseContext(), HomeActivity.class);
        startActivity(i);
        finish();
    }
}
