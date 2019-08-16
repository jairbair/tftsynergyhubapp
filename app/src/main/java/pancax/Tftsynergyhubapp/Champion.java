package pancax.Tftsynergyhubapp;

public class Champion {
    private String[] className;
    private String[] originName;
    private int rarity; // 1 - 5
    private String name;



    public Champion(String name, String[] classNames, String[] originNames, int rarity) {
        this.name=name;
        this.className=classNames;
        this.originName=originNames;
        this.rarity = rarity;
    }
    public String getName(){
        return this.name;
    }
    public String[] getClassName()
    {
        return this.className;
    }
    public String[] getOriginName(){
        return this.originName;
    }
    public int getRarity() { return this.rarity; }
    public String toString(){
        return name;
    }
}
