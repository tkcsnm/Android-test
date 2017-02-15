package hu.tkcsnm.butterfly;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Animal> zoo;
    TextView textBox;
    FloatingActionButton myButton;
    ImageView animalImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        zoo = new ArrayList<Animal>();
        textBox = (TextView)findViewById(R.id.animal_message);
        myButton = (FloatingActionButton) findViewById(R.id.fab);
        animalImage = (ImageView) findViewById(R.id.animal_image);

        this.zoo.add(new Caterpillar("Tódor", Animal.COLOR_GREEN));
        this.zoo.add(new Caterpillar("Bianka", Animal.COLOR_BLUE));

        myButton.setOnClickListener(myClickListener);
        animalImage.setOnClickListener(imageClickListener);

    }

    public void displayAnimal(Animal animal) {
        textBox.setText(animal.getName());

        textBox.setTextColor(Color.parseColor(animal.getColor()));
        animalImage.setImageResource(animal.imageRes);
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
        // as you specify clickListener parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    View.OnClickListener myClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Animal agedAnimal = zoo.get(1).aging();
            if (agedAnimal != zoo.get(1)){
                zoo.add(agedAnimal);
                zoo.remove(1);

            }
            displayAnimal(zoo.get(1));
        }
    };

    View.OnClickListener imageClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent myIntent = new Intent(v.getContext(), AnimalDetailActivity.class);
            startActivity(myIntent);
        }
    };
}
//TODO állat adatainak új activityt csinálni