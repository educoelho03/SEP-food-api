package com.example.restaurante.infrastructure.repository.spec;

import com.example.restaurante.domain.model.Restaurante;
import org.springframework.data.jpa.domain.Specification;

public class RestauranteSpecs {

    public static Specification<Restaurante> comFreteGratis() {
        return (root, query, builder) ->
                builder.equal(root.get("frete"), 0);
    }

    public static Specification<Restaurante> comNomeSemelhante(String nome) {
        return (root, query, builder) ->
                builder.like(root.get("nome"), "%" + nome + "%");
    }

}
