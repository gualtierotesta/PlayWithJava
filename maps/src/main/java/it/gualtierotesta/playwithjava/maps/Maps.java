package it.gualtierotesta.playwithjava.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Maps {

    private Map<Integer, String> map = new HashMap<>();


    public static void main(String[] args) {
        Maps instance = new Maps();
        instance.fillTheMap();
        instance.getValueIfPresentOtherwiseDefault();
        instance.loopAllEntries();


        // void forEach(BiConsumer<? super K, ? super V> action);
        // Loop per tutte le entry
        // Esempio:  map.forEach((k, v) -> System.out.println("Key=" + k + " - value=" + v));


        // void replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
        // Modifica in place dei valori per tutte le chiavi
        // Esempio: map.replaceAll((k, v) -> v == null ? "default" : v);


        // V putIfAbsent(K key, V value)
        // Se la chiave esiste e il suo valore non è nullo, restituisce il valore
        // se no, aggiorna la mappa (chiave esistente con valore nullo) o
        // inserisce nuova entry se chiave non esistente)


        // boolean remove(Object key, Object value)
        // Rimuove una entry dalla mappa solo se key e value indicati esistono
        // Restituisce true se rimossa, false se non ha fatto niente


        // boolean replace(K key, V oldValue, V newValue)
        // Rimpiazza il valore di una entry solo se esiste con chiave e oldValue indicati
        // Restituisce true se rimossa, false se non ha fatto niente


        // V replace(K key, V value)
        // Rimpiazza il valore di una chiave solo se già esistente
        // Restituisce sempre il valore indicato (value)


        // V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)
        // Se la chiave non esiste o ha valore nullo, usa la funzione per calcolarne il valore
        // Se il valore calcolato non è nullo, lo salva nella mappa
        // Restituisce il valore trovato o quello calcolato
        // Esempio: map.computeIfAbsent(key, k -> new HashSet<V>()).add(v)


        // V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)
        // Se la chiave è presente con valore non nullo, ne ricalcola il valore usando la funzione
        // Se il valore calcolato è nullo, l'entry è rimossa dalla mappa
        // Restituisce il valore ricalcolato (se non nullo) o null
        // Esempio 1:
        // I've used computeIfPresent as a null-safe way to fetch lowercase values from a map of strings.
        // String s = fields.computeIfPresent("foo", (k,v) -> v.toLowerCase())
        // Esempio 2:
        // Map<String, Collection<String>> strings = new HashMap<>();
        // void addString(String a) {
        //    String index = a.substring(0, 1);
        //    strings.computeIfAbsent(index, ign -> new HashSet<>()).add(a);
        // }
        // void removeString(String a) {
        //    String index = a.substring(0, 1);
        //    strings.computeIfPresent(index, (i, c) -> c.remove(a) && c.isEmpty() ? null : c);
        //}


        // V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)
        // Usa la funzione per calcolare il nuovo valore a partire dal vecchio valore (se esiste)
        // Se il nuovo valore non è null, lo salva nella mappa
        // Restituisce il nuovo valore o null;
        // Esempio: map.compute(key, (k, v) -> (v == null) ? msg : v.concat(msg))}


        // V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction)
        // Value deve essere not null
        // Se la chiave NON esiste o ha valore nullo, crea/aggiorna la entry con il valore passato
        // Altrimenti (chiave esiste e ha valore non nullo) usa la funzione per calcolare il nuovo valore
        // o rimuove la entry se il valore calcolato è nullo
        // Esempio: map.merge(key, msg, String::concat)
        // Restituisce il nuovo valore o null


        // JAVA 9

        // <K, V> Map<K, V> of()
        // Restituisce mappa IMMUTABILE vuota

        // <K, V> Map<K, V> of(K k1, V v1.... k10, v10)
        // Restituisce mappa IMMUTABILE con le coppie chiave-valore indicate

        //<K, V> Map<K, V> ofEntries(Entry<? extends K, ? extends V>... entries)
        // Restituisce mappa IMMUTABILE con le entry indicate (usate solo per ricavare le coppie chiave-valore)

       //  <K, V> Map<K, V> copyOf(Map<? extends K, ? extends V> map)
        // Restituisce una mappa IMMUTABILE con la copia del contenuto della mappa passata
        // La mappa passata NON deve contenere chiavi o valori NULLI


    }

    private void loopAllEntries() {
        // Pre java 8
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key=" + entry.getKey() + " - value=" + entry.getValue());
        }

        // Java 8+
        map.forEach((k, v) -> System.out.println("Key=" + k + " - value=" + v));
    }


    private void getValueIfPresentOtherwiseDefault() {

        Integer key = 1;
        String defaultValue = "default";

        // Pre Java 8
        String value1 = defaultValue;
        if (map.containsKey(key)) {
            value1 = map.get(key);
        }

        // Java 8
        String value2 = map.getOrDefault(key, defaultValue);


    }

    private void fillTheMap() {
        map.put(1, "uno");
        map.put(2, "due");
        map.put(3, "tre");
    }


}
