package com.youcode.loan.repository.Implementation;

import com.youcode.loan.model.RequestStatus;
import com.youcode.loan.repository.Interface.RequestStatusInterface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.Optional;
import java.util.UUID;

public class RequestStatusImplementation implements RequestStatusInterface {

    private final EntityManager em;

    public RequestStatusImplementation(EntityManager em) {
        this.em = em;
    }


    @Override
    public Optional<RequestStatus> getRequestStatus(UUID id) {
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            RequestStatus requestStatus = em.find(RequestStatus.class, id);
            transaction.commit();
            return Optional.of(requestStatus);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
