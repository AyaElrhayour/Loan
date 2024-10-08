package com.youcode.loan.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RequestStatus")
public class RequestStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "requestId")
    private Request request;

    @ManyToOne
    @JoinColumn(name = "statusId")
    private Status status;

    @Column
    private LocalDateTime UpdatedAt;
}
