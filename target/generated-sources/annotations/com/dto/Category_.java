package com.dto;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Category.class)
public abstract class Category_ {

	public static volatile SingularAttribute<Category, String> categoryName;
	public static volatile SingularAttribute<Category, Integer> categoryId;
	public static volatile SingularAttribute<Category, Integer> parentId;

	public static final String CATEGORY_NAME = "categoryName";
	public static final String CATEGORY_ID = "categoryId";
	public static final String PARENT_ID = "parentId";

}

