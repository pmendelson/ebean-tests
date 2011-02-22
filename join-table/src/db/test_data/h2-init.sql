runscript from 'src/db/schema.sql';

insert into organization direct select * from csvread('src/db/test_data/organization.csv');
alter sequence organization_seq restart with (select max(organization_id) + 1 from organization);

insert into user_t direct select * from csvread('src/db/test_data/user_t.csv');
alter sequence user_seq restart with (select max(user_id) + 1 from user_t);

insert into user_organization direct select * from csvread('src/db/test_data/user_organization.csv');