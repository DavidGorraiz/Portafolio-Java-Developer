-- ==========================
-- 1. Roles
-- ==========================
INSERT INTO role (id, role) VALUES (1,'ADMIN') ON CONFLICT (id) DO NOTHING;
INSERT INTO role (id, role) VALUES (2,'USER') ON CONFLICT (id) DO NOTHING;
INSERT INTO role (id, role) VALUES (3,'MODERATOR') ON CONFLICT (id) DO NOTHING;
INSERT INTO role (id, role) VALUES (4,'GUEST') ON CONFLICT (id) DO NOTHING;
INSERT INTO role (id, role) VALUES (5,'OWNER') ON CONFLICT (id) DO NOTHING;
INSERT INTO role (id, role) VALUES (6,'DEVELOPER') ON CONFLICT (id) DO NOTHING;
INSERT INTO role (id, role) VALUES (7,'MANAGER') ON CONFLICT (id) DO NOTHING;
INSERT INTO role (id, role) VALUES (8,'TESTER') ON CONFLICT (id) DO NOTHING;
INSERT INTO role (id, role) VALUES (9,'DESIGNER') ON CONFLICT (id) DO NOTHING;
INSERT INTO role (id, role) VALUES (10,'VIEWER') ON CONFLICT (id) DO NOTHING;

-- ==========================
-- 2. Users
-- ==========================
INSERT INTO "users" (id, username, password, email, locked, disabled) VALUES
                                                              (1,'alice', '$2y$10$jBOcauXWEucpfqlvUqDEBOgm4pYxy4loK5meaIu4rEDopjgE6YoLG','alice@emial.com', false, false), --pass1
                                                              (2,'bob', '$2y$10$Qb6VqJ2j6XL.h3qNOnbdvu7blGBT7fIC0tN1.ptbS7mB/1Py3LL4K', 'bob@emial.com',false, false), --pass2
                                                              (3,'carol', '$2y$10$Ijg8BNJrFwmQy/ZF68yknObl7WPQGV538.HA6QIp4ZeM9dBSRJ.qC', 'carol@emial.com',false, false), --pass3
                                                              (4,'dave', '$2y$10$TmK196ufKWPXpKdG3NpnsuTF0MHGTSvVIrvFzkIHdaJD4Tkbf4dlK', 'dave@emial.com',false, false), --pass4
                                                              (5,'eve', '$2y$10$UvS.H1KUjwMDNifvI7Ypn.sO1UlgWTXqGh8u0D3q.fItY51FSGAfa', 'eve@emial.com',false, false), --pass5
                                                              (6,'frank', '$2y$10$b0hUwPkUHjGqPrXNsi5KRuf98zhsFlEYGc/AZ3/ADu0IeXIx.Itla', 'frank@emial.com',false, false), --pass6
                                                              (7,'grace', '$2y$10$reIhA7g3RX3cKv8YLBpyTORFuOkdvayZBMA9n.S5nsKl6bpNzb2Y2', 'grace@emial.com',false, false), --pass7
                                                              (8,'heidi', '$2y$10$bKgZ4itl9NnFwKtsgCQOnOSxUQvFo6qeAjPKEZOvTvfm0h/rNyfRS', 'heidi@emial.com',false, false), --pass8
                                                              (9,'ivan', '$2y$10$4xZZvNbKEwD2dRWC/9zsZOj5cbokSZz.s/SszXlqg2zdt.yAiCEHS', 'ivan@emial.com',false, false), --pass9
                                                              (10,'judy', '$2y$10$9MnQE/e.I4qNM8yH3PhYCuIDEgJMtzYzPCtiJ1yCiO5qM.Xv/Cpky', 'judy@emial.com',false, false) --pass10
    ON CONFLICT (id) DO NOTHING;

-- ==========================
-- 3. User_Role
-- ==========================
INSERT INTO user_role (user_id, role_id) VALUES
                                           (1, 1),
                                           (2, 2),
                                           (3, 3),
                                           (4, 4),
                                           (5, 5),
                                           (6, 6),
                                           (7, 7),
                                           (8, 8),
                                           (9, 9),
                                           (10, 10)
    ON CONFLICT (user_id, role_id) DO NOTHING;

-- ==========================
-- 4. Boards
-- ==========================
INSERT INTO boards (id, name, description, owner_id) VALUES
                                                     (1, 'Project Alpha', 'Main project board', 1),
                                                     (2, 'Project Beta', 'Secondary board', 2),
                                                     (3, 'Project Gamma', 'Testing board', 3),
                                                     (4, 'Project Delta', 'Development board', 4),
                                                     (5, 'Project Epsilon', 'Research board', 5),
                                                     (6, 'Project Zeta', 'UI/UX design board', 6),
                                                     (7, 'Project Eta', 'QA board', 7),
                                                     (8, 'Project Theta', 'Documentation board', 8),
                                                     (9, 'Project Iota', 'Client board',9),
                                                     (10, 'Project Kappa', 'Experimental board', 10)
    ON CONFLICT (id) DO NOTHING;

-- ==========================
-- 5. Board Members
-- ==========================
INSERT INTO board_member (id, board_id, user_id, role_in_board) VALUES
                                                                   (1, 1, 1, 'OWNER'),
                                                                   (2, 1, 2, 'COLLABORATOR'),
                                                                   (3, 2, 3, 'OWNER'),
                                                                   (4, 2, 4, 'COLLABORATOR'),
                                                                   (5, 3, 5, 'OWNER'),
                                                                   (6, 3, 6, 'COLLABORATOR'),
                                                                   (7, 4, 7, 'OWNER'),
                                                                   (8, 5, 8, 'OWNER'),
                                                                   (9, 6, 9, 'OWNER'),
                                                                   (10, 7, 10, 'OWNER')
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
INSERT INTO attachments (id, file_url, user_id, task_id) VALUES
                                                           (1, 'http://files.com/specs1.pdf', 1, 1),
                                                           (2, 'http://files.com/specs2.pdf', 2, 2),
                                                           (3, 'http://files.com/specs3.pdf', 3, 3),
                                                           (4, 'http://files.com/specs4.pdf', 4, 4),
                                                           (5, 'http://files.com/specs5.pdf', 5, 5),
                                                           (6, 'http://files.com/specs6.pdf', 6, 6),
                                                           (7, 'http://files.com/specs7.pdf', 7, 7),
                                                           (8, 'http://files.com/specs8.pdf', 8, 8),
                                                           (9, 'http://files.com/specs9.pdf', 9, 9),
                                                           (10, 'http://files.com/specs10.pdf', 10, 10)
    ON CONFLICT (id) DO NOTHING;

-- ==========================
-- 9. Comments
-- ==========================
INSERT INTO comments (id, content, user_id, task_id) VALUES
                                                       (1, 'Looks good!', 1, 1),
                                                       (2, 'I will take this task.', 2, 2),
                                                       (3, 'Bug confirmed.', 3, 3),
                                                       (4, 'UI needs improvements.', 4, 4),
                                                       (5, 'Tests are missing.', 5, 5),
                                                       (6, 'Deployed successfully.', 6, 6),
                                                       (7, 'Client is happy.', 7, 7),
                                                       (8, 'Docs updated.', 8, 8),
                                                       (9, 'Found a security issue.', 9, 9),
                                                       (10, 'Refactoring done.', 10, 10)
    ON CONFLICT (id) DO NOTHING;


-- ==========================
-- 10. Alter sequences
-- ==========================

ALTER SEQUENCE attachments_id_seq RESTART WITH 11;
ALTER SEQUENCE board_member_id_seq RESTART WITH 11;
ALTER SEQUENCE boards_id_seq RESTART WITH 11;
ALTER SEQUENCE comments_id_seq RESTART WITH 11;
ALTER SEQUENCE lists_id_seq RESTART WITH 11;
ALTER SEQUENCE role_id_seq RESTART WITH 11;
ALTER SEQUENCE users_id_seq RESTART WITH 11;
ALTER SEQUENCE task_id_seq RESTART WITH 11;