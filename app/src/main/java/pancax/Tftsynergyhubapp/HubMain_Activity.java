package pancax.Tftsynergyhubapp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.style.TtsSpan;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;


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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub_main_);
        setupChampions();
        setupLists();

        numberOfChampsInHolderText = findViewById(R.id.numberOfChampsText);

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
    public void onChampionButtonClicked(View v){
        int buttonID = v.getId();
        switch(buttonID){
            case R.id.aatrox:{
                if(holder.isChampionInList(AATROX)){
                    holder.removeChampionFromList(AATROX);
                    findViewById(R.id.AatroxHolderImage).setVisibility(GONE);
                    updateHolder();
                }
                else{
                    if(holder.addChampionToList(AATROX)) {
                        findViewById(R.id.AatroxHolderImage).setVisibility(VISIBLE);
                        updateHolder();
                    }
                }
                break;
            }
            case R.id.varus:{
                if(holder.isChampionInList(VARUS)){
                    holder.removeChampionFromList(VARUS);
                    findViewById(R.id.VarusHolderImage).setVisibility(GONE);
                    updateHolder();
                }
                else{
                    if(holder.addChampionToList(VARUS)) {
                        findViewById(R.id.VarusHolderImage).setVisibility(VISIBLE);
                        updateHolder();
                    }
                }
                break;
            }
            case R.id.elise:{
                if(holder.isChampionInList(ELISE)){
                    holder.removeChampionFromList(ELISE);
                    findViewById(R.id.EliseHolderImage).setVisibility(GONE);
                    updateHolder();
                }
                else{
                    if(holder.addChampionToList(ELISE)) {
                        findViewById(R.id.EliseHolderImage).setVisibility(VISIBLE);
                        updateHolder();
                    }
                }
                break;
            }
        }
    }
    public void onChampionHolderButtonClicked(View v){
        int buttonID = v.getId();

        switch(buttonID){
            case R.id.AatroxHolderImage:{
                    holder.removeChampionFromList(AATROX);
                    v.setVisibility(GONE);
                    updateHolder();
                break;
            }
            case R.id.VarusHolderImage:{
                    holder.removeChampionFromList(VARUS);
                    v.setVisibility(GONE);
                    updateHolder();
                break;
            }
            case R.id.EliseHolderImage:{
                holder.removeChampionFromList(ELISE);
                v.setVisibility(GONE);
                updateHolder();
                break;
            }
        }

    }
    public void updateHolder(){
        ArrayList<Champion> currentList = holder.getCurrentChampionList();
        int demonCount=0;
        for(Champion i: currentList){
            for(String name:i.getOriginName()){
                switch(name){
                    case "Demon":{demonCount++;break;}
                }
            }
            for(String className:i.getClassName()){
                switch(className){
                    /* start adding cases for classes here*/
                }
            }

        }
        checkSynergies(demonCount);
        //update Champions in holder text
        updateNumberOfChampsInHolderText(currentList);


    }
    public void checkSynergies(int demonCount /*add all the synergies into this passer*/){

        if(demonCount==6){

        }else if(demonCount==4){

        }else if(demonCount==2){
            Log.d("demonCountistwo","twoboy");
        }
    }
    public void updateNumberOfChampsInHolderText(ArrayList<Champion> currentList){
        numberOfChampsInHolderText.setText(currentList.size()+"/10");
    }
}
