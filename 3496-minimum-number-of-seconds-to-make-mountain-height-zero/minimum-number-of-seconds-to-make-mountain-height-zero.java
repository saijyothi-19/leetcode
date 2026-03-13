import java.util.PriorityQueue;

class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        // Priority queue to store pairs in the form of (total_time, (original_time, iteration))
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        // Initialize the priority queue with worker times
        for (int time : workerTimes) {
            pq.offer(new long[]{time, time, 1}); // (current time, original time, iteration count)
        }

        long ans = 0;

        // Process each height increment of the mountain
        for (int i = 0; i < mountainHeight; i++) {
            long[] top = pq.poll();
            long currentTime = top[0];
            long originalTime = top[1];
            long iteration = top[2];

            ans = currentTime;

            // Push the next time for this worker back into the priority queue
            pq.offer(new long[]{currentTime + originalTime * (iteration + 1), originalTime, iteration + 1});
        }

        return ans;
    }
}