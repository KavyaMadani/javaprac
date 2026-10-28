import java.util.*;

public class Leaderboard {
public static void main(String[] args) {
Map<String, Integer> scores = new HashMap<>();

```
    scores.put("Kavya", 95);
    scores.put("Rahul", 88);
    scores.put("Amit", 95);
    scores.put("Priya", 91);
    scores.put("Neha", 85);

    List<Map.Entry<String, Integer>> leaderboard =
        new ArrayList<>(scores.entrySet());

    leaderboard.sort((a, b) -> {
        int result = b.getValue().compareTo(a.getValue());

        if (result == 0) {
            return a.getKey().compareTo(b.getKey());
        }

        return result;
    });

    int topN = 3;

    System.out.println("Top " + topN + " Players:");

    for (int i = 0; i < Math.min(topN, leaderboard.size()); i++) {
        Map.Entry<String, Integer> player = leaderboard.get(i);

        System.out.println(player.getKey() + " : " + player.getValue());
    }
}
```

}
