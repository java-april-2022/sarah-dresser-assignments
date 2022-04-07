import java.util.HashMap;
import java.util.Set;

public class SongMap {

    public static void main(String[] args){
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Kom Igen", "Gå din vej");
        trackList.put("Joanna", "Tag mig med!");
        trackList.put("Pianomand", "Er det koldt og mørkt");
        trackList.put("Hurtige Hænder", "Nu er jeg på vej");
        trackList.put("Ca plane pour moi", "Ca plane pour moi");

        System.out.println(trackList.get("Pianomand"));
        trackList.get("Pianomand");

        Set<String> keys = trackList.keySet();
        System.out.println("Let's sing along!\n");
        for(String key:keys){
            System.out.printf("%s : %s\n", key, trackList.get(key));
        }
    }
}
