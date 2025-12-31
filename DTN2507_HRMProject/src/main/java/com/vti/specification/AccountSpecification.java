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
//		Like
		if (operator.equalsIgnoreCase("LIKE")) {
			if (field.equalsIgnoreCase("department")) {
				return criteriaBuilder.like(root.get(field).get("name"), "%" + value.toString() + "%");
			} else {
				return criteriaBuilder.like(root.get(field), "%" + value.toString() + "%");
			}

		}

//		Lọc dữ liệu Fillter id: 2-5
		if (operator.equalsIgnoreCase("BETWEEN")) {
//		value: [2,5]
			if (field.equalsIgnoreCase("id")) {

				Short[] values = (Short[]) value;
				short idFrom = values[0];
				short idto = values[1];
				return criteriaBuilder.between(root.get(field), idFrom, idto);
			}

		}
//		
		return null;
	}

}
