insert into address (id, city, country, house_number, postal_code, street)
values (uuid_in((md5('bce3f59d-94a4-5f67-5b43-8e3a73434dc6'))::cstring), 'Budapest', 'HU', '44', '1064', 'Nagymező utca');

insert into address (id, city, country, house_number, postal_code, street)
values (uuid_in((md5('abc3f59d-94a4-5f67-5b43-8e3a73434dc6'))::cstring), 'Miskolc', 'HU', '9', '3525', 'Régiposta utca');

insert into address (id, city, country, house_number, postal_code, street)
values (uuid_in((md5('xyz3f59d-94a4-5f67-5b43-8e3a73434dc6'))::cstring), 'Warszawa', 'PL', '100',  '100-807', 'al. Jerozolimskie');


insert into users (id, created_date, email, name, phone_number, privilege, salary, status, updated_date, address_id)
values (uuid_in((md5('8cb3a14a-e68e-f902-badb-3e9877e6b330'))::cstring), date(current_timestamp), 'test@codecool.com', 'Teszt Elek', '+3611234567', 'ADMIN', 320000, 'ACTIVE', date(current_timestamp), uuid_in((md5('bce3f59d-94a4-5f67-5b43-8e3a73434dc6'))::cstring));

insert into users (id, created_date, email, name, phone_number, privilege, salary, status, updated_date, address_id)
values (uuid_in((md5('28b483cc-f11f-ad50-0743-996de7cb01c4'))::cstring), date(current_timestamp), 'tester@codecool.com', 'Minta Aladár', '+3619876543', 'USER', 300000, 'ACTIVE', date(current_timestamp), uuid_in((md5('abc3f59d-94a4-5f67-5b43-8e3a73434dc6'))::cstring));

insert into users (id, created_date, email, name, phone_number, privilege, salary, status, updated_date, address_id)
values (uuid_in((md5('xrz3f59d-94a4-6d89-5b43-8e3a73434dc6'))::cstring), date(current_timestamp), 'programmer@codecool.com', 'Git Áron', '+3614658443', 'USER', 280000, 'ACTIVE', date(current_timestamp), uuid_in((md5('xyz3f59d-94a4-5f67-5b43-8e3a73434dc6'))::cstring));



insert into users (id, created_date, email, name, phone_number, privilege, salary, status, updated_date, address_id)
values (uuid_in(md5(random()::text || clock_timestamp()::text)::cstring), date(current_timestamp), 'programmer1@codecool.com', 'Tra Pista', null, 'USER', 380000, 'ACTIVE', date(current_timestamp), null);


insert into users (id, created_date, email, name, phone_number, privilege, salary, status, updated_date, address_id)
values (uuid_in(md5(random()::text || clock_timestamp()::text)::cstring), date(current_timestamp), 'programmer2@codecool.com', 'Tatum Hoover', null, 'USER', 380000, 'ACTIVE', date(current_timestamp), null);


insert into users (id, created_date, email, name, phone_number, privilege, salary, status, updated_date, address_id)
values (uuid_in(md5(random()::text || clock_timestamp()::text)::cstring), date(current_timestamp), 'programmer3@codecool.com', 'Rayan Woodard', null, 'USER', 380000, 'ACTIVE', date(current_timestamp), null);


insert into users (id, created_date, email, name, phone_number, privilege, salary, status, updated_date, address_id)
values (uuid_in(md5(random()::text || clock_timestamp()::text)::cstring), date(current_timestamp), 'programmer4@codecool.com', 'Leo Sullivan', null, 'USER', 380000, 'ACTIVE', date(current_timestamp), null);


insert into users (id, created_date, email, name, phone_number, privilege, salary, status, updated_date, address_id)
values (uuid_in(md5(random()::text || clock_timestamp()::text)::cstring), date(current_timestamp), 'programmer5@codecool.com', 'Jeffrey Silva', null, 'USER', 380000, 'ACTIVE', date(current_timestamp), null);


insert into users (id, created_date, email, name, phone_number, privilege, salary, status, updated_date, address_id)
values (uuid_in(md5(random()::text || clock_timestamp()::text)::cstring), date(current_timestamp), 'programmer6@codecool.com', 'Kellen Haley', null, 'USER', 380000, 'ACTIVE', date(current_timestamp), null);


insert into users (id, created_date, email, name, phone_number, privilege, salary, status, updated_date, address_id)
values (uuid_in(md5(random()::text || clock_timestamp()::text)::cstring), date(current_timestamp), 'programmer7@codecool.com', 'Marcos Craig', null, 'USER', 380000, 'ACTIVE', date(current_timestamp), null);


insert into users (id, created_date, email, name, phone_number, privilege, salary, status, updated_date, address_id)
values (uuid_in(md5(random()::text || clock_timestamp()::text)::cstring), date(current_timestamp), 'programmer8@codecool.com', 'Tiffany Ray', null, 'USER', 380000, 'ACTIVE', date(current_timestamp), null);


insert into users (id, created_date, email, name, phone_number, privilege, salary, status, updated_date, address_id)
values (uuid_in(md5(random()::text || clock_timestamp()::text)::cstring), date(current_timestamp), 'programmer9@codecool.com', 'Sawyer Underwood', null, 'USER', 380000, 'ACTIVE', date(current_timestamp), null);


insert into users (id, created_date, email, name, phone_number, privilege, salary, status, updated_date, address_id)
values (uuid_in(md5(random()::text || clock_timestamp()::text)::cstring), date(current_timestamp), 'programmer10@codecool.com', 'Lena Keller', null, 'USER', 380000, 'ACTIVE', date(current_timestamp), null);


insert into users (id, created_date, email, name, phone_number, privilege, salary, status, updated_date, address_id)
values (uuid_in(md5(random()::text || clock_timestamp()::text)::cstring), date(current_timestamp), 'programmer11@codecool.com', 'Hector Patrick', null, 'USER', 380000, 'ACTIVE', date(current_timestamp), null);


insert into users (id, created_date, email, name, phone_number, privilege, salary, status, updated_date, address_id)
values (uuid_in(md5(random()::text || clock_timestamp()::text)::cstring), date(current_timestamp), 'programmer12@codecool.com', 'Michael Oxlong', null, 'USER', 380000, 'ACTIVE', date(current_timestamp), null);


insert into users (id, created_date, email, name, phone_number, privilege, salary, status, updated_date, address_id)
values (uuid_in(md5(random()::text || clock_timestamp()::text)::cstring), date(current_timestamp), 'programmer13@codecool.com', 'Isabelle Oconnor', null, 'USER', 380000, 'ACTIVE', date(current_timestamp), null);


insert into users (id, created_date, email, name, phone_number, privilege, salary, status, updated_date, address_id)
values (uuid_in(md5(random()::text || clock_timestamp()::text)::cstring), date(current_timestamp), 'programmer14@codecool.com', 'Nap Pali', null, 'USER', 380000, 'ACTIVE', date(current_timestamp), null);


insert into users (id, created_date, email, name, phone_number, privilege, salary, status, updated_date, address_id)
values (uuid_in(md5(random()::text || clock_timestamp()::text)::cstring), date(current_timestamp), 'programmer15@codecool.com', 'Evie Wood', null, 'USER', 380000, 'ACTIVE', date(current_timestamp), null);


insert into users (id, created_date, email, name, phone_number, privilege, salary, status, updated_date, address_id)
values (uuid_in(md5(random()::text || clock_timestamp()::text)::cstring), date(current_timestamp), 'programmer16@codecool.com', 'Byron Carey', null, 'USER', 380000, 'ACTIVE', date(current_timestamp), null);


insert into users (id, created_date, email, name, phone_number, privilege, salary, status, updated_date, address_id)
values (uuid_in(md5(random()::text || clock_timestamp()::text)::cstring), date(current_timestamp), 'programmer17@codecool.com', 'Maximilian Foster', null, 'USER', 380000, 'ACTIVE', date(current_timestamp), null);


insert into users (id, created_date, email, name, phone_number, privilege, salary, status, updated_date, address_id)
values (uuid_in(md5(random()::text || clock_timestamp()::text)::cstring), date(current_timestamp), 'programmer18@codecool.com', 'Rex Middleton', null, 'USER', 380000, 'ACTIVE', date(current_timestamp), null);


insert into users (id, created_date, email, name, phone_number, privilege, salary, status, updated_date, address_id)
values (uuid_in(md5(random()::text || clock_timestamp()::text)::cstring), date(current_timestamp), 'programmer19@codecool.com', 'Lawrence Nunez', null, 'USER', 380000, 'ACTIVE', date(current_timestamp), null);


insert into users (id, created_date, email, name, phone_number, privilege, salary, status, updated_date, address_id)
values (uuid_in(md5(random()::text || clock_timestamp()::text)::cstring), date(current_timestamp), 'programmer20@codecool.com', 'Maximilian Foster', null, 'USER', 380000, 'ACTIVE', date(current_timestamp), null);



insert into transactions (id, account_num_from, account_num_to, amount, "timestamp", user_id)
values (uuid_in((md5('98e070d8-9a06-fb14-01f2-98722bc783e9'))::cstring), '11111111-11111111-11111111', '11111111-22222222-33333333', 100000, date(current_timestamp), uuid_in((md5('8cb3a14a-e68e-f902-badb-3e9877e6b330'))::cstring));

insert into transactions (id, account_num_from, account_num_to, amount, "timestamp", user_id)
values (uuid_in((md5('87e070d8-9a06-fb14-01f2-98722bc783e9'))::cstring), '11111111-11111111-11111111', '11111111-22222222-33333333', 140000, date(current_timestamp)-30, uuid_in((md5('8cb3a14a-e68e-f902-badb-3e9877e6b330'))::cstring));

insert into transactions (id, account_num_from, account_num_to, amount, "timestamp", user_id)
values (uuid_in((md5('76e070d8-9a06-fb14-01f2-98722bc783e9'))::cstring), '11111111-11111111-11111111', '11111111-22222222-33333333', 175000, date(current_timestamp)-60, uuid_in((md5('8cb3a14a-e68e-f902-badb-3e9877e6b330'))::cstring));

insert into transactions (id, account_num_from, account_num_to, amount, "timestamp", user_id)
values (uuid_in((md5('543070d8-9a06-fb14-01f2-98722bc783e9'))::cstring), '11111111-11111111-11111111', '11111111-33333333-22222222', 210100, date(current_timestamp), uuid_in((md5('28b483cc-f11f-ad50-0743-996de7cb01c4'))::cstring));

insert into transactions (id, account_num_from, account_num_to, amount, "timestamp", user_id)
values (uuid_in((md5('54e024d8-9a06-fb14-01f2-98722bc783e9'))::cstring), '11111111-11111111-11111111', '11111111-33333333-22222222', 141000, date(current_timestamp)-30, uuid_in((md5('28b483cc-f11f-ad50-0743-996de7cb01c4'))::cstring));

insert into transactions (id, account_num_from, account_num_to, amount, "timestamp", user_id)
values (uuid_in((md5('54e07264-9a06-fb14-01f2-98722bc783e9'))::cstring), '11111111-11111111-11111111', '11111111-33333333-22222222', 106300, date(current_timestamp)-60, uuid_in((md5('28b483cc-f11f-ad50-0743-996de7cb01c4'))::cstring));

insert into transactions (id, account_num_from, account_num_to, amount, "timestamp", user_id)
values (uuid_in((md5('54e070d8-9a06-2354-01f2-98722bc783e9'))::cstring), '11111111-11111111-11111111', '22222222-11111111-22222222', 196000, date(current_timestamp), uuid_in((md5('xrz3f59d-94a4-6d89-5b43-8e3a73434dc6'))::cstring));

insert into transactions (id, account_num_from, account_num_to, amount, "timestamp", user_id)
values (uuid_in((md5('547246d8-9a06-fb14-01f2-98722bc783e9'))::cstring), '11111111-11111111-11111111', '22222222-11111111-22222222', 241000, date(current_timestamp)-30, uuid_in((md5('xrz3f59d-94a4-6d89-5b43-8e3a73434dc6'))::cstring));


insert into authentication (id, username, password, user_id)
values (uuid_in((md5('4f07f2cc-c7f2-40bf-b8db-f60f6377b0bf'))::cstring), 'teszt_elek', '$2a$10$z4Fm900R0goOBRlMjI1DYO8LV0jRCHHD2EiPwIKRxvBUlmyF02rBq', uuid_in((md5('8cb3a14a-e68e-f902-badb-3e9877e6b330'))::cstring));

insert into authentication (id, username, password, user_id)
values (uuid_in((md5('412345cc-c7f2-40bf-b8db-f60f6377b0bf'))::cstring), 'minta_aladar', 'safepassword2', uuid_in((md5('28b483cc-f11f-ad50-0743-996de7cb01c4'))::cstring));

insert into authentication (id, username, password, user_id)
values (uuid_in((md5('412345cc-c7f2-40bf-b8db-d8h4j377b0bf'))::cstring), 'git_aron', 'safepassword3', uuid_in((md5('xrz3f59d-94a4-6d89-5b43-8e3a73434dc6'))::cstring));


insert into holiday (id, date_from, date_to, user_id)
values (uuid_in((md5('4asf4f5c-c7f2-40bf-b8d5-f60f6377b0bf'))::cstring), date(current_timestamp)-20, date(current_timestamp)-15,  uuid_in((md5('xrz3f59d-94a4-6d89-5b43-8e3a73434dc6'))::cstring));
