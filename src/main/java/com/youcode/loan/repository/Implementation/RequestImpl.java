package com.youcode.loan.repository.Implementation;

import com.youcode.loan.config.ManagerFactory;
import com.youcode.loan.model.Request;
import com.youcode.loan.repository.Interface.RequestInterface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RequestImpl implements RequestInterface {

    private final EntityManager em;

    public RequestImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    public Optional<Request> addRequest(Request request) {
    EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(request);
            transaction.commit();
            return Optional.of(request);
        }catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<Request> getRequest(UUID id) {
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            Request request = em.find(Request.class, id);
            transaction.commit();
            return Optional.ofNullable(request);
        }catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }


    @Override
    public Optional<Request> updateRequest(Request request) {
        Request existingRequest = em.find(Request.class, request.getId());
        EntityTransaction transaction = em.getTransaction();
        if (existingRequest != null) {
            existingRequest.setProject(request.getProject());
            existingRequest.setOccupation(request.getOccupation());
            existingRequest.setAmount(request.getAmount());
            existingRequest.setPeriod(request.getPeriod());
            existingRequest.setMonthlyPayment(request.getMonthlyPayment());
            existingRequest.setEmail(request.getEmail());
            existingRequest.setPhone(request.getPhone());
            existingRequest.setTitle(request.getTitle());
            existingRequest.setName(request.getName());
            existingRequest.setLastName(request.getLastName());
            existingRequest.setIdCard(request.getIdCard());
            existingRequest.setBirthdate(request.getBirthdate());
            existingRequest.setHiringDate(request.getHiringDate());
            existingRequest.setMonthlyIncome(request.getMonthlyIncome());
            existingRequest.setOldLoan(request.getOldLoan());

            em.merge(existingRequest);
            transaction.commit();
            return Optional.of(existingRequest);
        }else {
            transaction.rollback();
            return Optional.empty();
        }
    }
    @Override
    public boolean removeRequest(UUID id) {
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            Request request = em.find(Request.class, id);
            if (request != null) {
                em.remove(request);
                transaction.commit();
                return true;
            }else {
                transaction.rollback();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Request> getAllRequests() {
        TypedQuery<Request> query = em.createQuery("SELECT r FROM Request r", Request.class);
        return query.getResultList();
    }


}
