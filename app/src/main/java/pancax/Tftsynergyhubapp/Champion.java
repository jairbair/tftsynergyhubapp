package pancax.Tftsynergyhubapp;

public class Champion {
    private String[] className;
    private String[] originName;
    private String name;



    public Champion(String name, String[] classNames, String[] originNames) {
        this.name=name;
        this.className=classNames;
        this.originName=originNames;
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
    public String toString(){
        return name;
    }
}
