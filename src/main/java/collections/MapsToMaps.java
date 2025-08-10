package collections;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

class MapsToMaps {
    public static void main(String[] args) {
        mapsToMaps();
    }
    public static void mapsToMaps(){
        Map<String, Integer> channelToSubscribers    = new TreeMap<>(); // channel, numSubscribers
        Map<String, String> channelToPublisher       = new TreeMap<>(); // channel, publisher
        Map<String, Integer> publisherToSubscribers  = new TreeMap<>(); // publisher, numSubscribers

        // channel -> number of subscribers
        // K -> V1
        channelToSubscribers.put("JustForLaughs", 120_000); 
        channelToSubscribers.put("JustForGags", 10_000); 
        channelToSubscribers.put("ContemplationTechniques", 10_000); 
        channelToSubscribers.put("A New Earth", 20_000); 
        
        // channel -> publisher
        // K -> V2
        channelToPublisher.put("JustForLaughs", "Charlie Chaplin");
        channelToPublisher.put("JustForGags", "Charlie Chaplin");
        channelToPublisher.put("ContemplationTechniques", "Echhart Tolle");
        channelToPublisher.put("A New Earth", "Echhart Tolle");

        // 1. Setup "publisherToSubscribers"
        // publisher -> number of subscribers (total)   
        // V2 -> V1
        publisherToSubscribers = channelToPublisher.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getValue,
                                entry -> channelToSubscribers.get(entry.getKey()),
                                Integer::sum,
                                TreeMap::new));


        // 2. Output "publisherToSubscribers"
        System.out.println(publisherToSubscribers);


        // 3. Who has the most/least subscribers?
        publisherToSubscribers
                .entrySet()
                .stream()
                .min(Comparator.comparing(Map.Entry::getValue))
                .ifPresent(entry -> System.out.println(entry.getKey()));

        publisherToSubscribers
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .ifPresent(entry -> System.out.println(entry.getKey()));
    }
}