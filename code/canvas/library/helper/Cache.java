package canvas.library.helper;

import java.util.HashMap;


public class Cache<T>
{
    //# Fields
    private final HashMap<String, T> data = new HashMap<>();


    //# Methods
    public boolean exists(String key) {
        return this.data.containsKey(key);
    }

    public T get(String key) {
        if (this.exists(key)) {
            return this.data.get(key);
        }

        return null;
    }

    public void set(String key, T value) {
        String className = value.getClass().getName();
        Terminal.log(
                STR."Cache<\{
                    className.substring(className.lastIndexOf('.') + 1)
                }>",
                key
        );

        this.data.put(key, value);
    }
}
