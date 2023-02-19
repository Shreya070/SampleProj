package collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Chatroom {
	private String name;
	private Set<String> username;
	private List<String> messages;

	public Chatroom(String name) {
		this.name = name;
	}

	public boolean removeUser(String username) {
		if (this.username.contains(username)) {
			this.username.remove(username);
			return true;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getUsername() {
		return username;
	}

	public void setUsername(Set<String> username) {
		this.username = username;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

}

class User {

	private String username;
	private String password;
	private String firstName;
	private String lastName;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}

class ChatApplication {

	private Map<String, Chatroom> chatrooms = new HashMap<String, Chatroom>();
	private Map<String, User> users = new HashMap<String, User>();
	private Set<String> loggedInUsers = new HashSet<String>();

	public Map<String, Chatroom> getChatrooms() {
		return chatrooms;
	}

	public void setChatrooms(Map<String, Chatroom> chatrooms) {
		this.chatrooms = chatrooms;
	}

	public Map<String, User> getUsers() {
		return users;
	}

	public void setUsers(Map<String, User> users) {
		this.users = users;
	}

	public Set<String> getLoggedInUsers() {
		return loggedInUsers;
	}

	public void setLoggedInUsers(Set<String> loggedInUsers) {
		this.loggedInUsers = loggedInUsers;
	}

	public boolean isChatroomNameValid(String name) {
		return chatrooms.containsKey(name);
	}

	public boolean isUsernameExists(String username) {
		return users.get(username).getUsername().contains(username);
	}

	public boolean authenticateUser(String username, String password) {

		if (users.containsKey(username) && users.get(username).getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}

	}

	// UI Methods Below
	public void createChatroom(Scanner input) {

		System.out.println("Enter the title of the chatroom: ");
		String name = input.nextLine();

		Chatroom chatroom = new Chatroom(name);

		chatrooms.put(name, chatroom);

	}

	public void addNewUser(Scanner input) {

		System.out.println("Enter your first and last name");
		String firstName = input.nextLine();
		String lastName = input.nextLine();
		System.out.println("Enter your username");
		String username = input.nextLine();
		System.out.println("Enter your password");
		String password = input.nextLine();

		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(password);
		user.setUsername(username);
		users.put(username, user);
		for (String chatroom : chatrooms.keySet()) {
			if (chatrooms.get(chatroom).getUsername() == null) {
				Set<String> usernames = new HashSet<String>();
				chatrooms.get(chatroom).setUsername(usernames);
				chatrooms.get(chatroom).getUsername().add(username);
			} else {
				chatrooms.get(chatroom).getUsername().add(username);
			}

		}

	}

	public boolean login(Scanner input) {
		
		System.out.println("Enter username");
		String username = input.nextLine();
		System.out.println("Enter password");
		String password = input.nextLine();

		if(loggedInUsers.add(username)) {
			return authenticateUser(username, password);
		}
		else if(loggedInUsers.contains(username)) {
			System.out.println("You are already logged in");
		}
		return false;
	}

	public void sendMessage(String chatroomName, Scanner input) {

		System.out.print("\nWrite Message: ");
		String message = input.nextLine();
		if (chatrooms.get(chatroomName).getMessages() == null) {
			List<String> messages = new ArrayList<String>();
			messages.add(message);
			chatrooms.get(chatroomName).setMessages(messages);
		} else {
			chatrooms.get(chatroomName).getMessages().add(message);
		}

	}

	public void printMessages(String chatroomName) {
		try {
			if (chatrooms.get(chatroomName) != null) {
				List<String> messages = chatrooms.get(chatroomName).getMessages();
				System.out.println("Messages from chatroom " + chatroomName + ": ");
				for (String message : messages) {
					System.out.println(message);
				}
				System.out.println("\n");
			} else {
				System.out.println("There is no such chatroom");
			}
		} catch (NullPointerException nullp) {
			System.out.println("There are no messages in this chatroom");
		}
	}

	public void listUsersFromChatroom(String chatroomName) {
		try {
			Set<String> users = chatrooms.get(chatroomName).getUsername();
			if (users.size() > 0) {
				System.out.println("Users from chatroom " + chatroomName + ": ");
				for (String user : users) {
					System.out.println(user);
				}
				System.out.println("\n");
			} else {
				System.out.println("There are no users in the chatroom");
			}
		} catch (NullPointerException nullp) {
			System.out.println("There are no users in the chatroom");
		}
	}

	public void logout(String username) {
		try {
			if (loggedInUsers.contains(username)) {
				loggedInUsers.remove(username);
				System.out.println("Logout success");
			} else {
				System.out.println("There is no such user logged in");
			}
		} catch (NullPointerException nullp) {
			System.out.println("There are no users logged in");
		}
	}

	public void deleteUser(String username) {
		try {
			users.remove(username);
			for (String chatroom : chatrooms.keySet()) {
				chatrooms.get(chatroom).removeUser(username);
			}
			System.out.println("User " + username + " deleted successfully");
		} catch (NullPointerException nullp) {
			System.out.println("There are no users on the Chatroom");
		}
	}

	public void deleteChatroom(String chatroomName) {
		try {
			chatrooms.remove(chatroomName);
			System.out.println("Chat room removed successfully");
		} catch (NullPointerException nullp) {
			System.out.println("There are no users on the Chatroom");
		}
	}

	public String menu(Scanner input) {

		System.out.println("Enter any Option:");
		System.out.println("A) Create a chatroom \nB) Add the user \nC) User login \nD) Send a message "
				+ "\nE) Display the messages from a specific chatroom \nF) List down all users belonging to the specified chat room "
				+ "\nG) Logout	\nH) Delete an User \nI) Delete the Chat room");
		String option = input.nextLine();
		option = option.toUpperCase();
		return option;
	}

}

public class Assignment3Q6 {

	public static void main(String[] args) {
		ChatApplication application = new ChatApplication();
		Scanner input = new Scanner(System.in);
		int tri = 1;
		while (tri!= 0) {
			char c = 'a';
			try {
				c = application.menu(input).charAt(0);
			} catch (StringIndexOutOfBoundsException strExc) {
				System.out.println("You have entered invalid option");
			}
			switch (c) {
			case 'A':
				application.createChatroom(input);
				break;

			case 'B':
				application.addNewUser(input);
				break;

			case 'C':
				if (application.login(input)) {
					System.out.println("User Logged  in ");
				} else {
					System.out.println("Username or password incorrect");
				}
				break;

			case 'D':
				System.out.println("Enter chatroom name: ");
				String chatroomName1 = input.nextLine();
				if (application.isChatroomNameValid(chatroomName1)) {
					application.sendMessage(chatroomName1, input);
				} else {
					System.out.println("Chatroom name incorrect");
				}

				break;

			case 'E':
				System.out.println("Enter chatroom name: ");
				String chatroomName2 = input.nextLine();
				if (application.isChatroomNameValid(chatroomName2)) {
					application.printMessages(chatroomName2);
				} else {
					System.out.println("There is no such Chatroom");
				}

				break;

			case 'F':
				System.out.println("Enter chatroom name: ");
				String chatroomName3 = input.nextLine();
				if (application.isChatroomNameValid(chatroomName3)) {
					application.listUsersFromChatroom(chatroomName3);
				} else {
					System.out.println("There is no such Chatroom");
				}

				break;

			case 'G':
				System.out.println("Enter the username");
				String username = input.nextLine();
				application.logout(username);

				break;

			case 'H':
				System.out.println("Enter the username");
				String username1 = input.nextLine();
				application.deleteUser(username1);

				break;

			case 'I':
				System.out.println("Enter the chatroom name");
				String chatroomName = input.nextLine();
				application.deleteChatroom(chatroomName);
				break;
			}
			System.out.println("Enter 1 for continue with menu or 0 for exiting application");
			try {
				int i = input.nextInt();
				
				tri = i;
				input.nextLine();
			}
			catch(Exception e) {
				System.out.println("You have entered invalid option");
			}
		}
		System.out.println("Exit from application Successfully");
	}

}