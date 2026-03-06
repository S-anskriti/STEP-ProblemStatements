import java.util.*;

public class ProblemStatement1 {

    static class Entry {
        String ip;
        long expiry;

        Entry(String ip, long ttl) {
            this.ip = ip;
            this.expiry = System.currentTimeMillis() + ttl * 1000;
        }
    }

    static HashMap<String, Entry> cache = new HashMap<>();
    static int hits = 0;
    static int miss = 0;
    static int limit = 5;

    public static void main(String[] args) {
        System.out.println(resolve("google.com"));
        System.out.println(resolve("google.com"));
        System.out.println(getCacheStats());
    }

    static String resolve(String domain) {
        if (cache.containsKey(domain)) {
            Entry e = cache.get(domain);
            if (System.currentTimeMillis() < e.expiry) {
                hits++;
                return "Cache HIT " + e.ip;
            } else {
                cache.remove(domain);
            }
        }

        miss++;
        String ip = queryDNS(domain);

        if (cache.size() >= limit) {
            String key = cache.keySet().iterator().next();
            cache.remove(key);
        }

        cache.put(domain, new Entry(ip, 300));
        return "Cache MISS " + ip;
    }

    static String queryDNS(String domain) {
        Random r = new Random();
        return "172.217.14." + (200 + r.nextInt(20));
    }

    static String getCacheStats() {
        int total = hits + miss;
        double rate = 0;
        if (total > 0) rate = (hits * 100.0) / total;
        return "Hit Rate: " + rate + "%";
    }
}