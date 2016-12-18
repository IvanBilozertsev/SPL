package L5;

import java.io.Closeable;
import java.io.File;

/**
 * Created by Ivan on 18.12.2016.
 */
public class SomeClosable implements Closeable {

    public SomeClosable(){
        System.out.println("I`m up!");
    }

    public void close(){
        System.out.println("I`m out!");
    }

}
