DROP TABLE IF EXISTS creature CASCADE;

CREATE TABLE creature(
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    health INT NOT NULL,
    damage INT NOT NULL,
    speed INT NOT NULL,
    notes VARCHAR(760) NOT NULL,
    PRIMARY KEY (id)
    );