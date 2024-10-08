INSERT INTO Agency (name_agency, created_at_agency)
VALUES ('Cool Agency Inc', '2024-10-08 10:00:00'),
       ('Even Cooler Agency Inc', '2024-10-08 11:00:00'),
       ('Pablo Agency', '2024-10-08 12:00:00'),
       ('The Best Agency Ever', '2024-10-08 13:00:00'),
       ('Adventure Agency', '2024-10-08 14:00:00');

INSERT INTO Report (title_report, content_report, ocurred_at_report)
VALUES ('Environmental Impact of Tourism', 'A detailed analysis of how tourism affects the local environment.', '2024-10-01 08:30:00'),
       ('City Infrastructure Upgrades', 'The latest updates on city infrastructure improvements.', '2024-10-02 09:45:00'),
       ('Flight Delays in Summer', 'An investigation into flight delays during the summer travel season.', '2024-10-03 10:15:00'),
       ('New Travel Regulations', 'New government travel regulations to be aware of.', '2024-10-04 11:50:00'),
       ('Luxury Travel Trends', 'A look into the latest trends in luxury travel experiences.', '2024-10-05 12:20:00');

INSERT INTO ReportSubmission (id_report, id_agency, created_at_report_submission)
VALUES (1, 1, '2024-10-08 10:30:00'),
       (2, 2, '2024-10-08 11:15:00'),
       (3, 3, '2024-10-08 12:05:00'),
       (4, 4, '2024-10-08 13:40:00'),
       (5, 5, '2024-10-08 14:50:00');