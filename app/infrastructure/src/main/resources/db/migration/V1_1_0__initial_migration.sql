CREATE TABLE Agency (
    id_agency INT PRIMARY KEY AUTO_INCREMENT,
    name_agency TEXT NOT NULL,
    created_at_agency TIMESTAMP
);

CREATE TABLE Journalist (
    id_journalist INT PRIMARY KEY AUTO_INCREMENT,
    name_journalist TEXT NOT NULL,
    email_journalist TEXT,
    phone_journalist TEXT
);

CREATE TABLE Report (
    id_report INT PRIMARY KEY AUTO_INCREMENT,
    title_report TEXT NOT NULL,
    content_report TEXT,
    ocurred_at_report TIMESTAMP
);

CREATE TABLE ReportCover (
    id_report_cover INT PRIMARY KEY AUTO_INCREMENT,
    id_journalist INT,
    id_report INT,
    FOREIGN KEY (id_report) REFERENCES Report(id_report),
    FOREIGN KEY (id_journalist) REFERENCES Journalist(id_journalist)
);

CREATE TABLE ReportSubmission (
    id_report_submission INT PRIMARY KEY AUTO_INCREMENT,
    id_report INT,
    id_agency INT,
    created_at_report_submission TIMESTAMP,
    FOREIGN KEY (id_report) REFERENCES Report(id_report),
    FOREIGN KEY (id_agency) REFERENCES Agency(id_agency)
);

CREATE TABLE RelatedReport (
    id_report INT,
    id_related_report INT,
    PRIMARY KEY (id_report, id_related_report),
    FOREIGN KEY (id_report) REFERENCES Report(id_report),
    FOREIGN KEY (id_related_report) REFERENCES Report(id_report)
);

CREATE TABLE InvolvementType (
    id_involvement_type INT PRIMARY KEY AUTO_INCREMENT,
    title_involvement_type TEXT NOT NULL,
    description_involvement_type TEXT NOT NULL
);

CREATE TABLE Involved (
    id_involved INT PRIMARY KEY AUTO_INCREMENT,
    name_involved TEXT,
    birth_date_involved TIMESTAMP
);

CREATE TABLE Involvement (
    id_involvement INT PRIMARY KEY AUTO_INCREMENT,
    id_involved INT,
    id_involvement_type INT,
    id_report INT,
    FOREIGN KEY (id_involved) REFERENCES Involved(id_involved),
    FOREIGN KEY (id_involvement_type) REFERENCES InvolvementType(id_involvement_type),
    FOREIGN KEY (id_report) REFERENCES Report(id_report)
);

CREATE TABLE Talk (
    id_report_cover INT,
    id_involvement INT,
    transcription_talk TEXT,
    PRIMARY KEY (id_report_cover , id_involvement),
    FOREIGN KEY (id_report_cover) REFERENCES ReportCover(id_report_cover),
    FOREIGN KEY (id_involvement) REFERENCES Involvement(id_involvement)
);
