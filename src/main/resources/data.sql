insert into coverages (id)
values ('WINDOWS_COVERAGE');
insert into coverages (id)
values ('ELECTRONIC_DEVICES_COVERAGE');
insert into coverages (id)
values ('FACADE_COVERAGE');

insert into coverage_incidences (id)
values ('FLOOD');
insert into coverage_incidences (id)
values ('EARTHQUAKE');
insert into coverage_incidences (id)
values ('DEEP_ASTEROID_IMPACT');
insert into coverage_incidences (id)
values ('TSUNAMI');
insert into coverage_incidences (id)
values ('TORNADO');
insert into coverage_incidences (id)
values ('ACCIDENT');

insert into coverages_and_incidences (coverage_id, incidence_id)
values ('WINDOWS_COVERAGE', 'FLOOD');
insert into coverages_and_incidences (coverage_id, incidence_id)
values ('WINDOWS_COVERAGE', 'EARTHQUAKE');
insert into coverages_and_incidences (coverage_id, incidence_id)
values ('ELECTRONIC_DEVICES_COVERAGE', 'DEEP_ASTEROID_IMPACT');
insert into coverages_and_incidences (coverage_id, incidence_id)
values ('ELECTRONIC_DEVICES_COVERAGE', 'TSUNAMI');
insert into coverages_and_incidences (coverage_id, incidence_id)
values ('FACADE_COVERAGE', 'TORNADO');
insert into coverages_and_incidences (coverage_id, incidence_id)
values ('FACADE_COVERAGE', 'ACCIDENT');
