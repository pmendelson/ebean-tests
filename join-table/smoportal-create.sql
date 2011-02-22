create table ORGANIZATION (
  ORGANIZATION_ID           bigint not null,
  REGION_CODE               varchar(255),
  LAB_CODE                  varchar(255),
  ORGANIZATION_NAME         varchar(255),
  constraint pk_ORGANIZATION primary key (ORGANIZATION_ID))
;

create table USER_T (
  USER_ID                   bigint not null,
  USERNAME                  varchar(255),
  PASSWORD                  varchar(255),
  FIRST_NAME                varchar(255),
  LAST_NAME                 varchar(255),
  constraint pk_USER_T primary key (USER_ID))
;

create sequence ORGANIZATION_SEQ;

create sequence USER_SEQ;

alter table USER_T add constraint fk_USER_T_organization_1 foreign key (USER_ID) references ORGANIZATION (ORGANIZATION_ID) on delete restrict on update restrict;
create index ix_USER_T_organization_1 on USER_T (USER_ID);


