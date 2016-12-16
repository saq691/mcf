/*创建数据库*/
CREATE DATABASE `mcf_db` DEFAULT CHARACTER SET utf8;

USE `mcf_db`;

drop table if exists t_admin_user;
create table t_admin_user(
   id                   varchar(32) not null comment '主键id',
   is_delete            tinyint(1) unsigned not null default 0 comment '是否删除，0否，1是',
   username             varchar(50) comment '用户名',
   password             varchar(256) comment '密码',
   enabled              tinyint(1) unsigned not null default 0 comment '是否启用，0否，1是',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (id),
   unique key username(username)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户管理表';

drop table if exists t_contact_info;
create table t_contact_info(
   id                   varchar(32) not null comment '主键ID',
   is_delete            tinyint(1) unsigned not null default 0 comment '是否删除，0否，1是',
   name                 varchar(30) comment '联系姓名',
   contact_way          varchar(256) comment '联系方式，邮箱或者电话',
   content              varchar(500) comment '信息内容',
   is_contact           tinyint(1) unsigned not null default 0 comment '是否已联系，0否，1是',
   remark               varchar(500) comment '备注',
   create_time          datetime comment '创建时间',
   visit_time           datetime comment '联系客户时间',
   primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='联系信息表';


drop table if exists t_news_content;
create table t_news_content(
   id                   varchar(32) not null comment '主键id',
   is_show              tinyint(1) unsigned not null default 0 comment '是否显示，0否，1是',
   title                varchar(100) comment '内容标题',
   source               varchar(30) comment '来源',
   author               varchar(30) comment '作者',
   digest               varchar(500) not null comment '摘要',
   content              text comment '内容',
   browse_num           int(11) unsigned not null default 0 comment '浏览数量',
   is_stick             tinyint(1) unsigned not null default 0 comment '是否置顶，0否，1是',
   creator              varchar(20) comment '创建者',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (id),
   unique key title(title)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='新闻资讯内容表';

drop table if exists t_copartner;
create table t_copartner(
   id                   varchar(32) not null comment '主键id',
   is_delete            tinyint(1) unsigned not null default 0 comment '是否删除，0否，1是',
   city_name            varchar(30) comment '城市名称',
   city_id              int(11) not null comment '城市id',
   name                 varchar(30) comment '姓名',
   contact_way          varchar(30) comment '联系方式',
   main_business        varchar(500) comment '主营业务',
   company_scale        tinyint(1) unsigned not null default 0 comment '公司人数，0标示1-49，1标示50-99，2标示100-499，3标示500-999，4标示1000以上',
   cooperate_type       tinyint(1) unsigned not null default 0 comment '合作类型，0企业，1个体',
   is_contact           tinyint(1) unsigned not null default 0 comment '是否已联系，0否，1是',
   remark               varchar(500) comment '备注',
   create_time          datetime comment '创建时间',
   visit_time           datetime comment '联系客户时间',
   primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='申请合伙人表';

/**------------------ 地址省市区字典表 -----------------------------**/
DROP TABLE IF EXISTS `t_address`;

CREATE TABLE `t_address` (
  `id`               int(11) unsigned NOT NULL COMMENT '主键',
  `name`             varchar(50) DEFAULT NULL COMMENT '地址名称',
  `parent_id`        int(11) unsigned DEFAULT NULL COMMENT '父id',
  `short_name`       varchar(50) DEFAULT NULL COMMENT '简称',
  `level_type`       tinyint(1) unsigned DEFAULT '0' COMMENT '级别',
  `city_code`        int(11) unsigned DEFAULT NULL COMMENT '城市编码',
  `zip_code`         int(11) DEFAULT NULL COMMENT '区号',
  `merger_name`      varchar(255) DEFAULT NULL COMMENT '完整地址',
  `lng`              double DEFAULT NULL COMMENT '经度',
  `lat`              double DEFAULT NULL COMMENT '纬度',
  `pinyin`           varchar(255) DEFAULT NULL COMMENT '拼音',
  `hot_city`         tinyint(1) unsigned DEFAULT '0' COMMENT '热门城市标记，0非热门，1热门',
  `sort_flag`        int(11) DEFAULT NULL COMMENT '排序',
  `is_flag`          tinyint(1) unsigned DEFAULT '0' COMMENT '是否显示，0代表显示，1代表不显示',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='地址省市区字典表';