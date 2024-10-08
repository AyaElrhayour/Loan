package com.youcode.loan.service;

import com.youcode.loan.repository.Implementation.RequestImpl;
import com.youcode.loan.model.Request;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
@AllArgsConstructor
@NoArgsConstructor
public class RequestService{

    private RequestImpl requestImpl;

    public void addRequest(Request request) throws Exception{
        if (request == null){
            throw new Exception("Request can't be null");
        }else {
            requestImpl.addRequest(request);
        }
    }

    public Request getRequestById(String id) throws Exception{
        if (id.toString().isEmpty()){
            throw new Exception("Request id can't be empty");
        }else {
            return requestImpl.getRequest(UUID.fromString(id)).orElse(null);
        }
    }

    public List<Request> getAllRequests() {
        return requestImpl.getAllRequests();
    }

    public boolean deleteRequest(UUID id) {
        if (id.toString().isEmpty() || requestImpl.getRequest(id).isEmpty()){
            return false;
        }else {
            return requestImpl.removeRequest(id);
        }
    }

    public Request updateRequest(Request request) throws Exception{
        if (requestImpl.getRequest(request.getId()).isEmpty()){
            throw new Exception("Request id can't be empty");
        }else {
            return requestImpl.updateRequest(request).get();
        }
    }
}
