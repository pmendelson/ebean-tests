create sequence user_seq start with 1;

create table user_t (
    user_id integer not null,
    username varchar2(50) not null,
    password varchar2(100) not null,
    status varchar2(20) default 'PENDING' not null,
    first_name varchar2(50),
    last_name varchar2(50),
    constraint un_user_username unique (username),
    constraint pk_user primary key (user_id)
);

create sequence organization_seq start with 1;
create table organization (
    organization_id integer not null,
    organization_name varchar2(50) not null,
    region_code varchar2(20),
    lab_code varchar2(20),
    constraint un_org_organization_name unique (organization_name),
    constraint pk_organization primary key (organization_id)
);

create sequence secret_question_seq start with 1;
create table secret_question (
    secret_question_id integer not null,
    value varchar2(1000) not null,
    constraint un_sq_value unique (value),
    constraint pk_secret_question primary key (secret_question_id)
);
comment on table secret_question is 'Lookup table for secret questions';



create sequence user_role_seq start with 1;

create table role_assignment (
  ROLE_ASSIGNMENT_ID number(20,0) not null,
  PARENT_ID number(20,0),
  ROLE_ID number(10,0),
  AUTHORIZATION_SOURCE varchar(6),
  ASSIGNMENT_STATUS varchar(8),
  last_update_date date null,
  last_update_full_name varchar(60) null,
  version  integer not null,
  constraint ck_role_assignment_ASSIGNMENT_STATUS check (ASSIGNMENT_STATUS in ('REJECTED','APPROVED','PENDING')),
  constraint ck_role_assignment_AUTHORIZATION_SOURCE check (AUTHORIZATION_SOURCE in ('SELF','ADMIN','PARENT')),
  constraint pk_role_assignment primary key (ROLE_ASSIGNMENT_ID));
comment on table role_assignment is 'Stores user-role associations';
comment on column role_assignment.AUTHORIZATION_SOURCE is 'Role was requested by user (1=True, 0=False)';
comment on column role_assignment.ASSIGNMENT_STATUS is 'Current status on role (1=Rejected, 3=Approved, 5=Pending)';

create table user_organization (
    user_id integer not null,
    organization_id integer not null,
    constraint fk_user_uo foreign key (user_id) references user_t (user_id) on delete cascade,
    constraint fk_org_uo foreign key (organization_id) references organization (organization_id) on delete cascade
);

commit;