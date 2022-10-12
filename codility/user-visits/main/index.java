package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class VisitCounter {

  Boolean isParseable(String key, UserStats value) {
    try {
      Long.parseLong(key);
      final Optional<Long> optionalValue = value.getVisits();
      if (optionalValue.isPresent()) {
        Long.parseLong(optionalValue.get().toString());
      } else {
        return false;
      }
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  Map<Long, Long> count(Map<String, UserStats>... visits) {
    Map<Long, Long> visitCount = new HashMap<Long, Long>();
    if(visits != null) {
      for (Map<String, UserStats> visit : visits) {
        if (visit != null) {
          visit.entrySet().stream()
            .filter(entry -> isParseable(entry.getKey(), entry.getValue()))
            .forEach(entry -> {
              Long userId = Long.parseLong(entry.getKey());
              Long visitCountForUser = entry.getValue().getVisits().get();
              if (visitCount.containsKey(userId)) {
                visitCount.put(userId, visitCount.get(userId) + visitCountForUser);
              } else {
                visitCount.put(userId, visitCountForUser);
              }
            });
        }
      }
    }
    return visitCount;
  }
}

class UserStats {
  private Long visits;

  UserStats() {
  }

  UserStats(Long visits) {
    this.visits = visits;
  }

  Optional<Long> getVisits() {
    if (this.visits == null) {
      return Optional.empty();
    }
    return Optional.of(visits);
  }
}

class Solution {
  public static void main(String[] args) {
    Map<String, UserStats> visits1 = Map.of(
        "1", new UserStats(10L),
        "2", new UserStats(20L));
    Map<String, UserStats> visits2 = Map.of(
        "3", new UserStats(30L),
        "4", new UserStats(40L));
    Map<String, UserStats> visits3 = Map.of(
        "5", new UserStats(50L),
        "6", new UserStats(60L),
        "7", new UserStats(70L));
    Map<String, UserStats> visits4 = Map.of(
        "8", new UserStats(80L),
        "9", new UserStats(90L),
        "10", new UserStats());
    Map<String, UserStats> visits5 = Map.of(
        "abc", new UserStats(13L));
    Map<String, UserStats> visits6 = null;

    final VisitCounter visitCounter = new VisitCounter();
    final Map<Long, Long> visits = visitCounter.count(visits1, visits2, visits3, visits4, visits5, visits6);
    System.out.println(visits);
  }
}