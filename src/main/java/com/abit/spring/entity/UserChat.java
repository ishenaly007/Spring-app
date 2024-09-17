package com.abit.spring.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@Builder
@Table(name = "users_chat")
public class UserChat implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_id")
    private Chat chat;

    public void addUser(User user) {
        this.user = user;
        user.getUserChats().add(this);
    }

    public void addChat(Chat chat) {
        this.chat = chat;
        chat.getUserChats().add(this);
    }
}