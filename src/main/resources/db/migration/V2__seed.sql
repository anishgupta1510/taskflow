-- USER
INSERT INTO users (id, name, email, password, created_at)
VALUES (
    '11111111-1111-1111-1111-111111111111',
    'Test User',
    'test@example.com',
    '$2a$12$wYy0rYkGEXAMPLEHASHEDPASSWORD1234567890abcdEfghijk', -- replace with real bcrypt
    NOW()
);

-- PROJECT
INSERT INTO projects (id, name, description, owner_id, created_at)
VALUES (
    '22222222-2222-2222-2222-222222222222',
    'Demo Project',
    'Sample seeded project',
    '11111111-1111-1111-1111-111111111111',
    NOW()
);

-- TASKS
INSERT INTO tasks (id, title, description, status, priority, project_id, assignee_id, created_at, updated_at)
VALUES
(
    '33333333-3333-3333-3333-333333333331',
    'Task 1',
    'Todo task',
    'TODO',
    'LOW',
    '22222222-2222-2222-2222-222222222222',
    '11111111-1111-1111-1111-111111111111',
    NOW(),
    NOW()
),
(
    '33333333-3333-3333-3333-333333333332',
    'Task 2',
    'In progress task',
    'IN_PROGRESS',
    'MEDIUM',
    '22222222-2222-2222-2222-222222222222',
    '11111111-1111-1111-1111-111111111111',
    NOW(),
    NOW()
),
(
    '33333333-3333-3333-3333-333333333333',
    'Task 3',
    'Done task',
    'DONE',
    'HIGH',
    '22222222-2222-2222-2222-222222222222',
    '11111111-1111-1111-1111-111111111111',
    NOW(),
    NOW()
);