package L7;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by Ivan on 18.12.2016.
 */
public class Main {

    private static void one(){
        Path path = Paths.get(System.getProperty("user.dir"),".");
        System.out.println("Current path:\n" + path.toString());
        System.out.println("\nEvery inner directory:");
        ArrayList<String> paths = new ArrayList<>();
        while(path.getNameCount() > 1){
            path = path.getParent();
            paths.add(path.getName(path.getNameCount()-1).toString());
        }
        paths.add(path.getRoot().toString());
        for(int i = paths.size()-1; i > -1; i--){
            System.out.println(paths.get(i));
        }

        path = Paths.get(System.getProperty("user.home"),".");
        System.out.println("Current path:\n" + path.toString());
        System.out.println("\nEvery inner directory:");
        paths = new ArrayList<>();
        while(path.getNameCount() > 1){
            path = path.getParent();
            paths.add(path.getName(path.getNameCount()-1).toString());
        }
        paths.add(path.getRoot().toString());
        for(int i = paths.size()-1; i > -1; i--){
            System.out.println(paths.get(i));
        }
    }

    public static void main(String[] args) {
        one();
    }
}
