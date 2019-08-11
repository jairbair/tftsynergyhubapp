package pancax.Tftsynergyhubapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class ChampionOriginsAdapter extends ArrayAdapter<ChampionOrigins> {

    ArrayList<ChampionOrigins> list;
    Context mContext;
    public ChampionOriginsAdapter(@NonNull Context context, @NonNull ArrayList<ChampionOrigins> objects) {
        super(context, R.layout.champion_set_layout, objects);
        list= objects;
        mContext = context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ChampionOrigins bobby = getItem(position);
        ArrayList<Champion> champions = bobby.getList();
        //open up a new view
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.champion_set_layout,parent,false);
            TextView name = convertView.findViewById(R.id.name);
            name.setText(bobby.getOriginName());

            LinearLayout layoutButtons = convertView.findViewById(R.id.buttonLayout);
            layoutButtons.setGravity(Gravity.FILL);
            for(int i=0;i<champions.size();i++){
                ImageButton button = new ImageButton(mContext);
                button.setTag(champions.get(i).getName());
                button.setId(View.generateViewId());
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name= (String)(view.getTag());
                        HubMain_Activity.holder.addChampionToList(name);
                    }
                });
                layoutButtons.addView(button);
                String nameThing="avatar_"+champions.get(i).getName().toLowerCase().replaceAll("[^a-z]","")+".png";

                Log.d("CODEIDTHING"," " + nameThing);
            }
            convertView.setHasTransientState(true);
        }



        return convertView;
    }
}
