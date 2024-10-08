package com.youcode.loan.repository.Interface;


import com.youcode.loan.model.Status;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StatusInterface {
    Optional<Status> addStatus(Status status);
    Optional<Status> getStatus(UUID id);
    Optional<Status> updateStatus(Status status);
    boolean removeStatus(UUID id);
    List<Status> getAllStatus();
}
