package VampireMadeByAlastor31415926.helpers;

public class STRING {
    public static String getModPrefix() {
        return "VampireMadeByAlastor31415926";
    }
    public static String makeID(String ID) {
        return getModPrefix()+":" + ID;
    }

    public static String getIMG_PATH() {
        return getModPrefix()+"/img/cards/";
    }
    public static String makeIMG_PATH(String ID) {
        return getModPrefix()+"/img/cards/"+ID+".png";
    }
    public static String makeIMG_PATH(String ID,String TYPE) {
        return getModPrefix()+"/img/"+TYPE+"/"+ID+".png";
    }
}
