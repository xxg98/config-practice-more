package com.yyh.outandinconfig.service.request;

import com.yyh.outandinconfig.pojo.User;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Builder
public class UserQueryRequest {

    private Long id;

    private String name;

    private String str;

    public Specification<User> getWhereCriteria() {

        return (root, query, cb) -> {
            List<Predicate> predicateList = new ArrayList<>();
            if(Objects.nonNull(id)){
                predicateList.add(cb.equal(root.get("id"), id));
            }

            if(Objects.nonNull(name)){
                predicateList.add(cb.like(root.get("name"),"%"+name+"%"));
            }

            if(Objects.nonNull(str)){
                predicateList.add(cb.like(root.get("name"),"%"+name+"%"));
            }

            Predicate[] predicates = predicateList.toArray(new Predicate[predicateList.size()]);

            return predicates.length == 0 ? null : predicates.length == 1 ? predicates[0] : cb.and(predicates);
        };
    }
}
