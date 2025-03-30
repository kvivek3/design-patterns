package com.designpattern.behavioural.mediator;

interface ChatMediator {
    void showMessage(User user, String message);
}

class ChatRoom implements ChatMediator {

    @Override
    public void showMessage(User user, String message) {
        System.out.println(user.getName() + ": " + message);
    }
}

class User {
    private String name;
    private ChatRoom chatRoom;

    public User(String name, ChatRoom chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message) {
        chatRoom.showMessage(this, message);
    }
}

public class ChatApplication {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();
        User user1 = new User("Vivek", chatRoom);
        User user2 = new User("Shivangi", chatRoom);
        user1.sendMessage("Hi");
        user2.sendMessage("Blocked");
    }
}
