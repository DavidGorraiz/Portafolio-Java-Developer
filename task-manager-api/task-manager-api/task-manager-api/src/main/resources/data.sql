-- ==========================
-- 1. Roles
-- ==========================
INSERT INTO role (role) VALUES ('ADMIN') ON CONFLICT (role) DO NOTHING;
INSERT INTO role (role) VALUES ('USER') ON CONFLICT (role) DO NOTHING;
INSERT INTO role (role) VALUES ('MODERATOR') ON CONFLICT (role) DO NOTHING;
INSERT INTO role (role) VALUES ('GUEST') ON CONFLICT (role) DO NOTHING;
INSERT INTO role (role) VALUES ('OWNER') ON CONFLICT (role) DO NOTHING;
INSERT INTO role (role) VALUES ('DEVELOPER') ON CONFLICT (role) DO NOTHING;
INSERT INTO role (role) VALUES ('MANAGER') ON CONFLICT (role) DO NOTHING;
INSERT INTO role (role) VALUES ('TESTER') ON CONFLICT (role) DO NOTHING;
INSERT INTO role (role) VALUES ('DESIGNER') ON CONFLICT (role) DO NOTHING;
INSERT INTO role (role) VALUES ('VIEWER') ON CONFLICT (role) DO NOTHING;

-- ==========================
-- 2. Users
-- ==========================
INSERT INTO "users" (username, password, locked, disabled) VALUES
                                                              ('alice', 'pass1', false, false),
                                                              ('bob', 'pass2', false, false),
                                                              ('carol', 'pass3', false, false),
                                                              ('dave', 'pass4', false, false),
                                                              ('eve', 'pass5', false, false),
                                                              ('frank', 'pass6', false, false),
                                                              ('grace', 'pass7', false, false),
                                                              ('heidi', 'pass8', false, false),
                                                              ('ivan', 'pass9', false, false),
                                                              ('judy', 'pass10', false, false)
    ON CONFLICT (username) DO NOTHING;

-- ==========================
-- 3. User_Role
-- ==========================
INSERT INTO user_role (username, role) VALUES
                                           ('alice', 'ADMIN'),
                                           ('bob', 'USER'),
                                           ('carol', 'MODERATOR'),
                                           ('dave', 'GUEST'),
                                           ('eve', 'OWNER'),
                                           ('frank', 'DEVELOPER'),
                                           ('grace', 'MANAGER'),
                                           ('heidi', 'TESTER'),
                                           ('ivan', 'DESIGNER'),
                                           ('judy', 'VIEWER')
    ON CONFLICT (username, role) DO NOTHING;

-- ==========================
-- 4. Boards
-- ==========================
INSERT INTO boards (id, name, description, username) VALUES
                                                     (1, 'Project Alpha', 'Main project board', 'alice'),
                                                     (2, 'Project Beta', 'Secondary board', 'bob'),
                                                     (3, 'Project Gamma', 'Testing board', 'carol'),
                                                     (4, 'Project Delta', 'Development board', 'dave'),
                                                     (5, 'Project Epsilon', 'Research board', 'eve'),
                                                     (6, 'Project Zeta', 'UI/UX design board', 'frank'),
                                                     (7, 'Project Eta', 'QA board', 'grace'),
                                                     (8, 'Project Theta', 'Documentation board', 'heidi'),
                                                     (9, 'Project Iota', 'Client board', 'ivan'),
                                                     (10, 'Project Kappa', 'Experimental board', 'judy')
    ON CONFLICT (id) DO NOTHING;

-- ==========================
-- 5. Board Members
-- ==========================
INSERT INTO board_member (id, board_id, username, role_in_board) VALUES
                                                                   (1, 1, 'alice', 'OWNER'),
                                                                   (2, 1, 'bob', 'COLLABORATOR'),
                                                                   (3, 2, 'carol', 'OWNER'),
                                                                   (4, 2, 'dave', 'COLLABORATOR'),
                                                                   (5, 3, 'eve', 'OWNER'),
                                                                   (6, 3, 'frank', 'COLLABORATOR'),
                                                                   (7, 4, 'grace', 'OWNER'),
                                                                   (8, 5, 'heidi', 'OWNER'),
                                                                   (9, 6, 'ivan', 'OWNER'),
                                                                   (10, 7, 'judy', 'OWNER')
    ON CONFLICT (id) DO NOTHING;

-- ==========================
-- 6. Lists
-- ==========================
INSERT INTO lists (id, name, position, board_id) VALUES
                                                    (1, 'To Do', 1, 1),
                                                    (2, 'In Progress', 2, 1),
                                                    (3, 'Done', 3, 1),
                                                    (4, 'Backlog', 1, 2),
                                                    (5, 'In Progress', 2, 2),
                                                    (6, 'Review', 3, 2),
                                                    (7, 'To Do', 1, 3),
                                                    (8, 'In Progress', 2, 3),
                                                    (9, 'Done', 3, 3),
                                                    (10, 'Ideas', 1, 4)
    ON CONFLICT (id) DO NOTHING;

-- ==========================
-- 7. Tasks
-- ==========================
INSERT INTO task (id, title, description, due_date, position, status, list_id, board_id) VALUES
                                                                                             (1, 'Setup project', 'Initialize repo', '2025-09-10', 1, 'OPEN', 1, 1),
                                                                                             (2, 'Feature A', 'Implement core logic', '2025-09-12', 2, 'IN_PROGRESS', 2, 1),
                                                                                             (3, 'Fix bug #23', 'Resolve login issue', '2025-09-15', 3, 'OPEN', 1, 2),
                                                                                             (4, 'Design mockups', 'Create UI drafts', '2025-09-20', 1, 'IN_PROGRESS', 5, 2),
                                                                                             (5, 'Write tests', 'Unit tests for feature A', '2025-09-22', 2, 'OPEN', 7, 3),
                                                                                             (6, 'Deploy beta', 'Deploy to staging', '2025-09-25', 3, 'OPEN', 8, 3),
                                                                                             (7, 'Client feedback', 'Review client notes', '2025-09-28', 1, 'OPEN', 10, 4),
                                                                                             (8, 'Update docs', 'Update API docs', '2025-09-30', 2, 'OPEN', 10, 4),
                                                                                             (9, 'Security review', 'Check vulnerabilities', '2025-10-02', 1, 'OPEN', 1, 5),
                                                                                             (10, 'Refactor code', 'Improve code quality', '2025-10-05', 2, 'OPEN', 2, 6)
    ON CONFLICT (id) DO NOTHING;

-- ==========================
-- 8. Attachments
-- ==========================
INSERT INTO attachments (id, file_url, username, task_id) VALUES
                                                           (1, 'http://files.com/specs1.pdf', 'alice', 1),
                                                           (2, 'http://files.com/specs2.pdf', 'bob', 2),
                                                           (3, 'http://files.com/specs3.pdf', 'carol', 3),
                                                           (4, 'http://files.com/specs4.pdf', 'dave', 4),
                                                           (5, 'http://files.com/specs5.pdf', 'eve', 5),
                                                           (6, 'http://files.com/specs6.pdf', 'frank', 6),
                                                           (7, 'http://files.com/specs7.pdf', 'grace', 7),
                                                           (8, 'http://files.com/specs8.pdf', 'heidi', 8),
                                                           (9, 'http://files.com/specs9.pdf', 'ivan', 9),
                                                           (10, 'http://files.com/specs10.pdf', 'judy', 10)
    ON CONFLICT (id) DO NOTHING;

-- ==========================
-- 9. Comments
-- ==========================
INSERT INTO comments (id, content, username, task_id) VALUES
                                                       (1, 'Looks good!', 'alice', 1),
                                                       (2, 'I will take this task.', 'bob', 2),
                                                       (3, 'Bug confirmed.', 'carol', 3),
                                                       (4, 'UI needs improvements.', 'dave', 4),
                                                       (5, 'Tests are missing.', 'eve', 5),
                                                       (6, 'Deployed successfully.', 'frank', 6),
                                                       (7, 'Client is happy.', 'grace', 7),
                                                       (8, 'Docs updated.', 'heidi', 8),
                                                       (9, 'Found a security issue.', 'ivan', 9),
                                                       (10, 'Refactoring done.', 'judy', 10)
    ON CONFLICT (id) DO NOTHING;
