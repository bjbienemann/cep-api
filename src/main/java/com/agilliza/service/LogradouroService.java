package com.agilliza.service;

import com.agilliza.model.Logradouro;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@ApplicationScoped
public class LogradouroService {

    @Inject
    EntityManager entityManager;

    public Logradouro findByCep(String cep) {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Logradouro> criteriaQuery = builder.createQuery(Logradouro.class);
        Root<Logradouro> root = criteriaQuery.from(Logradouro.class);

        Predicate predicate = builder.equal(root.get("cep"), cep);
        criteriaQuery.where(predicate);

        TypedQuery<Logradouro> typedQuery = this.entityManager.createQuery(criteriaQuery);
        return typedQuery.getSingleResult();
    }
}
