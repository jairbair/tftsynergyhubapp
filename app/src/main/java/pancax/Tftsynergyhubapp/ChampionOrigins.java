package pancax.Tftsynergyhubapp;

import java.util.ArrayList;

public class ChampionOrigins {
    private ArrayList<Champion> championArrayList;
    private String originName;
    ChampionOrigins(String name){
        originName=name;
        championArrayList=new ArrayList<>(1);
    }
    void addChampion(Champion champion){
        championArrayList.add(champion);
    }
    ArrayList<Champion> getList(){
        return championArrayList;
    }
    public String toString(){
        return championArrayList.toString();

    }

    String getOriginName(){
        return originName;
    }
}
