package ntqjteam.lambdastreamapi.excercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InterestedTopicOperations {

	public static void main(String[] args) {

		List<Topic> currentTopics = new ArrayList<>(); // needs initializing
		currentTopics.add(new Topic("1", "Java Stream API", "Java 8"));
		currentTopics.add(new Topic("2", "OOP", "Object-Oriented Programming"));
		currentTopics.add(new Topic("3", "Exceptions", "Java"));

		List<Topic> updatingTopics = new ArrayList<>(); // needs initializing
		updatingTopics.add(new Topic("2", "OOP", "Object-Oriented Programming"));
		updatingTopics.add(new Topic("3", "Exceptions", "Java aaa"));
		updatingTopics.add(new Topic("4", "Multithreading", "Java bbb"));
		updatingTopics.add(new Topic("5", "JDBC Framework", "Spring Framework"));

		// Find out these groups of topics from currentTopics and updatingTopics
		Map<String, Topic> currentTopicByIds = currentTopics.stream().collect(Collectors.toMap(t -> t.getId(), t -> t));
		Map<String, Topic> updatingTopicByIds = updatingTopics.stream()
				.collect(Collectors.toMap(t -> t.getId(), t -> t));

		List<Topic> addedTopics = updatingTopics.stream().filter(t -> !currentTopicByIds.containsKey(t.getId()))
				.collect(Collectors.toList());
		List<Topic> updatedTopics = updatingTopics.stream().filter(t -> currentTopicByIds.containsKey(t.getId()))
				.collect(Collectors.toList());
		List<Topic> deletedTopics = currentTopics.stream().filter(t -> !updatingTopicByIds.containsKey(t.getId()))
				.collect(Collectors.toList());

	}
}