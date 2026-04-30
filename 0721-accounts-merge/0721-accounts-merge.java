import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        for (List<String> account : accounts) {
            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                graph.putIfAbsent(email, new HashSet<>());
                emailToName.put(email, name);

                if (i == 1) continue;

                graph.get(account.get(i - 1)).add(email);
                graph.get(email).add(account.get(i - 1));
            }
        }

        Set<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();

        for (String email : graph.keySet()) {
            if (!visited.contains(email)) {
                List<String> emails = new ArrayList<>();
                dfs(email, graph, visited, emails);
                Collections.sort(emails);

                List<String> account = new ArrayList<>();
                account.add(emailToName.get(email));
                account.addAll(emails);

                result.add(account);
            }
        }

        return result;
    }

    private void dfs(String email, Map<String, Set<String>> graph, Set<String> visited, List<String> emails) {
        visited.add(email);
        emails.add(email);

        for (String next : graph.get(email)) {
            if (!visited.contains(next)) {
                dfs(next, graph, visited, emails);
            }
        }
    }
}