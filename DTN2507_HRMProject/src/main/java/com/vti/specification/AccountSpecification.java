package com.vti.specification;

import org.springframework.data.jpa.domain.Specification;

import com.vti.entity.Account;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@SuppressWarnings("serial")
public class AccountSpecification implements Specification<Account> {

	private String field;
	private String operator;
	private Object value;

// Hàm khởi tạo
	public AccountSpecification(String field, String operator, Object value) {
		this.field = field;
		this.operator = operator;
		this.value = value;
	}

	@Override
	public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//		
		if (operator.equalsIgnoreCase("LIKE")) {
			return criteriaBuilder.like(root.get(field), "%" + value.toString() + "%");
		}
//		
		return null;
	}

}
