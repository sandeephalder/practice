package heap2;

import java.util.HashMap;
import java.util.Map;

public class TaskScheduler {
    
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        Map<Character, Integer> taskMap = new HashMap<>();
        // highest frequency of the same task appearing
        int maxFrequency = 0;
        for (char task : tasks) {
            taskMap.put(task, taskMap.getOrDefault(task, 0) + 1);
            maxFrequency = Math.max(taskMap.get(task), maxFrequency);
        }

        // number of such max frequency tasks
        int maxFreqTasks = 0;
        for (char task : taskMap.keySet()) {
            if (taskMap.get(task) == maxFrequency) {
                maxFreqTasks++;
            }
        }

        // rest of the tasks
        int nonMaxFreqTasks = tasks.length - (maxFreqTasks * maxFrequency);
        // rest of the distributed tasks on each cycle
        int cycleLength = maxFrequency > 1 ? (nonMaxFreqTasks / (maxFrequency - 1)) : 0;
        // extra tasks distributed to the first few cycles if any
        int remaining = maxFrequency > 1 ? (nonMaxFreqTasks % (maxFrequency - 1)) : 0;

        // total length of each cycle (minus remaining)
        int cycle = maxFreqTasks + cycleLength;
        int idle = 0;
        // distribute idles if needed
        if (cycle + 1 <= n && remaining > 0) {
            idle += ((maxFrequency - 1) * (n - cycle));
        } else if (cycle <= n && remaining == 0) {
            idle += ((maxFrequency - 1) * (n - cycle + 1));
        }
        // add extra idles for the cycles that didn't get the "remaining" tasks
        if (remaining > 0 && cycle <= n) {
            idle += (maxFrequency - 1 - remaining);
        }
        return tasks.length + idle;
    }
}

