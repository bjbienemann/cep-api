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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@ApplicationScoped
public class LogradouroService {

    @Inject
    private EntityManager entityManager;

    public Logradouro findByCep(String cep) {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Logradouro> criteriaQuery = builder.createQuery(Logradouro.class);
        Root<Logradouro> root = criteriaQuery.from(Logradouro.class);

        Predicate predicate = builder.equal(root.get("cep"), cep);
        criteriaQuery.where(predicate);

        TypedQuery<Logradouro> typedQuery = this.entityManager.createQuery(criteriaQuery);
        return typedQuery.getSingleResult();
    }

    public List<Logradouro> findByNome(String nome) {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Logradouro> criteriaQuery = builder.createQuery(Logradouro.class);
        Root<Logradouro> root = criteriaQuery.from(Logradouro.class);

        Predicate predicate = builder.like(
                builder.upper(root.get("nome")), "%"+nome.toUpperCase()+"%");

        criteriaQuery.where(predicate);

        TypedQuery<Logradouro> typedQuery = this.entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    public Logradouro find(Map<String, Object> map) {
        if (map.isEmpty()) {
            return null;
        } else {
            CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
            CriteriaQuery<Logradouro> criteriaQuery = builder.createQuery(Logradouro.class);
            Root<Logradouro> root = criteriaQuery.from(Logradouro.class);

            List<Predicate> predicates = new ArrayList<>();
            map.forEach((key, value) -> {
                Predicate predicate = builder.equal(root.get(key), value);
                predicates.add(predicate);
            });

            Predicate[] a = new Predicate[predicates.size()];
            criteriaQuery.where(predicates.toArray(a));

            TypedQuery<Logradouro> typedQuery = this.entityManager.createQuery(criteriaQuery);
            return typedQuery.getSingleResult();
        }
    }
}
