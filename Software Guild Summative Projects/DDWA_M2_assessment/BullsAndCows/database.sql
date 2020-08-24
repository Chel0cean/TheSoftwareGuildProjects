
INSERT INTO Game (Answer, Status)
VALUES("1234", 1),
("4321", 1),
("2341", 1);

INSERT INTO Round(Game_id, Guess)
VALUES(1, "1235"),
(1, "2321"),
(1, "4321"),
(2, "2314"),
(2, "2143"),
(3, "5432"),
(3, "6543");