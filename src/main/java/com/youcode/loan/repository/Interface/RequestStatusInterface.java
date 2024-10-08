package com.youcode.loan.repository.Interface;

import com.youcode.loan.model.RequestStatus;

import java.util.Optional;

public interface RequestStatusInterface {
    Optional<RequestStatus> getRequestStatus();
}
