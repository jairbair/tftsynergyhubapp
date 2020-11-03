package pancax.Tftsynergyhubapp;


import android.content.Context;

import android.content.pm.ActivityInfo;
import android.graphics.Color;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.nio.charset.StandardCharsets.UTF_8;


public class HubMain_Activity extends AppCompatActivity {

    //instantiate champions and data for champions
    //holder for Origins and Classes

    static ArrayList<ChampionOrigins> ORIGINS_ARRAY_LIST;
    static ArrayList<ChampionClasses> CLASSES_ARRAY_LIST;
    //Setup Origins groupers
    /*
    * These are origin groupers
    * */
    final ChampionOrigins DEMON = new ChampionOrigins("Demon");
    final ChampionOrigins DRAGON = new ChampionOrigins("Dragon");
    final ChampionOrigins EXILE = new ChampionOrigins("Exile");
    final ChampionOrigins GLACIAL = new ChampionOrigins("Glacial");
    final ChampionOrigins ROBOT = new ChampionOrigins("Robot");
    final ChampionOrigins IMPERIAL = new ChampionOrigins("Imperial");
    final ChampionOrigins NOBLE = new ChampionOrigins("Noble");
    final ChampionOrigins NINJA = new ChampionOrigins("Ninja");
    final ChampionOrigins PIRATE = new ChampionOrigins("Pirate");
    final ChampionOrigins PHANTOM = new ChampionOrigins("Phantom");
    final ChampionOrigins WILD = new ChampionOrigins("Wild");
    final ChampionOrigins VOID = new ChampionOrigins("Void");
    final ChampionOrigins YORDLE = new ChampionOrigins("Yordle");
    final ChampionOrigins HEXTECH = new ChampionOrigins("Hextech");
    //Setup Classes groupers
    final ChampionClasses ASSASSIN = new ChampionClasses("Assassin");
    final ChampionClasses BLADEMASTER = new ChampionClasses("Blademaster");
    final ChampionClasses BRAWLER = new ChampionClasses("Brawler");
    final ChampionClasses ELEMENTALIST = new ChampionClasses("Elementalist");
    final ChampionClasses GUARDIAN = new ChampionClasses("Guardian");
    final ChampionClasses GUNSLINGER = new ChampionClasses("Gunslinger");
    final ChampionClasses KNIGHT = new ChampionClasses("Knight");
    final ChampionClasses RANGER = new ChampionClasses("Ranger");
    final ChampionClasses SHAPESHIFTER = new ChampionClasses("Shapeshifter");
    final ChampionClasses SORCERER = new ChampionClasses("Sorcerer");

    // Do actually important stuff
    static ChampionHolder holder = new ChampionHolder();
    TextView numberOfChampsInHolderText;
    LinearLayout championSelectedLayout;
    LinearLayout originSelectorLayout;
    LinearLayout classSelectorLayout;
    ScrollView originSelectorLayoutScroll;
    ScrollView classSelectorLayoutScroll;
    LinearLayout synergySelectedLayout;
    Button originButton;
    Button classButton;
    boolean originOrClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub_main_);
        CLASSES_ARRAY_LIST= new ArrayList<>();
        ORIGINS_ARRAY_LIST= new ArrayList<>();

        setupLists();
        createChampions();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        numberOfChampsInHolderText = findViewById(R.id.numberOfChampsText);
        originSelectorLayout = findViewById(R.id.originSelectorLayout);
        championSelectedLayout = findViewById(R.id.championSelectedLayout);
        classSelectorLayout = findViewById(R.id.classSelectorLayout);
        originSelectorLayoutScroll = findViewById(R.id.originSelectorLayoutScroll);
        classSelectorLayoutScroll = findViewById(R.id.classSelectorLayoutScroll);
        synergySelectedLayout = findViewById(R.id.synergyHolderLayout);
        originButton = findViewById(R.id.originButton);
        classButton = findViewById(R.id.classButton);
        //true for origin false for class
        originOrClass = false;
        sortChampions();
        makeOriginSelectorLayout();
        makeClassSelectorLayout();
        updateNumberOfChampsInHolderText(holder.getCurrentChampionList());
        updateHolder();
        updateAllChampionImages(classSelectorLayout);
        updateAllChampionImages(originSelectorLayout);

    }
    private void sortChampions(){
        Collections.sort(ORIGINS_ARRAY_LIST,new Comparator<ChampionOrigins>(){

            @Override
            public int compare(ChampionOrigins championOrigins, ChampionOrigins t1) {
                if(championOrigins.getOriginName().compareTo(t1.getOriginName())<0){
                    return -1;
                }
                if(championOrigins.getOriginName().compareTo(t1.getOriginName())>0){
                    return 1;
                }
                return 0;
            }
        });
        Collections.sort(CLASSES_ARRAY_LIST,new Comparator<ChampionClasses>(){

            @Override
            public int compare(ChampionClasses t1, ChampionClasses t2) {
                if(t1.getName().compareTo(t2.getName())<0){
                    return -1;
                }
                if(t1.getName().compareTo(t2.getName())>0){
                    return 1;
                }
                return 0;
            }
        });
        for(ChampionOrigins x:ORIGINS_ARRAY_LIST){
            Collections.sort(x.getList(),new Comparator<Champion>() {

                @Override
                public int compare(Champion champion, Champion t1) {
                    if(champion.getRarity()<t1.getRarity()){
                        return 1;
                    }
                    if(champion.getRarity()>t1.getRarity()){
                        return -1;
                    }
                    if(champion.getName().compareTo(t1.getName())<0){
                        return -1;
                    }
                    if(champion.getName().compareTo(t1.getName())>0){
                        return 1;
                    }
                    return 0;
                }
            });
        }
        for(ChampionClasses x:CLASSES_ARRAY_LIST){
            Collections.sort(x.getList(),new Comparator<Champion>() {
                @Override
                public int compare(Champion champion, Champion t1) {
                    if(champion.getRarity()<t1.getRarity()){
                        return 1;
                    }
                    if(champion.getRarity()>t1.getRarity()){
                        return -1;
                    }
                    if(champion.getName().compareTo(t1.getName())<0){
                        return -1;
                    }
                    if(champion.getName().compareTo(t1.getName())>0){
                        return 1;
                    }
                    return 0;
                }
            });
        }
    }
    private void createChampions() {
        try {
            JSONObject jsonObject = new JSONObject(loadJSONFromAsset(this));
            JSONArray jsonArray = jsonObject.getJSONArray("champions");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonChamp = jsonArray.getJSONObject(i);
                String name = jsonChamp.getString("name");
                int rarity = jsonChamp.getInt("rarity");
                Champion champion;
                if(jsonChamp.getString("class").contains("-")) {
                    String s = jsonChamp.getString("class");
                    String arg1 = s.substring(0, s.indexOf('-'));
                    String arg2 = s.substring(s.indexOf('-')+1);
                    String[] className = {arg1, arg2};
                    String[] originName;
                    if(jsonChamp.getString("origin").contains("-")) {
                        String s2 = jsonChamp.getString("origin");
                        String arg1s = s2.substring(0, s2.indexOf('-'));
                        String arg2s = s2.substring(s2.indexOf('-')+1);
                        originName = new String[]{arg1s, arg2s};
                    } else {
                        originName = new String[]{jsonChamp.getString("origin")};
                    }
                    champion = new Champion(name, className, originName, rarity);
                }
                else {
                    String[] className = {jsonChamp.getString("class")};
                    String[] originName;
                    if(jsonChamp.getString("origin").contains("-")) {
                        String s2 = jsonChamp.getString("origin");
                        String arg1s = s2.substring(0, s2.indexOf('-'));
                        String arg2s = s2.substring(s2.indexOf('-')+1);
                        originName = new String[]{arg1s, arg2s};
                    } else {
                        originName = new String[]{jsonChamp.getString("origin")};
                    }
                    champion = new Champion(name, className, originName, rarity);
                }
                putChampionInItsPlace(champion);
            }
        } catch (Exception e) {
        }

    }

    private void putChampionInItsPlace(Champion champion) {
        for(ChampionOrigins championOrigins: ORIGINS_ARRAY_LIST) {
            for(int i=0;i<champion.getOriginName().length;i++){
                if(championOrigins.getOriginName().equals(champion.getOriginName()[i])) {
                    championOrigins.addChampion(champion);
                }
            }
        }
        for(ChampionClasses championClasses: CLASSES_ARRAY_LIST) {
            for(int i=0;i<champion.getClassName().length;i++){
                if(championClasses.getName().equals(champion.getClassName()[i])) {
                    championClasses.addChampion(champion);
                }
            }
        }
    }

    private String loadJSONFromAsset(Context context) {
        String json;
        try {
            InputStream is = context.getAssets().open("champions.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }



    private void setupLists() {
        /*
        * TODO:: replace with automatic adder from txt file containing all info
        * */

        ORIGINS_ARRAY_LIST.add(DEMON);
        ORIGINS_ARRAY_LIST.add(DRAGON);
        ORIGINS_ARRAY_LIST.add(EXILE);
        ORIGINS_ARRAY_LIST.add(GLACIAL);
        ORIGINS_ARRAY_LIST.add(ROBOT);
        ORIGINS_ARRAY_LIST.add(IMPERIAL);
        ORIGINS_ARRAY_LIST.add(NOBLE);
        ORIGINS_ARRAY_LIST.add(NINJA);
        ORIGINS_ARRAY_LIST.add(PIRATE);
        ORIGINS_ARRAY_LIST.add(PHANTOM);
        ORIGINS_ARRAY_LIST.add(WILD);
        ORIGINS_ARRAY_LIST.add(VOID);
        ORIGINS_ARRAY_LIST.add(YORDLE);
        ORIGINS_ARRAY_LIST.add(HEXTECH);
        /*
        *
        * */
        CLASSES_ARRAY_LIST.add(ASSASSIN);
        CLASSES_ARRAY_LIST.add(BLADEMASTER);
        CLASSES_ARRAY_LIST.add(BRAWLER);
        CLASSES_ARRAY_LIST.add(ELEMENTALIST);
        CLASSES_ARRAY_LIST.add(GUARDIAN);
        CLASSES_ARRAY_LIST.add(GUNSLINGER);
        CLASSES_ARRAY_LIST.add(KNIGHT);
        CLASSES_ARRAY_LIST.add(RANGER);
        CLASSES_ARRAY_LIST.add(SHAPESHIFTER);
        CLASSES_ARRAY_LIST.add(SORCERER);

    }

    public void updateHolder() {
        ArrayList<Champion> currentList = holder.getCurrentChampionList();
        int demonCount = 0;
        int dragonCount = 0;
        int exileCount = 0;
        int glacialCount = 0;
        int robotCount = 0;
        int imperialCount = 0;
        int nobleCount = 0;
        int ninjaCount = 0;
        int pirateCount = 0;
        int phantomCount = 0;
        int wildCount = 0;
        int voidCount = 0;
        int yordleCount = 0;
        int assassinCount = 0;
        int blademasterCount = 0;
        int brawlerCount = 0;
        int elementalistCount = 0;
        int guardianCount = 0;
        int gunslingerCount = 0;
        int knightCount = 0;
        int rangerCount = 0;
        int shapeshifterCount = 0;
        int sorcererCount = 0;
        int hextechCount=0;
        for (Champion i : currentList) {
            for (String name : i.getOriginName()) {
                switch (name) {
                    case "Demon": {
                        demonCount++;
                        break;
                    }
                    case "Dragon": {
                        dragonCount++;
                        break;
                    }
                    case "Exile": {
                        exileCount++;
                        break;
                    }
                    case "Glacial": {
                        glacialCount++;
                        break;
                    }
                    case "Robot": {
                        robotCount++;
                        break;
                    }
                    case "Imperial": {
                        imperialCount++;
                        break;
                    }
                    case "Noble": {
                        nobleCount++;
                        break;
                    }
                    case "Ninja": {
                        ninjaCount++;
                        break;
                    }
                    case "Pirate": {
                        pirateCount++;
                        break;
                    }
                    case "Phantom": {
                        phantomCount++;
                        break;
                    }
                    case "Wild": {
                        wildCount++;
                        break;
                    }
                    case "Void": {
                        voidCount++;
                        break;
                    }
                    case "Yordle": {
                        yordleCount++;
                        break;
                    }
                    case "Hextech":{
                        hextechCount++;
                        break;
                    }
                }
            }
            for (String className : i.getClassName()) {
                switch (className) {
                    /* start adding cases for classes here*/
                    case "Assassin": {
                        assassinCount++;
                        break;
                    }
                    case "Blademaster": {
                        blademasterCount++;
                        break;
                    }
                    case "Brawler": {
                        brawlerCount++;
                        break;
                    }
                    case "Elementalist": {
                        elementalistCount++;
                        break;
                    }
                    case "Guardian": {
                        guardianCount++;
                        break;
                    }
                    case "Gunslinger": {
                        gunslingerCount++;
                        break;
                    }
                    case "Knight": {
                        knightCount++;
                        break;
                    }
                    case "Ranger": {
                        rangerCount++;
                        break;
                    }
                    case "Shapeshifter": {
                        shapeshifterCount++;
                        break;
                    }
                    case "Sorcerer": {
                        sorcererCount++;
                        break;
                    }
                }
            }

        }
        checkSynergies(demonCount, dragonCount, exileCount, glacialCount, robotCount, imperialCount, nobleCount,
                ninjaCount, pirateCount, phantomCount, wildCount, voidCount, yordleCount, assassinCount, blademasterCount, brawlerCount, elementalistCount, guardianCount, gunslingerCount, knightCount, rangerCount, shapeshifterCount, sorcererCount,hextechCount);
        //update Champions in holder text
        updateNumberOfChampsInHolderText(currentList);
        updateChampionImages(currentList);


    }

    public void updateChampionImages(ArrayList<Champion> champions) {
        championSelectedLayout.removeAllViewsInLayout();
        Context layoutContext = championSelectedLayout.getContext();
        int repeats = champions.size();
        int counter = -1;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int diviser = (int) Math.ceil(dpWidth) / 60 /*width of images + margins and stuff*/;
        while (repeats > 0) {
            counter++;
            LinearLayout holderView = new LinearLayout(championSelectedLayout.getContext());
            holderView.setGravity(Gravity.CENTER);
            for (int i = 0; i < diviser && i + counter * diviser < champions.size(); i++) {
                ImageButton button = new ImageButton(layoutContext);
                button.setTag(champions.get(i + counter * diviser).getName());
                button.setId(View.generateViewId());
                button.setBackgroundColor(Color.TRANSPARENT);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = (String) (view.getTag());
                        holder.removeChampionFromList(name);
                        updateHolder();
                        updateAllChampionImages(originSelectorLayout);
                        updateAllChampionImages(classSelectorLayout);
                    }
                });

                Champion champion= champions.get(i + counter * diviser);
                button.setForeground(champion.getRarity() ==1 ? getDrawable(R.drawable.border_gold):champion.getRarity() ==2 ? getDrawable(R.drawable.border_purple):champion.getRarity() ==3 ? getDrawable(R.drawable.border_blue):champion.getRarity() ==4 ? getDrawable(R.drawable.border_green):getDrawable(R.drawable.border_gray));
                LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.champion_selected_width), (int) getResources().getDimension(R.dimen.champion_selected_height));
                buttonParams.setMargins(8, 8, 8, 8);
                holderView.addView(button, buttonParams);
                String nameThing = "avatar_" + champions.get(i + counter * diviser).getName().toLowerCase().replaceAll("[^a-z]", "") + "";
                int id = getResources().getIdentifier(nameThing, "drawable", layoutContext.getPackageName());
                button.setBackground(getResources().getDrawable(id, layoutContext.getTheme()));
            }
            championSelectedLayout.addView(holderView);
            repeats /= diviser;
        }
    }

    public void checkSynergies(int demonCount, int dragonCount,
                               int exileCount,
                               int glacialCount,
                               int robotCount,
                               int imperialCount,
                               int nobleCount,
                               int ninjaCount,
                               int pirateCount,
                               int phantomCount,
                               int wildCount,
                               int voidCount,
                               int yordleCount, /*add all the synergies into this passer*/
                               int assassinCount,
                               int blademasterCount,
                               int brawlerCount,
                               int elementalistCount,
                               int guardianCount,
                               int gunslingerCount,
                               int knightCount,
                               int rangerCount,
                               int shapeshifterCount,
                               int sorcererCount,
                               int hextechCount) {
        synergySelectedLayout.removeAllViewsInLayout();
        //check ORIGINS
        if (demonCount >= 6) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.demon_6_text, demonCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        } else if (demonCount >= 4) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.demon_4_text, demonCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        } else if (demonCount >= 2) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.demon_2_text, demonCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if (dragonCount >= 2) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.dragon_2_text, dragonCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if (exileCount >= 1) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.exile_1_text, exileCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if (glacialCount >= 6) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.glacial_6_text, glacialCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        } else if (glacialCount >= 4) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.glacial_4_text, glacialCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        } else if (glacialCount >= 2) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.glacial_2_text, glacialCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if (robotCount >= 1) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.robot_1_text, robotCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if (imperialCount >= 4) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.imperial_4_text, imperialCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        } else if (imperialCount >= 2) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.imperial_2_text, imperialCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if (nobleCount >= 6) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.noble_6_text, nobleCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        } else if (nobleCount >= 3) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.noble_3_text, nobleCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if (ninjaCount == 1) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.ninja_1_text, ninjaCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        } else if (ninjaCount == 4) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.ninja_4_text, ninjaCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if (pirateCount >= 3) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.pirate_3_text, pirateCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if (phantomCount >= 2) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.phantom_2_text, phantomCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if (wildCount >= 4) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.wild_4_text, wildCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        } else if (wildCount >= 2) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.wild_2_text, wildCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if (voidCount >= 3) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.void_3_text, voidCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if (yordleCount >= 6) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.yordle_6_text, yordleCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        } else if (yordleCount >= 3) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.yordle_3_text, yordleCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if (hextechCount >=4){
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.hextech_4_text, hextechCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        } else if (hextechCount >=2){
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.hextech_2_text, hextechCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        //check CLASSES
        if (assassinCount >= 6) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.assassin_6_text, assassinCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        } else if (assassinCount >= 3) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.assassin_3_text, assassinCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if (blademasterCount >= 9) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.blademaster_9_text, blademasterCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        } else if (blademasterCount >= 6) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.blademaster_6_text, blademasterCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        } else if (blademasterCount >= 3) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.blademaster_3_text, blademasterCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if (brawlerCount >= 6) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.brawler_6_text, brawlerCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        } else if (brawlerCount >= 4) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.brawler_4_text, brawlerCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        } else if (brawlerCount >= 2) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.brawler_2_text, brawlerCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if (elementalistCount >= 3) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.elementalist_3_text, elementalistCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if (guardianCount >= 2) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.guardian_2_text, guardianCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if (gunslingerCount >= 6) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.gunslinger_6_text, gunslingerCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        } else if (gunslingerCount >= 4) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.gunslinger_4_text, gunslingerCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        } else if (gunslingerCount >= 2) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.gunslinger_2_text, gunslingerCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if (knightCount >= 6) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.knight_6_text, knightCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        } else if (knightCount >= 4) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.knight_4_text, knightCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        } else if (knightCount >= 2) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.knight_2_text, knightCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if (rangerCount >= 4) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.ranger_4_text, rangerCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        } else if (rangerCount >= 2) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.ranger_2_text, rangerCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if (shapeshifterCount >= 6) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.shapeshifter_6_text, shapeshifterCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        } else if (shapeshifterCount >= 3) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.shapeshifter_3_text, shapeshifterCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if (sorcererCount >= 6) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.sorcerer_6_text, sorcererCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        } else if (sorcererCount >= 3) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.sorcerer_3_text, sorcererCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }

    }

    public void updateNumberOfChampsInHolderText(ArrayList<Champion> currentList) {
        String textTjom = getString(R.string.ChampionHolderNumber, currentList.size());
        numberOfChampsInHolderText.setText(textTjom);
    }

    public void makeOriginSelectorLayout() {

        for (int i = 0; i < ORIGINS_ARRAY_LIST.size(); i++) {

            ChampionOrigins origin = ORIGINS_ARRAY_LIST.get(i);
            ArrayList<Champion> champions = origin.getList();

            LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            textViewParams.setMargins(8, 0, 8, 16);

            LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.champion_selector_width), (int) getResources().getDimension(R.dimen.champion_selector_height));
            buttonParams.setMargins(8, 0, 8, 8);

            int repeats = champions.size();
            int counter = -1;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
            int diviser = (int) Math.ceil(dpWidth) / 70 /*width of images + margins and stuff*/;
            while (repeats > 0) {
                LinearLayout originView = new LinearLayout(originSelectorLayout.getContext());
                counter++;
                if (counter == 0) {
                    TextView originName = new TextView(originView.getContext());
                    originName.setText(origin.getOriginName());
                    originSelectorLayout.addView(originName, textViewParams);
                    makeViewParams(originView);
                }
                for (int j = 0; j < diviser && j + counter * diviser < champions.size(); j++) {
                    ImageButton button = new ImageButton(originView.getContext());
                    button.setTag(champions.get(j + counter * diviser).getName());
                    button.setId(View.generateViewId());
                    button.setBackgroundColor(Color.TRANSPARENT);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String name = (String) (view.getTag());
                            if (!holder.isChampionInList(name)) {
                                holder.addChampionToList(name);
                                updateHolder();
                                updateAllChampionImages(originSelectorLayout);
                            } else {
                                holder.removeChampionFromList(name);
                                updateHolder();
                                updateAllChampionImages(originSelectorLayout);
                            }
                        }
                    });
                    Champion champion= champions.get(j + counter * diviser);
                    button.setForeground(champion.getRarity() ==1 ? getDrawable(R.drawable.border_gold):champion.getRarity() ==2 ? getDrawable(R.drawable.border_purple):champion.getRarity() ==3 ? getDrawable(R.drawable.border_blue):champion.getRarity() ==4 ? getDrawable(R.drawable.border_green):getDrawable(R.drawable.border_gray));
                    originView.addView(button, buttonParams);

                    String nameThing = "avatar_" + champions.get(j + counter * diviser).getName().toLowerCase().replaceAll("[^a-z]", "") + "";
                    int id = getResources().getIdentifier(nameThing, "drawable", originView.getContext().getPackageName());
                    button.setBackground(getResources().getDrawable(id, originView.getContext().getTheme()));
                }
                originSelectorLayout.addView(originView);
                repeats /= diviser;
            }
        }
    }

    public void makeClassSelectorLayout() {

        for (int i = 0; i < CLASSES_ARRAY_LIST.size(); i++) {
            ChampionClasses classes = CLASSES_ARRAY_LIST.get(i);
            ArrayList<Champion> champions = classes.getList();
            LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            textViewParams.setMargins(8, 0, 8, 16);

            LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.champion_selector_width), (int) getResources().getDimension(R.dimen.champion_selector_height));
            buttonParams.setMargins(8, 0, 8, 8);
            int repeats = champions.size();
            int counter = -1;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
            int diviser = (int) Math.ceil(dpWidth) / 70 /*width of images + margins and stuff*/;
            while (repeats > 0) {
                counter++;
                LinearLayout classView = new LinearLayout(classSelectorLayout.getContext());
                if (counter == 0) {
                    TextView className = new TextView(classView.getContext());
                    className.setText(classes.getName());
                    classSelectorLayout.addView(className, textViewParams);

                    //makeViewParams(classView);
                    classView.setOrientation(LinearLayout.HORIZONTAL);
                    classView.setGravity(Gravity.FILL);
                }
                for (int j = 0; j < diviser && j + counter * diviser < champions.size(); j++) {
                    ImageButton button = new ImageButton(classView.getContext());
                    button.setTag(champions.get(j + counter * diviser).getName());
                    button.setId(View.generateViewId());
                    button.setBackgroundColor(Color.TRANSPARENT);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String name = (String) (view.getTag());
                            if (!holder.isChampionInList(name)) {
                                if (holder.addChampionToList(name)) {
                                    updateHolder();
                                    updateAllChampionImages(classSelectorLayout);
                                }
                            } else {
                                holder.removeChampionFromList(name);
                                updateHolder();
                                updateAllChampionImages(classSelectorLayout);
                            }
                        }
                    });

                    Champion champion= champions.get(j + counter * diviser);
                    button.setForeground(champion.getRarity() ==1 ? getDrawable(R.drawable.border_gold):champion.getRarity() ==2 ? getDrawable(R.drawable.border_purple):champion.getRarity() ==3 ? getDrawable(R.drawable.border_blue):champion.getRarity() ==4 ? getDrawable(R.drawable.border_green):getDrawable(R.drawable.border_gray));
                    classView.addView(button, buttonParams);
                    String nameThing = "avatar_" + champions.get(j + counter * diviser).getName().toLowerCase().replaceAll("[^a-z]", "") + "";
                    int id = getResources().getIdentifier(nameThing, "drawable", classView.getContext().getPackageName());
                    button.setBackground(getResources().getDrawable(id, classView.getContext().getTheme()));
                }
                classSelectorLayout.addView(classView);
                repeats = repeats / diviser;
            }

        }

    }

    public void makeViewParams(LinearLayout view) {
        view.setGravity(Gravity.FILL);
        view.setOrientation(LinearLayout.HORIZONTAL);
    }

    public void onClassButtonClicked(View v) {
        originSelectorLayoutScroll.setVisibility(View.INVISIBLE);
        classSelectorLayoutScroll.setVisibility(View.VISIBLE);
        classButton.setBackground(getResources().getDrawable(R.drawable.button_selected_shape, this.getTheme()));
        originButton.setBackground(getResources().getDrawable(R.drawable.button_default_shape, this.getTheme()));
        originButton.setTextColor(ContextCompat.getColor(this, R.color.gold));
        classButton.setTextColor(ContextCompat.getColor(this, R.color.ic_launcher_background));

        updateAllChampionImages(classSelectorLayout);
    }
    public void updateAllChampionImages(LinearLayout layout){
        for (int i = 0; i < layout.getChildCount(); i++) {
            View childview = layout.getChildAt(i);
            if (childview instanceof LinearLayout) {
                LinearLayout chillview=(LinearLayout) childview;
                for (int j = 0; j < chillview.getChildCount(); j++) {
                    View childviewchild = chillview.getChildAt(j);
                    if(childviewchild instanceof ImageButton) {
                        if (holder.isChampionInList(childviewchild.getTag().toString())) {
                            Champion champion = new Champion("",new String[]{""},new String[]{""},-1);
                            for(ChampionOrigins x: ORIGINS_ARRAY_LIST){
                                for(int z=0;z<x.getList().size();z++){
                                    if(childviewchild.getTag().toString().equals(x.getList().get(z).getName())){
                                        champion = x.getList().get(z);
                                    }

                                }
                            }
                            childviewchild.setForeground(champion.getRarity() ==1 ? getDrawable(R.drawable.x_border_gold):champion.getRarity() ==2 ? getDrawable(R.drawable.x_border_purple):champion.getRarity() ==3 ? getDrawable(R.drawable.x_border_blue):champion.getRarity() ==4 ? getDrawable(R.drawable.x_border_green):getDrawable(R.drawable.x_border_gray));
                        } else {

                            Champion champion = new Champion("",new String[]{""},new String[]{""},-1);
                            for(ChampionOrigins x: ORIGINS_ARRAY_LIST){
                                for(int z=0;z<x.getList().size();z++){
                                    if(childviewchild.getTag().toString().equals(x.getList().get(z).getName())){
                                        champion = x.getList().get(z);
                                    }
                                }
                            }
                            childviewchild.setForeground(champion.getRarity() ==1 ? getDrawable(R.drawable.border_gold):champion.getRarity() ==2 ? getDrawable(R.drawable.border_purple):champion.getRarity() ==3 ? getDrawable(R.drawable.border_blue):champion.getRarity() ==4 ? getDrawable(R.drawable.border_green):getDrawable(R.drawable.border_gray));
                        }
                    }
                }
            }
        }
    }
    public void onOriginButtonClicked(View v) {

        classSelectorLayoutScroll.setVisibility(View.INVISIBLE);
        originSelectorLayoutScroll.setVisibility(View.VISIBLE);


        classButton.setBackground(getResources().getDrawable(R.drawable.button_default_shape, this.getTheme()));
        originButton.setBackground(getResources().getDrawable(R.drawable.button_selected_shape, this.getTheme()));
        originButton.setTextColor(ContextCompat.getColor(this, R.color.ic_launcher_background));
        classButton.setTextColor(ContextCompat.getColor(this, R.color.gold));

        updateAllChampionImages(originSelectorLayout);
    }
}

