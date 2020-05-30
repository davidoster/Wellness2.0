
package com.afdemp.wellness.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Message {
    
    private String name;
    private String content;
    
    private static List<Message> messages = new ArrayList();

    public Message(String name, String content) {
        this.name = name;
        this.content = content;
    }
    
    public static void addMessage(Message m){
        messages.add(m);
    }

    public Message() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static List<Message> getMessages() {
        return messages;
    }

    public static void setMessages(List<Message> messages) {
        Message.messages = messages;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.name);
        hash = 13 * hash + Objects.hashCode(this.content);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Message other = (Message) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.content, other.content)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Message{" + "name=" + name + ", content=" + content + '}';
    }
    
    
}
