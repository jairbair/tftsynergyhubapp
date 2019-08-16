package pancax.Tftsynergyhubapp;

import java.util.ArrayList;

public class ChampionClasses {
    private ArrayList<Champion> championArrayList;
    private String className;
    ChampionClasses(String name){
        className=name;
        championArrayList=new ArrayList<>(1);
    }
    void addChampion(Champion champion){
        championArrayList.add(champion);
    }
    ArrayList<Champion> getList(){
        return championArrayList;
    }
    public String getName(){
        return className;
    }
    public String toString(){
        return championArrayList.toString();

    }
}
