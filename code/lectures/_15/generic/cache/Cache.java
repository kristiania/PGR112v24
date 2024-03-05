package lectures._15.generic.cache;

import java.util.HashMap;

public class Cache<T>
{
    //# Fields
    private HashMap<String, T> data = new HashMap<>();

    //# Getter-methods

    /**
     * Henter en cachet-verdi, om den ikke finnes,
     * returneres en standard verdi som null
     *
     * @param key Nøkkelen inn i HashMappet
     * @return T Data av data-typen T som er en generisk type
     */
    public T get(String key, T defaultValue) {

        if (!this.data.containsKey(key)) {
            this.set(key, defaultValue);
        }

        return this.data.get(key);
    }


    //# Setter-methods
    public void set(String key, T value) {
        this.data.put(key, value);
    }


}
