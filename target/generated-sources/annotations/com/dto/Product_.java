package com.dto;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class Product_ {

	public static volatile SingularAttribute<Product, Integer> productId;
	public static volatile SingularAttribute<Product, Float> price;
	public static volatile SingularAttribute<Product, String> imagePath;
	public static volatile SingularAttribute<Product, String> description;
	public static volatile SingularAttribute<Product, Integer> stock;
	public static volatile SingularAttribute<Product, Category> category;
	public static volatile SingularAttribute<Product, String> brand;
	public static volatile SingularAttribute<Product, Long> version;
	public static volatile SingularAttribute<Product, String> productName;
	public static volatile ListAttribute<Product, Property> properties;

	public static final String PRODUCT_ID = "productId";
	public static final String PRICE = "price";
	public static final String IMAGE_PATH = "imagePath";
	public static final String DESCRIPTION = "description";
	public static final String STOCK = "stock";
	public static final String CATEGORY = "category";
	public static final String BRAND = "brand";
	public static final String VERSION = "version";
	public static final String PRODUCT_NAME = "productName";
	public static final String PROPERTIES = "properties";

}

