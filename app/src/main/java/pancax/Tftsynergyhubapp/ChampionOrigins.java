package pancax.Tftsynergyhubapp;

import java.util.ArrayList;

public class ChampionOrigins {
    private ArrayList<Champion> championArrayList;
    private String originName;
    public ChampionOrigins(String name){
        originName=name;
        championArrayList=new ArrayList<>(1);
    }
    public void addChampion(Champion champion){
        championArrayList.add(champion);
    }
    public ArrayList<Champion> getList(){
        return championArrayList;
    }
    public String toString(){
        return championArrayList.toString();

    }
}
