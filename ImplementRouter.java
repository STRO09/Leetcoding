// class Router {
//     LinkedHashSet<List<Integer>> router = new LinkedHashSet<List<Integer>>();
//     int routersize;
//     public Router(int memoryLimit) {
//         this.routersize = memoryLimit;   
//     }
    
//     public boolean addPacket(int source, int destination, int timestamp) {
//         if(router.contains(Arrays.asList(source,destination,timestamp))) return false;
//         if(router.size()==routersize) {
//             Iterator<List<Integer>> it = router.iterator();
//             while(it.hasNext()){
//                 it.next();
//                 it.remove();
//                 break;
//             }
//         }
//         return router.add(Arrays.asList(source,destination,timestamp));
//     }
    
//     public int[] forwardPacket() {
//         if(router.size()==0) {
//             return new int[0];
//         }
//          Iterator<List<Integer>> it = router.iterator();
//             while(it.hasNext()){
//                 List<Integer> firstPacket = it.next();
//                 int source = firstPacket.get(0);
//                 int destination = firstPacket.get(1);
//                 int timestamp = firstPacket.get(2);
//                 it.remove();
//                 return new int[]{source,destination,timestamp};
//             }
//        return new int[0]; 
//     }
    
//     public int getCount(int destination, int startTime, int endTime) {
//         int count = 0;
//         Iterator<List<Integer>> it = router.iterator();
//             while(it.hasNext()){
//                 List<Integer> packet = it.next();
//                 if(packet.get(1)==destination && packet.get(2)>=startTime && packet.get(2)<=endTime){
//                     count++;
//                 }
//                 if(packet.get(2)>endTime) break;
//             }
//         return count;
//     }
// }

// /**
//  * Your Router object will be instantiated and called as such:
//  * Router obj = new Router(memoryLimit);
//  * boolean param_1 = obj.addPacket(source,destination,timestamp);
//  * int[] param_2 = obj.forwardPacket();
//  * int param_3 = obj.getCount(destination,startTime,endTime);
//  */

//tried, I think my attempt was good but oh well knew the get function would get me in time limit

// so yea gpt had to come in ofc

import java.util.*;

class Packet {
    int source, destination, timestamp;

    Packet(int s, int d, int t) {
        source = s;
        destination = d;
        timestamp = t;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Packet)) return false;
        Packet p = (Packet) o;
        return source == p.source && destination == p.destination && timestamp == p.timestamp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination, timestamp);
    }
}

class Router {
    private LinkedList<Packet> fifo = new LinkedList<>();
    private Set<Packet> unique = new HashSet<>();
    private Map<Integer, TreeMap<Integer, Integer>> destPrefixSum = new HashMap<>();
    private int memoryLimit;

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet p = new Packet(source, destination, timestamp);

        if (unique.contains(p)) return false;

        // Remove oldest packet if memory limit reached
        if (fifo.size() == memoryLimit) {
            Packet oldest = fifo.pollFirst();
            unique.remove(oldest);

            TreeMap<Integer, Integer> tsMap = destPrefixSum.get(oldest.destination);
            if (tsMap != null) {
                // Decrement counts from oldest.timestamp and onward
                NavigableMap<Integer, Integer> tail = tsMap.tailMap(oldest.timestamp, true);
                for (Map.Entry<Integer, Integer> entry : tail.entrySet()) {
                    tsMap.put(entry.getKey(), entry.getValue() - 1);
                }
                // Clean up zeros
                tsMap.entrySet().removeIf(e -> e.getValue() == 0);
            }
        }

        fifo.addLast(p);
        unique.add(p);

        TreeMap<Integer, Integer> tsMap = destPrefixSum.computeIfAbsent(destination, k -> new TreeMap<>());

        // Add packet timestamp with prefix sum
        Integer prevSum = tsMap.floorEntry(timestamp) != null ? tsMap.floorEntry(timestamp).getValue() : 0;
        tsMap.put(timestamp, prevSum + 1);

        // Update following timestamps
        NavigableMap<Integer, Integer> tail = tsMap.tailMap(timestamp, false);
        for (Map.Entry<Integer, Integer> entry : tail.entrySet()) {
            tsMap.put(entry.getKey(), entry.getValue() + 1);
        }

        return true;
    }

    public int[] forwardPacket() {
        if (fifo.isEmpty()) return new int[0];

        Packet p = fifo.pollFirst();
        unique.remove(p);

        TreeMap<Integer, Integer> tsMap = destPrefixSum.get(p.destination);
        if (tsMap != null) {
            NavigableMap<Integer, Integer> tail = tsMap.tailMap(p.timestamp, true);
            for (Map.Entry<Integer, Integer> entry : tail.entrySet()) {
                tsMap.put(entry.getKey(), entry.getValue() - 1);
            }
            tsMap.entrySet().removeIf(e -> e.getValue() == 0);
        }

        return new int[]{p.source, p.destination, p.timestamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        TreeMap<Integer, Integer> tsMap = destPrefixSum.get(destination);
        if (tsMap == null || tsMap.isEmpty()) return 0;

        int endSum = tsMap.floorEntry(endTime) != null ? tsMap.floorEntry(endTime).getValue() : 0;
        int startSum = tsMap.lowerEntry(startTime) != null ? tsMap.lowerEntry(startTime).getValue() : 0;

        return endSum - startSum;
    }
}
