create sequence organization_seq start with 1;
create table organization (
    organization_id integer not null,
    org_code varchar2(20),
    organization_name varchar2(50) not null,
    address1 varchar2(200),
    address2 varchar2(200),
    city varchar2(100),
    state varchar2(2),
    zip varchar2(10),
    country varchar2(40) default 'Switzerland' not null,
    constraint un_org_organization_name unique (org_code),
    constraint pk_organization primary key (organization_id)
);

