package pancax.Tftsynergyhubapp;

import java.util.ArrayList;

public class ChampionHolder {
    private ArrayList<Champion> currentChampionList;
    public ChampionHolder(){
        currentChampionList = new ArrayList<>(1);
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
    public void addChampionToList(Champion champion){
        //do this after you mess with the graphical stuff
    }
}
