runscript from 'src/db/schema.sql';

insert into organization direct select * from csvread('src/db/test_data/organization.csv');
alter sequence organization_seq restart with (select max(organization_id) + 1 from organization);
