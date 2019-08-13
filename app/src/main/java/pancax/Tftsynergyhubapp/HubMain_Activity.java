package pancax.Tftsynergyhubapp;


import android.content.Context;

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
import android.widget.WrapperListAdapter;

import java.util.ArrayList;


public class HubMain_Activity extends AppCompatActivity {

    //instantiate champions and data for champions
    //holder for Origins and Classes

    static ArrayList<ChampionOrigins> ORIGINS_ARRAY_LIST=new ArrayList<>();
    static ArrayList<ChampionClasses> CLASSES_ARRAY_LIST=new ArrayList<>();
    //Setup Origins groupers
    static final ChampionOrigins DEMON = new ChampionOrigins("Demon");
    static final ChampionOrigins DRAGON = new ChampionOrigins("Dragon");
    static final ChampionOrigins EXILE = new ChampionOrigins("Exile");
    static final ChampionOrigins GLACIAL = new ChampionOrigins("Glacial");
    static final ChampionOrigins ROBOT = new ChampionOrigins("Robot");
    static final ChampionOrigins IMPERIAL = new ChampionOrigins("Imperial");
    static final ChampionOrigins NOBLE = new ChampionOrigins("Noble");
    static final ChampionOrigins NINJA = new ChampionOrigins("Ninja");
    static final ChampionOrigins PIRATE = new ChampionOrigins("Pirate");
    static final ChampionOrigins PHANTOM = new ChampionOrigins("Phantom");
    static final ChampionOrigins WILD = new ChampionOrigins("Wild");
    static final ChampionOrigins VOID = new ChampionOrigins("Void");
    static final ChampionOrigins YORDLE = new ChampionOrigins("Yordle");
    //Setup Classes groupers
    static final ChampionClasses ASSASSIN = new ChampionClasses("Assassin");
    static final ChampionClasses BLADEMASTER = new ChampionClasses("Blademaster");
    static final ChampionClasses BRAWLER = new ChampionClasses("Brawler");
    static final ChampionClasses ELEMENTALIST = new ChampionClasses("Elementalist");
    static final ChampionClasses GUARDIAN = new ChampionClasses("Guardian");
    static final ChampionClasses GUNSLINGER = new ChampionClasses("Gunslinger");
    static final ChampionClasses KNIGHT = new ChampionClasses("Knight");
    static final ChampionClasses RANGER = new ChampionClasses("Ranger");
    static final ChampionClasses SHAPESHIFTER = new ChampionClasses("Shapeshifter");
    static final ChampionClasses SORCERER = new ChampionClasses("Sorcerer");

    //Demon
    static final Champion AATROX = new Champion("Aatrox",new String[]{"Blademaster"},new String[]{"Demon"});
    static final Champion VARUS = new Champion("Varus",new String[]{"Ranger"},new String[]{"Demon"});
    static final Champion MORGANA = new Champion("Morgana",new String[]{"Sorcerer"},new String[]{"Demon"});
    static final Champion SWAIN = new Champion("Swain",new String[]{"Shapeshifter"},new String[]{"Demon","Imperial"});
    static final Champion ELISE = new Champion("Elise",new String[]{"Shapeshifter"},new String[]{"Demon"});
    static final Champion EVELYNN = new Champion("Evelynn",new String[]{"Assassin"},new String[]{"Demon"});
    static final Champion BRAND = new Champion("Brand",new String[]{"Elementalist"},new String[]{"Demon"});
    //Dragon
    static final Champion SHYVANA = new Champion("Shyvana",new String[]{"Shapeshifter"},new String[]{"Dragon"});
    static final Champion AURELION_SOL = new Champion("Aurelion Sol",new String[]{"Sorcerer"},new String[]{"Dragon"});
    //Exile
    static final Champion YASUO = new Champion("Yasuo",new String[]{"Blademaster"},new String[]{"Exile"});
    //Glacial
    static final Champion BRAUM = new Champion("Braum",new String[]{"Guardian"},new String[]{"Glacial"});
    static final Champion ASHE = new Champion("Ashe",new String[]{"Ranger"},new String[]{"Glacial"});
    static final Champion SEJUANI = new Champion("Sejuani",new String[]{"Knight"},new String[]{"Glacial"});
    static final Champion LISSANDRA = new Champion("Lissandra",new String[]{"Elementalist"},new String[]{"Glacial"});
    static final Champion VOLIBEAR = new Champion("Volibear",new String[]{"Brawler"},new String[]{"Glacial"});
    static final Champion ANIVIA = new Champion("Anivia",new String[]{"Elementalist"},new String[]{"Glacial"});
    //Robot
    static final Champion BLITZCRANK = new Champion("Blitzcrank",new String[]{"Brawler"},new String[]{"Robot"});
    //Imperial
    static final Champion DARIUS = new Champion("Darius",new String[]{"Knight"},new String[]{"Imperial"});
    static final Champion DRAVEN = new Champion("Draven",new String[]{"Blademaster"},new String[]{"Imperial"});
    static final Champion KATARINA = new Champion("Katarina",new String[]{"Assassin"},new String[]{"Imperial"});
    //Swain is also an imperial
    //Noble
    static final Champion FIORA = new Champion("Fiora",new String[]{"Blademaster"},new String[]{"Noble"});
    static final Champion VAYNE = new Champion("Vayne",new String[]{"Ranger"},new String[]{"Noble"});
    static final Champion LEONA = new Champion("Leona",new String[]{"Guardian"},new String[]{"Noble"});
    static final Champion GAREN = new Champion("Garen",new String[]{"Knight"},new String[]{"Noble"});
    static final Champion LUCIAN = new Champion("Lucian",new String[]{"Gunslinger"},new String[]{"Noble"});
    static final Champion KAYLE = new Champion("Kayle",new String[]{"Knight"},new String[]{"Noble"});
    //Ninja

    static final Champion SHEN = new Champion("Shen",new String[]{"Blademaster"},new String[]{"Ninja"});
    static final Champion KENNEN = new Champion("Kennen",new String[]{"Elementalist"},new String[]{"Ninja","Yordle"});
    static final Champion ZED = new Champion("Zed",new String[]{"Assassin"},new String[]{"Ninja"});
    static final Champion AKALI = new Champion("Akali",new String[]{"Assassin"},new String[]{"Ninja"});
    //Pirate
    static final Champion GRAVES = new Champion("Graves",new String[]{"Gunslinger"},new String[]{"Pirate"});
    static final Champion GANGPLANK = new Champion("Gangplank",new String[]{"Blademaster","Gunslinger"},new String[]{"Pirate"});
    static final Champion PYKE = new Champion("Pyke",new String[]{"Assassin"},new String[]{"Pirate"});
    static final Champion MISS_FORTUNE = new Champion("Miss Fortune",new String[]{"Gunslinger"},new String[]{"Pirate"});
    static final Champion TWISTED_FATE = new Champion("Twisted Fate",new String[]{"Sorcerer"},new String[]{"Pirate"});
    //Phantom
    static final Champion MORDEKAISER = new Champion("Mordekaiser",new String[]{"Knight"},new String[]{"Phantom"});
    static final Champion KARTHUS = new Champion("Karthus",new String[]{"Sorcerer"},new String[]{"Phantom"});
    static final Champion KINDRED = new Champion("Kindred",new String[]{"Ranger"},new String[]{"Phantom"});
    //Wild
    static final Champion AHRI = new Champion("Ahri",new String[]{"Sorcerer"},new String[]{"Wild"});
    static final Champion WARWICK = new Champion("Warwick",new String[]{"Brawler"},new String[]{"Wild"});
    static final Champion GNAR = new Champion("Gnar",new String[]{"Shapeshifter"},new String[]{"Wild","Yordle"});
    static final Champion NIDALEE = new Champion("Nidalee",new String[]{"Shapeshifter"},new String[]{"Wild"});
    static final Champion RENGAR = new Champion("Rengar",new String[]{"Assassin"},new String[]{"Wild"});
    //Void
    static final Champion KHAZIX = new Champion("Kha'Zix",new String[]{"Assassin"},new String[]{"Void"});
    static final Champion REKSAI = new Champion("Rek'Sai",new String[]{"Brawler"},new String[]{"Void"});
    static final Champion KASSADIN = new Champion("Kassadin",new String[]{"Sorcerer"},new String[]{"Void"});
    static final Champion CHOGATH = new Champion("Cho'Gath",new String[]{"Brawler"},new String[]{"Void"});
    //Yordle
    static final Champion TRISTANA = new Champion("Tristana",new String[]{"Gunslinger"},new String[]{"Yordle"});
    static final Champion POPPY = new Champion("Poppy",new String[]{"Knight"},new String[]{"Yordle"});
    //kennen is also a yordle
    static final Champion LULU = new Champion("Lulu",new String[]{"Sorcerer"},new String[]{"Yordle"});
    static final Champion VEIGAR = new Champion("Veigar",new String[]{"Sorcerer"},new String[]{"Yordle"});
    //gnar is also a yordle

    // Do actually important stuff
    ChampionHolder holder = new ChampionHolder();
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
        setupChampions();
        setupLists();
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
        originOrClass=false;
        makeOriginSelectorLayout();
        makeClassSelectorLayout();

    }

    private void setupChampions(){
        //setup Origins
        {
            DEMON.addChampion(VARUS);
            DEMON.addChampion(MORGANA);
            DEMON.addChampion(AATROX);
            DEMON.addChampion(SWAIN);
            DEMON.addChampion(ELISE);
            DEMON.addChampion(EVELYNN);
            DEMON.addChampion(BRAND);

            DRAGON.addChampion(SHYVANA);
            DRAGON.addChampion(AURELION_SOL);

            EXILE.addChampion(YASUO);

            GLACIAL.addChampion(BRAUM);
            GLACIAL.addChampion(ASHE);
            GLACIAL.addChampion(SEJUANI);
            GLACIAL.addChampion(LISSANDRA);
            GLACIAL.addChampion(VOLIBEAR);
            GLACIAL.addChampion(ANIVIA);

            ROBOT.addChampion(BLITZCRANK);

            IMPERIAL.addChampion(DARIUS);
            IMPERIAL.addChampion(DRAVEN);
            IMPERIAL.addChampion(KATARINA);
            IMPERIAL.addChampion(SWAIN);

            NOBLE.addChampion(FIORA);
            NOBLE.addChampion(VAYNE);
            NOBLE.addChampion(LEONA);
            NOBLE.addChampion(GAREN);
            NOBLE.addChampion(LUCIAN);
            NOBLE.addChampion(KAYLE);

            NINJA.addChampion(SHEN);
            NINJA.addChampion(KENNEN);
            NINJA.addChampion(ZED);
            NINJA.addChampion(AKALI);

            PIRATE.addChampion(GRAVES);
            PIRATE.addChampion(GANGPLANK);
            PIRATE.addChampion(PYKE);
            PIRATE.addChampion(MISS_FORTUNE);
            PIRATE.addChampion(TWISTED_FATE);

            PHANTOM.addChampion(MORDEKAISER);
            PHANTOM.addChampion(KARTHUS);
            PHANTOM.addChampion(KINDRED);

            WILD.addChampion(WARWICK);
            WILD.addChampion(AHRI);
            WILD.addChampion(GNAR);
            WILD.addChampion(NIDALEE);
            WILD.addChampion(RENGAR);

            VOID.addChampion(KHAZIX);
            VOID.addChampion(REKSAI);
            VOID.addChampion(KASSADIN);
            VOID.addChampion(CHOGATH);

            YORDLE.addChampion(TRISTANA);
            YORDLE.addChampion(POPPY);
            YORDLE.addChampion(KENNEN);
            YORDLE.addChampion(LULU);
            YORDLE.addChampion(VEIGAR);
            YORDLE.addChampion(GNAR);

        }
        //setup class groupers
        {
            ASSASSIN.addChampion(KHAZIX);
            ASSASSIN.addChampion(ZED);
            ASSASSIN.addChampion(EVELYNN);
            ASSASSIN.addChampion(AKALI);
            ASSASSIN.addChampion(PYKE);
            ASSASSIN.addChampion(KATARINA);
            ASSASSIN.addChampion(RENGAR);

            BLADEMASTER.addChampion(FIORA);
            BLADEMASTER.addChampion(AATROX);
            BLADEMASTER.addChampion(DRAVEN);
            BLADEMASTER.addChampion(SHEN);
            BLADEMASTER.addChampion(GANGPLANK);
            BLADEMASTER.addChampion(YASUO);

            BRAWLER.addChampion(WARWICK);
            BRAWLER.addChampion(BLITZCRANK);
            BRAWLER.addChampion(CHOGATH);
            BRAWLER.addChampion(REKSAI);
            BRAWLER.addChampion(VOLIBEAR);

            ELEMENTALIST.addChampion(LISSANDRA);
            ELEMENTALIST.addChampion(BRAND);
            ELEMENTALIST.addChampion(KENNEN);
            ELEMENTALIST.addChampion(ANIVIA);

            GUARDIAN.addChampion(BRAUM);
            GUARDIAN.addChampion(LEONA);

            GUNSLINGER.addChampion(GRAVES);
            GUNSLINGER.addChampion(LUCIAN);
            GUNSLINGER.addChampion(MISS_FORTUNE);
            GUNSLINGER.addChampion(TRISTANA);
            GUNSLINGER.addChampion(GANGPLANK);

            KNIGHT.addChampion(DARIUS);
            KNIGHT.addChampion(MORDEKAISER);
            KNIGHT.addChampion(SEJUANI);
            KNIGHT.addChampion(GAREN);
            KNIGHT.addChampion(POPPY);
            KNIGHT.addChampion(KAYLE);

            RANGER.addChampion(VAYNE);
            RANGER.addChampion(ASHE);
            RANGER.addChampion(VARUS);
            RANGER.addChampion(KINDRED);

            SHAPESHIFTER.addChampion(NIDALEE);
            SHAPESHIFTER.addChampion(SHYVANA);
            SHAPESHIFTER.addChampion(SWAIN);
            SHAPESHIFTER.addChampion(ELISE);
            SHAPESHIFTER.addChampion(GNAR);

            SORCERER.addChampion(KASSADIN);
            SORCERER.addChampion(LULU);
            SORCERER.addChampion(MORGANA);
            SORCERER.addChampion(KARTHUS);
            SORCERER.addChampion(AHRI);
            SORCERER.addChampion(VEIGAR);
            SORCERER.addChampion(AURELION_SOL);
            SORCERER.addChampion(TWISTED_FATE);

        }
    }
    private void setupLists(){
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
    public void updateHolder(){
        ArrayList<Champion> currentList = holder.getCurrentChampionList();
        int demonCount=0;
        int dragonCount=0;
        int exileCount=0;
        int glacialCount=0;
        int robotCount=0;
        int imperialCount=0;
        int nobleCount=0;
        int ninjaCount=0;
        int pirateCount=0;
        int phantomCount=0;
        int wildCount=0;
        int voidCount=0;
        int yordleCount=0;
        for(Champion i: currentList){
            for(String name:i.getOriginName()){
                switch(name){
                    case "Demon":{demonCount++;break;}
                    case "Dragon":{dragonCount++;break;}
                    case "Exile":{exileCount++;break;}
                    case "Glacial":{glacialCount++;break;}
                    case "Robot":{robotCount++;break;}
                    case "Imperial":{imperialCount++;break;}
                    case "Noble":{nobleCount++;break;}
                    case "Ninja":{ninjaCount++;break;}
                    case "Pirate":{pirateCount++;break;}
                    case "Phantom":{phantomCount++;break;}
                    case "Wild":{wildCount++;break;}
                    case "Void":{voidCount++;break;}
                    case "Yordle":{yordleCount++;break;}
                }
            }
            for(String className:i.getClassName()){
                switch(className){
                    /* start adding cases for classes here*/
                }
            }

        }
        checkSynergies(demonCount,dragonCount,exileCount,glacialCount,robotCount, imperialCount, nobleCount,
                        ninjaCount,pirateCount,phantomCount,wildCount,voidCount,yordleCount);
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
            for (int i = 0; i < diviser && i+counter*diviser<champions.size(); i++) {
                ImageButton button = new ImageButton(layoutContext);
                button.setTag(champions.get(i+counter*diviser).getName());
                button.setId(View.generateViewId());
                button.setBackgroundColor(Color.TRANSPARENT);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = (String) (view.getTag());
                        holder.removeChampionFromList(name);
                        updateHolder();
                    }
                });

                LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.champion_selected_width), (int) getResources().getDimension(R.dimen.champion_selected_height));
                buttonParams.setMargins(8, 8, 8, 8);
                holderView.addView(button, buttonParams);
                String nameThing = "avatar_" + champions.get(i+counter*diviser).getName().toLowerCase().replaceAll("[^a-z]", "") + "";
                int id = getResources().getIdentifier(nameThing, "drawable", layoutContext.getPackageName());
                button.setBackground(getResources().getDrawable(id, layoutContext.getTheme()));
            }
            championSelectedLayout.addView(holderView);
            repeats/=diviser;
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
            int yordleCount /*add all the synergies into this passer*/){
        synergySelectedLayout.removeAllViewsInLayout();

        if(demonCount>=6){
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.demon_6_text,demonCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }else if(demonCount>=4){
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.demon_4_text,demonCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }else if(demonCount>=2){
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.demon_2_text,demonCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if(dragonCount>=2){
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.dragon_2_text,dragonCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if(exileCount>=1){
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.exile_1_text,exileCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if(glacialCount>=6){
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.glacial_6_text,glacialCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        } else if(glacialCount>=4){
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.glacial_4_text,glacialCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        } else if(glacialCount>=2){
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.glacial_2_text,glacialCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if(robotCount>=1){
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.robot_1_text,robotCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if(imperialCount>=4){
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.imperial_4_text,imperialCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }else if(imperialCount>=2){
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.imperial_2_text,imperialCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if(nobleCount>=6){
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.noble_6_text,nobleCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        } else if(nobleCount>=3){
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.noble_3_text,nobleCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if(ninjaCount==1){
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.ninja_1_text,ninjaCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }else if(ninjaCount==4){
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.ninja_4_text,ninjaCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if(pirateCount>=3) {
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.pirate_3_text, pirateCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if(phantomCount>=2){
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.phantom_2_text,phantomCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if(wildCount>=4){
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.wild_4_text,wildCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        } else if(wildCount>=2){
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.wild_2_text,wildCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if(voidCount>=3){
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.void_3_text,voidCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
        if(yordleCount>=6){
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.yordle_6_text,yordleCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }else if(yordleCount>=3){
            TextView text = new TextView(synergySelectedLayout.getContext());
            String textTjom = getString(R.string.yordle_3_text,yordleCount);
            text.setText(textTjom);
            synergySelectedLayout.addView(text);
        }
    }
    public void updateNumberOfChampsInHolderText(ArrayList<Champion> currentList){
        numberOfChampsInHolderText.setText(currentList.size()+"/10");
    }
    public void makeOriginSelectorLayout(){

            for(int i=0;i<ORIGINS_ARRAY_LIST.size();i++) {

                ChampionOrigins origin = ORIGINS_ARRAY_LIST.get(i);
                ArrayList<Champion> champions = origin.getList();
                LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                textViewParams.setMargins(8, 0, 8, 8);
                LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.champion_selector_width), (int) getResources().getDimension(R.dimen.champion_selector_height));
                buttonParams.setMargins(8, 8, 8, 8);
                int repeats = champions.size();
                int counter = -1;
                DisplayMetrics displayMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
                int diviser = (int) Math.ceil(dpWidth)/ 70 /*width of images + margins and stuff*/;
                while (repeats > 0) {
                    LinearLayout originView = new LinearLayout(originSelectorLayout.getContext());
                    counter++;
                    if(counter==0){
                        TextView originName = new TextView(originView.getContext());
                        originName.setText(origin.getOriginName());
                        originSelectorLayout.addView(originName,textViewParams);
                        makeViewParams(originView);
                    }
                    for (int j = 0; j < diviser&&j+counter*diviser<champions.size(); j++) {
                        ImageButton button = new ImageButton(originView.getContext());
                        button.setTag(champions.get(j+counter*diviser).getName());
                        button.setId(View.generateViewId());
                        button.setBackgroundColor(Color.TRANSPARENT);
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String name = (String) (view.getTag());
                                if (!holder.isChampionInList(name)) {
                                    holder.addChampionToList(name);
                                    Log.d("Holdercurrent", holder.getCurrentChampionList().toString());
                                    updateHolder();
                                } else {
                                    holder.removeChampionFromList(name);
                                    updateHolder();
                                }
                            }
                        });
                        originView.addView(button, buttonParams);

                        String nameThing = "avatar_" + champions.get(j+counter*diviser).getName().toLowerCase().replaceAll("[^a-z]", "") + "";
                        int id = getResources().getIdentifier(nameThing, "drawable", originView.getContext().getPackageName());
                        button.setBackground(getResources().getDrawable(id, originView.getContext().getTheme()));
                    }
                    originSelectorLayout.addView(originView);
                    repeats/=diviser;
                }
            }
    }
    public void makeClassSelectorLayout(){

        for(int i=0;i<CLASSES_ARRAY_LIST.size();i++) {
            ChampionClasses classes = CLASSES_ARRAY_LIST.get(i);
            ArrayList<Champion> champions = classes.getList();
            LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            textViewParams.setMargins(8, 0, 8, 8);

            LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.champion_selector_width), (int) getResources().getDimension(R.dimen.champion_selector_height));
            buttonParams.setMargins(8, 8, 8, 8);
            int repeats = champions.size();
            int counter = -1;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
            int diviser = (int) Math.ceil(dpWidth)/ 70 /*width of images + margins and stuff*/;
            while (repeats > 0) {
                counter++;
                LinearLayout classView = new LinearLayout(classSelectorLayout.getContext());
                if(counter==0)
                {
                    TextView className = new TextView(classView.getContext());
                    className.setText(classes.getName());
                    classSelectorLayout.addView(className,textViewParams);

                    //makeViewParams(classView);
                    classView.setOrientation(LinearLayout.HORIZONTAL);
                    classView.setGravity(Gravity.FILL);
                }
                for (int j = 0; j < diviser && j+counter*diviser<champions.size(); j++) {
                    ImageButton button = new ImageButton(classView.getContext());
                    button.setTag(champions.get(j+counter*diviser).getName());
                    button.setId(View.generateViewId());
                    button.setBackgroundColor(Color.TRANSPARENT);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String name = (String) (view.getTag());
                            if (!holder.isChampionInList(name)) {
                                holder.addChampionToList(name);
                                Log.d("Holdercurrent", holder.getCurrentChampionList().toString());
                                updateHolder();
                            } else {
                                holder.removeChampionFromList(name);
                                updateHolder();
                            }
                        }
                    });
                    classView.addView(button, buttonParams);

                    String nameThing = "avatar_" + champions.get(j+counter*diviser).getName().toLowerCase().replaceAll("[^a-z]", "") + "";
                    int id = getResources().getIdentifier(nameThing, "drawable", classView.getContext().getPackageName());
                    button.setBackground(getResources().getDrawable(id, classView.getContext().getTheme()));
                }
                classSelectorLayout.addView(classView);
                repeats = repeats/diviser;
            }

        }

    }

    public void makeViewParams(LinearLayout view){
        view.setGravity(Gravity.FILL);
        view.setOrientation(LinearLayout.HORIZONTAL);
    }
    public void onClassButtonClicked(View v){
        originSelectorLayoutScroll.setVisibility(View.INVISIBLE);
        classSelectorLayoutScroll.setVisibility(View.VISIBLE);
        classButton.setBackground(getResources().getDrawable(R.drawable.button_selected_shape,this.getTheme()));
        originButton.setBackground(getResources().getDrawable(R.drawable.button_default_shape,this.getTheme()));
        originButton.setTextColor(ContextCompat.getColor(this, R.color.gold));
        classButton.setTextColor(ContextCompat.getColor(this, R.color.ic_launcher_background));
    }
    public void onOriginButtonClicked(View v){

        classSelectorLayoutScroll.setVisibility(View.INVISIBLE);
        originSelectorLayoutScroll.setVisibility(View.VISIBLE);

        classButton.setBackground(getResources().getDrawable(R.drawable.button_default_shape,this.getTheme()));
        originButton.setBackground(getResources().getDrawable(R.drawable.button_selected_shape,this.getTheme()));
        originButton.setTextColor(ContextCompat.getColor(this, R.color.ic_launcher_background));
        classButton.setTextColor(ContextCompat.getColor(this, R.color.gold));
    }
}
