package com.example.restaurante.infrastructure.repository;

import com.example.restaurante.domain.model.Restaurante;
import com.example.restaurante.domain.repository.RestauranteRepositoryQueries;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;


@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurante> find(String nome,
                                  BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Restaurante> criteriaQuery = builder.createQuery(Restaurante.class); // criteria é um construtor de clausulas
        criteriaQuery.from(Restaurante.class);

        TypedQuery<Restaurante> query = manager.createQuery(criteriaQuery);
        return query.getResultList();
    }

}