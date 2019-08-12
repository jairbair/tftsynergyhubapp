package pancax.Tftsynergyhubapp;

import java.util.ArrayList;

public class ChampionHolder {
    private ArrayList<Champion> currentChampionList;

    public ChampionHolder(){
        currentChampionList = new ArrayList<>(0);
    }
    public ArrayList<Champion> getCurrentChampionList(){
        return currentChampionList;
    }

    public void removeChampionFromList(Champion champion){

        for(int i=0;i<currentChampionList.size();i++){
            if(champion.getName().equals(currentChampionList.get(i).getName())){
                currentChampionList.remove(i);
                break;
            }
        }

    }
    public boolean addChampionToList(Champion champion){
        if(currentChampionList.size()<10) {
            currentChampionList.add(champion);
            return true;
        }
        return false;
    }
    public boolean isChampionInList(String name){
        for(int i=0;i<currentChampionList.size();i++){
            if(name.equals(currentChampionList.get(i).getName())){
                return true;
            }
        }
        return false;
    }
    public boolean addChampionToList(String championName){
        if(currentChampionList.size()<10) {
            for(ChampionOrigins x:HubMain_Activity.ORIGINS_ARRAY_LIST){
                for(Champion z: x.getList()){
                    if(z.getName().equals(championName)){
                        if(!isChampionInList(z)) {
                            currentChampionList.add(z);
                            return true;
                        }
                        else
                            return false;
                    }
                }
            }
        }
        return false;
    }
    public boolean removeChampionFromList(String name){
        for(int i=0;i<currentChampionList.size();i++){
            if(currentChampionList.get(i).getName().equals(name)){
                currentChampionList.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean isChampionInList(Champion champion){
        for(int i=0;i<currentChampionList.size();i++){
            if(champion.getName().equals(currentChampionList.get(i).getName())){
                return true;
            }
        }
        return false;
    }
}
