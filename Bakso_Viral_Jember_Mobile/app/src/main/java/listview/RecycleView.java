package listview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bakso_viral_jember_mobile.R;

import java.util.ArrayList;


public class RecycleView extends AppCompatActivity {

    private RecyclerView viewData;
    private DataAdapter adapterData;
    private ArrayList<Data> dataArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        addData();
        adapterData = new DataAdapter(dataArrayList);

        viewData = findViewById(R.id.view_data);
        viewData.setLayoutManager(new LinearLayoutManager(this));
        viewData.setAdapter(adapterData);
    }

    private void addData(){
        dataArrayList = new ArrayList<>();
        dataArrayList.add(new Data( "Mixtape", "Bicycle", "RM"));
        dataArrayList.add(new Data( "Mixtape", "Blue side", "j-hope"));
        dataArrayList.add(new Data( "Mixtape", "Snow Flower", "V"));
        dataArrayList.add(new Data( "Mixtape", "Chrismas Love", "Jimin"));
        dataArrayList.add(new Data( "Mixtape", "Abyss", "Jin"));
        dataArrayList.add(new Data( "Mixtape", "Still With You", "Jungkook"));
        dataArrayList.add(new Data( "Mixtape", "Daechwita", "Suga"));



    }
}