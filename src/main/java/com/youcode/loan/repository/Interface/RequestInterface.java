package com.youcode.loan.repository.Interface;

import com.youcode.loan.model.Request;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RequestInterface {

    public Optional<Request> addRequest(Request request);
    public Optional<Request> getRequest(UUID id);
    public Optional<Request> updateRequest(Request request);
    public boolean removeRequest(UUID id);
    public List<Request> getAllRequests();


}
