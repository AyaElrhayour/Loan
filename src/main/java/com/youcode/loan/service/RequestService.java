package com.youcode.loan.service;

import com.youcode.loan.repository.Interface.RequestInterface;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RequestService{

    @Inject
    private RequestInterface request;

    public RequestInterface createRequest() {
        Optional<RequestInterface> optionalRequest = request.addRequest(request);
        return optionalRequest.orElse(null);
    }

    public RequestInterface getRequestById (UUID uuid) {


    public List<RequestInterface> getRequests() {
        return request.getAllRequests();
    }

    public boolean deleteRequestById(UUID uuid) {

    }

    public boolean updateRequest(RequestInterface request) {
        //if(uuid.toString().isEmpty() || request.getRequest(id).isEmpty())
    }
}
