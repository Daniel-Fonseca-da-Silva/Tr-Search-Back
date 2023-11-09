INSERT INTO corporate_users (id, cellphone, created_at, documentation, email, name, password, roles, status, updated_at, premium, telephone)
VALUES
(
    '1ec34f21-1732-4ab2-a62b-eb35d1b62194', '123-456-7890', CURRENT_TIMESTAMP, '123456789012345', 'usuario1@example.com', 'Usuário Comum', '$2a$12$XEqhEMh2sDpLvytozFozvunvhqQ70jEtB1zmMlAV8IrqE8XnlzTNa', 'ROLE_CORPORATE', TRUE, CURRENT_TIMESTAMP, 'FREE', '123-456-7890'
),
(
    '2ec34f21-1732-4ab2-a62b-eb35d1b62195', '987-654-3210', CURRENT_TIMESTAMP, '987654321098765', 'premium1@example.com', 'Usuário Premium Bronze', '$2a$12$XEqhEMh2sDpLvytozFozvunvhqQ70jEtB1zmMlAV8IrqE8XnlzTNa', 'ROLE_CORPORATE', TRUE, CURRENT_TIMESTAMP, 'BRONZE', '987-654-3210'
),
(
    '3ec34f21-1732-4ab2-a62b-eb35d1b62196', '555-555-5555', CURRENT_TIMESTAMP, '555555555555555', 'premium2@example.com', 'Usuário Premium Prata', '$2a$12$XEqhEMh2sDpLvytozFozvunvhqQ70jEtB1zmMlAV8IrqE8XnlzTNa', 'ROLE_CORPORATE', TRUE, CURRENT_TIMESTAMP, 'SILVER', '555-555-5555'
),
(
    '4ec34f21-1732-4ab2-a62b-eb35d1b62197', '111-222-3333', CURRENT_TIMESTAMP, '111122223333444', 'premium3@example.com', 'Usuário Premium Ouro', '$2a$12$XEqhEMh2sDpLvytozFozvunvhqQ70jEtB1zmMlAV8IrqE8XnlzTNa', 'ROLE_CORPORATE', TRUE, CURRENT_TIMESTAMP, 'GOLD', '111-222-3333'
);
