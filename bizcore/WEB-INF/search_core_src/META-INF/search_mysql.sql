-- BUILD WITH MODEL TIME 190109T2342
drop database  if exists search;
create database search;
alter  database search  character set = utf8mb4  collate = utf8mb4_unicode_ci; -- 支持表情符号
use search;

drop table  if exists platform_data;
create table platform_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(92)                              comment 'Name',
	introduction        	varchar(288)                             comment 'Introduction',
	current_version     	varchar(16)                              comment 'Current Version',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists site_data;
create table site_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(92)                              comment 'Name',
	introduction        	varchar(148)                             comment 'Introduction',
	platform            	varchar(48)                              comment 'Platform',
	last_update_time    	varchar(64)                              comment 'Last Update Time',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists catalog_data;
create table catalog_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(20)                              comment 'Name',
	seller_id           	varchar(32)                              comment 'Seller Id',
	site                	varchar(48)                              comment 'Site',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists level_one_category_data;
create table level_one_category_data (
	id                  	varchar(64)          not null            comment 'Id',
	catalog             	varchar(48)                              comment 'Catalog',
	name                	varchar(52)                              comment 'Name',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists level_two_category_data;
create table level_two_category_data (
	id                  	varchar(64)          not null            comment 'Id',
	parent_category     	varchar(48)                              comment 'Parent Category',
	name                	varchar(52)                              comment 'Name',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists level_n_category_data;
create table level_n_category_data (
	id                  	varchar(64)          not null            comment 'Id',
	parent_category     	varchar(48)                              comment 'Parent Category',
	name                	varchar(44)                              comment 'Name',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists brand_data;
create table brand_data (
	id                  	varchar(64)          not null            comment 'Id',
	brand_name          	varchar(40)                              comment 'Brand Name',
	logo                	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment 'Logo',
	remark              	varchar(336)                             comment 'Remark',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists product_data;
create table product_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(20)                              comment 'Name',
	parent_category     	varchar(48)                              comment 'Parent Category',
	brand               	varchar(48)                              comment 'Brand',
	origin              	varchar(24)                              comment 'Origin',
	catalog             	varchar(48)                              comment 'Catalog',
	remark              	varchar(336)                             comment 'Remark',
	last_update_time    	varchar(64)                              comment 'Last Update Time',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists product_recommendation_data;
create table product_recommendation_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(20)                              comment 'Name',
	brand               	varchar(48)                              comment 'Brand',
	origin              	varchar(24)                              comment 'Origin',
	product             	varchar(48)                              comment 'Product',
	remark              	varchar(336)                             comment 'Remark',
	last_update_time    	varchar(64)                              comment 'Last Update Time',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists sku_data;
create table sku_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(52)                              comment 'Name',
	size                	varchar(24)                              comment 'Size',
	product             	varchar(48)                              comment 'Product',
	active              	tinyint                                  comment 'Active',
	base_price          	numeric(7,2)                             comment 'Base Price',
	last_update_time    	varchar(64)                              comment 'Last Update Time',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists profile_data;
create table profile_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(72)                              comment 'Name',
	age                 	int                                      comment 'Age',
	gender              	varchar(24)                              comment 'Gender',
	last_update_time    	varchar(64)                              comment 'Last Update Time',
	platform            	varchar(48)                              comment 'Platform',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists shipping_address_data;
create table shipping_address_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(24)                              comment 'Name',
	line1               	varchar(100)                             comment 'Line1',
	line2               	varchar(48)                              comment 'Line2',
	city                	varchar(60)                              comment 'City',
	state               	varchar(8)                               comment 'State',
	zip_code            	int                                      comment 'Zip Code',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists payment_method_data;
create table payment_method_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(44)                              comment 'Name',
	number              	varchar(52)                              comment 'Number',
	line1               	varchar(88)                              comment 'Line1',
	line2               	varchar(40)                              comment 'Line2',
	city                	varchar(48)                              comment 'City',
	expire_on           	date                                     comment 'Expire On',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists user_order_data;
create table user_order_data (
	id                  	varchar(64)          not null            comment 'Id',
	title               	varchar(64)                              comment 'Title',
	total_adjustment    	numeric(7,2)                             comment 'Total Adjustment',
	total_amount        	numeric(9,2)                             comment 'Total Amount',
	user                	varchar(48)                              comment 'User',
	platform            	varchar(48)                              comment 'Platform',
	last_update_time    	varchar(64)                              comment 'Last Update Time',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists line_item_data;
create table line_item_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(52)                              comment 'Name',
	quantity            	int                                      comment 'Quantity',
	price               	numeric(7,2)                             comment 'Price',
	discount_price      	numeric(6,2)                             comment 'Discount Price',
	user_order          	varchar(48)                              comment 'User Order',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists order_promotion_data;
create table order_promotion_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(60)                              comment 'Name',
	amount              	int                                      comment 'Amount',
	thread_hold         	int                                      comment 'Thread Hold',
	type                	varchar(44)                              comment 'Type',
	user_order          	varchar(48)                              comment 'User Order',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists manual_adjustment_data;
create table manual_adjustment_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(60)                              comment 'Name',
	amount              	int                                      comment 'Amount',
	thread_hold         	int                                      comment 'Thread Hold',
	type                	varchar(36)                              comment 'Type',
	user_order          	varchar(48)                              comment 'User Order',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists shipping_group_data;
create table shipping_group_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(48)                              comment 'Name',
	line1               	varchar(100)                             comment 'Line1',
	line2               	varchar(48)                              comment 'Line2',
	city                	varchar(60)                              comment 'City',
	state               	varchar(8)                               comment 'State',
	zip_code            	int                                      comment 'Zip Code',
	country             	varchar(8)                               comment 'Country',
	user_order          	varchar(48)                              comment 'User Order',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists payment_group_data;
create table payment_group_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(52)                              comment 'Name',
	amount              	numeric(7,2)                             comment 'Amount',
	user_order          	varchar(48)                              comment 'User Order',
	status              	varchar(28)                              comment 'Status',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists user_domain_data;
create table user_domain_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(16)                              comment 'Name',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists user_white_list_data;
create table user_white_list_data (
	id                  	varchar(64)          not null            comment 'Id',
	user_identity       	varchar(40)                              comment 'User Identity',
	user_special_functions	varchar(200)                             comment 'User Special Functions',
	domain              	varchar(48)                              comment 'Domain',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists sec_user_data;
create table sec_user_data (
	id                  	varchar(64)          not null            comment 'Id',
	login               	varchar(20)                              comment 'Login',
	mobile              	varchar(11)                              comment 'Mobile',
	email               	varchar(76)                              comment 'Email',
	pwd                 	varchar(64)                              comment 'Pwd',
	verification_code   	int                                      comment 'Verification Code',
	verification_code_expire	datetime                                 comment 'Verification Code Expire',
	last_login_time     	datetime                                 comment 'Last Login Time',
	domain              	varchar(48)                              comment 'Domain',
	blocking            	varchar(48)                              comment 'Blocking',
	current_status      	varchar(28)                              comment 'Current Status',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists sec_user_blocking_data;
create table sec_user_blocking_data (
	id                  	varchar(64)          not null            comment 'Id',
	who                 	varchar(52)                              comment 'Who',
	block_time          	datetime                                 comment 'Block Time',
	comments            	varchar(96)                              comment 'Comments',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists user_app_data;
create table user_app_data (
	id                  	varchar(64)          not null            comment 'Id',
	title               	varchar(300)                             comment 'Title',
	sec_user            	varchar(48)                              comment 'Sec User',
	app_icon            	varchar(36)                              comment 'App Icon',
	full_access         	tinyint                                  comment 'Full Access',
	permission          	varchar(16)                              comment 'Permission',
	object_type         	varchar(108)                             comment 'Object Type',
	object_id           	varchar(40)                              comment 'Object Id',
	location            	varchar(48)                              comment 'Location',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists list_access_data;
create table list_access_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(200)                             comment 'Name',
	internal_name       	varchar(200)                             comment 'Internal Name',
	read_permission     	tinyint                                  comment 'Read Permission',
	create_permission   	tinyint                                  comment 'Create Permission',
	delete_permission   	tinyint                                  comment 'Delete Permission',
	update_permission   	tinyint                                  comment 'Update Permission',
	execution_permission	tinyint                                  comment 'Execution Permission',
	app                 	varchar(48)                              comment 'App',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists object_access_data;
create table object_access_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(28)                              comment 'Name',
	object_type         	varchar(112)                             comment 'Object Type',
	list1               	varchar(80)                              comment 'List1',
	list2               	varchar(80)                              comment 'List2',
	list3               	varchar(80)                              comment 'List3',
	list4               	varchar(80)                              comment 'List4',
	list5               	varchar(80)                              comment 'List5',
	list6               	varchar(80)                              comment 'List6',
	list7               	varchar(80)                              comment 'List7',
	list8               	varchar(80)                              comment 'List8',
	list9               	varchar(80)                              comment 'List9',
	app                 	varchar(48)                              comment 'App',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists login_history_data;
create table login_history_data (
	id                  	varchar(64)          not null            comment 'Id',
	login_time          	datetime                                 comment 'Login Time',
	from_ip             	varchar(44)                              comment 'From Ip',
	description         	varchar(16)                              comment 'Description',
	sec_user            	varchar(48)                              comment 'Sec User',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists generic_form_data;
create table generic_form_data (
	id                  	varchar(64)          not null            comment 'Id',
	title               	varchar(20)                              comment 'Title',
	description         	varchar(48)                              comment 'Description',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists form_message_data;
create table form_message_data (
	id                  	varchar(64)          not null            comment 'Id',
	title               	varchar(24)                              comment 'Title',
	form                	varchar(48)                              comment 'Form',
	level               	varchar(28)                              comment 'Level',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists form_field_message_data;
create table form_field_message_data (
	id                  	varchar(64)          not null            comment 'Id',
	title               	varchar(16)                              comment 'Title',
	parameter_name      	varchar(16)                              comment 'Parameter Name',
	form                	varchar(48)                              comment 'Form',
	level               	varchar(28)                              comment 'Level',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists form_field_data;
create table form_field_data (
	id                  	varchar(64)          not null            comment 'Id',
	label               	varchar(12)                              comment 'Label',
	locale_key          	varchar(44)                              comment 'Locale Key',
	parameter_name      	varchar(16)                              comment 'Parameter Name',
	type                	varchar(36)                              comment 'Type',
	form                	varchar(48)                              comment 'Form',
	placeholder         	varchar(48)                              comment 'Placeholder',
	default_value       	varchar(12)                              comment 'Default Value',
	description         	varchar(48)                              comment 'Description',
	field_group         	varchar(16)                              comment 'Field Group',
	minimum_value       	varchar(60)                              comment 'Minimum Value',
	maximum_value       	varchar(72)                              comment 'Maximum Value',
	required            	tinyint                                  comment 'Required',
	disabled            	tinyint                                  comment 'Disabled',
	custom_rendering    	tinyint                                  comment 'Custom Rendering',
	candidate_values    	varchar(12)                              comment 'Candidate Values',
	suggest_values      	varchar(12)                              comment 'Suggest Values',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists form_action_data;
create table form_action_data (
	id                  	varchar(64)          not null            comment 'Id',
	label               	varchar(8)                               comment 'Label',
	locale_key          	varchar(16)                              comment 'Locale Key',
	action_key          	varchar(24)                              comment 'Action Key',
	level               	varchar(28)                              comment 'Level',
	url                 	varchar(168)                             comment 'Url',
	form                	varchar(48)                              comment 'Form',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;






	
insert into platform_data values ('P000001','Chain eComerce Platform','new generation of eCommerce platform based on opensource and modern tech','V1.0','1');

	
insert into site_data values ('S000001','The first customer site','The primary site for show the concept','P000001','lastUpdateTime()','1');
insert into site_data values ('S000002','The first customer site0002','The primary site for show the concept0002','P000001','lastUpdateTime()0002','1');

	
insert into catalog_data values ('C000001','Cloth','SC000001','S000001','1');
insert into catalog_data values ('C000002','Cloth0002','SC0000010002','S000001','1');
insert into catalog_data values ('C000003','Cloth0003','SC0000010003','S000002','1');
insert into catalog_data values ('C000004','Cloth0004','SC0000010004','S000002','1');

	
insert into level_one_category_data values ('LOC000001','C000001','Level One Cat','1');
insert into level_one_category_data values ('LOC000002','C000001','Level One Cat0002','1');
insert into level_one_category_data values ('LOC000003','C000002','Level One Cat0003','1');
insert into level_one_category_data values ('LOC000004','C000002','Level One Cat0004','1');
insert into level_one_category_data values ('LOC000005','C000003','Level One Cat0005','1');
insert into level_one_category_data values ('LOC000006','C000003','Level One Cat0006','1');
insert into level_one_category_data values ('LOC000007','C000004','Level One Cat0007','1');
insert into level_one_category_data values ('LOC000008','C000004','Level One Cat0008','1');

	
insert into level_two_category_data values ('LTC000001','LOC000001','Level Two Cat','1');
insert into level_two_category_data values ('LTC000002','LOC000001','Level Two Cat0002','1');
insert into level_two_category_data values ('LTC000003','LOC000002','Level Two Cat0003','1');
insert into level_two_category_data values ('LTC000004','LOC000002','Level Two Cat0004','1');
insert into level_two_category_data values ('LTC000005','LOC000003','Level Two Cat0005','1');
insert into level_two_category_data values ('LTC000006','LOC000003','Level Two Cat0006','1');
insert into level_two_category_data values ('LTC000007','LOC000004','Level Two Cat0007','1');
insert into level_two_category_data values ('LTC000008','LOC000004','Level Two Cat0008','1');
insert into level_two_category_data values ('LTC000009','LOC000005','Level Two Cat0009','1');
insert into level_two_category_data values ('LTC000010','LOC000005','Level Two Cat0010','1');
insert into level_two_category_data values ('LTC000011','LOC000006','Level Two Cat0011','1');
insert into level_two_category_data values ('LTC000012','LOC000006','Level Two Cat0012','1');
insert into level_two_category_data values ('LTC000013','LOC000007','Level Two Cat0013','1');
insert into level_two_category_data values ('LTC000014','LOC000007','Level Two Cat0014','1');
insert into level_two_category_data values ('LTC000015','LOC000008','Level Two Cat0015','1');
insert into level_two_category_data values ('LTC000016','LOC000008','Level Two Cat0016','1');

	
insert into level_n_category_data values ('LNC000001','LTC000001','Level N Cat','1');
insert into level_n_category_data values ('LNC000002','LTC000001','Level N Cat0002','1');
insert into level_n_category_data values ('LNC000003','LTC000002','Level N Cat0003','1');
insert into level_n_category_data values ('LNC000004','LTC000002','Level N Cat0004','1');
insert into level_n_category_data values ('LNC000005','LTC000003','Level N Cat0005','1');
insert into level_n_category_data values ('LNC000006','LTC000003','Level N Cat0006','1');
insert into level_n_category_data values ('LNC000007','LTC000004','Level N Cat0007','1');
insert into level_n_category_data values ('LNC000008','LTC000004','Level N Cat0008','1');
insert into level_n_category_data values ('LNC000009','LTC000005','Level N Cat0009','1');
insert into level_n_category_data values ('LNC000010','LTC000005','Level N Cat0010','1');
insert into level_n_category_data values ('LNC000011','LTC000006','Level N Cat0011','1');
insert into level_n_category_data values ('LNC000012','LTC000006','Level N Cat0012','1');
insert into level_n_category_data values ('LNC000013','LTC000007','Level N Cat0013','1');
insert into level_n_category_data values ('LNC000014','LTC000007','Level N Cat0014','1');
insert into level_n_category_data values ('LNC000015','LTC000008','Level N Cat0015','1');
insert into level_n_category_data values ('LNC000016','LTC000008','Level N Cat0016','1');
insert into level_n_category_data values ('LNC000017','LTC000009','Level N Cat0017','1');
insert into level_n_category_data values ('LNC000018','LTC000009','Level N Cat0018','1');
insert into level_n_category_data values ('LNC000019','LTC000010','Level N Cat0019','1');
insert into level_n_category_data values ('LNC000020','LTC000010','Level N Cat0020','1');
insert into level_n_category_data values ('LNC000021','LTC000011','Level N Cat0021','1');
insert into level_n_category_data values ('LNC000022','LTC000011','Level N Cat0022','1');
insert into level_n_category_data values ('LNC000023','LTC000012','Level N Cat0023','1');
insert into level_n_category_data values ('LNC000024','LTC000012','Level N Cat0024','1');
insert into level_n_category_data values ('LNC000025','LTC000013','Level N Cat0025','1');
insert into level_n_category_data values ('LNC000026','LTC000013','Level N Cat0026','1');
insert into level_n_category_data values ('LNC000027','LTC000014','Level N Cat0027','1');
insert into level_n_category_data values ('LNC000028','LTC000014','Level N Cat0028','1');
insert into level_n_category_data values ('LNC000029','LTC000015','Level N Cat0029','1');
insert into level_n_category_data values ('LNC000030','LTC000015','Level N Cat0030','1');
insert into level_n_category_data values ('LNC000031','LTC000016','Level N Cat0031','1');
insert into level_n_category_data values ('LNC000032','LTC000016','Level N Cat0032','1');

	
insert into brand_data values ('B000001','Telsa Auto','https://demo.doublechaintech.com/demodata/imageManager/genImage/logo00/400/200/grey/','The brand a great that has Roadester, Model S and Model X, Model 3 is in development','1');

	
insert into product_data values ('P000001','Jeans','LNC000001','B000001','China','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development','lastUpdateTime()','1');
insert into product_data values ('P000002','Jeans0002','LNC000001','B000001','US','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0002','lastUpdateTime()0002','1');
insert into product_data values ('P000003','Jeans0003','LNC000002','B000001','Japan','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0003','lastUpdateTime()0003','1');
insert into product_data values ('P000004','Jeans0004','LNC000002','B000001','French','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0004','lastUpdateTime()0004','1');
insert into product_data values ('P000005','Jeans0005','LNC000003','B000001','China','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0005','lastUpdateTime()0005','1');
insert into product_data values ('P000006','Jeans0006','LNC000003','B000001','US','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0006','lastUpdateTime()0006','1');
insert into product_data values ('P000007','Jeans0007','LNC000004','B000001','Japan','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0007','lastUpdateTime()0007','1');
insert into product_data values ('P000008','Jeans0008','LNC000004','B000001','French','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0008','lastUpdateTime()0008','1');
insert into product_data values ('P000009','Jeans0009','LNC000005','B000001','China','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0009','lastUpdateTime()0009','1');
insert into product_data values ('P000010','Jeans0010','LNC000005','B000001','US','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0010','lastUpdateTime()0010','1');
insert into product_data values ('P000011','Jeans0011','LNC000006','B000001','Japan','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0011','lastUpdateTime()0011','1');
insert into product_data values ('P000012','Jeans0012','LNC000006','B000001','French','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0012','lastUpdateTime()0012','1');
insert into product_data values ('P000013','Jeans0013','LNC000007','B000001','China','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0013','lastUpdateTime()0013','1');
insert into product_data values ('P000014','Jeans0014','LNC000007','B000001','US','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0014','lastUpdateTime()0014','1');
insert into product_data values ('P000015','Jeans0015','LNC000008','B000001','Japan','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0015','lastUpdateTime()0015','1');
insert into product_data values ('P000016','Jeans0016','LNC000008','B000001','French','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0016','lastUpdateTime()0016','1');
insert into product_data values ('P000017','Jeans0017','LNC000009','B000001','China','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0017','lastUpdateTime()0017','1');
insert into product_data values ('P000018','Jeans0018','LNC000009','B000001','US','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0018','lastUpdateTime()0018','1');
insert into product_data values ('P000019','Jeans0019','LNC000010','B000001','Japan','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0019','lastUpdateTime()0019','1');
insert into product_data values ('P000020','Jeans0020','LNC000010','B000001','French','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0020','lastUpdateTime()0020','1');
insert into product_data values ('P000021','Jeans0021','LNC000011','B000001','China','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0021','lastUpdateTime()0021','1');
insert into product_data values ('P000022','Jeans0022','LNC000011','B000001','US','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0022','lastUpdateTime()0022','1');
insert into product_data values ('P000023','Jeans0023','LNC000012','B000001','Japan','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0023','lastUpdateTime()0023','1');
insert into product_data values ('P000024','Jeans0024','LNC000012','B000001','French','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0024','lastUpdateTime()0024','1');
insert into product_data values ('P000025','Jeans0025','LNC000013','B000001','China','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0025','lastUpdateTime()0025','1');
insert into product_data values ('P000026','Jeans0026','LNC000013','B000001','US','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0026','lastUpdateTime()0026','1');
insert into product_data values ('P000027','Jeans0027','LNC000014','B000001','Japan','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0027','lastUpdateTime()0027','1');
insert into product_data values ('P000028','Jeans0028','LNC000014','B000001','French','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0028','lastUpdateTime()0028','1');
insert into product_data values ('P000029','Jeans0029','LNC000015','B000001','China','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0029','lastUpdateTime()0029','1');
insert into product_data values ('P000030','Jeans0030','LNC000015','B000001','US','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0030','lastUpdateTime()0030','1');
insert into product_data values ('P000031','Jeans0031','LNC000016','B000001','Japan','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0031','lastUpdateTime()0031','1');
insert into product_data values ('P000032','Jeans0032','LNC000016','B000001','French','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0032','lastUpdateTime()0032','1');
insert into product_data values ('P000033','Jeans0033','LNC000017','B000001','China','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0033','lastUpdateTime()0033','1');
insert into product_data values ('P000034','Jeans0034','LNC000017','B000001','US','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0034','lastUpdateTime()0034','1');
insert into product_data values ('P000035','Jeans0035','LNC000018','B000001','Japan','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0035','lastUpdateTime()0035','1');
insert into product_data values ('P000036','Jeans0036','LNC000018','B000001','French','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0036','lastUpdateTime()0036','1');
insert into product_data values ('P000037','Jeans0037','LNC000019','B000001','China','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0037','lastUpdateTime()0037','1');
insert into product_data values ('P000038','Jeans0038','LNC000019','B000001','US','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0038','lastUpdateTime()0038','1');
insert into product_data values ('P000039','Jeans0039','LNC000020','B000001','Japan','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0039','lastUpdateTime()0039','1');
insert into product_data values ('P000040','Jeans0040','LNC000020','B000001','French','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0040','lastUpdateTime()0040','1');
insert into product_data values ('P000041','Jeans0041','LNC000021','B000001','China','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0041','lastUpdateTime()0041','1');
insert into product_data values ('P000042','Jeans0042','LNC000021','B000001','US','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0042','lastUpdateTime()0042','1');
insert into product_data values ('P000043','Jeans0043','LNC000022','B000001','Japan','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0043','lastUpdateTime()0043','1');
insert into product_data values ('P000044','Jeans0044','LNC000022','B000001','French','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0044','lastUpdateTime()0044','1');
insert into product_data values ('P000045','Jeans0045','LNC000023','B000001','China','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0045','lastUpdateTime()0045','1');
insert into product_data values ('P000046','Jeans0046','LNC000023','B000001','US','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0046','lastUpdateTime()0046','1');
insert into product_data values ('P000047','Jeans0047','LNC000024','B000001','Japan','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0047','lastUpdateTime()0047','1');
insert into product_data values ('P000048','Jeans0048','LNC000024','B000001','French','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0048','lastUpdateTime()0048','1');
insert into product_data values ('P000049','Jeans0049','LNC000025','B000001','China','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0049','lastUpdateTime()0049','1');
insert into product_data values ('P000050','Jeans0050','LNC000025','B000001','US','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0050','lastUpdateTime()0050','1');
insert into product_data values ('P000051','Jeans0051','LNC000026','B000001','Japan','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0051','lastUpdateTime()0051','1');
insert into product_data values ('P000052','Jeans0052','LNC000026','B000001','French','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0052','lastUpdateTime()0052','1');
insert into product_data values ('P000053','Jeans0053','LNC000027','B000001','China','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0053','lastUpdateTime()0053','1');
insert into product_data values ('P000054','Jeans0054','LNC000027','B000001','US','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0054','lastUpdateTime()0054','1');
insert into product_data values ('P000055','Jeans0055','LNC000028','B000001','Japan','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0055','lastUpdateTime()0055','1');
insert into product_data values ('P000056','Jeans0056','LNC000028','B000001','French','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0056','lastUpdateTime()0056','1');
insert into product_data values ('P000057','Jeans0057','LNC000029','B000001','China','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0057','lastUpdateTime()0057','1');
insert into product_data values ('P000058','Jeans0058','LNC000029','B000001','US','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0058','lastUpdateTime()0058','1');
insert into product_data values ('P000059','Jeans0059','LNC000030','B000001','Japan','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0059','lastUpdateTime()0059','1');
insert into product_data values ('P000060','Jeans0060','LNC000030','B000001','French','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0060','lastUpdateTime()0060','1');
insert into product_data values ('P000061','Jeans0061','LNC000031','B000001','China','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0061','lastUpdateTime()0061','1');
insert into product_data values ('P000062','Jeans0062','LNC000031','B000001','US','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0062','lastUpdateTime()0062','1');
insert into product_data values ('P000063','Jeans0063','LNC000032','B000001','Japan','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0063','lastUpdateTime()0063','1');
insert into product_data values ('P000064','Jeans0064','LNC000032','B000001','French','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0064','lastUpdateTime()0064','1');

	
insert into product_recommendation_data values ('PR000001','Jeans','B000001','China','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development','lastUpdateTime()','1');
insert into product_recommendation_data values ('PR000002','Jeans0002','B000001','US','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0002','lastUpdateTime()0002','1');
insert into product_recommendation_data values ('PR000003','Jeans0003','B000001','Japan','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0003','lastUpdateTime()0003','1');
insert into product_recommendation_data values ('PR000004','Jeans0004','B000001','French','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0004','lastUpdateTime()0004','1');
insert into product_recommendation_data values ('PR000005','Jeans0005','B000001','China','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0005','lastUpdateTime()0005','1');
insert into product_recommendation_data values ('PR000006','Jeans0006','B000001','US','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0006','lastUpdateTime()0006','1');
insert into product_recommendation_data values ('PR000007','Jeans0007','B000001','Japan','P000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0007','lastUpdateTime()0007','1');
insert into product_recommendation_data values ('PR000008','Jeans0008','B000001','French','P000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0008','lastUpdateTime()0008','1');
insert into product_recommendation_data values ('PR000009','Jeans0009','B000001','China','P000005','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0009','lastUpdateTime()0009','1');
insert into product_recommendation_data values ('PR000010','Jeans0010','B000001','US','P000005','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0010','lastUpdateTime()0010','1');
insert into product_recommendation_data values ('PR000011','Jeans0011','B000001','Japan','P000006','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0011','lastUpdateTime()0011','1');
insert into product_recommendation_data values ('PR000012','Jeans0012','B000001','French','P000006','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0012','lastUpdateTime()0012','1');
insert into product_recommendation_data values ('PR000013','Jeans0013','B000001','China','P000007','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0013','lastUpdateTime()0013','1');
insert into product_recommendation_data values ('PR000014','Jeans0014','B000001','US','P000007','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0014','lastUpdateTime()0014','1');
insert into product_recommendation_data values ('PR000015','Jeans0015','B000001','Japan','P000008','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0015','lastUpdateTime()0015','1');
insert into product_recommendation_data values ('PR000016','Jeans0016','B000001','French','P000008','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0016','lastUpdateTime()0016','1');
insert into product_recommendation_data values ('PR000017','Jeans0017','B000001','China','P000009','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0017','lastUpdateTime()0017','1');
insert into product_recommendation_data values ('PR000018','Jeans0018','B000001','US','P000009','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0018','lastUpdateTime()0018','1');
insert into product_recommendation_data values ('PR000019','Jeans0019','B000001','Japan','P000010','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0019','lastUpdateTime()0019','1');
insert into product_recommendation_data values ('PR000020','Jeans0020','B000001','French','P000010','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0020','lastUpdateTime()0020','1');
insert into product_recommendation_data values ('PR000021','Jeans0021','B000001','China','P000011','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0021','lastUpdateTime()0021','1');
insert into product_recommendation_data values ('PR000022','Jeans0022','B000001','US','P000011','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0022','lastUpdateTime()0022','1');
insert into product_recommendation_data values ('PR000023','Jeans0023','B000001','Japan','P000012','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0023','lastUpdateTime()0023','1');
insert into product_recommendation_data values ('PR000024','Jeans0024','B000001','French','P000012','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0024','lastUpdateTime()0024','1');
insert into product_recommendation_data values ('PR000025','Jeans0025','B000001','China','P000013','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0025','lastUpdateTime()0025','1');
insert into product_recommendation_data values ('PR000026','Jeans0026','B000001','US','P000013','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0026','lastUpdateTime()0026','1');
insert into product_recommendation_data values ('PR000027','Jeans0027','B000001','Japan','P000014','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0027','lastUpdateTime()0027','1');
insert into product_recommendation_data values ('PR000028','Jeans0028','B000001','French','P000014','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0028','lastUpdateTime()0028','1');
insert into product_recommendation_data values ('PR000029','Jeans0029','B000001','China','P000015','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0029','lastUpdateTime()0029','1');
insert into product_recommendation_data values ('PR000030','Jeans0030','B000001','US','P000015','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0030','lastUpdateTime()0030','1');
insert into product_recommendation_data values ('PR000031','Jeans0031','B000001','Japan','P000016','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0031','lastUpdateTime()0031','1');
insert into product_recommendation_data values ('PR000032','Jeans0032','B000001','French','P000016','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0032','lastUpdateTime()0032','1');
insert into product_recommendation_data values ('PR000033','Jeans0033','B000001','China','P000017','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0033','lastUpdateTime()0033','1');
insert into product_recommendation_data values ('PR000034','Jeans0034','B000001','US','P000017','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0034','lastUpdateTime()0034','1');
insert into product_recommendation_data values ('PR000035','Jeans0035','B000001','Japan','P000018','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0035','lastUpdateTime()0035','1');
insert into product_recommendation_data values ('PR000036','Jeans0036','B000001','French','P000018','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0036','lastUpdateTime()0036','1');
insert into product_recommendation_data values ('PR000037','Jeans0037','B000001','China','P000019','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0037','lastUpdateTime()0037','1');
insert into product_recommendation_data values ('PR000038','Jeans0038','B000001','US','P000019','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0038','lastUpdateTime()0038','1');
insert into product_recommendation_data values ('PR000039','Jeans0039','B000001','Japan','P000020','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0039','lastUpdateTime()0039','1');
insert into product_recommendation_data values ('PR000040','Jeans0040','B000001','French','P000020','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0040','lastUpdateTime()0040','1');
insert into product_recommendation_data values ('PR000041','Jeans0041','B000001','China','P000021','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0041','lastUpdateTime()0041','1');
insert into product_recommendation_data values ('PR000042','Jeans0042','B000001','US','P000021','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0042','lastUpdateTime()0042','1');
insert into product_recommendation_data values ('PR000043','Jeans0043','B000001','Japan','P000022','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0043','lastUpdateTime()0043','1');
insert into product_recommendation_data values ('PR000044','Jeans0044','B000001','French','P000022','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0044','lastUpdateTime()0044','1');
insert into product_recommendation_data values ('PR000045','Jeans0045','B000001','China','P000023','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0045','lastUpdateTime()0045','1');
insert into product_recommendation_data values ('PR000046','Jeans0046','B000001','US','P000023','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0046','lastUpdateTime()0046','1');
insert into product_recommendation_data values ('PR000047','Jeans0047','B000001','Japan','P000024','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0047','lastUpdateTime()0047','1');
insert into product_recommendation_data values ('PR000048','Jeans0048','B000001','French','P000024','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0048','lastUpdateTime()0048','1');
insert into product_recommendation_data values ('PR000049','Jeans0049','B000001','China','P000025','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0049','lastUpdateTime()0049','1');
insert into product_recommendation_data values ('PR000050','Jeans0050','B000001','US','P000025','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0050','lastUpdateTime()0050','1');
insert into product_recommendation_data values ('PR000051','Jeans0051','B000001','Japan','P000026','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0051','lastUpdateTime()0051','1');
insert into product_recommendation_data values ('PR000052','Jeans0052','B000001','French','P000026','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0052','lastUpdateTime()0052','1');
insert into product_recommendation_data values ('PR000053','Jeans0053','B000001','China','P000027','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0053','lastUpdateTime()0053','1');
insert into product_recommendation_data values ('PR000054','Jeans0054','B000001','US','P000027','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0054','lastUpdateTime()0054','1');
insert into product_recommendation_data values ('PR000055','Jeans0055','B000001','Japan','P000028','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0055','lastUpdateTime()0055','1');
insert into product_recommendation_data values ('PR000056','Jeans0056','B000001','French','P000028','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0056','lastUpdateTime()0056','1');
insert into product_recommendation_data values ('PR000057','Jeans0057','B000001','China','P000029','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0057','lastUpdateTime()0057','1');
insert into product_recommendation_data values ('PR000058','Jeans0058','B000001','US','P000029','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0058','lastUpdateTime()0058','1');
insert into product_recommendation_data values ('PR000059','Jeans0059','B000001','Japan','P000030','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0059','lastUpdateTime()0059','1');
insert into product_recommendation_data values ('PR000060','Jeans0060','B000001','French','P000030','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0060','lastUpdateTime()0060','1');
insert into product_recommendation_data values ('PR000061','Jeans0061','B000001','China','P000031','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0061','lastUpdateTime()0061','1');
insert into product_recommendation_data values ('PR000062','Jeans0062','B000001','US','P000031','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0062','lastUpdateTime()0062','1');
insert into product_recommendation_data values ('PR000063','Jeans0063','B000001','Japan','P000032','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0063','lastUpdateTime()0063','1');
insert into product_recommendation_data values ('PR000064','Jeans0064','B000001','French','P000032','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0064','lastUpdateTime()0064','1');
insert into product_recommendation_data values ('PR000065','Jeans0065','B000001','China','P000033','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0065','lastUpdateTime()0065','1');
insert into product_recommendation_data values ('PR000066','Jeans0066','B000001','US','P000033','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0066','lastUpdateTime()0066','1');
insert into product_recommendation_data values ('PR000067','Jeans0067','B000001','Japan','P000034','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0067','lastUpdateTime()0067','1');
insert into product_recommendation_data values ('PR000068','Jeans0068','B000001','French','P000034','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0068','lastUpdateTime()0068','1');
insert into product_recommendation_data values ('PR000069','Jeans0069','B000001','China','P000035','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0069','lastUpdateTime()0069','1');
insert into product_recommendation_data values ('PR000070','Jeans0070','B000001','US','P000035','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0070','lastUpdateTime()0070','1');
insert into product_recommendation_data values ('PR000071','Jeans0071','B000001','Japan','P000036','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0071','lastUpdateTime()0071','1');
insert into product_recommendation_data values ('PR000072','Jeans0072','B000001','French','P000036','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0072','lastUpdateTime()0072','1');
insert into product_recommendation_data values ('PR000073','Jeans0073','B000001','China','P000037','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0073','lastUpdateTime()0073','1');
insert into product_recommendation_data values ('PR000074','Jeans0074','B000001','US','P000037','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0074','lastUpdateTime()0074','1');
insert into product_recommendation_data values ('PR000075','Jeans0075','B000001','Japan','P000038','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0075','lastUpdateTime()0075','1');
insert into product_recommendation_data values ('PR000076','Jeans0076','B000001','French','P000038','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0076','lastUpdateTime()0076','1');
insert into product_recommendation_data values ('PR000077','Jeans0077','B000001','China','P000039','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0077','lastUpdateTime()0077','1');
insert into product_recommendation_data values ('PR000078','Jeans0078','B000001','US','P000039','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0078','lastUpdateTime()0078','1');
insert into product_recommendation_data values ('PR000079','Jeans0079','B000001','Japan','P000040','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0079','lastUpdateTime()0079','1');
insert into product_recommendation_data values ('PR000080','Jeans0080','B000001','French','P000040','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0080','lastUpdateTime()0080','1');
insert into product_recommendation_data values ('PR000081','Jeans0081','B000001','China','P000041','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0081','lastUpdateTime()0081','1');
insert into product_recommendation_data values ('PR000082','Jeans0082','B000001','US','P000041','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0082','lastUpdateTime()0082','1');
insert into product_recommendation_data values ('PR000083','Jeans0083','B000001','Japan','P000042','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0083','lastUpdateTime()0083','1');
insert into product_recommendation_data values ('PR000084','Jeans0084','B000001','French','P000042','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0084','lastUpdateTime()0084','1');
insert into product_recommendation_data values ('PR000085','Jeans0085','B000001','China','P000043','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0085','lastUpdateTime()0085','1');
insert into product_recommendation_data values ('PR000086','Jeans0086','B000001','US','P000043','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0086','lastUpdateTime()0086','1');
insert into product_recommendation_data values ('PR000087','Jeans0087','B000001','Japan','P000044','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0087','lastUpdateTime()0087','1');
insert into product_recommendation_data values ('PR000088','Jeans0088','B000001','French','P000044','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0088','lastUpdateTime()0088','1');
insert into product_recommendation_data values ('PR000089','Jeans0089','B000001','China','P000045','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0089','lastUpdateTime()0089','1');
insert into product_recommendation_data values ('PR000090','Jeans0090','B000001','US','P000045','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0090','lastUpdateTime()0090','1');
insert into product_recommendation_data values ('PR000091','Jeans0091','B000001','Japan','P000046','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0091','lastUpdateTime()0091','1');
insert into product_recommendation_data values ('PR000092','Jeans0092','B000001','French','P000046','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0092','lastUpdateTime()0092','1');
insert into product_recommendation_data values ('PR000093','Jeans0093','B000001','China','P000047','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0093','lastUpdateTime()0093','1');
insert into product_recommendation_data values ('PR000094','Jeans0094','B000001','US','P000047','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0094','lastUpdateTime()0094','1');
insert into product_recommendation_data values ('PR000095','Jeans0095','B000001','Japan','P000048','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0095','lastUpdateTime()0095','1');
insert into product_recommendation_data values ('PR000096','Jeans0096','B000001','French','P000048','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0096','lastUpdateTime()0096','1');
insert into product_recommendation_data values ('PR000097','Jeans0097','B000001','China','P000049','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0097','lastUpdateTime()0097','1');
insert into product_recommendation_data values ('PR000098','Jeans0098','B000001','US','P000049','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0098','lastUpdateTime()0098','1');
insert into product_recommendation_data values ('PR000099','Jeans0099','B000001','Japan','P000050','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0099','lastUpdateTime()0099','1');
insert into product_recommendation_data values ('PR000100','Jeans0100','B000001','French','P000050','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0100','lastUpdateTime()0100','1');
insert into product_recommendation_data values ('PR000101','Jeans0101','B000001','China','P000051','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0101','lastUpdateTime()0101','1');
insert into product_recommendation_data values ('PR000102','Jeans0102','B000001','US','P000051','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0102','lastUpdateTime()0102','1');
insert into product_recommendation_data values ('PR000103','Jeans0103','B000001','Japan','P000052','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0103','lastUpdateTime()0103','1');
insert into product_recommendation_data values ('PR000104','Jeans0104','B000001','French','P000052','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0104','lastUpdateTime()0104','1');
insert into product_recommendation_data values ('PR000105','Jeans0105','B000001','China','P000053','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0105','lastUpdateTime()0105','1');
insert into product_recommendation_data values ('PR000106','Jeans0106','B000001','US','P000053','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0106','lastUpdateTime()0106','1');
insert into product_recommendation_data values ('PR000107','Jeans0107','B000001','Japan','P000054','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0107','lastUpdateTime()0107','1');
insert into product_recommendation_data values ('PR000108','Jeans0108','B000001','French','P000054','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0108','lastUpdateTime()0108','1');
insert into product_recommendation_data values ('PR000109','Jeans0109','B000001','China','P000055','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0109','lastUpdateTime()0109','1');
insert into product_recommendation_data values ('PR000110','Jeans0110','B000001','US','P000055','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0110','lastUpdateTime()0110','1');
insert into product_recommendation_data values ('PR000111','Jeans0111','B000001','Japan','P000056','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0111','lastUpdateTime()0111','1');
insert into product_recommendation_data values ('PR000112','Jeans0112','B000001','French','P000056','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0112','lastUpdateTime()0112','1');
insert into product_recommendation_data values ('PR000113','Jeans0113','B000001','China','P000057','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0113','lastUpdateTime()0113','1');
insert into product_recommendation_data values ('PR000114','Jeans0114','B000001','US','P000057','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0114','lastUpdateTime()0114','1');
insert into product_recommendation_data values ('PR000115','Jeans0115','B000001','Japan','P000058','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0115','lastUpdateTime()0115','1');
insert into product_recommendation_data values ('PR000116','Jeans0116','B000001','French','P000058','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0116','lastUpdateTime()0116','1');
insert into product_recommendation_data values ('PR000117','Jeans0117','B000001','China','P000059','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0117','lastUpdateTime()0117','1');
insert into product_recommendation_data values ('PR000118','Jeans0118','B000001','US','P000059','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0118','lastUpdateTime()0118','1');
insert into product_recommendation_data values ('PR000119','Jeans0119','B000001','Japan','P000060','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0119','lastUpdateTime()0119','1');
insert into product_recommendation_data values ('PR000120','Jeans0120','B000001','French','P000060','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0120','lastUpdateTime()0120','1');
insert into product_recommendation_data values ('PR000121','Jeans0121','B000001','China','P000061','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0121','lastUpdateTime()0121','1');
insert into product_recommendation_data values ('PR000122','Jeans0122','B000001','US','P000061','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0122','lastUpdateTime()0122','1');
insert into product_recommendation_data values ('PR000123','Jeans0123','B000001','Japan','P000062','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0123','lastUpdateTime()0123','1');
insert into product_recommendation_data values ('PR000124','Jeans0124','B000001','French','P000062','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0124','lastUpdateTime()0124','1');
insert into product_recommendation_data values ('PR000125','Jeans0125','B000001','China','P000063','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0125','lastUpdateTime()0125','1');
insert into product_recommendation_data values ('PR000126','Jeans0126','B000001','US','P000063','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0126','lastUpdateTime()0126','1');
insert into product_recommendation_data values ('PR000127','Jeans0127','B000001','Japan','P000064','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0127','lastUpdateTime()0127','1');
insert into product_recommendation_data values ('PR000128','Jeans0128','B000001','French','P000064','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0128','lastUpdateTime()0128','1');

	
insert into sku_data values ('S000001','Jeans - Large','Large','P000001',1,'102.33','lastUpdateTime()','1');
insert into sku_data values ('S000002','Jeans - Large0002','Small','P000001',1,'101.18','lastUpdateTime()0002','1');
insert into sku_data values ('S000003','Jeans - Large0003','Medium','P000002',1,'82.54','lastUpdateTime()0003','1');
insert into sku_data values ('S000004','Jeans - Large0004','Large','P000002',1,'96.54','lastUpdateTime()0004','1');
insert into sku_data values ('S000005','Jeans - Large0005','Small','P000003',1,'87.35','lastUpdateTime()0005','1');
insert into sku_data values ('S000006','Jeans - Large0006','Medium','P000003',1,'101.97','lastUpdateTime()0006','1');
insert into sku_data values ('S000007','Jeans - Large0007','Large','P000004',1,'80.52','lastUpdateTime()0007','1');
insert into sku_data values ('S000008','Jeans - Large0008','Small','P000004',1,'99.73','lastUpdateTime()0008','1');
insert into sku_data values ('S000009','Jeans - Large0009','Medium','P000005',1,'94.35','lastUpdateTime()0009','1');
insert into sku_data values ('S000010','Jeans - Large0010','Large','P000005',1,'97.48','lastUpdateTime()0010','1');
insert into sku_data values ('S000011','Jeans - Large0011','Small','P000006',1,'91.54','lastUpdateTime()0011','1');
insert into sku_data values ('S000012','Jeans - Large0012','Medium','P000006',1,'82.81','lastUpdateTime()0012','1');
insert into sku_data values ('S000013','Jeans - Large0013','Large','P000007',1,'92.69','lastUpdateTime()0013','1');
insert into sku_data values ('S000014','Jeans - Large0014','Small','P000007',1,'99.75','lastUpdateTime()0014','1');
insert into sku_data values ('S000015','Jeans - Large0015','Medium','P000008',1,'82.61','lastUpdateTime()0015','1');
insert into sku_data values ('S000016','Jeans - Large0016','Large','P000008',1,'98.68','lastUpdateTime()0016','1');
insert into sku_data values ('S000017','Jeans - Large0017','Small','P000009',1,'96.11','lastUpdateTime()0017','1');
insert into sku_data values ('S000018','Jeans - Large0018','Medium','P000009',1,'80.16','lastUpdateTime()0018','1');
insert into sku_data values ('S000019','Jeans - Large0019','Large','P000010',1,'73.77','lastUpdateTime()0019','1');
insert into sku_data values ('S000020','Jeans - Large0020','Small','P000010',1,'73.68','lastUpdateTime()0020','1');
insert into sku_data values ('S000021','Jeans - Large0021','Medium','P000011',1,'89.57','lastUpdateTime()0021','1');
insert into sku_data values ('S000022','Jeans - Large0022','Large','P000011',1,'87.26','lastUpdateTime()0022','1');
insert into sku_data values ('S000023','Jeans - Large0023','Small','P000012',1,'90.06','lastUpdateTime()0023','1');
insert into sku_data values ('S000024','Jeans - Large0024','Medium','P000012',1,'77.10','lastUpdateTime()0024','1');
insert into sku_data values ('S000025','Jeans - Large0025','Large','P000013',1,'93.18','lastUpdateTime()0025','1');
insert into sku_data values ('S000026','Jeans - Large0026','Small','P000013',1,'89.92','lastUpdateTime()0026','1');
insert into sku_data values ('S000027','Jeans - Large0027','Medium','P000014',1,'81.95','lastUpdateTime()0027','1');
insert into sku_data values ('S000028','Jeans - Large0028','Large','P000014',1,'102.00','lastUpdateTime()0028','1');
insert into sku_data values ('S000029','Jeans - Large0029','Small','P000015',1,'75.97','lastUpdateTime()0029','1');
insert into sku_data values ('S000030','Jeans - Large0030','Medium','P000015',1,'95.37','lastUpdateTime()0030','1');
insert into sku_data values ('S000031','Jeans - Large0031','Large','P000016',1,'86.06','lastUpdateTime()0031','1');
insert into sku_data values ('S000032','Jeans - Large0032','Small','P000016',1,'83.05','lastUpdateTime()0032','1');
insert into sku_data values ('S000033','Jeans - Large0033','Medium','P000017',1,'81.67','lastUpdateTime()0033','1');
insert into sku_data values ('S000034','Jeans - Large0034','Large','P000017',1,'74.94','lastUpdateTime()0034','1');
insert into sku_data values ('S000035','Jeans - Large0035','Small','P000018',1,'94.70','lastUpdateTime()0035','1');
insert into sku_data values ('S000036','Jeans - Large0036','Medium','P000018',1,'75.31','lastUpdateTime()0036','1');
insert into sku_data values ('S000037','Jeans - Large0037','Large','P000019',1,'87.48','lastUpdateTime()0037','1');
insert into sku_data values ('S000038','Jeans - Large0038','Small','P000019',1,'90.09','lastUpdateTime()0038','1');
insert into sku_data values ('S000039','Jeans - Large0039','Medium','P000020',1,'73.50','lastUpdateTime()0039','1');
insert into sku_data values ('S000040','Jeans - Large0040','Large','P000020',1,'89.44','lastUpdateTime()0040','1');
insert into sku_data values ('S000041','Jeans - Large0041','Small','P000021',1,'97.78','lastUpdateTime()0041','1');
insert into sku_data values ('S000042','Jeans - Large0042','Medium','P000021',1,'93.28','lastUpdateTime()0042','1');
insert into sku_data values ('S000043','Jeans - Large0043','Large','P000022',1,'94.22','lastUpdateTime()0043','1');
insert into sku_data values ('S000044','Jeans - Large0044','Small','P000022',1,'78.75','lastUpdateTime()0044','1');
insert into sku_data values ('S000045','Jeans - Large0045','Medium','P000023',1,'92.54','lastUpdateTime()0045','1');
insert into sku_data values ('S000046','Jeans - Large0046','Large','P000023',1,'84.12','lastUpdateTime()0046','1');
insert into sku_data values ('S000047','Jeans - Large0047','Small','P000024',1,'86.61','lastUpdateTime()0047','1');
insert into sku_data values ('S000048','Jeans - Large0048','Medium','P000024',1,'89.33','lastUpdateTime()0048','1');
insert into sku_data values ('S000049','Jeans - Large0049','Large','P000025',1,'81.05','lastUpdateTime()0049','1');
insert into sku_data values ('S000050','Jeans - Large0050','Small','P000025',1,'79.75','lastUpdateTime()0050','1');
insert into sku_data values ('S000051','Jeans - Large0051','Medium','P000026',1,'88.74','lastUpdateTime()0051','1');
insert into sku_data values ('S000052','Jeans - Large0052','Large','P000026',1,'72.30','lastUpdateTime()0052','1');
insert into sku_data values ('S000053','Jeans - Large0053','Small','P000027',1,'84.01','lastUpdateTime()0053','1');
insert into sku_data values ('S000054','Jeans - Large0054','Medium','P000027',1,'74.35','lastUpdateTime()0054','1');
insert into sku_data values ('S000055','Jeans - Large0055','Large','P000028',1,'102.57','lastUpdateTime()0055','1');
insert into sku_data values ('S000056','Jeans - Large0056','Small','P000028',1,'82.40','lastUpdateTime()0056','1');
insert into sku_data values ('S000057','Jeans - Large0057','Medium','P000029',1,'85.76','lastUpdateTime()0057','1');
insert into sku_data values ('S000058','Jeans - Large0058','Large','P000029',1,'92.90','lastUpdateTime()0058','1');
insert into sku_data values ('S000059','Jeans - Large0059','Small','P000030',1,'88.63','lastUpdateTime()0059','1');
insert into sku_data values ('S000060','Jeans - Large0060','Medium','P000030',1,'89.95','lastUpdateTime()0060','1');
insert into sku_data values ('S000061','Jeans - Large0061','Large','P000031',1,'87.82','lastUpdateTime()0061','1');
insert into sku_data values ('S000062','Jeans - Large0062','Small','P000031',1,'82.24','lastUpdateTime()0062','1');
insert into sku_data values ('S000063','Jeans - Large0063','Medium','P000032',1,'90.32','lastUpdateTime()0063','1');
insert into sku_data values ('S000064','Jeans - Large0064','Large','P000032',1,'80.42','lastUpdateTime()0064','1');
insert into sku_data values ('S000065','Jeans - Large0065','Small','P000033',1,'77.04','lastUpdateTime()0065','1');
insert into sku_data values ('S000066','Jeans - Large0066','Medium','P000033',1,'92.40','lastUpdateTime()0066','1');
insert into sku_data values ('S000067','Jeans - Large0067','Large','P000034',1,'99.66','lastUpdateTime()0067','1');
insert into sku_data values ('S000068','Jeans - Large0068','Small','P000034',1,'89.45','lastUpdateTime()0068','1');
insert into sku_data values ('S000069','Jeans - Large0069','Medium','P000035',1,'80.45','lastUpdateTime()0069','1');
insert into sku_data values ('S000070','Jeans - Large0070','Large','P000035',1,'102.22','lastUpdateTime()0070','1');
insert into sku_data values ('S000071','Jeans - Large0071','Small','P000036',1,'85.87','lastUpdateTime()0071','1');
insert into sku_data values ('S000072','Jeans - Large0072','Medium','P000036',1,'97.42','lastUpdateTime()0072','1');
insert into sku_data values ('S000073','Jeans - Large0073','Large','P000037',1,'89.41','lastUpdateTime()0073','1');
insert into sku_data values ('S000074','Jeans - Large0074','Small','P000037',1,'85.00','lastUpdateTime()0074','1');
insert into sku_data values ('S000075','Jeans - Large0075','Medium','P000038',1,'95.82','lastUpdateTime()0075','1');
insert into sku_data values ('S000076','Jeans - Large0076','Large','P000038',1,'80.10','lastUpdateTime()0076','1');
insert into sku_data values ('S000077','Jeans - Large0077','Small','P000039',1,'77.59','lastUpdateTime()0077','1');
insert into sku_data values ('S000078','Jeans - Large0078','Medium','P000039',1,'95.59','lastUpdateTime()0078','1');
insert into sku_data values ('S000079','Jeans - Large0079','Large','P000040',1,'82.43','lastUpdateTime()0079','1');
insert into sku_data values ('S000080','Jeans - Large0080','Small','P000040',1,'82.38','lastUpdateTime()0080','1');
insert into sku_data values ('S000081','Jeans - Large0081','Medium','P000041',1,'92.75','lastUpdateTime()0081','1');
insert into sku_data values ('S000082','Jeans - Large0082','Large','P000041',1,'76.42','lastUpdateTime()0082','1');
insert into sku_data values ('S000083','Jeans - Large0083','Small','P000042',1,'81.58','lastUpdateTime()0083','1');
insert into sku_data values ('S000084','Jeans - Large0084','Medium','P000042',1,'95.44','lastUpdateTime()0084','1');
insert into sku_data values ('S000085','Jeans - Large0085','Large','P000043',1,'91.82','lastUpdateTime()0085','1');
insert into sku_data values ('S000086','Jeans - Large0086','Small','P000043',1,'98.30','lastUpdateTime()0086','1');
insert into sku_data values ('S000087','Jeans - Large0087','Medium','P000044',1,'73.44','lastUpdateTime()0087','1');
insert into sku_data values ('S000088','Jeans - Large0088','Large','P000044',1,'84.91','lastUpdateTime()0088','1');
insert into sku_data values ('S000089','Jeans - Large0089','Small','P000045',1,'80.02','lastUpdateTime()0089','1');
insert into sku_data values ('S000090','Jeans - Large0090','Medium','P000045',1,'94.57','lastUpdateTime()0090','1');
insert into sku_data values ('S000091','Jeans - Large0091','Large','P000046',1,'97.68','lastUpdateTime()0091','1');
insert into sku_data values ('S000092','Jeans - Large0092','Small','P000046',1,'96.34','lastUpdateTime()0092','1');
insert into sku_data values ('S000093','Jeans - Large0093','Medium','P000047',1,'82.22','lastUpdateTime()0093','1');
insert into sku_data values ('S000094','Jeans - Large0094','Large','P000047',1,'100.21','lastUpdateTime()0094','1');
insert into sku_data values ('S000095','Jeans - Large0095','Small','P000048',1,'83.47','lastUpdateTime()0095','1');
insert into sku_data values ('S000096','Jeans - Large0096','Medium','P000048',1,'100.96','lastUpdateTime()0096','1');
insert into sku_data values ('S000097','Jeans - Large0097','Large','P000049',1,'78.06','lastUpdateTime()0097','1');
insert into sku_data values ('S000098','Jeans - Large0098','Small','P000049',1,'77.40','lastUpdateTime()0098','1');
insert into sku_data values ('S000099','Jeans - Large0099','Medium','P000050',1,'79.05','lastUpdateTime()0099','1');
insert into sku_data values ('S000100','Jeans - Large0100','Large','P000050',1,'99.07','lastUpdateTime()0100','1');
insert into sku_data values ('S000101','Jeans - Large0101','Small','P000051',1,'73.56','lastUpdateTime()0101','1');
insert into sku_data values ('S000102','Jeans - Large0102','Medium','P000051',1,'89.18','lastUpdateTime()0102','1');
insert into sku_data values ('S000103','Jeans - Large0103','Large','P000052',1,'75.96','lastUpdateTime()0103','1');
insert into sku_data values ('S000104','Jeans - Large0104','Small','P000052',1,'90.46','lastUpdateTime()0104','1');
insert into sku_data values ('S000105','Jeans - Large0105','Medium','P000053',1,'84.76','lastUpdateTime()0105','1');
insert into sku_data values ('S000106','Jeans - Large0106','Large','P000053',1,'92.15','lastUpdateTime()0106','1');
insert into sku_data values ('S000107','Jeans - Large0107','Small','P000054',1,'84.69','lastUpdateTime()0107','1');
insert into sku_data values ('S000108','Jeans - Large0108','Medium','P000054',1,'102.86','lastUpdateTime()0108','1');
insert into sku_data values ('S000109','Jeans - Large0109','Large','P000055',1,'88.37','lastUpdateTime()0109','1');
insert into sku_data values ('S000110','Jeans - Large0110','Small','P000055',1,'88.08','lastUpdateTime()0110','1');
insert into sku_data values ('S000111','Jeans - Large0111','Medium','P000056',1,'83.76','lastUpdateTime()0111','1');
insert into sku_data values ('S000112','Jeans - Large0112','Large','P000056',1,'93.59','lastUpdateTime()0112','1');
insert into sku_data values ('S000113','Jeans - Large0113','Small','P000057',1,'82.84','lastUpdateTime()0113','1');
insert into sku_data values ('S000114','Jeans - Large0114','Medium','P000057',1,'75.54','lastUpdateTime()0114','1');
insert into sku_data values ('S000115','Jeans - Large0115','Large','P000058',1,'80.39','lastUpdateTime()0115','1');
insert into sku_data values ('S000116','Jeans - Large0116','Small','P000058',1,'96.05','lastUpdateTime()0116','1');
insert into sku_data values ('S000117','Jeans - Large0117','Medium','P000059',1,'84.64','lastUpdateTime()0117','1');
insert into sku_data values ('S000118','Jeans - Large0118','Large','P000059',1,'97.94','lastUpdateTime()0118','1');
insert into sku_data values ('S000119','Jeans - Large0119','Small','P000060',1,'95.27','lastUpdateTime()0119','1');
insert into sku_data values ('S000120','Jeans - Large0120','Medium','P000060',1,'86.26','lastUpdateTime()0120','1');
insert into sku_data values ('S000121','Jeans - Large0121','Large','P000061',1,'87.25','lastUpdateTime()0121','1');
insert into sku_data values ('S000122','Jeans - Large0122','Small','P000061',1,'72.47','lastUpdateTime()0122','1');
insert into sku_data values ('S000123','Jeans - Large0123','Medium','P000062',1,'88.41','lastUpdateTime()0123','1');
insert into sku_data values ('S000124','Jeans - Large0124','Large','P000062',1,'102.49','lastUpdateTime()0124','1');
insert into sku_data values ('S000125','Jeans - Large0125','Small','P000063',1,'84.60','lastUpdateTime()0125','1');
insert into sku_data values ('S000126','Jeans - Large0126','Medium','P000063',1,'100.64','lastUpdateTime()0126','1');
insert into sku_data values ('S000127','Jeans - Large0127','Large','P000064',1,'88.63','lastUpdateTime()0127','1');
insert into sku_data values ('S000128','Jeans - Large0128','Small','P000064',1,'74.33','lastUpdateTime()0128','1');

	
insert into profile_data values ('P000001','Philip Zhang','32','male','lastUpdateTime()','P000001','1');
insert into profile_data values ('P000002','Naveen Kumar R ','34','female','lastUpdateTime()0002','P000001','1');
insert into profile_data values ('P000003','VENKATESH GADUPUTI','34','male','lastUpdateTime()0003','P000001','1');

	
insert into shipping_address_data values ('SA000001','Home','1900 AVE OF THE STARTS - ','Suite 555 - ','Century City - ','CA','932887','1');
insert into shipping_address_data values ('SA000002','Office','1900 AVE OF THE STARTS - 0002','Suite 555 - 0002','Century City - 0002','VA','792076','1');

	
insert into payment_method_data values ('PM000001','Credit Card','4100987733939','1900 AVE OF THE STARTS','Suite 555 ','Century City','2018-05-02','1');
insert into payment_method_data values ('PM000002','GiftCard','4100987733939','1900 AVE OF THE STARTS0002','Suite 555 0002','Century City0002','2016-03-03','1');

	
insert into user_order_data values ('UO000001','a consumer order','80.02','9586.72','P000001','P000001','lastUpdateTime()','1');
insert into user_order_data values ('UO000002','a consumer order0002','91.05','7852.52','P000001','P000001','lastUpdateTime()0002','1');
insert into user_order_data values ('UO000003','a consumer order0003','82.80','9075.10','P000002','P000001','lastUpdateTime()0003','1');
insert into user_order_data values ('UO000004','a consumer order0004','77.45','7090.09','P000003','P000001','lastUpdateTime()0004','1');

	
insert into line_item_data values ('LI000001','Jeans - Large','11','88.19','9.02','UO000001','1');
insert into line_item_data values ('LI000002','Jeans - Large0002','12','75.18','8.94','UO000001','1');
insert into line_item_data values ('LI000003','Jeans - Large0003','9','75.31','10.76','UO000002','1');
insert into line_item_data values ('LI000004','Jeans - Large0004','9','76.87','10.35','UO000002','1');
insert into line_item_data values ('LI000005','Jeans - Large0005','12','91.54','8.39','UO000003','1');
insert into line_item_data values ('LI000006','Jeans - Large0006','10','72.63','10.77','UO000003','1');
insert into line_item_data values ('LI000007','Jeans - Large0007','12','79.11','11.00','UO000004','1');
insert into line_item_data values ('LI000008','Jeans - Large0008','12','81.43','10.82','UO000004','1');

	
insert into order_promotion_data values ('OP000001','Promo For Total','1035','1142','PERCENT_OFF','UO000001','1');
insert into order_promotion_data values ('OP000002','Promo For Total0002','1085','1183','FIX_PRICE','UO000001','1');
insert into order_promotion_data values ('OP000003','Promo For Total0003','994','976','PERCENT_OFF','UO000002','1');
insert into order_promotion_data values ('OP000004','Promo For Total0004','1220','1087','FIX_PRICE','UO000002','1');
insert into order_promotion_data values ('OP000005','Promo For Total0005','953','1130','PERCENT_OFF','UO000003','1');
insert into order_promotion_data values ('OP000006','Promo For Total0006','1228','877','FIX_PRICE','UO000003','1');
insert into order_promotion_data values ('OP000007','Promo For Total0007','983','1228','PERCENT_OFF','UO000004','1');
insert into order_promotion_data values ('OP000008','Promo For Total0008','1136','950','FIX_PRICE','UO000004','1');

	
insert into manual_adjustment_data values ('MA000001','Promo For Total','1049','986','OFF','UO000001','1');
insert into manual_adjustment_data values ('MA000002','Promo For Total0002','1056','1166','FIX_PRICE','UO000001','1');
insert into manual_adjustment_data values ('MA000003','Promo For Total0003','899','985','OFF','UO000002','1');
insert into manual_adjustment_data values ('MA000004','Promo For Total0004','1129','870','FIX_PRICE','UO000002','1');
insert into manual_adjustment_data values ('MA000005','Promo For Total0005','950','1142','OFF','UO000003','1');
insert into manual_adjustment_data values ('MA000006','Promo For Total0006','945','1051','FIX_PRICE','UO000003','1');
insert into manual_adjustment_data values ('MA000007','Promo For Total0007','1199','1142','OFF','UO000004','1');
insert into manual_adjustment_data values ('MA000008','Promo For Total0008','1017','960','FIX_PRICE','UO000004','1');

	
insert into shipping_group_data values ('SG000001','Ship To Home','1900 AVE OF THE STARTS - ','Suite 555 - ','Century City - ','CA','866348','US','UO000001','1');
insert into shipping_group_data values ('SG000002','Ship To Home0002','1900 AVE OF THE STARTS - 0002','Suite 555 - 0002','Century City - 0002','VA','824673','US','UO000001','1');
insert into shipping_group_data values ('SG000003','Ship To Home0003','1900 AVE OF THE STARTS - 0003','Suite 555 - 0003','Century City - 0003','MA','932856','US','UO000002','1');
insert into shipping_group_data values ('SG000004','Ship To Home0004','1900 AVE OF THE STARTS - 0004','Suite 555 - 0004','Century City - 0004','PA','699693','US','UO000002','1');
insert into shipping_group_data values ('SG000005','Ship To Home0005','1900 AVE OF THE STARTS - 0005','Suite 555 - 0005','Century City - 0005','WA','812301','US','UO000003','1');
insert into shipping_group_data values ('SG000006','Ship To Home0006','1900 AVE OF THE STARTS - 0006','Suite 555 - 0006','Century City - 0006','LA','810447','US','UO000003','1');
insert into shipping_group_data values ('SG000007','Ship To Home0007','1900 AVE OF THE STARTS - 0007','Suite 555 - 0007','Century City - 0007','CA','751396','US','UO000004','1');
insert into shipping_group_data values ('SG000008','Ship To Home0008','1900 AVE OF THE STARTS - 0008','Suite 555 - 0008','Century City - 0008','VA','979678','US','UO000004','1');

	
insert into payment_group_data values ('PG000001','Pay for order','111.10','UO000001','PAID','1');
insert into payment_group_data values ('PG000002','Pay for order0002','91.33','UO000001','PENDING','1');
insert into payment_group_data values ('PG000003','Pay for order0003','89.20','UO000002','FAIL','1');
insert into payment_group_data values ('PG000004','Pay for order0004','88.10','UO000002','PAID','1');
insert into payment_group_data values ('PG000005','Pay for order0005','97.95','UO000003','PENDING','1');
insert into payment_group_data values ('PG000006','Pay for order0006','101.35','UO000003','FAIL','1');
insert into payment_group_data values ('PG000007','Pay for order0007','114.08','UO000004','PAID','1');
insert into payment_group_data values ('PG000008','Pay for order0008','93.97','UO000004','PENDING','1');

	
insert into user_domain_data values ('UD000001','用户区域','1');

	
insert into user_white_list_data values ('UWL000001','clariones','tester;ios-spokesperson','UD000001','1');
insert into user_white_list_data values ('UWL000002','13808188512','tester;ios-spokesperson0002','UD000001','1');

	
insert into sec_user_data values ('SU000001','login','13900000001','','C183EC89F92A462CF45B95504792EC4625E847C90536EEFE512D1C9DB8602E95','0','2019-02-06 13:47:40','2019-02-14 03:05:49','UD000001',NULL,'BLOCKED','1');
insert into sec_user_data values ('SU000002','login0002','13900000002','suddy_chang@163.com','AC2F95628244C6975EB2C36942EA879ED93D93F5895EF3157733E4629FA86B92','9999999','2019-02-15 03:13:41','2019-02-06 09:02:23','UD000001',NULL,'BLOCKED0002','1');

	
insert into sec_user_blocking_data values ('SUB000001','currentUser()','2019-02-06 00:00:52','这个用户多次发送违反社区的帖子，现在把他给屏蔽了','1');

	
insert into user_app_data values ('UA000001','审车平台','SU000001','users',1,'MXWR','CarInspectionPlatform','CIP000001','/link/to/app','1');
insert into user_app_data values ('UA000002','账户管理','SU000001','bank',1,'MXWR','UserDomain','UD000001','/link/to/app0002','1');
insert into user_app_data values ('UA000003','接车公司','SU000001','wechat',1,'MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0003','1');
insert into user_app_data values ('UA000004','审车公司','SU000002','bar-chart',1,'MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0004','1');
insert into user_app_data values ('UA000005','维修公司','SU000002','user',1,'MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0005','1');
insert into user_app_data values ('UA000006','顾客','SU000002','users',1,'MXWR','CustomerInfo','CI000001','/link/to/app0006','1');

	
insert into list_access_data values ('LA000001','列表','levelOneCategoryList',1,1,1,1,1,'UA000001','1');
insert into list_access_data values ('LA000002','列表0002','levelOneCategoryList0002',1,1,1,1,1,'UA000001','1');
insert into list_access_data values ('LA000003','列表0003','levelOneCategoryList0003',1,1,1,1,1,'UA000002','1');
insert into list_access_data values ('LA000004','列表0004','levelOneCategoryList0004',1,1,1,1,1,'UA000003','1');
insert into list_access_data values ('LA000005','列表0005','levelOneCategoryList0005',1,1,1,1,1,'UA000004','1');
insert into list_access_data values ('LA000006','列表0006','levelOneCategoryList0006',1,1,1,1,1,'UA000004','1');
insert into list_access_data values ('LA000007','列表0007','levelOneCategoryList0007',1,1,1,1,1,'UA000005','1');
insert into list_access_data values ('LA000008','列表0008','levelOneCategoryList0008',1,1,1,1,1,'UA000006','1');

	
insert into object_access_data values ('OA000001','控制访问列表1','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000001','1');
insert into object_access_data values ('OA000002','控制访问列表10002','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000001','1');
insert into object_access_data values ('OA000003','控制访问列表10003','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000002','1');
insert into object_access_data values ('OA000004','控制访问列表10004','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000003','1');
insert into object_access_data values ('OA000005','控制访问列表10005','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000004','1');
insert into object_access_data values ('OA000006','控制访问列表10006','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000004','1');
insert into object_access_data values ('OA000007','控制访问列表10007','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000005','1');
insert into object_access_data values ('OA000008','控制访问列表10008','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000006','1');

	
insert into login_history_data values ('LH000001','2019-02-14 10:13:50','192.168.1.1','登陆成功','SU000001','1');
insert into login_history_data values ('LH000002','2019-02-21 12:58:08','192.168.1.2','登陆成功0002','SU000001','1');
insert into login_history_data values ('LH000003','2019-02-13 03:00:26','192.168.1.1','登陆成功0003','SU000002','1');
insert into login_history_data values ('LH000004','2019-02-09 21:51:35','192.168.1.2','登陆成功0004','SU000002','1');

	
insert into generic_form_data values ('GF000001','登记输入单','姓名就是你身份证上的名字','1');

	
insert into form_message_data values ('FM000001','字段组合错误','GF000001','success','1');
insert into form_message_data values ('FM000002','字段组合错误0002','GF000001','info','1');

	
insert into form_field_message_data values ('FFM000001','输入错误','name','GF000001','success','1');
insert into form_field_message_data values ('FFM000002','输入错误0002','name0002','GF000001','info','1');

	
insert into form_field_data values ('FF000001','姓名','name','name','text','GF000001','姓名就是你身份证上的名字','李一一','姓名就是你身份证上的名字','基础信息','maybe any value','a value expression',true,true,0,'','','1');
insert into form_field_data values ('FF000002','年龄','age','name0002','longtext','GF000001','姓名就是你身份证上的名字0002','李一一0002','姓名就是你身份证上的名字0002','扩展信息','maybe any value0002','a value expression0002',false,false,0,'','','1');
insert into form_field_data values ('FF000003','出生地','birth_place','name0003','date','GF000001','姓名就是你身份证上的名字0003','李一一0003','姓名就是你身份证上的名字0003','基础信息','maybe any value0003','a value expression0003',true,true,0,'','','1');
insert into form_field_data values ('FF000004','国籍','country','name0004','date_time','GF000001','姓名就是你身份证上的名字0004','李一一0004','姓名就是你身份证上的名字0004','扩展信息','maybe any value0004','a value expression0004',false,false,0,'男,女','男,女','1');

	
insert into form_action_data values ('FA000001','功能','name','save','default','genericFormManager/name/name0002/name0003/','GF000001','1');
insert into form_action_data values ('FA000002','功能0002','name0002','update','warning','genericFormManager/name/name0002/name0003/0002','GF000001','1');

/*
Mysql innodb's foreign key has index automatically

*/

create unique index idx_platform_version on platform_data(id, version);

create unique index idx_site_version on site_data(id, version);

alter table site_data add constraint site4platform_fk
	foreign key(platform) references platform_data(id) on delete cascade on update cascade;
create unique index idx_catalog_version on catalog_data(id, version);

alter table catalog_data add constraint catalog4site_fk
	foreign key(site) references site_data(id) on delete cascade on update cascade;
create unique index idx_level_one_category_version on level_one_category_data(id, version);

alter table level_one_category_data add constraint level_one_category4catalog_fk
	foreign key(catalog) references catalog_data(id) on delete cascade on update cascade;
create unique index idx_level_two_category_version on level_two_category_data(id, version);

alter table level_two_category_data add constraint level_two_category4parent_category_fk
	foreign key(parent_category) references level_one_category_data(id) on delete cascade on update cascade;
create unique index idx_level_n_category_version on level_n_category_data(id, version);

alter table level_n_category_data add constraint level_n_category4parent_category_fk
	foreign key(parent_category) references level_two_category_data(id) on delete cascade on update cascade;
create unique index idx_brand_version on brand_data(id, version);

create unique index idx_product_version on product_data(id, version);

alter table product_data add constraint product4parent_category_fk
	foreign key(parent_category) references level_n_category_data(id) on delete cascade on update cascade;
alter table product_data add constraint product4brand_fk
	foreign key(brand) references brand_data(id) on delete cascade on update cascade;
alter table product_data add constraint product4catalog_fk
	foreign key(catalog) references catalog_data(id) on delete cascade on update cascade;
create unique index idx_product_recommendation_version on product_recommendation_data(id, version);

alter table product_recommendation_data add constraint product_recommendation4brand_fk
	foreign key(brand) references brand_data(id) on delete cascade on update cascade;
alter table product_recommendation_data add constraint product_recommendation4product_fk
	foreign key(product) references product_data(id) on delete cascade on update cascade;
create unique index idx_sku_version on sku_data(id, version);

alter table sku_data add constraint sku4product_fk
	foreign key(product) references product_data(id) on delete cascade on update cascade;
create unique index idx_profile_version on profile_data(id, version);

alter table profile_data add constraint profile4platform_fk
	foreign key(platform) references platform_data(id) on delete cascade on update cascade;
create unique index idx_shipping_address_version on shipping_address_data(id, version);

create unique index idx_payment_method_version on payment_method_data(id, version);

create unique index idx_user_order_version on user_order_data(id, version);

alter table user_order_data add constraint user_order4user_fk
	foreign key(user) references profile_data(id) on delete cascade on update cascade;
alter table user_order_data add constraint user_order4platform_fk
	foreign key(platform) references platform_data(id) on delete cascade on update cascade;
create unique index idx_line_item_version on line_item_data(id, version);

alter table line_item_data add constraint line_item4user_order_fk
	foreign key(user_order) references user_order_data(id) on delete cascade on update cascade;
create unique index idx_order_promotion_version on order_promotion_data(id, version);

alter table order_promotion_data add constraint order_promotion4user_order_fk
	foreign key(user_order) references user_order_data(id) on delete cascade on update cascade;
create unique index idx_manual_adjustment_version on manual_adjustment_data(id, version);

alter table manual_adjustment_data add constraint manual_adjustment4user_order_fk
	foreign key(user_order) references user_order_data(id) on delete cascade on update cascade;
create unique index idx_shipping_group_version on shipping_group_data(id, version);

alter table shipping_group_data add constraint shipping_group4user_order_fk
	foreign key(user_order) references user_order_data(id) on delete cascade on update cascade;
create unique index idx_payment_group_version on payment_group_data(id, version);

alter table payment_group_data add constraint payment_group4user_order_fk
	foreign key(user_order) references user_order_data(id) on delete cascade on update cascade;
create unique index idx_user_domain_version on user_domain_data(id, version);

create unique index idx_user_white_list_version on user_white_list_data(id, version);

alter table user_white_list_data add constraint user_white_list4domain_fk
	foreign key(domain) references user_domain_data(id) on delete cascade on update cascade;
create unique index idx_sec_user_version on sec_user_data(id, version);

alter table sec_user_data add constraint sec_user4domain_fk
	foreign key(domain) references user_domain_data(id) on delete cascade on update cascade;
alter table sec_user_data add constraint sec_user4blocking_fk
	foreign key(blocking) references sec_user_blocking_data(id) on delete cascade on update cascade;
create unique index idx_sec_user_blocking_version on sec_user_blocking_data(id, version);

create unique index idx_user_app_version on user_app_data(id, version);

alter table user_app_data add constraint user_app4sec_user_fk
	foreign key(sec_user) references sec_user_data(id) on delete cascade on update cascade;
create unique index idx_list_access_version on list_access_data(id, version);

alter table list_access_data add constraint list_access4app_fk
	foreign key(app) references user_app_data(id) on delete cascade on update cascade;
create unique index idx_object_access_version on object_access_data(id, version);

alter table object_access_data add constraint object_access4app_fk
	foreign key(app) references user_app_data(id) on delete cascade on update cascade;
create unique index idx_login_history_version on login_history_data(id, version);

alter table login_history_data add constraint login_history4sec_user_fk
	foreign key(sec_user) references sec_user_data(id) on delete cascade on update cascade;
create unique index idx_generic_form_version on generic_form_data(id, version);

create unique index idx_form_message_version on form_message_data(id, version);

alter table form_message_data add constraint form_message4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
create unique index idx_form_field_message_version on form_field_message_data(id, version);

alter table form_field_message_data add constraint form_field_message4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
create unique index idx_form_field_version on form_field_data(id, version);

alter table form_field_data add constraint form_field4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
create unique index idx_form_action_version on form_action_data(id, version);

alter table form_action_data add constraint form_action4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
-- create extra index for time, number and mobile phone

create index platform4version_idx on platform_data(version);
create index site4version_idx on site_data(version);
create index catalog4seller_id_idx on catalog_data(seller_id);
create index catalog4version_idx on catalog_data(version);
create index level_one_category4version_idx on level_one_category_data(version);
create index level_two_category4version_idx on level_two_category_data(version);
create index level_n_category4version_idx on level_n_category_data(version);
create index brand4version_idx on brand_data(version);
create index product4version_idx on product_data(version);
create index product_recommendation4version_idx on product_recommendation_data(version);
create index sku4base_price_idx on sku_data(base_price);
create index sku4version_idx on sku_data(version);
create index profile4age_idx on profile_data(age);
create index profile4version_idx on profile_data(version);
create index shipping_address4zip_code_idx on shipping_address_data(zip_code);
create index shipping_address4version_idx on shipping_address_data(version);
create index payment_method4expire_on_idx on payment_method_data(expire_on);
create index payment_method4version_idx on payment_method_data(version);
create index user_order4total_adjustment_idx on user_order_data(total_adjustment);
create index user_order4total_amount_idx on user_order_data(total_amount);
create index user_order4version_idx on user_order_data(version);
create index line_item4quantity_idx on line_item_data(quantity);
create index line_item4price_idx on line_item_data(price);
create index line_item4discount_price_idx on line_item_data(discount_price);
create index line_item4version_idx on line_item_data(version);
create index order_promotion4amount_idx on order_promotion_data(amount);
create index order_promotion4thread_hold_idx on order_promotion_data(thread_hold);
create index order_promotion4version_idx on order_promotion_data(version);
create index manual_adjustment4amount_idx on manual_adjustment_data(amount);
create index manual_adjustment4thread_hold_idx on manual_adjustment_data(thread_hold);
create index manual_adjustment4version_idx on manual_adjustment_data(version);
create index shipping_group4zip_code_idx on shipping_group_data(zip_code);
create index shipping_group4version_idx on shipping_group_data(version);
create index payment_group4amount_idx on payment_group_data(amount);
create index payment_group4version_idx on payment_group_data(version);
create index user_domain4version_idx on user_domain_data(version);
create index user_white_list4version_idx on user_white_list_data(version);
create index sec_user4mobile_idx on sec_user_data(mobile);
create index sec_user4verification_code_idx on sec_user_data(verification_code);
create index sec_user4verification_code_expire_idx on sec_user_data(verification_code_expire);
create index sec_user4last_login_time_idx on sec_user_data(last_login_time);
create index sec_user4version_idx on sec_user_data(version);
create index sec_user_blocking4block_time_idx on sec_user_blocking_data(block_time);
create index sec_user_blocking4version_idx on sec_user_blocking_data(version);
create index user_app4object_id_idx on user_app_data(object_id);
create index user_app4version_idx on user_app_data(version);
create index list_access4version_idx on list_access_data(version);
create index object_access4version_idx on object_access_data(version);
create index login_history4login_time_idx on login_history_data(login_time);
create index login_history4version_idx on login_history_data(version);
create index generic_form4version_idx on generic_form_data(version);
create index form_message4version_idx on form_message_data(version);
create index form_field_message4version_idx on form_field_message_data(version);
create index form_field4version_idx on form_field_data(version);
create index form_action4version_idx on form_action_data(version);










delete from sec_user_data;
delete from user_app_data;

/*
+--------------------------+-------------+------+-----+---------+-------+
| Field                    | Type        | Null | Key | Default | Extra |
+--------------------------+-------------+------+-----+---------+-------+
| id                       | varchar(64) | NO   | PRI | NULL    |       |
| login                    | varchar(20) | YES  |     | NULL    |       |
| mobile                   | varchar(11) | YES  | MUL | NULL    |       |
| email                    | varchar(76) | YES  |     | NULL    |       |
| pwd                      | varchar(64) | YES  |     | NULL    |       |
| verification_code        | int(11)     | YES  | MUL | NULL    |       |
| verification_code_expire | datetime    | YES  | MUL | NULL    |       |
| last_login_time          | datetime    | YES  | MUL | NULL    |       |
| domain                   | varchar(48) | YES  | MUL | NULL    |       |
| blocking                 | varchar(48) | YES  | MUL | NULL    |       |
| current_status           | varchar(28) | YES  |     | NULL    |       |
| version                  | int(11)     | YES  | MUL | NULL    |       |
+--------------------------+-------------+------+-----+---------+-------+


*/

insert into sec_user_data values('SU000001','User000001','13900000001','1000001@qq.com','258D9BB89BBC1F2A6CDDD3A4CB300E6CD9B83F3FC9984619DF1A59F6051F1F44','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000001','Platform','SU000001','at',1,'MXWR','Platform','P000001','/link/to/app','1'); -- REFER COUNT: 3
insert into user_app_data values('UA000002','My Account','SU000001','lock',1,'MXWR','SecUser','SU000001','/link/to/app','1'); -- REFER COUNT: 3
insert into sec_user_data values('SU000002','User000002','13900000002','1000002@qq.com','7FEABCC19D638787655F9FFC2C22755D5771184D85D000147D643D22F6617F7B','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000003','Brand','SU000002','address-card',1,'MXWR','Brand','B000001','/link/to/app','1'); -- REFER COUNT: 2
insert into user_app_data values('UA000004','My Account','SU000002','lock',1,'MXWR','SecUser','SU000002','/link/to/app','1'); -- REFER COUNT: 2
insert into sec_user_data values('SU000003','User000003','13900000003','1000003@qq.com','8169C17063461B0B0CC210CE5EF682E9517A19170F7DCA3C76170229D765DE7A','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000005','Shipping Address','SU000003','ad',1,'MXWR','ShippingAddress','SA000001','/link/to/app','1'); -- REFER COUNT: 0
insert into user_app_data values('UA000006','My Account','SU000003','lock',1,'MXWR','SecUser','SU000003','/link/to/app','1'); -- REFER COUNT: 0
insert into sec_user_data values('SU000004','User000004','13900000004','1000004@qq.com','025745F4A4EA0C11059911E40714470F323C42836B1137D66AD3F85210A725CF','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000007','Payment Method','SU000004','th',1,'MXWR','PaymentMethod','PM000001','/link/to/app','1'); -- REFER COUNT: 0
insert into user_app_data values('UA000008','My Account','SU000004','lock',1,'MXWR','SecUser','SU000004','/link/to/app','1'); -- REFER COUNT: 0
insert into sec_user_data values('SU000005','User000005','13900000005','1000005@qq.com','F8D472FBE8716BFB66C0A9BC73208FE4C5971051D240D9AC3B5EBCEF05CD5FFA','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000009','User Order','SU000005','user',1,'MXWR','UserOrder','UO000001','/link/to/app','1'); -- REFER COUNT: 5
insert into user_app_data values('UA000010','My Account','SU000005','lock',1,'MXWR','SecUser','SU000005','/link/to/app','1'); -- REFER COUNT: 5
insert into sec_user_data values('SU000006','User000006','13900000006','1000006@qq.com','FEE10F101DD4B9D2C98FAA1A672821DF22B9FA662528ED5B885B60C0979E6530','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000011','User Domain','SU000006','user',1,'MXWR','UserDomain','UD000001','/link/to/app','1'); -- REFER COUNT: 2
insert into user_app_data values('UA000012','My Account','SU000006','lock',1,'MXWR','SecUser','SU000006','/link/to/app','1'); -- REFER COUNT: 2
insert into sec_user_data values('SU000007','User000007','13900000007','1000007@qq.com','016B4A47737559D64FC1369AA4D8CFD0B47E11F4C6219E80946C0E47A4C1C74B','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000013','Sec User Blocking','SU000007','user',1,'MXWR','SecUserBlocking','SUB000001','/link/to/app','1'); -- REFER COUNT: 1
insert into user_app_data values('UA000014','My Account','SU000007','lock',1,'MXWR','SecUser','SU000007','/link/to/app','1'); -- REFER COUNT: 1




/*
| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|
|Platform|13900000001|DoubleChain!y1|
|Brand|13900000002|DoubleChain!y1|
|Shipping Address|13900000003|DoubleChain!y1|
|Payment Method|13900000004|DoubleChain!y1|
|User Order|13900000005|DoubleChain!y1|
|User Domain|13900000006|DoubleChain!y1|
|Sec User Blocking|13900000007|DoubleChain!y1|


*/



/* start with data patch */
/* The sql file is not found from: /Users/Philip/githome/web-code-generator/sky/data-patch/search.sql */


/*

+----------+---------------------------------+---------------------+--------+
| Charset  | Description                     | Default collation   | Maxlen |
+----------+---------------------------------+---------------------+--------+
| gb2312   | GB2312 Simplified Chinese       | gb2312_chinese_ci   |      2 |
| gbk      | GBK Simplified Chinese          | gbk_chinese_ci      |      2 |
| utf8mb4  | UTF-8 Unicode                   | utf8mb4_general_ci  |      4 |
| utf32    | UTF-32 Unicode                  | utf32_general_ci    |      4 |
| gb18030  | China National Standard GB18030 | gb18030_chinese_ci  |      4 |
+----------+---------------------------------+---------------------+--------+

*/

