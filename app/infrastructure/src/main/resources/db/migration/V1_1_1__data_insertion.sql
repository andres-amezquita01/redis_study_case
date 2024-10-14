INSERT INTO InvolvementType (id_involvement_type, title_involvement_type, description_involvement_type)
VALUES
	(1, 'Affected', 'The person is directly affected by the news event or story'),
	(2, 'Responsible', 'The person is responsible for causing or influencing the news event'),
	(3, 'Witness', 'The person witnessed the event or has first-hand information about it'),
	(4, 'Contributor', 'The person contributed to the creation or details of the news story'),
	(5, 'Expert', 'The person provided expert opinion or analysis for the news story');

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

INSERT INTO Journalist (name_journalist, address_journalist, phone_journalist)
VALUES
	('Alice Smith', '123 Maple Street, Springfield', '555-1234'),
	('Bob Johnson', '456 Oak Avenue, Greenfield', '555-5678'),
	('Charlie Brown', '789 Pine Road, Riverdale', '555-8765'),
	('Diane Carter', '321 Birch Boulevard, Willowdale', '555-4321'),
	('Eve Davis', '654 Cedar Lane, Elmville', '555-9876');

INSERT INTO ReportCover (id_report_cover, id_journalist, id_report)
VALUES
	(1, 1, 1),
	(2, 2, 2),
	(3, 3, 3),
	(4, 4, 4),
	(5, 5, 5);