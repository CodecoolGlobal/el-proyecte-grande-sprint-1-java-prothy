insert into address (id, city, country, house_number, postal_code, street)
values (uuid_in((md5('bce3f59d-94a4-5f67-5b43-8e3a73434dc6'))::cstring), 'Budapest', 'HU', '1', '1064',
        'Nagymező utca');

insert into users (id, created_date, email, name, phone_number, privilege, salary, status, updated_date,
                   address_id)
values (uuid_in((md5('28b483cc-f11f-ad50-0743-996de7cb01c4'))::cstring), now(), 'test@test.com', 'Teszt Elek',
        '+3611234567', 'USER', 100,
        'ACTIVE', now(),
        uuid_in((md5('bce3f59d-94a4-5f67-5b43-8e3a73434dc6'))::cstring));

insert into transactions (id, account_num_from, account_num_to, amount, "timestamp", user_id)
values (uuid_in((md5('54e070d8-9a06-fb14-01f2-98722bc783e9'))::cstring), '11111111-11111111-11111111',
        '11111111-11111111-22222222', 1000, now(), uuid_in((md5('28b483cc-f11f-ad50-0743-996de7cb01c4'))::cstring));

insert into authentication (id, login_name, password, users_id)
values (uuid_in((md5('4f07f2cc-c7f2-40bf-b8db-f60f6377b0bf'))::cstring), 'teszt_elek', 'safepassword',
        uuid_in((md5('28b483cc-f11f-ad50-0743-996de7cb01c4'))::cstring))