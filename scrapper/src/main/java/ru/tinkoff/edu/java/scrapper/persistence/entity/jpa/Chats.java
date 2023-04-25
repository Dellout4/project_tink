package ru.tinkoff.edu.java.scrapper.persistence.entity.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Entity
@Data
@Table(name = "chats")
public class Chats {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "created_date", nullable = false, unique = true, updatable = false)
    private OffsetDateTime createdDate;
    @Column(name = "last_call_date", nullable = false)
    private LocalDate lastCallDate;
//    @OneToMany(mappedBy = "chat", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private List<ChatLink> links = new ArrayList<>();
}