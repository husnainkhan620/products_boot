CREATE TABLE IF NOT EXISTS PRODUCT_CATEGORY(
	productCategoryId int(10) not null,
	productCategoryName varchar(200) not null,
	productCategoryQuantity int(10),
	PRIMARY KEY (productCategoryId)
);

CREATE TABLE IF NOT EXISTS PRODUCT_SUB_CATEGORY(
	productSubCategoryId int(10) not null,
	productSubCategoryName varchar(200) not null,
	productCategoryId int(10) not null,
	productCategoryName varchar(200) not null,
	productSubCategoryQuantity int(10) not null,
	PRIMARY KEY (productSubCategoryId)
);
CREATE TABLE IF NOT EXISTS PRODUCT(
	productId int(10) not null,
	productName varchar(200) not null,
	productSubCategoryId int(10) not null,
	productSubCategoryName varchar(200) not null,
	productCategoryId int(10) not null,
	productCategoryName varchar(200) not null,
	productActive boolean,
	skucode varchar(20),
	productQuantity int(10),
	PRIMARY KEY (productId)
);