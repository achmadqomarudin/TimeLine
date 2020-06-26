package com.achmadqomarudin.timeline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.lin.timeline.TimeLineDecoration;

import java.util.ArrayList;
import java.util.List;

import static com.lin.timeline.TimeLineDecoration.BEGIN;
import static com.lin.timeline.TimeLineDecoration.END_FULL;
import static com.lin.timeline.TimeLineDecoration.NORMAL;

public class MainActivity extends AppCompatActivity {
    private Adapter adapter;
    private RecyclerView recyclerView;
    private List<Model> modelList = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TimeLineDecoration decoration = new TimeLineDecoration(this)
                .setLineColor(R.color.colorPrimary)
                .setLineWidth(1)
                .setLeftDistance(16)
                .setTopDistance(12)
                .setBeginMarker(R.drawable.begin_marker)
                .setMarkerRadius(8)
                .setMarkerColor(R.color.colorAccent)
                .setCallback(new TimeLineDecoration.TimeLineAdapter() {
                    //or new TimeLineDecoration.TimeLineCallback
                    @Override
                    public int getTimeLineType(int position) {
                        if (position == 0) return BEGIN;
                        else if (position == adapter.getItemCount() - 1) return END_FULL;
                        else return NORMAL;
                    }
                });


        Model model = new Model(true,"DELIVERED TO [ACHMAD, TULUNGAGUNG]", "05-05-2020 13:19");
        modelList.add(model);

        model = new Model(false,"WITH DELIVERY COURRIER [TULUNGAGUNG]", "05-05-2020 04:27");
        modelList.add(model);

        model = new Model(false,"RECEIVED AT WAREHOUSE [TULUNGAGUNG, KAB.TULUNGAGUNG]", "05-05-2020 03:05");
        modelList.add(model);

        model = new Model(false,"DEPARTED FROM TRANSIT [SURABAYA]", "04-05-2020 09:04");
        modelList.add(model);

        model = new Model(false,"PROCESSED AT SORTING CENTER [SURABAYA]", "03-05-2020 02:24");
        modelList.add(model);

        model = new Model(false,"RECEIVED AT SORTING CENTER [SURABAYA]", "02-05-2020 20:02");
        modelList.add(model);

        model = new Model(false,"SHIPMENT PICKED UP BY COURIER [SURABAYA]", "02-05-2020 19:08");
        modelList.add(model);

        model = new Model(false,"SHIPMENT RECEIVED BY COUNTER OFFICER AT [SURABAYA]", "05-05-2020 18:32");
        modelList.add(model);


        adapter = new Adapter(modelList);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(decoration);
    }
}
