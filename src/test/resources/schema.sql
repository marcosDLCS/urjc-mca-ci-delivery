CREATE TABLE IF NOT EXISTS clients
(
    id          varchar(255) not null
        constraint clients_pkey
            primary key,
    city        varchar(255),
    country     varchar(255),
    name        varchar(255),
    number      varchar(255),
    postal_code varchar(255),
    street      varchar(255),
    surname     varchar(255)
);

CREATE TABLE IF NOT EXISTS coverage_incidences
(
    id varchar(255) not null
        constraint coverage_incidences_pkey
            primary key
);

CREATE TABLE IF NOT EXISTS coverages
(
    id varchar(255) not null
        constraint coverages_pkey
            primary key
);

CREATE TABLE IF NOT EXISTS coverages_and_incidences
(
    coverage_id  varchar(255) not null
        constraint fk9axtpocu2e7mykinqfe2k8hyd
            references coverages,
    incidence_id varchar(255) not null
        constraint fkkdu30djexyu1ewgy86ke37dey
            references coverage_incidences,
    constraint coverages_and_incidences_pkey
        primary key (coverage_id, incidence_id)
);

CREATE TABLE if not exists insurances
(
    id                varchar(255) not null
        constraint insurances_pkey
            primary key,
    house_city        varchar(255),
    house_country     varchar(255),
    house_number      varchar(255),
    house_postal_code varchar(255),
    house_registry    varchar(255)
        constraint uk_ailmk0gy2mkmavj4oihl0m8wa
            unique,
    house_street      varchar(255),
    client_id         varchar(255)
        constraint fkeipougxuspyv3gyp4ff9qg9w1
            references clients
);

CREATE TABLE IF NOT EXISTS incidences
(
    id           varchar(255) not null
        constraint incidences_pkey
            primary key,
    amount       numeric(19, 2),
    currency     varchar(255),
    date         timestamp,
    description  varchar(10000),
    status       varchar(255),
    type         varchar(255),
    insurance_id varchar(255)
        constraint fkllroavqdd7m5xo5a5gu48knk9
            references insurances
);

CREATE TABLE IF NOT EXISTS insurances_and_coverages
(
    insurance_id varchar(255) not null
        constraint fkcjec2qph4xy1qrk9b6ypbutb7
            references insurances,
    coverage_id  varchar(255) not null
        constraint fkq6j783nmilgo4qhfdtxoiufdr
            references coverages,
    constraint insurances_and_coverages_pkey
        primary key (insurance_id, coverage_id)
);

CREATE TABLE IF NOT EXISTS insurances_incidences
(
    insurance_entity_id varchar(255) not null
        constraint fkg4w0q173exeyw4wfq9swxd1c0
            references insurances,
    incidences_id       varchar(255) not null
        constraint uk_clj1klbysltys5y1j1gs6nw7
            unique
        constraint fkhhxtm25e7q3pidcedu48yb57c
            references incidences,
    constraint insurances_incidences_pkey
        primary key (insurance_entity_id, incidences_id)
);

INSERT INTO coverages (id)
VALUES ('WINDOWS_COVERAGE');
INSERT INTO coverages (id)
VALUES ('ELECTRONIC_DEVICES_COVERAGE');
INSERT INTO coverages (id)
VALUES ('FACADE_COVERAGE');

INSERT INTO coverage_incidences (id)
VALUES ('FLOOD');
INSERT INTO coverage_incidences (id)
VALUES ('EARTHQUAKE');
INSERT INTO coverage_incidences (id)
VALUES ('DEEP_ASTEROID_IMPACT');
INSERT INTO coverage_incidences (id)
VALUES ('TSUNAMI');
INSERT INTO coverage_incidences (id)
VALUES ('TORNADO');
INSERT INTO coverage_incidences (id)
VALUES ('ACCIDENT');

INSERT INTO coverages_and_incidences (coverage_id, incidence_id)
VALUES ('WINDOWS_COVERAGE', 'FLOOD');
INSERT INTO coverages_and_incidences (coverage_id, incidence_id)
VALUES ('WINDOWS_COVERAGE', 'EARTHQUAKE');
INSERT INTO coverages_and_incidences (coverage_id, incidence_id)
VALUES ('ELECTRONIC_DEVICES_COVERAGE', 'DEEP_ASTEROID_IMPACT');
INSERT INTO coverages_and_incidences (coverage_id, incidence_id)
VALUES ('ELECTRONIC_DEVICES_COVERAGE', 'TSUNAMI');
INSERT INTO coverages_and_incidences (coverage_id, incidence_id)
VALUES ('FACADE_COVERAGE', 'TORNADO');
INSERT INTO coverages_and_incidences (coverage_id, incidence_id)
VALUES ('FACADE_COVERAGE', 'ACCIDENT');
