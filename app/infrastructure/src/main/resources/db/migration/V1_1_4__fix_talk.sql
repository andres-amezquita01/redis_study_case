
DROP TABLE Talk;
CREATE TABLE Talk (
                      id_talk INT PRIMARY KEY AUTO_INCREMENT,
                      id_report_cover INT,
                      id_involvement INT,
                      transcription_talk TEXT,
                      FOREIGN KEY (id_report_cover) REFERENCES ReportCover(id_report_cover),
                      FOREIGN KEY (id_involvement) REFERENCES Involvement(id_involvement)
);
INSERT INTO Talk (id_report_cover, id_involvement, transcription_talk)
VALUES
    (1, 1, 'Transcription text for talk 1')

