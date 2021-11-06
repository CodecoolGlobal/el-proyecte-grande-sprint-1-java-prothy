CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DO
$$
    DECLARE
        i record;
    BEGIN
        FOR i IN 1..20
            LOOP
                INSERT INTO users (id, created_date, name, privilege, status)
                VALUES (uuid_generate_v4(), current_timestamp, 'HELLO', 'USER', 'ACTIVE');
            END LOOP;
    END;
$$;

INSERT INTO holiday (id, date_from, date_to, user_id)
VALUES (uuid_generate_v4(), date(current_timestamp), date(current_timestamp), (
    SELECT id
    FROM users
    LIMIT 1
));