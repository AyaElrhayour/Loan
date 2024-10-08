package com.youcode.loan.repository.Interface;

import com.youcode.loan.model.RequestStatus;

import java.util.Optional;
import java.util.UUID;

public interface RequestStatusInterface {
    Optional<RequestStatus> getRequestStatus(UUID id);
}
